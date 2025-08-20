import { NgStyle } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-exe4ngstyle',
  imports: [NgStyle],
  templateUrl: './exe4ngstyle.html',
  styleUrl: './exe4ngstyle.css',
})
export class Exe4ngstyle {
  flag: boolean = false;
}
