import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrderListComponent } from './order-list.component';
import { OrderService } from '../../services/order.service';
import { AuthService } from '../../services/auth.service';

describe('OrderListComponent', () => {
  let component: OrderListComponent;
  let fixture: ComponentFixture<OrderListComponent>;

  beforeEach(async () => {
    const orderSpy = jasmine.createSpyObj('OrderService', [
      'getUserOrders',
      'getAllOrders',
      'getOrderDetails',
      'cancelOrder',
    ]);
    const authSpy = jasmine.createSpyObj('AuthService', [
      'getCurrentUser',
      'isAdmin',
    ]);

    await TestBed.configureTestingModule({
      imports: [OrderListComponent],
      providers: [
        { provide: OrderService, useValue: orderSpy },
        { provide: AuthService, useValue: authSpy },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(OrderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
