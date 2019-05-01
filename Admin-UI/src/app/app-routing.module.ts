import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent} from './sign-in/sign-in.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { EnrollSubscriberComponent } from './enroll-subscriber/enroll-subscriber.component';
import { DeleteOfferComponent } from './delete-offer/delete-offer.component';
import { CreateOfferComponent } from './create-offer/create-offer.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';
import { CreateSingleOfferComponent } from './create-single-offer/create-single-offer.component';
import { ModifyOfferComponent } from './modify-offer/modify-offer.component';

const routes: Routes = [
  { path: 'signIn', component: SignInComponent},
  { path: '', redirectTo: 'signIn', pathMatch: 'full'},
  { path: 'sideBar', component: SideBarComponent,
    children: [
      { path: "", redirectTo: 'enroll', pathMatch:'full' },
      { path: "enroll", component: EnrollSubscriberComponent },
      { path: "delete-offer", component: DeleteOfferComponent},
      { path: "create-offer", component: CreateOfferComponent},
      { path: "report", component: GenerateReportComponent},
      { path: "create-single-offer", component: CreateSingleOfferComponent},
      { path: "modifyOffer", component: ModifyOfferComponent},
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ SignInComponent, SideBarComponent, EnrollSubscriberComponent, DeleteOfferComponent, CreateOfferComponent, GenerateReportComponent ];