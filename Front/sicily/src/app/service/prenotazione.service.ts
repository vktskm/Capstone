import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Iprenota } from '../interfaces/Iprenota';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {

prenotazioneInCorso: Iprenota ={};

headers = new HttpHeaders();

constructor(private userSvc: UserService, private http: HttpClient) { }

// POST METHODS
addPrenota() {
  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );
  console.log(this.userSvc.getId())
  return this.http.post<Iprenota>('http://localhost:8080/api/prenotazione/post/' + this.userSvc.getId(),{},{headers: this.headers} );
}

setPrenota( value: Iprenota){
    this.prenotazioneInCorso = value;
}

getAllP() {
  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );
  return this.http.get<Iprenota[]>('http://localhost:8080/api/prenotazione/set', {
    headers: this.headers
  });
}

getByIdP(id:any) {

  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );
  return this.http.get<Iprenota>('http://localhost:8080/api/prenotazione/'+ id, {
    headers: this.headers
  });
}



}
