import { PrenotazioneService } from 'src/app/service/prenotazione.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Icity } from 'src/app/interfaces/Icity';
import { Iprenota } from 'src/app/interfaces/Iprenota';
import { ComuniService } from 'src/app/service/comuni.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-comuni',
  templateUrl: './comuni.component.html',
  styleUrls: ['./comuni.component.scss']
})
export class ComuniComponent implements OnInit {
  comuni : Icity[]=[];
  prenotazioni: Iprenota[] = [];
  comune: Icity ={};
  error: undefined | string;
  @ViewChild('f') form!: NgForm;

  constructor(private comuniSvc: ComuniService , private prSvc: PrenotazioneService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAllP();

  }

  getAll() {
    this.comuniSvc.getAll().subscribe((data) => {
      this.comuni = data;
      console.log(this.comuni);
    });
  }

  getByNome() {
    this.comuniSvc.getNome(this.form.value).subscribe(comuni =>{
      this.comuni = comuni;
      console.log(this.comuni)
      this.form.reset();
    })
}


  getAllP(){
    this.prSvc.getAllP().subscribe((data) => {
      this.prenotazioni = data;
      console.log(this.prenotazioni);
    });
  }

  getIdC(id:any) {
    this.comuniSvc.getByIdC(id).subscribe((data) => {
     console.log(data); })
  }


  put(idC:any ): void {

    this.comuniSvc.addPutC(this.prSvc.prenotazioneInCorso.idPrenotazione,idC).subscribe(resp => {
      console.log(resp);
      this.error = undefined;

      const indiceDaRimuovere = this.comuni.findIndex(elemento => elemento.idCity === idC);
      console.log(indiceDaRimuovere);


    if (indiceDaRimuovere !== -1) {
      this.comuni.splice(indiceDaRimuovere, 1); // Rimuove l'elemento dall'array
    } else {
      console.error(`L'elemento con id ${idC} non è stato trovato nell'array.`);
    }



    // console.log(this.comuni);

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
