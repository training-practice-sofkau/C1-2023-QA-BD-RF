#1 Seleccionar los nombres de las dietas de los animales que están en el zoo:
SELECT d.nombreDieta 
FROM Dieta d 
INNER JOIN Animal a ON d.idDieta = a.dieta_id;


#2 Seleccionar los nombres de los animales y los nombres de sus especies:
SELECT a.nombreAnimal, e.nombreEspecie 
FROM Animal a 
INNER JOIN especie e ON a.especie_id = e.idEspecie;

#3 Seleccionar los nombres de las dietas que no tienen ningún animal que la esté siguiendo:
SELECT d.nombreDieta 
FROM Dieta d 
LEFT JOIN Animal a ON d.idDieta = a.dieta_id 
WHERE a.idAnimal IS NULL;

#4 Seleccionar los nombres de los veterinarios y los números de teléfono:
SELECT v.nombreVeterinario, tv.numero 
FROM Veterinario v 
INNER JOIN telefonoVeterinario tv ON v.idVeterinario = tv.idtelefonoVeterinario;


#5 Seleccionar los nombres de los animales y los nombres de sus dietas, incluyendo aquellos animales que no tengan dieta asignada:
SELECT a.nombreAnimal, d.nombreDieta 
FROM Animal a 
LEFT JOIN Dieta d ON a.dieta_id = d.idDieta;


#6 Seleccionar los nombres de las dietas y la cantidad de animales que la siguen, incluyendo aquellas dietas que no tienen ningún animal que la esté siguiendo:
SELECT d.nombreDieta, COUNT(a.idAnimal) AS cantidad 
FROM Dieta d 
LEFT JOIN Animal a ON d.idDieta = a.dieta_id 
GROUP BY d.idDieta;

#7 Seleccionar los nombres de las especies y la cantidad de animales que pertenecen a cada especie:
SELECT esp.nombreEspecie, COUNT(a.idAnimal) AS cantidad 
FROM Animal a 
INNER JOIN especie esp ON a.especie_id = esp.idEspecie 
GROUP BY esp.idEspecie;

#8Mostrar todos los teléfonos de los entrenadores:
SELECT Entrenador.nombreEntrenador, telefonoEntrenador.numero
FROM Entrenador
JOIN telefonoEntrenador ON Entrenador.idEntrenador = telefonoEntrenador.idtelefonoEntrenador;

#9 Mostrar todos los animales dentro del zoo
SELECT nombreAnimal FROM Animal;

#10 Mostrar las dietas usadas ultimamente
SELECT nombreDieta, dosisDieta FROM Dieta
JOIN Animal ON Dieta.idDieta = Animal.dieta_id;


