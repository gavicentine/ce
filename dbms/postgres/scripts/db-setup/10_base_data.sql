\o /tmp/10_base_data.log

delete from tipo_parametro;
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_SIT','A','ATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_SIT','I','INATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_SEXO','M','MASCULINO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_SEXO','F','FEMININO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_TIPO','1','CE','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_TIPO','2','Autor/Espirito','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'PESSOA.CD_TIPO','3','Usuario','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'USUARIO.CD_SIT','A','ATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'USUARIO.CD_SIT','I','INATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'USUARIO.CD_TIPO','I','INTERNO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'USUARIO.CD_TIPO','E','EXTERNO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'CONTEUDO.CD_SIT','A','ATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'CONTEUDO.CD_SIT','I','INATIVO','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'CONTEUDO.CD_TIPO','1','Mensagem','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'CONTEUDO.CD_TIPO','2','Trecho do Livro','ADMIN');

insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'ITEM.CD_TIPO','1','Categoria','ADMIN');
insert into tipo_parametro (tpparam_num, dominio, chave, vl_min, us_alt) values (nextval('seq_tipo_parametro'), 'ITEM.CD_TIPO','2','Livro','ADMIN');

delete from item;
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Caridade','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Família','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Reencarnação','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Aborto','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Suicídio','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Dinheiro','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Riqueza','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Crise','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Mágoa','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Espiritismo','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Terra','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Regeneração','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Expiação','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Prece','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '1', 'Necessidade','A','ADMIN');

insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '2', 'Por entre as sombras','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '2', 'A órfa número sete','A','ADMIN');
insert into item (item_num, cd_tipo, nm_item, cd_sit, us_alt) values (nextval('seq_item'), '2', 'Paulo Ricardo, Mar calmo nunca fez bom Marinheiro','A','ADMIN');

delete from perfil_acesso;
insert into perfil_acesso (perfil_num, nm_perfil, ds_perfil, us_alt) values (nextval('seq_perfil_acesso'), 'ROLE_ADMIN','ADMINISTRADOR','ADMIN');

delete from pessoa;
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '1', 'Comunidade Espirita','A','ADMIN',CURRENT_TIMESTAMP);

--autores / espiritos
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Vera Lúcia Marinzeck de Carvalho','A','ADMIN',CURRENT_TIMESTAMP);
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Chico Xavier','A','ADMIN',CURRENT_TIMESTAMP);
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Jairo Avelar','A','ADMIN',CURRENT_TIMESTAMP);
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Antônio Carlos','A','ADMIN',CURRENT_TIMESTAMP);
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Marcelo Rios','A','ADMIN',CURRENT_TIMESTAMP);
insert into pessoa(pessoa_num, cd_tipo, nm_pessoa ,cd_sit ,us_alt, dt_cad) values (nextval('seq_pessoa'), '2', 'Euripa Alcântra e Co-Autores','A','ADMIN',CURRENT_TIMESTAMP);

delete from usuario;
insert into usuario (nm_login ,ds_frase_senha ,ds_senha ,cd_sit , cd_tipo, perfil_num, pessoa_num, us_alt) values ('admin','admin','$2a$10$zYySvsl4SIBYZHVngLryredG1qNGfROfNIVrtNxHD/mJgVLCrvQmC','A','I',1,1,'ADMIN');



