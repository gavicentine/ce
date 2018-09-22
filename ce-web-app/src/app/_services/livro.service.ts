import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Livro } from '../_models/livro';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { environment } from '../../environments/environment';

@Injectable()
export class LivroService {

  private livros_url = environment.base_api_url + 'livros.json';
  private livro_url = environment.base_api_url + 'livro.json';

  constructor(private http: HttpClient) {}

  create(): Livro {
    return {
      codigo: null,
      titulo: '',
      autores: [{
        codigo: null,
        nome: '',
        situacao: {
          codigo: 1,
          nome: 'Ativo'
        },
        tipo: {
          codigo: 1,
          nome: 'Autor'
        }
      }],
      espirito: {
        codigo: null,
        nome: '',
        situacao: {
          codigo: 1,
          nome: 'Ativo'
        },
        tipo: {
          codigo: 2,
          nome: 'Espirito'
        }
      }
    };
  }

  fetchLivros(): Observable<Livro[]> {
    return this.http.get<Livro[]>(this.livros_url).catch(this.errorHandler);
  }

  fetchLivroById(id: number): Observable<Livro> {
    return this.http.get<Livro[]>(this.livro_url).catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error.');
  }
}
