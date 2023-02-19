CREATE VIEW vista_clientespedido AS
SELECT c.cedula_cli, c.primer_nombre, p.codigo_pedido, p.estado, 
r.primer_nombre AS responsable_nombre, t.telefono_res AS responsable_telefono, 
d.primer_nombre AS domiciliario_nombre, td.telefono_dom AS domiciliario_telefono
FROM cliente c
LEFT JOIN pedido p ON c.ID_cli = p.ID_cli
LEFT JOIN responsable r ON p.cedula_res = r.cedula_res
LEFT JOIN tel_responsable t ON r.cedula_res = t.cedula_res
LEFT JOIN domiciliario d ON p.cedula_dom = d.cedula_dom
LEFT JOIN tel_domiciliario td ON d.cedula_dom = td.cedula_dom;

CREATE VIEW vista_cli_cesta AS
SELECT c.cedula_cli, c.primer_nombre, pr.nombre_prod, ce.cantidad
FROM cliente c
LEFT JOIN pedido p ON c.ID_cli = p.ID_cli
LEFT JOIN cesta ce ON p.codigo_pedido = ce.codigo_pedido
LEFT JOIN producto pr ON ce.ID_producto = pr.ID_producto;

CREATE VIEW vista_pedidos AS
SELECT p.codigo_pedido, c.primer_nombre AS nombre_cliente, 
c.direccion_cli AS direccion_cliente, c.ID_zona AS zona_cliente, 
d.primer_nombre AS nombre_domiciliario, d.ID_zona AS zona_domiciliario
FROM pedido p
INNER JOIN cliente c ON p.ID_cli = c.ID_cli
INNER JOIN domiciliario d ON p.cedula_dom = d.cedula_dom;

CREATE VIEW vista_cliente_valor_total AS
SELECT c.primer_nombre AS cliente_nombre, 
SUM(p.valor_venta * cesta.cantidad) AS valor_total
FROM cliente c
INNER JOIN pedido pe ON c.ID_cli = pe.ID_cli
INNER JOIN cesta ON pe.codigo_pedido = cesta.codigo_pedido
INNER JOIN producto p ON cesta.ID_producto = p.ID_producto
GROUP BY c.ID_cli;