CREATE DATABASE barber;

-- Crear tabla Cliente
CREATE TABLE Cliente (
  id_cliente INT PRIMARY KEY,
  nombre_cliente VARCHAR(50),
  cedula_cliente VARCHAR(20),
  profesion VARCHAR(50),
  correo VARCHAR(50),
  edad INT,
  direccion VARCHAR(50)
);

CREATE TABLE Compra(
 REF VARCHAR(10),
 id_cliente int,
 PRIMARY KEY (id_cliente, REF),
 FOREIGN KEY(REF) REFERENCES Producto(REF),
 FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);
CREATE TABLE Telefono_cliente(
	id_cliente INT PRIMARY KEY,
    numero VARCHAR(12),
    FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);


-- Crear tabla Reserva
CREATE TABLE Reserva (
  id_reserva INT PRIMARY KEY,
  id_cliente INT,
  estado VARCHAR(50),
  fecha_reserva DATE,
  descripcion VARCHAR(255),
  FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Crear tabla Cita
CREATE TABLE Cita (
  id_cita INT PRIMARY KEY,
  id_reserva INT,
  fecha DATE,
  hora TIME,
  descripcion VARCHAR(255),
  
  FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva)
);

-- Crear tabla Servicio
CREATE TABLE Servicio (
  id_servicio INT PRIMARY KEY,
  id_cita INT,
  tipo VARCHAR(50),
  duracion INT,
  
  FOREIGN KEY (id_cita) REFERENCES Cita(id_cita)
);

-- Crear tabla Historial
CREATE TABLE Historial (
  id_empleado INT,
  id_servicio INT,
  productos_consumidos VARCHAR(100),
  duracion_procedimiento INT,
  fecha_servicio DATE,
   PRIMARY KEY (id_empleado, id_servicio),
  FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado),
  FOREIGN KEY (id_servicio) REFERENCES Servicio(id_servicio)
);

-- Crear tabla Empleado
CREATE TABLE Empleado (
  id_empleado INT PRIMARY KEY,
  cedula VARCHAR(20),
  nombre_empleado VARCHAR(50),
  especialidad VARCHAR(50)
);

