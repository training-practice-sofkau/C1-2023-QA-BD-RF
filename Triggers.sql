# Trigger que registra la fecha y hora de la inserción en la tabla animal

DELIMITER //
CREATE TRIGGER animal_insert_trigger
BEFORE INSERT ON zoologico.animal
FOR EACH ROW
BEGIN
    INSERT INTO zoologico.auditoria (usuario, accion, fecha)
    VALUES (user(), 'Insertó un animal a la hora', NOW());
END;

// DELIMITER ;

#Trigger que registra la fecha y hora de la actualización en la tabla "animal":
DELIMITER //
CREATE TRIGGER animal_update_trigger
BEFORE UPDATE ON zoologico.animal
FOR EACH ROW
BEGIN
    INSERT INTO zoologico.auditoria  (usuario, accion, fecha)
    VALUES (user(), 'Actulizó un animal a la hora', NOW());
END;
// DELIMITER ;

#Trigger que registra la fecha y hora de la inserción en la tabla "dieta":
DELIMITER //

CREATE TRIGGER dieta_insert_trigger
BEFORE INSERT ON zoologico.dieta
FOR EACH ROW
BEGIN
    INSERT INTO zoologico.auditoria  (usuario, accion, fecha)
    VALUES (user(), 'Insertó una nueva dieta a la hora', NOW());
END;
// DELIMITER ;

#Trigger que registra la fecha y hora de la actualización en la tabla "dieta":
DELIMITER //
CREATE TRIGGER dieta_update_trigger
BEFORE UPDATE ON zoologico.dieta
FOR EACH ROW
BEGIN
    INSERT INTO zoologico.auditoria (usuario, accion, fecha)
    VALUES (user(), 'Actualizó una dieta a la hora', NOW());
END;
// DELIMITER ;
