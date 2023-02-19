use barber;
DELIMITER //
CREATE PROCEDURE insertar_cliente(IN id INT, IN nombre varchar(50), IN cedula varchar(20), IN profesion varchar(50), IN correo varchar(50), 
IN edad int, IN direccion varchar(50)
)
BEGIN
    INSERT INTO cliente (id_cliente,nombre_cliente, cedula_cliente, profesion, correo, edad, direccion) 
    VALUES (id, nombre, cedula, profesion, correo, edad, direccion);
END;

call insertar_cliente('58','YEISON', '1010110', 'INGENIERO', 'YEISON@GMAIL.COM', 12, 'INJNCD');


DELIMITER //
CREATE PROCEDURE leer_cliente(
    IN id int
)
BEGIN
    SELECT * FROM cliente WHERE id_cliente = id;
END;



DELIMITER //
CREATE PROCEDURE borrar_cliente(
    IN id int
)
BEGIN
    DELETE FROM cliente WHERE id_cliente = id;
END //
DELIMITER ;

call borrar_cliente(58);



DELIMITER //
CREATE PROCEDURE actualizar_cliente(
    IN id int,
    IN nombre varchar(50),
    IN cedula varchar(20),
    IN profesion varchar(50),
    IN correo varchar(50),
    IN edad int,
    IN direccion varchar(50)
)
BEGIN
    UPDATE cliente SET
        nombre_cliente = nombre,
        cedula_cliente = cedula,
        profesion = profesion,
        correo = correo,
        edad = edad,
        direccion = direccion
    WHERE id_cliente = id;
END; //

call actualizar_cliente(70, 'YEISON FERNEY', 'OSORIO BUITRAGO', 'QA', 'JEISON@GMAIL.COM', 10, 'CALLE VIRIGLIO');






