
CREATE SCHEMA IF NOT EXISTS barberia DEFAULT CHARACTER SET utf8 ;

USE barberia ;

#  Tabla proveedor

CREATE TABLE IF NOT EXISTS proveedor (
  NIT INT NOT NULL,
  nombre VARCHAR(25) NOT NULL,
  direccion VARCHAR(30) NOT NULL,
  PRIMARY KEY (NIT));


# Tabla producto

CREATE TABLE IF NOT EXISTS producto (
  REF INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  cantidad INT NOT NULL,
  precioCompra DOUBLE NOT NULL,
  precioVenta DOUBLE NOT NULL,
  NITProveedor INT NOT NULL,
  PRIMARY KEY (REF),
    FOREIGN KEY (NITProveedor) REFERENCES proveedor (NIT));


#Tabla insumo

CREATE TABLE IF NOT EXISTS insumo (
  REF INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  cantidad INT NOT NULL,
  precioCompra DOUBLE NOT NULL,
  NITProveedor INT NOT NULL,
  PRIMARY KEY (REF),
    FOREIGN KEY (NITProveedor) REFERENCES proveedor (NIT));


# Tabla cliente

CREATE TABLE IF NOT EXISTS cliente (
  id INT NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  cedula VARCHAR(15) NOT NULL,
  correo VARCHAR(30) NOT NULL,
  edad VARCHAR(3) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));


# Tabla empleado

CREATE TABLE IF NOT EXISTS empleado (
  id INT NOT NULL,
  cedula VARCHAR(15) NOT NULL,
  nombre VARCHAR(25) NOT NULL,
  PRIMARY KEY (id));


# Tabla cotización 

CREATE TABLE IF NOT EXISTS cotizacion (
  id INT NOT NULL,
  descripcion VARCHAR(50) NOT NULL,
  idCliente INT NOT NULL,
  idEmpleado INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES cliente (id),
    FOREIGN KEY (idEmpleado) REFERENCES empleado (id));

# Tabla venta 

CREATE TABLE IF NOT EXISTS venta (
  id INT NOT NULL,
  valorTotal DOUBLE NOT NULL,
  liga DOUBLE NOT NULL,
  fecha DATE NOT NULL,
  idProducto INT NOT NULL,
  idCotizacion INT NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (idProducto) REFERENCES producto (REF),
    FOREIGN KEY (idCotizacion) REFERENCES cotizacion(id));


# Tabla telefono cliente

CREATE TABLE IF NOT EXISTS telefonoCliente (
  idCliente INT NOT NULL,
  telefono VARCHAR(20) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES cliente (id));

# Tabla correo cliente

CREATE TABLE IF NOT EXISTS correoCliente (
  idCliente INT NOT NULL,
  correo VARCHAR(30) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES cliente (id));

# Tabla profesion cliente

CREATE TABLE IF NOT EXISTS profesionCliente(
  idCliente INT NOT NULL,
  profesion VARCHAR(30) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES cliente (id));

# Tabla especialidad empleado

CREATE TABLE IF NOT EXISTS especialidadEmpleado (
  idEmpleado INT NOT NULL,
  especialidad VARCHAR(30) NOT NULL,
    FOREIGN KEY (idEmpleado) REFERENCES empleado (id));


# Tabla cita

CREATE TABLE IF NOT EXISTS cita (
  id INT NOT NULL,
  idCliente INT NOT NULL,
  fechaSolicitda DATE NOT NULL,
  horaSolicitada VARCHAR(10) NOT NULL,
  PRIMARY KEY (id, idCliente),
    FOREIGN KEY (idCliente) REFERENCES cliente (id));


# Tabla servicio

CREATE TABLE IF NOT EXISTS servicio (
  id INT NOT NULL,
  idCita INT NOT NULL,
  precio DOUBLE NOT NULL,
  descripción VARCHAR(50) NOT NULL,
  fecha DATE NOT NULL,
  duracion DOUBLE NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (idCita) REFERENCES cita (id));


#Tabla servicio empleado

CREATE TABLE IF NOT EXISTS servicioEmpleado (
  idServicio INT NOT NULL,
  idEmpleado INT NOT NULL,
    FOREIGN KEY (idEmpleado) REFERENCES empleado (id),
    FOREIGN KEY (idServicio) REFERENCES servicio (id));


# Tabla servicio insumo
CREATE TABLE IF NOT EXISTS servicioInsumo (
  idServicio INT NOT NULL,
  REFinsumo INT NOT NULL,
    FOREIGN KEY (idServicio) REFERENCES servicio (id),
    FOREIGN KEY (REFinsumo) REFERENCES insumo (REF));


