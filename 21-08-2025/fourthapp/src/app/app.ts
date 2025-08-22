import { Component, signal } from '@angular/core';
import { Vehiclecomp } from './vehiclecomp/vehiclecomp';
@Component({
  selector: 'app-root',
  imports: [Vehiclecomp],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('fourthapp');
}
