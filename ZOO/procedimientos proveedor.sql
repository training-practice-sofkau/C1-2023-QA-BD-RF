# Elabore 4 procedimientos almacenados

USE zoologico;

#PROCEDIMIENTO PARA AGREGAR UN REGISTRO
DELIMITER // 
CREATE PROCEDURE agregarProveedor
(
IN _id_proveedor VARCHAR (10),
IN _nombre VARCHAR(45),
IN _direccion VARCHAR(45),
IN _correo VARCHAR(45)
)
BEGIN 
INSERT INTO proveedor (id_proveedor,nombre,direccion,correo)
 values (_id_proveedor,_nombre,_direccion,_correo);
END
// 
#Llamar el procedimiento agregar proveedor
CALL agregarProveedor('10','Tierragro','Fusagasuga','tierragro@agro.com');

# PROCEDIMIENTO PARA CONSULTAR PROVEEDOR
DELIMITER //
CREATE PROCEDURE buscar_proveedor(IN _id_proveedor VARCHAR (10))
BEGIN
SELECT * FROM proveedor WHERE id_proveedor = _id_proveedor;
END
//
#Llamar procedimiento buscar paciente
CALL buscar_proveedor(10);

#Procedimiento para modifica proveedor
DELIMITER //
CREATE PROCEDURE modificar_proveedor
(
IN _id_proveedor VARCHAR (10),
IN _nombre VARCHAR(45),
IN _direccion VARCHAR(45),
IN _correo VARCHAR(45)
)
BEGIN
UPDATE proveedor 
SET  nombre = _nombre,
direccion = _direccion,
correo = _correo
WHERE id_proveedor = _id_proveedor;
END
//
#Llamar procedimiento modificar proveedor
CALL modificar_proveedor ('10','Tierragro','Bogota','tierragro@agro.com');

#PROCEDIMIENTO BORRAR PROVEEDOR
DELIMITER //
CREATE PROCEDURE borrar_proveedor 
(
IN _id_proveedor VARCHAR (10)
)
BEGIN
DELETE FROM proveedor WHERE id_proveedor = _id_proveedor;
END
//
#Llamar procedimiento borrar paciente
CALL borrar_proveedor(10);
