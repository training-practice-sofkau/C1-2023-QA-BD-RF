
CREATE DATABASE zoologico; 

use zoologico;

#Tabla Veterinario
CREATE TABLE veterinario (
  id_veterinario VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  PRIMARY KEY (id_veterinario)
);

#Tabla dieta
CREATE TABLE dieta (
  id_dieta VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  dosis VARCHAR(45) NOT NULL,
  veterinario_id_d VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_dieta),  
  FOREIGN KEY (veterinario_id_d) REFERENCES veterinario(id_veterinario)
  ); 

#Tabla animal
CREATE TABLE animal (
  id_animal VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  sexo_animal VARCHAR(45) NULL,
  edad VARCHAR(45) NULL,
  tipo_especie VARCHAR(25) NOT NULL,
  dieta_id_a VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_animal),
  FOREIGN KEY (dieta_id_a)REFERENCES dieta(id_dieta)
);

#Tabla entrenador
CREATE TABLE entrenador (
  id_entrenador VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  PRIMARY KEY (id_entrenador)
  );

#Tabla de Proveedor
CREATE TABLE proveedor (
  id_proveedor VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  PRIMARY KEY (id_proveedor)
  );

#Tabla de alimento
CREATE TABLE alimento (
  id_alimento VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  cantidad VARCHAR(45) NULL,
  PRIMARY KEY (id_alimento)
  );

#Tabla de factura
CREATE TABLE factura (
  id_factura VARCHAR(10) NOT NULL,
  fecha VARCHAR(45) NULL,
  detalle VARCHAR(100),
  total DECIMAL(10) NOT NULL,
  proveedor_id_o VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_factura),
  FOREIGN KEY (proveedor_id_o)REFERENCES proveedor(id_proveedor)
  );

#Tabla de logistico
CREATE TABLE logistico(
  id_logistico VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  PRIMARY KEY (id_logistico)
  );  

#Tabla de orden_compra
CREATE TABLE orden_compra(
  id_orden VARCHAR(10) NOT NULL,
  fecha VARCHAR(45) NULL,
  detalle VARCHAR(45) NOT NULL,
  logistico_id_p VARCHAR(10) NOT NULL,
  proveedor_id_l VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_orden),
  FOREIGN KEY (logistico_id_p)REFERENCES logistico(id_logistico),
  FOREIGN KEY (proveedor_id_l)REFERENCES proveedor(id_proveedor)
  );

#Tabla dieta_alimento
CREATE TABLE dieta_alimento(
  dieta_id_a VARCHAR(10) NOT NULL,
  alimento_id_d VARCHAR(10) NOT NULL,
  PRIMARY KEY (dieta_id_a, alimento_id_d),
  FOREIGN KEY (dieta_id_a)REFERENCES dieta(id_dieta),
  FOREIGN KEY (alimento_id_d)REFERENCES alimento(id_alimento)
  );

#Tabla proveedor_alimento
CREATE TABLE proveedor_alimento(
  proveedor_id_a VARCHAR(10) NOT NULL,
  alimento_id_p VARCHAR(10) NOT NULL,
  PRIMARY KEY (proveedor_id_a,alimento_id_p),
  FOREIGN KEY (proveedor_id_a)REFERENCES proveedor(id_proveedor),
  FOREIGN KEY (alimento_id_p)REFERENCES alimento(id_alimento)
  );

#Tabla Informe Peso
CREATE TABLE informe_peso(
  id_informe VARCHAR(10) NOT NULL,
  fecha VARCHAR(45) NULL,
  peso_animal VARCHAR(45) NULL,
  detalle VARCHAR(45) NULL,
  entrenador_id_i VARCHAR(10) NOT NULL,
  animal_id_i VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_informe),
  FOREIGN KEY(entrenador_id_i)REFERENCES entrenador(id_entrenador),
  FOREIGN KEY (animal_id_i)REFERENCES animal(id_animal)
  );

#Tabla informe_veterinario
CREATE TABLE informe_veterinario(
  informe_peso_id_v VARCHAR(10) NOT NULL,
  veterinario_id_i VARCHAR(10) NOT NULL,
  PRIMARY KEY (informe_peso_id_v,veterinario_id_i),
  FOREIGN KEY (informe_peso_id_v)REFERENCES informe_peso(id_informe),    
  FOREIGN KEY (veterinario_id_i)REFERENCES veterinario(id_veterinario)
  );

#Tabla telefono_proveedor
CREATE TABLE telefono_proveedor(
  proveedor_id_proveedor VARCHAR(10) NOT NULL,
  telefono_proveedor VARCHAR(45) NOT NULL,  
  PRIMARY KEY (proveedor_id_proveedor,telefono_proveedor),
  FOREIGN KEY (proveedor_id_proveedor)REFERENCES proveedor(id_proveedor)
  );