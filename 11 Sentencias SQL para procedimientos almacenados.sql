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



CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_recibo_factura`()
BEGIN
    CREATE TABLE resultado_procedimiento(
        `cedula_cli` VARCHAR(50),
        `primer_nombre` VARCHAR(50),
        `nombre_prod` VARCHAR(50),
        `cantidad` VARCHAR(50),
        `valor_total` VARCHAR(50)
	);

    INSERT INTO resultado_procedimiento
    SELECT c.cedula_cli, c.primer_nombre, pr.nombre_prod, ce.cantidad, pr.valor_venta * ce.cantidad
    FROM cliente c
    LEFT JOIN pedido p ON c.ID_cli = p.ID_cli
    LEFT JOIN cesta ce ON p.codigo_pedido = ce.codigo_pedido
    LEFT JOIN producto pr ON ce.ID_producto = pr.ID_producto;

    SELECT * FROM resultado_procedimiento;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_tabla_ganancias`()
BEGIN
    CREATE TABLE procedimiento_ganancias (
        `codigo_pedido` VARCHAR(50),
        `cedula_cli` VARCHAR(50),
        `nombre_prod` VARCHAR(50),
        `cantidad` VARCHAR(50),
        `precio_compra_total` VARCHAR(50),
        `valor_total`VARCHAR(50),
        `ganancia` VARCHAR(50)
    );

    INSERT INTO procedimiento_ganancias
    SELECT p.codigo_pedido, c.cedula_cli, pr.nombre_prod, ce.cantidad, 
    ce.cantidad * pr.valor_compra AS precio_compra_total, 
    ce.cantidad * pr.valor_venta AS valor_total,
    (ce.cantidad * pr.valor_venta) - (ce.cantidad * pr.valor_compra) AS ganancia
    FROM cliente c
    LEFT JOIN pedido p ON c.ID_cli = p.ID_cli
    LEFT JOIN cesta ce ON p.codigo_pedido = ce.codigo_pedido
    LEFT JOIN producto pr ON ce.ID_producto = pr.ID_producto;

    ALTER TABLE procedimiento_ganancias DROP COLUMN primer_nombre;

    SELECT * FROM procedimiento_ganancias;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_ganancia_total`()
BEGIN
    DECLARE ganancia_total VARCHAR(50);
    SELECT SUM(ganancia) INTO ganancia_total FROM procedimiento_ganancias;
    CREATE TABLE Ganancias_total (ganancia_total VARCHAR(50));
    INSERT INTO Ganancias_total VALUES (ganancia_total);
    SELECT ganancia_total;
END




