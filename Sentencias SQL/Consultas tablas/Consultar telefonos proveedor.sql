select p.idProveedor,p.nombre,group_concat(tp.telefono_proveedor) as telefonos_proveedor
from proveedor p
join telefono_proveedor tp on p.idProveedor=tp.idProveedor_telefono
group by p.idProveedor;