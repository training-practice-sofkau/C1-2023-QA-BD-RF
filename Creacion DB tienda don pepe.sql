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
  Id_Pedido VARCHAR(6),
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