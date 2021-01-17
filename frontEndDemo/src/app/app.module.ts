import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserAddComponent } from './components/user-add/user-add.component';
import { CarAddComponent } from './components/car-add/car-add.component';
import { UserModifyComponent } from './components/user-modify/user-modify.component';
import { CarModifyComponent } from './components/car-modify/car-modify.component';
import { UserGetPageComponent } from './components/user-get-page/user-get-page.component';
import { CarGetPageComponent } from './components/car-get-page/car-get-page.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { CarGetByUserComponent } from './components/car-get-by-user/car-get-by-user.component';
import {SlimLoadingBarModule, SlimLoadingBarService} from 'ng2-slim-loading-bar';
import {UserService} from './services/user.service';
import {CarService} from './services/car.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {ReactiveFormsModule} from '@angular/forms';
import {FilterPipe} from "./services/filterPipe.service";

@NgModule({
  declarations: [
    AppComponent,
    UserAddComponent,
    CarAddComponent,
    UserModifyComponent,
    CarModifyComponent,
    UserGetPageComponent,
    CarGetPageComponent,
    HomepageComponent,
    CarGetByUserComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [SlimLoadingBarService, UserService, CarService],
  exports: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
