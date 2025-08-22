import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ivehicle } from './ivehicle';

@Injectable({
  providedIn: 'root',
})
export class Vehicleservice {
  private apiUrl = 'http://localhost:3000/vehicle';

  constructor(private http: HttpClient) {}

  getvehicles(): Observable<Ivehicle[]> {
    return this.http.get<Ivehicle[]>(this.apiUrl);
  }

  getVechileById(vehicleId: string): Observable<Ivehicle> {
    return this.http.get<Ivehicle>(`${this.apiUrl}/${vehicleId}`);
  }

  updateVechile(vehicle: Ivehicle): Observable<Ivehicle> {
    return this.http.put<Ivehicle>(`${this.apiUrl}/${vehicle.id}`, vehicle);
  }

  deleteVechile(vehicleId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${vehicleId}`);
  }

  saveVehicle(vehicle: Ivehicle): Observable<Ivehicle> {
    const vehicleSave: Omit<Ivehicle, 'id'> = {
      make: vehicle.make,
      model: vehicle.model,
      fuelType: vehicle.fuelType,
      price: vehicle.price,
    };
    return this.http.post<Ivehicle>(this.apiUrl, vehicleSave);
  }
}
