# Crear la tabla control_de_cambios_en proveedores
CREATE TABLE IF NOT EXISTS sp_elimnar_proveedor(
  usuario VARCHAR(55) NOT NULL,
  accion VARCHAR(10) NOT NULL,
  fecha DATETIME NOT NULL,
  PRIMARY KEY (usuario, accion, fecha)
);

#Trigger 1: registra el usuario que registro los datos en la proveedor.

DELIMITER //
CREATE TRIGGER tr_insertar_proveedor
AFTER INSERT ON proveedor
FOR EACH ROW
BEGIN
  INSERT INTO tr_insertar_proveedor (usuario, accion, fecha)
  VALUES (USER(), "insert", NOW());
END//
DELIMITER ;


#Trigger para la eliminación de un registro de proveedor
DELIMITER //
CREATE TRIGGER tr_eliminar_proveedor
AFTER DELETE ON proveedor
FOR EACH ROW
BEGIN
  INSERT INTO tr_eliminar_proveedor(usuario, accion, fecha)
  VALUES (USER(), "delete", NOW());
END//
DELIMITER ;

#Trigger 3: registra el usuario que registro los datos en la tabla insumo.

DELIMITER //
CREATE TRIGGER tr_insertar_insumo
AFTER INSERT ON insumo
FOR EACH ROW
BEGIN
  INSERT INTO tr_insertar_insumo (usuario, accion, fecha)
  VALUES (USER(), "insert", NOW());
END//
DELIMITER ;

#Trigger para la eliminación de un registro de la tabla insumo
DELIMITER //
CREATE TRIGGER tr_eliminar_insumo
AFTER DELETE ON insumo
FOR EACH ROW
BEGIN
  INSERT INTO tr_eliminar_insumo(usuario, accion, fecha)
  VALUES (USER(), "delete", NOW());
END//
DELIMITER ;


