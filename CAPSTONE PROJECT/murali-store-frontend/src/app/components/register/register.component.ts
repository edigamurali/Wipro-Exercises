import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { User } from '../../interfaces/user.interface';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  user: User = { name: '', email: '', password: '' };
  confirmPassword = '';
  loading = false;
  error = '';
  success = false;

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (!this.user.name || !this.user.email || !this.user.password) {
      this.error = 'Please fill in all fields';
      return;
    }

    if (this.user.password !== this.confirmPassword) {
      this.error = 'Passwords do not match';
      return;
    }

    if (this.user.password.length < 6) {
      this.error = 'Password must be at least 6 characters long';
      return;
    }

    this.loading = true;
    this.error = '';

    this.authService.register(this.user).subscribe({
      next: (response) => {
        this.loading = false;
        this.success = true;
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 2000);
      },
      error: (err) => {
        this.loading = false;
        this.error =
          err.error?.message || 'Registration failed. Please try again.';
      },
    });
  }
}
