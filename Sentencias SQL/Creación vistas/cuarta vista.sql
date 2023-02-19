create view proveedores as
select p.idProveedor, p.nombre, group_concat(tp.telefono_proveedor) as telefonos_proveedor
from alimento_dieta ad
join alimento a on a.idAlimento=ad.idAlimento_dieta
join proveedor p on p.idProveedor=a.idProveedor_alimento
join telefono_proveedor tp on tp.idProveedor_telefono=p.idProveedor
group by p.idProveedor