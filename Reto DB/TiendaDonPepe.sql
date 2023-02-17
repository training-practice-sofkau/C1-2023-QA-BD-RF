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

SELECT pe.IdPedido, pe.ImporteTotalPedido
FROM Pedido pe
WHERE pe.FKIdCliente = '1'
ORDER BY pe.fechaPedido DESC;


SELECT Nombre, Precio
FROM Producto
WHERE FKIdCategoriaProducto = '2'
ORDER BY Precio ASC

