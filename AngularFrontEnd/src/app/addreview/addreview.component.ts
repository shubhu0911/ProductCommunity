import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Reviews } from '../model/Reviews';
import { Form } from '@angular/forms';
import { Route, ActivatedRoute, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { Product } from '../model/Product';
@Component({
  selector: 'app-addreview',
  templateUrl: './addreview.component.html',
  styleUrls: ['./addreview.component.css']
})
export class AddreviewComponent implements OnInit {
  selectedValue = 0;
  error = "";
  // product: Array<Product> = []
  product: Product = {
    productName: "",
    productCode: "",
    brand: "",
    userName: "",
    date: "",
    price:""

  }
  stars: number[] = [1, 2, 3, 4, 5];
  review: Reviews = {
    reviewId: "",
    review: "",
    rating: 0,
    userName: "",
    heading: "",
    date: ""
  
  }

  constructor(private dashBoardservice: DashboardService, private registrationService: RegistrationService, private route: ActivatedRoute, private router: Router) { }
  id: any
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('productCode');
    if (this.registrationService.getloginUserName() != null) {
      this.review.userName = this.registrationService.getloginUserName()
    }
    this.getProduct()
  }
  //This method  used to get product
  getProduct() {
    this.dashBoardservice.getProductById(this.id).subscribe((data) => {
      this.product = data;
    }, (error) => {
      console.log(error)
    })
  }

  //This method is used to initialize the value in selectedValue 
  countStar(star: any) {
    this.selectedValue = star;
    console.log('Value of star', star);
  }

  //This method is used to get  reviews from client side and store into  database through api
  getFormData() {

    this.review.rating = this.selectedValue;
    if (this.review.rating == 0) {
      this.error = "Please rate in between 1 and 5!";
    }
    else {
      this.error = "";
      this.dashBoardservice.putReview(this.review, this.id).subscribe((data) => {
        this.router.navigate(["/productList/" + this.id])
      }, (error) => {
        console.log(error)
        this.ngOnInit();
      })


    }
  }

  //This method is used for logout user
  logOutLogin() {
    this.registrationService.logOut();
    location.reload();
  }
}