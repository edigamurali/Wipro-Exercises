import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCompt } from './list-compt';

describe('ListCompt', () => {
  let component: ListCompt;
  let fixture: ComponentFixture<ListCompt>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListCompt]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCompt);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
