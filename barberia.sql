CREATE DATABASE barberia;

USE barberia;

CREATE TABLE empleados (
    ID INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE clientes (
    ID INT NOT NULL AUTO_INCREMENT,
    cedula VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    profesion VARCHAR(50),
    telefono VARCHAR(20),
    correo VARCHAR(50),
    edad INT,
    direccion VARCHAR(100),
    PRIMARY KEY (ID)
);

CREATE TABLE servicios (
    ID INT NOT NULL AUTO_INCREMENT,
    empleado_id INT NOT NULL,
    cliente_id INT NOT NULL,
    productos_consumidos VARCHAR(100),
    duracion_procedimiento INT,
    fecha DATE,
    PRIMARY KEY (ID),
    FOREIGN KEY (empleado_id) REFERENCES empleados(ID),
    FOREIGN KEY (cliente_id) REFERENCES clientes(ID)
);

CREATE TABLE citas (
    ID INT NOT NULL AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    empleado_id INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (cliente_id) REFERENCES clientes(ID),
    FOREIGN KEY (empleado_id) REFERENCES empleados(ID)
);

CREATE TABLE productos (
    REF INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    proveedor VARCHAR(50) NOT NULL,
    PRIMARY KEY (REF)
);

CREATE TABLE ventas (
    ID INT NOT NULL AUTO_INCREMENT,
    empleado_id INT NOT NULL,
    cliente_id INT NOT NULL,
    producto_id INT NOT NULL,
    fecha DATE NOT NULL,
    liga_ganancia DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (empleado_id) REFERENCES empleados(ID),
    FOREIGN KEY (cliente_id) REFERENCES clientes(ID),
    FOREIGN KEY (producto_id) REFERENCES productos(REF)
);