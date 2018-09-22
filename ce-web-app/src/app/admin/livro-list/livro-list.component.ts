import { Component, OnInit } from '@angular/core';
import { LivroService } from '../../_services/livro.service';
import { Router } from '@angular/router';
import { Livro } from '../../_models/livro';
import { Pessoa } from '../../_models/pessoa';
import { PessoaSituacao } from '../../_models/pessoaSituacao';
import { PessoaTipo } from '../../_models/pessoaTipo';
import { environment } from '../../../environments/environment';
import { MessageService } from '../../_services/message.service';
import { ErrorHandlerService } from '../../_services/errorHandler.service';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.css']
})
export class LivroListComponent implements OnInit {

  // public livro: Livro;
  public livros: Livro[];

  constructor(
    private livroService: LivroService
  , private messageService: MessageService
  , private router: Router
  , private errorHandler: ErrorHandlerService) {

  }

  ngOnInit() {
    this.livroService.fetchLivros()
      .subscribe(data => this.livros = data,
                 error => this.errorHandler.handleError = error
    );
  }

  onSelect(livro: Livro) {
    // this.livro = livro;
    // this.router.navigate(['/categorias',categoria.id]);
    this.router.navigate([environment.base_livros_url, livro.codigo]);
  }

  onCreate() {
    // this.livro = this.livroService.create();
    // this.router.navigate(['/categorias/new']);
    // this.selected = new Livro(null, '', new Pessoa(null, '', '', new PessoaSituacao(1, 'Ativo'), new PessoaTipo(1, 'Autor')),
    // new Pessoa(null, '', '', new PessoaSituacao(1, 'Ativo'), new PessoaTipo(2, 'Espirito')));
    // this.livro = this.livroService.create();
    this.router.navigate([environment.base_livros_url + '/0']);

  }

  // fromChild(event) {
    // console.log("categoria-list fromChild "+event);
    // this.livro = null;
  // }

}
