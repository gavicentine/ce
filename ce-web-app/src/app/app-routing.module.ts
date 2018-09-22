import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DashboardAdminComponent } from './admin/dashboard-admin/dashboard-admin.component';
import { CategoriaListComponent } from './admin/categoria-list/categoria-list.component';
import { CategoriaDetailComponent } from './admin/categoria-detail/categoria-detail.component';
import { LivroListComponent } from './admin/livro-list/livro-list.component';
import { LivroDetailComponent } from './admin/livro-detail/livro-detail.component';
import { UsuarioListComponent } from './admin/pessoa/usuario-list/usuario-list.component';
import { UsuarioDetailComponent } from './admin/pessoa/usuario-detail/usuario-detail.component';
import { ConteudoListComponent } from './admin/conteudo-list/conteudo-list.component';
import { ConteudoDetailComponent } from './admin/conteudo-detail/conteudo-detail.component';
import { LoginComponent } from './login/login.component';
import { PessoaListComponent } from './admin/pessoa/pessoa-list/pessoa-list.component';
import { PessoaDetailComponent } from './admin/pessoa/pessoa-detail/pessoa-detail.component';
import { CategoriaDetailResolver } from './_resolvers/categoria-detail.resolver';
import { LivroDetailResolver } from './_resolvers/livro-detail.resolver';
import { PessoaDetailResolver } from './_resolvers/pessoa-detail.resolver';
import { ConteudoDetailResolver } from './_resolvers/conteudo-detail.resolver';
import { PesquisaListComponent } from './pesquisa-list/pesquisa-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'pesquisa', component: PesquisaListComponent },
    { path: 'login', component: LoginComponent },
    { path: 'adm', component: DashboardAdminComponent },
    { path: 'adm/conteudo', component: ConteudoListComponent },
    { path: 'adm/conteudo/:id', component: ConteudoDetailComponent, resolve: {conteudo: ConteudoDetailResolver}},
    { path: 'adm/categorias', component: CategoriaListComponent },
    { path: 'adm/categorias/:id', component: CategoriaDetailComponent, resolve: {categoria: CategoriaDetailResolver}},
    { path: 'adm/pessoas', component: PessoaListComponent },
    { path: 'adm/pessoas/:id', component: PessoaDetailComponent, resolve: {pessoa: PessoaDetailResolver}},
    { path: 'adm/livros', component: LivroListComponent },
    { path: 'adm/livros/:id', component: LivroDetailComponent, resolve: {livro: LivroDetailResolver}},
    { path: 'adm/usuarios', component: UsuarioListComponent },
    { path: 'adm/usuarios/:login', component: UsuarioDetailComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule(
    {
        imports: [RouterModule.forRoot(routes)],
        exports: [RouterModule]
    }
)
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, PesquisaListComponent, PageNotFoundComponent,
    CategoriaListComponent, CategoriaDetailComponent,
    ConteudoListComponent, ConteudoDetailComponent,
    PessoaListComponent, PessoaDetailComponent,
    LivroListComponent, LivroDetailComponent,
    UsuarioListComponent, UsuarioDetailComponent];
