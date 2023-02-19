CREATE VIEW VISTA_CLIENTE_EMPLEADO_SERVICIO AS
SELECT cliente.nombre_cliente, cliente.cedula_cliente, cliente.correo, cita.fecha, cita.hora, 
cita.descripcion, servicio.tipo, empleado.nombre_empleado
FROM servicio
INNER JOIN cita ON servicio.id_cita = cita.id_cita
INNER JOIN reserva ON cita.id_reserva = reserva.id_reserva
INNER JOIN cliente ON reserva.id_cliente = cliente.id_cliente
INNER JOIN historial ON servicio.id_servicio = historial.id_servicio
INNER JOIN empleado ON historial.id_empleado = empleado.id_empleado;


CREATE VIEW VISTA_CLIENTE_SERVICIO_FACTURA AS
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


CREATE VIEW CLIENTE_MAS_VISITAS AS
SELECT cliente.nombre_cliente, COUNT(*) AS num_servicios
FROM cliente
INNER JOIN reserva ON cliente.id_cliente = reserva.id_cliente
INNER JOIN cita ON reserva.id_reserva = cita.id_reserva
INNER JOIN servicio ON cita.id_cita = servicio.id_cita
GROUP BY cliente.id_cliente
ORDER BY num_servicios DESC
LIMIT 1;


CREATE VIEW CLIENTE_EMPLEADO_ASESORA_VENTA AS 
SELECT cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto, empleado.nombre_empleado
FROM producto 
INNER JOIN compra ON producto.REF = compra.REF
INNER JOIN cliente ON compra.id_cliente = cliente.id_cliente 
INNER JOIN producto_factura ON producto.REF = producto_factura.REF
INNER JOIN factura ON producto_factura.id_factura = factura.id_factura
INNER JOIN empleado ON factura.id_empleado = empleado.id_empleado;


CREATE VIEW PRODUCTOS_PROVEEDOR AS
SELECT producto.nombre_producto, proveedor.nombre_proveedor
FROM producto
INNER JOIN proveedor ON producto.id_proveedor = proveedor.id_proveedor
WHERE proveedor.nombre_proveedor = 'Proveedor 1';


CREATE VIEW PRODUCTOS_COMPRADO_CLIENTE AS
SELECT COUNT(*) AS cantidad_productos, cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto
FROM producto 
INNER JOIN compra ON producto.REF = compra.REF
INNER JOIN cliente ON compra.id_cliente = cliente.id_cliente 
INNER JOIN producto_factura ON producto.REF = producto_factura.REF
INNER JOIN factura ON producto_factura.id_factura = factura.id_factura
GROUP BY cliente.nombre_cliente, factura.valor, factura.fecha_factura, producto.nombre_producto;
