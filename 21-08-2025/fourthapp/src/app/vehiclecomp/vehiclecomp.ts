import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Ivehicle } from '../ivehicle';

@Component({
  selector: 'app-vehiclecomp',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vehiclecomp.html',
})
export class Vehiclecomp {
  vehicles: Ivehicle[] = [
    { id: '1', make: 'Toyota', model: 'Corolla', fuelType: 'Petrol', price: 15000 },
    { id: '2', make: 'Honda', model: 'Civic', fuelType: 'Diesel', price: 18000 },
  ];

  vehicleEdit: Ivehicle = { id: '', make: '', model: '', fuelType: '', price: 0 };
  vehicleAdd: Ivehicle = { id: '', make: '', model: '', fuelType: '', price: 0 };

  edit(id: string) {
    const found = this.vehicles.find((v) => v.id === id);
    if (found) {
      this.vehicleEdit = { ...found };
    }
  }

  update() {
    const index = this.vehicles.findIndex((v) => v.id === this.vehicleEdit.id);
    if (index !== -1) {
      this.vehicles[index] = { ...this.vehicleEdit };
      this.vehicleEdit = { id: '', make: '', model: '', fuelType: '', price: 0 };
    }
  }

  delete(id: string) {
    this.vehicles = this.vehicles.filter((v) => v.id !== id);
  }

  save() {
    const newVehicle: Ivehicle = {
      ...this.vehicleAdd,
      id: Date.now().toString(),
    };
    this.vehicles.push(newVehicle);
    this.vehicleAdd = { id: '', make: '', model: '', fuelType: '', price: 0 };
  }
}
