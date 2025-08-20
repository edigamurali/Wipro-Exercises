import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tasklist',
  standalone: true,
  imports: [CommonModule], // 👈 Required for *ngFor, *ngIf
  templateUrl: './tasklist.html',
  styleUrls: ['./tasklist.css'],
})
export class TasklistComponent {
  @Input() tasks: any[] = [];
  @Output() deleteTask = new EventEmitter<number>();
}
