-- -----------------------------------------------------
-- Triggers CUD para empleados y C para proveedores
-- -----------------------------------------------------
USE ocochosBarberia;

-- -----------------------------------------------------
-- Creación de nueva tabla para registrar acciones CUD
-- sobre la tabla empleado
-- -----------------------------------------------------
CREATE TABLE controlCambiosEmpleado (
	usuario VARCHAR(100),
    accion VARCHAR(40),
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------
-- Creación de nueva tabla para registrar acción C sobre
-- la tabla proveedor
-- -----------------------------------------------------
CREATE TABLE controlCambiosProveedor (
	usuario VARCHAR(100),
    accion VARCHAR(40),
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------
-- Creando Trigger para registro Agregar Empleado
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER insEmpleado
AFTER INSERT ON empleado
FOR EACH ROW
BEGIN
INSERT INTO controlCambiosEmpleado
VALUES (USER(), 'AGREGAR', NOW());
END;
//

-- -----------------------------------------------------
-- Creando Trigger para registro Eliminar Empleado
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER delEmpleado
AFTER DELETE ON empleado
FOR EACH ROW
BEGIN
INSERT INTO controlCambiosEmpleado
VALUES (USER(), 'ELIMINAR', NOW());
END;
//

-- -----------------------------------------------------
-- Creando Trigger para registro Actualizar Empleado
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER updEmpleado
AFTER UPDATE ON empleado
FOR EACH ROW
BEGIN
IF OLD.cedula <> NEW.cedula AND OLD THEN
	INSERT INTO controlCambiosEmpleado
	VALUES (USER(), 'INVALIDO', NOW());
ELSEIF OLD.nombreEmpleado <> NEW.cédula THEN
	INSERT INTO controlCambiosEmpleado
	VALUES (USER(), 'ACTUALIZAR', NOW());
END IF;
END;
//

-- -----------------------------------------------------
-- Creando Trigger para registro Agregar Proveedor
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER insProveedor
AFTER INSERT ON proveedor
FOR EACH ROW
BEGIN
INSERT INTO controlCambiosProveedor
VALUES (USER(), 'AGREGAR', NOW());
END;
//