DROP PROCEDURE IF EXISTS cliente__find_all;
DELIMITER $$
CREATE PROCEDURE cliente__find_all()
BEGIN
	SELECT id,nombre,apellido,edad,fecha_nacimiento
	from cliente;
END;