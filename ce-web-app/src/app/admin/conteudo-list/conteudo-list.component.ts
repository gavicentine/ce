import { Component, OnInit } from '@angular/core';
import { ConteudoService } from '../../_services/conteudo.service';
import { ErrorHandlerService } from '../../_services/errorHandler.service';
import { Router } from '@angular/router';
import { Conteudo } from '../../_models/conteudo';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Component({
  selector: 'app-conteudo-list',
  templateUrl: './conteudo-list.component.html',
  styleUrls: ['./conteudo-list.component.css']
})
export class ConteudoListComponent implements OnInit {

  public conteudo: Conteudo;
  public listaConteudo: Conteudo[];

  constructor(private conteudoService: ConteudoService
            , private router: Router
            , private errorHandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.conteudoService.fetchMensagens()
      .subscribe(data => this.listaConteudo = data,
                 error => this.errorHandler.handleError = error
    );
  }

  onSelect(conteudo: Conteudo) {
    this.router.navigate([environment.base_conteudo_url, conteudo.codigo]);
  }

  onCreate() {
    this.conteudo = this.conteudoService.create();
    this.router.navigate([environment.base_conteudo_url + '/0']);
  }

}
