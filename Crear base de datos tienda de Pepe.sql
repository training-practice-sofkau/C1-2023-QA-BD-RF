CREATE SCHEMA IF NOT EXISTS `TiendaDonPepe`;
USE `TiendaDonPepe` ;

-- Crear tabla Zona
CREATE TABLE IF NOT EXISTS Zona (
  IdZona VARCHAR(10) PRIMARY KEY,
  codigoPostal VARCHAR(20)
);
-- Crear tabla cliente
CREATE TABLE IF NOT EXISTS Cliente (
  CedulaCliente VARCHAR(15) PRIMARY KEY,
  NombreCliente VARCHAR(45),
  Direccion VARCHAR(150),
  Email VARCHAR(45),
  Password VARCHAR(45),
  IdZona VARCHAR(10),
  FOREIGN KEY (IdZona) REFERENCES Zona (IdZona)
);
-- Crear tabla Domiciliario
CREATE TABLE IF NOT EXISTS Domiciliario (
  idDomiciliario VARCHAR(10) PRIMARY KEY,
  NombreDomiciliario VARCHAR(45),
  NumeroMatricula VARCHAR(45),
  idZona VARCHAR(10),
  FOREIGN KEY (idZona) REFERENCES Zona(IdZona)
);
-- Crear tabla CestaCompra
CREATE TABLE IF NOT EXISTS CestaCompras (
  idCestaCompras VARCHAR(10) PRIMARY KEY,
  FechaCreacion VARCHAR(45),
  CedulaCliente VARCHAR(15),
  FOREIGN KEY (CedulaCliente) REFERENCES Cliente(CedulaCliente)
  );
-- Crear tabla pedido
CREATE TABLE IF NOT EXISTS Pedido(
  CodigoPedido VARCHAR(10) PRIMARY KEY,
  FechaPedido VARCHAR(45),
  DireccionEntrega VARCHAR(150),
  ImporteTotal INT,
  DatosDePago VARCHAR(45),
  CedulaCliente VARCHAR(15),
  FOREIGN KEY (CedulaCliente) REFERENCES Cliente(CedulaCliente),
  idDomiciliario VARCHAR(10),
  FOREIGN KEY (idDomiciliario) REFERENCES Domiciliario(idDomiciliario),
  idCestaCompras VARCHAR(10),
  FOREIGN KEY (idCestaCompras) REFERENCES CestaCompras(idCestaCompras)
  );
  -- Crear tabla Categoria
  CREATE TABLE IF NOT EXISTS Categoria (
  NombreCategoria VARCHAR(45) PRIMARY KEY,
  Condiciones VARCHAR(45),
  Observaciones VARCHAR(150)
  );
  -- Crear tabla producto
  CREATE TABLE IF NOT EXISTS Producto(
  NombreProducto VARCHAR(45) PRIMARY KEY,
  Marca VARCHAR(45),
  Origen VARCHAR(45),
  Dimensiones VARCHAR(45),
  UnidadesDisponibles INT,
  NombreCategoria VARCHAR(45),
  FOREIGN KEY (NombreCategoria) REFERENCES Categoria(NombreCategoria)
  );
  -- Crear tabla ProductosCesta
  CREATE TABLE IF NOT EXISTS ProductoCesta(
	NombreProducto VARCHAR(45),
	idCestaCompras VARCHAR(10),
	UnidadesSeleccionadas INT,
    PRIMARY KEY (NombreProducto, idCestaCompras),
	FOREIGN KEY (NombreProducto) REFERENCES Producto(NombreProducto),
	FOREIGN KEY (idCestaCompras) REFERENCES CestaCompras(idCestaCompras)
  );
  -- Crear tabla TelefonoCliente
  CREATE TABLE IF NOT EXISTS Telefono_Cliente (
	CedulaCliente VARCHAR(15),
	TelefonoCliente VARCHAR(15),
	PRIMARY KEY (CedulaCliente, TelefonoCliente),
    FOREIGN KEY (CedulaCliente) REFERENCES Cliente(CedulaCliente)
    );
