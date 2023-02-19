CREATE DATABASE tienda;

USE tienda;

-- tabla cliente
CREATE TABLE cliente (
cedula VARCHAR(15) NOT NULL PRIMARY KEY,
nombre_cliente VARCHAR(50) NOT NULL,
direccion_cliente VARCHAR(50) NOT NULL,
zona_cliente VARCHAR(15) NOT NULL,
email VARCHAR(30) NOT NULL,
password_cliente VARCHAR(20) NOT NULL
);

-- tabla telefono cliente
CREATE TABLE telefono_cliente (
  cedula_cliente VARCHAR(15) NOT NULL,
  numero_cliente VARCHAR(15) NOT NULL,
  PRIMARY KEY (cedula_cliente, numero_cliente),
  FOREIGN KEY (cedula_cliente) REFERENCES cliente (cedula)
);

-- tabla proveedor
CREATE TABLE proveedor(
id_proveedor  VARCHAR(15) NOT NULL PRIMARY KEY,
nombre_proveedor VARCHAR(50) NOT NULL
);

-- tabla telefono proveedor
CREATE TABLE telefono_proveedor(
id_proveedor_telefono VARCHAR(15) NOT NULL,
numero_proveedor VARCHAR(15) NOT NULL,
PRIMARY KEY(id_proveedor_telefono, numero_proveedor),
FOREIGN KEY (id_proveedor_telefono) REFERENCES proveedor(id_proveedor)
);

-- tabla categoria
CREATE TABLE categoria(
id_categoria VARCHAR(15) NOT NULL PRIMARY KEY,
nombre_categoria VARCHAR(50) NOT NULL,
condiciones_almacenaimiento VARCHAR(15) NOT NULL,
observaciones VARCHAR(15) NOT NULL
);

-- tabla producto
CREATE TABLE producto(
id_producto VARCHAR(15) NOT NULL PRIMARY KEY,
nombre_producto VARCHAR(50) NOT NULL,
marca VARCHAR(50) NOT NULL,
origen VARCHAR(50) NOT NULL,
contenido VARCHAR(20) NOT NULL,
fotografia VARCHAR(20) NOT NULL,
stock INT NOT NULL,
id_categoria_producto VARCHAR(15) NOT NULL,
id_proveedor_producto VARCHAR(15) NOT NULL,
FOREIGN KEY(id_categoria_producto) REFERENCES categoria(id_categoria),
FOREIGN KEY(id_proveedor_producto) REFERENCES proveedor(id_proveedor)
);

-- tabla domiciliario
CREATE TABLE domiciliario(
id_domiciliario VARCHAR(15) NOT NULL PRIMARY KEY,
nombre_domiciliario VARCHAR(50) NOT NULL,
numero_matricula VARCHAR(20) NOT NULL,
zona_domiciliario VARCHAR(15) NOT NULL
);

-- tabla pedido
CREATE TABLE pedidos(
id_pedido VARCHAR(15) NOT NULL PRIMARY KEY,
direccion_pedido VARCHAR(50) NOT NULL,
fecha_pedido DATETIME DEFAULT current_timestamp,
numero_tarjeta VARCHAR(20) NOT NULL,
fecha_caducidad_tarjeta VARCHAR(5) NOT NULL,
total_valor VARCHAR(10) NOT NULL,
cedula_cliente VARCHAR(15) NOT NULL,
id_domiciliario_pedido VARCHAR(15) NOT NULL,
FOREIGN KEY(cedula_cliente) REFERENCES cliente(cedula),
FOREIGN KEY(id_domiciliario_pedido) REFERENCES domiciliario(id_domiciliario)
);

-- tabla producto_pedido
CREATE TABLE producto_pedido(
id_producto_pedido VARCHAR(15) NOT NULL,
id_pedido_producto VARCHAR(15) NOT NULL,
Cantidad INT NOT NULL CHECK (Cantidad >= 1),
FOREIGN KEY(id_producto_pedido) REFERENCES producto(id_producto),
FOREIGN KEY(id_pedido_producto) REFERENCES pedidos(id_pedido)
);

-- 1 consulta para ver el listado de productos con su categoria y proveedor
SELECT producto.nombre_producto, categoria.nombre_categoria, proveedor.nombre_proveedor
FROM producto
INNER JOIN categoria ON categoria.id_categoria = producto.id_categoria_producto
INNER JOIN proveedor ON proveedor.id_proveedor = producto.id_proveedor_producto;

