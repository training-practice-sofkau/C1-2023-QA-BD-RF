CREATE DATABASE TiendaVirtual;
USE TiendaVirtual;

CREATE TABLE Zona (
  CodigoPostal INT PRIMARY KEY
);

CREATE TABLE Cliente (
  Cedula INT PRIMARY KEY,
  Nombre VARCHAR(50),
  Direccion VARCHAR(100),
  Email VARCHAR(100),
  Contrasena VARCHAR(60),
  Zona_CodigoPostal INT,
  FOREIGN KEY (Zona_CodigoPostal) REFERENCES Zona(CodigoPostal)
);

CREATE TABLE Telefono_Cliente (
  Cedula_FK INT NOT NULL,
  Telefono_FK VARCHAR(15) NOT NULL,
  PRIMARY KEY (Cedula_FK, Telefono_FK),
  FOREIGN KEY (Cedula_FK) REFERENCES Cliente (Cedula)
);

CREATE TABLE Categoria (
  Nombre VARCHAR(50) PRIMARY KEY,
  CondicionesAlmacenamiento VARCHAR(100),
  Observaciones VARCHAR(200)
);



CREATE TABLE Proveedor (
  Nombre VARCHAR(50) PRIMARY KEY,
  Direccion VARCHAR(100),
  Telefono VARCHAR(15),
  Email VARCHAR(50)
);

CREATE TABLE Producto (
  ID INT PRIMARY KEY,
  Nombre VARCHAR(50),
  Marca VARCHAR(50),
  Origen VARCHAR(50),
  Volumen DECIMAL(10,2), -- Use DECIMAL para medidas físicas
  Peso DECIMAL(10,2), -- Use DECIMAL para medidas físicas
  Fotografia VARCHAR(100),
  Categoria_Nombre VARCHAR(50),
  UnidadesDisponibles INT,
  Proveedor_Nombre VARCHAR(50),
  FOREIGN KEY (Categoria_Nombre) REFERENCES Categoria(Nombre),
  FOREIGN KEY (Proveedor_Nombre) REFERENCES Proveedor(Nombre)
);

CREATE TABLE Domiciliario (
  ID INT PRIMARY KEY,
  Nombre VARCHAR(50),
  NumeroMatriculaFurgoneta VARCHAR(30), 
  Zona_CodigoPostal INT,
  FOREIGN KEY (Zona_CodigoPostal) REFERENCES Zona(CodigoPostal)
);
CREATE TABLE Pedido (
  CodigoPedido INT PRIMARY KEY,
  FechaPedido DATETIME, 
  Cliente_Cedula INT,
  Domiciliario_ID INT,
  DireccionEntrega VARCHAR(100),
  ImporteTotal DECIMAL(10,2), -- Use DECIMAL para medidas monetarias
  NumeroTarjeta VARCHAR(16),
  FechaCaducidad DATE,
  FOREIGN KEY (Cliente_Cedula) REFERENCES Cliente(Cedula),
  FOREIGN KEY (Domiciliario_ID) REFERENCES Domiciliario (ID)
);

CREATE TABLE Pedido_Producto (
  Pedido_CodigoPedido INT,
  Producto_ID INT,
  Cantidad INT NOT NULL CHECK (Cantidad >= 1), -- La cantidad mínima es 1
  PRIMARY KEY (Pedido_CodigoPedido, Producto_ID),
  FOREIGN KEY (Pedido_CodigoPedido) REFERENCES Pedido(CodigoPedido),
  FOREIGN KEY (Producto_ID) REFERENCES Producto(ID)
);

CREATE TABLE CarritoCompras (
  ID INT PRIMARY KEY,
  FechaCreacion DATETIME, 
  Cliente_Cedula INT,
  FOREIGN KEY (Cliente_Cedula) REFERENCES Cliente(Cedula)
);

CREATE TABLE CarritoCompras_Pedido (
  CarritoCompras_ID INT,
  CodigoPedido_FK INT,
  Cantidad INT NOT NULL CHECK (Cantidad >= 1), -- La cantidad mínima es 1
  PRIMARY KEY (CarritoCompras_ID, CodigoPedido_FK),
  FOREIGN KEY (CarritoCompras_ID) REFERENCES CarritoCompras(ID),
  FOREIGN KEY (CodigoPedido_FK) REFERENCES Pedido(CodigoPedido)
);



