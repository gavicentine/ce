import { Component, OnInit, Input } from '@angular/core';
import { Conteudo } from '../_models/conteudo';
import { ConteudoService } from '../_services/conteudo.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ErrorHandlerService } from '../_services/errorHandler.service';

@Component({
  selector: 'app-pesquisa-list',
  templateUrl: './pesquisa-list.component.html',
  styleUrls: ['./pesquisa-list.component.css']
})
export class PesquisaListComponent implements OnInit {

  @Input() filterValues: string;
  public listaConteudo: Conteudo[];

  constructor(
      private conteudoService: ConteudoService
    , private router: Router
    , private activatedRoute: ActivatedRoute
    , private errorHandler: ErrorHandlerService) {
  }

  ngOnInit() {

    this.activatedRoute.queryParams.subscribe(params => {
      console.log('value on child: ' + params['search']);
    });


    this.conteudoService.fetchMensagens()
      .subscribe(data => this.listaConteudo = data,
                 error => this.errorHandler.handleError = error
    );
  }

  onSelect(conteudo: Conteudo) {
    // this.router.navigate([environment.base_conteudo_url, conteudo.codigo]);
    console.log('conteudo selecionado: ' + conteudo.codigo);
  }

}
