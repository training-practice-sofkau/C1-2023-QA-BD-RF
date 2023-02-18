CREATE SCHEMA Zoo_Santafe;
USE Zoo_Santafe;

-- Tabla Dieta
CREATE TABLE Dieta (
  idDieta VARCHAR(25) NOT NULL,
  nombre_dieta VARCHAR(45) NOT NULL,
  dosis_dieta VARCHAR(45) NOT NULL,
  tipo_dieta VARCHAR(45) NOT NULL,
  PRIMARY KEY (idDieta));

-- Tabla Animal
CREATE TABLE Animal (
  idAnimal VARCHAR(25) NOT NULL,
  nombre_animal VARCHAR(45) NOT NULL,
  Especie VARCHAR(45) NULL,
  idDieta VARCHAR(25) NOT NULL,
  PRIMARY KEY (idAnimal),
  FOREIGN KEY (idDieta)
  REFERENCES Dieta (idDieta));

-- Tabla logista
CREATE TABLE logista (
  idlogista VARCHAR(25) NOT NULL,
  nombre_logista VARCHAR(45) NOT NULL,
  telefono_logista VARCHAR(45) NOT NULL,
  PRIMARY KEY (idlogista));

-- Tabla Entrenador
CREATE TABLE Entrenador (
  idEntrenador VARCHAR(25) NOT NULL,
  nombre_eentrenador VARCHAR(45) NOT NULL,
  telefono_entrenador VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEntrenador));

-- Tabla Veterinario
CREATE TABLE Veterinario (
  idVeterinario VARCHAR(25) NOT NULL,
  nombre_veterinario VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  PRIMARY KEY (idVeterinario));

-- Tabla Alimento
CREATE TABLE Alimento (
  idAlimento VARCHAR(25) NOT NULL,
  nombre_alimento VARCHAR(45) NOT NULL,
  tipo_alimento VARCHAR(45) NOT NULL,
  dosis_alimento VARCHAR(45) NOT NULL,
  PRIMARY KEY (idAlimento));

-- Tabla Proveedores
CREATE TABLE Proveedores (
  idProveedores VARCHAR(25) NOT NULL,
  nombre_proveedor VARCHAR(45) NOT NULL,
  telefono_proveedor VARCHAR(45) NOT NULL,
  PRIMARY KEY (idProveedores));

-- Tabla Orden_compra
CREATE TABLE Orden_compra (
  idOrden_compra VARCHAR(25) NOT NULL,
  fecha_compra VARCHAR(45) NOT NULL,
  idlogista VARCHAR(25) NOT NULL,
  idProveedores VARCHAR(25) NOT NULL,
  PRIMARY KEY (idOrden_compra),
  FOREIGN KEY (idlogista)
  REFERENCES logista (idlogista),
  FOREIGN KEY (idProveedores)
  REFERENCES Proveedores (idProveedores));

-- Tabla Animal_Entrenador
CREATE TABLE Animal_Entrenador (
  idAnimal VARCHAR(25) NOT NULL,
  idEntrenador VARCHAR(25) NOT NULL,
  PRIMARY KEY (idAnimal, idEntrenador),
  FOREIGN KEY (idAnimal)
  REFERENCES Animal (idAnimal),
  FOREIGN KEY (idEntrenador)
  REFERENCES Entrenador (idEntrenador));

-- Tabla Entrenador_Veterinario
CREATE TABLE Entrenador_Veterinario (
  idEntrenador VARCHAR(25) NOT NULL,
  idVeterinario VARCHAR(25) NOT NULL,
  PRIMARY KEY (idEntrenador, idVeterinario),
  FOREIGN KEY (idEntrenador)
  REFERENCES Entrenador (idEntrenador),
  FOREIGN KEY (idVeterinario)
  REFERENCES Veterinario (idVeterinario));

-- Tabla Dieta_Alimento
CREATE TABLE Dieta_Alimento (
  idDieta VARCHAR(25) NOT NULL,
  idAlimento VARCHAR(25) NOT NULL,
  PRIMARY KEY (idDieta, idAlimento),
  FOREIGN KEY (idDieta)
  REFERENCES Dieta (idDieta),
  FOREIGN KEY (idAlimento)
  REFERENCES Alimento (idAlimento));

-- Tabla Veterinario_Dieta
CREATE TABLE Veterinario_Dieta (
  idVeterinario VARCHAR(25) NOT NULL,
  idDieta VARCHAR(25) NOT NULL,
  PRIMARY KEY (idVeterinario, idDieta),
  FOREIGN KEY (idVeterinario)
  REFERENCES Veterinario (idVeterinario),
  FOREIGN KEY (idDieta)
  REFERENCES Dieta (idDieta));

