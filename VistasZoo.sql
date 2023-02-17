
use zoologico;

#1. Vista para ver todos los detalles concatenados de las facturas
CREATE VIEW factura_detalles_concatenados AS
SELECT GROUP_CONCAT(detalle SEPARATOR ', ') AS detalles_concatenados
FROM factura;

#2. Vista que me permite saber el total de todas las facturas sumado
CREATE VIEW vista_total_facturas AS
    SELECT 
        SUM(total) AS total_facturas
    FROM
        factura;
	SELECT total_facturas
		FROM vista_total_facturas;
        
#3. Vista para conocer que dieta esta llevando cada animal y la dosis correspondiente
CREATE VIEW vista_dieta_animal AS
SELECT a.id_animal, a.nombre AS nombre_animal, d.nombre AS nombre_dieta, d.dosis
FROM animal a
JOIN dieta d ON a.dieta_id_a = d.id_dieta;

#4. Vista para conocer los detalles del informe de peso y,el animal, el entrenador que registro el informe.
CREATE VIEW vista_informe_peso_entrenador_animal AS
SELECT i.id_informe, i.fecha, i.peso_animal, i.detalle, a.nombre AS nombre_animal, e.nombre AS nombre_entrenador
FROM informe_peso AS i
JOIN animal AS a ON i.animal_id_i = a.id_animal
JOIN entrenador AS e ON i.entrenador_id_i = e.id_entrenador;