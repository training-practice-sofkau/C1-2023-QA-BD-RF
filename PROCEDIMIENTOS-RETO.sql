USE DONPEPE;

/* PROCEDIMIENTO 1 PARA REGISTRAR UN CLIENTE */

DELIMITER //
CREATE PROCEDURE registrarCliente(
IN cedula VARCHAR(45),
IN nombre VARCHAR(45),
IN direccion VARCHAR(45),
IN telefono VARCHAR(45),
IN correo VARCHAR(45),
IN contraseña VARCHAR(45),
IN codigo_postal INT
)
BEGIN
INSERT INTO cliente (cedula, nombre, direccion, telefono, correo, contraseña, codigo_postal)
VALUES (cedula, nombre, direccion, telefono, correo, contraseña, codigo_postal);
END //
DELIMITER ;

CALL registrarCliente();

/*PROCEDIMIENTO 2*/

DELIMITER //
CREATE PROCEDURE agregarProducto(
IN nombre VARCHAR(45),
IN marca VARCHAR(45),
IN origen VARCHAR(45),
IN volumen VARCHAR(45),
IN precio INT,
IN peso VARCHAR(45),
IN foto VARCHAR(45),
IN categoria VARCHAR(45)
)
BEGIN
INSERT INTO productos (nombre, marca, origen, volumen, precio, peso, foto, categoria)
VALUES (nombre, marca, origen, volumen, precio, peso, foto, categoria);
END //
DELIMITER ;

CALL agregarProducto();

/*PROCEDIMIENTO 3 PARA SABER TODA LA INFORMACION DE LA BASE DE DATOS*/

DELIMITER //
CREATE PROCEDURE VerTodaLaInformacion()
BEGIN
  SELECT * FROM cliente, domiciliario, zona, pedido, producto, categoria, proveedor;
END //
DELIMITER ;

call VerTodaLaInformacion();

/*PROCEDIMIENTO 4 QUE SERVIRA PARA VER LOS PRODUCTOS SUMINISTRADOS POR EL PROVEEDOR*/

DELIMITER //
CREATE PROCEDURE VerProveedoresYSuministros()
BEGIN
  SELECT pr.nombre AS nombre_proveedor, p.nombre AS nombre_producto,
  c.nombre AS nombre_categoria, COUNT(*) AS cantidad_productos_suministrados
  FROM proveedor pr
  JOIN producto p ON pr.id = p.id_proveedor
  JOIN categoria c ON p.id_categoria = c.id
  GROUP BY pr.nombre, p.nombre, c.nombre;
END //
DELIMITER ;

call VerProveedoresYSuministros();