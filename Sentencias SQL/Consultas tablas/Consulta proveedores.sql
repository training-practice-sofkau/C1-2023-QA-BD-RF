SELECT p.idProveedor,p.nombre as nombre_proveedor,group_concat(a.idAlimento) as id_alimento,group_concat(a.nombre) as nombre_alimento
FROM alimentos_parque_santafe.proveedor p
join alimento a on p.idProveedor=a.idProveedor_alimento
group by p.idProveedor;