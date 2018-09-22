import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { AppRoutingModule, routingComponents} from './app-routing.module';
import { AutofocusDirective } from './autofocus.directive';

// external
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { PesquisaListComponent } from './pesquisa-list/pesquisa-list.component';
import { PesquisaFilterComponent } from './pesquisa-filter/pesquisa-filter.component';

// internal
import { MenuAdminComponent } from './admin/menu-admin/menu-admin.component';
import { DashboardAdminComponent } from './admin/dashboard-admin/dashboard-admin.component';
import { LivroDetailComponent } from './admin/livro-detail/livro-detail.component';
import { LivroListComponent } from './admin/livro-list/livro-list.component';
import { UsuarioListComponent } from './admin/pessoa/usuario-list/usuario-list.component';
import { UsuarioDetailComponent } from './admin/pessoa/usuario-detail/usuario-detail.component';
import { ConteudoListComponent } from './admin/conteudo-list/conteudo-list.component';
import { ConteudoDetailComponent } from './admin/conteudo-detail/conteudo-detail.component';
import { PessoaDetailComponent } from './admin/pessoa/pessoa-detail/pessoa-detail.component';
import { PessoaListComponent } from './admin/pessoa/pessoa-list/pessoa-list.component';

// resolvers
import { CategoriaDetailResolver } from './_resolvers/categoria-detail.resolver';
import { PessoaDetailResolver } from './_resolvers/pessoa-detail.resolver';
import { ConteudoDetailResolver } from './_resolvers/conteudo-detail.resolver';
import { LivroDetailResolver } from './_resolvers/livro-detail.resolver';

// services
import { UsuarioService} from './_services/usuario.service';
import { CategoriaService} from './_services/categoria.service';
import { PessoaService} from './_services/pessoa.service';
import { LivroService} from './_services/livro.service';
import { MessageService} from './_services/message.service';
import { ErrorHandlerService} from './_services/errorHandler.service';
import { ConteudoService } from './_services/conteudo.service';

// import { NgxDatatableModule } from '@swimlane/ngx-datatable';
// import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/multiselect.component';
// import { SelectDropDownModule } from 'ngx-select-dropdown';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuAdminComponent,
    routingComponents,
    PageNotFoundComponent,
    DashboardAdminComponent,
    AutofocusDirective,
    LivroDetailComponent,
    LivroListComponent,
    UsuarioListComponent,
    UsuarioDetailComponent,
    ConteudoListComponent,
    ConteudoDetailComponent,
    LoginComponent,
    PessoaDetailComponent,
    PessoaListComponent,
    DashboardAdminComponent,
    MenuAdminComponent,
    PesquisaListComponent,
    PesquisaFilterComponent,
    HomeComponent
],
  imports: [
    BrowserModule,
    FormsModule,
    NgSelectModule,
    // NgxDatatableModule,
    // AngularMultiSelectModule
    // SelectDropDownModule
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [
    CategoriaService,
    CategoriaDetailResolver,
    PessoaService,
    PessoaDetailResolver,
    LivroService,
    LivroDetailResolver,
    ConteudoService,
    ConteudoDetailResolver,
    MessageService,
    UsuarioService,
    ErrorHandlerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
