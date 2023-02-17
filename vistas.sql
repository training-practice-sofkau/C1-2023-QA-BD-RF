
#vista 1
CREATE VIEW cliente_servicio_insumo AS

SELECT cliente.nombre AS nombre_cliente, cita.fechaSolicitda, servicio.descripción 
AS descripción_Servicio, servicio.fecha AS fecha_de_servicio, insumo.nombre 
AS nombre_insumo, servicioinsumo.REFinsumo
FROM cliente
INNER JOIN cita ON cliente.id = cita.idCliente
INNER JOIN servicio ON cita.id = servicio.idCita
INNER JOIN servicioinsumo ON servicio.id = servicioinsumo.idServicio
INNER JOIN insumo ON servicioinsumo.REFinsumo = insumo.REF;

SELECT * FROM cliente_servicio_insumo;

#vista 2: Cotizaciones que finalizarón con exito de compra.
CREATE VIEW ventaDeProducto AS
SELECT cliente.nombre AS nombre_cliente, cotizacion.id AS id_cotizacion, venta.valorTotal,
       empleado.nombre AS atendido_por
FROM cliente
INNER JOIN cotizacion ON cliente.id = cotizacion.idCliente
INNER JOIN venta ON cotizacion.id = venta.idCotizacion
INNER JOIN empleado ON cotizacion.idEmpleado = empleado.id;

SELECT * FROM ventaDeProducto;

#Vista 3: la cantidad de ligas realizadas por los empleados detrmina la catidad de ventas asistidas durante una cotización.
CREATE VIEW ventas_realizadas_por_Empleado AS
SELECT empleado.nombre AS nombre_Empleado, COUNT(venta.liga) as total_ligas
FROM venta
JOIN cotizacion ON venta.idCotizacion = cotizacion.id
JOIN empleado ON cotizacion.idEmpleado = empleado.id
WHERE venta.fecha BETWEEN '2022-01-01' AND '2023-12-31'
GROUP BY empleado.nombre;

SELECT * FROM ventas_realizadas_por_Empleado;

# vista 4: Costo generada por un servicio prestado
CREATE VIEW costo_servicio_cliente AS
SELECT servicio.id, servicio.descripción, servicio.precio, cita.fechaSolicitda, cliente.nombre as cliente, cliente.correo
FROM servicio
INNER JOIN cita ON servicio.idCita = cita.id
INNER JOIN cliente ON cita.idCliente = cliente.id;

SELECT * FROM costo_servicio_cliente;




