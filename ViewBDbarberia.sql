#1
create view produtos_vendidos_empleado as 
select Nombre_empleado, Nombre_cliente, Nombre_producto  from venta_producto
join empleado on ID_empleado = ID_venta_producto
join cliente on ID_cliente = ID_venta_producto_cliente
join producto on ID_venta_producto = REF_producto;
select * from produtos_vendidos_empleado;
#2
create view cita_servicio as
select nombre_cliente, Nombre_empleado, Fecha_cita, Hora_cita from cliente
join cita on ID_cliente_cita = ID_cliente
join empleado_cita on ID_cita_empleado = ID_cita
join empleado on ID_empleado_cita = ID_empleado;
select * from cita_servicio;
#3
create view Proveedor_productoo as
select Nombre_proveedor, Nombre_producto from proveedor
join producto on ID_producto_proveedor = ID_proveedor;
select * from Proveedor_productoo;
#4
create view empleado_producto_utilizado as
select Nombre_empleado, Nombre_producto from empleado
join empleado_producto on ID_empleado_producto = ID_empleado
join producto on REF_producto = ID_producto_empleado;
select * from empleado_producto_utilizado;