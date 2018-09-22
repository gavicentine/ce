import { Component, OnInit } from '@angular/core';
import { PessoaService } from '../../../_services/pessoa.service';
import { Router } from '@angular/router';
import { Pessoa } from '../../../_models/pessoa';
import { PessoaTipo } from '../../../_models/pessoaTipo';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  public pessoas: Pessoa[];
  public errorMessage;

  constructor(private pessoaService: PessoaService, private router: Router) {

  }

  ngOnInit() {
    this.pessoaService.fetchPessoas()
      .subscribe(data => this.pessoas = data,
                 error => this.errorMessage = error
    );
  }

  onSelect(pessoa: Pessoa) {
    this.router.navigate([environment.base_pessoas_url, pessoa.codigo]);
  }

  onCreate() {
    this.router.navigate([environment.base_pessoas_url + '/0']);
  }

}
