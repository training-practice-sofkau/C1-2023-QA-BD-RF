
#1
delimiter //
create procedure agregar_registro_cliente(in ID_cliente_nuevo varchar(15),in Nombre_cliente_nuevo  varchar(50),
in Cedula_cliente_nuevo  varchar(50),
in Direccion_cliente_nuevo  varchar(50),
in Edad_cliente_nuevo  varchar(50))
begin
select * from cliente;
insert into cliente  values (ID_cliente_nuevo, Nombre_cliente_nuevo,Cedula_cliente_nuevo,
Direccion_cliente_nuevo,
Edad_cliente_nuevo);
end//
delimiter ;
call barberia.agregar_registro_cliente(5, 'Juna', '123456', 'cr60', '45');
#2
delimiter //
create procedure eliminar_registro_cliente(in ID_cliente_nuevo varchar(15))
begin
select * from cliente;
delete from  cliente where ID_cliente = ID_cliente_nuevo;
end//
delimiter ;
call eliminar_registro_cliente(5)
#3
delimiter //
create procedure actualizar_registro_cliente(in ID_cliente_nuevo varchar(15),in Nombre_cliente_nuevo  varchar(50),
in Cedula_cliente_nuevo  varchar(50),
in Direccion_cliente_nuevo  varchar(50),
in Edad_cliente_nuevo  varchar(50))
begin
select * from cliente;
update cliente set Nombre_cliente = Nombre_cliente_nuevo, 
Cedula_cliente = Cedula_cliente_nuevo,
Direccion_cliente =  Direccion_cliente_nuevo,
Edad_cliente = Edad_cliente_nuevo  where ID_cliente = ID_cliente_nuevo;
end//
delimiter ;
call actualizar_registro_cliente(1,'Roman', 1234567, 'cr67', 45);
#4
delimiter //
create procedure consultar_registro_cliente(in ID_cliete_nuevo varchar(15))
begin
select * from cliente where ID_cliente = ID_cliete_nuevo;
end//
delimiter ;
call consultar_registro_cliente(1);