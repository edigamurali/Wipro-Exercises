import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exe4ngstyle } from './exe4ngstyle';

describe('Exe4ngstyle', () => {
  let component: Exe4ngstyle;
  let fixture: ComponentFixture<Exe4ngstyle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exe4ngstyle]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exe4ngstyle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
