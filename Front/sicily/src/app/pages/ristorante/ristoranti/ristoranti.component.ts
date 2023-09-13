import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { Iristorante } from 'src/app/interfaces/Iristorante';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';
import { RistoranteService } from 'src/app/service/ristorante.service';

@Component({
  selector: 'app-ristoranti',
  templateUrl: './ristoranti.component.html',
  styleUrls: ['./ristoranti.component.scss']
})
export class RistorantiComponent {

  @ViewChild('f') form!: NgForm;
ristorante: Iristorante ={};
prenotazione:Iprenota={};


  constructor(private rsSvc:RistoranteService, private prSvc:PrenotazioneService, private route:ActivatedRoute, private router:Router) {};

  ngOnInit(): void {
    this.getById();
    // this.getPrenotazioni();
  }

getById(){
    this.route.params
    .subscribe((params:any)=>{
      this.rsSvc.getByIdR(params.id).subscribe(ristorante => {
        console.log(ristorante);
        this.ristorante = ristorante;
      })
    })
  }

// getPrenotazioni(){
//     this.route.params
//     .subscribe((params:any)=>{
//       this.prSvc.getByIdP(params.id).subscribe(prenotazione => {
//            console.log(prenotazione);
//            this.prenotazione = prenotazione;
//       })
//     })
//   }

}