INSERT INTO Zona (CodigoPostal) VALUES (1010);
INSERT INTO Zona (CodigoPostal) VALUES (1020);
INSERT INTO Zona (CodigoPostal) VALUES (1030);

INSERT INTO Cliente (Cedula, Nombre, Direccion, Email, Contrasena, Zona_CodigoPostal)
VALUES (1012345678, 'Juan Perez', 'Calle 1 # 23-45', 'juanperez@gmail.com', 'contraseña123', 1010);
INSERT INTO Cliente (Cedula, Nombre, Direccion, Email, Contrasena, Zona_CodigoPostal)
VALUES (1023456789, 'Maria Rodriguez', 'Carrera 2 # 34-56', 'mariarodriguez@gmail.com', 'contraseña456', 1020);
INSERT INTO Cliente (Cedula, Nombre, Direccion, Email, Contrasena, Zona_CodigoPostal)
VALUES (1023456723, 'Mariaaaaa', 'Carrera 2 # 34-56', 'mariarodriguez@gmail.com', 'contraseña456', 1050);

INSERT INTO Telefono_Cliente (Cedula_FK, Telefono_FK) VALUES (1012345678, '3123456789');
INSERT INTO Telefono_Cliente (Cedula_FK, Telefono_FK) VALUES (1023456789, '3001234567');


INSERT INTO Categoria (Nombre, CondicionesAlmacenamiento, Observaciones)
VALUES ('Electrónicos', 'Almacenar en lugares secos y frescos', 'No apilar productos');
INSERT INTO Categoria (Nombre, CondicionesAlmacenamiento, Observaciones)
VALUES ('Alimentos', 'Almacenar en lugares frescos y limpios', 'Revisar fecha de caducidad antes de enviar al cliente');


INSERT INTO Proveedor (Nombre, Direccion, Telefono, Email)
VALUES ('Proveedor 1', 'Carrera 4 # 56-78', '3004567890', 'proveedor1@gmail.com');
INSERT INTO Proveedor (Nombre, Direccion, Telefono, Email)
VALUES ('Proveedor 2', 'Calle 5 # 67-89', '3101234567', 'proveedor2@gmail.com');


INSERT INTO Producto (ID, Nombre, Marca, Origen, Volumen, Peso, Fotografia, Categoria_Nombre, UnidadesDisponibles, Proveedor_Nombre)
VALUES (1, 'Celular', 'Samsung', 'Corea del Sur', 200, 0.234, 'celular.jpg', 'Electrónicos', 100, 'Proveedor 1');
INSERT INTO Producto (ID, Nombre, Marca, Origen, Volumen, Peso, Fotografia, Categoria_Nombre, UnidadesDisponibles, Proveedor_Nombre)
VALUES (2, 'Arroz', 'Diana', 'Colombia', 1000, 1.5, 'arroz.jpg', 'Alimentos', 500, 'Proveedor 2');

INSERT INTO Domiciliario (ID, Nombre, NumeroMatriculaFurgoneta, Zona_CodigoPostal)
VALUES (1, 'Pedro Gomez', 'ABC123', 1010);
INSERT INTO Domiciliario (ID, Nombre, NumeroMatriculaFurgoneta, Zona_CodigoPostal)
VALUES (2, 'Maria Hernandez', 'XYZ123', 1020);

INSERT INTO Pedido (CodigoPedido, FechaPedido, Cliente_Cedula, Domiciliario_ID, DireccionEntrega, ImporteTotal, NumeroTarjeta, FechaCaducidad)
VALUES (1, '2023-02-16 10:00:00', 1012345678, 1, 'Calle 1 # 23-45', 50000.00, '1234567890123456', '2025-01-31');
INSERT INTO Pedido (CodigoPedido, FechaPedido, Cliente_Cedula, Domiciliario_ID, DireccionEntrega, ImporteTotal, NumeroTarjeta, FechaCaducidad)
VALUES (2, '2023-02-16 14:00:00', 1023456789, 2, 'Carrera 2 # 34-56', 35000.00, '9876543210987654', '2024-11-30');

