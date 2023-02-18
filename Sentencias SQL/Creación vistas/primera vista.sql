create view animales as
select a.idAnimal, a.nombre, a.peso, group_concat(cp.pesoAnimal) as historico_pesos,
ad.idDieta_animal, al.tipo,al.dosis,group_concat(al.idProveedor_alimento) as id_proveedor
,group_concat(p.nombre) as nombre_proveedor,group_concat(pv.telefono_proveedor)
as telefonos_proveedor
from animal a
join control_cambio_peso cp on cp.idAnimal_cambio=a.idAnimal
join animal_dieta ad on a.idAnimal=ad.idAnimal_dieta
join alimento_dieta ald on ald.idDieta_alimento=ad.idDieta_animal
join alimento al on al.idAlimento=ald.idAlimento_dieta
join proveedor p on p.idProveedor=al.idProveedor_alimento
join telefono_proveedor pv on pv.idProveedor_telefono=p.idProveedor
group by a.idAnimal,ad.idDieta_animal,al.tipo,al.dosis;