

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubscriberData } from '../data/subscriber-data';
import { Offer } from '../_models/Offer';
import { Observable } from 'rxjs';

@Injectable()
export class DataStorageService {

    constructor(private http : HttpClient){}

    enrollSubscriberData(subs : SubscriberData ){
        console.log('Hello World'+ subs);
        return this.http.post("http://localhost:8888/api/v1/enroll/",  
        subs,
        {responseType: 'json'});
    }

    getOfferData(){
        return this.http.post("http://localhost:8888/api/v1/offers/",  
         {responseType: 'json'});
    }

    createSingleOffer(offer :Offer){
        return this.http.post("http://localhost:8888/api/v1/offer/",
         offer,  
         {responseType: 'json'});
    }

    deleteOffer(offer: Offer){
        return this.http.delete("http://localhost:8888/api/v1/offer/"+offer.offerId);
    }


    modifyOffer(offer : Offer){
        return this.http.put("http://localhost:8888/api/v1/offer/",
        offer,
        {responseType : 'json'});
    }
   

}
