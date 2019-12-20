DROP PROCEDURE IF EXISTS cliente__update;
DELIMITER $$
CREATE PROCEDURE cliente__update(IN p_id int,
                                IN p_nombre varchar(50),
                                IN p_apellido varchar(50),
                                IN p_edad int,
                                IN p_fecha_nac Date)
BEGIN
	update cliente
	set nombre = p_nombre,
	    apellido=p_apellido,
	    edad=p_edad,
	    fecha_nacimiento = p_fecha_nac
	where id = p_id;
END;