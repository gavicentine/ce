// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  // api_url: 'http://localhost:5000/api/'
  base_api_url: './assets/data/',
  base_adm_url: '/adm',
  base_categorias_url: '/adm/categorias',
  base_livros_url: '/adm/livros',
  base_pessoas_url: '/adm/pessoas',
  base_usuarios_url: '/adm/usuarios',
  base_conteudo_url: '/adm/conteudo',
  base_pesquisa_url: '/pesquisa'
};
