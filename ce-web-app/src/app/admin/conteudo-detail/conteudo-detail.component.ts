import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ConteudoService } from '../../_services/conteudo.service';
import { Conteudo } from '../../_models/conteudo';
import { environment } from '../../../environments/environment';
import { MessageService } from '../../_services/message.service';
import { Livro } from '../../_models/livro';
import { Pessoa } from '../../_models/pessoa';
import { LivroService } from '../../_services/livro.service';
import { PessoaService } from '../../_services/pessoa.service';
import { ConteudoSituacao } from '../../_models/conteudoSituacao';
import { ConteudoTipo } from '../../_models/conteudoTipo';
import { Categoria } from '../../_models/categoria';
import { CategoriaService } from '../../_services/categoria.service';

@Component({
  selector: 'app-conteudo-detail',
  templateUrl: './conteudo-detail.component.html',
  styleUrls: ['./conteudo-detail.component.css']
})
export class ConteudoDetailComponent implements OnInit {
  public conteudo: Conteudo;
  public livros: Livro[];
  public pessoas: Pessoa[];
  public situacoes: ConteudoSituacao[];
  public tipos: ConteudoTipo[];

  public categorias: Categoria[];
  public errorMessage;

  constructor(
    private conteudoService: ConteudoService,
    private livroService: LivroService,
    private pessoaService: PessoaService,
    private categoriaService: CategoriaService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.fillLookups();
    this.fillDetail();
  }

  onChangeSituacao(event) {
    // console.log('autor-detail - imprimir');
    // console.log(event);
    // console.log(event.target.selectedOptions[0].innerText);
    // console.log(event.target.selectedOptions[0].value);
    // TODO: remover esse codigo quando salvar estiver funcionando (lista deve ser atualizada automaticamente)
    this.conteudo.situacao.nome = event.target.selectedOptions[0].innerText;
  }

  onChangeTipo(event) {
    this.conteudo.tipo.nome = event.target.selectedOptions[0].innerText;
  }

  salvar() {
    console.log('conteudo-detail - salvar');
    console.log(this.conteudo);
    this.messageService.success(this.messageService.SALVO_SUCESSO);
    this.router.navigate(['..' + environment.base_conteudo_url]);
  }

  voltar() {
    this.router.navigate(['..' + environment.base_conteudo_url]);
  }

  onChangeCategoria(event) {
    console.log(event);
  }

  onChangeLivro(event) {

    console.log(event);

    this.conteudo.autores = [{
      codigo : 2,
      nome : 'Chico Xavier',
      situacao: {
          codigo: 1,
          nome: 'Ativo'
      },
      tipo: {
          codigo: 1,
          nome: 'Autor'
      }
    }];

    this.conteudo.espirito = {
      codigo: 1,
      nome: 'Espirito Selecionado',
      situacao: {
        codigo: 1, nome: 'Ativo'
      },
      tipo: {
        codigo: 1, nome: 'Autor'
      }
    };

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
      .fetchConteudoSituacoes()
      .subscribe(
        data => (this.situacoes = data),
        error => (this.errorMessage = error)
      );

    this.conteudoService
      .fetchConteudoTipos()
      .subscribe(
        data => (this.tipos = data),
        error => (this.errorMessage = error)
      );

    this.categoriaService
      .fetchCategorias()
      .subscribe(
        data => (this.categorias = data),
        error => (this.errorMessage = error)
      );
  }

  private fillDetail() {
    const cod: number = +this.activatedRoute.snapshot.paramMap.get('id');
    console.log(cod);

    if (cod === 0) {
      this.conteudo = this.conteudoService.create();
    } else {
      this.activatedRoute.data.subscribe(data => {
        this.conteudo = data['conteudo'];
      });
    }
  }
}
