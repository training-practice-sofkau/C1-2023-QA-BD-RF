CREATE DATABASE IF NOT EXISTS TiendaDonPepe;
USE TiendaDonPepe;

-- Creacion tabla Cliente
CREATE TABLE Cliente (
  Id_Cliente VARCHAR(6) PRIMARY KEY,
  Nombre_Cliente VARCHAR(60),
  Cedula_Cliente VARCHAR(30),
  Password_Cliente VARCHAR(30),
  Email_Cliente VARCHAR(80),
  Direccion_Cliente VARCHAR(130),
  Codigo_Postal_Cliente VARCHAR(30)  
);


-- Creacion tabla Contacto_Cliente
CREATE TABLE Contacto_Cliente (
  Id_Cliente VARCHAR(6) PRIMARY KEY,
  Telefono_Cliente INT,
  CONSTRAINT IdCLiente_Contacto FOREIGN KEY (Id_Cliente)
    REFERENCES Cliente (Id_Cliente)
);


-- Creacion tabla Domiciliario
CREATE TABLE Domiciliario (
  Id_Domiciliario VARCHAR(6) PRIMARY KEY,
  Placa_Furgoneta_Domiciliario VARCHAR(90),
  Nombre_Domiciliario VARCHAR(30),
  Codigo_Postal_Domiciliario VARCHAR(30)
  );
  
  
  -- Creacion tabla Contacto_Domiciliario
CREATE TABLE Contacto_Domiciliario (
  Id_Domiciliario VARCHAR(6) PRIMARY KEY,
  Telefono_Domiciliario INT,
  CONSTRAINT IdDomiciliario_contacto FOREIGN KEY (Id_Domiciliario)
    REFERENCES Domiciliario (Id_Domiciliario)
);


-- Creacion tabla Proveedor
CREATE TABLE Proveedor (
  NIT VARCHAR(6) PRIMARY KEY,
  Nombre_Proveedor VARCHAR(80),
  Direccion_Proveedor VARCHAR(130),
  Email_Proveedor VARCHAR(80)
);


-- Creacion tabla  Contacto_Proveedor
CREATE TABLE Contacto_Proveedor (
  NIT VARCHAR(6) PRIMARY KEY,
  Telefono_Proveedor INT,
  CONSTRAINT IdProveedor_contacto FOREIGN KEY (NIT)
    REFERENCES Proveedor (NIT)
);


-- Creacion tabla Condiciones Almacenamiento
CREATE TABLE Condiciones_Almacenamiento (
  Id_Almacenamiento VARCHAR(6) PRIMARY KEY,
  Condiciones_Almacenamiento VARCHAR(30)
);


-- Creacion tabla Pedido
CREATE TABLE Pedido (
  Id_Pedido VARCHAR(6) PRIMARY KEY,
  Id_Cliente VARCHAR(6),
  Id_Domiciliario VARCHAR(6),
  Fecha_Pedido VARCHAR(150),
  Unidades_Producto_Pedido INT,
  Valor_Total_Pedido VARCHAR(30),
  Numero_Tarjeta_Pago VARCHAR(30),
  Caducidad_Tarjeta_Pago VARCHAR(30),
  Direccion_Pedido VARCHAR(130),
  Codigo_Postal_Cliente VARCHAR(30),
  Codigo_Postal_Domiciliario VARCHAR(30),
  Verificacion_Zona_Pedido VARCHAR(30),
  CONSTRAINT IdCLiente_Pedido FOREIGN KEY (Id_Cliente)
    REFERENCES Cliente (Id_Cliente),
  CONSTRAINT IdDomiciliario_Pedido FOREIGN KEY (Id_Domiciliario)
    REFERENCES Domiciliario (Id_Domiciliario)
);


-- Creacion Tabla Categoria Producto
CREATE TABLE Categoria_Producto (
  Id_Categoria_Producto VARCHAR(6) PRIMARY KEY,
  Observaciones_Producto VARCHAR(500),
  Id_condiciones_Almacenamiento VARCHAR(6),
  CONSTRAINT IdAlmacenamiento_Categoria FOREIGN KEY (Id_condiciones_Almacenamiento)
    REFERENCES Condiciones_Almacenamiento (Id_Almacenamiento)
);


-- Creacion tabla Producto
CREATE TABLE Producto (
  ID_Producto VARCHAR(6) PRIMARY KEY,
  Id_Categoria_Producto VARCHAR(6),
  NIT VARCHAR(6),
  Foto_Producto VARCHAR(100),
  Unidad_Disponible_Producto INT,
  Volumen_Producto VARCHAR(30),
  Peso_Producto VARCHAR(30),
  Nombre_Producto VARCHAR(80),
  Precio_Producto VARCHAR(8),
  CONSTRAINT IdCategoria_Producto FOREIGN KEY (Id_Categoria_Producto)
    REFERENCES Categoria_Producto (Id_Categoria_Producto),
  CONSTRAINT NIT_Producto FOREIGN KEY (NIT)
    REFERENCES Proveedor (NIT)
);


