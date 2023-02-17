use zoologico;

-- --------------------------------------------
-- procedimiento para insertar un alimento
-- ---------------------------------------------

DELIMITER //
create procedure agregar_alimento(in id_alimento varchar(10),
nombre_alimento varchar(45),
tipo_alimento varchar(45),
cantidad_alimento varchar(6))
begin
	insert into alimento values (id_alimento, nombre_alimento, tipo_alimento, cantidad_alimento);
end //
DELIMITER ;


-- ----------------------------------------------
-- procedimiento para eliminar un alimento
-- ----------------------------------------------

DELIMITER //
create procedure eliminar_alimento(in id_alimento varchar(10))
begin
	delete from alimento where alimento.id = id_alimento;
end //
DELIMITER ;

-- ----------------------------------------------------
-- procedimiento para actualizar un alimento
-- ----------------------------------------------------

DELIMITER //
create procedure actualizar_alimento(in id_alimento varchar(10),
nombre_alimento varchar(45),
tipo_alimento varchar(45),
cantidad_alimento varchar(6))
begin
	update alimento
    set alimento.nombre = nombre_alimento, alimento.tipo = tipo_alimento,
		alimento.cantidad = cantidad_alimento
	where alimento.id = id_alimento;
end //
DELIMITER ;

-- ----------------------------------------------------------------
-- procedimiento para consultar la cantidad de alimento disponible
-- ---------------------------------------------------------------

DELIMITER //
create procedure consultar_cantidad_alimento(in id_alimento varchar(10))
begin
	select alimento.nombre, alimento.cantidad from alimento
    where alimento.id = id_alimento;
end //
DELIMITER ;



