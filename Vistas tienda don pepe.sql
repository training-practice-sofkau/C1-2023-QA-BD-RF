-- Vista Numero de pedidos por cada cliente
create view NumeroDePedidosCliente as
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, COUNT(Pedido.CodigoPedido) as NumeroPedidos
FROM Cliente
LEFT JOIN Pedido ON Cliente.CedulaCliente = Pedido.CedulaCliente
GROUP BY Cliente.CedulaCliente, Cliente.NombreCliente;
select * from NumeroDePedidosCliente;

-- Obtener la informacion del cliente, su pedido y el domiciliario que se le asigno la entrega
create view detallesPedido as
SELECT Cliente.CedulaCliente, Cliente.NombreCliente, Pedido.CodigoPedido, Domiciliario.NombreDomiciliario
FROM Cliente
JOIN Pedido ON Cliente.CedulaCliente = Pedido.CedulaCliente
JOIN Domiciliario ON Pedido.idDomiciliario = Domiciliario.idDomiciliario;
select * from detallesPedido;

-- Domiciliarios en la zona
create view DomiciliariosenZona as
SELECT Zona.IdZona, Zona.codigoPostal, COUNT(Domiciliario.idDomiciliario) as NumeroDomiciliarios
FROM Zona
LEFT JOIN Domiciliario ON Zona.IdZona = Domiciliario.idZona
GROUP BY Zona.IdZona, Zona.codigoPostal;
select * from DomiciliariosenZona;

-- Clientes en la zona
create view ClientesenZona as 
SELECT Zona.IdZona, Zona.codigoPostal, COUNT(cliente.CedulaCliente) as NumeroClientes
FROM Zona
LEFT JOIN cliente ON Zona.IdZona = cliente.idZona
GROUP BY Zona.IdZona, Zona.codigoPostal;
select * from ClientesenZona;



