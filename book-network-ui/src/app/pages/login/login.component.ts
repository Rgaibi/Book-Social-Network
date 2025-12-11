import { Component, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationRequest } from 'src/app/api/models';
import { AuthenticationService } from 'src/app/api/services';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {


  authRequest: AuthenticationRequest = {email: '', password: ''};
  errorMsg: Array<string> = [];

  private router = inject(Router);
  private authService = inject(AuthenticationService)

  register() {

    this.router.navigate(['/register']);
    
  }

  login(form: NgForm) {
    this.errorMsg = [];
    
    
      this.authService.authenticate({ body: this.authRequest })
        .then((response) => {
          //save token;
          this.router.navigate(['/books']);
        })
        .catch((err) => {
          console.log(err);
        })
        

  }
}
                