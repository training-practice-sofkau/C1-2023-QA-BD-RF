create view veterinarios as
select v.idEmpleado, v.nombre, group_concat(tv.telefono_veterinario) as telefonos_veterinario
from dieta d
join veterinario v on d.idEmpleado_veterinario=v.idEmpleado
join telefono_veterinario tv on tv.idEmpleado_telefono=v.idEmpleado
group by v.idEmpleado;