import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AdminProductComponent } from './admin-product.component';
import { ProductService } from '../../services/product.service';

describe('AdminProductComponent', () => {
  let component: AdminProductComponent;
  let fixture: ComponentFixture<AdminProductComponent>;

  beforeEach(async () => {
    const productSpy = jasmine.createSpyObj('ProductService', [
      'getAllProducts',
      'addProduct',
      'updateProduct',
      'deleteProduct',
    ]);

    await TestBed.configureTestingModule({
      imports: [AdminProductComponent],
      providers: [{ provide: ProductService, useValue: productSpy }],
    }).compileComponents();

    fixture = TestBed.createComponent(AdminProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
