import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { PrenotazioneComponent } from './pages/prenotazione/prenotazione.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [

  {
    path: "",
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
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
