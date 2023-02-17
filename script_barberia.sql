-- Creación de la base de datos barbería
CREATE DATABASE db_barberia; 

-- Indica cuál será la BD a la cual se le aplicarán las siguientes consultas: 
USE db_barberia;

-- Creación tabla de servicio 
CREATE TABLE tb_servicio(
id_servicio VARCHAR(10) NOT NULL, 
nombre_servicio VARCHAR(45) NOT NULL,
descripcion VARCHAR(200) NOT NULL, 
valor INT NOT NULL,
PRIMARY KEY(id_servicio)
);

-- Creación de tabla cliente
CREATE TABLE tb_cliente(
id_cliente VARCHAR(10) NOT NULL, 
nombre_cliente VARCHAR(25) NOT NULL, 
apellido_cliente VARCHAR(25) NOT NULL,
fecha_nacimiento VARCHAR(20) NOT NULL, 
correo VARCHAR(30) NOT NULL,
direccion VARCHAR(50) NOT NULL,
PRIMARY KEY(id_cliente)
);

-- Creación tabla telefono_cliente
CREATE TABLE tb_telefono_cliente(
id_telefono_cliente VARCHAR(10) NOT NULL, 
telefono VARCHAR(15) NOT NULL, 
PRIMARY KEY(id_telefono_cliente, telefono),
FOREIGN KEY(id_telefono_cliente) REFERENCES tb_cliente(id_cliente)
);

-- Creación de la tabla registro venta
CREATE TABLE tb_registro_venta(
id_registro_venta VARCHAR(10) NOT NULL, 
valor INT NOT NULL, 
fecha VARCHAR(20) NOT NULL, 
id_cliente VARCHAR(10) NOT NULL, 
PRIMARY KEY(id_registro_venta),
FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente)
);

-- Creación de la tabla proveedor
CREATE TABLE tb_proveedor(
id_proveedor VARCHAR(10) NOT NULL,
nombre_proveedor VARCHAR(45) NOT NULL, 
direccion VARCHAR(50) NOT NULL,
PRIMARY KEY(id_proveedor)
);

-- Creación tabla de telefono_proveedor
CREATE TABLE tb_telefono_proveedor(
id_telefono_proveedor VARCHAR(10) NOT NULL, 
telefono VARCHAR(15) NOT NULL,
PRIMARY KEY(id_telefono_proveedor, telefono),
FOREIGN KEY(id_telefono_proveedor) REFERENCES tb_proveedor(id_proveedor)
);

-- Creación de la tabla producto
CREATE TABLE tb_producto(
id_producto VARCHAR(10) NOT NULL,
nombre_producto VARCHAR(30) NOT NULL, 
cantidad_disponible INT NOT NULL, 
precio INT NOT NULL, 
id_proveedor VARCHAR(10) NOT NULL,
PRIMARY KEY(id_producto),
FOREIGN KEY(id_proveedor) REFERENCES tb_proveedor(id_proveedor)
);

-- Creación de la tabla compra
CREATE TABLE tb_compra(
id_compra VARCHAR(10) NOT NULL, 
valor INT NOT NULL, 
fecha VARCHAR(20) NOT NULL, 
PRIMARY KEY(id_compra)
);

-- Creación de la tabla detalle compra producto 
CREATE TABLE dll_compra_producto(
id_compra_producto VARCHAR(10) NOT NULL, 
id_compra VARCHAR(10) NOT NULL, 
id_producto VARCHAR(10) NOT NULL, 
unidades INT NOT NULL,
valor INT NOT NULL,
PRIMARY KEY(id_compra_producto),
FOREIGN KEY(id_compra) REFERENCES tb_compra(id_compra),
FOREIGN KEY(id_producto) REFERENCES tb_producto(id_producto)
);

-- Creación de la tabla detalle venta producto 
CREATE TABLE dll_venta_producto(
id_venta_producto VARCHAR(10) NOT NULL, 
id_registro_venta VARCHAR(10) NOT NULL, 
ref_producto VARCHAR(10) NOT NULL, 
unidades INT NOT NULL,
valor INT NOT NULL,
PRIMARY KEY(id_venta_producto),
FOREIGN KEY(id_registro_venta) REFERENCES tb_registro_venta(id_registro_venta),
FOREIGN KEY(ref_producto) REFERENCES tb_producto(id_producto)
);

-- Creación tabla empleado 
CREATE TABLE tb_empleado(
id_empleado VARCHAR(10) NOT NULL, 
nombre_empleado VARCHAR(25) NOT NULL, 
apellido_empleado VARCHAR(25) NOT NULL,
especialidad VARCHAR(30) NOT NULL,
id_servicio VARCHAR(10) NOT NULL,
PRIMARY KEY(id_empleado), 
FOREIGN KEY(id_servicio) REFERENCES tb_servicio(id_servicio)
);

-- Creación tabla cita 
CREATE TABLE tb_cita(
id_cita VARCHAR(10) NOT NULL, 
fecha VARCHAR(20) NOT NULL, 
hora VARCHAR(7) NOT NULL, 
estado VARCHAR(10) NOT NULL,
id_cliente VARCHAR(10) NOT NULL,
id_empleado VARCHAR(10)NOT NULL, 
PRIMARY KEY(id_cita),
FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente),
FOREIGN KEY(id_empleado) REFERENCES tb_empleado(id_empleado)
);

-- Creación tabla historial servicio 
CREATE TABLE tb_historial_servicio(
id_historial_servicio VARCHAR(10) NOT NULL, 
producto_consumido VARCHAR(30) NOT NULL, 
duracion VARCHAR(15) NOT NULL, 
fecha VARCHAR(20) NOT NULL,
id_empleado VARCHAR(10) NOT NULL,
id_servicio VARCHAR(10) NOT NULL,
PRIMARY KEY(id_historial_servicio), 
FOREIGN KEY(id_empleado) REFERENCES tb_empleado(id_empleado),
FOREIGN KEY(id_servicio) REFERENCES tb_servicio(id_servicio)
); 





