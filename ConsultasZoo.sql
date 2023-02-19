

#1.Obtener todos los animales registrados en la base de datos:
SELECT * FROM animal;

#2.Obtener el nombre y el tipo de especie de los animales registrados
SELECT nombre, tipo_especie FROM animal;

#3.Obtener el nombre y la dirección de todos los proveedores registrados en la base de datos:
SELECT nombre, direccion
FROM proveedor;

#4.Obtener los detalles de la dieta que un animal en particular está siguiendo:
SELECT d.nombre, d.dosis, v.nombre AS nombre_veterinario, v.telefono AS telefono_veterinario 
FROM dieta d
INNER JOIN veterinario v ON d.veterinario_id_d = v.id_veterinario
INNER JOIN animal a ON d.id_dieta = a.dieta_id_a
WHERE a.nombre = 'Mufasa';

#5. Consulta para obtener el detalle y el costo total de todas las facturas, junto con el nombre del proveedor que las emitió:
SELECT f.detalle, f.total, p.nombre AS proveedor 
FROM factura f 
INNER JOIN proveedor p ON f.proveedor_id_o = p.id_proveedor;

#6. Consulta para obtener todos los animales de una misma especie
SELECT * FROM animal WHERE animal.tipo_especie = "Felino";

#7. Consulta para conocer el estado actual del inventario de alimentos
SELECT * FROM alimento;

#8. Consulta para saber que animales son mayores de 5 años de edad
SELECT * FROM animal where animal.edad >= 5;

#9. Consulta para agrupar todos los telefonos de los proveedores
select proveedor.nombre,GROUP_CONCAT(telefono_proveedor.telefono_proveedor separator ', ')as telefonos
from proveedor inner join telefono_proveedor on id_proveedor = telefono_proveedor.proveedor_id_proveedor
group by proveedor.nombre;

#10.Listado de todas las dietas existentes
SELECT * FROM dieta;