-- Creacion tabla Producto_Pedido
CREATE TABLE Producto_Pedido (
  Id_Producto VARCHAR(6),
  Id_Pedido VARCHAR(6),
  PRIMARY KEY (Id_Producto,Id_Pedido),
  foreign key(Id_Pedido) references Pedido(Id_Pedido),
  foreign key(Id_Producto) references Producto(Id_Producto)
);

-- Consultas
-- Mostrar productos disponibles que tengan un precio mayor a 50
SELECT *
FROM Producto
WHERE Precio_Producto > 50;

-- Mostrar la unidades disponibles de un producto
SELECT Unidad_Disponible_Producto FROM Producto WHERE ID_Producto = 'Prod25';

-- Seleccionar los productos que cumplan con ciertas condiciones de almacenamiento
SELECT Nombre_Producto FROM Producto 
JOIN Categoria_Producto ON Producto.Id_Categoria_Producto = Categoria_Producto.Id_Categoria_Producto 
JOIN Condiciones_Almacenamiento ON Categoria_Producto.Id_condiciones_Almacenamiento = Condiciones_Almacenamiento.Id_Almacenamiento 
WHERE Condiciones_Almacenamiento = 'Seco';

-- Seleccionar los productos que tienen un precio superior a 20 y que esten disponibles en la categoria de "Bebida"
SELECT * FROM Producto
JOIN Categoria_Producto ON Producto.Id_Categoria_Producto = Categoria_Producto.Id_Categoria_Producto
WHERE Precio_Producto > 20 AND Observaciones_Producto = 'Bebida';

-- Obtener el nombre y el correo electrónico de todos los proveedores cuyo nombre contenga caracteres especificos
SELECT Nombre_Proveedor, Email_Proveedor 
FROM Proveedor 
WHERE Nombre_Proveedor LIKE '%Pu%';

-- Obtener el nombre y la cantidad disponible de los productos de una categoría específica usando su Id
SELECT Nombre_Producto, Unidad_Disponible_Producto 
FROM Producto 
JOIN Categoria_Producto 
ON Producto.Id_Categoria_Producto = Categoria_Producto.Id_Categoria_Producto 
WHERE Categoria_Producto.Id_Categoria_Producto = 'Cat15';

-- Obtener el nombre y el numero telefonico de todos los domiciliarios
SELECT Nombre_Domiciliario, Telefono_Domiciliario 
FROM Contacto_Domiciliario 
JOIN Domiciliario 
ON Contacto_Domiciliario.Id_Domiciliario = Domiciliario.Id_Domiciliario;

-- Ver las obsertvaciones de un producto, el nombre del proveedor que lo suministra y el precio del producto
SELECT Categoria_Producto.Observaciones_Producto, Proveedor.Nombre_Proveedor, Producto.Precio_Producto 
FROM Producto 
JOIN Categoria_Producto 
ON Producto.Id_Categoria_Producto = Categoria_Producto.Id_Categoria_Producto 
JOIN Proveedor 
ON Producto.NIT = Proveedor.NIT;

-- Ver la información de los clientes que tengan una dirección que contenga la palabra "puerta"
SELECT *
FROM Cliente
WHERE Direccion_Cliente LIKE '%puerta%';

-- Ver clientes que hayan realizado un pedido superior a 50000
SELECT Cliente.*
FROM Cliente
JOIN Pedido ON Cliente.Id_Cliente = Pedido.Id_Cliente
WHERE Pedido.Valor_Total_Pedido > '50000';

-- Vistas
-- Vista de la imformacion completa de los clientes
CREATE VIEW Vista_Clientes_Contactos AS
SELECT c.Id_Cliente, c.Nombre_Cliente, c.Cedula_Cliente, cc.Telefono_Cliente, c.Email_Cliente, c.Direccion_Cliente, c.Codigo_Postal_Cliente
FROM Cliente c
JOIN Contacto_Cliente cc ON c.Id_Cliente = cc.Id_Cliente;
SELECT * FROM tiendadonpepe.Vista_Clientes_Contactos;

-- Vista que nos permite validar el stock de un producto y su proveedor
CREATE VIEW Productos_Por_Proveedor AS
SELECT pr.Nombre_Proveedor, p.Nombre_Producto, p.Unidad_Disponible_Producto, p.Precio_Producto
FROM Proveedor pr
JOIN Producto p ON pr.NIT = p.NIT;
SELECT * FROM tiendadonpepe.Productos_Por_Proveedor;

