-- -----------------------------------------------------
-- Creando y usando la BD
-- -----------------------------------------------------
CREATE DATABASE ocochosBarberia;
USE ocochosBarberia;

-- -----------------------------------------------------
-- Se crean las tablas correspondientes
-- -----------------------------------------------------
-- Tabla Proveedor
CREATE TABLE proveedor (
	idProveedor INT AUTO_INCREMENT,
    nombreProveedor VARCHAR(40),
    teléfonoProveedor VARCHAR(20),
    PRIMARY KEY (idProveedor)
);

-- Tabla Producto
CREATE TABLE producto (
	REFProducto INT AUTO_INCREMENT,
    nombreProducto VARCHAR(40),
    cantidadProducto INT DEFAULT 0,
    precioProducto FLOAT DEFAULT 0,
    PRIMARY KEY (REFProducto)
);

-- Tabla Insumo
CREATE TABLE insumo (
	REFInsumo INT AUTO_INCREMENT,
    nombreInsumo VARCHAR(40),
    cantidadInsumo INT DEFAULT 0,
    PRIMARY KEY (REFInsumo)
);

-- Tabla Proveer Prodcuto
CREATE TABLE proveerP (
	idProveedorP INT,
    REFProductoP INT,
    PRIMARY KEY (idProveedorP, REFProductoP),
    FOREIGN KEY (idProveedorP) REFERENCES proveedor (idProveedor),
    FOREIGN KEY (REFProductoP) REFERENCES producto (REFProducto)
);

-- Tabla Proveer Insumo
CREATE TABLE proveerI (
	idProveedorI INT,
    REFInsumoI INT,
    PRIMARY KEY (idProveedorI, REFInsumoI),
    FOREIGN KEY (idProveedorI) REFERENCES proveedor (idProveedor),
    FOREIGN KEY (REFInsumoI) REFERENCES insumo (REFInsumo)
);

-- Tabla Cliente
CREATE TABLE cliente (
	idCliente INT AUTO_INCREMENT,
    nombreCliente VARCHAR(40),
    correo VARCHAR(100),
    teléfonoCliente VARCHAR(20),
    PRIMARY KEY (idCliente)
);

-- Tabla Empleado
CREATE TABLE empleado (
	idEmpleado INT AUTO_INCREMENT,
    nombreEmpleado VARCHAR(40),
    cédula VARCHAR(20),
    PRIMARY KEY (idEmpleado)
);

-- Tabla Especialidad del Empleado
CREATE TABLE especialidad (
	idEmpleadoE INT,
    especialidad VARCHAR(30),
    PRIMARY KEY (idEmpleadoE, especialidad),
    FOREIGN KEY (idEmpleadoE) REFERENCES empleado (idEmpleado)
);

-- Tabla Cita
CREATE TABLE cita (
	idCita INT AUTO_INCREMENT,
    fechaCita VARCHAR(100),    
    idClienteC INT,
    idEmpleadoC INT,
    PRIMARY KEY (idCita),
    FOREIGN KEY (idClienteC) REFERENCES cliente (idCliente),
    FOREIGN KEY (idEmpleadoC) REFERENCES empleado (idEmpleado)
);

-- Tabla Venta
CREATE TABLE venta (
	idVenta INT AUTO_INCREMENT,
	liga FLOAT DEFAULT 0,
    fechaVenta VARCHAR(100),
    idClienteV INT,
    idEmpleadoV INT,
    PRIMARY KEY (idVenta),
    FOREIGN KEY (idClienteV) REFERENCES cliente (idCliente),
    FOREIGN KEY (idEmpleadoV) REFERENCES empleado (idEmpleado)
);

-- Tabla Vender
CREATE TABLE vender (
	idVentaV INT,
    REFProductoV INT,
    PRIMARY KEY (idVentaV, REFProductoV),
    FOREIGN KEY (idVentaV) REFERENCES venta (idVenta),
    FOREIGN KEY (REFProductoV) REFERENCES producto (REFProducto)
);

-- Tabla Servicio
CREATE TABLE servicio (
	idServicio INT AUTO_INCREMENT,
	duración INT DEFAULT 0, -- ¡En horas!
    fechaServicio VARCHAR(100),
    descripción VARCHAR(250),
    idClienteS INT,
    idEmpleadoS INT,
    PRIMARY KEY (idServicio),
    FOREIGN KEY (idClienteS) REFERENCES cliente (idCliente),
    FOREIGN KEY (idEmpleadoS) REFERENCES empleado (idEmpleado)
);

-- Tabla Procedimiento
CREATE TABLE procedimiento (
	tipo VARCHAR(40) DEFAULT 'CORTE',
    precioProcedimiento FLOAT DEFAULT 0,
    PRIMARY KEY (tipo)
);

-- Tabla Realizar
CREATE TABLE realizar (
	idServicioR INT,
    tipoR VARCHAR(40) DEFAULT 'CORTE',
    PRIMARY KEY (idServicioR, tipoR),
    FOREIGN KEY (idServicioR) REFERENCES servicio (idServicio),
    FOREIGN KEY (tipoR) REFERENCES procedimiento (tipo)
);

-- Tabla Usar
CREATE TABLE usar (
	idServicioU INT,
    REFInsumoU INT,
    PRIMARY KEY (idServicioU, REFInsumoU),
    FOREIGN KEY (idServicioU) REFERENCES servicio (idServicio),
    FOREIGN KEY (REFInsumoU) REFERENCES insumo (REFInsumo)
);
