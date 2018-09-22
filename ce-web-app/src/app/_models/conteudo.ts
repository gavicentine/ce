import { Pessoa } from './pessoa';
import { ConteudoTipo } from './conteudoTipo';
import { ConteudoSituacao } from './conteudoSituacao';
import { Categoria } from './categoria';
import { Livro } from './livro';

export class Conteudo {
  codigo: number;
  titulo: string;
  descricao: string;
  tipo: ConteudoTipo;
  situacao: ConteudoSituacao;
  categorias: Categoria[];
  autores: Pessoa[];
  espirito?: Pessoa;
  livro?: Livro;
}
