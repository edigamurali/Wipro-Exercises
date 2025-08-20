import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [FormsModule], 
  templateUrl: './task.html',
  styleUrls: ['./task.css'],
})
export class TaskComponent {
  description: string = '';
  category: string = '';
  @Output() addTask = new EventEmitter<{ description: string; category: string }>();

  submitTask() {
    if (this.description && this.category) {
      this.addTask.emit({ description: this.description, category: this.category });
      this.description = '';
      this.category = '';
    }
  }
}
