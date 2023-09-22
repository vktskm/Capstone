import { Injectable } from '@angular/core';
import { Icity } from '../interfaces/Icity';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from './user.service';
import { Iprenota } from '../interfaces/Iprenota';

@Injectable({
  providedIn: 'root'
})
export class ComuniService {

constructor(private http: HttpClient , private  userSvc: UserService) {}

headers = new HttpHeaders();


getAll() {
  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );
  return this.http.get<Icity[]>('http://localhost:8080/api/city/set', {
    headers: this.headers
  });
}

getByIdC(id:any) {

  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );
  return this.http.get<Icity>('http://localhost:8080/api/city/'+ id, {
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
  return this.http.get<Icity[]>('http://localhost:8080/api/city/findbycity/'+ Object.values(nome), {
    headers: this.headers
  });
}

addPutC(idP:any,idC:any) {
  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.userSvc.getToken()
  );

  return this.http.put<Iprenota>('http://localhost:8080/api/prenotazione/comune/'+idP+'/'+idC,{},
  {headers: this.headers
  } );
}

}


