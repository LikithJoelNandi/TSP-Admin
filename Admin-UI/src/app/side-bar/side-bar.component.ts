import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  showEnrollPage:boolean;
  showDeleteOfferPage:boolean;
  showCreateOfferPage:boolean;
  showReportPage:boolean;

  constructor(
  private router : Router
  ) { }

  ngOnInit() {
    this.showEnrollPage = false;
    this.showDeleteOfferPage = false;
    this.showCreateOfferPage = false;
    this.showReportPage = false;
  }

  enrollClicked() {
    console.log('enroll clicked');
    this.showDeleteOfferPage = false;
    this.showCreateOfferPage = false;
    this.showReportPage = false;
    this.showEnrollPage = true;
  }
  deleteOfferClicked(){
    console.log('delete clicked');
    this.showCreateOfferPage = false;
    this.showEnrollPage = false;
    this.showReportPage = false;
    this.showDeleteOfferPage = true;
  }
  createOfferClicked(){
    console.log('create clicked');
    this.showDeleteOfferPage = false;
    this.showEnrollPage = false;
    this.showReportPage = false;
    this.showCreateOfferPage = true;    
  }
  generateReportClicked(){
    console.log('create clicked');
    this.showDeleteOfferPage = false;
    this.showEnrollPage = false;
    this.showCreateOfferPage = false;
    this.showReportPage = true;
  }

  enrollUser(){
    this.router.navigate(['/enroll']);
  }
}
