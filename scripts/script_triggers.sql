use zoologico;

-- --------------------------------------------------------
-- sentencia para crear la tabla control_cambios_zoologico
-- --------------------------------------------------------

create table control_cambios_zoologico (
	usuario varchar(45) not null,
    accion varchar(45) not null,
    fecha datetime default current_timestamp
    );
    
-- ------------------------------------------------------------------
-- sentencia para crear un trigger que se active cuando un usuario
-- agregue un registro en la tabla alimento
-- -------------------------------------------------------------------

DELIMITER //
create trigger insert_alimento after insert on alimento
for each row
begin
	insert into control_cambios_zoologico
    values (user(), "Agregó alimento", now());
end //
DELIMITER ;

-- ---------------------------------------------------------------
-- sentencia para crear un trigger que se active cuando un usuario
-- consulte la cantidad de alimentos disponibles
-- ---------------------------------------------------------------

DELIMITER //
create trigger update_alimento after update on alimento
for each row
begin
    insert into control_cambios_zoologico
    values (user(), "Actualizó alimento", now());
end //
DELIMITER ;

-- -------------------------------------------------------------
-- sentencia para crear trigger que se active cuando un usuario
-- elimine un registro en la tabla alimento
-- -------------------------------------------------------------

DELIMITER //
create trigger delete_alimento after delete on alimento
for each row
begin
	insert into control_cambios_zoologico
    values (user(), "Eliminó alimento", now());
end //
DELIMITER ;

-- ------------------------------------------------------
-- sentencia para crear trigger que se active cuando un usuario
-- agregue un registro en la tabla reporte
-- ------------------------------------------------------------

DELIMITER //
create trigger insert_reporte after insert on reporte
for each row
begin
	insert into control_cambio_zoologico
    values (user(), "Agregó reporte", now());
end //
DELIMITER ;




