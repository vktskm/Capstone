import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './pages/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { PrenotazioneComponent } from './pages/prenotazione/prenotazione.component';
import { ComuniComponent } from './pages/comuni/comuni.component';
import { RistoranteComponent } from './pages/ristorante/ristorante.component';
import { SpiaggieComponent } from './pages/spiaggie/spiaggie.component';
import { UserComponent } from './pages/user/user.component';
import { ComuneComponent } from './pages/comuni/comune/comune.component';
import { RistorantiComponent } from './pages/ristorante/ristoranti/ristoranti.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    PrenotazioneComponent,
    ComuniComponent,
    RistoranteComponent,
    SpiaggieComponent,
    UserComponent,
    ComuneComponent,
    RistorantiComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
