import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  uri = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  addUser(firstName, lastName, email) {
    const obj = {
      firstName,
      lastName,
      email
    };
    return this.http.post(`${this.uri}addUser`, obj);
  }

  getUserById(req) {
    return this.http.get(`${this.uri}getUserById/${req}`);
  }


  getUsers(req) {
    const params = req;
    return this.http.get(`${this.uri}getUsers`, {params});
  }

  deleteUser(id) {
    return this
      .http
      .delete(`${this.uri}deleteUser/${id}`);
  }

}
