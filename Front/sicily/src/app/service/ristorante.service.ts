import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Iristorante } from '../interfaces/Iristorante';
import { UserService } from './user.service';
import { Iprenota } from '../interfaces/Iprenota';

@Injectable({
  providedIn: 'root'
})
export class RistoranteService {

  constructor(private http: HttpClient , private  userSvc: UserService) {}

  headers = new HttpHeaders();


  getAllR() {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );
    return this.http.get<Iristorante[]>('http://localhost:8080/api/ristorante/set', {
      headers: this.headers
    });
  }

  getNome(nome: string){

    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );
    console.log(nome);
    console.log(Object.values(nome));
    return this.http.get<Iristorante[]>('http://localhost:8080/api/ristorante/findbyrist/'+ Object.values(nome), {
      headers: this.headers
    });
  }

  getByIdR(id:any) {

    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );
    return this.http.get<Iristorante>('http://localhost:8080/api/ristorante/'+ id, {
      headers: this.headers
    });
  }

  addPutR(idP:any,idR:any) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.userSvc.getToken()
    );

    return this.http.put<Iprenota>('http://localhost:8080/api/prenotazione/ristorante/'+idP+'/'+idR,{},
    {headers: this.headers
    } );
  }

}
