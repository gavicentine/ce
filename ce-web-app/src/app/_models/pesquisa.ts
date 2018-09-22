import { Pessoa } from './pessoa';
import { ConteudoTipo } from './conteudoTipo';
import { ConteudoSituacao } from './conteudoSituacao';
import { Categoria } from './categoria';
import { Livro } from './livro';

export class Pesquisa {
  descricao?: string;
  conteudoTipos?: ConteudoTipo[];
  categorias?: Categoria[];
  autores?: Pessoa[];
  espiritos?: Pessoa[];
  livros?: Livro[];
}