-- 2 consulta para ver el cliente con su numero de telefono
SELECT cliente.nombre_cliente AS nombre, telefono_cliente.numero_cliente AS telefono
FROM cliente
INNER JOIN telefono_cliente ON telefono_cliente.cedula_cliente = cliente.cedula;

-- 3 consulta para ver e proveedores con su numero de telefono
SELECT proveedor.nombre_proveedor, telefono_proveedor.numero_proveedor
FROM proveedor
INNER JOIN telefono_proveedor ON telefono_proveedor.id_proveedor_telefono = proveedor.id_proveedor;

-- 4 consulta para ver el pedido con los productos y las cantidades 
SELECT pedido.id_pedido, GROUP_CONCAT( producto.nombre_producto, ' (', producto_pedido.Cantidad, ') ') as productos_cantidad
FROM producto_pedido
INNER JOIN pedido ON producto_pedido.id_pedido_producto = pedido.id_pedido
INNER JOIN producto ON producto_pedido.id_producto_pedido = producto.id_producto
GROUP BY pedido.id_pedido;

-- 5 consulta para ver los clientes con pedidos mayores a 60000
SELECT cliente.nombre_cliente, cliente.cedula, pedido.total_valor
FROM cliente 
INNER JOIN pedido ON cliente.cedula = pedido.cedula_cliente 
WHERE pedido.total_valor > 60000;

-- 6 consulta para ver domiciliarios en la zona 2 
SELECT * 
FROM domiciliario 
WHERE zona_domiciliario = 'Zona 2';

-- 7 consulta para ver los domiciliarios que hay en cada zona de cada cliente
SELECT cliente.nombre_cliente, cliente.zona_cliente, domiciliario.nombre_domiciliario, domiciliario.zona_domiciliario
FROM cliente
INNER JOIN domiciliario ON cliente.zona_cliente = domiciliario.zona_domiciliario;

-- 8 consulta para ver los productos con sus stock
SELECT producto.nombre_producto, producto.stock
FROM producto;

-- 9 consulta para ver la direcciones id del pedido y el domiciliario que lo entrega
SELECT domiciliario.nombre_domiciliario, pedido.id_pedido
FROM domiciliario
INNER JOIN pedido ON pedido.id_domiciliario_pedido = domiciliario.id_domiciliario;

-- 10 consulta para ver los clientes y las id de los pedidos que han realizado
SELECT 	 GROUP_CONCAT(pedido.id_pedido SEPARATOR ', ') as pedidos_realizados
FROM cliente
LEFT JOIN pedido ON cliente.cedula = pedido.cedula_cliente
GROUP BY cliente.cedula;


-- 1 vista para ver el contacto del cliente
CREATE VIEW contacto_cliente AS
SELECT cliente.nombre_cliente AS nombre, telefono_cliente.numero_cliente AS telefono, cliente.email AS correo, cliente.direccion_cliente AS direccion
FROM cliente
INNER JOIN telefono_cliente ON telefono_cliente.cedula_cliente = cliente.cedula;

SELECT *
FROM contacto_cliente;

-- 2 vista para ver ver el listado de productos con su categoria y proveedor
CREATE VIEW info_productos AS
SELECT producto.nombre_producto, categoria.nombre_categoria, proveedor.nombre_proveedor
FROM producto
INNER JOIN categoria ON categoria.id_categoria = producto.id_categoria_producto
INNER JOIN proveedor ON proveedor.id_proveedor = producto.id_proveedor_producto;

SELECT *
FROM info_productos;

-- 3 vista para ver el domiciliario que se le asigno un pedido con el id del pedido y la direccion que entrega
CREATE VIEW info_domicilio AS
SELECT domiciliario.nombre_domiciliario, pedido.id_pedido, pedido.direccion_pedido
FROM domiciliario
INNER JOIN pedido ON pedido.id_domiciliario_pedido = domiciliario.id_domiciliario;

SELECT *
FROM info_domicilio;

-- 4 Vista para ver los pedidos con el nombre de cada producto y sus cantidades
CREATE VIEW info_pedido AS
SELECT pedido.id_pedido, GROUP_CONCAT( producto.nombre_producto, ' (', producto_pedido.Cantidad, ') ') as productos_cantidad
FROM producto_pedido
INNER JOIN pedido ON producto_pedido.id_pedido_producto = pedido.id_pedido
INNER JOIN producto ON producto_pedido.id_producto_pedido = producto.id_producto
GROUP BY pedido.id_pedido;


SELECT *
FROM info_pedido;

