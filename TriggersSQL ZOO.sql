USE zoodb;

-- -----------------------------------------------------
-- Creo la tabla control de cambios ZOO
-- -----------------------------------------------------
CREATE TABLE control_de_cambios_zoo (
  usuario VARCHAR(45),
  accion VARCHAR(20),
  fecha DATETIME
);

-- -----------------------------------------------------
-- 1. Triggers Insertar
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER control_zoo_insert
AFTER INSERT ON dieta
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoo (usuario, accion, fecha)
VALUES (user(), 'insertar', NOW());
END;
//

-- -----------------------------------------------------
-- 2. Trigger Eliminar
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER control_zoo_delete_factura
AFTER DELETE ON factura
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoo (usuario, accion, fecha)
VALUES (user(), 'eliminar', NOW());
END;
//

-- -----------------------------------------------------
-- 3. Trigger Actualizar Dieta Animal
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER control_zoo_actualizar_dieta
AFTER UPDATE ON animal
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoo (usuario, accion, fecha)
VALUES (user(), 'actualizar', NOW());
END;
//

-- -----------------------------------------------------
-- 4. Trigger Agregar nuevo Animal
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER control_zoo_insertar_animal
AFTER INSERT ON animal
FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoo (usuario, accion, fecha)
VALUES (user(), 'insertar', NOW());
END;
//


