SELECT e.nombre, COUNT(s.ID) AS cantidad_servicios
FROM empleados e
LEFT JOIN servicios s ON e.ID = s.empleado_id
GROUP BY e.ID
ORDER BY cantidad_servicios DESC;

SELECT c.nombre
FROM clientes c
JOIN ventas v ON c.ID = v.cliente_id
JOIN productos p ON v.producto_id = p.REF
WHERE c.edad > 30;

SELECT nombre
FROM productos
WHERE cantidad = 0;

SELECT proveedor
FROM productos
GROUP BY proveedor
ORDER BY SUM(cantidad) DESC
LIMIT 1;

SELECT e.nombre, COUNT(v.producto_id) AS cantidad_productos_vendidos
FROM empleados e
LEFT JOIN ventas v ON e.ID = v.empleado_id
GROUP BY e.ID
ORDER BY cantidad_productos_vendidos DESC;

SELECT YEAR(s.fecha) AS year, MONTH(s.fecha)
AS month, COUNT(s.ID) AS cantidad_servicios
FROM servicios s
WHERE YEAR(s.fecha) = 2022
GROUP BY YEAR(s.fecha), MONTH(s.fecha)
ORDER BY year, month;

SELECT SUM(precio) AS total_ganado
FROM ventas v
JOIN productos p ON v.producto_id = p.REF
WHERE MONTH(v.fecha) = 1 AND YEAR(v.fecha) = 2023;

SELECT e.nombre, COUNT(s.ID) AS cantidad_servicios, 
SUM(v.liga_ganancia) AS total_ganado
FROM empleados e
LEFT JOIN servicios s ON e.ID = s.empleado_id
LEFT JOIN ventas v ON e.ID = v.empleado_id
WHERE YEAR(s.fecha) = 2022 OR YEAR(v.fecha) = 2022
GROUP BY e.ID;

SELECT e.nombre, COUNT(c.ID) AS cantidad_citas
FROM empleados e
JOIN citas c ON e.ID = c.empleado_id
WHERE MONTH(c.fecha_hora) = 12 AND YEAR(c.fecha_hora) = 2023
GROUP BY e.ID
ORDER BY cantidad_citas DESC;

SELECT DISTINCT c.nombre 
FROM clientes c
INNER JOIN servicios s ON c.ID = s.cliente_id
WHERE c.edad > 50;
