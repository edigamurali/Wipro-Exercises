import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, tap, catchError, of } from 'rxjs';
import { Router } from '@angular/router';
import { User, LoginRequest, AuthResponse } from '../interfaces/user.interface';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:9191/user';
  private currentUserSubject = new BehaviorSubject<User | null>(null);
  public currentUser$ = this.currentUserSubject.asObservable();

  constructor(private http: HttpClient, private router: Router) {
    // Initialize auth status on service creation
    this.checkAuthStatus();
  }

  register(user: User): Observable<User> {
    console.log('AuthService: Registering user:', user.email);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http
      .post<User>(`${this.apiUrl}/register`, user, { headers })
      .pipe(
        tap((response) =>
          console.log('AuthService: Registration response:', response)
        )
      );
  }

  login(credentials: LoginRequest): Observable<AuthResponse> {
    console.log('AuthService: Login request for:', credentials.email);
    console.log('AuthService: Request URL:', `${this.apiUrl}/login`);
    console.log('AuthService: Request body:', JSON.stringify(credentials));

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Accept: 'application/json',
    });

    return this.http
      .post<AuthResponse>(`${this.apiUrl}/login`, credentials, { headers })
      .pipe(
        tap(
          (response) => {
            console.log('AuthService: Login response:', response);

            // Handle the Token class response from backend
            const token = (response as any).token;

            if (token && typeof token === 'string') {
              console.log('AuthService: Token found, setting auth');
              this.setToken(token);
              this.decodeAndSetUser(token);
            } else {
              console.error('AuthService: No token found in response');
            }
          },
          (error) => {
            console.error('AuthService: Login error:', error);
            console.error('AuthService: Error response body:', error.error);
          }
        )
      );
  }

  logout(): void {
    console.log('AuthService: Logging out');

    // Get token for the logout request
    const token = this.getToken();

    // Clear auth immediately for better UX
    this.clearAuth();

    // Navigate to home page
    this.router.navigate(['/']);

    // Optional: Call server logout for logging/cleanup
    if (token) {
      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      });

      this.http
        .post(`${this.apiUrl}/logout`, {}, { headers })
        .pipe(
          catchError((error) => {
            console.log('AuthService: Server logout failed (ignored):', error);
            return of(null); // Return empty observable to complete the stream
          })
        )
        .subscribe({
          next: () => console.log('AuthService: Server logout successful'),
          error: (error) =>
            console.log('AuthService: Server logout error:', error),
        });
    }
  }

  private setToken(token: string): void {
    console.log('AuthService: Setting token in localStorage');
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  private clearAuth(): void {
    console.log('AuthService: Clearing auth');
    localStorage.removeItem('token');
    this.currentUserSubject.next(null);
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    if (!token) {
      console.log('AuthService: No token found');
      return false;
    }

    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      const isValid = payload.exp > Date.now() / 1000;
      console.log('AuthService: Token valid:', isValid);

      // If token is expired, clear auth
      if (!isValid) {
        this.clearAuth();
      }

      return isValid;
    } catch (error) {
      console.error('AuthService: Error checking token validity:', error);
      this.clearAuth(); // Clear invalid token
      return false;
    }
  }

  getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }

  isAdmin(): boolean {
    const user = this.getCurrentUser();
    const isAdmin = user?.role === 'ROLE_ADMIN';
    console.log('AuthService: User is admin:', isAdmin);
    return isAdmin;
  }

  checkAuthStatus(): void {
    console.log('AuthService: Checking auth status');
    const token = this.getToken();
    if (token && this.isAuthenticated()) {
      this.decodeAndSetUser(token);
    } else {
      // Clear auth if token is invalid or missing
      this.clearAuth();
    }
  }

  private decodeAndSetUser(token: string): void {
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      console.log('AuthService: Decoded token payload:', payload);

      const user: User = {
        id: parseInt(payload.userId),
        name: payload.name,
        email: payload.sub,
        role: payload.roles[0],
      };

      console.log('AuthService: Setting current user:', user);
      this.currentUserSubject.next(user);
    } catch (error) {
      console.error('AuthService: Error decoding token:', error);
      this.clearAuth();
    }
  }
}
