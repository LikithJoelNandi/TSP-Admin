import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import { AppRoutingModule,routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { EnrollSubscriberComponent } from './enroll-subscriber/enroll-subscriber.component';
import { DeleteOfferComponent } from './delete-offer/delete-offer.component';
import { CreateOfferComponent } from './create-offer/create-offer.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';
import { HttpClientModule } from '@angular/common/http';
import { DataStorageService } from './shared/data-storage.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalBasic } from './modal.basic';
import { CreateSingleOfferComponent } from './create-single-offer/create-single-offer.component';
import { ModifyOfferComponent } from './modify-offer/modify-offer.component';

 


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    EnrollSubscriberComponent,
    DeleteOfferComponent,
    CreateOfferComponent,
    GenerateReportComponent ,
    NgbdModalBasic,
    CreateSingleOfferComponent,
    ModifyOfferComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule ,
    HttpClientModule,
    NgbModule
  ],
  providers: [DataStorageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
