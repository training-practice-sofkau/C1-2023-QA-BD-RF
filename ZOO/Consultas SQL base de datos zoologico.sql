# Consultas zoologico 

# 1. MOSTRAR LISTA DE ALIMENTOS
select alimento.nombre, alimento.dosis, tipo_alimento.tipo
from alimento 
inner join tipo_alimento on alimento.id_alimento = tipo_alimento.id_aliment;

# 2. MOSTRAR LISTA DE PROVEEDORES
select * from proveedor;

# 3. MOSTRAR DIETA 
select veterinario.nombre, dieta.recomendaciones, alimento.nombre
from veterinario
inner join dieta_veterinario on dieta_veterinario.id_veterinario_ = veterinario.id_veterinario
inner join dieta on dieta.id_dieta = dieta_veterinario.id_dieta_
inner join dieta_alimento on dieta_alimento.id_dietas = dieta.id_dieta
inner join alimento on alimento.id_alimento = dieta_alimento.id_aliments;

# 4. Mostrar historial de peso = el veterinario podra consultar el historial de peso por animal y notar los cambios existidos por cada registro
select animal.nombre, clasificacion_animal.clasificacion, peso_historial.peso
from animal 
inner join clasificacion_animal on animal.id_animal = clasificacion_animal.id_animales
inner join peso_historial on animal.id_animal = peso_historial.id_animales_;

# 5. mostrar los empleados
select veterinario.nombre, entrenador.nombre, emp_logistic.nombre
from veterinario, entrenador, emp_logistic;

#6. MOSTRAR FACTURAS
select * from facturas;

# 7. mostrar lista de animales y su clasificacion
select animal.nombre, clasificacion_animal.clasificacion
from animal 
inner join clasificacion_animal on animal.id_animal = clasificacion_animal.id_animales;

# 8. Mostrar orden de compra 
select * from orden_compra;

# 9. Entrenador que pesa al animal 
select entrenador.nombre, animal.nombre
from entrenador 
inner join entrenador_animal on entrenador.id_entrenador = entrenador_animal.id_entrenador_
inner join animal on animal.id_animal = entrenador_animal.id_animal_;

# 10. Alimentos gestionados por el empleado logistico
select alimento.nombre, alimento.dosis, emp_logistic.nombre
from alimento 
inner join alimento_logistico on alimento.id_alimento = alimento_logistico.id_alimento_
inner join emp_logistic on emp_logistic.id_logistico = alimento_logistico.id_logistico;



