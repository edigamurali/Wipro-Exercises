import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { OrderResponse } from './order';

@Injectable({
  providedIn: 'root',
})
export class Productservice {
  constructor(private http: HttpClient) {}

  getProducts(): Observable<Product[]> {
    // const url: string = `http://localhost:3000/products`;
    const url: string = `http://localhost:9000/product`;
    return this.http.get<Product[]>(url);
  }

  addProduct(product: Product): Observable<Product> {
    // const url: string = `http://localhost:3000/products`;
    const url: string = `http://localhost:9000/product`;
    return this.http.post<Product>(url, product);
  }

  deleteProduct(id: string | number): Observable<void> {
    // const url: string = `http://localhost:3000/products/${id}`;
    const url: string = `http://localhost:9000/product/${id}`;
    return this.http.delete<void>(url);
  }

  findProduct(id: string | number): Observable<Product> {
    // const url: string = `http://localhost:3000/products/${id}`;
    const url: string = `http://localhost:9000/product/${id}`;
    return this.http.get<Product>(url);
  }

  saveProduct(product: Product): Observable<Product> {
    // const url: string = `http://localhost:3000/products/${product.id}`;
    const url: string = `http://localhost:9000/product/${product.id}`;
    return this.http.put<Product>(url, product);
  }

  placeOrder(productId: number, qty: number): Observable<OrderResponse> {
    return this.http.post<OrderResponse>(`http://localhost:9000/orders`, { productId, qty });
  }

  getOrders(): Observable<OrderResponse[]> {
    return this.http.get<OrderResponse[]>(`http://localhost:9000/orders`);
  }
}
