-- -----------------------------------------------------
-- Procedimientos CRUD para empleados
-- -----------------------------------------------------
USE ocochosBarberia;

-- -----------------------------------------------------
-- Procedimiento Agregar
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarEmpleado (IN idE INT,
								  IN nombreE VARCHAR(40),
                                  IN cédulaE VARCHAR(20))
BEGIN
INSERT INTO empleado
VALUES 
	(idE, nombreE, cédulaE);
END;
//

-- -----------------------------------------------------
-- Procedimiento Consultar
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE empleadoPorId (IN idE INT)
BEGIN
SELECT
		nombreEmpleado AS 'Empleado',
		cédula AS 'Identificación'
FROM empleado
WHERE idEmpleado = idE;
END;
//

-- -----------------------------------------------------
-- Procedimiento Actualizar
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE actualizarEmpleado (IN idE INT,
									 IN nombreE VARCHAR(40),
                                     IN cédulaE VARCHAR(20))
BEGIN
UPDATE empleado
SET
	nombreEmpleado = nombreE,
	cédula = cédulaE
WHERE idEmpleado = idE;
END;
//

-- -----------------------------------------------------
-- Procedimiento Borrar
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE borrarEmpleadoPorId (IN idE INT)
BEGIN
DELETE FROM empleado WHERE idEmpleado = idE;
END;
//
