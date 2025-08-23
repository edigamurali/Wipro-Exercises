import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Productdelete } from './productdelete';

describe('Productdelete', () => {
  let component: Productdelete;
  let fixture: ComponentFixture<Productdelete>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Productdelete]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Productdelete);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
