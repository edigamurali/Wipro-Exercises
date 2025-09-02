import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private apiUrl = 'http://localhost:9191/products';
  private baseUrl = 'http://localhost:9191'; // Add base URL for image construction

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${id}`);
  }

  getProductsByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(
      `${this.apiUrl}/search?category=${category}`
    );
  }

  searchProducts(name: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/search?name=${name}`);
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.apiUrl}/${id}`, product);
  }

  deleteProduct(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }

  getUniqueCategories(): Observable<string[]> {
    return new Observable((observer) => {
      this.getAllProducts().subscribe((products) => {
        const categories = [...new Set(products.map((p) => p.category))];
        observer.next(categories);
        observer.complete();
      });
    });
  }

  getImageUrl(imagePath: string | null | undefined): string {
    if (!imagePath) {
      return this.getPlaceholderImage();
    }

    if (imagePath.startsWith('http')) {
      return imagePath;
    }

       return `${this.baseUrl}/images/${imagePath}`;

      }

  getPlaceholderImage(): string {
    return 'https://via.placeholder.com/300x200/e9ecef/6c757d?text=No+Image';
  }

  checkImageUrl(imagePath: string): Observable<boolean> {
    return new Observable((observer) => {
      const img = new Image();
      img.onload = () => {
        observer.next(true);
        observer.complete();
      };
      img.onerror = () => {
        observer.next(false);
        observer.complete();
      };
      img.src = this.getImageUrl(imagePath);
    });
  }
}
