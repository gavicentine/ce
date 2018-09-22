import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Categoria } from '../_models/categoria';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { environment } from '../../environments/environment';


@Injectable()
export class CategoriaService {

  private categs_url = environment.base_api_url + 'categorias.json';
  private categ_url = environment.base_api_url + 'categoria.json';

  constructor(private http: HttpClient) { }

  create(): Categoria {
    return {
      codigo: null,
      nome: ''
    };
  }

  fetchCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.categs_url).catch(this.errorHandler);
  }

  fetchCategoriaById(id: number): Observable<Categoria> {
    return this.http.get<Categoria[]>(this.categ_url).catch(this.errorHandler);
  }

  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error.');
  }

}
