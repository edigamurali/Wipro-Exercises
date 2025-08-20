import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exe2NgClass } from './exe2-ng-class';

describe('Exe2NgClass', () => {
  let component: Exe2NgClass;
  let fixture: ComponentFixture<Exe2NgClass>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exe2NgClass]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exe2NgClass);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
