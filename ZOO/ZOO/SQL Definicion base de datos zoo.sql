#Se crea base de datos
CREATE DATABASE zoologico;
USE zoologico;

#Se crea la tabla animal
CREATE TABLE animal (
  id_animal VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  sexo VARCHAR(15) NULL,
  fecha_nacimiento VARCHAR(15) NULL,
  edad VARCHAR(30) NULL,
  PRIMARY KEY (id_animal));
  
  # Se crea la tabla clasificacion del animal
  CREATE TABLE clasificacion_animal (
  id_animales VARCHAR(10) NOT NULL,
  clasificacion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_animales, clasificacion),
  CONSTRAINT id_animales
    FOREIGN KEY (id_animales)
    REFERENCES animal (id_animal));
    
  
  # Se crea la tabla veterinario
  CREATE TABLE veterinario (
  id_veterinario VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  PRIMARY KEY (id_veterinario));
  
  #	Se crea la tabla entrenador 
  CREATE TABLE entrenador (
  id_entrenador VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  id_veterinarios VARCHAR(10) NULL,
  PRIMARY KEY (id_entrenador));
  
  # Se crea tabla entrenador_animal
  CREATE TABLE entrenador_animal (
  id_animal_ VARCHAR(10) NOT NULL,
  id_entrenador_ VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_animal_, id_entrenador_),
   CONSTRAINT id_animal_
    FOREIGN KEY (id_animal_)
    REFERENCES animal (id_animal),
  CONSTRAINT id_entrenador_
    FOREIGN KEY (id_entrenador_)
    REFERENCES entrenador (id_entrenador));
 
  #Se crea la tabla dieta
  CREATE TABLE dieta (
  id_dieta VARCHAR(10) NOT NULL,
  recomendaciones VARCHAR(45) NULL,
  id_animals VARCHAR(10) NULL,
  PRIMARY KEY (id_dieta),
  CONSTRAINT id_animals
    FOREIGN KEY (id_animals)
    REFERENCES animal (id_animal));
    
#Se crea la tabla dieta veterinario
CREATE TABLE dieta_veterinario (
  id_dieta_ VARCHAR(10) NOT NULL,
  id_veterinario_ VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_dieta_, id_veterinario_),
  CONSTRAINT id_dieta_
    FOREIGN KEY (id_dieta_)
    REFERENCES dieta (id_dieta),
  CONSTRAINT id_veterinario_
    FOREIGN KEY (id_veterinario_)
    REFERENCES veterinario (id_veterinario));
    
#Se crea la tabla alimento
CREATE TABLE alimento (
  id_alimento VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  dosis VARCHAR(20) NULL,
  PRIMARY KEY (id_alimento));
  
# Se crea la tabla tipo_alimento
CREATE TABLE tipo_alimento (
  id_aliment VARCHAR(10) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_aliment, tipo),
  CONSTRAINT id_aliment
    FOREIGN KEY (id_aliment)
    REFERENCES alimento (id_alimento));
  
  # Se crea la tabla dieta_alimento
CREATE TABLE dieta_alimento (
  id_dietas VARCHAR(10) NOT NULL,
  id_aliments VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_dietas, id_aliments),
  CONSTRAINT id_dietas
    FOREIGN KEY (id_dietas)
    REFERENCES dieta (id_dieta),
  CONSTRAINT id_aliments
    FOREIGN KEY (id_aliments)
    REFERENCES alimento (id_alimento));
    
# Se crea tabla emp_logistico
CREATE TABLE emp_logistic (
  id_logistico VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  correo VARCHAR(45) NULL,
  PRIMARY KEY (id_logistico));
  
  # Se crea tabla alimento_logistico
CREATE TABLE alimento_logistico (
  id_alimento_ VARCHAR(10) NOT NULL,
  id_logistico VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_alimento_, id_logistico),
  CONSTRAINT id_alimento_
    FOREIGN KEY (id_alimento_)
    REFERENCES alimento (id_alimento),
  CONSTRAINT id_logistico
    FOREIGN KEY (id_logistico)
    REFERENCES emp_logistic (id_logistico));
    
# Se crea tabla proveedor
CREATE TABLE proveedor (
  id_proveedor VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  correo VARCHAR(45) NULL,
  PRIMARY KEY (id_proveedor));
    
# Se crea la tabla orden_compra
CREATE TABLE orden_compra (
  id_orden VARCHAR(10) NOT NULL,
  fecha VARCHAR(15) NULL,
  nombre_alimento VARCHAR(45) NULL,
  cantidad VARCHAR(10) NULL,
  id_logisticos VARCHAR(10) NULL,
  id_proveedors VARCHAR(10) NULL,
  observaciones VARCHAR(45) NULL,
  PRIMARY KEY (id_orden),
  CONSTRAINT id_logisticos
    FOREIGN KEY (id_logisticos)
    REFERENCES emp_logistic (id_logistico),
  CONSTRAINT id_proveedors
    FOREIGN KEY (id_proveedors)
    REFERENCES proveedor (id_proveedor));
 
 #Se crea la tabla factura
 CREATE TABLE factura (
  id_factura VARCHAR(10) NOT NULL,
  fecha VARCHAR(15) NULL,
  total VARCHAR(45) NULL,
  PRIMARY KEY (id_factura));
  
  # Se crea la tabla proveedor_factura
  CREATE TABLE proveedor_factura (
  id_proveed VARCHAR(10) NOT NULL,
  id_facturas VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_proveed, id_facturas),
  CONSTRAINT id_proveed
    FOREIGN KEY (id_proveed)
    REFERENCES proveedor (id_proveedor),
  CONSTRAINT id_facturas
    FOREIGN KEY (id_facturas)
    REFERENCES factura (id_factura));

# Se crea la tabla peso_historial
CREATE TABLE peso_historial (
  id_animales_ VARCHAR(10) NOT NULL,
  peso VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_animales_, peso),
  CONSTRAINT peso_animales_
    FOREIGN KEY (id_animales_)
    REFERENCES animal (id_animal));
    
    