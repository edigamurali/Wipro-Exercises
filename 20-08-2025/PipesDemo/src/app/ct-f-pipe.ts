import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ctF',
})
export class CtFPipe implements PipeTransform {
  transform(value: number, ...args: unknown[]): string {
    var fahrenheit = (value * 9) / 5 + 32;
    return fahrenheit + 'F';
  }
}
