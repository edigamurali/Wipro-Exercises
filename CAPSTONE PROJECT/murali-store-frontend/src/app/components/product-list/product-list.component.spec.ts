import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductListComponent } from './product-list.component';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

describe('ProductListComponent', () => {
  let component: ProductListComponent;
  let fixture: ComponentFixture<ProductListComponent>;

  beforeEach(async () => {
    const productSpy = jasmine.createSpyObj('ProductService', [
      'getAllProducts',
      'getUniqueCategories',
    ]);
    const cartSpy = jasmine.createSpyObj('CartService', ['addToCart']);
    const authSpy = jasmine.createSpyObj('AuthService', ['getCurrentUser']);
    const routeSpy = { params: of({}) };

    await TestBed.configureTestingModule({
      imports: [ProductListComponent],
      providers: [
        { provide: ProductService, useValue: productSpy },
        { provide: CartService, useValue: cartSpy },
        { provide: AuthService, useValue: authSpy },
        { provide: ActivatedRoute, useValue: routeSpy },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(ProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
