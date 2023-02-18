select v.idEmpleado as id_veterinario, group_concat(tv.telefono_veterinario) as telefonos_veterinario
from veterinario v
join telefono_veterinario tv on v.idEmpleado=tv.idEmpleado_telefono
group by v.idEmpleado