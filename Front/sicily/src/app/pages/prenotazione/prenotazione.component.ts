import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { AuthService } from 'src/app/service/auth.service';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.scss']
})
export class PrenotazioneComponent implements OnInit{

    constructor(private autSvc: AuthService , private prSvc: PrenotazioneService , private userSvc: UserService, private router:Router){}

    prenotazioni: Iprenota[] = [];
    prenotPagate: Iprenota[] = [];
    prenotNonPagate: Iprenota[] = [];

    error: undefined | string;

    ngOnInit(): void {
      this.getAll();
    }

    esci (): void {
      this.autSvc.logout();
    }

    getAll() : void {
      this.prSvc.getAllP().subscribe((data) => {
        this.prenotazioni = data;
        this.checkPagate();

        console.log(this.prenotazioni);
      });

    }

    checkPagate() : void {

      this.prenotPagate = [];
      this.prenotNonPagate = [];
      for (let i = 0; i < this.prenotazioni.length; i++)
         {
             if (this.prenotazioni[i].pagata == true)
                {
                  this.prenotPagate.push(this.prenotazioni[i]);
                }
             else{
                 this.prenotNonPagate.push(this.prenotazioni[i]);
             }

         }
    }



    getIdP(id:any) {
        this.prSvc.getByIdP(id).subscribe((data) => {
         console.log(data); })
    }

    prenota(): void {

      this.prSvc.addPrenota().subscribe(resp => {
        // console.log(resp);
        this.prSvc.setPrenota( resp );
        this.error = undefined;
      }, err => {
        // console.log(err.error.message);
        this.error = err.error.message;
      });

    }

    getIdUser():number{

      return this.userSvc.getId();
    }

    setP( value:Iprenota ){
      this.prSvc.setPrenota( value );
  }

    prenotPag(id:any){
      this.prSvc.prenotazionePagata(id).subscribe(resp => {
         console.log(resp);
         this.getAll();
        this.error = undefined;
      }, err => {
         console.log(err.error.message);
        this.error = err.error.message;

      });

    }

    deleteP(id:any){
      this.prSvc.eliminaIdP(id).subscribe(resp => {
        // console.log(resp);

        this.error = undefined;
      }, err => {
        // console.log(err.error.message);
        this.error = err.error.message;
        this.getAll();
      });

}

}
