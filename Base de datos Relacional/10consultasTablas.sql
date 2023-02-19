USE tienda_don_pepe;

-- consulta 1 cliente datos de contacto y su direccion
SELECT nombre_cliente, cedula, email,  telefono, calle, numero, barrio
FROM cliente
INNER JOIN direccion_cliente 
ON cliente.id_cliente = direccion_cliente.id_cliente;


-- consulta 2 mostrar los productos y caracteristicas que comiencen por la letra A
SELECT *
FROM Producto
WHERE nombre_producto LIKE 'A%';

-- Consulta 3  agrupar el numero de  domiciliarios por zonas

SELECT COUNT(nombre_domiciliario), zona_reparto
FROM domiciliario
GROUP BY domiciliario.zona_reparto;

-- consulta 4 listado de productos nombre y precio

SELECT concat(nombre_producto, ' , ',  marca, + ' , ', precio ) lista_producto 
FROM producto;

-- Consulta 5 pedidos con sus fechas pedido, direccion de pedido y estatus

SELECT  fecha_pedido as 'fecha' , nombre_cliente, direccion_cliente.calle, direccion_cliente.numero, direccion_cliente.barrio, estado_pedido.estado
FROM pedido
INNER JOIN estado_pedido
ON estado_pedido.id_estado_pedido = pedido.id_estado_pedido
INNER JOIN cliente 
ON pedido.id_cliente = cliente.id_cliente
INNER JOIN direccion_cliente 
ON pedido.id_cliente = direccion_cliente.id_cliente;

-- Consulta 6 buscar cliente Juan Perez

SELECT *
FROM cliente
WHERE nombre_cliente LIKE '%Juan Perez%';

-- consulta 7 producto cuyo precio es mayor a 8000 $
SELECT *
FROM producto
WHERE producto.precio > 8000;

-- consulta 8 mostrar los productos cuyo stock sea menor a 30 productos

SELECT *
FROM producto
WHERE producto.stock <30;



-- consulta 9 Ordenar por stock mayor a 30 unidades y precio los productos de maenra descendente 

SELECT * 
FROM producto
WHERE stock < 30
ORDER BY precio DESC;


-- Consulta 10 ver los clientes y domiciliarios que se pueden encontar en la misma zona
SELECT cliente.nombre_cliente, domiciliario.nombre_domiciliario, zona_postal.zona
FROM cliente
INNER JOIN domiciliario
ON cliente.id_zona_postal = domiciliario.id_zona_postal
INNER JOIN zona_postal
ON cliente.id_zona_postal = zona_postal.id_zona_postal
GROUP BY  cliente.id_zona_postal


  