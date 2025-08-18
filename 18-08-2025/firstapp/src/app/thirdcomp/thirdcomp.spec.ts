import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Thirdcomp } from './thirdcomp';

describe('Thirdcomp', () => {
  let component: Thirdcomp;
  let fixture: ComponentFixture<Thirdcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Thirdcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Thirdcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
