class Vehicle {
  constructor(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  getInfo() {
    return `Vehicle: ${this.make} ${this.model}, Year: ${this.year}`;
  }
}
let vehicle = new Vehicle("SUV", "Nexon", 2023);
console.log(vehicle.getInfo());

class Car extends Vehicle {
  constructor(make, model, year, numDoors) {
    super(make, model, year);
    this.numDoors = numDoors;
  }

  getInfo() {
    return `Car: ${this.make} ${this.model}, Year: ${this.year}, Doors: ${this.numDoors}`;
  }
}

let car = new Car("SUV", "Nexon", 2023, 4);
console.log(car.getInfo());
