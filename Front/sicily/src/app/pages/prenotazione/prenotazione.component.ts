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
    prenotPagate: Iprenota[]= [];
    prenotNonPagate: Iprenota[]= [];

    error: undefined | string;

    ngOnInit(): void {
      this.getAll();
    }

    esci (): void {
      // for (let i = 0; i < this.prenotazioni.length; i++)
      //  {
      //    console.log(this.prenotazioni[i]);
      //    this.deleteP(this.prenotazioni?.[i].idPrenotazione);
      //  }
      //questa istruzioni mi distrugge tutte le prenotazioni
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

            if (this.prenotazioni[i].pagata == false && this.prenotazioni[i].utente == this.userSvc.getId())
                {
                  this.prenotNonPagate.push(this.prenotazioni[i]);

                }
             else if (this.prenotazioni[i].pagata == true && this.prenotazioni[i].utente == this.userSvc.getId())
             {
                 this.prenotPagate.push(this.prenotazioni[i]);

             }
         console.log("================Pagate================");
         console.log(this.prenotPagate);
         console.log("================NON Pagate================");
         console.log(this.prenotNonPagate);
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
