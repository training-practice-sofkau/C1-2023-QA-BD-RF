#Procedimientos Zoologico

#1. Procedimiento para agregar un nuevo animal
DELIMITER //
CREATE PROCEDURE insertar_animal(IN id VARCHAR(10),IN name_animal VARCHAR(45),IN animal_sexo VARCHAR(45),
  IN edad_a VARCHAR(45), 
  IN tipo VARCHAR(10), 
  IN dieta_id VARCHAR(10)
)
BEGIN
  INSERT INTO animal VALUES(id, name_animal, animal_sexo, edad_a, tipo, dieta_id);
END
//
DELIMITER ; 

call insertar_animal('A10','Grogu','macho','2','Mono','D002');


#2. Procedimiento para actualizar la cantidad de un alimento

DELIMITER //
CREATE PROCEDURE actualizar_cantidad_alimento(
  IN id VARCHAR(10), 
  IN cant VARCHAR(45)
)
BEGIN
  UPDATE alimento
  SET cantidad = cant
  WHERE id_alimento = id;
END
//
DELIMITER ;
call actualizar_cantidad_alimento('ALM001','300kg');

#3. Cambiar la dieta que tiene asignada un animal
use zoologico;
DELIMITER //
CREATE PROCEDURE actualizar_dieta_animal(IN id VARCHAR(10),IN dieta_id VARCHAR(10))
BEGIN
  UPDATE animal
  SET dieta_id_a = dieta_id
  WHERE id_animal = id;
END
//
DELIMITER ;

call actualizar_dieta_animal('A001','D002');

#4. Procedimiento para eliminar un animal
DELIMITER //
CREATE PROCEDURE eliminar_animal(IN id VARCHAR(10))
BEGIN
  DELETE FROM animal WHERE id_animal = id;
END
//
DELIMITER ; 

call eliminar_animal('A10');