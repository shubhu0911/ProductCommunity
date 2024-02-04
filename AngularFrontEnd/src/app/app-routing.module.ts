import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddreviewComponent } from './addreview/addreview.component';
import { AuthenticationGuard } from './authentication.guard';
import { CheckPincodeComponent } from './check-pincode/check-pincode.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { RegistrationComponent } from './registration/registration.component';
import { ReviewlistComponent } from './reviewlist/reviewlist.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"registration",component:RegistrationComponent},
  {path:"dashboard",component:DashboardComponent,canActivate:[AuthenticationGuard]},
  {path:"home",component:HomeComponent},
  {path:"productList/:productSearch",component:ProductlistComponent,canActivate:[AuthenticationGuard]},
  {path:"viewList/:productCode",component:ReviewlistComponent,canActivate:[AuthenticationGuard]},
  {path:"addReview/:productCode",component:AddreviewComponent,canActivate:[AuthenticationGuard]},
  {path:"checkpin/:pincode",component:CheckPincodeComponent,canActivate:[AuthenticationGuard]},
  {path:"",redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


