import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../service/login-service';
import { LoginRequest } from '../../interface/login';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css'],
})
export class Login {
  email: string = '';
  password: string = '';

  constructor(private loginService: LoginService, private router: Router) {}

  login() {
    const request: LoginRequest = {
      email: this.email,
      passWord: this.password,
    };

    this.loginService.login(request).subscribe({
      next: () => {
        this.router.navigate(['/order']);
      },
      error: (err) => {
        console.error('Login failed:', err);
        alert('Invalid credentials!');
      },
    });
  }
}
