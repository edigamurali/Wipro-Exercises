import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import { AuthService } from '../../services/auth.service';
import { Product } from '../../interfaces/product.interface';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categories: string[] = [];
  selectedCategory = '';
  searchTerm = '';
  loading = false;
  error = '';
  addingToCart: { [key: number]: boolean } = {};

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.loadCategories();

    // Check if we have a category parameter
    this.route.params.subscribe((params) => {
      if (params['category']) {
        this.selectedCategory = params['category'];
        this.filterByCategory(this.selectedCategory);
      } else {
        this.loadProducts();
      }
    });
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

  loadCategories() {
    this.productService.getUniqueCategories().subscribe({
      next: (categories) => {
        this.categories = categories;
      },
      error: (err) => {
        console.error('Failed to load categories:', err);
      },
    });
  }

  filterByCategory(category: string) {
    this.selectedCategory = category;
    if (category) {
      this.loading = true;
      this.productService.getProductsByCategory(category).subscribe({
        next: (products) => {
          this.products = products;
          this.loading = false;
        },
        error: (err) => {
          this.error = 'Failed to load products';
          this.loading = false;
        },
      });
    } else {
      this.loadProducts();
    }
  }

  searchProducts() {
    if (this.searchTerm.trim()) {
      this.loading = true;
      this.productService.searchProducts(this.searchTerm).subscribe({
        next: (products) => {
          this.products = products;
          this.loading = false;
        },
        error: (err) => {
          this.error = 'Failed to search products';
          this.loading = false;
        },
      });
    } else {
      this.loadProducts();
    }
  }

  addToCart(product: Product) {
    const currentUser = this.authService.getCurrentUser();
    if (!currentUser?.id) {
      this.error = 'Please login to add items to cart';
      return;
    }

    if (!product.id || typeof product.id !== 'number') {
      this.error = 'Invalid product';
      return;
    }

    const productId = product.id;
    this.addingToCart[productId] = true;

    this.cartService.addToCart(currentUser.id, productId, 1).subscribe({
      next: (cartItem) => {
        this.addingToCart[productId] = false;
        console.log('Added to cart successfully');
        alert('Product added to cart successfully!');
      },
      error: (err) => {
        this.addingToCart[productId] = false;
        this.error = err.error?.message || 'Failed to add item to cart';
      },
    });
  }

  clearFilters() {
    this.selectedCategory = '';
    this.searchTerm = '';
    this.loadProducts();
  }

  isAddingToCart(productId: number | undefined): boolean {
    return productId ? this.addingToCart[productId] || false : false;
  }

  // NEW: Method to handle image loading errors
  onImageError(event: any, product: Product) {
    console.log('Image failed to load for product:', product.name);
    // Set a placeholder image
    event.target.src = this.getPlaceholderImage();
  }

  // NEW: Method to get proper image URL using ProductService
  getImageUrl(product: Product): string {
    return this.productService.getImageUrl(product.image);
  }

  // NEW: Method to get placeholder image
  private getPlaceholderImage(): string {
    return this.productService.getPlaceholderImage();
  }
}
