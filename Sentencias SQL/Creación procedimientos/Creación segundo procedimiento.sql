delimiter //
create procedure insertar_veterinario(
	in nombre varchar(60)
)
begin
	insert into veterinario(nombre)
    values (nombre);
end; //
delimiter ;