-- Crear tabla Factura
CREATE TABLE Factura (
  id_factura INT PRIMARY KEY,
  id_empleado INT,
  valor DOUBLE,
  fecha_factura DATE,
   FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

-- Crear tabla Producto
CREATE TABLE Producto (
  REF varchar(10) PRIMARY KEY,
  precio DOUBLE,
  cantidad INT,
  nombre_producto VARCHAR(50),
  id_proveedor INT,
  FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);
-- Crear tabla Proveedor
CREATE TABLE Proveedor (
  id_proveedor INT PRIMARY KEY,
  nombre_proveedor VARCHAR(50),
  direccion VARCHAR(50),
  correo VARCHAR(50)
);
CREATE TABLE Telefono_proveedor(
	id_proveedor INT PRIMARY KEY,
    numero VARCHAR(12),
    FOREIGN KEY(id_proveedor) REFERENCES proveedor(id_proveedor)
);
CREATE TABLE insumo(
	id_insumo int,
    nombre_insumo VARCHAR(50),
    descripcion VARCHAR(255),
    cantidad int
);
    
  
    
    
CREATE TABLE Insumo_factura(
    id_factura INT,
    id_insumo INT,
    PRIMARY KEY (id_factura, id_insumo),
	FOREIGN KEY(id_factura) REFERENCES Factura(id_factura),
	FOREIGN KEY(id_insumo) REFERENCES insumo(id_insumo)

);

CREATE INDEX idx_insumo_id ON Insumo (id_insumo);



CREATE TABLE Insumo_servicio(

	id_insumo INT,
    id_servicio INT,
    PRIMARY KEY (id_insumo, id_servicio),
	FOREIGN KEY(id_insumo) REFERENCES Insumo(id_insumo),
	FOREIGN KEY(id_servicio) REFERENCES servicio(id_servicio)
);


CREATE TABLE Producto_factura(
	REF VARCHAR(10),
    id_factura INT,
    PRIMARY KEY(REF, id_factura),
    FOREIGN KEY(REF) REFERENCES Producto(REF),
	FOREIGN KEY(id_factura) REFERENCES Factura(id_factura)

);



INSERT INTO Cliente (id_cliente, nombre_cliente, cedula_cliente, profesion, correo, edad, direccion) VALUES
(1, 'Juan Perez', '1234567890', 'Ingeniero', 'juanperez@gmail.com', 35, 'Calle 123'),
(2, 'Maria Rodriguez', '0987654321', 'Médico', 'maria.rodriguez@hotmail.com', 28, 'Avenida Principal'),
(3, 'Pedro Gomez', '4567890123', 'Abogado', 'pedrogomez@gmail.com', 42, 'Calle 456'),
(4, 'Laura Hernandez', '3216549870', 'Arquitecta', 'laurahernandez@yahoo.com', 31, 'Calle 789'),
(5, 'Andres Torres', '9876543210', 'Contador', 'andrestorres@gmail.com', 29, 'Calle 456');


INSERT INTO Reserva (id_reserva, id_cliente, estado, fecha_reserva, descripcion) VALUES
(1, 1, 'Pendiente', '2023-02-21', 'Reserva para limpieza dental'),
(2, 2, 'Confirmada', '2023-02-23', 'Reserva para consulta médica'),
(3, 3, 'Pendiente', '2023-02-25', 'Reserva para asesoría legal'),
(4, 4, 'Cancelada', '2023-02-20', 'Reserva para diseño de interiores'),
(5, 5, 'Confirmada', '2023-02-26', 'Reserva para asesoría contable');


INSERT INTO Cita (id_cita, id_reserva, fecha, hora, descripcion) VALUES
(1, 1, '2023-02-21', '10:00:00', 'Cita para limpieza dental'),
(2, 2, '2023-02-23', '14:00:00', 'Cita para consulta médica'),
(3, 3, '2023-02-25', '11:00:00', 'Cita para asesoría legal'),
(4, 4, '2023-02-20', '16:00:00', 'Cita para diseño de interiores'),
(5, 5, '2023-02-26', '09:00:00', 'Cita para asesoría contable');

INSERT INTO Servicio (id_servicio, id_cita, tipo, duracion) VALUES
(1, 1, 'Limpieza dental', 30),
(2, 2, 'Consulta médica', 60),
(3, 3, 'Asesoría legal', 120),
(4, 4, 'Diseño de interiores', 180),
(5, 5, 'Asesoría contable', 90);


INSERT INTO Empleado (id_empleado, cedula, nombre_empleado, especialidad)
VALUES 
  (1, '1234567890', 'Juan Pérez', 'Odontólogo'),
  (2, '0987654321', 'María González', 'Asistente dental'),
  (3, '2468013579', 'Pedro Rodríguez', 'Ortodoncista'),
  (4, '1357924680', 'Ana García', 'Implantóloga'),
  (5, '8642075319', 'Javier Ruiz', 'Endodoncista');
  
  INSERT INTO Proveedor (id_proveedor, nombre_proveedor, direccion, correo) VALUES
(1, 'Proveedor 1', 'Calle 123', 'proveedor1@example.com'),
(2, 'Proveedor 2', 'Avenida 456', 'proveedor2@example.com'),
(3, 'Proveedor 3', 'Boulevard 789', 'proveedor3@example.com');

INSERT INTO Producto (REF, precio, cantidad, nombre_producto, id_proveedor) VALUES
('REF1', 10.5, 50, 'Producto 1', 1),
('REF2', 15.25, 100, 'Producto 2', 2),
('REF3', 8.99, 75, 'Producto 3', 1),
('REF4', 20.0, 40, 'Producto 4', 3),
('REF5', 12.75, 60, 'Producto 5', 2);

  INSERT INTO insumo (id_insumo, nombre_insumo, descripcion, cantidad)
VALUES 
  (6, 'Navaja de afeitar', 'Herramienta utilizada para el rasurado del vello facial', 10),
  (7, 'Tijeras de peluquería', 'Tijeras específicas para cortar el cabello', 15),
  (8, 'Cepillo de barbero', 'Cepillo utilizado para quitar el exceso de cabello después de cortar', 20),
  (9, 'Peine de barbero', 'Peine utilizado para peinar el cabello antes y después del corte', 25),
  (10, 'Loción de afeitar', 'Loción que se utiliza después del afeitado para hidratar la piel', 30);
  
  
  INSERT INTO factura (id_factura, id_empleado, valor, fecha_factura)
VALUES
(1, 1, 100.50, '2021-02-17'),
(2, 2, 75.25, '2021-02-18'),
(3, 3, 200.00, '2021-02-18'),
(4, 4, 85.99, '2021-02-19'),
(5, 1, 150.00, '2021-02-19');