create table control_de_cambios_pedidos(
	nombre varchar(50),
    accion varchar(30),
    fecha datetime default current_timestamp
);

create table control_de_cambios_clientes(
	nombre varchar(50),
    accion varchar(30),
    fecha datetime default current_timestamp
);

-- Trigger insercion de datos pedidos
DELIMITER //
create trigger trigger_ins_pedidos after insert on pedido
	for each row
    begin
		insert into control_de_cambios_pedidos values (
			user(), 'Insertar', now()
            );
    end;
    //
    DELIMITER ;
-- Trigger eliminacion de datos pedidos
DELIMITER //
create trigger trigger_DEL_pedidos after delete on pedido
	for each row
    begin
		insert into control_de_cambios_pedidos values (
			user(), 'Eliminar', now()
            );
    end;
    //
    DELIMITER ;
    
    -- Trigger insercion de datos clientes
DELIMITER //
create trigger trigger_ins_clientes after insert on cliente
	for each row
    begin
		insert into control_de_cambios_clientes values (
			user(), 'Insertar', now()
            );
    end;
    //
    DELIMITER ;
-- Trigger eliminacion de datos clientes
DELIMITER //
create trigger trigger_DEL_clientes after delete on cliente
	for each row
    begin
		insert into control_de_cambios_clientes values (
			user(), 'Eliminar', now()
            );
    end;
    //
    DELIMITER ;