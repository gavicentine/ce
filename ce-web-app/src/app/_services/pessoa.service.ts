import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Pessoa } from '../_models/pessoa';
import { PessoaTipo } from '../_models/pessoaTipo';
import { PessoaSituacao } from '../_models/pessoaSituacao';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
// import 'rxjs/add/observable/throw';
import { environment } from '../../environments/environment';

@Injectable()
export class PessoaService {

  private pessoa_url = environment.base_api_url + 'pessoa.json';
  private pessoas_url = environment.base_api_url + 'pessoas.json';
  private pessoa_situacoes_url = environment.base_api_url + 'pessoaSituacoes.json';
  private pessoa_tipos_url = environment.base_api_url + 'pessoaTipos.json';

  constructor(private httpClient: HttpClient) {}

  create(): Pessoa {
    return {
      codigo: null,
      nome: '',
      situacao: {
        codigo: 1, nome: 'Ativo'
      },
      tipo: {
        codigo: 1, nome: 'Autor'
      }
    };
  }

  fetchPessoas(): Observable<Pessoa[]> {
    return this.httpClient.get<Pessoa[]>(this.pessoas_url).catch(this.errorHandler);
  }

  fetchPessoaById(id: number): Observable<Pessoa[]> {
    return this.httpClient.get<Pessoa[]>(this.pessoa_url).catch(this.errorHandler);
  }

  fetchPessoaSituacoes(): Observable<PessoaSituacao[]> {
    return this.httpClient.get<PessoaSituacao[]>(this.pessoa_situacoes_url).catch(this.errorHandler);
  }

  fetchPessoaTipos(): Observable<PessoaTipo[]> {
    return this.httpClient.get<PessoaTipo[]>(this.pessoa_tipos_url).catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error.');
  }
}
