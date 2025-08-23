import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';

@Component({
  selector: 'app-productdelete',
  imports: [],
  templateUrl: './productdelete.html',
  styleUrl: './productdelete.css',
})
export class Productdelete {
  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: Productservice,
    private router: Router
  ) {}

  id: string | null = null;

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');

    if (this.id) {
      this.productService.deleteProduct(this.id).subscribe(
        (response) => {
          this.router.navigate(['/productlist']);
        },
        (error) => {
          console.error('Error deleting product : ', error);
        }
      );
    }
  }
}
