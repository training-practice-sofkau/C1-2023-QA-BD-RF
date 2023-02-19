# Crear la tabla control_de_cambios_en proveedores
CREATE TABLE IF NOT EXISTS contol_cambios_proveedor (
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


#Trigger para registrar el usuario que registro los datos en la tabla clientes.
DELIMITER //
CREATE TRIGGER tr_eliminar_proveedor
AFTER DELETE ON proveedor
FOR EACH ROW
BEGIN
  INSERT INTO tr_eliminar_proveedor(usuario, accion, fecha)
  VALUES (USER(), "delete", NOW());
END//
DELIMITER ;