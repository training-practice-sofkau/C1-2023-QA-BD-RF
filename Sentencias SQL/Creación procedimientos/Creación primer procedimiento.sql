delimiter //
create procedure insertar_animal(
	in nombre varchar(60),
    in peso varchar(4),
    in clasificacion varchar(50)
)
begin
	insert into animal(nombre,peso,clasificacion)
    values(nombre,peso,clasificacion);
end; //
delimiter ;