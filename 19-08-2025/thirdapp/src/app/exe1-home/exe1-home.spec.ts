import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exe1Home } from './exe1-home';

describe('Exe1Home', () => {
  let component: Exe1Home;
  let fixture: ComponentFixture<Exe1Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exe1Home]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exe1Home);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
