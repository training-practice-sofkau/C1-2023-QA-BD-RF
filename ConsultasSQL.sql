
-- Mostrar todas las reservas y sus citas asociadas:
SELECT r.id_reserva, c.id_cita, c.fecha, c.hora, c.descripcion
FROM Reserva r
LEFT JOIN Cita c ON r.id_reserva = c.id_reserva;


-- consulta que me permite saber  ver el cliente con sus datos personales el dia de su cita hora y la descripcion del servicio y su tipo de servicio y el empleado que lo atendio
SELECT cliente.nombre_cliente, cliente.cedula_cliente, cliente.correo, cita.fecha, cita.hora, cita.descripcion, servicio.tipo, empleado.nombre_empleado
FROM servicio
INNER JOIN cita ON servicio.id_cita = cita.id_cita
INNER JOIN reserva ON cita.id_reserva = reserva.id_reserva
INNER JOIN cliente ON reserva.id_cliente = cliente.id_cliente
INNER JOIN historial ON servicio.id_servicio = historial.id_servicio
INNER JOIN empleado ON historial.id_empleado = empleado.id_empleado;





-- consulta que me permite ver el cliente con sus datos personales el dia de su cita hora y la descripcion del servicio y su tipo de servicio
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


SELECT 