INSERT INTO Pedido_Producto (Pedido_CodigoPedido, Producto_ID, Cantidad) VALUES (1, 1, 2);
INSERT INTO Pedido_Producto (Pedido_CodigoPedido, Producto_ID, Cantidad) VALUES (2, 2, 3);

INSERT INTO CarritoCompras (ID, FechaCreacion, Cliente_Cedula) VALUES (1, '2023-02-16 16:00:00', 1012345678);
INSERT INTO CarritoCompras (ID, FechaCreacion, Cliente_Cedula) VALUES (2, '2023-02-16 18:00:00', 1023456789);

INSERT INTO CarritoCompras_Pedido (CarritoCompras_ID, CodigoPedido_FK, Cantidad) VALUES (1, 1, 1);
INSERT INTO CarritoCompras_Pedido (CarritoCompras_ID, CodigoPedido_FK, Cantidad) VALUES (2, 2, 2);



-- -----------------------------------------------------
-- ----#CONSULTAS:------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- ----#Obtener el nombre y la dirección de todos los clientes que se encuentran en la zona con código postal 1010::------------
-- -----------------------------------------------------
SELECT Nombre, Direccion
FROM Cliente
WHERE Zona_CodigoPostal = 1010;

-- -----------------------------------------------------
-- ----#Obtener el nombre, la dirección y el correo electrónico de los clientes que han realizado pedidos:------------
-- -----------------------------------------------------
SELECT DISTINCT c.Nombre, c.Direccion, c.Email
FROM Cliente c
INNER JOIN Pedido p ON c.Cedula = p.Cliente_Cedula;

-- -----------------------------------------------------
-- ----#Obtener el nombre de los proveedores que suministran productos de la categoría "Alimentos":------------
-- -----------------------------------------------------
SELECT DISTINCT Proveedor_Nombre
FROM Producto
WHERE Categoria_Nombre = 'Alimentos';

-- -----------------------------------------------------
-- ----#Obtener el nombre y la dirección de los proveedores que suministran productos con un volumen mayor a 500:------------
-- -----------------------------------------------------
SELECT Nombre, Direccion
FROM Proveedor
WHERE Nombre IN (SELECT DISTINCT Proveedor_Nombre FROM Producto WHERE Volumen > 500);

-- -----------------------------------------------------
-- ----#Obtener el nombre y la marca de todos los productos con un peso menor a 1:------------
-- -----------------------------------------------------
SELECT Nombre, Marca
FROM Producto
WHERE Peso < 1;

-- -----------------------------------------------------
-- ----#Obtener el número de teléfono de los clientes que han realizado pedidos:------------
-- -----------------------------------------------------
SELECT DISTINCT Telefono_FK
FROM Telefono_Cliente
WHERE Cedula_FK IN (SELECT DISTINCT Cliente_Cedula FROM Pedido);

-- -----------------------------------------------------
-- ----#Obtener el nombre y el número de matrícula de todas las furgonetas de domiciliarios que trabajan en la zona con código postal 1020:------------
-- -----------------------------------------------------
SELECT Nombre, NumeroMatriculaFurgoneta
FROM Domiciliario
WHERE Zona_CodigoPostal = 1020;

-- -----------------------------------------------------
-- ----#Obtener el número total de unidades disponibles de todos los productos:------------
-- -----------------------------------------------------

SELECT SUM(UnidadesDisponibles) as TotalUnidades
FROM Producto;

-- -----------------------------------------------------
-- ----#Obtener el importe total de todos los pedidos realizados:------------
-- -----------------------------------------------------
SELECT SUM(ImporteTotal) as TotalImporte
FROM Pedido;


-- -----------------------------------------------------
-- ----# Consulta para contar el número total de productos diferentes que han sido pedidos a través de la tabla "Pedido_Producto":------------
-- -----------------------------------------------------
SELECT COUNT(DISTINCT Producto_ID) as TotalProductos
FROM Pedido_Producto;


-- -----------------------------------------------------
-- ----#VISTAS:------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- ----#Vista de clientes con sus respectivas zonas y teléfonos:------------
-- -----------------------------------------------------
SELECT Cliente.Cedula, Cliente.Nombre, Zona.CodigoPostal, Telefono_Cliente.Telefono_FK
FROM Cliente
INNER JOIN Zona ON Cliente.Zona_CodigoPostal = Zona.CodigoPostal
INNER JOIN Telefono_Cliente ON Cliente.Cedula = Telefono_Cliente.Cedula_FK;

