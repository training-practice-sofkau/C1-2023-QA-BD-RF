use barberia;
delimiter //
create trigger registro_cliente after insert on cliente
for each row
begin
	insert into registro_cambios values (user(),'se agrego un registro registro',now());
end//
delimiter ;

delimiter //
create trigger registro_cliente_eliminado after delete on cliente
for each row
begin
	insert into registro_cambios values (user(),'se elimino un  registro',now());
end//
delimiter //

create trigger registro_cliente_actualizado after update on cliente
for each row
begin
	insert into registro_cambios values (user(),'se actualizo un  registro',now());
end//
delimiter ;

delimiter //
create trigger registro_empleado after insert on empleado
for each row
begin
	insert into registro_cambios values (user(),'se agrego un registro a empleado',now());
end//
delimiter ;
