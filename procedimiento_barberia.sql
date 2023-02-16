DELIMITER //

CREATE PROCEDURE sp_citas_empleados_mes_actual()
BEGIN
  SELECT empleados.nombre, COUNT(citas.id) as citas_mes_actual
  FROM empleados
  JOIN citas ON empleados.id = citas.empleado_id
  WHERE MONTH(citas.fecha_hora) = MONTH(CURRENT_DATE())
  GROUP BY empleados.id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_total_servicios_empleado(IN empleado_id INT)
BEGIN
  SELECT COUNT(*) AS total_servicios
  FROM servicios
  WHERE empleado_id = empleado_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_cantidad_productos_proveedor(IN proveedor VARCHAR(50))
BEGIN
  SELECT SUM(cantidad) AS total_productos
  FROM productos
  WHERE proveedor = proveedor;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_clientes_compras_mes_actual()
BEGIN
  SELECT clientes.nombre, SUM(ventas.liga_ganancia) AS monto_total_compras
  FROM clientes
  JOIN ventas ON clientes.id = ventas.cliente_id
  WHERE MONTH(ventas.fecha) = MONTH(CURRENT_DATE())
  GROUP BY clientes.id;
END //

DELIMITER ;
