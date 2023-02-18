# Procedimientos 

# Se genera el procedimiento para agregar nuevo peso de animal 
USE zoologico;

# PROCEDIMIENTO PARA AGREGAR PESO ANIMAL 
DELIMITER //
CREATE PROCEDURE agregarPeso
(
IN _id_animales_ VARCHAR(10),
IN _peso VARCHAR(15)
)
BEGIN
INSERT INTO peso_historial (id_animales_,peso)
 values (_id_animales_,_peso);
END
//
#Llamar procedimiento de agregar peso
CALL agregarPeso ('1','1500 gramos');


# PROCEDIMIENTO PARA CONSULTAR PESO
DELIMITER //
CREATE PROCEDURE consultar_peso
(
IN _id_animales_ VARCHAR (10)
)
BEGIN
SELECT * FROM peso_historial WHERE id_animales_ = _id_animales_;
END
//
#Llamar procedimiento consultar peso animales
CALL consultar_peso(1);

#______________________________________ TRIGGERS_________________________________________________________________________________________

#Generar al menos 4 triggers

# CREACION DE LA TABLA control_de_cambios_zoologico 
CREATE TABLE control_de_cambios_zoologico (
usuario VARCHAR(45),
accion VARCHAR (45),
fecha DATETIME DEFAULT current_timestamp
);

# 1. CREACION DE TRIGGER PARA REGISTRO DE ACCION AL AGREGAR PESO
DELIMITER //
CREATE TRIGGER registro_agregar_peso
AFTER INSERT 
ON peso_historial FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoologico (usuario,accion,fecha) 
VALUES ('Sergio Paez, entrenador','Agregar peso',now());
END
//
#Se usa el proceimiento agregar peso para cargar el registro
CALL agregarPeso('1','1600 gtramos');

#se lista la tablacontrol_de_cambios_zoologico
SELECT * FROM control_de_cambios_zoologico;

# 2. CREACION  DE TRIGGER PARA REGISTRO DE ACCION AL ELIMINAR UN PROVEEDOR 
DELIMITER //
CREATE TRIGGER registro_borrar_proveedor
AFTER DELETE 
ON proveedor FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoologico (usuario,accion,fecha) 
VALUES ('Antionio Pardo','Borrar proveedor',now());
END
//
#Se llama el procedimiento creado para borrar proveedor
CALL borrar_proveedor(1);

# 3. CREACION DE TRIGGER PARA REGISTRAR ACCION DE CREACION DE PROVEEDOR
DELIMITER //
CREATE TRIGGER registro_agregar_proveedor
AFTER INSERT 
ON proveedor FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoologico (usuario,accion,fecha) 
VALUES ('Miguel Molina','Agregar proveedor',now());
END
//
#Se usa el proceimiento agregar proveedor para cargar el registro
CALL agregarProveedor('12','Aves','Cali','Aves@agro.com');

#se lista la tablacontrol_de_cambios_libreria
SELECT * FROM control_de_cambios_zoologico;

# 4. CREACION DE TRIGGER PARA REGISTRAR ACCION DE CREACION DE ALIMENTO
DELIMITER //
CREATE TRIGGER registro_agregar_alimento
AFTER INSERT 
ON alimento FOR EACH ROW
BEGIN
INSERT INTO control_de_cambios_zoologico (usuario,accion,fecha) 
VALUES ('Angel Mora','Agregar alimento',now());
END
//
#Se agrega el alimento
INSERT INTO alimento (id_alimento,nombre,dosis) VALUES ('A10','Purina pez','50 gramos');

#se lista la tablacontrol_de_cambios_libreria
SELECT * FROM control_de_cambios_zoologico;

