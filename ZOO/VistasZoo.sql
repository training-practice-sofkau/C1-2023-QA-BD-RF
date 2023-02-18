# Generar de 4 a 6 vistas donde se evidencie lo más importante de cada ejercicio 
# (haga una selección muy responsable de la información realmente importante según el contexto).

# Como el planteamiento inicial especifica que el objetivo es la gestion del consumo de alimentos de los animales del ZOO la conservacion
# Se escogen las siguientes vistas en busqueda se seguir el objetivo planteado 

USE zoologico;

# VISTA 1: Permite ver la lista de los alimentos que existen en el zoologico 
CREATE VIEW ListaAlimentos AS
select alimento.nombre, alimento.dosis, tipo_alimento.tipo
from alimento 
inner join tipo_alimento on alimento.id_alimento = tipo_alimento.id_aliment;
SELECT * FROM ListaAlimentos;

#VISTA 2: Se muestra registros que corresponden a la dieta ordenada por el veterinario
CREATE VIEW DietaAnimal AS
select veterinario.nombre as Vetertinario, dieta.recomendaciones AS Recomendaciones, alimento.nombre AS Alimento_ordenado
from veterinario
inner join dieta_veterinario on dieta_veterinario.id_veterinario_ = veterinario.id_veterinario
inner join dieta on dieta.id_dieta = dieta_veterinario.id_dieta_
inner join dieta_alimento on dieta_alimento.id_dietas = dieta.id_dieta
inner join alimento on alimento.id_alimento = dieta_alimento.id_aliments;
select * from DietaAnimal;

# VISTA 3: Mostrar historial del peso por medio de la vista
CREATE VIEW HistorialPeso AS
select animal.nombre AS NombreAnimal, clasificacion_animal.clasificacion AS ClaseAnimal, 
group_concat(peso_historial.peso separator ' ,')   AS PesosRegistrados
from animal 
inner join clasificacion_animal on animal.id_animal = clasificacion_animal.id_animales
inner join peso_historial on animal.id_animal = peso_historial.id_animales_;
select * from HistorialPeso;

# VISTA 4: Mostrar historial de empleados que han gestionado alimentos
CREATE VIEW GestioNAlimentos AS
select alimento.nombre AS Alimento, alimento.dosis, emp_logistic.nombre AS EmpleadoGestor
from alimento 
inner join alimento_logistico on alimento.id_alimento = alimento_logistico.id_alimento_
inner join emp_logistic on emp_logistic.id_logistico = alimento_logistico.id_logistico;
select * from GestionAlimentos;