-- Tabla Proveedores_Alimento
CREATE TABLE Proveedores_Alimento (
  idProveedores VARCHAR(25) NOT NULL,
  idAlimento VARCHAR(25) NOT NULL,
  PRIMARY KEY (idProveedores, idAlimento),
  FOREIGN KEY (idProveedores)
  REFERENCES Proveedores (idProveedores),
  FOREIGN KEY (idAlimento)
  REFERENCES Alimento (idAlimento));

-- Tabla Factura
CREATE TABLE Factura (
  idFactura VARCHAR(25) NOT NULL,
  precio_factura VARCHAR(45) NOT NULL,
  cantidad_factura VARCHAR(45) NOT NULL,
  idProveedores VARCHAR(25) NOT NULL,
  PRIMARY KEY (idFactura),
  FOREIGN KEY (idProveedores)
  REFERENCES Proveedores (idProveedores));
  
  CREATE TABLE Informe (
  idInforme VARCHAR(25) NOT NULL,
  peso_animal VARCHAR(45) NULL,
  edad_animal VARCHAR(45) NULL,
  idAnimal VARCHAR(25) NOT NULL,
  idEntrenador VARCHAR(25) NOT NULL,
  PRIMARY KEY (idInforme),
  FOREIGN KEY (idAnimal)
  REFERENCES Animal (idAnimal),
  FOREIGN KEY (idEntrenador)
  REFERENCES Entrenador (idEntrenador));
  
# CONSULTAS

-- 1. Ver la lista de animales y su dieta correspondiente
SELECT Animal.nombre_animal, Dieta.nombre_dieta 
FROM Animal 
INNER JOIN Dieta ON Animal.idDieta = Dieta.idDieta;

-- 2. Ver los detalles de un animal en particular
SELECT * FROM Animal 
WHERE idAnimal = 'Anim1';

-- 3. Ver el precio y la cantidad de los productos comprados de la tabla Factura:
SELECT precio_factura, cantidad_factura 
FROM Factura;

-- 4. Ver todos los detalles de una orden de compra en particular

SELECT * FROM Orden_compra 
WHERE idOrden_compra = 'OC1';

-- 5. Ver todos los proveedores que han suministrado alimentos
SELECT DISTINCT nombre_proveedor 
FROM Proveedores_Alimento 
JOIN Proveedores ON Proveedores_Alimento.idProveedores = Proveedores.idProveedores;

-- 6. Ver el número de animales que hay en cada especie
SELECT especie, COUNT(*) FROM Animal
GROUP BY especie;

-- 7. Ver el nombre y teléfono de todos los proveedores de la tabla Proveedores
SELECT nombre_proveedor, telefono_proveedor 
FROM Proveedores;

-- 8. Ver todos los animales y sus entrenadores correspondientes
SELECT a.nombre_animal, e.nombre_eentrenador
FROM Animal a
JOIN Animal_Entrenador ae ON a.idAnimal = ae.idAnimal
JOIN Entrenador e ON ae.idEntrenador = e.idEntrenador;

-- 9. Ver el nombre y teléfono de todos los veterinarios:
SELECT nombre_veterinario, telefono 
FROM Veterinario;


-- 10. Ver todos los alimentos que se utilizan en cada dieta
SELECT Dieta.nombre_dieta, Alimento.nombre_alimento
FROM Dieta
INNER JOIN Dieta_Alimento ON Dieta.idDieta = Dieta_Alimento.idDieta
INNER JOIN Alimento ON Dieta_Alimento.idAlimento = Alimento.idAlimento;

# VISTAS GENERADAS

-- 1. Vista de animales y sus dietas correspondientes
CREATE VIEW Vista_Animal_Dieta AS
SELECT Animal.idAnimal, Animal.nombre_animal, Dieta.nombre_dieta, Dieta.dosis_dieta, Dieta.tipo_dieta
FROM Animal
INNER JOIN Dieta ON Animal.idDieta = Dieta.idDieta;


-- 2. Vista de entrenadores y sus animales asignados
CREATE VIEW Vista_Entrenador_Animal AS
SELECT Entrenador.idEntrenador, Eobtener_nombre_animal_dietantrenador.nombre_eentrenador, Animal.idAnimal, Animal.nombre_animal
FROM Entrenador
INNER JOIN Animal_Entrenador ON Entrenador.idEntrenador = Animal_Entrenador.idEntrenador
INNER JOIN Animal ON Animal_Entrenador.idAnimal = Animal.idAnimal;


