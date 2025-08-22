import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Vehiclecomp } from './vehiclecomp';

describe('Vehiclecomp', () => {
  let component: Vehiclecomp;
  let fixture: ComponentFixture<Vehiclecomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Vehiclecomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Vehiclecomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
