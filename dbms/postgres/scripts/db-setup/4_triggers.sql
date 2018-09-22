\o /tmp/4_triggers.log

CREATE TRIGGER trg_tipo_parametro_bef_ins
  BEFORE INSERT OR UPDATE
  ON tipo_parametro
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_pessoa_bef_ins
  BEFORE INSERT OR UPDATE
  ON pessoa
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_perfil_acesso_bef_ins
  BEFORE INSERT OR UPDATE
  ON perfil_acesso
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_caract_bef_ins
  BEFORE INSERT OR UPDATE
  ON caract
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_usuario_bef_ins
  BEFORE INSERT OR UPDATE
  ON usuario
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_usuario_caract_bef_ins
  BEFORE INSERT OR UPDATE
  ON usuario_caract
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_item_bef_ins
  BEFORE INSERT OR UPDATE
  ON item
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_conteudo_bef_ins
  BEFORE INSERT OR UPDATE
  ON conteudo
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_conteudo_item_bef_ins
  BEFORE INSERT OR UPDATE
  ON conteudo_item
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt(); 
  
CREATE TRIGGER trg_conteudo_pessoa_bef_ins
  BEFORE INSERT OR UPDATE
  ON conteudo_pessoa
  FOR EACH ROW
  EXECUTE PROCEDURE func_create_dt_alt();   
  