import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public textoPesquisa: string;

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  onSearch() {
    console.log('onSearch fired: ' + this.textoPesquisa);
    this.router.navigate(['..' + environment.base_pesquisa_url ], {queryParams: {search: this.textoPesquisa}});
  }

}
