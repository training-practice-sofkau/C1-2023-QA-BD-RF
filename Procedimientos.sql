USE zoodb;

-- -----------------------------------------------------
-- 1. Obtener proveedores por tipo de alimento
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE obtener_proveedores_por_tipo_alimento(IN tipo_alimento VARCHAR(45))
BEGIN
    SELECT p.nombre, p.telefono, p.correo, p.direccion
    FROM proveedor p
    JOIN proveedor_alimento pa ON p.nit = pa.id_proveedor_alimento
    JOIN alimento a ON pa.id_alimento_proveedor = a.id_alimento
    WHERE a.tipo_alimento = tipo_alimento;
END //
DELIMITER ;

CALL obtener_proveedores_por_tipo_alimento('Tipo 1');

-- -----------------------------------------------------
-- 2. Agregar nueva dieta
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregar_nueva_dieta(
	dieta_id VARCHAR(20),
    alimento_tipo VARCHAR(45),
    alimentoDosis VARCHAR(45)
)
BEGIN
    INSERT INTO dieta (id_dieta, tipo_alimento, dosis) VALUES (dieta_id, alimento_tipo, alimentoDosis) ;
END//
DELIMITER ;

call agregar_nueva_dieta('DIE-003', 'Tipo 1', '80 gr');
call agregar_nueva_dieta('DIE-004', 'Tipo 3', '300 gr');
call agregar_nueva_dieta('DIE-005', 'Tipo 3', '300 gr');

-- -----------------------------------------------------
-- 3. Actualizar dieta de un animal
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE actualizar_dieta_animal(
	idAnimal VARCHAR(20),
	id_dietaAnimal VARCHAR(20)
)
BEGIN
    UPDATE animal SET id_dieta_animal= id_dietaAnimal WHERE id_animal = idAnimal ;
END//
DELIMITER ;

call actualizar_dieta_animal('ANI-001', 'DIE-002');
call actualizar_dieta_animal('ANI-001', 'DIE-003');
-- -----------------------------------------------------
-- 4. Eliminar una factura
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE eliminar_factura_saldada(
    IN factura_id VARCHAR(20)
)
BEGIN
    DELETE FROM factura
    WHERE id_factura = factura_id; 
END//
DELIMITER ;

call eliminar_factura_saldada('FAC-001');

