import { Routes } from '@angular/router';
import { FoodOrder } from '../components/food-order/food-order';
import { Login } from '../components/login/login';

export const routes: Routes = [
  { path: '', component: Login },
  { path: 'order', component: FoodOrder },
];
