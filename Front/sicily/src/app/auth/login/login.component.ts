import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild('f') form!: NgForm;
  error: undefined | string;

  // @ViewChild('f') form!: NgForm;: Questa riga di codice utilizza il decoratore @ViewChild per ottenere
  // un riferimento a un elemento del componente DOM. In questo caso, stiamo cercando un elemento con il nome
  // f all'interno del template HTML del componente. form è una variabile che rappresenta questo riferimento.
  // La ! alla fine della dichiarazione indica che questa variabile sarà inizializzata in un secondo momento,
  // ma non in fase di dichiarazione. NgForm è il tipo di dati del riferimento, che indica che ci aspettiamo
  // che form sia un riferimento a un oggetto NgForm. NgForm è comunemente utilizzato in Angular per gestire
  // i moduli dei form.

  // error: undefined | string;: Questa riga di codice dichiara una variabile chiamata error di tipo
  // undefined | string. Questo significa che error può contenere una stringa o essere indefinito (null).
  // È comune utilizzare questo tipo di dichiarazione per variabili che potrebbero essere inizializzate in
  // un secondo momento o che possono avere valori nulli.

  constructor(private authService: AuthService, private router: Router) { }

  // constructor(private authService: AuthService, private router: Router) { }: Questo è il costruttore della
  // classe.  Il costruttore viene eseguito quando viene creato un nuovo oggetto di questa classe. In questo
  // caso, il costruttore accetta due parametri: authService e router. Questi parametri sono oggetti delle
  // classi AuthService e Router e vengono utilizzati per l'iniezione delle dipendenze. Questo è un approccio
  // comune in Angular per ottenere istanze di servizi o altre dipendenze all'interno di un componente.

  ngOnInit(): void {
  }

  // ngOnInit(): void { }: Questa è una funzione del ciclo di vita del componente chiamata ngOnInit. Viene eseguita
  // una volta quando il componente viene inizializzato. In questa implementazione, non contiene alcun codice.
  // Tuttavia, spesso viene utilizzata per inizializzare le proprietà del componente o per eseguire azioni iniziali
  // quando il componente viene creato.

  onSubmit() {
    if( this.form.value.username.trim() !== '' && this.form.value.password.trim() !== '') {
        this.authService.signin(this.form.value).subscribe(
          resp => {
            console.log(resp);
            this.error = undefined;
            this.authService.loggedIn = true;
            localStorage.setItem('user', JSON.stringify(resp));
            this.router.navigate(['/prenotazione'])
          }, err => {
            console.log(err.error.message);
            this.error = err.error.message;
          })
        this.error = undefined;
    } else {
      this.error = 'Field Required';
    }
  }

  // onSubmit() {: Questa è una funzione chiamata onSubmit che viene chiamata quando si verifica un evento
  // di invio del form. In genere, questa funzione gestisce l'invio dei dati del form.

  // if (this.form.value.username.trim() !== '' && this.form.value.password.trim() !== '') {: Qui inizia una
  // dichiarazione condizionale. Stai verificando se entrambi i campi del form (username e password) non sono
  // vuoti dopo la rimozione degli spazi vuoti iniziali e finali utilizzando trim(). In altre parole, stai
  // controllando se entrambi i campi sono stati compilati dall'utente.

  // this.authService.signin(this.form.value).subscribe(: Qui stai chiamando un metodo signin dell'oggetto
  // authService. Questo sembra essere un servizio che gestisce l'autenticazione dell'utente. Stai passando
  // this.form.value come parametro, che rappresenta i dati inseriti nel form.

  // Dentro la funzione subscribe, stai gestendo la risposta (quando l'autenticazione ha successo). Questa parte
  // del codice viene eseguita quando il servizio signin restituisce una risposta. Ecco cosa sta facendo:
  // console.log(resp);: Stai stampando la risposta nella console.
  // this.error = undefined;: Stai cancellando eventuali messaggi di errore precedenti impostando error su undefined.
  // this.authService.loggedIn = true;: Stai impostando una variabile booleana loggedIn nell'oggetto authService
  // su true, il che potrebbe indicare che l'utente è autenticato.
  // localStorage.setItem('userLogin', JSON.stringify(resp));: Stai memorizzando la risposta nel localStorage del
  // browser dopo averla convertita in una stringa JSON. Questo potrebbe essere utilizzato per mantenere l'autenti-
  // cazione tra le sessioni.
  // this.router.navigate(['/users']): Stai reindirizzando l'utente alla pagina '/users' utilizzando il servizio
  // di routing di Angular (router).
}
