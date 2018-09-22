import { Component, OnInit} from '@angular/core';
import { Conteudo } from '../_models/conteudo';
import { ConteudoService } from '../_services/conteudo.service';
import { Router } from '@angular/router';
import { ErrorHandlerService } from '../_services/errorHandler.service';
import { MockNgModuleResolver } from '@angular/compiler/testing';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public conteudos: Conteudo[];
  public conteudo: Conteudo;
  public indexAtual = 0;

  constructor(private conteudoService: ConteudoService
    , private router: Router
    , private errorHandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.conteudoService.fetchMensagens()
      .subscribe(data => this.conteudos = data,
                 error => this.errorHandler.handleError = error
    );
    this.conteudoService.fetchMensagemById(0)
    .subscribe(data => this.conteudo = data,
               error => this.errorHandler.handleError = error
    );
  }

  showProxima() {
    if (this.indexAtual < 5) {
      this.indexAtual++;
    }
    this.conteudo = this.conteudos[this.indexAtual];
  }

  showAnterior() {
    if (this.indexAtual > 0) {
      this.indexAtual--;
    }
    this.conteudo = this.conteudos[this.indexAtual];
  }

}
