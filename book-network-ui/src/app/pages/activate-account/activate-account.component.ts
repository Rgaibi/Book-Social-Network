import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/api/services/authentication.service';

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  styleUrls: ['./activate-account.component.scss']
})
export class ActivateAccountComponent {



  message: string = "";
  isOk: boolean = true;
  submitted: boolean = false;

  private router = inject(Router);
  private authService = inject(AuthenticationService);

  confirmAccount(token: string) {
    this.authService.confirm({ token: token }).subscribe({
      next: () => {
        this.message = 'your account has been successfully activated. You can now log in.';
        this.submitted = true;
      },
      error: (err) => {
        this.message = 'Token is invalid or expired.';
        this.submitted = false;
        this.isOk = false;
      }

    })
  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }
  

  redirectToLogin() {
    this.router.navigate(['/login']);
  }

}
