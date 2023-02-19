show triggers;
DROP TRIGGER infor_cliente;

DELIMITER |
CREATE TRIGGER infor_cliente BEFORE INSERT ON tb_cliente
FOR EACH ROW BEGIN 
INSERT INTO consulta_cliente(nombre_cliente,telefono) VALUE (new.nombre, new.telefono);
END |

INSERT INTO `barberia`.`tb_cliente` (`id_cliente`, `cedula`, `nombre`, `edad`, `telefono`, 
`direccion`, `correo`, `profesion`) VALUES (109,'10930043','Domitila Alvarez','47', 
'10000364','Cs C # 1297-35','tilale@hlo','Economista');

INSERT INTO `barberia`.`tb_cliente` (`id_cliente`, `cedula`, `nombre`, `edad`, `telefono`, 
`direccion`, `correo`, `profesion`) VALUES ('108', '34555555', 'Alicia Alvarez', '70', '1099766', 
'Cs 28 #7788-9', 'Alicia@7gmail', 'Economista');

use barberia;

drop TRIGGER log_tb_cliente;
DELIMITER //
CREATE TRIGGER log_tb_cliente after INSERT ON tb_cliente
FOR EACH ROW BEGIN 
INSERT INTO control_usuario(accion) value (CONCAT('Se creó un registro en la tabla cliente con el id: '),new.id_cliente, 
', con el nombre',new.nombre);
END//
DELIMITER ;


drop TRIGGER log_tb_proveedor ;
show triggers;

DELIMITER //
CREATE TRIGGER log_tb_proveedor after INSERT ON tb_provedor
FOR EACH ROW BEGIN 
INSERT INTO control_usuario(accion) value (concat('Se creó un registro en la tabla provedor con el id: '),new.id_provedor);
END//
DELIMITER ;

INSERT INTO `barberia`.`tb_provedor` (`id_provedor`, `telefono`, `direccion`, `nombre`) VALUES 
('309', '5540055', 'Br La eugenia M r C 323', 'Sara Mendoza');