CREATE DATABASE  zoodb;

USE zoodb;

CREATE TABLE proveedor(
	nit VARCHAR(20) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    telefono VARCHAR(45) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE factura(
	id_factura VARCHAR(20) NOT NULL,
    total VARCHAR(45) NOT NULL,
    nit_proveedor_factura VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_factura),
    FOREIGN KEY (nit_proveedor_factura) REFERENCES proveedor(nit) 
);

CREATE TABLE logistico(
	id_logistico VARCHAR(20) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    telefono VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_logistico)
);

CREATE TABLE orden_compra(
	id_orden VARCHAR(20) NOT NULL,
    fecha_emision VARCHAR(45) NOT NULL,
    fecha_entrega VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    nit_proveedor_orden VARCHAR(20) NOT NULL,
    id_logistico_orden VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_orden),
    FOREIGN KEY (nit_proveedor_orden) REFERENCES proveedor(nit),
    FOREIGN KEY (id_logistico_orden) REFERENCES logistico(id_logistico)
);

CREATE TABLE alimento(
	id_alimento VARCHAR(20) NOT NULL,
    nombre_alimento VARCHAR(45) NOT NULL,
    tipo_alimento VARCHAR(45) NOT NULL,
    cantidad VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_alimento)
);

CREATE TABLE proveedor_alimento(
	id_proveedor_alimento VARCHAR(20) NOT NULL,
    id_alimento_proveedor VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_proveedor_alimento, id_alimento_proveedor),
    FOREIGN KEY (id_proveedor_alimento) REFERENCES proveedor(nit),  
    FOREIGN KEY (id_alimento_proveedor) REFERENCES alimento(id_alimento)
);

CREATE TABLE dieta(
	id_dieta VARCHAR(20) NOT NULL,
    tipo_alimento VARCHAR(45) NOT NULL,
    dosis VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_dieta)
);

CREATE TABLE animal(
	id_animal VARCHAR(20) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    clase VARCHAR(45) NOT NULL,
    especie VARCHAR(45) NOT NULL,
    fecha_nacimiento VARCHAR(45) NOT NULL,
    id_dieta_animal VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_animal),
    FOREIGN KEY (id_dieta_animal) REFERENCES dieta(id_dieta)
);

CREATE TABLE alimento_animal(
	id_alimento_animal VARCHAR(20) NOT NULL,
    id_animal_alimento VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_alimento_animal, id_animal_alimento),
    FOREIGN KEY (id_alimento_animal) REFERENCES alimento(id_alimento),  
    FOREIGN KEY (id_animal_alimento) REFERENCES animal(id_animal)
);

CREATE TABLE entrenador(
	id_entrenador VARCHAR(20) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    telefono VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_entrenador)
);

CREATE TABLE informe_animal(
	id_informe VARCHAR(20) NOT NULL,
	fecha_peso VARCHAR(45) NOT NULL,
    peso_registrado VARCHAR(45) NOT NULL,
    detalles VARCHAR(45) NOT NULL,
    id_animal_informe VARCHAR(20) NOT NULL,
    id_entrenador_informe VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_informe),
    FOREIGN KEY (id_animal_informe) REFERENCES animal(id_animal),
    FOREIGN KEY (id_entrenador_informe) REFERENCES entrenador(id_entrenador)
);

CREATE TABLE veterinario(
	id_veterinario VARCHAR(20) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    telefono VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_veterinario)
);

CREATE TABLE veterinario_informe(
	id_veterinario_informe VARCHAR(20) NOT NULL,
    id_informe_veterinario VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_veterinario_informe, id_informe_veterinario),
    FOREIGN KEY (id_veterinario_informe) REFERENCES veterinario(id_veterinario),  
    FOREIGN KEY (id_informe_veterinario) REFERENCES informe_animal(id_informe)
);

CREATE TABLE veterinario_dieta(
	id_veterinario_dieta VARCHAR(20) NOT NULL,
    id_dieta_veterinario VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_veterinario_dieta,  id_dieta_veterinario),
    FOREIGN KEY (id_veterinario_dieta) REFERENCES veterinario(id_veterinario),  
    FOREIGN KEY (id_dieta_veterinario) REFERENCES dieta(id_dieta)
);




