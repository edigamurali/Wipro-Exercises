import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order, OrderDetails } from '../interfaces/order.interface';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private apiUrl = 'http://localhost:9191/order';

  constructor(private http: HttpClient) {}

  createOrder(userId: number): Observable<Order> {
    return this.http.post<Order>(`${this.apiUrl}?userId=${userId}`, {});
  }

  cancelOrder(orderId: number): Observable<Order> {
    return this.http.put<Order>(`${this.apiUrl}/${orderId}`, {});
  }

  getUserOrders(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiUrl}/user/${userId}`);
  }

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.apiUrl);
  }

  getOrderDetails(orderId: number): Observable<OrderDetails> {
    return this.http.get<OrderDetails>(`${this.apiUrl}/${orderId}/items`);
  }
}
