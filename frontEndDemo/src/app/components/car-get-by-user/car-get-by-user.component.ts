import { Component, OnInit } from '@angular/core';
import {Car} from "../../../models/car";
import {CarService} from "../../services/car.service";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-car-get-by-user',
  templateUrl: './car-get-by-user.component.html',
  styleUrls: ['./car-get-by-user.component.css']
})
export class CarGetByUserComponent implements OnInit {

  totalElements = 0;
  loading: boolean;
  searchText: string;
  cars: Car[];
  user: any = {};

  constructor(private cs: CarService, private us: UserService,
              private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.us.getUserById(params.id).subscribe(res => {
        this.user = res;
        this.getList({page: "0", size: "10", id: this.user.userId});
      });
    });
  }

  private getList(req) {
    this.loading = true;
    this.cs.getCarsByUserId(req).subscribe(data => {
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

  deleteCar(id) {
    this.cs.deleteCar(id).subscribe(res => {
    });
    this.reloadCurrentRoute()
  }
  reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([currentUrl]);
    });
  }
}
