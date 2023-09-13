import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Ispiaggia } from '../interfaces/Ispiaggia';
import { Iprenota } from '../interfaces/Iprenota';

@Injectable({
  providedIn: 'root'
})
export class SpiaggieService {

  constructor(private http: HttpClient , private  userSvc: UserService) {}

  headers = new HttpHeaders();


  getAllS() {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );
    return this.http.get<Ispiaggia[]>('http://localhost:8080/api/spiaggia/set', {
      headers: this.headers
    });
  }

  getByIdS(id:any) {

    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );
    return this.http.get<Ispiaggia>('http://localhost:8080/api/spiaggia/'+ id, {
      headers: this.headers
    });
  }

  addPutS(idP:any,idC:any) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );

    return this.http.put<Iprenota>('http://localhost:8080/api/prenotazione/spiaggia/'+idP+'/'+idC,{},
    {headers: this.headers
    } );
  }

}
