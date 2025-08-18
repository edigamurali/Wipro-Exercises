import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-country',
  imports: [FormsModule],
  templateUrl: './country.html',
  styleUrls: ['./country.css'],
})
export class Country {
  allCountries: string[] = ['INDIA', 'USA', 'JAPAN', 'SREELANKA'];
  countries: string[] = [];
  loadCountries() {
    this.countries = this.allCountries;
  }
  //<!--Exercise 13-->
  color: string = 'GREEN';
}
