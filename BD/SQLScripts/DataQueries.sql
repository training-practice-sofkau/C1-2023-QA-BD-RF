-- -----------------------------------------------------
-- Sentencias de visualización de la información
-- -----------------------------------------------------
USE ocochosBarberia;

-- -----------------------------------------------------
-- Visualizar stock de productos
-- -----------------------------------------------------
SELECT
		REFProducto AS 'Referencia',
        nombreProducto AS 'Producto',
        cantidadProducto AS 'Unidades',
        precioProducto AS 'Precio'
FROM producto;

-- -----------------------------------------------------
-- Visualizar stock de insumos
-- -----------------------------------------------------
SELECT
		REFInsumo AS 'Referencia',
        nombreInsumo AS 'Producto',
        cantidadProducto AS 'Unidades'
FROM insumo;

-- -----------------------------------------------------
-- Visualizar todas las citas agendadas
-- -----------------------------------------------------
SELECT
		idCita AS 'Cita N°',
        fechaCita AS 'Agendada para el',
        c.nombreCliente AS 'Cliente'
FROM cita, cliente AS c
WHERE idClienteC = c.idCliente;

-- -----------------------------------------------------
-- Visualizar servicios realizados
-- -----------------------------------------------------
SELECT
		idServicio AS 'Servicio N°',
        duración AS 'Duración',
        fechaServicio AS 'Realizado en',
        descripción AS 'Descripción'
FROM servicio;

-- -----------------------------------------------------
-- Visualizar empleados en nomina
-- -----------------------------------------------------
SELECT
		nombreEmpleado AS 'Empleado',
        cédula AS 'Identificación'
FROM empleado;

-- -----------------------------------------------------
-- Visualizar clientes registrados
-- -----------------------------------------------------
SELECT
		nombreCliente AS 'Cliente',
        correo AS 'Correo',
        teléfonoCliente AS 'Teléfono'
FROM cliente;

-- -----------------------------------------------------
-- Visualizar proveedores de productos e insumos
-- -----------------------------------------------------
SELECT
		nombreProveedor AS 'Proveedor',
        teléfonoProveedor AS 'Teléfono'
FROM proveedor;

-- -----------------------------------------------------
-- Visualizar procedimientos ofrecidos actualmente
-- -----------------------------------------------------
SELECT
		tipo AS 'Ofrecemos',
        precioProcedimiento AS 'Precio'
FROM procedimiento;

-- -----------------------------------------------------
-- Visualizar la cantidad de ventas realizadas
-- -----------------------------------------------------
SELECT COUNT(idVenta) AS 'Cantidad de ventas realizadas'
FROM venta;

-- -----------------------------------------------------
-- Visualizar los empleados y sus citas asignadas
-- -----------------------------------------------------
SELECT nombreEmpleado AS 'Empleado', 
GROUP_CONCAT(c.idCita SEPARATOR ' | ') AS 'Cita(s)'
FROM empleado
INNER JOIN cita AS c ON idEmpleado = c.idEmpleadoC  
GROUP BY idEmpleado;
