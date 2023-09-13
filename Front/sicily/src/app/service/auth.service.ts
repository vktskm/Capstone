import { Injectable } from '@angular/core';
import { Isignin } from '../interfaces/Isignin';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, map, tap } from 'rxjs';
import { Isignup } from '../interfaces/Isignup';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn: boolean = false;
  // headers = new HttpHeaders();

  jwtHelper: JwtHelperService = new JwtHelperService();
  private authSubject = new BehaviorSubject<null | Object>(null);

  user$ = this.authSubject.asObservable();
  isLoggedIn$ = this.user$.pipe(map((data: any) => Boolean(data)));

  constructor(private http: HttpClient , private router: Router) {

  }

  logout() {
    this.authSubject.next(null);
    localStorage.removeItem('user');
    console.log('Utente Sloggato');
    this.router.navigate(['']);
  }

  restoreUser() {
    const userJson = localStorage.getItem('user');
    if (!userJson) {
      return;
    }
    const user = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(user.accessToken)) {
      console.log(user.accessToken);
      this.router.navigate(['']);
      localStorage.clear();
      return;
    } else {
      this.authSubject.next(user);
      this.router.navigate(['/prenotazione']);
      return;
    }
  }


  signup(user: Isignup) {
    console.log(user);
    return this.http.post('http://localhost:8080/api/auth/register', user);
  }

  signin(user: Isignin) {
    console.log(user);
    return this.http.post('http://localhost:8080/api/auth/login', user)
    .pipe(tap((data: any) => this.authSubject.next(data)));
  }

}