-- Vista para ver los productos y sus categorias
CREATE VIEW Vista_Productos_Categorias AS
SELECT p.ID_Producto, p.Nombre_Producto, p.Precio_Producto, c.Id_Categoria_Producto, c.Observaciones_Producto
FROM Producto p
INNER JOIN Categoria_Producto c ON p.Id_Categoria_Producto = c.Id_Categoria_Producto;
SELECT * FROM tiendadonpepe.Vista_Productos_Categorias;

-- Vista para validar el inventario de productos
CREATE VIEW Vista_Validacion_Inventario AS
SELECT ID_Producto, Nombre_Producto, Unidad_Disponible_Producto, Precio_Producto
FROM Producto
WHERE Unidad_Disponible_Producto > 0;
SELECT * FROM tiendadonpepe.Vista_Validacion_Inventario;

-- Vista que nos permite ver los pedidos y sus detalles
CREATE VIEW Pedidos_Y_Detalles AS
SELECT Pedido.Id_Pedido, Pedido.Fecha_Pedido, Cliente.Nombre_Cliente, Domiciliario.Nombre_Domiciliario, Pedido.Valor_Total_Pedido, Pedido.Direccion_Pedido
FROM Pedido
JOIN Cliente ON Pedido.Id_Cliente = Cliente.Id_Cliente
JOIN Domiciliario ON Pedido.Id_Domiciliario = Domiciliario.Id_Domiciliario;
SELECT * FROM tiendadonpepe.Pedidos_Y_Detalles;

-- Procedimientos
-- Procedimiento para regitrar clientes nuevos
DELIMITER //
CREATE PROCEDURE Registrar_Cliente(
    IN Id_Cliente VARCHAR(6),
    IN Nombre_Cliente VARCHAR(60),
    IN Cedula_Cliente VARCHAR(30),
    IN Password_Cliente VARCHAR(30),
    IN Email_Cliente VARCHAR(80),
    IN Direccion_Cliente VARCHAR(130),
    IN Codigo_Postal_Cliente VARCHAR(30)
)
BEGIN
    INSERT INTO Cliente(Id_Cliente, Nombre_Cliente, Cedula_Cliente, Password_Cliente, Email_Cliente, Direccion_Cliente, Codigo_Postal_Cliente)
    VALUES(Id_Cliente, Nombre_Cliente, Cedula_Cliente, Password_Cliente, Email_Cliente, Direccion_Cliente, Codigo_Postal_Cliente);
END//
DELIMITER ;

-- Procedimiento para ingresar nuevos domiciliarios
DELIMITER //
CREATE PROCEDURE Registrar_Domiciliario(
    IN Id_Domiciliario VARCHAR(6),
    IN Placa_Furgoneta_Domiciliario VARCHAR(90),
    IN Nombre_Domiciliario VARCHAR(30),
    IN Codigo_Postal_Domiciliario VARCHAR(30)
)
BEGIN
    INSERT INTO Domiciliario(Id_Domiciliario, Placa_Furgoneta_Domiciliario, Nombre_Domiciliario, Codigo_Postal_Domiciliario)
    VALUES(Id_Domiciliario, Placa_Furgoneta_Domiciliario, Nombre_Domiciliario, Codigo_Postal_Domiciliario);
    
END//
DELIMITER ;
CALL Registrar_Domiciliario ('D60', 'GQD-712', 'djsfghlashdg', 'Andres lopez', '47663');
SELECT * FROM tiendadonpepe.domiciliario;

-- Procedimineto para modificar clientes 
DELIMITER //
CREATE PROCEDURE Modificar_Cliente(
  IN p_Id_Cliente VARCHAR(6),
  IN p_Nombre_Cliente VARCHAR(60),
  IN p_Cedula_Cliente VARCHAR(30),
  IN p_Password_Cliente VARCHAR(30),
  IN p_Email_Cliente VARCHAR(80),
  IN p_Direccion_Cliente VARCHAR(130),
  IN p_Codigo_Postal_Cliente VARCHAR(30)
)
BEGIN
  UPDATE Cliente
  SET Nombre_Cliente = p_Nombre_Cliente,
    Cedula_Cliente = p_Cedula_Cliente,
    Password_Cliente = p_Password_Cliente,
    Email_Cliente = p_Email_Cliente,
    Direccion_Cliente = p_Direccion_Cliente,
    Codigo_Postal_Cliente = p_Codigo_Postal_Cliente
  WHERE Id_Cliente = p_Id_Cliente;
END//
DELIMITER ;

