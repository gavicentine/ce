import { Pessoa } from './pessoa';

export class Livro {
  codigo: number;
  titulo: string;
  autores: Pessoa[];
  espirito?: Pessoa;
}
