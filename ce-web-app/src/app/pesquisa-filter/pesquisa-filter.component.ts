import { Component, OnInit } from '@angular/core';
import { LivroService } from '../_services/livro.service';
import { PessoaService } from '../_services/pessoa.service';
import { CategoriaService } from '../_services/categoria.service';
import { Router } from '@angular/router';
import { MessageService } from '../_services/message.service';
import { ConteudoService } from '../_services/conteudo.service';
import { Categoria } from '../_models/categoria';
import { Livro } from '../_models/livro';
import { Pessoa } from '../_models/pessoa';
import { Pesquisa } from '../_models/pesquisa';
import { ConteudoTipo } from '../_models/conteudoTipo';

@Component({
  selector: 'app-pesquisa-filter',
  templateUrl: './pesquisa-filter.component.html',
  styleUrls: ['./pesquisa-filter.component.css']
})
export class PesquisaFilterComponent implements OnInit {

  public livros: Livro[];
  public pessoas: Pessoa[];
  public conteudoTipos: ConteudoTipo[];
  public categorias: Categoria[];
  public errorMessage;
  public pesquisa: Pesquisa;

  constructor(
    private conteudoService: ConteudoService,
    private livroService: LivroService,
    private pessoaService: PessoaService,
    private categoriaService: CategoriaService,
    private router: Router,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.fillLookups();
  }

  onSearch() {
    console.log('pesquisa filter onSearch : ');
    // this.router.navigate(['..' + environment.base_pesquisa_url ], {queryParams: {search: this.textoPesquisa}});
  }

  onChangeConteudoTipo(event) {
    console.log(event);
  }

  onChangeCategoria(event) {
    console.log(event);
  }

  private fillLookups() {
    this.pessoaService
      .fetchPessoas()
      .subscribe(
        data => (this.pessoas = data),
        error => (this.errorMessage = error)
      );

    this.livroService
      .fetchLivros()
      .subscribe(
        data => (this.livros = data),
        error => (this.errorMessage = error)
      );

    this.conteudoService
      .fetchConteudoTipos()
      .subscribe(
        data => (this.conteudoTipos = data),
        error => (this.errorMessage = error)
      );

    this.categoriaService
      .fetchCategorias()
      .subscribe(
        data => (this.categorias = data),
        error => (this.errorMessage = error)
      );
  }
}
