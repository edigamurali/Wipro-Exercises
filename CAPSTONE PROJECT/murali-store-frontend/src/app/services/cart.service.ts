import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartItem } from '../interfaces/cart.interface';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private apiUrl = 'http://localhost:9191/cart';

  constructor(private http: HttpClient) {}

  addToCart(
    userId: number,
    productId: number,
    quantity: number
  ): Observable<CartItem> {
    return this.http.post<CartItem>(
      `${this.apiUrl}/addProd?userId=${userId}&productId=${productId}&qty=${quantity}`,
      {}
    );
  }

  updateCartItem(itemId: number, quantity: number): Observable<CartItem> {
    return this.http.put<CartItem>(
      `${this.apiUrl}/update/${itemId}?qty=${quantity}`,
      {}
    );
  }

  removeFromCart(itemId: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deleteProd/${itemId}`);
  }

  getCartItems(userId: number): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(`${this.apiUrl}/${userId}`);
  }
}
