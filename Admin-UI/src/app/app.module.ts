import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";

import { AppRoutingModule,routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { EnrollSubscriberComponent } from './enroll-subscriber/enroll-subscriber.component';
import { DeleteOfferComponent } from './delete-offer/delete-offer.component';
import { CreateOfferComponent } from './create-offer/create-offer.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    EnrollSubscriberComponent,
    DeleteOfferComponent,
    CreateOfferComponent,
    GenerateReportComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
