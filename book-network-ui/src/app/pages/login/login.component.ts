import { Component } from '@angular/core';
import { AuthenticationRequest } from 'src/app/services/models';
import { NgIf, NgForOf } from "../../../../node_modules/@angular/common/index";
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {


  authRequest: AuthenticationRequest = {email: '', password: ''};
  errorMsg: Array<string> = [];

  register() {
  throw new Error('Method not implemented.');
  }

  login(form: NgForm) {
  throw new Error('Method not implemented.');
  }

}
