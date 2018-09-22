\o /tmp/3_functions.log

CREATE FUNCTION func_create_dt_alt()
RETURNS trigger AS
$$
BEGIN
	NEW.dt_alt := CURRENT_TIMESTAMP;
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';