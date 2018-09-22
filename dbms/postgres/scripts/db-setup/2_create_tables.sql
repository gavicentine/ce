\o /tmp/2_create_tables.log

create table tipo_parametro
(tpparam_num integer NOT NULL
,dominio character varying(100) NOT NULL
,chave character varying(100) NOT NULL
,vl_min character varying(50) NOT NULL
,vl_max character varying(50)
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (tpparam_num)
); 

create table pessoa
(pessoa_num integer NOT NULL
,cd_tipo character (1) NOT NULL
,nm_pessoa character varying(100) NOT NULL
,nm_abrev character varying(30)
,cd_sit character (1) NOT NULL
,cd_sexo character (1) 
,cpf_cnpj_num character varying(20)
,rg_ie_num character varying(20)
,dt_cad timestamp not null
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (pessoa_num)
);

create table perfil_acesso
(perfil_num integer NOT NULL
,nm_perfil  character varying(100) NOT NULL
,ds_perfil  character varying(100) NOT NULL
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (perfil_num)
);

create table caract
(caract_num integer not null
,nm_caract character varying(100) NOT NULL
,ds_caract character varying(1000) NOT NULL
,cd_tipo character (1) NOT NULL
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (caract_num)
);

create table usuario
(nm_login character varying(30) NOT NULL
,ds_senha character varying(100) NOT NULL
,cd_sit character(1) NOT NULL
,cd_tipo character(1) NOT NULL
,ds_frase_senha character varying(50)
,perfil_num integer NOT NULL
,pessoa_num integer NOT NULL
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (nm_login)
);

ALTER TABLE usuario ADD CONSTRAINT fk_usu_perfil
  FOREIGN KEY ( perfil_num )
   REFERENCES perfil_acesso ( perfil_num );
   
ALTER TABLE pessoa ADD CONSTRAINT fk_usu_pessoa
  FOREIGN KEY ( pessoa_num )
   REFERENCES pessoa ( pessoa_num );
   
create table usuario_caract
(nm_login character varying(50) NOT NULL
,caract_num integer not null
,ds_valor character varying(100) 
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (nm_login,caract_num)
);

ALTER TABLE usuario_caract ADD CONSTRAINT fk_usucar_usuario
  FOREIGN KEY ( nm_login )
   REFERENCES usuario ( nm_login );
   
ALTER TABLE usuario_caract ADD CONSTRAINT fk_usucar_caract
  FOREIGN KEY ( caract_num )
   REFERENCES caract ( caract_num );

create table item
(item_num integer not null
,nm_item character varying(100) NOT NULL
,cd_tipo character varying(1) not null
,cd_sit character varying(1) not null
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (item_num)
);

create table conteudo
(conteudo_num integer not null
,tit_conteudo character varying(200) NOT NULL
,ds_conteudo character varying(4000) NOT NULL
,cd_tipo character (1) NOT NULL -- 1 Mensagem , 2 Trecho do Livro, 
,cd_sit character(1) NOT NULL
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (conteudo_num)
);

create table conteudo_item
(contitem_num integer not null
,conteudo_num integer not null
,item_num integer not null
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (contitem_num)
);

ALTER TABLE conteudo_item ADD CONSTRAINT fk_contitem_conteudo
  FOREIGN KEY ( conteudo_num )
   REFERENCES conteudo ( conteudo_num );

ALTER TABLE conteudo_item ADD CONSTRAINT fk_contitem_item
  FOREIGN KEY ( item_num )
   REFERENCES item ( item_num );

  
create table conteudo_pessoa
(contpessoa_num integer not null
,conteudo_num integer not null
,pessoa_num integer not null
,cd_tipo character(1) NOT NULL --1 Autores 2 Espiritos
,us_alt character varying(30) not null
,dt_alt timestamp not null
,primary key (contpessoa_num)
);

ALTER TABLE conteudo_pessoa ADD CONSTRAINT fk_contpessoa_conteudo
  FOREIGN KEY ( conteudo_num )
   REFERENCES conteudo ( conteudo_num );

ALTER TABLE conteudo_pessoa ADD CONSTRAINT fk_contpessoa_pessoa
  FOREIGN KEY ( pessoa_num )
   REFERENCES pessoa ( pessoa_num );
  
  
  
  
  
  