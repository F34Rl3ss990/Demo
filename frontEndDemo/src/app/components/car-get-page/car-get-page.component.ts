import { Component, OnInit } from '@angular/core';
import {Car} from "../../../models/car";
import {CarService} from "../../services/car.service";
import {PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-car-get-page',
  templateUrl: './car-get-page.component.html',
  styleUrls: ['./car-get-page.component.css']
})
export class CarGetPageComponent implements OnInit {

  totalElements: number = 0;
  loading: boolean;
  searchText: string;
  cars: Car[];

  constructor(private cs: CarService) {
  }

  ngOnInit(): void {
    this.getList({page: "0", size: "10"});

  }

  private getList(req) {
    this.loading = true;
    this.cs.getCars(req).subscribe(data => {
      this.cars = data['content'];
      this.totalElements = data['totalElements'];
      this.loading = false;
    }, error => {
      this.loading = false;
    });
  }

  nextPage(event: PageEvent) {
    const req = {};
    req['page'] = event.pageIndex.toString();
    req['size'] = event.pageSize.toString();
    this.getList(req);
  }
}
