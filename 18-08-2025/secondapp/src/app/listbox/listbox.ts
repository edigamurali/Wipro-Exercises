import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-listbox',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './listbox.html',
  styleUrls: ['./listbox.css'],
})
export class Listbox {
  searchText: string = '';

  names: string[] = [
    'Jayanta',
    'Jayaram',
    'Kiran',
    'Murali',
    'Ramesh',
    'Suresh',
    'Anil',
    'Pavan',
    'Rajesh',
    'Jayanth',
  ];

  get filteredNames(): string[] {
    return this.names.filter((name) =>
      name.toLowerCase().startsWith(this.searchText.toLowerCase())
    );
  }
}
