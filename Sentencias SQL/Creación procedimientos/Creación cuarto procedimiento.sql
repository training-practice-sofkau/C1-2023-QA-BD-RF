delimiter //
create procedure insertar_alimento(
	in dosis varchar(30),
    in tipo varchar(30),
    in nombre varchar(60),
    in idProveedor_alimento int
)
begin
	insert into alimento(dosis,tipo,nombre,idProveedor_alimento)
    values(dosis,tipo,nombre,idProveedor_alimento);
end; //
delimiter ;