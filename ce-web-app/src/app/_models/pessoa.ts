import { PessoaSituacao } from './pessoaSituacao';
import { PessoaTipo } from './pessoaTipo';

export class Pessoa {
  codigo: number;
  nome: string;
  nomeAbrev?: string;
  situacao?: PessoaSituacao;
  tipo?: PessoaTipo;
}
