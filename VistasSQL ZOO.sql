USE zoodb;

-- -----------------------------------------------------
-- 1. Vista para ver la dieta de cada animal y el veterinario que la diseñó
-- -----------------------------------------------------
CREATE VIEW vista_animal_dieta_veterinario AS
SELECT animal.nombre AS nombre_animal, dieta.tipo_alimento, dieta.dosis, veterinario.nombre AS disenado_por
FROM animal
INNER JOIN dieta ON animal.id_dieta_animal = dieta.id_dieta
INNER JOIN informe_animal ON animal.id_animal = informe_animal.id_animal_informe
INNER JOIN veterinario_informe ON informe_animal.id_informe = veterinario_informe.id_informe_veterinario
INNER JOIN veterinario ON veterinario_informe.id_veterinario_informe = veterinario.id_veterinario;

-- -----------------------------------------------------
-- 2. Vista para ver el alimento y el proveedor de ese alimento
-- -----------------------------------------------------
CREATE VIEW vista_alimento_proveedor AS
SELECT a.nombre_alimento, p.nombre as proveedor
FROM alimento a 
JOIN proveedor_alimento pa ON a.id_alimento = pa.id_alimento_proveedor 
JOIN proveedor p ON pa.id_proveedor_alimento = p.nit;

-- -----------------------------------------------------
-- 3. Vista para ver el alimento que un animal consume diario segun su dieta
-- -----------------------------------------------------
CREATE VIEW vista_alimento_animal_segun_dieta AS
SELECT animal.nombre AS nombre_animal, alimento.nombre_alimento, alimento.tipo_alimento, dieta.dosis
FROM animal
JOIN dieta ON animal.id_dieta_animal = dieta.id_dieta
JOIN alimento ON dieta.tipo_alimento = alimento.tipo_alimento;

-- -----------------------------------------------------
-- 4. Vista para ver el informe de todos los animales y el entrenador
-- -----------------------------------------------------
CREATE VIEW vista_informe_de_animales_y_entrenador AS
SELECT animal.nombre AS nombre_animal, informe_animal.fecha_peso, informe_animal.peso_registrado, informe_animal.detalles, entrenador.nombre AS nombre_entrenador, entrenador.apellido AS apellido_entrenador
FROM animal
JOIN informe_animal ON animal.id_animal = informe_animal.id_animal_informe
JOIN entrenador ON informe_animal.id_entrenador_informe = entrenador.id_entrenador;

-- -----------------------------------------------------
-- 5. Vista para ver la cantidad de alimento existente segun tipo de alimento, 
-- y total de alimento diario Requerido segun dietas diseñadas
-- -----------------------------------------------------
CREATE VIEW vista_cantidad_alimento_existente_comparando_dieta_necesaria AS
SELECT dieta.tipo_alimento, SUM(dieta.dosis) AS total_alimento_diario_requerido, 
    (SELECT SUM(cantidad) FROM alimento WHERE alimento.tipo_alimento = dieta.tipo_alimento) AS cantidad_existente
FROM dieta
WHERE dieta.tipo_alimento IN (SELECT tipo_alimento FROM alimento)
GROUP BY dieta.tipo_alimento;
