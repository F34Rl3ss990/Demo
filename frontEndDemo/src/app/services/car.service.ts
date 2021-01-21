import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  uri = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  addCar(brand, type, mileage, yearOfManufacture, userId) {
    const obj = {
      brand,
      type,
      mileage,
      yearOfManufacture,
      userId
    };
    return this.http.post(`${this.uri}addCar`, obj);
  }

  getCars(req) {
    const params = req;
    return this.http.get(`${this.uri}getCars`, {params});
  }

  getCarsByUserId(req) {
    const params = req;
    return this.http.get(`${this.uri}getCarsByUserId`, {params});
  }

  getCarById(id) {
    return this.http.get(`${this.uri}getCarById/${id}`);
  }


  deleteCar(id) {
    return this
      .http
      .delete(`${this.uri}deleteCar/${id}`);
  }

  modifyCar(brand, type, mileage, yearOfManufacture, carId) {
    const obj = {
      brand,
      type,
      mileage,
      yearOfManufacture,
    }
    this.http.put(`${this.uri}modifyArticle/${carId}`, obj).subscribe(
      res => console.log('Done'));
  }
}
