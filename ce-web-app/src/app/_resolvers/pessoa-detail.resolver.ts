import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, Resolve} from '@angular/router';
import { Pessoa } from '../_models/pessoa';
import { PessoaService } from '../_services/pessoa.service';
import { environment } from '../../environments/environment';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of';

@Injectable()
export class PessoaDetailResolver implements Resolve<Pessoa> {

    constructor(private pessoaService: PessoaService
    , private router: Router) {
    }

    resolve(route: ActivatedRouteSnapshot): Observable<Pessoa> {
        return this.pessoaService.fetchPessoaById(route.params['id']).catch(error => {
            console.log(error);
            this.router.navigate([environment.base_pessoas_url]);
            return Observable.of(null);
        });
    }
}
