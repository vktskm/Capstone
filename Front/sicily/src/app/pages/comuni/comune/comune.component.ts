import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Icity } from 'src/app/interfaces/Icity';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { ComuniService } from 'src/app/service/comuni.service';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';

@Component({
  selector: 'app-comune',
  templateUrl: './comune.component.html',
  styleUrls: ['./comune.component.scss']
})
export class ComuneComponent implements OnInit {

@ViewChild('f') form!: NgForm;
comune: Icity ={};
prenotazione:Iprenota={};


  constructor(private comSvc:ComuniService, private prSvc:PrenotazioneService, private route:ActivatedRoute, private router:Router) {};

  ngOnInit(): void {
    this.getById();
    // this.getPrenotazioni();
  }

getById(){
    this.route.params
    .subscribe((params:any)=>{
      this.comSvc.getByIdC(params.id).subscribe(comune => {
        console.log(comune);
        this.comune = comune;
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
