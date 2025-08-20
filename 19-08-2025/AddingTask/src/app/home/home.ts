import { Component } from '@angular/core';
import { TaskComponent } from '../task/task';
import { TasklistComponent } from '../tasklist/tasklist';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, TaskComponent, TasklistComponent], // 👈 import children
  templateUrl: './home.html',
  styleUrls: ['./home.css'],
})
export class HomeComponent {
  tasks: { id: number; description: string; category: string }[] = [];
  private idCounter = 1;

  handleAddTask(task: Omit<{ id: number; description: string; category: string }, 'id'>) {
    this.tasks.push({ id: this.idCounter++, ...task });
  }

  handleDeleteTask(id: number) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
  }
}
