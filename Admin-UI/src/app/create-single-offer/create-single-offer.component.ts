import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataStorageService } from '../shared/data-storage.service';
import { Offer } from '../_models/Offer';

@Component({
  selector: 'app-create-single-offer',
  templateUrl: './create-single-offer.component.html',
  styleUrls: ['./create-single-offer.component.css']
})
export class CreateSingleOfferComponent implements OnInit {

  private createOfferForm:FormGroup;
  private offer:Offer;
  private submitted =  false;

  constructor(
  private  formBuilder : FormBuilder,
  private dataStorageService : DataStorageService
  ) { 
    this.offer = new Offer();
  }

  ngOnInit() {
   this.createOfferForm = this.formBuilder.group({
    offerName : [ '', Validators.required ],
    validity : [ Number , Validators.required ],
    price : [ Number , Validators.required ],
   });
  }

  onSubmit(value : JSON){

    this.submitted = true;

    // stop here if form is invalid
    if (this.createOfferForm.invalid) {
        return;
    }

    this.offer.offerName = value['offerName'];
    this.offer.validityInDays = value['validity'];
    this.offer.price = value['price'];
    this.dataStorageService.createSingleOffer(this.offer)
    .subscribe(
      (response : Response) => {
        console.log(response);
      }
    )
  }

}
