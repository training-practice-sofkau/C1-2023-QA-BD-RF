use zoologico;

-- ----------------------------------------------------------
-- vista para visualizar la cantidad de alimento disponible
-- asociado a su proveedor
-- ------------------------------------------------------------
create view proveedor_alimento_cantidad as
select proveedor.nombre as proveedor, alimento.nombre as alimento,
alimento.cantidad as cantidad
from proveedor
inner join orden_compra on proveedor.id = orden_compra.proveedor_id
inner join orden_alimento on orden_compra.id = orden_alimento.orden_compra_id
inner join alimento on orden_alimento.alimento_id = alimento.id;

-- -------------------------------------------------------------------------
-- vista donde se relaciona el peso reportado de animal con los alimentos
-- que consume, segun su dieta asignada
-- --------------------------------------------------------------------------
create view peso_animal_alimentos as
select animal.id as animal_id, reporte.peso_animal, animal.especie as especie,
group_concat(distinct alimento.nombre separator ', ') as alimento,
dieta.dosis as dosis
from reporte
inner join animal on reporte.animal_id = animal.id
inner join dieta on animal.dieta_id = dieta.id
inner join alimento_dieta on dieta.id = alimento_dieta.dieta_id
inner join alimento on alimento_dieta.alimento_id = alimento.id
group by animal.id, reporte.peso_animal;


-- --------------------------------------------------------------------
-- vista para visualizar las facturas recibidas en lo corrido del 2023
-- --------------------------------------------------------------------

create view facturas_año as
select factura.fecha, alimento.nombre as producto, factura.unidades, proveedor.nombre proveedor
from alimento
inner join orden_alimento on alimento.id = orden_alimento.alimento_id
inner join orden_compra on orden_alimento.orden_compra_id = orden_compra.id
inner join proveedor on orden_compra.proveedor_id = proveedor.id
inner join factura on proveedor.id = factura.id_proveedor
where factura.fecha like '%23';

-- ---------------------------------------------------------------
-- vista para visualizar las ordenes de compra generadas
-- ---------------------------------------------------------------

create view orden_compra_view as
select orden_compra.fecha as fecha_orden, alimento.nombre as producto,
orden_compra.unidades as unidades_solicitadas
from alimento
inner join orden_alimento on alimento.id = orden_alimento.alimento_id
inner join orden_compra on orden_alimento.orden_compra_id = orden_compra.id;


