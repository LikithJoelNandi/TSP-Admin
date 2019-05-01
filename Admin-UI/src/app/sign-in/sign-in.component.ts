import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SigninService } from '../_service/sign-in.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  credentialCheck: Response;

  constructor(
    private formBuilder: FormBuilder,
    private signinService: SigninService
    ) { }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
        userName: [ '', Validators.required ],
        password: [ '', [Validators.required, Validators.minLength(6)] ],
      }); 
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit(value: JSON) {
      this.submitted = true;

      // stop here if form is invalid
      if (this.registerForm.invalid) {
          return;
      }
      this.signinService.checkCredentials(value['userName'], value['password'])
      .subscribe(
        (response :Response) =>{
          this.credentialCheck  = response;
          console.log(response);
        }
      );
      /* alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value)) */
  } 
  
 
}
