import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { OrderService } from '../../services/order.service';
import { AuthService } from '../../services/auth.service';
import { CartItem } from '../../interfaces/cart.interface';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  loading = false;
  error = '';
  placingOrder = false;
  updatingItems: { [key: number]: boolean } = {};

  constructor(
    private cartService: CartService,
    private orderService: OrderService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadCart();
  }

  loadCart() {
    const currentUser = this.authService.getCurrentUser();
    if (!currentUser?.id) {
      this.error = 'Please login to view cart';
      return;
    }

    this.loading = true;
    this.error = '';

    this.cartService.getCartItems(currentUser.id).subscribe({
      next: (items) => {
        this.cartItems = items;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load cart items';
        this.loading = false;
      },
    });
  }

  updateQuantity(item: CartItem, quantity: number) {
    if (quantity <= 0 || !item.id) return;

    this.updatingItems[item.id] = true;

    this.cartService.updateCartItem(item.id, quantity).subscribe({
      next: (updatedItem) => {
        const index = this.cartItems.findIndex((ci) => ci.id === item.id);
        if (index > -1) {
          this.cartItems[index] = updatedItem;
        }
        this.updatingItems[item.id!] = false;
      },
      error: (err) => {
        this.error = err.error?.message || 'Failed to update quantity';
        this.updatingItems[item.id!] = false;
      },
    });
  }

  removeItem(item: CartItem) {
    if (!item.id) return;

    this.cartService.removeFromCart(item.id).subscribe({
      next: () => {
        this.cartItems = this.cartItems.filter((ci) => ci.id !== item.id);
      },
      error: (err) => {
        this.error = err.error?.message || 'Failed to remove item';
      },
    });
  }

  getTotalAmount(): number {
    return this.cartItems.reduce((total, item) => {
      return total + (item.productPrice || 0) * item.quantity;
    }, 0);
  }

  placeOrder() {
    const currentUser = this.authService.getCurrentUser();
    if (!currentUser?.id) {
      this.error = 'Please login to place order';
      return;
    }

    if (this.cartItems.length === 0) {
      this.error = 'Cart is empty';
      return;
    }

    this.placingOrder = true;
    this.error = '';

    this.orderService.createOrder(currentUser.id).subscribe({
      next: (order) => {
        this.placingOrder = false;
        //alert('Order placed successfully!');
        this.router.navigate(['/orders']);
      },
      error: (err) => {
        this.placingOrder = false;
        this.error = err.error?.message || 'Failed to place order';
      },
    });
  }
}
