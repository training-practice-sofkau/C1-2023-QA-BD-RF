
SELECT nombre,telefono, correo FROM tb_cliente;

Select * from tb_cliente ORDER BY nombre ASC;

#Busque de informacion de una tabla producto en este caso empezando por Al
SELECT * FROM tb_productos where nombre_producto LIKE 'Al%';


select r.descripcion,r.fecha, c.nombre, c.telefono
from tb_reserva as r INNER JOIN 
tb_cliente as  c on r.id_cliente_reserva=c.id_cliente;

SELECT nombre , nombre_especialidad FROM tb_empleado;

SELECT nombre_insumo FROM tb_insumo;
#7
SELECT fecha, descripcion FROM tb_reserva;
#8
SELECT * FROM tb_cita where hora BETWEEN 15 AND 18;
#9

SELECT * FROM tb_productos where id_provedor_tabla=301;

SELECT * FROM tb_empleado where nombre LIKE 'je%';

use barberia;

#Consultar informacion de dos tablas pero para que no se repita la informacion
#comparamos los dos id
SELECT * FROM tb_cliente where id_cliente =id;
SELECT c.nombre, c.telefono, c.correo FROM tb_cliente AS c
INNER JOIN  tb_cliente AS c on c.id_cliente=id_cliente WHERE c.id_cliente =100;

SELECT c.nombre, c.telefono, c.direccion, c.correo FROM tb_cliente AS c
INNER JOIN  tb_cliente AS c on p.idCategoria=idCategoria=c.id WHERE p.idCategoria =2;







SELECT nombre,telefono, correo FROM tb_cliente;


