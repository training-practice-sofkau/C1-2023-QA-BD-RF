CREATE DATABASE IF NOT EXISTS TiendaDonPepeSanty;
USE  TiendaDonPepeSanty;

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
  VerificacionRealizacionPedido VARCHAR (30),
  CodigoPostalCliente VARCHAR(30),
  CodigoPostalDomiciliario VARCHAR(30),
  DireccionPedido VARCHAR(30),
  UnidadesPedidas INT,
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

-- Vista que muestra el numero total de pedidos por domiciliario:
CREATE VIEW PedidosPorDomiciliario AS
SELECT pe.FKIdDomiciliario, COUNT(pe.IdPedido) AS NumeroPedidos
FROM Pedido pe
GROUP BY pe.FKIdDomiciliario;




-- TRIGGERS 

-- Trigger para descontar del stock

DELIMITER //
CREATE TRIGGER descontar_unidades
AFTER INSERT ON contener
FOR EACH ROW
UPDATE Producto p
JOIN contener c ON p.IdProducto = c.FKIdContenerProductoPedido
JOIN Pedido ped ON ped.IdPedido = c.FKIdContenerPedidoProducto
SET p.UnidadesDisponibles = p.UnidadesDisponibles - ped.UnidadesPedidas
WHERE c.FKIdContenerProductoPedido = NEW.FKIdContenerProductoPedido AND c.FKIdContenerPedidoProducto = NEW.FKIdContenerPedidoProducto;
//DELIMITER ;

-- Tabla notificacion 
CREATE TABLE Notificacion (
    IdNotificacion INT AUTO_INCREMENT  PRIMARY KEY,
    Mensaje VARCHAR(100),
    Fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);







SELECT * FROM information_schema.tables WHERE table_name = 'Notificacion';

DELIMITER //
CREATE TRIGGER tr_notificacion_nuevo_pedido
AFTER INSERT ON Pedido
FOR EACH ROW
BEGIN
    DECLARE mensaje VARCHAR(255);
    SET mensaje = CONCAT('Se ha registrado un nuevo pedido con ID ', NEW.IdPedido);
    INSERT INTO Notificacion (Mensaje) VALUES (mensaje);
END
//DELIMITER ;



 DROP TRIGGER tr_notificacion_nuevo_pedido
