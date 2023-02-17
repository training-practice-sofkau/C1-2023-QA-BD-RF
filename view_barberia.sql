CREATE VIEW clientes_mayores_servicios AS
SELECT c.nombre, c.edad, s.productos_consumidos, s.fecha
FROM clientes c
INNER JOIN servicios s ON c.ID = s.cliente_id
WHERE c.edad > 50;

CREATE VIEW empleados_especialidades AS
SELECT e.nombre, e.especialidad
FROM empleados e;

CREATE VIEW servicios_empleados AS
SELECT e.nombre AS empleado, COUNT(s.ID) AS num_servicios
FROM empleados e
LEFT JOIN servicios s ON e.ID = s.empleado_id
GROUP BY e.ID;

CREATE VIEW productos_disponibles AS
SELECT p.nombre, p.cantidad
FROM productos p;

CREATE VIEW ventas_empleados AS
SELECT e.nombre AS empleado, SUM(v.liga_ganancia) AS ganancias
FROM empleados e
LEFT JOIN ventas v ON e.ID = v.empleado_id
GROUP BY e.ID;

CREATE VIEW citas_empleados AS
SELECT e.nombre AS empleado, COUNT(c.ID) AS num_citas
FROM empleados e
LEFT JOIN citas c ON e.ID = c.empleado_id
GROUP BY e.ID;