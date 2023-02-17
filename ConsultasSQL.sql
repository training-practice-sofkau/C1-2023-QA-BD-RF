
-- Mostrar todas las reservas y sus citas asociadas:
SELECT r.id_reserva, c.id_cita, c.fecha, c.hora, c.descripcion
FROM Reserva r
LEFT JOIN Cita c ON r.id_reserva = c.id_reserva;


-- consulta que me permite saber  ver el cliente con sus datos personales el dia de su cita hora y la descripcion del 
-- servicio y su tipo de servicio y el empleado que lo atendio   -V
SELECT cliente.nombre_cliente, cliente.cedula_cliente, cliente.correo, cita.fecha, cita.hora, 
cita.descripcion, servicio.tipo, empleado.nombre_empleado
FROM servicio
INNER JOIN cita ON servicio.id_cita = cita.id_cita
INNER JOIN reserva ON cita.id_reserva = reserva.id_reserva
INNER JOIN cliente ON reserva.id_cliente = cliente.id_cliente
INNER JOIN historial ON servicio.id_servicio = historial.id_servicio
INNER JOIN empleado ON historial.id_empleado = empleado.id_empleado;



-- consulta que me permite ver el cliente con sus datos personales el dia de su cita hora 
-- y la descripcion del servicio y su tipo de servicio
SELECT cliente.nombre_cliente, cliente.cedula_cliente, cliente.correo, cita.fecha, cita.hora, cita.descripcion, servicio.tipo
FROM servicio
INNER JOIN cita ON servicio.id_cita = cita.id_cita
INNER JOIN reserva ON cita.id_reserva = reserva.id_reserva
INNER JOIN cliente ON reserva.id_cliente = cliente.id_cliente;



-- Esta consulta contará la cantidad de productos comprados por cada cliente
SELECT COUNT(*) AS cantidad_productos, cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto
FROM producto 
INNER JOIN compra ON producto.REF = compra.REF
INNER JOIN cliente ON compra.id_cliente = cliente.id_cliente 
INNER JOIN producto_factura ON producto.REF = producto_factura.REF
INNER JOIN factura ON producto_factura.id_factura = factura.id_factura
GROUP BY cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto;



-- Esta consulta me permite ver  los productos comprados por un cliente y el empleado que lo asesoro
SELECT cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto, empleado.nombre_empleado
FROM producto 
INNER JOIN compra ON producto.REF = compra.REF
INNER JOIN cliente ON compra.id_cliente = cliente.id_cliente 
INNER JOIN producto_factura ON producto.REF = producto_factura.REF
INNER JOIN factura ON producto_factura.id_factura = factura.id_factura
INNER JOIN empleado ON factura.id_empleado = empleado.id_empleado;



-- consulta que me permite conocer la reserva que tiene el cliente, el dia de la cita el empleado que le va a
-- realizar el servicio los insumos gastados y la factura del servicio   V
SELECT cliente.nombre_cliente, cliente.cedula_cliente, cliente.correo, cita.fecha, cita.hora, 
cita.descripcion, servicio.tipo, empleado.nombre_empleado, factura.valor, factura.fecha_factura
FROM servicio
INNER JOIN cita ON servicio.id_cita = cita.id_cita
INNER JOIN reserva ON cita.id_reserva = reserva.id_reserva
INNER JOIN cliente ON reserva.id_cliente = cliente.id_cliente
INNER JOIN historial ON servicio.id_servicio = historial.id_servicio
INNER JOIN empleado ON historial.id_empleado = empleado.id_empleado
INNER JOIN insumo_servicio ON servicio.id_servicio = insumo_servicio.id_servicio
INNER JOIN insumo ON insumo_servicio.id_insumo = insumo.id_insumo
INNER JOIN insumo_factura ON insumo.id_insumo = insumo_factura.id_insumo
INNER JOIN factura ON insumo_factura.id_factura = factura.id_factura;


-- consulta que me permite saber cual empleado a realizado mas 
-- servicios y me muestra solo el empleado con el numero mayor de servicios

SELECT empleado.nombre_empleado, COUNT(*) as cantidad_servicios
FROM historial
INNER JOIN empleado ON historial.id_empleado = empleado.id_empleado
GROUP BY empleado.nombre_empleado
ORDER BY cantidad_servicios DESC
LIMIT 1;


 -- consulta que me permite saber cual cliente es el que más ha asistido a servicios, podemos contar el número de 
 -- servicios que ha tenido cada cliente y luego ordenarlos en orden descendente.
SELECT cliente.nombre_cliente, COUNT(*) AS num_servicios
FROM cliente
INNER JOIN reserva ON cliente.id_cliente = reserva.id_cliente
INNER JOIN cita ON reserva.id_reserva = cita.id_reserva
INNER JOIN servicio ON cita.id_cita = servicio.id_cita
GROUP BY cliente.id_cliente
ORDER BY num_servicios DESC
LIMIT 1;


-- En esta consulta, ver las tablas de productos y proveedores,
-- utilizando la columna id_proveedor como clave de unión.
 -- Luego, se especifica en la cláusula WHERE el nombre del proveedor del cual se desean los productos.
SELECT producto.nombre_producto, proveedor.nombre_proveedor
FROM producto
INNER JOIN proveedor ON producto.id_proveedor = proveedor.id_proveedor
WHERE proveedor.nombre_proveedor = 'Proveedor 1';



-- Consulta que me permite obtener los nombres de los clientes mayores de 30 años podrías hacer

SELECT nombre_cliente AS "Clientes mayores"
FROM cliente
WHERE edad > 30;


