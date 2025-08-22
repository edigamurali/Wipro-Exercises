import { Component, signal } from '@angular/core';
import { DatePipe, UpperCasePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CtFPipe } from './ct-f-pipe';
import { Highlightstrikethru } from './highlightstrikethru';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [UpperCasePipe, FormsModule, DatePipe, CtFPipe, Highlightstrikethru],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('PipesDemo');

  textEntered: string = '';
  shortDate = '';
  centigrade: number = 30;
}
