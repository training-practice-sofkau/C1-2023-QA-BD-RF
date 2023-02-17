CREATE DATABASE barberia_normalizada;

USE barberia_normalizada;

CREATE TABLE empleados (
    empleado_id INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50) NOT NULL,
    PRIMARY KEY (empleado_id)
);

CREATE TABLE clientes (
    cliente_id INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    profesion VARCHAR(50),
    telefono VARCHAR(20),
    correo VARCHAR(50),
    edad INT,
    direccion VARCHAR(100),
    PRIMARY KEY (cliente_id)
);

CREATE TABLE servicios (
    servicio_id INT NOT NULL AUTO_INCREMENT,
    empleado_id INT NOT NULL,
    cliente_id INT NOT NULL,
    duracion_procedimiento INT,
    fecha DATE,
    PRIMARY KEY (servicio_id),
    FOREIGN KEY (empleado_id) 
    REFERENCES empleados(empleado_id),
    FOREIGN KEY (cliente_id) 
    REFERENCES clientes(cliente_id)
);

CREATE TABLE productos (
    producto_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    proveedor VARCHAR(50) NOT NULL,
    PRIMARY KEY (producto_id)
);

CREATE TABLE ventas (
    venta_id INT NOT NULL AUTO_INCREMENT,
    empleado_id INT NOT NULL,
    cliente_id INT NOT NULL,
    producto_id INT NOT NULL,
    fecha DATE NOT NULL,
    liga_ganancia DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (venta_id),
    FOREIGN KEY (empleado_id) 
    REFERENCES empleados(empleado_id),
    FOREIGN KEY (cliente_id) 
    REFERENCES clientes(cliente_id),
    FOREIGN KEY (producto_id) 
    REFERENCES productos(producto_id)
);

CREATE TABLE servicios_productos (
    servicio_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (servicio_id, producto_id),
    FOREIGN KEY (servicio_id)
     REFERENCES servicios(servicio_id),
    FOREIGN KEY (producto_id) 
    REFERENCES productos(producto_id)
);

CREATE TABLE citas (
    cita_id INT NOT NULL AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    empleado_id INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    PRIMARY KEY (cita_id),
    FOREIGN KEY (cliente_id)
     REFERENCES clientes(cliente_id),
    FOREIGN KEY (empleado_id) 
    REFERENCES empleados(empleado_id)
);