-- procedimiento para agregar un telefono al cliente
DELIMITER //
CREATE PROCEDURE agregar_telefono_cliente(
  IN cedula_procedimiento VARCHAR(15),
  IN numero_procedimiento VARCHAR(15)
)
BEGIN
  INSERT INTO telefono_cliente(cedula_cliente, numero_cliente)
  VALUES(cedula_procedimiento, numero_procedimiento);
END//
// DELIMITER;

CALL agregar_telefono_cliente('123456789', '555-5555')

SELECT *
FROM telefono_cliente

-- procedimiento para actualizar el telefono de un cliente
DELIMITER //
CREATE PROCEDURE actualizar_telefono_cliente (
IN cedula_procedimiento VARCHAR(15),
IN numero_procedimiento VARCHAR(15),
IN nuevo_numero_procedimiento VARCHAR(15)
)
BEGIN
UPDATE telefono_cliente
SET numero_cliente = nuevo_numero_procedimiento
WHERE cedula_cliente = cedula_procedimiento AND numero_cliente = numero_procedimiento;
END //
//DELIMITER ;

CALL actualizar_telefono_cliente ('123456789','555-5555','666-6666')

-- Procedimiento para consultar numero de telefonos del cliente 
DELIMITER // 
CREATE PROCEDURE consultar_telefono_cliente (
IN cedula_procedimiento VARCHAR(15)
)
BEGIN 
SELECT numero_cliente
FROM telefono_cliente
WHERE cedula_cliente = cedula_procedimiento;
END //
//DELIMITER ;

CALL consultar_telefono_cliente ('123456789')

-- Procedimiento para eliminar numero de telefonos del cliente 
DELIMITER //
CREATE PROCEDURE eliminar_telefono_cliente (
IN cedula_procedimiento VARCHAR(10),
IN numero_procedimiento VARCHAR(15)
)
BEGIN
DELETE FROM telefono_cliente
WHERE cedula_cliente = cedula_procedimiento AND numero_cliente = numero_procedimiento;
END //
//DELIMITER ;

CALL eliminar_telefono_cliente ('123456789','666-6666')

-- trigger para disminuir el stock cuando se realice una compra en la tabla producto_pedido
DELIMITER //
CREATE TRIGGER disminuir_stock AFTER INSERT ON producto_pedido 
FOR EACH ROW
BEGIN
  IF NEW.Cantidad > (SELECT stock FROM producto WHERE id_producto = NEW.id_producto_pedido) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay suficiente stock para realizar el pedido';
  ELSE
    UPDATE producto SET stock = stock - NEW.Cantidad WHERE id_producto = NEW.id_producto_pedido;
  END IF;
END;
// DELIMITER ;

INSERT INTO producto_pedido(id_producto_pedido, id_pedido_producto, Cantidad)
VALUES('prod001', 'PED001', 200)

-- trigger para validar que el domicilirio este en la misma zona que el cliente
DELIMITER //
CREATE TRIGGER validar_zona_domiciliario
BEFORE INSERT ON pedido
FOR EACH ROW
BEGIN
    DECLARE trigger_zona_cliente VARCHAR(15);
    DECLARE trigger_zona_domiciliario VARCHAR(15);
    
    SELECT zona_cliente INTO trigger_zona_cliente FROM cliente WHERE cedula = NEW.cedula_cliente;
    SELECT zona_domiciliario INTO trigger_zona_domiciliario FROM domiciliario WHERE id_domiciliario = NEW.id_domiciliario_pedido;
    
    IF trigger_zona_cliente != trigger_zona_domiciliario THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El domiciliario no está en la misma zona que el cliente';
    END IF;
END;
// DELIMITER ;

-- Tabla control_de_cambios_librería
CREATE TABLE IF NOT EXISTS control_de_cambios_tienda (
    usuario VARCHAR(50),
    accion VARCHAR(50),
    fecha DATETIME DEFAULT current_timestamp
);

-- Trigger agregar
DELIMITER //
CREATE TRIGGER agregar_telefono AFTER INSERT ON telefono_cliente
	FOR EACH ROW
	BEGIN
		INSERT INTO control_de_cambios_tienda VALUES(user(), 'agregar', now());
	END;
// DELIMITER ;

-- Trigger eliminar
DELIMITER //
CREATE TRIGGER eliminar_telefono AFTER DELETE ON telefono_cliente
	FOR EACH ROW
	BEGIN
		INSERT INTO control_de_cambios_tienda VALUES(user(), 'eliminar', now());
	END;
// DELIMITER ;
