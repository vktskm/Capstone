import { Ispiaggia } from 'src/app/interfaces/Ispiaggia';
import { SpiaggieService } from './../../../service/spiaggie.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-spiaggia',
  templateUrl: './spiaggia.component.html',
  styleUrls: ['./spiaggia.component.scss']
})
export class SpiaggiaComponent {

  // @ViewChild('f') form!: NgForm;
  spiaggia: Ispiaggia ={};
  // prenotazione:Iprenota={};


    constructor(private spSvc:SpiaggieService,  private route:ActivatedRoute, private router:Router) {};

    ngOnInit(): void {
      this.getById();
      // this.getPrenotazioni();
    }

  getById(){
      this.route.params
      .subscribe((params:any)=>{
        this.spSvc.getByIdS(params.id).subscribe(spiaggia => {
          console.log(spiaggia);
          this.spiaggia = spiaggia;
        })
      })
    }


}