-- -----------------------------------------------------
-- ----#Vista de productos con su respectiva categoría y proveedor:------------
-- -----------------------------------------------------
SELECT Producto.ID, Producto.Nombre, Producto.Marca, Producto.Categoria_Nombre, Producto.Proveedor_Nombre
FROM Producto
INNER JOIN Categoria ON Producto.Categoria_Nombre = Categoria.Nombre
INNER JOIN Proveedor ON Producto.Proveedor_Nombre = Proveedor.Nombre;

-- -----------------------------------------------------
-- ----#Vista de pedidos con información del cliente, domiciliario y productos:------------
-- -----------------------------------------------------
SELECT Pedido.CodigoPedido, Pedido.FechaPedido, Cliente.Nombre AS NombreCliente, Domiciliario.Nombre AS NombreDomiciliario, Pedido.DireccionEntrega, Pedido.ImporteTotal, Pedido.NumeroTarjeta, Pedido.FechaCaducidad, Producto.Nombre AS NombreProducto, Pedido_Producto.Cantidad
FROM Pedido
INNER JOIN Cliente ON Pedido.Cliente_Cedula = Cliente.Cedula
INNER JOIN Domiciliario ON Pedido.Domiciliario_ID = Domiciliario.ID
INNER JOIN Pedido_Producto ON Pedido.CodigoPedido = Pedido_Producto.Pedido_CodigoPedido
INNER JOIN Producto ON Pedido_Producto.Producto_ID = Producto.ID;

-- -----------------------------------------------------
-- ----#Vista de proveedores con información de sus productos:------------
-- -----------------------------------------------------
SELECT Proveedor.Nombre, Proveedor.Direccion, Proveedor.Telefono, Proveedor.Email, Producto.Nombre AS NombreProducto, Producto.Categoria_Nombre
FROM Proveedor
INNER JOIN Producto ON Proveedor.Nombre = Producto.Proveedor_Nombre;

-- -----------------------------------------------------
-- ----#Vista de carritos de compras con información de los pedidos y el cliente:------------
-- -----------------------------------------------------
SELECT CarritoCompras.ID, CarritoCompras.FechaCreacion, Cliente.Nombre AS NombreCliente, Pedido.CodigoPedido, Pedido.FechaPedido, Pedido.ImporteTotal
FROM CarritoCompras
INNER JOIN Cliente ON CarritoCompras.Cliente_Cedula = Cliente.Cedula
INNER JOIN CarritoCompras_Pedido ON CarritoCompras.ID = CarritoCompras_Pedido.CarritoCompras_ID
INNER JOIN Pedido ON CarritoCompras_Pedido.CodigoPedido_FK = Pedido.CodigoPedido;

-- -----------------------------------------------------
-- ----#Vista de categorías de productos y sus respectivas condiciones de almacenamiento:------------
-- -----------------------------------------------------
SELECT Categoria.Nombre, Categoria.CondicionesAlmacenamiento
FROM Categoria;

-- -----------------------------------------------------
-- ----#PROCEDIMIENTOS ALMACENADOS:------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- ----##Procedimiento para agregar un nuevo producto------------
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE sp_agregar_producto(
    IN producto_id INT, 
    IN nombre_producto VARCHAR(50), 
    IN marca_producto VARCHAR(50), 
    IN origen_producto VARCHAR(50), 
    IN volumen FLOAT, 
    IN peso FLOAT, 
    IN fotografia_producto VARCHAR(50), 
    IN categoria_producto VARCHAR(50), 
    IN unidades_disponibles INT, 
    IN proveedor_producto VARCHAR(50)
)
BEGIN
    INSERT INTO Producto (ID, Nombre, Marca, Origen, Volumen, Peso, Fotografia, Categoria_Nombre, UnidadesDisponibles, Proveedor_Nombre)
    VALUES (producto_id, nombre_producto, marca_producto, origen_producto, volumen, peso, fotografia_producto, categoria_producto, unidades_disponibles, proveedor_producto);
