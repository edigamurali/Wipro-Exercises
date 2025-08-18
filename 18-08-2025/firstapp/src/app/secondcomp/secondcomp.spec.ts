import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Secondcomp } from './secondcomp';

describe('Secondcomp', () => {
  let component: Secondcomp;
  let fixture: ComponentFixture<Secondcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Secondcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Secondcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
