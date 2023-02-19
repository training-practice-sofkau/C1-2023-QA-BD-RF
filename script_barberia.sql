-- Creación de la base de datos barbería
CREATE DATABASE db_barberia; 

-- Indica cuál será la BD a la cual se le aplicarán las siguientes consultas: 
USE db_barberia;

-- Creación tabla de servicio 
CREATE TABLE tb_servicio(
id_servicio VARCHAR(200) NOT NULL, 
nombre_servicio VARCHAR(200) NOT NULL,
descripcion VARCHAR(200) NOT NULL, 
valor INT NOT NULL,
PRIMARY KEY(id_servicio)
);

-- Creación de tabla cliente
CREATE TABLE tb_cliente(
id_cliente VARCHAR(200) NOT NULL, 
nombre_cliente VARCHAR(200) NOT NULL, 
apellido_cliente VARCHAR(200) NOT NULL,
fecha_nacimiento VARCHAR(200) NOT NULL, 
correo VARCHAR(200) NOT NULL,
direccion VARCHAR(200) NOT NULL,
PRIMARY KEY(id_cliente)
);

-- Creación tabla telefono_cliente
CREATE TABLE tb_telefono_cliente(
id_telefono_cliente VARCHAR(200) NOT NULL, 
telefono VARCHAR(200) NOT NULL, 
PRIMARY KEY(id_telefono_cliente, telefono),
FOREIGN KEY(id_telefono_cliente) REFERENCES tb_cliente(id_cliente)
);

-- Creación de la tabla registro venta
CREATE TABLE tb_registro_venta(
id_registro_venta VARCHAR(200) NOT NULL, 
valor INT NOT NULL, 
fecha VARCHAR(200) NOT NULL, 
id_cliente VARCHAR(200) NOT NULL, 
PRIMARY KEY(id_registro_venta),
FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente)
);

-- Creación de la tabla proveedor
CREATE TABLE tb_proveedor(
id_proveedor VARCHAR(200) NOT NULL,
nombre_proveedor VARCHAR(200) NOT NULL, 
direccion VARCHAR(200) NOT NULL,
PRIMARY KEY(id_proveedor)
);

-- Creación tabla de telefono_proveedor
CREATE TABLE tb_telefono_proveedor(
id_telefono_proveedor VARCHAR(200) NOT NULL, 
telefono VARCHAR(200) NOT NULL,
PRIMARY KEY(id_telefono_proveedor, telefono),
FOREIGN KEY(id_telefono_proveedor) REFERENCES tb_proveedor(id_proveedor)
);

-- Creación de la tabla producto
CREATE TABLE tb_producto(
id_producto VARCHAR(200) NOT NULL,
nombre_producto VARCHAR(200) NOT NULL, 
cantidad_disponible INT NOT NULL, 
precio INT NOT NULL, 
id_proveedor VARCHAR(200) NOT NULL,
PRIMARY KEY(id_producto),
FOREIGN KEY(id_proveedor) REFERENCES tb_proveedor(id_proveedor)
);

-- Creación de la tabla compra
CREATE TABLE tb_compra(
id_compra VARCHAR(200) NOT NULL, 
valor INT NOT NULL, 
fecha VARCHAR(200) NOT NULL, 
PRIMARY KEY(id_compra)
);

-- Creación de la tabla detalle compra producto 
CREATE TABLE dll_compra_producto(
id_compra_producto VARCHAR(200) NOT NULL, 
id_compra VARCHAR(200) NOT NULL, 
id_producto VARCHAR(200) NOT NULL, 
unidades INT NOT NULL,
valor INT NOT NULL,
PRIMARY KEY(id_compra_producto),
FOREIGN KEY(id_compra) REFERENCES tb_compra(id_compra),
FOREIGN KEY(id_producto) REFERENCES tb_producto(id_producto)
);

-- Creación de la tabla detalle venta producto 
CREATE TABLE dll_venta_producto(
id_venta_producto VARCHAR(200) NOT NULL, 
id_registro_venta VARCHAR(200) NOT NULL, 
ref_producto VARCHAR(200) NOT NULL, 
unidades INT NOT NULL,
valor INT NOT NULL,
PRIMARY KEY(id_venta_producto),
FOREIGN KEY(id_registro_venta) REFERENCES tb_registro_venta(id_registro_venta),
FOREIGN KEY(ref_producto) REFERENCES tb_producto(id_producto)
);

