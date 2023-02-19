use barber;

create table control_de_cambios_barber(
	nombre varchar(50),
    accion varchar(30),
    fecha datetime default current_timestamp
);

-- triger insert
DELIMITER //
CREATE TRIGGER control_insert
AFTER INSERT ON cliente
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_barber (usuario, accion, fecha)
VALUES (user(), 'insert', NOW());
END;
//


DROP TRIGGER control_insert
DROP TRIGGER control_delete
call insertar_cliente('70','YEISON', '1010110', 'INGENIERO', 'YEISON@GMAIL.COM', 12, 'INJNCD');


-- eliminar trigger

DELIMITER //
CREATE TRIGGER control_delete
AFTER DELETE ON cliente
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_barber (usuario, accion, fecha)
VALUES (user(), 'delete', NOW());
END;
//


call borrar_cliente(58);



-- trigger actualizar
DELIMITER //
CREATE TRIGGER control_update
AFTER UPDATE ON cliente
FOR EACH ROW
BEGIN
    INSERT INTO control_de_cambios_barber (usuario, accion, fecha)
    VALUES (user(), 'update', NOW());
END;
//
DELIMITER ;


call actualizar_cliente(70, 'YEISON FERNEY', 'OSORIO BUITRAGO', 'QA', 'JEISON@GMAIL.COM', 10, 'CALLE VIRIGLIO');



