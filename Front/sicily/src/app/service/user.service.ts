import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

headers = new HttpHeaders();

constructor(private http: HttpClient) {}

// LOCAL USER METHODS
getToken(): string {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.accessToken);

    return userData.accessToken;
  } else {
    return '';
  }
}

getUsername(): string {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.username);

    return userData.username;
  } else {
    return '';
  }
}
getId(): number {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.userId);

    return userData.userId;
  } else {
    return 0;
  }
}
getName(): string {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.name);

    return userData.name;
  } else {
    return '';
  }
}
getEmail(): string {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.email);

    return userData.email;
  } else {
    return '';
  }
}
getExp(): number {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.exp);
    return userData.exp;
  } else {
    return 0;
  }
}
getCurrency(): string {
  const user = localStorage.getItem('user');
  if (user) {
    const userData = JSON.parse(user);

    console.log(userData.currency);

    return userData.currency;
  } else {
    return '';
  }
}

}