-- 3. Vista de dietas y sus alimentos correspondientes
CREATE VIEW Vista_Dieta_Alimento AS
SELECT d.nombre_dieta, a.nombre_alimento, a.tipo_alimento, a.dosis_alimento
FROM Dieta d
INNER JOIN Dieta_Alimento da ON d.idDieta = da.idDieta
INNER JOIN Alimento a ON da.idAlimento = a.idAlimento;

-- 4. Vista de los logistas y las órdenes de compra que han realizado
CREATE VIEW vista_Logista_Orden_Compra AS
SELECT l.nombre_logista, o.fecha_compra
FROM logista l
INNER JOIN Orden_compra o ON l.idlogista = o.idlogista;

# PROCEDIMIENTOS GENERADOS

-- 1. Procedimiento para obtener el nombre del animal y su dieta
DELIMITER //
CREATE PROCEDURE obtener_nombre_animal_dieta()
BEGIN
   SELECT Animal.nombre_animal, Dieta.nombre_dieta 
   FROM Animal
   INNER JOIN Dieta ON Animal.idDieta = Dieta.idDieta;
END; //

-- 2. Procedimiento que inserta un nuevo alimento en la base de datos
drop procedure insertar_alimento;
DELIMITER //
CREATE PROCEDURE insertar_alimento(
	IN p_idAlimento VARCHAR (25),
    IN p_nombre_alimento VARCHAR(45),
    IN p_tipo_alimento VARCHAR(45),
    IN p_dosis_alimento VARCHAR(45)
)
BEGIN
    INSERT INTO Alimento (idAlimento, nombre_alimento, tipo_alimento, dosis_alimento)
    VALUES (p_idAlimento, p_nombre_alimento, p_tipo_alimento, p_dosis_alimento);
END; //
call zoo_santafe.insertar_alimento('alim100', 'morcilla', 'chatarra', '500 gramos');

-- 3. Procedimiento que actualiza la dieta asociada a un animal
DELIMITER //
CREATE PROCEDURE actualizar_dieta_animal(
    IN p_idAnimal VARCHAR(25),
    IN p_idDieta VARCHAR(25)
)
BEGIN
    UPDATE Animal
    SET idDieta = p_idDieta
    WHERE idAnimal = p_idAnimal;
END; //

-- 4. Procedimiento para obtener la dieta de un animal dado su ID:
DELIMITER //
CREATE PROCEDURE dieta_de_animal(IN animal_id VARCHAR(25))
BEGIN
    SELECT d.nombre_dieta, d.dosis_dieta, d.tipo_dieta
    FROM Dieta d
    INNER JOIN Animal a ON d.idDieta = a.idDieta
    WHERE a.idAnimal = animal_id;
END; //

# TRIGGER GENERADOS

-- 1. Trigger para agregar un animal
CREATE TRIGGER tr_agregar_animal
AFTER INSERT ON animal
FOR EACH ROW
INSERT INTO control_de_cambios_ZOO (usuario, accion, fecha)
VALUES (USER(), 'Agregar animal', NOW());

INSERT INTO animal VALUES('anim300', 'GatoBotas', 'felino', 'd20');

-- 2. Trigger para agregar un alimento
CREATE TRIGGER tr_agregar_alimento
AFTER INSERT ON alimento
FOR EACH ROW
INSERT INTO control_de_cambios_ZOO (usuario, accion, fecha)
VALUES (USER(), 'Agregar alimento', NOW());
INSERT INTO alimento VALUES('alim300', 'hamburguesa', 'callejera', '200g');

-- 3. Trigger para actualizar una dieta
CREATE TRIGGER tr_actualizar_dieta
AFTER UPDATE ON dieta
FOR EACH ROW
INSERT INTO control_de_cambios_ZOO (usuario, accion, fecha)
VALUES (USER(), 'Actualizar dieta', NOW(), NEW.tipo_dieta,NEW.dosis_dieta, NEW.nombre_dieta, NEW.idDieta);
UPDATE dieta SET tipo_dieta='altaGrasa', dosis_dieta=50, nombre_dieta='calorica' WHERE idDieta='D30';

-- 4. Trigger para eliminar una dieta
CREATE TRIGGER tr_eliminar_dieta
AFTER DELETE ON Dieta
FOR EACH ROW
INSERT INTO control_de_cambios_ZOO (usuario, accion, fecha, idDieta, tipo_dieta, dosis_dieta, nombre_dieta)
VALUES (USER(), 'Eliminar dieta', NOW(), OLD.idDieta, OLD.tipo_dieta, OLD.dosis_dieta, OLD.nombre_dieta);

