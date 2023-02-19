create view dietas as
SELECT d.idDieta_alimento as id_dieta,group_concat(d.idAlimento_dieta) as id_alimento,
group_concat(a.nombre) as nombre_alimento, group_concat(a.tipo) as tipo_alimento
FROM alimentos_parque_santafe.alimento_dieta d
join alimento a on d.idAlimento_dieta=a.idAlimento
group by d.idDieta_alimento;