-- Creación tabla empleado 
CREATE TABLE tb_empleado(
id_empleado VARCHAR(200) NOT NULL, 
nombre_empleado VARCHAR(200) NOT NULL, 
apellido_empleado VARCHAR(200) NOT NULL,
especialidad VARCHAR(200) NOT NULL,
id_servicio VARCHAR(200) NOT NULL,
PRIMARY KEY(id_empleado), 
FOREIGN KEY(id_servicio) REFERENCES tb_servicio(id_servicio)
);

-- Creación tabla cita 
CREATE TABLE tb_cita(
id_cita VARCHAR(200) NOT NULL, 
fecha VARCHAR(200) NOT NULL, 
hora VARCHAR(200) NOT NULL, 
estado VARCHAR(200) NOT NULL,
id_cliente VARCHAR(200) NOT NULL,
id_empleado VARCHAR(200)NOT NULL, 
PRIMARY KEY(id_cita),
FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente),
FOREIGN KEY(id_empleado) REFERENCES tb_empleado(id_empleado)
);

-- Creación tabla historial servicio 
CREATE TABLE tb_historial_servicio(
id_historial_servicio VARCHAR(200) NOT NULL, 
producto_consumido VARCHAR(200) NOT NULL, 
duracion VARCHAR(200) NOT NULL, 
fecha VARCHAR(200) NOT NULL,
id_empleado VARCHAR(200) NOT NULL,
id_servicio VARCHAR(200) NOT NULL,
PRIMARY KEY(id_historial_servicio), 
FOREIGN KEY(id_empleado) REFERENCES tb_empleado(id_empleado),
FOREIGN KEY(id_servicio) REFERENCES tb_servicio(id_servicio)
); 

-- Procedimientos almacenados 
-- 1. Permite registrar un nuevo proveedor
DELIMITER //
CREATE PROCEDURE registrar_proveedor(
IN id_proveedor_proc VARCHAR(200),
IN nombre_proveedor_proc VARCHAR(200),
IN direccion_proc VARCHAR(200)
)
BEGIN 
INSERT INTO tb_proveedor(id_proveedor, nombre_proveedor, direccion)
VALUES (id_proveedor_proc, nombre_proveedor_proc, direccion_proc);
END 
//DELIMITER ;

-- 2. Permite registrar un nuevo producto 
DELIMITER //
CREATE PROCEDURE registrar_producto(
IN id_producto_proc VARCHAR(200),
IN nombre_producto_proc VARCHAR(200), 
IN cantidad_disponible_proc INT, 
IN precio_proc INT, 
IN id_proveedor_proc VARCHAR(200)
)
BEGIN 
INSERT INTO tb_producto(id_producto, nombre_producto, cantidad_disponible, precio, id_proveedor)
VALUES (id_producto_proc, nombre_producto_proc, cantidad_disponible_proc, precio_proc, id_proveedor_proc);
END 
//DELIMITER ;

-- 3. Permite registrar un nuevo cliente 
DELIMITER //
CREATE PROCEDURE registrar_cliente(
IN id_cliente_proc VARCHAR(200), 
IN nombre_cliente_proc VARCHAR(200), 
IN apellido_cliente_proc VARCHAR(200),
IN fecha_nacimiento_proc VARCHAR(200), 
IN correo_proc VARCHAR(200),
IN direccion_proc VARCHAR(200) 
)
BEGIN 
INSERT INTO tb_cliente(id_cliente, nombre_cliente, apellido_cliente, fecha_nacimiento, correo, direccion)
VALUES (id_cliente_proc, nombre_cliente_proc, apellido_cliente_proc, fecha_nacimiento_proc, correo_proc, direccion_proc);
END 
//DELIMITER ;

-- 4. Permite registrar un nuevo empleado (barbero)
DELIMITER //
CREATE PROCEDURE registrar_empleado(
IN id_empleado_proc VARCHAR(200), 
IN nombre_empleado_proc VARCHAR(200), 
IN apellido_empleado_proc VARCHAR(200),
IN especialidad_proc VARCHAR(200),
IN id_servicio_proc VARCHAR(200)
)
BEGIN 
INSERT INTO tb_empleado(id_empleado, nombre_empleado, apellido_empleado, especialidad, id_servicio)
VALUES (id_empleado_proc, nombre_empleado_proc, apellido_empleado_proc, especialidad_proc, id_servicio_proc);
END 
//DELIMITER ;

