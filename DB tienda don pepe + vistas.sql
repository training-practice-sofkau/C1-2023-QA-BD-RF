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


