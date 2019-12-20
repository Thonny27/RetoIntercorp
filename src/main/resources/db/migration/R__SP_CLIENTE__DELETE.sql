DROP PROCEDURE IF EXISTS cliente__delete;
DELIMITER $$
CREATE PROCEDURE cliente__delete(IN p_id int)
BEGIN
	delete from cliente
	where id = p_id;
END;