import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from '../interface/food';
import { LoginService } from './login-service';

@Injectable({
  providedIn: 'root',
})
export class FoodService {
  private baseUrl = 'http://localhost:9191/food';

  constructor(private http: HttpClient, private loginService: LoginService) {}

  getFood(): Observable<Food[]> {
    const token = this.loginService.getToken();
    const headers = new HttpHeaders().set('Authorization', token ? `Bearer ${token}` : '');

    return this.http.get<Food[]>(`${this.baseUrl}`, { headers });
  }
}
