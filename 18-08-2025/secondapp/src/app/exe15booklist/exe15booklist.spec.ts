import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exe14booklist } from './exe15booklist';

describe('Exe14booklist', () => {
  let component: Exe14booklist;
  let fixture: ComponentFixture<Exe14booklist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exe14booklist],
    }).compileComponents();

    fixture = TestBed.createComponent(Exe14booklist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
