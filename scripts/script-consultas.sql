use zoologico;

-- -----------------------------------------------------
-- Consulta para visualizar Reportes de un Animal
-- ------------------------------------------------------

select * from reporte where reporte.animal_id = '001';

-- -------------------------------------------------------
-- Consulta para visualizar la cantidad de Alimento
-- -------------------------------------------------------

select nombre, cantidad from alimento;

-- -------------------------------------------------------
-- Consulta para visualizar las ordenes de compras
-- generadas por un Empleado_logistico, ingresando su id
-- -------------------------------------------------------

select * from orden_compra
where empleado_logistico_id = "E1";

-- ------------------------------------------------------
-- Consulta para visualizar el proveedor de cada alimento
-- ------------------------------------------------------

select proveedor.nombre as proveedor, alimento.nombre as alimento
from proveedor
inner join orden_compra on proveedor.id = orden_compra.proveedor_id
inner join orden_alimento on orden_compra.id = orden_alimento.orden_compra_id
inner join alimento on orden_alimento.alimento_id = alimento.id;

-- ------------------------------------------------------------------
-- Consulta para visualizar los alimentos contenidos en una Dieta
-- ----------------------------------------------------------------

select distinct dieta.nombre as dieta, group_concat(distinct alimento.nombre separator ', ') as alimento
from alimento
inner join alimento_dieta on alimento.id = alimento_dieta.alimento_id
inner join dieta on alimento_dieta.dieta_id = dieta.id
group by dieta.id;

-- -------------------------------------------------------------------
-- Consulta para visualizar las facturas enviadas por los proveedores
-- ------------------------------------------------------------------

select factura.fecha, alimento.nombre as producto, factura.unidades, proveedor.nombre proveedor
from alimento
inner join orden_alimento on alimento.id = orden_alimento.alimento_id
inner join orden_compra on orden_alimento.orden_compra_id = orden_compra.id
inner join proveedor on orden_compra.proveedor_id = proveedor.id
inner join factura on proveedor.id = factura.id_proveedor;



-- -------------------------------------------------------------------------
-- Consulta para visualizar el veterinario que formula dieta a una especie
-- -------------------------------------------------------------------------

select distinct dieta.nombre as dieta, group_concat(distinct alimento.nombre separator ', ') as alimento,
veterinario.nombre as veterinario
from alimento
inner join alimento_dieta on alimento.id = alimento_dieta.alimento_id
inner join dieta on alimento_dieta.dieta_id = dieta.id
inner join veterinario on dieta.veterinario_id = veterinario.id
group by dieta.id;

-- --------------------------------------------------------------------
-- Consulta que permite visualizar reporte asociado a un animal
-- consultado por un veterinario
-- ----------------------------------------------------------------------

select veterinario.nombre as veterinario, animal.especie as especie, animal.id as id_animal, reporte.peso_animal
from veterinario
inner join veterinario_reporte on veterinario.id = veterinario_reporte.veterinario_id
inner join reporte on veterinario_reporte.reporte_id = reporte.id
inner join animal on reporte.animal_id = animal.id;

-- ---------------------------------------------------------------------
-- Consulta para visualizar los alimentos consumidos por un animal
-- y relacionarlos con su peso
-- ----------------------------------------------------------------------

select animal.id as animal_id, reporte.peso_animal, animal.especie as especie,
group_concat(distinct alimento.nombre separator ', ') as alimento,
dieta.dosis
from reporte
inner join animal on reporte.animal_id = animal.id
inner join dieta on animal.dieta_id = dieta.id
inner join alimento_dieta on dieta.id = alimento_dieta.dieta_id
inner join alimento on alimento_dieta.alimento_id = alimento.id
group by animal.id, reporte.peso_animal;

-- ----------------------------------------------------------
-- Consulta para visualizar todas las facturas del año 2023
-- ----------------------------------------------------------

select factura.fecha, alimento.nombre as producto, factura.unidades, proveedor.nombre proveedor
from alimento
inner join orden_alimento on alimento.id = orden_alimento.alimento_id
inner join orden_compra on orden_alimento.orden_compra_id = orden_compra.id
inner join proveedor on orden_compra.proveedor_id = proveedor.id
inner join factura on proveedor.id = factura.id_proveedor
where factura.fecha like '%23';

