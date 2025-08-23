import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { Productservice } from '../productservice';
import { OrderResponse } from '../order';

@Component({
  selector: 'app-orderhistorycomp',
  imports: [DatePipe, CommonModule],
  templateUrl: './orderhistorycomp.html',
  styleUrl: './orderhistorycomp.css',
})
export class Orderhistorycomp implements OnInit {
  orders: OrderResponse[] = [];

  constructor(private productService: Productservice) {}

  ngOnInit() {
    this.productService.getOrders().subscribe({
      next: (os) => {
        // Convert backend date array/string into real Date
        this.orders = os.map((o) => {
          if (typeof o.orderDate === 'string') {
            const parts = o.orderDate.split(',').map(Number);
            // parts: [year, month, day, hour, min, sec, nanos]
            if (parts.length >= 3) {
              o.orderDate = new Date(
                parts[0], // year
                parts[1] - 1, // month (0-based)
                parts[2], // day
                parts[3] || 0,
                parts[4] || 0,
                parts[5] || 0,
                Math.floor((parts[6] || 0) / 1000000) // nanos → ms
              );
            }
          }
          return o;
        });
      },
      error: () => alert('Failed to load orders'),
    });
  }
}
