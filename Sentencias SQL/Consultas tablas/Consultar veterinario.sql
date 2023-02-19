select v.idEmpleado, v.nombre,group_concat(ad.idDieta_alimento) as dietas_diseñadas,group_concat(a.nombre) as alimentos, group_concat(a.tipo) as tipos, group_concat(a.dosis) as dosis_alimento
from veterinario v
join dieta d on d.idEmpleado_veterinario=v.idEmpleado
join alimento_dieta ad on ad.idDieta_alimento=d.idDieta
join alimento a on a.idAlimento=ad.idAlimento_dieta
group by v.idEmpleado;