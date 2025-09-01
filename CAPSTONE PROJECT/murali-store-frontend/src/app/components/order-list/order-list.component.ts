import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrderService } from '../../services/order.service';
import { AuthService } from '../../services/auth.service';
import { Order, OrderDetails } from '../../interfaces/order.interface';

@Component({
  selector: 'app-order-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  orders: Order[] = [];
  selectedOrderDetails: OrderDetails | null = null;
  loading = false;
  error = '';
  loadingDetails = false;

  constructor(
    private orderService: OrderService,
    public authService: AuthService // ✅ made public
  ) {}

  ngOnInit() {
    this.loadOrders();
  }

  loadOrders() {
    const currentUser = this.authService.getCurrentUser();
    if (!currentUser?.id) {
      this.error = 'Please login to view orders';
      return;
    }

    this.loading = true;
    this.error = '';

    if (this.authService.isAdmin()) {
      this.orderService.getAllOrders().subscribe({
        next: (orders) => {
          this.orders = orders;
          this.loading = false;
        },
        error: () => {
          this.error = 'Failed to load orders';
          this.loading = false;
        },
      });
    } else {
      this.orderService.getUserOrders(currentUser.id).subscribe({
        next: (orders) => {
          this.orders = orders;
          this.loading = false;
        },
        error: () => {
          this.error = 'Failed to load orders';
          this.loading = false;
        },
      });
    }
  }

  viewOrderDetails(orderId: number) {
    this.loadingDetails = true;
    this.orderService.getOrderDetails(orderId).subscribe({
      next: (details) => {
        this.selectedOrderDetails = details;
        this.loadingDetails = false;
      },
      error: () => {
        this.error = 'Failed to load order details';
        this.loadingDetails = false;
      },
    });
  }

  cancelOrder(orderId: number) {
    if (confirm('Are you sure you want to cancel this order?')) {
      this.orderService.cancelOrder(orderId).subscribe({
        next: (updatedOrder) => {
          const index = this.orders.findIndex((o) => o.id === orderId);
          if (index > -1) {
            this.orders[index] = updatedOrder;
          }
          if (this.selectedOrderDetails?.order.id === orderId) {
            this.selectedOrderDetails.order = updatedOrder;
          }
        },
        error: (err) => {
          this.error = err.error?.message || 'Failed to cancel order';
        },
      });
    }
  }

  closeDetails() {
    this.selectedOrderDetails = null;
  }

  getStatusBadgeClass(status: string): string {
    switch (status.toUpperCase()) {
      case 'CREATED':
        return 'bg-success';
      case 'CANCELLED':
        return 'bg-danger';
      case 'FAILED':
        return 'bg-warning';
      default:
        return 'bg-secondary';
    }
  }
}
