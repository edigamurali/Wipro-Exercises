import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exe1DisplayList } from './exe1-display-list';

describe('Exe1DisplayList', () => {
  let component: Exe1DisplayList;
  let fixture: ComponentFixture<Exe1DisplayList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exe1DisplayList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exe1DisplayList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
