use tiendadonpepe;
-- -----------------------------------------------------
-- 1- Conocer las categorias y sus prodcutos

select categoria.nombre as Nombre_Categoria, 
group_concat(producto.nom_producto separator ', ') as Nombre_Productos
from producto inner join  categoria
on producto.id_categorias = categoria.id_categoria
group by categoria.nombre;
-- -----------------------------------------------------
-- 2- Conocer cuantas unidades hay de cada producto 

select producto.nom_producto as Nombre_Producto, sum(inventario.cant_disponible) as Unidades_Disponibles
from producto inner join inventario
on producto.nom_producto= inventario.nombre_producto
group by producto.nom_producto;

-- -----------------------------------------------------
-- 3- Conocer que  proveedor me ha suministrado que productos

select proveedor.razon_social as Nombre_Proveedor,
 group_concat(producto.nom_producto separator ', ') 
as Nombre_Productos
from producto inner join producto_proveedor
on producto.nom_producto= producto_proveedor.nombre_prod
inner join proveedor
on proveedor.razon_social= producto_proveedor.razon_social
group by proveedor.razon_social;

-- -----------------------------------------------------
-- 4- Conocer la zona y sus clientes 

select zona.nombre as Barrio, group_concat(cliente.nombre separator ', ') as Clientes
from zona inner join cliente
on zona.cod_postal=cliente.codigo_postal
group by zona.nombre;

-- -----------------------------------------------------
-- 5- Conocer que productos se han agregado a un carrito de compra 

select carrito_compra_producto.id_carrito_compra as Carrito_Compra, 
carrito_compra_producto.nombre_producto as Nombre_Producto,
carrito_compra_producto.cantidad as Cantidad
from carrito_compra_producto
where carrito_compra_producto.id_carrito_compra='1';

-- -----------------------------------------------------
-- 6- Conocer cuantos pedidos han sido confimados

select pedido.codigo_pedido as Codigo,
pedido.id_carrito_compra as Pedido_Confirmado
from pedido; 

 -- -----------------------------------------------------
-- 7-Conocer cuantos pedidos ha repartido cada domiciliario

select domiciliario.nombre as Nombre_Domiciliario, count(factura.cedula_cliente) as Numeros_Pedidos
from domiciliario inner join factura 
on domiciliario.cedula_domiciliario= factura.ced_domiciliario
group by domiciliario.nombre; 

 -- -----------------------------------------------------
-- 8-Conocer cuantos pedidos ha generado cada cliente

select cliente.nombre as Nombre_Cliente, count(factura.codigo_factura) as Pedidos_Realizados
from cliente inner join factura 
on cliente.ced_cliente= factura.cedula_cliente
group by cliente.nombre;

 -- -----------------------------------------------------
-- 9-Conocer el numero de pedidos repartidos por cada domiciliario  
--  en una zona especifica

select domiciliario.nombre as Nombre_Domiciliario, 
zona.nombre as Zona,
count(factura.cod_pedido) as Numero_Pedidos
from domiciliario inner join factura 
on domiciliario.cedula_domiciliario = factura.ced_domiciliario
inner join cliente  on factura.cedula_cliente = cliente.ced_cliente
inner join zona on cliente.codigo_postal= zona.cod_postal
where zona.nombre = 'Emilio sierra'
group by domiciliario.nombre;

 -- -----------------------------------------------------
-- 10- Conocer el numero de productos en cada categoria suministrado por cada proveedor

select proveedor.razon_social as Nombre_Proveedor, categoria.nombre as Nombre_Categoria, 
count(producto.nom_producto) as Numero_de_Productos
from proveedor inner join producto_proveedor
on proveedor.razon_social = producto_proveedor.razon_social
inner join producto on producto_proveedor.nombre_prod = producto.nom_producto
inner join categoria on producto.id_categorias = categoria.id_categoria
group by proveedor.razon_social, categoria.nombre;



