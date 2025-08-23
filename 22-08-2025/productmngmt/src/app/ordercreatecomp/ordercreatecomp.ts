import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { AsyncPipe, DatePipe } from '@angular/common';
import { CommonModule } from '@angular/common';
import { Productservice } from '../productservice';
import { Product } from '../product';

@Component({
  selector: 'app-ordercreatecomp',
  imports: [FormsModule, CommonModule],
  templateUrl: './ordercreatecomp.html',
  styleUrl: './ordercreatecomp.css',
})
export class Ordercreatecomp implements OnInit {
  products: Product[] = [];
  selectedProductId?: number;
  purchaseQty: number = 1;
  errorMsg: string = '';
  placing = false;

  constructor(private productService: Productservice) {}

  ngOnInit() {
    this.productService.getProducts().subscribe({
      next: (ps) => (this.products = ps),
      error: (e) => (this.errorMsg = 'Failed to load products'),
    });
  }

  get selectedProduct(): Product | undefined {
    return this.products.find((p) => p.id === this.selectedProductId);
  }

  canPlace(): boolean {
    const p = this.selectedProduct;
    return !!p && this.purchaseQty >= 1 && this.purchaseQty <= p.qty;
  }

  placeOrder(f: NgForm) {
    this.errorMsg = '';
    const p = this.selectedProduct;
    if (!p) {
      this.errorMsg = 'Select a product';
      return;
    }
    if (!this.canPlace()) {
      this.errorMsg = 'Invalid quantity';
      return;
    }

    this.placing = true;
    this.productService.placeOrder(p.id!, this.purchaseQty).subscribe({
      next: (res) => {
        // Update local stock right away so max validation updates
        p.qty = p.qty - this.purchaseQty;
        f.resetForm(); // clear form
        this.selectedProductId = undefined;
        this.purchaseQty = 1;
        this.placing = false;
        alert('Order placed!');
      },
      error: (e) => {
        this.placing = false;
        // Show backend message when qty > available
        this.errorMsg = e?.error?.message || 'Failed to place order';
      },
    });
  }
}
