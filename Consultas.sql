use tiendadonpepe;
-- -----------------------------------------------------
-- Conocer las categorias y sus prodcutos

select categoria.nombre as Nombre_Categoria, group_concat(producto.nom_producto separator ', ') as Nombre_Productos
from producto inner join  categoria
on producto.id_categorias = categoria.id_categoria
group by categoria.nombre;
-- -----------------------------------------------------
-- Conocer cuantas unidades hay de cada producto 

select producto.nom_producto as Nombre_Producto, sum(inventario.cant_disponible) as Unidades_Disponibles
from producto inner join inventario
on producto.nom_producto= inventario.nombre_producto
group by producto.nom_producto;

-- -----------------------------------------------------
-- Conocer que  proveedor me ha suministrado que productos

select proveedor.razon_social as Nombre_Proveedor, group_concat(producto.nom_producto separator ', ') as Nombre_Productos
from producto inner join producto_proveedor
on producto.nom_producto= producto_proveedor.nombre_prod
inner join proveedor
on proveedor.razon_social= producto_proveedor.razon_social
group by proveedor.razon_social;

-- -----------------------------------------------------
-- Conocer la zona y sus clientes 

select zona.nombre as Barrio, group_concat(cliente.nombre separator ', ') as Clientes
from zona inner join cliente
on zona.cod_postal=cliente.codigo_postal
group by zona.nombre;

-- -----------------------------------------------------
-- Conocer 

