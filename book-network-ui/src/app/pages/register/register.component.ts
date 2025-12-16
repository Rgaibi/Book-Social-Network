import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegistrationRequest } from 'src/app/api/models';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {email: '', password: '', firstname: '', lastname: ''};
  errorMsg: Array<string> = [];

  login() {

  }

  
  register(_t7: NgForm) {

  }


}
