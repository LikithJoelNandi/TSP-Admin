import { Component, OnInit } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  

  constructor(
    private http : HttpClient
    ) { }

  ngOnInit() {
  }

  getOfferDetails(){
   
  }

}