-- 1er. Trigger 
DELIMITER //
CREATE TRIGGER triggerCompras BEFORE INSERT ON dll_compra_producto
FOR EACH ROW 
BEGIN
UPDATE tb_producto SET cantidad_disponible = cantidad_disponible + NEW.unidades 
WHERE id_producto = NEW.id_producto;  
END
//DELIMITER ;

INSERT INTO dll_compra_producto()
VALUES ('034135', '1000000', '0000000001', 2, 2102);

-- 2do. trigger
DELIMITER //
CREATE TRIGGER triggerVentas BEFORE INSERT ON dll_venta_producto
FOR EACH ROW 
BEGIN
UPDATE tb_producto SET cantidad_disponible = cantidad_disponible - NEW.unidades 
WHERE id_producto = NEW.ref_producto;  
END
//DELIMITER ;

INSERT INTO dll_venta_producto()
VALUES ('03413591', '1000001', '0000000002', 1, 23157);

SELECT *
FROM tb_producto; 
-- 3er. trigger
DELIMITER //
CREATE TRIGGER prevenir_remover_producto BEFORE DELETE ON tb_producto
FOR EACH ROW
BEGIN
	DECLARE veces_vendido INT; -- Declaramos una variable de tipo entero
	SELECT COUNT(*) INTO veces_vendido FROM dll_venta_producto WHERE ref_producto = OLD.id_producto;
    IF veces_vendido > 0 THEN
		-- La palabra reservada SIGNAL le dice a mysql que no continue con la ejecución y que
        -- arroje un error
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No puedes eliminar este producto por que ya tiene ventas.';
    END IF;
END
//DELIMITER // ; 
Delete from tb_producto WHERE id_producto = '0000000003';

-- 4to. trigger
DELIMITER //  
CREATE TRIGGER prevenir_citas_dobles BEFORE INSERT ON tb_cita
FOR EACH ROW
BEGIN
	DECLARE citas_duplicadas INT;
    SELECT 
		COUNT(*) INTO citas_duplicadas 
        FROM tb_cita
        WHERE 
            id_empleado = NEW.id_empleado AND
            fecha = NEW.fecha AND
            hora = NEW.hora;
	IF citas_duplicadas > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "La cita está duplicada";
	END IF; 
END
//DELIMITER ;

INSERT INTO tb_cita(id_cita, fecha, hora, estado, id_cliente, id_empleado) 
	VALUES ('12012010', '08/09/1973', '3', 'activa', '1000004', '1000004');

-- Consultas que permiten ver la información de cada tabla o de varias tablas. 
-- Consulta #1. Mostrar todos los empleados que trabajan en la barbería
SELECT id_empleado AS "Cédula", CONCAT(nombre_empleado, " ",apellido_empleado) AS "Nombre completo empleado" 
FROM tb_empleado; 

-- Consulta #2. Mostrar todos los clientes de la barbería y su localidad. 
SELECT id_cliente AS "Cédula cliente", CONCAT(nombre_cliente, apellido_cliente) AS "Nombre completo", direccion AS "Dirección"
FROM tb_cliente; 

-- Consulta #3. Mostrar todas las citas programadas para un empleado en especial (en este caso que contenga el id: 1000044)
SELECT tb_empleado.id_empleado AS "Cédula del empleado", 
CONCAT(tb_empleado.nombre_empleado, " ", tb_empleado.apellido_empleado) AS "Nombre del empleado", 
tb_cliente.id_cliente AS "Cédula del cliente", 
CONCAT(tb_cliente.nombre_cliente, " ", tb_cliente.apellido_cliente) AS "Nombre del cliente"
FROM tb_empleado 
INNER JOIN tb_cita ON tb_cita.id_empleado = tb_empleado.id_empleado
INNER JOIN tb_cliente ON tb_cliente.id_cliente = tb_cita.id_cliente
WHERE tb_empleado.id_empleado = '1000044';

-- Consulta #4. Mostrar el id y el nombre, de los proveedores de productos en la barbería, donde la dirección empiece por Lake 
SELECT id_proveedor AS "Id proveedor", nombre_proveedor AS "Nombre del proveedor", direccion
FROM tb_proveedor
WHERE direccion LIKE 'Lake%';

