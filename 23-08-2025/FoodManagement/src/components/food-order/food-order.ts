import { Component, OnInit } from '@angular/core';
import { FoodService } from '../../service/food-service';
import { Food } from '../../interface/food';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-food-order',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './food-order.html',
  styleUrls: ['./food-order.css'],
})
export class FoodOrder implements OnInit {
  foods: Food[] = [];

  constructor(private foodService: FoodService) {}

  ngOnInit() {
    this.foodService.getFood().subscribe({
      next: (data: Food[]) => {
        this.foods = data;
      },

      error: (err) => {
        console.error('Error fetching Foods:', err);
      },
    });
    console.log(this.foods);
  }
}
