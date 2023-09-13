import { Component, OnInit } from '@angular/core';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { Iristorante } from 'src/app/interfaces/Iristorante';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';
import { RistoranteService } from 'src/app/service/ristorante.service';

@Component({
  selector: 'app-ristorante',
  templateUrl: './ristorante.component.html',
  styleUrls: ['./ristorante.component.scss']
})
export class RistoranteComponent implements OnInit{

  ristoranti : Iristorante[]=[];
  prenotazioni: Iprenota[] = [];

  error: undefined | string;

  constructor(private rsSvc: RistoranteService , private prSvc: PrenotazioneService) { }

  ngOnInit(): void {
    this.getAllR();
    this.getAllP();

  }

  getAllR() {
    this.rsSvc.getAllR().subscribe((data) => {
      this.ristoranti = data;
      console.log(this.ristoranti);
    });
  }

  getAllP(){
    this.prSvc.getAllP().subscribe((data) => {
      this.prenotazioni = data;
      console.log(this.prenotazioni);
    });
  }

  getIdR(id:any) {
    this.rsSvc.getByIdR(id).subscribe((data) => {
     console.log(data); })
  }


  put(idS:any ): void {

    this.rsSvc.addPutR(this.prSvc.prenotazioneInCorso.idPrenotazione,idS).subscribe(resp => {
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
