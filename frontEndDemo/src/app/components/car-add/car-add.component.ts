import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CarService} from '../../services/car.service';
import {ActivatedRoute, Router} from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrls: ['./car-add.component.css']
})
export class CarAddComponent implements OnInit {

  angForm: FormGroup;
  userId: number;
  date: Date = new Date();

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
      this.userId = params.id;
    });
  }

  addCar(brand, type, mileage, yearOfManufacture) {
    this.cs.addCar(brand, type, mileage, yearOfManufacture, this.userId).subscribe(res => {
      this.router.navigate(['car-get-page']);
    });
  }

  backClicked() {
    this.location.back();
  }
}
