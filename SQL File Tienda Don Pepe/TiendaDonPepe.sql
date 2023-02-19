CREATE DATABASE IF NOT EXISTS TiendaDonPepe;
USE  TiendaDonPepe;

-- Tabla cliente
CREATE TABLE cliente (
  IdCliente VARCHAR(30) PRIMARY KEY,
  Password VARCHAR(30),
  Email VARCHAR(30),
  NombreCliente VARCHAR(30),
  ApellidoCliente VARCHAR(30),
  ClienteCedula VARCHAR(30),
  Barrio VARCHAR(30),
  NumeroCasa VARCHAR(30)
);

-- Tabla TelefonoClIENTE
CREATE TABLE TelefonoCliente (
  IdTelefono INT PRIMARY KEY,
  FKIdCliente VARCHAR(30),
  NumeroTelefono VARCHAR(30),
  CONSTRAINT FK_TelefonoCliente_Cliente FOREIGN KEY (FKIdCliente)
    REFERENCES Cliente (IdCliente)
);
-- Tabla Domiciliario
CREATE TABLE Domiciliario (
  IdDomiciliario VARCHAR(30) PRIMARY KEY,
  NumeroMatricula VARCHAR(30),
  NombreDomiciliario VARCHAR(30),
  ApellidoDomiciliario VARCHAR(30)
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
  IdProveedor VARCHAR(30) PRIMARY KEY,
  NombreProveedor VARCHAR(30),
  TelefonoProveedor VARCHAR(30)
);


-- Tabla Tipo Almacenamiento
CREATE TABLE TipoAlmacenamiento (
  IdTipoAlmacenamiento VARCHAR(30) PRIMARY KEY,
  TipoDeAlmacenaminento VARCHAR(30)
);

-- Tabla Categoria Producto
CREATE TABLE CategoriaProducto (
  IdCategoriaProducto VARCHAR(30) PRIMARY KEY,
  Recomendaciones VARCHAR(30),
  FKIdTipoAlmacenamiento VARCHAR(30),
  CONSTRAINT FKCategoriaProductoTipoAlmacenamiento FOREIGN KEY (FKIdTipoAlmacenamiento)
    REFERENCES TipoAlmacenamiento (IdTipoAlmacenamiento)
);

-- Tabla Pedido
CREATE TABLE Pedido (
  IdPedido VARCHAR(30) PRIMARY KEY,
  FKIdCliente VARCHAR(30),
  FKIdDomiciliario VARCHAR(30),
  FechaPedido VARCHAR(30),
  ImporteTotalPedido VARCHAR(30),
  VerificacionRealizacionPedido BOOLEAN,
  CodigoPostalCliente VARCHAR(30),
  CodigoPostalDomiciliario VARCHAR(30),
  ProductosPedidos VARCHAR(30),
  CONSTRAINT FKPedidoCliente FOREIGN KEY (FKIdCliente)
    REFERENCES Cliente (IdCliente),
  CONSTRAINT FKPedidoDomiciliario FOREIGN KEY (FKIdDomiciliario)
    REFERENCES Domiciliario (IdDomiciliario)
);


-- Tabla Producto
CREATE TABLE Producto (
  IdProducto VARCHAR(30) PRIMARY KEY,
  FKIdCategoriaProducto VARCHAR(30),
  FKIdProveedor VARCHAR(30),
  FKIdPedido VARCHAR(30),
  Fotografia VARCHAR(30),
  UnidadesDisponibles INT,
  Observaciones VARCHAR(30),
  Volumen VARCHAR(30),
  Peso VARCHAR(30),
  Nombre VARCHAR(30),
  CONSTRAINT FKProductoCategoriaProducto FOREIGN KEY (FKIdCategoriaProducto)
    REFERENCES CategoriaProducto (IdCategoriaProducto),
  CONSTRAINT FKProductoProveedor FOREIGN KEY (FKIdProveedor)
    REFERENCES Proveedor (IdProveedor),
  CONSTRAINT FKProductoPedido FOREIGN KEY (FKIdPedido)
    REFERENCES Pedido (IdPedido)
);

-- Tabla Contener

CREATE TABLE Contener (
  FKIdContenerPedidoProducto VARCHAR(30),
  FKIdContenerProductoPedido VARCHAR(30),
  PRIMARY KEY (FKIdContenerPedidoProducto,FKIdContenerProductoPedido),
  foreign key(FKIdContenerPedidoProducto) references Pedido(IdPedido),
  foreign key(FKIdContenerProductoPedido) references Producto(IdProducto)
);



--                   CONSULTAS               ---


-- Mostrar la cantidad total de unidades disponibles de cada producto:
SELECT p.Nombre AS NombreProducto, SUM(p.UnidadesDisponibles) AS TotalUnidades
FROM Producto p
GROUP BY p.Nombre;


-- Mostrar todos los pedidos realizados por un cliente específico:
SELECT p.IdPedido, p.FechaPedido, p.ImporteTotalPedido, d.NombreDomiciliario, p.VerificacionRealizacionPedido
FROM Pedido p
INNER JOIN Domiciliario d ON p.FKIdDomiciliario = d.IdDomiciliario
WHERE p.FKIdCliente = '1';

----- Mostrar el número total de pedidos realizados por cada cliente:
SELECT c.NombreCliente, COUNT(p.IdPedido) AS TotalPedidos
FROM Cliente c
LEFT JOIN Pedido p ON c.IdCliente = p.FKIdCliente
GROUP BY c.NombreCliente;


