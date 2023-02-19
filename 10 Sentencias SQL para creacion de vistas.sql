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