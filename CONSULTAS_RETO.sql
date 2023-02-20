USE donpepe;

SELECT DOMICILIARIO.NOMBRE, ZONA.NOMBRE AS ZONA, PEDIDO.FECHA_PEDIDO
FROM DOMICILIARIO 
LEFT JOIN ZONA ON DOMICILIARIO.CODIGO_POSTAL = ZONA.CODIGO_POSTAL
LEFT JOIN PEDIDO ON DOMICILIARIO.ID = PEDIDO.ID_DOMICILIARIO;



/*CONSULTA 2
VER CANTIDAD DE PRODUCTOS HA SUMINISTRADO EL PROVEEDOR*/

SELECT PROVE.NOMBRE AS NOMBRE_PROVEEDOR, COUNT(PROD.ID) AS CATIDAD_PRODUCTOS_SUMINISTRADOS
FROM PROVEEDOR PROVE JOIN PRODUCTO PROD ON PROVE.NIT = PROD.ID_proveedor
GROUP BY PROVE.NOMBRE;



/* CONSULTA 3
VER EL NOMBRE DE CADA PRODUCTO Y LAS VECES QUE HA SIDO PEDIDO*/

SELECT PRODUCTO.NOMBRE AS PRODUCTO, COUNT(*) AS CANTIDAD_PRODUCTOS_PEDIDOS
FROM PEDIDO JOIN PRODUCTO ON PEDIDO.ID = PRODUCTO.ID
GROUP BY PEDIDO.ID;

/*CONSULTA 4
VER EL NOMBRE DEL PRODUCTO CON SU PRECIO Y A QUE CATEGORIA PERTENECE*/

SELECT PR.NOMBRE AS NOMBRE_PRODUCTO, PR.PRECIO AS PRECIO_PRODUCTO, CTG.NOMBRE AS NOMBRE_CATEGORIA
FROM PRODUCTO PR JOIN CATEGORIA CTG ON PR.ID_CATEGORIA = CTG.ID;


/*CONSULTA 5
VER EL NOMBRE DE CADA AREA Y LA CANTIDAD DE PEDIDOS QUE HA RECIBIDO*/

SELECT ZONA.NOMBRE AS ZONA, COUNT(*) AS CANTIDAD_PEDIDOS
FROM PEDIDO JOIN DOMICILIARIO ON PEDIDO.ID_DOMICILIARIO = DOMICILIARIO.ID
JOIN ZONA ON DOMICILIARIO.CODIGO_POSTAL = ZONA.CODIGO_POSTAL
GROUP BY ZONA.NOMBRE;

/*CONSULTA 6
//VER EL CLIENTE Y LA CANTIDAD DE PEDIDOS QUE HA REALIZADO//*/

SELECT CLIENTE.NOMBRE AS CLIENTE, COUNT(*) AS CANTIDAD_PEDIDOS
FROM PEDIDO JOIN CLIENTE ON PEDIDO.ID_CLIENTE = CLIENTE.ID
GROUP BY CLIENTE.NOMBRE;

/*CONSULTA 7
//VER EL NOMBRE DEL PRODUCTO CON SU PRECIO Y CATEGORIA, Y LA CANTIDAD DE VECES QUE SE HA PEDIDO*/

SELECT PR.NOMBRE AS NOMBRE_PRODUCTO, PR.PRECIO AS PRECIO_PRODUCTO, COUNT(*) 
AS CATIDAD_PEDIDOS, CTG.NOMBRE AS NOMBRE_CATEGORIA
FROM DETALLE_PEDIDO DP JOIN PRODUCTO PR ON  PR.ID =DP.ID_PRODUCTO 
JOIN CATEGORIA CTG ON CTG.ID= PR.ID_CATEGORIA 
GROUP BY  PR.ID,CTG.NOMBRE;

/*CONSULTA 8
//NOMBRE DE REPARTIDOR Y SU AREA, CON LA FECHA QUE REALIZÓ EL PEDIDO//*/

SELECT DOMICILIARIO.NOMBRE, ZONA.NOMBRE AS ZONA, PEDIDO.FECHA_PEDIDO
FROM DOMICILIARIO 
LEFT JOIN ZONA ON DOMICILIARIO.CODIGO_POSTAL = ZONA.CODIGO_POSTAL
LEFT JOIN PEDIDO ON DOMICILIARIO.ID = PEDIDO.ID_DOMICILIARIO;
/*CONSULTA 9
//VER EL PRODUCTO DE ACUERDO A SU CATEGORIA Y CUAL FUE SU PROVEEDOR*/




SELECT PRODUCTO.NOMBRE AS PRODUCTO, CATEGORIA.NOMBRE AS CATEGORIA, PROVEEDOR.NOMBRE AS PROVEEDOR, PRODUCTO.PRECIO
FROM PRODUCTO INNER JOIN CATEGORIA ON PRODUCTO.ID_CATEGORIA = CATEGORIA.ID
INNER JOIN PROVEEDOR ON PRODUCTO.ID_PROVEEDOR = PROVEEDOR.NIT;


/*CONSULTA 10
VER EL ID DEL PEDIDO CON LA FECHA EN LA QUE SE PIDIO Y EL DOMICILIARIO ENCARGADO CON EL NUMERO DE SU FURGONETA//
*/
SELECT PEDIDO.ID, PEDIDO.FECHA_PEDIDO, 
DOMICILIARIO.NOMBRE AS DOMICILIARIO, DOMICILIARIO.MATRICULA_FURGONETA
FROM PEDIDO INNER JOIN DOMICILIARIO ON PEDIDO.ID_DOMICILIARIO = DOMICILIARIO.ID;
	
