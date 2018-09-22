import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LivroService } from '../../_services/livro.service';
import { Livro } from '../../_models/livro';
import { PessoaService } from '../../_services/pessoa.service';
import { Pessoa } from '../../_models/pessoa';
import { environment } from '../../../environments/environment';
import { MessageService } from '../../_services/message.service';

@Component({
  selector: 'app-livro-detail',
  templateUrl: './livro-detail.component.html',
  styleUrls: ['./livro-detail.component.css']
})
export class LivroDetailComponent implements OnInit {

  public livro: Livro;
  public pessoas: Pessoa[];
  public errorMessage;

  constructor(
    private livroService: LivroService,
    private pessoaService: PessoaService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.fillLookups();
    this.fillDetails();
  }

  salvar() {
    this.messageService.success(this.messageService.SALVO_SUCESSO);
    this.router.navigate(['..' + environment.base_livros_url]);
    console.log(this.livro);
  }

  voltar() {
    this.router.navigate(['..' + environment.base_livros_url]);
  }

  onChangeAutor(event) {
    console.log(event);
  }

  onChangeEspirito(event) {
    console.log(event);
  }

  private fillLookups() {

    this.pessoaService
      .fetchPessoas()
      .subscribe(
        data => (this.pessoas = data),
        error => (this.errorMessage = error)
      );

  }

  private fillDetails() {
    const cod: number = +this.activatedRoute.snapshot.paramMap.get('id');
    console.log(cod);

    // if new just create otherwise show data fetched
    if (cod === 0) {
      this.livro = this.livroService.create();
    } else {
      this.activatedRoute.data.subscribe(data => {
        this.livro = data['livro'];
      });
    }
  }

}
