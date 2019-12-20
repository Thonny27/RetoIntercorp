DROP PROCEDURE IF EXISTS cliente__insert;
DELIMITER $$
CREATE PROCEDURE cliente__insert(IN p_nombre varchar(50),
                                   IN p_apellido varchar(50),
                                   IN p_edad int,
                                   IN p_fecha_nacimiento date)
BEGIN
	insert into cliente(nombre,
	                    apellido,
	                    edad,
	                    fecha_nacimiento)
	                    values(p_nombre,
                                p_apellido,
                                p_edad,
                                p_fecha_nacimiento);
END;