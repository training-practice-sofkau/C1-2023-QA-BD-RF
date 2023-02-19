use tiendadonpepe;

create table control_de_cambios_tienda_pepe(
	usuario varchar(45),
    accion varchar(45),
    fecha datetime default current_timestamp
);

-- -----------------------------------------------------
-- Trigger- generar un registro cuando se inserte una categoria

delimiter //
create trigger agregar_categoria after insert on categoria
	for each row 
    begin
		insert into control_de_cambios_tienda_pepe (usuario,accion,fecha)
		values ('Luisa mendez','Agregar Categoria', now());
    end; 
    //

insert into categoria (id_categoria,nombre,almacenamiento,observaciones)
values ('106','cremas','seco','dejar en estantes');

-- -----------------------------------------------------
-- Trigger- generar un registro cuando se actualizar una categoria

delimiter //
create trigger actualizar_categoria after update on categoria
	for each row 
    begin
		insert into control_de_cambios_tienda_pepe (usuario,accion,fecha)
		values ('Pedro perez','Actualizar', now());
    end; 
    //

update categoria set observaciones= 'dejar en estantes y alejado de los jabones'
where id_categoria = '106';

-- -----------------------------------------------------
-- Trigger- generar un registro cuando se actualizar una categoria

delimiter //
create trigger eliminar_categoria after delete on categoria
	for each row
    begin
		insert into control_de_cambios_tienda_pepe (usuario,accion,fecha)
		values ('Vivian Gonzalez','eliminar categoria', now());
    end;
    //
    
delete from categoria where id_categoria='106';

-- -----------------------------------------------------
-- Trigger- generar un registro cuando se agregue un proveedor

delimiter //
create trigger agregar_proveedor after insert on proveedor
	for each row 
    begin
		insert into control_de_cambios_tienda_pepe (usuario,accion,fecha)
		values ('Luisa mendez','Agregar Proveedor', now());
    end; 
    //
    
insert into proveedor (razon_social,telefono,correo)
values ('zoto y zuluaga','345345','zoto@gmail.com')

