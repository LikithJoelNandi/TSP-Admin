import { Component, OnInit } from '@angular/core';
import { getCurrencySymbol } from '@angular/common';

@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.css']
})
export class CreateOfferComponent implements OnInit {
  currencySymbol: any
  constructor() { }

  ngOnInit() {
   this.currencySymbol =  getCurrencySymbol('INR', 'wide');
  }

}
