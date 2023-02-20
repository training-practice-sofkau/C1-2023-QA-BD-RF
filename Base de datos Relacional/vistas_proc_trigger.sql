use tienda_don_pepe;

-- vista 1 
CREATE VIEW vista_productos_sin_stock as 
SELECT *
FROM producto
WHERE stock =0;

SELECT * FROM vista_productos_sin_stock;

-- vista2 que muestre número de  clientes por zona 

CREATE VIEW cantidad_clientes_por_zona as 
SELECT  zona_postal.zona  as "clientes",  COUNT(*) as cantidad
FROM cliente
INNER JOIN zona_postal
ON  cliente.id_zona_postal = zona_postal.id_zona_postal
GROUP BY  zona_postal.zona;

SELECT * FROM cantidad_clientes_por_zona;

-- vista 3 Datos del cliente y estatus de pedido

CREATE VIEW datos_cliente_estatus_pedido as
SELECT cliente.nombre_cliente, cliente.email, cliente.cedula, cliente.telefono, pedido.fecha_pedido, estado_pedido.estado
FROM cliente
INNER JOIN pedido
ON cliente.id_cliente = pedido.id_cliente
INNER JOIN estado_pedido
ON pedido.id_estado_pedido = estado_pedido.id_estado_pedido;

SELECT * FROM datos_cliente_estatus_pedido;

-- vista 4 producto y almacenamiento
CREATE VIEW producto_tipo_almacenamiento as
SELECT producto.nombre_producto, categoria.almacenamiento, categoria.nombre_categoria
FROM producto
INNER JOIN categoria
ON producto.id_categoria = categoria.id_categoria
ORDER BY categoria.almacenamiento ASC;

-- Procedimiento para conocer el stock que sea menor a 10 productos

DELIMITER //
CREATE PROCEDURE productos_limite_stock()
BEGIN
  SELECT producto.nombre_producto, producto.stock
  FROM producto
  WHERE stock <=10;
  
END //
// DELIMITER ;

CALL productos_limite_stock();


-- procedimiento para conocer las ganancias por pedidos en  una fecha 

DELIMITER //
CREATE PROCEDURE agregar_cliente(
     IN id_cliente VARCHAR(15),
     IN nombre_cliente VARCHAR(45),
     IN cedula VARCHAR(20),
	 IN email VARCHAR(60),
	 IN password VARCHAR(45),
     IN telefono VARCHAR(45),
     IN id_zona_postal VARCHAR(15)
    
     )
 
BEGIN
 INSERT INTO cliente(id_cliente, nombre_cliente,	cedula,	email,	password,	telefono,	id_zona_postal)
 VALUES(id_cliente,	nombre_cliente,	cedula,	email,	password,	telefono,	id_zona_postal);

END //
// DELIMITER ;

CALL agregar_cliente('111',	'Camila Cabello','2567892',	'cabelloc@gmail.com','C546C','32045878','1');

-- Procedimiento 3 ventas total de pedidos


DELIMITER //
CREATE PROCEDURE ventas_totales_pedidos_porfecha()
 
BEGIN
 SELECT  pedido.fecha_pedido, SUM(total) 
 FROM pedido
 GROUP BY pedido.fecha_pedido;

END //
// DELIMITER ;


CALL ventas_totales_pedidos_porfecha();


-- Procedimiento 4modificar precio de un producto

DELIMITER //
CREATE PROCEDURE actualizar_precio_producto(
    IN id_producto VARCHAR(15),
    IN nuevo_precio VARCHAR(45)
  
)
 
BEGIN
   UPDATE producto
   SET  precio = nuevo_precio
   WHERE producto.id_producto = id_producto;

END //
// DELIMITER ;


CREATE TABLE acciones (
  id INT NOT NULL AUTO_INCREMENT,
  accion VARCHAR(45) NULL,
  fecha DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id));

CALL actualizar_precio_producto('8', '6540');


-- tigger 1 actualizar iva aplicado a productos

DELIMITER //
CREATE TRIGGER actualizar_iva
BEFORE INSERT ON producto
FOR EACH ROW
BEGIN
   DECLARE iva double;
   SET iva = 0.19; 
   SET NEW.precio = NEW.precio * (1+ iva);
   
END;
// DELIMITER ;

-- tigger 2  log de registros cuando se agregar nuevos pedidos mostrando la fecha 
DELIMITER //
CREATE TRIGGER log_productos
AFTER INSERT ON producto
FOR EACH ROW
BEGIN
   INSERT INTO acciones(accion) 
   VALUE ('Se agrego un nuevo producto');
   
END;
// DELIMITER ;

-- tigger 3  log de registros cuando se agregar nuevos pedidos mostrando la fecha 
DELIMITER //
CREATE TRIGGER log_pedido
AFTER INSERT ON pedido
FOR EACH ROW
BEGIN
   INSERT INTO acciones(accion) 
   VALUE ('Se solicito un nuevo pedido');
   
END;
// DELIMITER ;

 -- DROP TRIGGER IF EXISTS agregar_domiciliario;

-- tigger 4 actualizar stock cuando se haga un pedidos
DELIMITER //
CREATE TRIGGER actualizar_stock_productos
AFTER INSERT ON detalles_pedido
FOR EACH ROW
BEGIN
  UPDATE producto
SET stock = producto.stock - NEW.cantidad_productos
WHERE producto.id_producto = NEW.id_producto;
   
END;
// DELIMITER ;

-- tigger 5  log de registros actualizacion de un domiciliario 
DELIMITER //

CREATE TRIGGER agregar_proveedor
AFTER DELETE ON proveedor
FOR EACH ROW
BEGIN
   INSERT INTO acciones(accion) 
  VALUES ('Se ha agregado un nuevo proveedor');
END//

DELIMITER ;





