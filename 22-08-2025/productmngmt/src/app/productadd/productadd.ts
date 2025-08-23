import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Productservice } from '../productservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-productadd',
  imports: [FormsModule],
  templateUrl: './productadd.html',
  styleUrl: './productadd.css',
})
export class Productadd {
  constructor(private productService: Productservice, private router: Router) {}

  productName: string = '';
  productCategory: string = '';
  productPrice: number = 0;
  productQty: number = 0;

  submit() {
    this.productService
      .addProduct({
        name: this.productName,
        category: this.productCategory,
        price: this.productPrice,
        qty: this.productQty,
      })
      .subscribe(
        (response) => {
          this.productName = '';
          this.productCategory = '';
          this.productPrice = 0;

          this.router.navigate(['/productlist']);
        },
        (error) => {
          console.error('Error adding the product', error);
        }
      );
    return;
  }
}
