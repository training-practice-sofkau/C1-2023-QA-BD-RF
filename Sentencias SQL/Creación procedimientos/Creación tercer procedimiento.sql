delimiter //
create procedure insertar_proveedor(
	in nombre varchar(60)
)
begin
	insert into proveedor(nombre)
    values (nombre);
end; //
delimiter ;