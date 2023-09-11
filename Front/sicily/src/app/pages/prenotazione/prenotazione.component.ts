import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.scss']
})
export class PrenotazioneComponent implements OnInit{


    constructor(private svc: AuthService){}

    ngOnInit(): void {

    }

    esci (): void {
      this.svc.logout();
    }

}
