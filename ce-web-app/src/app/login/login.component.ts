import { Component, OnInit } from '@angular/core';
import { Usuario } from '../_models/usuario';
import { Router } from '@angular/router';
import { UsuarioService } from '../_services/usuario.service';
import { MessageService } from '../_services/message.service';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public usuario: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.usuario = this.usuarioService.create();
  }

  login() {
    console.log('login efetuado');
    this.router.navigate(['..' + environment.base_adm_url]);
  }


}
