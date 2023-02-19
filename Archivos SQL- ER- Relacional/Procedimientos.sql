DELIMITER //
CREATE PROCEDURE insertar_animal (IN idAnimal VARCHAR(10), IN nombreAnimal VARCHAR(45), IN especie_id VARCHAR(10), IN dieta_id VARCHAR(10))
BEGIN
    INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) 
    VALUES (idAnimal, nombreAnimal, especie_id, dieta_id);
END;

CALL insertar_animal ('A15', 'Pantera', 'ESP1', 'D1');

// DELIMITER ;

DELIMITER //
CREATE PROCEDURE insertar_alimento (IN idAlimento VARCHAR (10), IN nombreAlimento VARCHAR(20), IN tipoAlimento VARCHAR(45))
BEGIN
    INSERT INTO zoologico.alimento (idAlimento, nombreAlimento, tipoAlimento) VALUES (idAlimento, nombreAlimento, tipoAlimento);
END;

CALL insertar_alimento ('Al1','ALPISTE', 'GRANO');

// DELIMITER ;

DELIMITER //
CREATE PROCEDURE insertar_entrenador (IN idEntrenador VARCHAR(10), IN nombreEntrenador VARCHAR(45))
BEGIN
    INSERT INTO zoologico.entrenador (idEntrenador, nombreEntrenador) VALUES (idEntrenador, nombreEntrenador);
END;

CALL insertar_entrenador ('EME10', 'Tin tin');

// DELIMITER ;

DELIMITER //
CREATE PROCEDURE insertar_proveedor (IN idproveedor VARCHAR(10), IN nombreProveedor VARCHAR(45))
BEGIN
    INSERT INTO zoologico.proveedor (idproveedor, nombreProveedor) VALUES  (idproveedor, nombreProveedor) ;
END;

CALL insertar_proveedor ('PRO10', 'Max Power');

// DELIMITER ;



