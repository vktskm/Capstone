import { Component } from '@angular/core';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { Ispiaggia } from 'src/app/interfaces/Ispiaggia';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';
import { SpiaggieService } from 'src/app/service/spiaggie.service';

@Component({
  selector: 'app-spiaggie',
  templateUrl: './spiaggie.component.html',
  styleUrls: ['./spiaggie.component.scss']
})
export class SpiaggieComponent {

  spiaggie : Ispiaggia[]=[];
  prenotazioni: Iprenota[] = [];

  error: undefined | string;

  constructor(private spSvc: SpiaggieService , private prSvc: PrenotazioneService) { }

  ngOnInit(): void {
    this.getAllS();
    this.getAllP();

  }

  getAllS() {
    this.spSvc.getAllS().subscribe((data) => {
      this.spiaggie = data;
      console.log(this.spiaggie);
    });
  }

  getAllP(){
    this.prSvc.getAllP().subscribe((data) => {
      this.prenotazioni = data;
      console.log(this.prenotazioni);
    });
  }

  getIdS(id:any) {
    this.spSvc.getByIdS(id).subscribe((data) => {
     console.log(data); })
  }


  put(idS:any ): void {

    this.spSvc.addPutS(this.prSvc.prenotazioneInCorso.idPrenotazione,idS).subscribe(resp => {
      console.log(resp);
      this.error = undefined;
    }, err => {
      console.log(err.error.message);
      this.error = err.error.message;
    });

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



}
