# CONSULTA 1: obtener el nombre del producto, precio de compra y precio de venta para calcular la ganancia neta por producto
SELECT REF, nombre, cantidad, precioCompra, precioVenta, NITProveedor, (precioVenta - precioCompra) AS ganacia_por_producto
FROM producto
ORDER BY precioCompra ASC;



# CONSULTA 2: Obtener la descripción de la cotización, la fecha de venta y el nombre del producto vendido:

SELECT cotizacion.descripcion as descripción_Cotizacion, venta.fecha, producto.nombre
FROM venta
INNER JOIN producto ON venta.idProducto = producto.REF
INNER JOIN cotizacion ON venta.idCotizacion = cotizacion.id;

#CONSULTA 3: la cantidad de ligas realizadas por todos los empleados en determinadas fechas.
SELECT empleado.nombre AS nombre_Empleado, COUNT(venta.liga) as total_ligas
FROM venta
JOIN cotizacion ON venta.idCotizacion = cotizacion.id
JOIN empleado ON cotizacion.idEmpleado = empleado.id
WHERE venta.fecha BETWEEN '2022-01-01' AND '2023-12-31'
GROUP BY empleado.nombre;


#CONSULTA 4: Obtener los empleados que tienen asignadas citas en un rango de fechas:
SELECT empleado.nombre as nombreEmpleado, COUNT(cita.id) as num_citas
FROM empleado
INNER JOIN servicioEmpleado ON servicioEmpleado.idEmpleado = empleado.id
INNER JOIN servicio ON servicio.id = servicioEmpleado.idServicio
INNER JOIN cita ON cita.id = servicio.idCita
WHERE cita.fechaSolicitda BETWEEN '2022-02-01' AND '2023-02-15'
GROUP BY empleado.nombre;

# CONSULTA 5: obtiene la lista de clientes con los empleados que atendieron durante la cotización.
SELECT cliente.nombre as nombre_cliente, empleado.nombre as nombre_empleado, telefonoCliente.telefono as telefono
FROM cotizacion
JOIN empleado ON cotizacion.idEmpleado = empleado.id
JOIN cliente ON cotizacion.idCliente = cliente.id
JOIN telefonoCliente ON telefonoCliente.idCliente = cliente.id;



#CONSULTA 6: obtener la lista de clientes atendidos y los isumos usados durante el servicio
SELECT cliente.nombre as nombre_cliente, cita.fechaSolicitda, servicio.descripción as descripción_Servicio, servicio.fecha as fecha_de_servicio, insumo.nombre as nombre_insumo, servicioinsumo.REFinsumo
FROM cliente
INNER JOIN cita ON cliente.id = cita.idCliente
INNER JOIN servicio ON cita.id = servicio.idCita
INNER JOIN servicioinsumo ON servicio.id = servicioinsumo.idServicio
INNER JOIN insumo ON servicioinsumo.REFinsumo = insumo.REF;

#CONSULTA 7: costo generado por el servicio realizado a un cliente

SELECT servicio.descripción, servicio.precio, cita.fechaSolicitda, cliente.nombre as cliente, cliente.correo
FROM servicio
INNER JOIN cita ON servicio.idCita = cita.id
INNER JOIN cliente ON cita.idCliente = cliente.id;

#CONSULTA 8: Obtener la cantidad de citas realizadas por el cliente, incluyendo su profesión ya que la barberia desea premiar al cliente con más citas pero con una temática relacionada a su profesión.
SELECT cliente.nombre, profesionCliente.profesion, COUNT(cita.id) AS cantidad_citas
FROM cliente
INNER JOIN profesionCliente ON cliente.id = profesionCliente.idCliente
INNER JOIN cita ON cliente.id = cita.idCliente
WHERE cita.fechaSolicitda = '2022-02-02'
GROUP BY cliente.nombre, profesionCliente.profesion;

#CONSULTA 9: obtener productos relacionados con proveedores
SELECT proveedor.nombre as nombre_proveedor, producto.nombre as nombre_producto, producto.precioCompra, producto.precioVenta, producto.cantidad
FROM producto
INNER JOIN proveedor ON producto.NITProveedor = proveedor.NIT;
#Consulta 10: obtner lista de productos proveeidos, con el respectivo precio de compra
SELECT proveedor.nombre AS nombre_proveedor, insumo.nombre AS nombre_insumo, insumo.precioCompra
FROM proveedor
INNER JOIN insumo ON proveedor.NIT = insumo.NITProveedor
GROUP BY proveedor.nombre, insumo.nombre;
 












