import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements  CanActivate {
     constructor(
          private authService: UserService,
          private router: Router) {

     }
     canActivate(
          next: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
               if (this.authService.isAuthenticated()) {
                    return true;
               } else {
                    this.router.navigateByUrl('/login');
                    return false;
               }
          }
}
