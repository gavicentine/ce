import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, Resolve} from '@angular/router';
import { Livro } from '../_models/livro';
import { LivroService } from '../_services/livro.service';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of';

@Injectable()
export class LivroDetailResolver implements Resolve<Livro> {

    constructor(private livroService: LivroService
    , private router: Router) {
    }

    resolve(route: ActivatedRouteSnapshot): Observable<Livro> {
        return this.livroService.fetchLivroById(route.params['id']).catch(error => {
            console.log(error);
            this.router.navigate([environment.base_livros_url]);
            return Observable.of(null);
        });
    }
}
