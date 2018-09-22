import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Conteudo } from '../_models/conteudo';
import { ConteudoSituacao } from '../_models/conteudoSituacao';
import { ConteudoTipo } from '../_models/conteudoTipo';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { environment } from '../../environments/environment';

@Injectable()
export class ConteudoService {

  private mensagens_url = environment.base_api_url + 'mensagens.json';
  private mensagem_url = environment.base_api_url + 'mensagem.json';
  private conteudo_situacoes_url = environment.base_api_url + 'conteudoSituacoes.json';
  private conteudo_tipos_url = environment.base_api_url + 'conteudoTipos.json';

  constructor(private httpClient: HttpClient) {}

  create(): Conteudo {
    return {
        codigo: null,
        titulo: '',
        descricao: '',
        tipo: {
            codigo: 1,
            nome: 'Mensagem'
        },
        situacao: {
            codigo: 1,
            nome: 'Ativo'
        },
        categorias: [],
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
        livro: {
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
              }]
        },
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

  fetchMensagens(): Observable<Conteudo[]> {
    console.log(this.mensagens_url);
    return this.httpClient.get<Conteudo[]>(this.mensagens_url).catch(this.errorHandler);
  }

  fetchMensagemById(id: number): Observable<Conteudo> {
    console.log(this.mensagens_url);
    return this.httpClient.get<Conteudo>(this.mensagem_url).catch(this.errorHandler);
  }

  fetchConteudoById(id: number): Observable<Conteudo> {
    console.log(this.mensagens_url);
    return this.httpClient.get<Conteudo>(this.mensagem_url).catch(this.errorHandler);
  }

  fetchConteudoSituacoes(): Observable<ConteudoSituacao[]> {
    return this.httpClient.get<ConteudoSituacao[]>(this.conteudo_situacoes_url).catch(this.errorHandler);
  }

  fetchConteudoTipos(): Observable<ConteudoTipo[]> {
    return this.httpClient.get<ConteudoTipo[]>(this.conteudo_tipos_url).catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error.');
  }
}
