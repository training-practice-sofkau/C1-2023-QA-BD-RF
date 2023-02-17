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

