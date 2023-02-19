#Vista 1 Animales por especies 
CREATE VIEW Cantidad_AnimalesXEspecies AS
SELECT especie.nombreEspecie, COUNT(Animal.especie_id) as cantidad
FROM especie
JOIN Animal ON especie.idEspecie = Animal.especie_id
GROUP BY especie.nombreEspecie;

SELECT * FROM Cantidad_AnimalesXEspecies;

#Vista 2 Mostrar todos los animales junto con su especie y su dieta correspondiente:
CREATE VIEW Especies_X_ANIMALES_X_DIETA AS 
SELECT Animal.nombreAnimal, especie.nombreEspecie, Dieta.nombreDieta
FROM Animal
JOIN especie ON Animal.especie_id = especie.idEspecie
JOIN Dieta ON Animal.dieta_id = Dieta.idDieta;

SELECT * FROM Especies_X_ANIMALES_X_DIETA;

#Vista 3 Cantidad de animales (numerico) por especie
CREATE VIEW Cantidad_animalesXEspecie AS
SELECT esp.nombreEspecie, COUNT(a.idAnimal) AS cantidad 
FROM Animal a 
INNER JOIN especie esp ON a.especie_id = esp.idEspecie 
GROUP BY esp.idEspecie;

#Vista 4 que muestra la especie con más animales
CREATE VIEW Especie_x_animales AS
SELECT e.nombreEspecie, COUNT(*) AS cantidad_animales
FROM especie e
JOIN Animal a ON e.idEspecie = a.especie_id
GROUP BY e.idEspecie
ORDER BY cantidad_animales DESC
LIMIT 1;

#Vista 5 que muestra el animal, su tipo de dieta y dosis
CREATE VIEW Dieta_y_Dosis_Animales AS
SELECT nombreAnimal, nombreDieta, dosisDieta FROM Animal
JOIN Dieta ON Animal.dieta_id = Dieta.idDieta;
