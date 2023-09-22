import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { PrenotazioneComponent } from './pages/prenotazione/prenotazione.component';
import { AuthGuard } from './auth/auth.guard';
import { ComuniComponent } from './pages/comuni/comuni.component';
import { SpiaggieComponent } from './pages/spiaggie/spiaggie.component';
import { RistoranteComponent } from './pages/ristorante/ristorante.component';
import { UserComponent } from './pages/user/user.component';
import { ComuneComponent } from './pages/comuni/comune/comune.component';
import { RistorantiComponent } from './pages/ristorante/ristoranti/ristoranti.component';
import { SpiaggiaComponent } from './pages/spiaggie/spiaggia/spiaggia.component';
import { AboutComponent } from './pages/about/about.component';
import { CondizioniComponent } from './pages/condizioni/condizioni.component';

const routes: Routes = [

  {
    path: "",
    pathMatch: "full",
    component: HomeComponent,
  },

  { path: "login",
    component: LoginComponent,
  },
  {
    path: "register",
    component: RegisterComponent,
  },
  {
    path: "prenotazione",
    component: PrenotazioneComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "comuni",
    component: ComuniComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "comune/:id",
    component: ComuneComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "spiaggie",
    component: SpiaggieComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "spiaggia/:id",
    component: SpiaggiaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "ristorante",
    component: RistoranteComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "ristoranti/:id",
    component: RistorantiComponent,
    canActivate: [AuthGuard]
  },

  {
    path: "user",
    component: UserComponent,
    canActivate: [AuthGuard]
  },

  {
    path: "about",
    component: AboutComponent,
    canActivate: [AuthGuard]
  },

  {
    path: "condizioni",
    component: CondizioniComponent,
    canActivate: [AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
