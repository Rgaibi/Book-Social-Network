import { Component, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationRequest } from 'src/app/api/models';
import { AuthenticationService } from 'src/app/api/services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {email: '', password: '', firstname: '', lastname: ''};
  errorMsg: Array<string> = [];

  private router = inject(Router);
  private authService = inject(AuthenticationService)

  login() {
    this.router.navigate(['/login']);
  }


  register(form: NgForm) {
    this.errorMsg = [];

    this.authService.register({ body: this.registerRequest }).subscribe({
        next: () => {
          this.router.navigate(['/activate-account']);
        },
        error: (err) => {
          this.errorMsg = err.error.validationErrors;
        }
    })

  }


}
