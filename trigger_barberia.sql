DELIMITER $$
CREATE TRIGGER tr_actualizar_cantidad_productos_consumidos
AFTER INSERT ON servicios
FOR EACH ROW
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE id_producto INT;
    DECLARE cantidad_consumida INT;
    DECLARE nombre_producto VARCHAR(50);
    
    WHILE i <= LENGTH(NEW.productos_consumidos) DO
        SET id_producto = SUBSTRING_INDEX(SUBSTRING_INDEX(NEW.productos_consumidos, ',', i), ',', -1);
        SET cantidad_consumida = SUBSTRING_INDEX(SUBSTRING_INDEX(NEW.productos_consumidos, ',', i+1), ',', -1) - 
                                SUBSTRING_INDEX(SUBSTRING_INDEX(NEW.productos_consumidos, ',', i), ',', -1);
        SET nombre_producto = (SELECT nombre FROM productos WHERE REF = id_producto);
        
        UPDATE productos
        SET cantidad = cantidad - cantidad_consumida
        WHERE REF = id_producto;
        
        INSERT INTO registro_productos_consumidos(servicio_id, producto_id, cantidad_consumida, nombre_producto, fecha)
        VALUES (NEW.ID, id_producto, cantidad_consumida, nombre_producto, CURDATE());
        
        SET i = i + 2;
    END WHILE;
END$$
DELIMITER ;


DELIMITER //

CREATE TRIGGER tr_agregar_cita
AFTER INSERT ON clientes
FOR EACH ROW
BEGIN
    INSERT INTO citas (cliente_id, empleado_id, fecha_hora)
    VALUES (NEW.ID, 1, DATE_ADD(NOW(), INTERVAL 30 MINUTE));
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_eliminar_venta
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN
    IF NEW.cantidad = 0 THEN
        DELETE FROM ventas WHERE producto_id = NEW.REF;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_actualizar_especialidad
AFTER INSERT ON servicios
FOR EACH ROW
BEGIN
    UPDATE empleados
    SET especialidad = NEW.productos_consumidos
    WHERE ID = NEW.empleado_id AND NOT EXISTS (
        SELECT * FROM servicios
        WHERE empleado_id = NEW.empleado_id
        AND productos_consumidos <> NEW.productos_consumidos
    );
END //

DELIMITER ;


