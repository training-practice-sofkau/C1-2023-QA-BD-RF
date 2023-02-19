CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_coincidencia_zonas`()
BEGIN
    CREATE TABLE temp_vista_pedidos (
        codigo_pedido VARCHAR(50),
        nombre_cliente VARCHAR(50),
        direccion_cliente VARCHAR(50),
        zona_cliente VARCHAR(50),
        nombre_domiciliario VARCHAR(50),
        zona_domiciliario VARCHAR(50),
        estado_pedido VARCHAR(50)
    );
    INSERT INTO temp_vista_pedidos 
    SELECT p.codigo_pedido, 
           c.primer_nombre AS nombre_cliente, 
           c.direccion_cli AS direccion_cliente, 
           c.ID_zona AS zona_cliente, 
           d.primer_nombre AS nombre_domiciliario, 
           d.ID_zona AS zona_domiciliario,
           CASE WHEN c.ID_zona = d.ID_zona THEN 'pedido aceptado' ELSE 'no es posible aceptar pedido' END AS estado_pedido
    FROM pedido p
    INNER JOIN cliente c ON p.ID_cli = c.ID_cli
    INNER JOIN domiciliario d ON p.cedula_dom = d.cedula_dom;
    
    SELECT * FROM temp_vista_pedidos;
END


