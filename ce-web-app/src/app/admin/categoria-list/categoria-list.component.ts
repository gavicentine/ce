import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../../_services/categoria.service';
import { ErrorHandlerService } from '../../_services/errorHandler.service';
import { Router } from '@angular/router';
import { Categoria } from '../../_models/categoria';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.css']
})
export class CategoriaListComponent implements OnInit {

  public categoria: Categoria;
  public categorias: Categoria[];

  rows = [
    { name: 'Austin', gender: 'Male', company: 'Swimlane' },
    { name: 'Dany', gender: 'Male', company: 'KFC' },
    { name: 'Molly', gender: 'Female', company: 'Burger King' },
  ];
  columns = [
    { prop: 'name' },
    { name: 'Gender' },
    { name: 'Company' }
  ];

  constructor(private categoriaService: CategoriaService
            , private router: Router
            , private errorHandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.categoriaService.fetchCategorias()
      .subscribe(data => this.categorias = data,
                 error => this.errorHandler.handleError = error
    );
  }

  onSelect(categoria: Categoria) {
    this.router.navigate([environment.base_categorias_url, categoria.codigo]);
  }

  onCreate() {
    this.categoria = this.categoriaService.create();
    this.router.navigate([environment.base_categorias_url + '/0']);
  }

  // fromChild(event) {
    // console.log("categoria-list fromChild "+event);
    // this.categoria = null;
  // }

}
