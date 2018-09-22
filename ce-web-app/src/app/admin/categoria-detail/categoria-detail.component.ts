import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoriaService } from '../../_services/categoria.service';
import { Categoria } from '../../_models/categoria';
import { environment } from '../../../environments/environment';
import { MessageService } from '../../_services/message.service';

@Component({
  selector: 'app-categoria-detail',
  templateUrl: './categoria-detail.component.html',
  styleUrls: ['./categoria-detail.component.css']
})
export class CategoriaDetailComponent implements OnInit {
  // @Input() categoria: Categoria;
  // @Output() backRequest = new EventEmitter<string>();

  public categoria: Categoria;
  // public submitted = false;

  constructor(
    private categoriaService: CategoriaService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit() {

    const cod: number = +this.activatedRoute.snapshot.paramMap.get('id');
    console.log(cod);

    if (cod === 0) {
      this.categoria = this.categoriaService.create();
    } else {
      this.activatedRoute.data.subscribe(data => {
        this.categoria = data['categoria'];
      });
    }
  }

  salvar() {
    console.log('categoria-detail - salvar');
    this.messageService.success(this.messageService.SALVO_SUCESSO);
    this.router.navigate(['..' + environment.base_categorias_url]);
    // this.submitted = true;
  }

  voltar() {
    // console.log('categoria-detail - voltar');
    // this.backRequest.emit('voltar');
    this.router.navigate(['..' + environment.base_categorias_url]);
  }
}
