CREATE DATABASE ZOO_santaFe;
USE ZOO_santaFe;




CREATE TABLE empleado_entrenador(
id_empleado_entrenador VARCHAR(4) NOT NULL PRIMARY KEY,
nombre_empleado_entrenador VARCHAR(60) NOT NULL,
telefono_empleador_entrenador VARCHAR(15) NOT NULL
);



CREATE TABLE empleado_veterinario(
id_empleado_veterinario VARCHAR(4) NOT NULL PRIMARY KEY,
nombre_empleado_entrenador VARCHAR(60) NOT NULL,
telefono_empleado_veterinario VARCHAR(15) NOT NULL 
);

CREATE TABLE reporte_veterinario(
id_empleado_veterinario_r VARCHAR(4) NOT NULL, 
id_reporte_r VARCHAR(4) NOT NULL,
FOREIGN KEY (id_empleado_veterinario_r) REFERENCES empleado_veterinario(id_empleado_veterinario),
FOREIGN KEY (id_reporte_r) REFERENCES reporte(id_reporte)
);

CREATE TABLE animal (
id_animal VARCHAR(12) NOT NULL PRIMARY KEY,
especie VARCHAR(4)  NOT NULL,
edad VARCHAR(4) NOT NULL,
id_dieta_a VARCHAR(11) NOT NULL,
FOREIGN KEY (id_dieta_a) REFERENCES dieta(id_dieta)
);

CREATE TABLE dieta (
id_dieta VARCHAR(11) NOT NULL PRIMARY KEY,
tipo_dieta VARCHAR(60) NOT NULL,
dosis VARCHAR(6) NOT NULL
);


CREATE TABLE alimento(
id_alimento VARCHAR(10) NOT NULL PRIMARY KEY,
tipo_alimento VARCHAR(60) NOT NULL,
cantidad  VARCHAR(12) NOT NULL
);

CREATE TABLE proveedor(
id_proveedor VARCHAR(6) NOT NULL PRIMARY KEY,
nombre_proveedor VARCHAR(60),
direccion VARCHAR(60)
);

