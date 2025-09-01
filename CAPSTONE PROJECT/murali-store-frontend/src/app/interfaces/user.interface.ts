export interface User {
  id?: number;
  name: string;
  email: string;
  password?: string;
  role?: string;
}

export interface LoginRequest {
  email: string;
  password: string;
}

// Backend returns { token: string } based on Token class
export interface AuthResponse {
  token: string;
}

// Alternative interface if backend returns just the token string
export interface TokenResponse {
  token: string;
}
