import { Injectable } from '@angular/core';
import { Usuario } from '../_models/usuario';

@Injectable()
export class UsuarioService {

  constructor() { }

  create(): Usuario {
    return {
      login: '',
      password: ''
    };
  }

}
