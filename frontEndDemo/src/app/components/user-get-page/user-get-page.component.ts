import { Component, OnInit } from '@angular/core';
import {User} from "../../../models/user";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-user-get-page',
  templateUrl: './user-get-page.component.html',
  styleUrls: ['./user-get-page.component.css']
})
export class UserGetPageComponent implements OnInit {
  users: User[];
  searchText: string;
  totalElements: number = 0;
  loading: boolean;


  constructor(private us: UserService, private router: Router) {
  }

  public ngOnInit(): void {
    this.getList({page: "0", size: "10"});
  }

  deleteUser(id) {
    this.us.deleteUser(id).subscribe(res => {
    });
    this.router.navigate(['successful-user-delete', id]);
  }

  private getList(req) {
    this.loading = true;
    this.us.getUsers(req).subscribe(data => {
      this.users = data['content'];
      this.totalElements = data.totalElements;
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
