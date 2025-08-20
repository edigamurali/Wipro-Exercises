import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-fruit',
  standalone: true,
  templateUrl: './fruit.html',
  styleUrls: ['./fruit.css'],
})
export class FruitComponent {
  @Input() fruit!: IFruit;
  @Output() btnClick = new EventEmitter<string>();
  onClick(name: string) {
    this.btnClick.emit(name);
  }
}
