import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Product } from '../../interfaces/product.interface';

@Component({
  selector: 'app-admin-product',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-product.component.html',
  styleUrls: ['./admin-product.component.css'],
})
export class AdminProductComponent implements OnInit {
  products: Product[] = [];
  showForm = false;
  editMode = false;
  currentProduct: Product = this.getEmptyProduct();
  loading = false;
  error = '';
  saving = false;

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.loadProducts();
  }

  getEmptyProduct(): Product {
    return {
      name: '',
      description: '',
      price: 0,
      stock: 0,
      category: '',
      image: '',
    };
  }

  loadProducts() {
    this.loading = true;
    this.error = '';

    this.productService.getAllProducts().subscribe({
      next: (products) => {
        this.products = products;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load products';
        this.loading = false;
      },
    });
  }

  showAddForm() {
    this.currentProduct = this.getEmptyProduct();
    this.editMode = false;
    this.showForm = true;
    this.error = '';
  }

  editProduct(product: Product) {
    this.currentProduct = { ...product };
    this.editMode = true;
    this.showForm = true;
    this.error = '';
  }

  cancelForm() {
    this.showForm = false;
    this.currentProduct = this.getEmptyProduct();
    this.error = '';
  }

  saveProduct() {
    if (
      !this.currentProduct.name ||
      !this.currentProduct.description ||
      this.currentProduct.price <= 0 ||
      this.currentProduct.stock < 0
    ) {
      this.error = 'Please fill in all required fields with valid values';
      return;
    }

    this.saving = true;
    this.error = '';

    const operation = this.editMode
      ? this.productService.updateProduct(
          this.currentProduct.id!,
          this.currentProduct
        )
      : this.productService.addProduct(this.currentProduct);

    operation.subscribe({
      next: (product) => {
        this.saving = false;
        this.showForm = false;
        this.loadProducts();

        if (this.editMode) {
          const index = this.products.findIndex((p) => p.id === product.id);
          if (index > -1) {
            this.products[index] = product;
          }
        } else {
          this.products.push(product);
        }
      },
      error: (err) => {
        this.saving = false;
        this.error =
          err.error?.message ||
          `Failed to ${this.editMode ? 'update' : 'add'} product`;
      },
    });
  }

  deleteProduct(product: Product) {
    if (confirm(`Are you sure you want to delete "${product.name}"?`)) {
      this.productService.deleteProduct(product.id!).subscribe({
        next: () => {
          this.products = this.products.filter((p) => p.id !== product.id);
        },
        error: (err) => {
          this.error = err.error?.message || 'Failed to delete product';
        },
      });
    }
  }
}
