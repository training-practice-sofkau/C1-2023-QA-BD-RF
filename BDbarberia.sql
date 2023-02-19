create database Barberia;
use barberia;

create table producto(
REF_producto varchar(50) primary key,
Nombre_producto varchar(50),
Precio_producto varchar(50),
Cantidad_producto varchar(50),
ID_producto_proveedor varchar(50),
foreign key (ID_producto_proveedor) references proveedor(ID_proveedor)
);

create table producto_venta_producto(
ID_producto_venta varchar(50) primary key,
ID_producto_venta_producto varchar(50),
foreign key (ID_producto_venta) references producto(REF_producto),
foreign key (ID_producto_venta_producto) references venta_producto(ID_venta_producto)
);


create table empleado_producto(
ID_empleado_producto varchar(50) primary key,
ID_producto_empleado varchar(50),
foreign key (ID_empleado_producto) references empleado(ID_empleado),
foreign key (ID_producto_empleado) references producto(REF_producto)
);


create table empleado(
ID_empleado varchar(50) primary key,
Nombre_empleado varchar(50),
Cedula_empleado varchar(50)
);

create table especialidad_empleado(
Especialidad_empleado varchar(50) primary key,
ID_empleado_especialidad varchar(50),
foreign key (ID_empleado_especialidad) references empleado(ID_empleado)
);

create table cliente(
ID_cliente varchar(50) primary key,
Nombre_cliente varchar(50),
Cedula_cliente varchar(50),
Direccion_cliente varchar(50),
Edad_cliente varchar(50)
);

create table telefono_cliente(
Telefono_cliente varchar(50) primary key,
ID_cliente_telefono varchar(50),
foreign key (ID_cliente_telefono) references cliente(ID_cliente)
);


create table cita(
ID_cita varchar(50) primary key,
Hora_cita varchar(50),
Fecha_cita varchar(50),
ID_cliente_cita varchar(50),
foreign key (ID_cliente_cita) references cliente(ID_cliente)
);

create table empleado_cita(
ID_empleado_cita varchar(50) primary key,
ID_cita_empleado varchar(50),
foreign key (ID_empleado_cita) references empleado(ID_empleado),
foreign key (ID_cita_empleado) references cita(ID_cita)
);

drop table empleado_cita;



create table historial_servicio(
ID_servicio varchar(50) primary key,
Duracion_servicio varchar(50),
ID_servicio_cita varchar(50),
foreign key (ID_servicio_cita) references cita(ID_cita)
);

create table proveedor(
ID_proveedor varchar(50) primary key,
Nombre_proveedor varchar(50),
Telefono_proveedor varchar(50),
Direccion_proveedor varchar(50)
);


create table venta_producto(
ID_venta_producto varchar(50) primary key,
Fecha_venta_producto varchar(50),
ID_venta_producto_empleado varchar(50),
ID_venta_producto_cliente varchar(50),
foreign key (ID_venta_producto_empleado) references empleado(ID_empleado),
foreign key (ID_venta_producto_cliente) references cliente(ID_cliente)
);
