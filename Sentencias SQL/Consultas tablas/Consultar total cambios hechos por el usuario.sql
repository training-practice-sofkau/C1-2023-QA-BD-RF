select cd.usuario as usuarios, group_concat(cd.accion,cp.accion) as acciones,group_concat(cd.fecha,cp.fecha) as fechas_de_cambios
from control_cambio_dieta cd
join control_cambio_peso cp on cd.usuario=cp.usuario
group by cd.usuario