import { Component, OnInit } from '@angular/core';
import { Iuser } from 'src/app/interfaces/Iuser';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  user: Iuser = {};

  constructor(private athsvc:AuthService, private userSvc:UserService){}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    this.user.id = this.userSvc.getId();
    this.user.username = this.userSvc.getUsername();
    this.user.nome = this.userSvc.getName();
    this.user.email = this.userSvc.getEmail();
  }

}
