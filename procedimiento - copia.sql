use barberia;
DELIMITER //
CREATE PROCEDURE consulta_cliente(in id_client INT)
BEGIN
    Select * from tb_cliente where id_cliente = id_client;
END//
DELIMITER ;

UPDATE `barberia`.`tb_cliente` SET `c.c` = '109354334', `nombre` = 'Liusita Morale', 
`edad` = '455', `telefono` = '3447557565', `direccion` = 'Cll 2 bis5 # 152-35', `correo` = 
'ospi_858@hotlmail.co', `profesion` = 'L.5Q' WHERE (`id_cliente` = '103');

CALL actualizar_cliente(101);

DELIMITER //
CREATE PROCEDURE actualizar_cliente(in id_client INT)
BEGIN
    UPDATE tb_cliente SET id_cliente = id_client;
END//
DELIMITER ;


#Procedimiento para actualizar informacion de una base de datos
DELIMITER //

CREATE PROCEDURE insertar_registro()
BEGIN
  INSERT INTO barberia.tb_cliente (id_cliente, cedula, nombre,edad,
                                   telefono,direccion,correo,profesion)
  VALUES (105,'1093244','Emilia Maria Ospina',
          '3447676', '18','Clle 28b # 78-21', 'naoz@gmail.com',
            'Abogada');
END //

DELIMITER ;

CALL insertar_registro;

SELECT * FROM barberia.tb_provedor;
#eliminar un registro 


DELIMITER //

CREATE PROCEDURE eliminar_datos(IN id INT)
BEGIN
  DELETE FROM tb_provedor WHERE id_provedor = id;
END //

DELIMITER ;
CALL eliminar_datos(304);












CREATE PROCEDURE actualizar
@id_provedor INT,
@telefono varchar(45),
@direccion varchar(45),
@nombre varchar(100)
AS
BEGIN
UPDATE tb_cliente

     telefono=@telefono,
     direccion=@direccion,
	 nombre=@nombre,
     WHERE id_cliente=@id_cliente
     end

CREATE PROCEDURE insertar
@id_provedor int,
@telefono varchar(45),
@direccion varchar(45),
@nombre varchar(100)
as
begin
insert into tb_provedor (id_provedor,telefono,direccion,nombre) 
values(@id_provedor,@telefono,@direccion,@nombre)
end


delimiter //
create procedure actualizar(in id_provedor1 int,in  telefononuev varchar(45),
 in direcnuev varchar(45), in
nombrenuev varchar(100))
begin
update tb_provedor
set telefono=telefononuev_nue, direccion = direcnuev, nombre=nombrenuev
where id_provedor=provedor1;
end
//
delimiter ;
CALL actualizar(303, "6666666","sin direccion","Juan Gabriel");






call modificar_cita("3004","01/02/94","13:30");
select * from cita;