-- Consulta #5. Mostrar todos los registros de venta que existen hasta el momento
SELECT tb_registro_venta.id_registro_venta AS "Id registros de venta", 
tb_registro_venta.valor, 
tb_registro_venta.fecha, 
tb_registro_venta.id_cliente AS "Cédula cliente",
CONCAT (tb_cliente.nombre_cliente, " ",tb_cliente.apellido_cliente) AS "Nombre cliente"
FROM tb_registro_venta
INNER JOIN tb_cliente ON tb_cliente.id_cliente = tb_registro_venta.id_cliente;

-- Consulta #6. Mostrar nombre de los empleados y los servicios que prestan en la barbería
SELECT CONCAT(nombre_empleado, " ",apellido_empleado) AS "Nombre del empleado", especialidad AS Servicio
FROM tb_empleado
ORDER BY nombre_empleado;

-- Consulta #7. Mostrar los clientes que nacieron en el año 1999
SELECT CONCAT(nombre_cliente, apellido_cliente) AS "Nombre del cliente", fecha_nacimiento 
FROM tb_cliente
WHERE fecha_nacimiento LIKE '%1999';

-- Consulta #8. Mostrar el precio de los productos donde su rango esté entre 5000 y 15000
SELECT id_producto AS "Id del producto", nombre_producto AS "Nombre del producto", precio 
FROM tb_producto
WHERE precio BETWEEN 5000 AND 15000;

-- Consulta #9. Mostrar los productos donde la cantidad del producto sea menor a 5
SELECT id_producto AS "Id del producto", nombre_producto AS "Nombre del producto", cantidad_disponible AS Stock
FROM tb_producto
WHERE cantidad_disponible < 5; 

-- Consulta #10. Mostrar el nombre de todos los clientes de manera ascendente
SELECT CONCAT(nombre_cliente," " ,apellido_cliente) AS "Lista de clientes"
FROM tb_cliente 
ORDER BY nombre_cliente ASC;

-- Creación de vistas 
-- Vista #1. 
CREATE VIEW citas_empleado AS
SELECT tb_empleado.id_empleado AS "Cédula del empleado", 
CONCAT(tb_empleado.nombre_empleado, " ", tb_empleado.apellido_empleado) AS "Nombre del empleado", 
tb_cliente.id_cliente AS "Cédula del cliente", 
CONCAT(tb_cliente.nombre_cliente, " ", tb_cliente.apellido_cliente) AS "Nombre del cliente"
FROM tb_empleado 
INNER JOIN tb_cita ON tb_cita.id_empleado = tb_empleado.id_empleado
INNER JOIN tb_cliente ON tb_cliente.id_cliente = tb_cita.id_cliente
WHERE tb_empleado.id_empleado = '1000044';

SELECT *
FROM citas_empleado;

-- Vista #2.
CREATE VIEW registro_venta_actual AS 
SELECT tb_registro_venta.id_registro_venta AS "Id registros de venta", 
tb_registro_venta.valor, 
tb_registro_venta.fecha, 
tb_registro_venta.id_cliente AS "Cédula cliente",
CONCAT (tb_cliente.nombre_cliente, " ",tb_cliente.apellido_cliente) AS "Nombre cliente"
FROM tb_registro_venta
INNER JOIN tb_cliente ON tb_cliente.id_cliente = tb_registro_venta.id_cliente;

SELECT *
FROM registro_venta_actual;

-- Vista #3.
CREATE VIEW agotando_stock AS 
SELECT id_producto AS "Id del producto", nombre_producto AS "Nombre del producto", cantidad_disponible AS Stock
FROM tb_producto
WHERE cantidad_disponible < 5; 

SELECT *
FROM agotando_stock;

-- Vista #4.
CREATE VIEW servicios_empleado AS
SELECT CONCAT(nombre_empleado, " ",apellido_empleado) AS "Nombre del empleado", especialidad AS Servicio
FROM tb_empleado
ORDER BY nombre_empleado;

SELECT * 
FROM servicios_empleado;

-- Muestra todos los datos de cada una de las tablas
SELECT * 
FROM tb_proveedor;

SELECT * 
FROM tb_producto;

SELECT * 
FROM tb_cliente; 

SELECT *
FROM tb_servicio; 

SELECT * 
FROM tb_empleado;

SELECT * 
FROM tb_telefono_proveedor;

SELECT * 
FROM tb_telefono_cliente;

SELECT * 
FROM tb_compra;

SELECT *
FROM dll_compra_producto;

SELECT * 
FROM dll_venta_producto;

SELECT * 
FROM tb_historial_servicio;

SELECT * 
FROM tb_cita;
