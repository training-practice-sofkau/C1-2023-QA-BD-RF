create table control_cambio_peso(
	idCambio int auto_increment primary key,
	usuario varchar(60),
    accion varchar(17),
    fecha date,
    idAnimal_cambio int,
    nombreAnimal varchar(60),
    clasificacionAnimal varchar(50),
    pesoAnimal varchar(4)
);

DELIMITER //
create trigger cambiar_peso after update on animal
for each row
begin
	insert into control_cambio_peso(usuario,accion,fecha,idAnimal_cambio,nombreAnimal,clasificacionAnimal,pesoAnimal)
    values (user(),"cambio en el peso",now(),old.idAnimal,old.nombre,old.clasificacion,old.peso);
end; //
DELIMITER ;

delimiter //
create trigger nuevo_animal after insert on animal
for each row
begin
	insert into control_cambio_peso(usuario,accion,fecha,idAnimal_cambio,nombreAnimal,clasificacionAnimal,pesoAnimal)
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