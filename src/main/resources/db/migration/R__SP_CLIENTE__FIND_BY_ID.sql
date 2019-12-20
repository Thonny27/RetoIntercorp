DROP PROCEDURE IF EXISTS cliente__find_by_id;
DELIMITER $$
CREATE PROCEDURE cliente__find_by_id(IN p_id int)
BEGIN
	SELECT id,nombre,apellido,edad
	from cliente
	where id = p_id;
END;