-- -----------------------------------------------------
-- Vistas Importantes
-- -----------------------------------------------------
USE ocochosBarberia;

-- -----------------------------------------------------
-- Visualizar las especialidades de cada empleado
-- -----------------------------------------------------
CREATE VIEW especialidadesEmpleado AS
SELECT
		e.nombreEmpleado AS 'Empleado', 
		GROUP_CONCAT(es.especialidad SEPARATOR ', ') AS 'Especialidad(es)'
FROM empleado AS e
INNER JOIN especialidad AS es
ON e.idEmpleado = es.idEmpleadoE
GROUP BY e.idEmpleado;

-- -----------------------------------------------------
-- Visualizar los procedimientos realizados en un
-- servicio
-- -----------------------------------------------------
CREATE VIEW procedimientosEnServicio AS
SELECT
		s.idServicio AS 'Servicio N°', 
		GROUP_CONCAT(p.tipo SEPARATOR ', ') AS 'Procedimiento(s)'
FROM servicio AS s
INNER JOIN realizar AS r
ON s.idServicio = r.idServicioR
INNER JOIN procedimiento AS p
ON r.tipoR = p.tipo
GROUP BY s.idServicio;

-- -----------------------------------------------------
-- Visualizar los insumos usados en un servicio
-- -----------------------------------------------------
CREATE VIEW insumosEnServicio AS
SELECT
		s.idServicio AS 'Servicio N°', 
		GROUP_CONCAT(i.nombreInsumo SEPARATOR ', ') AS 'Insumo(s)',
		GROUP_CONCAT(i.cantidadInsumo SEPARATOR ' | ') AS 'Unidad(es)'
FROM servicio AS s
INNER JOIN usar AS u
ON s.idServicio = u.idServicioU
INNER JOIN insumo AS i
ON u.REFInsumoU = i.REFInsumo
GROUP BY s.idServicio;
-- -----------------------------------------------------
-- Visualizar la cantidad total de ligas que se ha
-- ganado un empleado
-- -----------------------------------------------------
CREATE VIEW ligaTotalEmpleado AS
SELECT 
		e.nombreEmpleado AS 'Empleado',
        SUM(v.liga) AS 'La liga total'
FROM empleado AS e
INNER JOIN venta AS v
ON e.idEmpleado = v.idEmpleadoV;

-- -----------------------------------------------------
-- Visualizar las citas que tiene agendadas cada cliente
-- -----------------------------------------------------
CREATE VIEW citasCliente AS
SELECT
		c.nombreCliente AS 'Cliente', 
		GROUP_CONCAT(ci.fechaCita SEPARATOR ' | ') AS 'Fecha(s) para cita(s)'
FROM cliente AS c
INNER JOIN cita AS ci
ON c.idCliente = ci.idClienteC
GROUP BY c.idCliente;

-- -----------------------------------------------------
-- Visualizar el tiempo total trabajado por cada
-- empleado
-- -----------------------------------------------------
CREATE VIEW tiempoTotalEmpleado AS
SELECT 
		e.nombreEmpleado AS 'Empleado',
        SUM(s.duracion) AS 'Tiempo total laborado'
FROM empleado AS e
INNER JOIN servicio AS s
ON e.idEmpleado = s.idEmpleadoS;