-- Procedimiento para modificar un domiciliario registrado
DELIMITER //
CREATE PROCEDURE Modificar_Domiciliario(
  IN p_Id_Domiciliario VARCHAR(6),
  IN p_Placa_Furgoneta_Domiciliario VARCHAR(90),
  IN p_Nombre_Domiciliario VARCHAR(30),
  IN p_Codigo_Postal_Domiciliario VARCHAR(30)
)
BEGIN
  UPDATE Domiciliario
  SET Placa_Furgoneta_Domiciliario = p_Placa_Furgoneta_Domiciliario,
    Nombre_Domiciliario = p_Nombre_Domiciliario,
    Codigo_Postal_Domiciliario = p_Codigo_Postal_Domiciliario
  WHERE Id_Domiciliario = p_Id_Domiciliario;
END//
DELIMITER ;


-- Triggers
-- Creacion de tabla de notificaciones 
CREATE TABLE Notificaciones (
    Id_Notificacion INT AUTO_INCREMENT  PRIMARY KEY,
    Mensaje_Notificacion VARCHAR(150),
    Fecha_Notificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Tabla de registros de cambio tabla Cliente
 CREATE TABLE IF NOT EXISTS Registros_Cliente (
 Usuario_Cambio VARCHAR(90) NOT NULL,
 Cambio_Realizado VARCHAR(150) NOT NULL,
 Fecha_Cambio DATETIME NOT NULL,
 PRIMARY KEY (Usuario_Cambio, Cambio_Realizado, Fecha_Cambio)
);


-- Notificar la existencia de un nuevo pedido 
DELIMITER //
CREATE TRIGGER Nuevo_Pedido
AFTER INSERT ON Pedido
FOR EACH ROW
BEGIN
    DECLARE nuevoMensaje VARCHAR(150);
    SET nuevoMensaje = CONCAT('Un nuevo ha sido creado con el ID: ', NEW.Id_Pedido);
    INSERT INTO Notificaciones (Mensaje_Notificacion) VALUES (nuevoMensaje);
END
//DELIMITER ;
INSERT INTO `tiendadonpepe`.`pedido`
(`Id_Pedido`,`Id_Cliente`,`Id_Domiciliario`,`Fecha_Pedido`,`Unidades_Producto_Pedido`,`Valor_Total_Pedido`,`Numero_Tarjeta_Pago`,`Caducidad_Tarjeta_Pago`,`Direccion_Pedido`,`Codigo_Postal_Cliente`,`Codigo_Postal_Domiciliario`,`Verificacion_Zona_Pedido`)
VALUES
('Ped60', 'C35', 'D25', '15-02-2023', '6', '6735', '3333-3333-3333-3333','12-25', 'Calle falsa 123','45736','45736','Si');
SELECT * FROM tiendadonpepe.notificaciones;

-- Trigger para registrar el ingreso de nuevos clientes
DELIMITER //
CREATE TRIGGER Nuevo_Cliente
AFTER INSERT ON Cliente
FOR EACH ROW
BEGIN
 INSERT INTO Registros_Cliente (Usuario_Cambio, Cambio_Realizado, Fecha_Cambio)
 VALUES (USER(), "Agrego un nuevo cliente en", NOW());
END//
DELIMITER ;
CALL Registrar_Cliente('C61','Carlo pedro martinez', '73424287', 'dgfdgh', 'carlopedromartinez@gmail.com', 'Calle de la alegria 13', '23452');
SELECT * FROM tiendadonpepe.registros_cliente;


-- Trigger para validar que un usuario no haya sido previamente registrado
DELIMITER //
CREATE TRIGGER check_existing_client BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM Cliente WHERE Id_Cliente = NEW.Id_Cliente OR Email_Cliente = NEW.Email_Cliente) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El cliente ya existe.';
  END IF;
END;
//DELIMITER ;
CALL Registrar_Cliente('C61','Carlo pedro martinez', '73424287', 'dgfdgh', 'carlopedromartinez@gmail.com', 'Calle de la alegria 13', '23452');

 
-- Trigger para descontar del stock
DELIMITER //
CREATE TRIGGER Restar_Stock
AFTER INSERT ON Producto_Pedido
FOR EACH ROW
UPDATE Producto
JOIN Producto_Pedido ON Producto.ID_Producto = Producto_Pedido.Id_Producto
JOIN Pedido ON Pedido.Id_Pedido = Producto_Pedido.Id_Pedido
SET Producto.Unidad_Disponible_Producto = Producto.Unidad_Disponible_Producto - Pedido.Unidades_Producto_Pedido
WHERE Producto_Pedido.Id_Producto = NEW.Id_Producto AND Producto_Pedido.Id_Pedido = NEW.Id_Pedido;
//
DELIMITER ;

