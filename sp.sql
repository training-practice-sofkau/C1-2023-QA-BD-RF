#Sp para agregar proveedor
DELIMITER //
CREATE PROCEDURE sp_agregar_proveedor (
   NIT_param INT,
  nombre_param VARCHAR(30), 
  direccion_param VARCHAR(15)
 )
BEGIN
    INSERT INTO   proveedor (NIT, nombre, direccion)
VALUES (NIT_param, nombre_param, direccion_param);
END//
DELIMITER ;

CALL sp_agregar_proveedor( 116, "Cosmeticos LI", "direccion5");
SELECT*FROM proveedor;


#Sp para eliminar proveedor
DELIMITER //
CREATE PROCEDURE sp_eliminar_proveedor (
   NIT_param INT
 )
BEGIN
    DELETE FROM  proveedor WHERE NIT = NIT_param;
END//
DELIMITER 
CALL sp_eliminar_proveedor(116);
SELECT*FROM proveedor;

#Sp para actualizar proveedor
CREATE PROCEDURE sp_actualizar_proveedor (
   NIT_param INT
   nombre_param VARCHAR(30), 
   direccion_param VARCHAR(15)
 )
BEGIN
    UPDATE  proveedor SET NIT = NIT_param WHERE direccion = direccion_param;
END//
DELIMITER 
CALL sp_actualizar_proveedor(11);
SELECT*FROM proveedor;

#Sp para buscar producto
DELIMITER //
CREATE PROCEDURE sp_consultar_producto (
    IN id_param  INT
)
BEGIN
    SELECT * FROM producto WHERE REF = id_param ;
END//
DELIMITER ;
CALL sp_consultar_producto  (112);



