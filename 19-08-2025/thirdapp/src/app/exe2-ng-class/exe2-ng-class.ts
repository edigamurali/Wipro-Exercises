import { NgClass } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-exe2-ng-class',
  imports: [NgClass],
  templateUrl: './exe2-ng-class.html',
  styleUrl: './exe2-ng-class.css',
})
export class Exe2NgClass {
  flag1: boolean = true;
  flag2: boolean = true;

  getNgClass() {
    return {
      style1: this.flag1,
      style2: this.flag2,
    };
  }
}
