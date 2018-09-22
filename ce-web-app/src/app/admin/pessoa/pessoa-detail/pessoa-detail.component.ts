import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PessoaService } from '../../../_services/pessoa.service';
import { Pessoa } from '../../../_models/pessoa';
import { Observable } from 'rxjs/Observable';
import { PessoaSituacao } from '../../../_models/pessoaSituacao';
import { PessoaTipo } from '../../../_models/pessoaTipo';
import { environment } from '../../../../environments/environment';
import { MessageService } from '../../../_services/message.service';

@Component({
  selector: 'app-pessoa-detail',
  templateUrl: './pessoa-detail.component.html',
  styleUrls: ['./pessoa-detail.component.css']
})
export class PessoaDetailComponent implements OnInit {

  public pessoa: Pessoa;
  // @Output() backRequest = new EventEmitter<Pessoa>();

  public situacoes: PessoaSituacao[];
  public tipos: PessoaTipo[];
  public errorMessage;

  constructor(
    private pessoaService: PessoaService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
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
    this.pessoa.situacao.nome = event.target.selectedOptions[0].innerText;
  }

  onChangeTipo(event) {
    this.pessoa.tipo.nome = event.target.selectedOptions[0].innerText;
  }

  salvar() {
    this.messageService.success(this.messageService.SALVO_SUCESSO);
    this.router.navigate(['..' + environment.base_pessoas_url]);
  }

  voltar() {
    this.router.navigate(['..' + environment.base_pessoas_url]);
  }

  private fillLookups() {
    this.pessoaService
      .fetchPessoaSituacoes()
      .subscribe(
        data => (this.situacoes = data),
        error => (this.errorMessage = error)
      );

    this.pessoaService
      .fetchPessoaTipos()
      .subscribe(
        data => (this.tipos = data),
        error => (this.errorMessage = error)
      );
  }

  private fillDetail() {
    const cod: number = +this.activatedRoute.snapshot.paramMap.get('id');
    console.log(cod);

    // if new just create otherwise show data fetched
    if (cod === 0) {
      this.pessoa = this.pessoaService.create();
    } else {
      this.activatedRoute.data.subscribe(data => {
        this.pessoa = data['pessoa'];
      });
    }
  }


}
