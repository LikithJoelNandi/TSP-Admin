import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  display:boolean;
  user = {
    userName: '',
    password: ''
  };

  constructor(private router: Router) {
    this.display = false;
   }
  ngOnInit() {
  }

  onSubmit() {
    console.log('userName: ' + this.user.userName);
    this.display = false;
    // this.router.navigateByUrl('sideBar')
  }
}
