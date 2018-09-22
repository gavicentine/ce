import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, Resolve} from '@angular/router';
import { Conteudo } from '../_models/conteudo';
import { ConteudoService } from '../_services/conteudo.service';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of';

@Injectable()
export class ConteudoDetailResolver implements Resolve<Conteudo> {

    constructor(private conteudoService: ConteudoService
    , private router: Router) {
    }

    resolve(route: ActivatedRouteSnapshot): Observable<Conteudo> {
        return this.conteudoService.fetchConteudoById(route.params['id']).catch(error => {
            console.log(error);
            this.router.navigate([environment.base_conteudo_url]);
            return Observable.of(null);
        });
    }
}
