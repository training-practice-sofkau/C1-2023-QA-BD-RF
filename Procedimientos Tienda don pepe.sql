-- Procedimientos
-- Crear cesta de compras
DELIMITER //
CREATE PROCEDURE insertarCestaCompras(IN p_idCestaCompras VARCHAR(10),
 IN p_fechaCreacion VARCHAR(45), IN p_cedulaCliente VARCHAR(15))
BEGIN
  INSERT INTO CestaCompras(idCestaCompras, FechaCreacion, CedulaCliente)
  VALUES (p_idCestaCompras, p_fechaCreacion, p_cedulaCliente);
END //
DELIMITER ;
CALL insertarCestaCompras('CC001', '2023-02-16', '79246');
-- LLenar cesta de compras
DELIMITER //
CREATE PROCEDURE insertarProductoCesta (IN p_NombreProducto VARCHAR(45),
    IN p_IdCestaCompras VARCHAR(10), IN p_UnidadesSeleccionadas INT
)
BEGIN
    INSERT INTO ProductoCesta (NombreProducto, idCestaCompras, UnidadesSeleccionadas)
    VALUES (p_NombreProducto, p_IdCestaCompras, p_UnidadesSeleccionadas);
END //
DELIMITER ;
call insertarProductoCesta("Fabuloso","CC001", 10);
-- realizar pedido
DELIMITER //
CREATE PROCEDURE insertarPedido (IN p_CodigoPedido VARCHAR(10), IN p_FechaPedido VARCHAR(45), IN p_DireccionEntrega VARCHAR(45), 
                                 IN p_ImporteTotal INT, IN p_DatosDePago VARCHAR(45), IN p_CedulaCliente VARCHAR(15), 
                                 IN p_idDomiciliario VARCHAR(10), IN p_idCestaCompras VARCHAR(10))
BEGIN
    INSERT INTO Pedido (CodigoPedido, FechaPedido, DireccionEntrega, ImporteTotal, DatosDePago, CedulaCliente, 
                        idDomiciliario, idCestaCompras)
    VALUES (p_CodigoPedido, p_FechaPedido, p_DireccionEntrega, p_ImporteTotal, p_DatosDePago, p_CedulaCliente, 
            p_idDomiciliario, p_idCestaCompras);
END //
DELIMITER ;
CALL InsertarPedido('P001', '2022-02-16', 'Calle 123', 100, 'Efectivo', '79246', 'dom01', 'CC001')
-- Insertar cliente
DELIMITER //
CREATE PROCEDURE insertarCliente(
    IN pCedulaCliente VARCHAR(15),
    IN pNombreCliente VARCHAR(45),
    IN pDireccion VARCHAR(45),
    IN pEmail VARCHAR(45),
    IN pPassword VARCHAR(45),
    IN pIdZona VARCHAR(10)
)
BEGIN
    INSERT INTO Cliente (CedulaCliente, NombreCliente, Direccion, Email, Password, IdZona)
    VALUES (pCedulaCliente, pNombreCliente, pDireccion, pEmail, pPassword, pIdZona);
END //
DELIMITER ;
CALL insertarCliente('123456789', 'Juan Perez', 'Calle 123', 'juanperez@gmail.com', 'password', '001');
