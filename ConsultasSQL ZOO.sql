USE zoodb;

-- -----------------------------------------------------
-- 1. Consulta para ver la cantidad y el tipo de alimento existente en la sede
-- -----------------------------------------------------
SELECT nombre_alimento, tipo_alimento, cantidad FROM alimento;

-- -----------------------------------------------------
-- 2. Consulta para ver la dieta de cada animal y el veterinario que la diseñó
-- -----------------------------------------------------
SELECT animal.nombre AS nombre_animal, dieta.tipo_alimento, dieta.dosis, veterinario.nombre AS diseñado_por
FROM animal
INNER JOIN dieta ON animal.id_dieta_animal = dieta.id_dieta
INNER JOIN informe_animal ON animal.id_animal = informe_animal.id_animal_informe
INNER JOIN veterinario_informe ON informe_animal.id_informe = veterinario_informe.id_informe_veterinario
INNER JOIN veterinario ON veterinario_informe.id_veterinario_informe = veterinario.id_veterinario;

-- -----------------------------------------------------
-- 3. Consulta para ver las ordenes de compra y el logistico que lo creó
-- -----------------------------------------------------
SELECT orden_compra.id_orden, orden_compra.fecha_emision, orden_compra.fecha_entrega, orden_compra.descripcion, logistico.nombre as nombre_logistico, logistico.apellido as apellido_logistico
FROM orden_compra
JOIN logistico ON orden_compra.id_logistico_orden = logistico.id_logistico;

-- -----------------------------------------------------
-- 4. Consulta para ver la cantidad de alimento existente segun tipo de alimento, 
-- y total de alimento diario Requerido segun dietas diseñadas
-- -----------------------------------------------------
SELECT dieta.tipo_alimento, SUM(dieta.dosis) AS total_alimento_diario_requerido, 
    (SELECT SUM(cantidad) FROM alimento WHERE alimento.tipo_alimento = dieta.tipo_alimento) AS cantidad_existente
FROM dieta
WHERE dieta.tipo_alimento IN (SELECT tipo_alimento FROM alimento)
GROUP BY dieta.tipo_alimento;

-- -----------------------------------------------------
-- 5. Consulta para ver el alimento que un animal consume diario segun su dieta
-- -----------------------------------------------------
SELECT animal.nombre AS nombre_animal, alimento.nombre_alimento, alimento.tipo_alimento, dieta.dosis
FROM animal
JOIN dieta ON animal.id_dieta_animal = dieta.id_dieta
JOIN alimento ON dieta.tipo_alimento = alimento.tipo_alimento;

-- -----------------------------------------------------
-- 6. Consulta para ver el informe de todos los animales y el entrenador
-- -----------------------------------------------------
SELECT animal.nombre AS nombre_animal, informe_animal.fecha_peso, informe_animal.peso_registrado, informe_animal.detalles, entrenador.nombre AS nombre_entrenador, entrenador.apellido AS apellido_entrenador
FROM animal
JOIN informe_animal ON animal.id_animal = informe_animal.id_animal_informe
JOIN entrenador ON informe_animal.id_entrenador_informe = entrenador.id_entrenador;

-- -----------------------------------------------------
-- 7. Consulta para ver todas las facturas y la informacion del proveedor 
-- -----------------------------------------------------
SELECT factura.id_factura, proveedor.nombre, proveedor.telefono, proveedor.correo, 
proveedor.direccion, factura.total
FROM factura
JOIN proveedor
ON factura.nit_proveedor_factura = proveedor.nit;

-- -----------------------------------------------------
-- 8. Consulta para ver el nombre, la clase, la especie y la fecha de nacimiento de animales
-- -----------------------------------------------------
SELECT nombre, clase, especie, fecha_nacimiento FROM animal;

-- -----------------------------------------------------
-- 9. Consulta para ver la cantidad de animales segun su clase
-- -----------------------------------------------------
SELECT clase, COUNT(*) AS cantidad
FROM animal
GROUP BY clase;

-- -----------------------------------------------------
-- 10. Consulta para saber la cantidad de alimento existente segun el tipo de alimento
-- -----------------------------------------------------
SELECT tipo_alimento, SUM(cantidad) as cantidad_total 
FROM alimento 
GROUP BY tipo_alimento;









