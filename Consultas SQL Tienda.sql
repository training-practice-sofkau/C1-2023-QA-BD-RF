-- Obtener cedula y nombre del cliente acompañado de el id de la zona y el codigo postal
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, Zona.IdZona, Zona.codigoPostal
FROM Cliente
INNER JOIN Zona ON Cliente.IdZona = Zona.IdZona;
-- obtener datos del cliente junto con su numero de telefono o sus numeros de telefono
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, 
GROUP_CONCAT(Telefono_Cliente.TelefonoCliente SEPARATOR ', ') as Telefonos
FROM Cliente
INNER JOIN Telefono_Cliente ON Cliente.CedulaCliente = Telefono_Cliente.CedulaCliente
group by Cliente.CedulaCliente;
-- obtener el número de cédula de un cliente, su nombre, el nombre de los productos que compró y las unidades compradas
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, ProductoCesta.NombreProducto, ProductoCesta.UnidadesSeleccionadas
FROM Cliente
INNER JOIN CestaCompras ON Cliente.CedulaCliente = CestaCompras.CedulaCliente
INNER JOIN ProductoCesta ON CestaCompras.idCestaCompras = ProductoCesta.idCestaCompras;
-- Obtener la cedula del cliente, el nombre del cliente, el código del pedido y el nombre del domiciliario asignado
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, Pedido.CodigoPedido, Domiciliario.NombreDomiciliario
FROM Cliente
JOIN Pedido ON Cliente.CedulaCliente = Pedido.CedulaCliente
JOIN Domiciliario ON Pedido.idDomiciliario = Domiciliario.idDomiciliario;
-- Obtener una tabla con los siguientes atributos: CodigoPedido, FechaPedido, DireccionEntrega, ImporteTotal, y DatosDePago de pedido
SELECT CodigoPedido, FechaPedido, DireccionEntrega, ImporteTotal, DatosDePago
FROM Pedido;
-- Obtener todas las categorias y las condiciones de almacenamiento
select NombreCategoria, Condiciones from categoria;
-- Obtener ID de zona, codigo postal, y numero de domiciliarios en la zona
SELECT Zona.IdZona, Zona.codigoPostal, COUNT(Domiciliario.idDomiciliario) as NumeroDomiciliarios
FROM Zona
LEFT JOIN Domiciliario ON Zona.IdZona = Domiciliario.idZona
GROUP BY Zona.IdZona, Zona.codigoPostal;
-- Obtener ID de zona, codigo postal, y numero de clientes en las zonas
SELECT Zona.IdZona, Zona.codigoPostal, COUNT(cliente.CedulaCliente) as NumeroClientes
FROM Zona
LEFT JOIN cliente ON Zona.IdZona = cliente.idZona
GROUP BY Zona.IdZona, Zona.codigoPostal;
-- Obtener numero de pedidos realizados por cada cliente
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, COUNT(Pedido.CodigoPedido) as NumeroPedidos
FROM Cliente
LEFT JOIN Pedido ON Cliente.CedulaCliente = Pedido.CedulaCliente
GROUP BY Cliente.CedulaCliente, Cliente.NombreCliente;
-- Obtener numero de productos en una categoria
SELECT NombreCategoria, COUNT(*) as NumProductos
FROM Producto
GROUP BY NombreCategoria;
