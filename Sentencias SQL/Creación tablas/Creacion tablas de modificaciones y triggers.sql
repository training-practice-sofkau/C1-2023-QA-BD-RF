create table control_cambio_peso(
	idCambio int auto_increment primary key,
	usuario varchar(60),
    accion varchar(17),
    fecha date,
    idAnimal int,
    nombreAnimal varchar(60),
    clasificaion varchar(50),
    peso int
);

DELIMITER //
create trigger cambiar_peso after update on animal
for each row
begin
	insert into control_cambio_peso(usuario,accion,fecha,idAnimal,nombre,clasificacion,peso)
    values (user(),"cambio en el peso",now(),old.idAnimal,old.nombre,old.clasificacion,old.peso);
end; //
DELIMITER ;

delimiter //
create trigger nuevo_animal after insert on animal
for each row
begin
	insert into control_cambio_peso(usuario,accion,fecha,idAnimal,nombre,clasificacion,peso)
    values(user(),"insercion",now(),new.idAnimal,new.nombre,new.clasificacion,new.peso);
end; //
delimiter ;

create table control_cambio_dieta(
	idCambio int auto_increment primary key,
    usuario varchar(60),
    accion varchar(18),
    fecha date,
    idDieta int
);

DELIMITER //
create trigger cambiar_dieta after update on alimento_dieta
for each row
begin
	insert into control_cambio_dieta(usuario,accion,fecha,idDieta)
    values (user(),"cambio en la dieta",now(),old.idDieta_alimento);
end; //
DELIMITER ;

delimiter //
create trigger nueva_dieta after insert on alimento_dieta
for each row
begin
	insert into control_cambio_dieta(usuario,accion,fecha,idDieta)
    values(user(),"insercion",now(),new.idDieta_alimento);
end; //
delimiter ;