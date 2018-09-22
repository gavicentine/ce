import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  template: `
    <div class="jumbotron">
      <h1 class="display-4">Ooooops...</h1>
      <p class="lead">Página não encontrada.</p>
      <hr class="my-4">
      <p>A página solicitada não existe ou não pode ser exibida. Pressione o botão abaixo para retornar ao início.</p>
      <a class="btn btn-primary btn-lg" href="#" role="button">Retornar</a>
  </div>
  `,
  styles: []
})
export class PageNotFoundComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
