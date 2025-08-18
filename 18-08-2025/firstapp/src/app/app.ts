import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Secondcomp } from './secondcomp/secondcomp';
import { Login } from './login/login';
import { Thirdcomp } from './thirdcomp/thirdcomp';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Secondcomp, Login, Thirdcomp],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
})
export class App {}
