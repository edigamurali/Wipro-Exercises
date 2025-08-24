import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodOrder } from './food-order';

describe('FoodOrder', () => {
  let component: FoodOrder;
  let fixture: ComponentFixture<FoodOrder>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FoodOrder]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoodOrder);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
