import { Component, OnInit } from '@angular/core';
import {Car} from "../../../models/car";
import {CarService} from "../../services/car.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import { Location } from '@angular/common';

@Component({
  selector: 'app-car-modify',
  templateUrl: './car-modify.component.html',
  styleUrls: ['./car-modify.component.css']
})
export class CarModifyComponent implements OnInit {

  angForm: FormGroup;
  carId: number;
  car: any = {};
  date: Date;

  constructor(private fb: FormBuilder, private cs: CarService,
              private router: Router, private route: ActivatedRoute,
              private location: Location) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      brand: ['', Validators.required],
      type: ['', Validators.required],
      mileage: ['', [Validators.required, , Validators.max(999999), ]],
      yearOfManufacture: ['', [Validators.required, Validators.min(1900), Validators.max(this.date.getFullYear())]]
    });
  }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.carId = params.id;
    });
    this.route.params.subscribe(params => {
      this.cs.getCarById(params.id).subscribe(res => {
        this.car = res;
      });
    });

  }

  modifyCar(brand, type, mileage, yearOfManufacture) {
    this.cs.modifyCar(brand, type, mileage, yearOfManufacture, this.carId);
    this.router.navigate(['car-get-page/', this.car.userId]);
  }

  backClicked() {
    this.location.back();
  }

}
