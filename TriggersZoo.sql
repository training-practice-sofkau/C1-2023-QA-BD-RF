
#Creacion tabla para control de cambios
-- create table control_de_cambios_zoologico(
-- usuario varchar(45),
-- accion varchar(45),
-- fecha datetime default current_timestamp
-- );

#1. Trigger para registrar quien agrega un animal

DELIMITER //
create trigger inserto_animal after insert on animal
for each row
begin
	insert into control_de_cambios_zoologico
    values (user(),"AGREGO ANIMAL",now());
end;
//
DELIMITER ;

insert into animal values('A10','Grogu','macho','2','Mono','D002');

#2. Trigger para registrar quien elimina un medico
DELIMITER //
create trigger elimino_animal after delete on animal
for each row
begin
	insert into control_de_cambios_zoologico
    values (user(),"ELIMINO ANIMAL",now());
end;
//
DELIMITER ;

delete from animal where id_animal = 'A10';

#3. Trigger para cuando ingresen nueva dieta
DELIMITER //
create trigger inserto_dieta after insert on dieta
for each row
begin
	insert into control_de_cambios_zoologico
    values (user(),"AGREGO DIETA",now());
end;
//
DELIMITER ;
insert into dieta values('D004','Dieta Acuatica','100g/dia','VET001');

#4. Trigger para cuando eliminen dieta
DELIMITER //
create trigger elimino_dieta after delete on dieta
for each row
begin
	insert into control_de_cambios_zoologico
    values (user(),"ELIMINO DIETA",now());
end;
//
DELIMITER ;
delete from dieta where id_dieta = 'D004';