END //  
DELIMITER ;
CALL sp_agregar_producto(6, 'Pan Tajado', 'Bimbo', 'Colombia', 1, 2.5, 'Bimbo.jpg', 'Alimentos', 400, 'Proveedor 2');
drop procedure sp_agregar_producto;
-- -----------------------------------------------------
-- ----##Procedimiento para actualizar la cantidad de unidades disponibles de un producto------------
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE sp_actualizar_unidades_disponibles(
    IN producto_id INT,
    IN nuevas_unidades INT
)
BEGIN
    UPDATE Producto
    SET UnidadesDisponibles = nuevas_unidades
    WHERE ID = producto_id;
END //
DELIMITER ;
CALL sp_actualizar_unidades_disponibles(1, 123);
-- -----------------------------------------------------
-- ----##Procedimiento para consultar inventario------------
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE sp_consultar_inventario()
BEGIN
    SELECT ID, Nombre, Marca, Origen, Volumen, Peso, Fotografia, Categoria_Nombre, UnidadesDisponibles, Proveedor_Nombre
    FROM Producto;
END //
DELIMITER ;
CALL sp_consultar_inventario();

-- -----------------------------------------------------
-- ----##Procedimiento para eliminar un producto------------
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE sp_eliminar_producto_con_pedidos(
    IN producto_id INT
)
BEGIN
    -- Eliminar los registros en Pedido_Producto que corresponden al producto
    DELETE FROM Pedido_Producto
    WHERE Producto_ID = producto_id;

    -- Eliminar el producto de la tabla Producto
    DELETE FROM Producto
    WHERE ID = producto_id;
END //
DELIMITER ;
CALL sp_eliminar_producto_con_pedidos(4);

-- -----------------------------------------------------
-- ----##Procedimiento para AGREGAR DOMICILIARIO------------
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE sp_agregar_domiciliario(
    IN domiciliario_id INT, 
    IN nombre_domiciliario VARCHAR(100), 
    IN matricula_furgoneta VARCHAR(10), 
    IN zona_codigopostal INT
)
BEGIN
    INSERT INTO Domiciliario (ID, Nombre, NumeroMatriculaFurgoneta, Zona_CodigoPostal)
    VALUES (domiciliario_id, nombre_domiciliario, matricula_furgoneta, zona_codigopostal);
END //
DELIMITER ;
CALL sp_agregar_domiciliario(3, 'Ana López', 'XYZ987', 1030);
CALL sp_agregar_domiciliario(4, 'luis', 'XYZ980', 1040);


-- -----------------------------------------------------
-- ----#CREACION DE LOS TRIGGERS: ------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- ----#Trigger para verificar si hay domiciliario disponible en esa zona que ingresa el cliente antes de registrar un cliente: ------------
-- -----------------------------------------------------

DELIMITER //
CREATE TRIGGER tr_verificar_domiciliarios
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
    DECLARE num_domiciliarios INT;

    SELECT COUNT(*) INTO num_domiciliarios
    FROM Domiciliario
    WHERE Zona_CodigoPostal = NEW.Zona_CodigoPostal;

    IF num_domiciliarios = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No existen domiciliarios para la zona del cliente';
    END IF;
END//
DELIMITER ;

-- -----------------------------------------------------
-- ----#Trigger para actualizar la cantidad de unidades disponibles de un producto: ------------
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER tr_actualizar_unidades_disponibles
AFTER INSERT ON Pedido_Producto
FOR EACH ROW
BEGIN
    UPDATE Producto
    SET UnidadesDisponibles = UnidadesDisponibles - NEW.Cantidad
    WHERE ID = NEW.Producto_ID;
END//
DELIMITER ;

-- -----------------------------------------------------
-- ----#Trigger para validar la cantidad de unidades disponibles antes de insertar un nuevo registro en la tabla "Pedido_Producto": ------------
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER tr_validar_unidades_disponibles
BEFORE INSERT ON Pedido_Producto
FOR EACH ROW
BEGIN
    DECLARE unidades_disponibles INT;
    SELECT UnidadesDisponibles INTO unidades_disponibles
    FROM Producto
    WHERE ID = NEW.Producto_ID;
    
    IF unidades_disponibles < NEW.Cantidad THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La cantidad solicitada no está disponible en el inventario';
    END IF;
END//
DELIMITER ;


