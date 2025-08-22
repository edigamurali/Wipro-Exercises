import { Directive } from '@angular/core';
import { ElementRef } from '@angular/core';
@Directive({
  selector: '[appHighlightstrikethru]',
})
export class Highlightstrikethru {
  constructor(private elementRef: ElementRef) {
    this.elementRef.nativeElement.style.backgroundColor = 'yellow';
    this.elementRef.nativeElement.style.textDecoration = 'line-through';
  }
}
