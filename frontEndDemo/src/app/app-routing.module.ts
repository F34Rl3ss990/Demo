import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CarAddComponent} from './components/car-add/car-add.component';
import {CarGetByUserComponent} from './components/car-get-by-user/car-get-by-user.component';
import {CarGetPageComponent} from './components/car-get-page/car-get-page.component';
import {CarModifyComponent} from './components/car-modify/car-modify.component';
import {HomepageComponent} from './components/homepage/homepage.component';
import {UserAddComponent} from './components/user-add/user-add.component';
import {UserGetPageComponent} from './components/user-get-page/user-get-page.component';

const routes: Routes = [
  {path: 'car-add', component: CarAddComponent},
  {path: 'car-get-by-user/:id', component: CarGetByUserComponent},
  {path: 'car-get', component: CarGetPageComponent},
  {path: 'car-modify/:id', component: CarModifyComponent},
  {path: '', component: HomepageComponent},
  {path: 'user-add', component: UserAddComponent},
  {path: 'user-page', component: UserGetPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
