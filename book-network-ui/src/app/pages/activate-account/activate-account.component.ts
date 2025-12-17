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

  onCodeCompleted($event: string) {

  }

  redirectToLogin() {
    this.router.navigate(['/login']);
  }

}