DELETE FROM Dieta WHERE idDieta = 'D300';

-- se crea una nueva tabla para llevar el control de las acciones de triggers
-- tabla control_de_cambios_ZOO
CREATE TABLE control_de_cambios_ZOO (
usuario VARCHAR(45) NOT NULL,
accion VARCHAR(45) NOT NULL,
fecha DATETIME);

-- # agrego registros a las tablas para probar

-- -- Tabla Dieta
-- INSERT INTO Dieta (idDieta, nombre_dieta, dosis_dieta, tipo_dieta) VALUES
-- ('D01', 'Dieta 1', '250g', 'Herbívoro'),
-- ('D02', 'Dieta 2', '400g', 'Carnívoro');

-- -- Tabla Animal
-- INSERT INTO Animal (idAnimal, nombre_animal, Especie, idDieta) VALUES
-- ('A02', 'Tigre', 'Panthera tigris', 'D02'),
-- ('A03', 'Jirafa', 'Giraffa camelopardalis', 'D01'),
-- ('A04', 'Elefante', 'Loxodonta africana', 'D01');

-- -- Tabla logista
-- INSERT INTO logista (orden_compraidlogista, nombre_logista, telefono_logista) VALUES
-- ('L01', 'Juan Pérez', '1234567'),
-- ('L02', 'María Gómez', '7654321');

-- -- Tabla Entrenador
-- INSERT INTO Entrenador (idEntrenador, nombre_eentrenador, telefono_entrenador) VALUES
-- ('E01', 'Pedro Rodríguez', '1111111'),
-- ('E02', 'Laura Fernández', '2222222');

-- -- Tabla Veterinario
-- INSERT INTO Veterinario (idVeterinario, nombre_veterinario, telefono) VALUES
-- ('V01', 'José González', '3333333'),
-- ('V02', 'Ana Martínez', '4444444');

-- -- Tabla Alimento
-- INSERT INTO Alimento (idAlimento, nombre_alimento, tipo_alimento, dosis_alimento) VALUES
-- ('AL01', 'Carne de res', 'Carnívoro', '500g'),
-- ('AL02', 'Heno', 'Herbívoro', '1kg');

-- -- Tabla Proveedores
-- INSERT INTO Proveedores (idProveedores, nombre_proveedor, telefono_proveedor) VALUES
-- ('P01', 'Proveedor 1', '5555555'),
-- ('P02', 'Proveedor 2', '6666666');

-- -- Tabla Orden_compra
-- INSERT INTO Orden_compra (idOrden_compra, fecha_compra, idlogista, idProveedores) VALUES
-- ('OC01', '2022-02-01', 'L01', 'P01'),
-- ('OC02', '2022-02-05', 'L02', 'P02');

-- -- Tabla Animal_Entrenador
-- INSERT INTO Animal_Entrenador (idAnimal, idEntrenador) VALUES
-- ('A01', 'E01'),
-- ('A02', 'E01'),
-- ('A03', 'E02'),
-- ('A04', 'E02');

-- -- Tabla Entrenador_Veterinario
-- INSERT INTO Entrenador_Veterinario (idEntrenador, idVeterinario) VALUES
-- ('E01', 'V01'),
-- ('E02', 'V02');

-- -- Tabla Dieta_Alimento
-- INSERT INTO Dieta_Alimento (idDieta, idAlimento) VALUES
-- ('D01', 'AL02'),
-- ('D02', 'AL01'),
-- ('D02', 'AL02');

-- -- Tabla Veterinario_Dieta

-- INSERT INTO Veterinario_Dieta (idVeterinario, idDieta) VALUES 
-- ('V01', 'D01'),
-- ('V01', 'D02');

-- INSERT INTO Proveedores_Alimento (idProveedores, idAlimento) VALUES 
-- ('P01', 'AL01'),
-- ('P02', 'AL02');

-- INSERT INTO Factura (idFactura, precio_factura, cantidad_factura, idProveedores) VALUES 
-- ('F01', '50.00', '10', 'P01'),
-- ('F02', '80.00', '15', 'P02');

-- INSERT INTO Informe (idInforme, peso_animal, edad_animal, idAnimal, idEntrenador) VALUES 
-- ('Inf001', '60 kg', '5 years', 'A01', 'E01'),
-- ('Inf002', '120 kg', '8 years', 'A03', 'E02');



 