-- Importe total de los pedidos de cada cliente
SELECT pe.IdPedido, pe.ImporteTotalPedido
FROM Pedido pe
WHERE pe.FKIdCliente = '1'
ORDER BY pe.fechaPedido DESC;

-- Mostrar la lista de todos los domiciliarios con su número de matrícula y el número de pedidos que han entregado:
SELECT d.NombreDomiciliario, d.NumeroMatricula, COUNT(p.IdPedido) AS TotalPedidos
FROM Domiciliario d
LEFT JOIN Pedido p ON d.IdDomiciliario = p.FKIdDomiciliario
GROUP BY d.NombreDomiciliario, d.NumeroMatricula;

-- Mostrar la cantidad total de productos suministrados por cada proveedor:
SELECT pr.NombreProveedor, COUNT(p.IdProducto) AS TotalProductos
FROM Proveedor pr
LEFT JOIN Producto p ON pr.IdProveedor = p.FKIdProveedor
GROUP BY pr.NombreProveedor;

-- Mostrar el nombre y el apellido de los clientes que han realizado algún pedido:
SELECT NombreCliente, ApellidoCliente
FROM Cliente
WHERE IdCliente IN (SELECT FKIdCliente FROM Pedido);

-- Mostrar la cantidad de pedidos realizados por cada domiciliario, ordenados de forma descendente:
SELECT d.NombreDomiciliario, d.ApellidoDomiciliario, COUNT(*) AS CantidadPedidos
FROM Domiciliario d
INNER JOIN Pedido pe ON d.IdDomiciliario = pe.FKIdDomiciliario
GROUP BY d.IdDomiciliario
ORDER BY CantidadPedidos DESC;


-- Mostrar el nombre y el importe total de los pedidos realizados por el cliente con IdCliente = '1', ordenados por fecha de forma descendente:
SELECT pe.IdPedido, pe.ImporteTotalPedido
FROM Pedido pe
WHERE pe.FKIdCliente = '1'
ORDER BY pe.fechaPedido DESC;

-- Mostrar el nombre y el teléfono del proveedor del producto con IdProducto = '1':
SELECT p.NombreProveedor, p.TelefonoProveedor
FROM Proveedor p
INNER JOIN Producto pr ON p.IdProveedor = pr.FKIdProveedor
WHERE pr.IdProducto = '1';


-- VISTAS 


-- Vista que muestra Vista que muestra el nombre y el importe total de todos los pedidos realizados por los clientes:

CREATE VIEW ImporteTotalPedidos AS
SELECT pe.FKIdCliente, c.NombreCliente, c.ApellidoCliente, SUM(pe.ImporteTotalPedido) AS ImporteTotal
FROM Pedido pe
INNER JOIN Cliente c ON pe.FKIdCliente = c.IdCliente
GROUP BY pe.FKIdCliente, c.NombreCliente, c.ApellidoCliente;


-- Vista que nos muestra el total de pedidos por el codigo Postal
CREATE VIEW PedidosPorCodigoPostal AS
SELECT pe.CodigoPostalCliente, COUNT(pe.IdPedido) AS NumeroPedidos
FROM Pedido pe
GROUP BY pe.CodigoPostalCliente; 



-- Vista que muestra el Id de los productos y el número de pedidos en los que han sido incluidos:
CREATE VIEW PedidosPorDomiciliario AS
SELECT pe.FKIdDomiciliario, COUNT(pe.IdPedido) AS NumeroPedidos
FROM Pedido pe
GROUP BY pe.FKIdDomiciliario;

-- TRIGGERS 

-- Para crear un Trigger que disminuya el número de unidades disponibles del producto cada vez que se realice un pedido, podemos utilizar el siguiente código:




DELIMITER //
CREATE TRIGGER notificar_pedido_realizado
AFTER INSERT ON Pedido
FOR EACH ROW
BEGIN
    DECLARE cliente_nombre VARCHAR(30);
    DECLARE cliente_email VARCHAR(30);
    DECLARE producto_nombre VARCHAR(30);
    DECLARE producto_cantidad INT;
    DECLARE mensaje VARCHAR(1000);
    
    SELECT NombreCliente, Email 
    INTO cliente_nombre, cliente_email
    FROM Cliente
    WHERE IdCliente = NEW.FKIdCliente;
    
    SELECT Nombre
    INTO producto_nombre
    FROM Producto
    WHERE IdProducto = NEW.FKIdProducto;
    
    SET producto_cantidad = NEW.CantidadProductos;
    
    SET mensaje = CONCAT('El cliente ', cliente_nombre, ' (', cliente_email, ') ha realizado un pedido de ', producto_cantidad, ' unidades del producto ', producto_nombre, '.');
    
    -- Enviar el mensaje a un sistema de notificación, por ejemplo, un correo electrónico o una API de mensajería.
    -- En este caso, simplemente se mostrará el mensaje en la consola.
    SELECT mensaje;
END
//DELIMITER ;

-- ALTER TABLE usuarios MODIFY edad VARCHAR(50);

-- IMPORTANTE  TRIGGER FINAL 

DELIMITER //
CREATE TRIGGER descontar_unidades
AFTER INSERT ON Pedido
FOR EACH ROW
UPDATE Producto
SET UnidadesDisponibles = UnidadesDisponibles - NEW.ProductosPedidos
WHERE IdProducto= NEW.producto_id;
//DELIMITER ;