import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { LoginRequest } from '../../interfaces/user.interface';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  credentials: LoginRequest = { email: '', password: '' };
  loading = false;
  error = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (!this.credentials.email || !this.credentials.password) {
      this.error = 'Please fill in all fields';
      return;
    }

    this.loading = true;
    this.error = '';

    console.log('Frontend: Attempting login with:', this.credentials.email);

    this.authService.login(this.credentials).subscribe({
      next: (response) => {
        console.log('Frontend: Login response received:', response);
        this.loading = false;

        // Check if response has token
        if (response && response.token) {
          console.log('Frontend: Token found, navigating to products');
          this.router.navigate(['/products']);
        } else {
          console.error('Frontend: No token in response:', response);
          this.error = 'Login failed - no token received';
        }
      },
      error: (err) => {
        console.error('Frontend: Login error:', err);
        console.error('Frontend: Error details:', {
          status: err.status,
          statusText: err.statusText,
          error: err.error,
          message: err.message,
          url: err.url,
        });

        this.loading = false;

        // Enhanced error handling
        if (err.status === 0) {
          this.error =
            'Cannot connect to server. Please check if the backend is running.';
        } else if (err.status === 401) {
          this.error = 'Invalid email or password.';
        } else if (err.status === 403) {
          this.error = 'Access forbidden.';
        } else if (err.error && err.error.message) {
          this.error = err.error.message;
        } else {
          this.error = `Login failed: ${err.statusText || 'Unknown error'}`;
        }
      },
    });
  }
}
