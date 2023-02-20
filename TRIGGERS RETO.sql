USE DONPEPE;

/*TRIGGER 1*/

DELIMITER //
CREATE TRIGGER validaProductoInsert
BEFORE INSERT
ON producto
FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM producto WHERE id_producto = NEW.id) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El número de identificación ya está en uso.';
  END IF;
END//
DELIMITER ;

/*TRIGGER 2*/

DELIMITER //
CREATE TRIGGER eliminaPedidoDelete
AFTER DELETE
ON cliente
FOR EACH ROW
BEGIN
  DELETE FROM pedido WHERE id_cliente = OLD.id;
END //
DELIMITER ;

/*TRIGGER 3*/

DELIMITER //
CREATE TRIGGER agregaProductosInsert
AFTER INSERT
ON proveedor
FOR EACH ROW
BEGIN
  INSERT INTO producto (ID, nombre, marca, origen, volumen, precio, peso, foto, id_categoria, id_proveedor)
  SELECT ID, nombre, marca, origen, volumen, precio, peso, foto, id_categoria, NEW.NIT 
  FROM producto
  WHERE id_proveedor IS NULL;
END //
DELIMITER ;

/*TRIGGER 4*/

DELIMITER //
CREATE TRIGGER actualiza_precios_pedidos
AFTER UPDATE
ON producto
FOR EACH ROW
BEGIN
  UPDATE pedido SET precio_pedido = NEW.precio WHERE id_producto = OLD.id;
END //
DELIMITER ;