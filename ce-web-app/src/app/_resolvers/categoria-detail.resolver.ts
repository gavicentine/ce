import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, Resolve} from '@angular/router';
import { Categoria } from '../_models/categoria';
import { CategoriaService } from '../_services/categoria.service';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of';

@Injectable()
export class CategoriaDetailResolver implements Resolve<Categoria> {

    constructor(private categoriaService: CategoriaService
    , private router: Router) {
    }

    resolve(route: ActivatedRouteSnapshot): Observable<Categoria> {
        return this.categoriaService.fetchCategoriaById(route.params['id']).catch(error => {
            console.log(error);
            this.router.navigate([environment.base_categorias_url]);
            return Observable.of(null);
        });
    }
}