CREATE TABLE telefono_proveedor(
id_proveedor_telefono  VARCHAR(10) NOT NULL,
numero VARCHAR(10) NOT NULL,
PRIMARY KEY(id_proveedor_telefono,numero),
FOREIGN KEY (id_proveedor_telefono) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE factura(
id_factura VARCHAR(20) NOT NULL PRIMARY KEY,
cantidad_total VARCHAR(25) NOT NULL,
cantidad_productos VARCHAR(9) NOT NULL,
id_proveedor_f VARCHAR(10) NOT NULL,
FOREIGN KEY(id_proveedor_f) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE orden_compra(
id_orden VARCHAR(50) NOT NULL PRIMARY KEY,
fecha_de_elaboracion VARCHAR(60) NOT NULL,
fecha_de_entrega VARCHAR(60) NOT NULL,
descripcion VARCHAR(50) NOT NULL,
id_empleado_logistico_o VARCHAR(5) NOT NULL,
id_proveedor_o VARCHAR(6) NOT NULL,
FOREIGN KEY (id_empleado_logistico_o) REFERENCES empleado_logistico(id_empleado_logistico),
FOREIGN KEY (id_proveedor_o) REFERENCES proveedor(id_proveedor)
);


CREATE TABLE empleado_logistico(
id_empleado_logistico VARCHAR(5) NOT NULL PRIMARY KEY,
nombre_empleado_logistico VARCHAR(9) NOT NULL,
telefono VARCHAR(15) NOT NULL
);


CREATE TABLE veterinario_dieta(
id_empleado_veterinario_d VARCHAR(4) NOT NULL,
id_dieta_d VARCHAR(11) NOT NULL,
FOREIGN KEY (id_empleado_veterinario_d) REFERENCES empleado_veterinario(id_empleado_veterinario),
FOREIGN KEY (id_dieta_d) REFERENCES dieta(id_dieta)
);


CREATE TABLE dieta_alimento(
id_dieta_d_a VARCHAR(12) NOT NULL,
id_alimento_d_a VARCHAR(12) NOT NULL,
FOREIGN KEY (id_dieta_d_a) REFERENCES dieta(id_dieta),
FOREIGN KEY (id_alimento_d_a) REFERENCES alimento(id_alimento)
);

CREATE TABLE proveedor_alimento(
id_alimento_p VARCHAR(12) NOT NULL,
id_proveedor_p VARCHAR(12) NOT NULL,
FOREIGN KEY (id_alimento_p) REFERENCES alimento(id_alimento),
FOREIGN KEY (id_proveedor_p) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE reporte(
id_reporte VARCHAR(6) NOT NULL PRIMARY KEY, 
peso_ultimo VARCHAR(10) NOT NULL,
fecha_ultimo_peso VARCHAR(70) NOT NULL,
detalles VARCHAR(1000) NOT NULL,
id_empleado_entrenador_r VARCHAR(4) NOT NULL,
id_animal_r VARCHAR(12) NOT NULL,
FOREIGN KEY (id_empleado_entrenador_r) REFERENCES empleado_entrenador(id_empleado_entrenador),
FOREIGN KEY (id_animal_r) REFERENCES animal(id_animal)
);


-- inserto algunos registros para validar las consultas 
INSERT INTO dieta VALUES ('01A','carnivora','9 kilos diarios');
INSERT INTO dieta VALUES('01B','marina','5 kilos pescados y 3 kilos mariscos');

INSERT INTO  animal VALUES ('1001','leon','10 años','01A');
INSERT INTO animal VALUES ('10015','foca','15 años','01B');
INSERT INTO animal VALUES ('1006','lobo','5años','01B');

INSERT INTO proveedor VALUES('M-01','Albeiro Sepulveda','Fontidueño 8A-13');

INSERT INTO factura VALUES('F-001','5.126.350','390 toneladas','M-01');

INSERT INTO alimento VALUES('L-001','humedo','10 kilos','carne fria + jamon');

INSERT INTO empleado_veterinario VALUES('v001','Fermin Aguirre','3112225499');

INSERT INTO empleado_logistico VALUES ('l001','Sara Roma','3112758950');

INSERT INTO empleado_entrenador VALUES ('e001','Camilo Perez','32000025021');

INSERT INTO telefono_proveedor VALUES('M-01','6045896523');
INSERT INTO telefono_proveedor VALUES('M-01','3112887544');


INSERT INTO orden_compra VALUES('O-111','16/02/2023','24/02/2023','1000 toneladas carne fria','l001','M-01');

INSERT INTO reporte VALUES('R-01','190Kg','15/02/2023','el leon esta en peso estable','e001','1001');

-- consulta para ver las dietas de todos los animales 
SELECT animal.id_animal, dieta.tipo_dieta, dieta.dosis
FROM animal
JOIN dieta ON animal.id_dieta_a = dieta.id_dieta;

-- consulta para obtener el promedio de edad de todos los animales 
SELECT AVG(edad) AS promedio_edad 
FROM animal;

-- Consulta para obtener todos los detalles de la dieta del animal con ID '1001':
SELECT * 
FROM dieta d 
JOIN animal a 
ON d.id_dieta = a.id_dieta_a 
WHERE a.id_animal = '1001';

-- consulta para ver los detalles de todas las facturas, incluyendo el nombre del proveedor, 
-- la cantidad total de productos comprados y la fecha de entrega de cada orden de compra:

SELECT f.id_factura, p.nombre_proveedor, f.cantidad_total, f.cantidad_productos, o.fecha_de_entrega
FROM factura f
JOIN proveedor p ON f.id_proveedor_f = p.id_proveedor
JOIN orden_compra o ON f.id_proveedor_f = o.id_proveedor_o;

-- Consulta para obtener todos los proveedores de alimentos y sus números de teléfono:
SELECT p.nombre_proveedor, tp.numero 
FROM proveedor p 
JOIN telefono_proveedor tp 
ON p.id_proveedor = tp.id_proveedor_telefono;

-- Consulta para obtener todos los detalles de la factura con ID 'F-001':
SELECT * 
FROM factura 
WHERE id_factura = 'F-001';


-- Consulta para obtener el nombre y teléfono del empleado logístico responsable de la orden de compra con ID 'O-111':
SELECT e.nombre_empleado_logistico, e.telefono 
FROM empleado_logistico e 
JOIN orden_compra o ON e.id_empleado_logistico = o.id_empleado_logistico_o
 WHERE o.id_orden = 'O-111';

-- Consulta para obtener el número de teléfono de todos los empleados entrenadores:
SELECT telefono_empleador_entrenador
 FROM empleado_entrenador;

-- Consulta para obtener los detalles de la orden de compra más reciente:
SELECT * 
FROM orden_compra 
ORDER BY fecha_de_elaboracion DESC LIMIT 1;

-- Consulta para obtener el número de teléfono y dirección del proveedor con ID 'M-01':
SELECT p.nombre_proveedor, tp.numero, p.direccion 
FROM proveedor p 
JOIN telefono_proveedor tp ON p.id_proveedor = tp.id_proveedor_telefono 
WHERE p.id_proveedor = 'M-01';

-- Consulta para obtener todos los reportes veterinarios de los animales:
SELECT a.id_animal, r.peso_ultimo, r.fecha_ultimo_peso, r.detalles, ev.nombre_empleado_entrenador, ev.telefono_empleador_entrenador 
FROM animal a 
JOIN reporte r ON a.id_animal = r.id_animal_r 
JOIN empleado_entrenador ev ON r.id_empleado_entrenador_r = ev.id_empleado_entrenador;


-- vista para llevar registro de entreandores y sus animales asignados 
CREATE VIEW vista_entrenadores AS 
SELECT e.nombre_empleado_entrenador, a.especie
FROM empleado_entrenador e 
JOIN reporte r ON e.id_empleado_entrenador = r.id_empleado_entrenador_r
JOIN animal a ON r.id_animal_r = a.id_animal;

-- Vista de las compras realizadas a cada proveedor junto con la cantidad total y la cantidad de productos adquiridos:
CREATE VIEW compras_por_proveedor AS
SELECT p.id_proveedor, p.nombre_proveedor, COUNT(f.id_factura) AS cantidad_compras, SUM(f.cantidad_total) AS total_compras, SUM(f.cantidad_productos) AS total_productos
FROM proveedor p
LEFT JOIN factura f ON f.id_proveedor_f = p.id_proveedor
GROUP BY p.id_proveedor;

-- Vista de la dieta prescrita por el veterinario 
CREATE VIEW dieta_prescrita AS
SELECT d.id_dieta, d.tipo_dieta, d.dosis, e.id_empleado_veterinario, e.nombre_empleado_entrenador
FROM dieta d
INNER JOIN veterinario_dieta vd ON vd.id_dieta_d = d.id_dieta
INNER JOIN empleado_veterinario e ON e.id_empleado_veterinario = vd.id_empleado_veterinario_d;

-- Vista de informe de salud del animal: 
CREATE VIEW informe_salud_animal AS
SELECT a.id_animal, a.especie, a.edad, r.fecha_ultimo_peso, r.peso_ultimo, r.detalles
FROM animal a
INNER JOIN reporte r ON a.id_animal = r.id_animal_r AND r.fecha_ultimo_peso = (SELECT MAX(fecha_ultimo_peso) FROM reporte WHERE id_animal_r = a.id_animal);

-- Procedimiento para insertar un nuevo empleado entrenador
DELIMITER //
CREATE PROCEDURE insertar_empleado_entrenador(IN id_empleado_entrenador VARCHAR(4), IN nombre_empleado_entrenador VARCHAR(60), IN telefono_empleador_entrenador VARCHAR(15))
BEGIN
    INSERT INTO empleado_entrenador (id_empleado_entrenador, nombre_empleado_entrenador, telefono_empleador_entrenador)
    VALUES (id_empleado_entrenador, nombre_empleado_entrenador, telefono_empleador_entrenador);
END//


-- procedimiento para mostrar los animales que consumen una dieta especifica : 
DELIMITER //
CREATE PROCEDURE mostrar_animales_por_dieta(IN dieta_a VARCHAR(11))
BEGIN
    SELECT animal.id_animal, animal.especie, animal.edad 
    FROM animal 
    WHERE animal.id_dieta_a = dieta_a;
END;//
-- Procedimiento para insertar un nuevo reporte veterinario:
DELIMITER //
CREATE PROCEDURE insertar_reporte_veterinario(IN id_empleado_veterinario_r VARCHAR(4), IN id_reporte_r VARCHAR(4))
BEGIN
    INSERT INTO reporte_veterinario (id_empleado_veterinario_r, id_reporte_r)
    VALUES (id_empleado_veterinario_r, id_reporte_r);
END;//

-- Procedimiento para insertar un nuevo animal:
DELIMITER //
CREATE PROCEDURE insertar_animal(IN id_animal VARCHAR(12), IN especie VARCHAR(4), IN edad VARCHAR(4), IN id_dieta_a VARCHAR(11))
BEGIN
    INSERT INTO animal (id_animal, especie, edad, id_dieta_a)
    VALUES (id_animal, especie, edad, id_dieta_a);
END;//

-- procedimiento para agregar una nueva dieta 
DELIMITER //
CREATE PROCEDURE agregar_dieta(IN id_dieta VARCHAR(11), IN tipo_dieta VARCHAR(60), IN dosis VARCHAR(6))
BEGIN
    INSERT INTO dieta (id_dieta, tipo_dieta, dosis) VALUES (id_dieta, tipo_dieta, dosis);
END;//

-- procedimiento para actualizar la edad de un animal 
DELIMITER //
CREATE PROCEDURE actualizar_edad_animal(IN id_animal VARCHAR(12), IN edad VARCHAR(4))
BEGIN
    UPDATE animal SET edad = edad WHERE id_animal = id_animal;
END;//

-- procedimiento para mostrar la dosis de todos los animales en el zoo
DELIMITER //

CREATE PROCEDURE mostrar_dosis_animales()
BEGIN
  SELECT a.id_animal, d.tipo_dieta, d.dosis
  FROM animal a
  JOIN dieta d ON a.id_dieta_a = d.id_dieta;
END //

DELIMITER ;

-- creacion de TRIGGERS

CREATE TABLE control_de_cambios_zoologico (
  id_cambio INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuario VARCHAR(60) NOT NULL,
  accion VARCHAR(15) NOT NULL,
  fecha DATETIME NOT NULL,
  lugar VARCHAR(100) NOT NULL
);

-- trigger que se ejecuta cuando se inserta un nuevo animal 
DELIMITER //
CREATE TRIGGER insertar_cambio
AFTER INSERT ON animal
FOR EACH ROW
INSERT INTO control_de_cambios_zoologico (usuario, accion, fecha, lugar)
VALUES (USER(), 'INSERTAR', NOW(), 'animal');
END//

-- trigger que se ejecuta cuando se borra un animal 
DELIMITER //
CREATE TRIGGER trigger_eliminar_animal
AFTER DELETE ON animal
FOR EACH ROW
BEGIN
    INSERT INTO control_de_cambios_zoologico (usuario, accion, fecha, lugar)
    VALUES (USER(), 'Eliminar', NOW(), 'animal');
END//

-- trigger que se ejecuta cuando se inserta una nueva dieta 
DELIMITER //
CREATE TRIGGER insertar_cambio_dieta
AFTER INSERT ON dieta
FOR EACH ROW
INSERT INTO control_de_cambios_zoologico (usuario, accion, fecha, lugar)
VALUES (USER(), 'INSERTAR', NOW(), 'dieta');
END//

-- trigger que se ejecuta cuando se elimina un proveedor 
DELIMITER //
CREATE TRIGGER trigger_eliminar_proveedor_alimento
AFTER DELETE ON proveedor_alimento
FOR EACH ROW
BEGIN
    INSERT INTO control_de_cambios_zoologico (usuario, accion, fecha, lugar)
    VALUES (USER(), 'Eliminar', NOW(), 'proveedor_alimento');
END//

-- trigger que se ejecuta cuando se modifica un reporte 
DELIMITER //
CREATE TRIGGER trigger_modificar_reporte
AFTER UPDATE ON reporte
FOR EACH ROW
BEGIN
    INSERT INTO control_de_cambios_zoologico (usuario, accion, fecha, lugar)
    VALUES (USER(), 'Modificar', NOW(), 'reporte');
END//







