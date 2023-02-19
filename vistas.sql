use barberia;
#Vista informacion del procedimiento y c liente
CREATE VIEW info_procedim_al_cliente as
select r.descripcion,r.fecha, c.nombre, c.telefono
from tb_reserva as r INNER JOIN 
tb_cliente as  c on r.id_cliente_reserva=c.id_cliente;

#Vista buena
CREATE VIEW servicio_cliente AS SELECT tb_servicio.id_servicio, tb_servicio.nombre_procedimiento,
tb_cita.fecha, tb_cliente.nombre,tb_cliente.telefono
FROM tb_servicio
inner JOIN tb_cita On tb_servicio.id_cita_servicio =tb_cita.id_cita
inner join tb_cliente on tb_cita.id_reserva_cliente;

#Vista SELECT * FROM filtar_cliente_por_hora;

CREATE VIEW filtar_cliente_por_hora as
SELECT * FROM tb_cita where hora BETWEEN 15 AND 18;
SELECT * FROM filtar_cliente_por_hora;



CREATE VIEw gastos_insumos AS
SELECT tb_cliente.nombre AS Cliente, tb_cita.fecha, tb_cita.hora, tb_servicio.nombre_procedimiento
from tb_cliente
inner join tb_cita on tb_cita.reserva_cliente = tb_cita.reserva_cliente
inner join tb_servicio on cita.id_cita = tb_servicio.id_servicio



#crear visita
create view informacionLibro as SELECT libreriabuscalibre.cliente.nombre, 
libreriabuscalibre.telefono_cliente.numero
FROM libreriabuscalibre.cliente
JOIN libreriabuscalibre.telefono_cliente
ON libreriabuscalibre.cliente.cedula = libreriabuscalibre.telefono_cliente.cedula_cliente;

CREATE VIEW informacion_reserva as select barberia.tb_reserva.descripcion,
barberia.tb_reserva.fecha
from barberia.cliente JOIN  barberia.tb_cliente on 
barberia.id_cliente =barberia.id_cliente_reserva;







SELECT * FROM info_procedim_al_cliente;


create view informacioncliente as SELECT libreriabuscalibre.cliente.nombre, 
libreriabuscalibre.telefono_cliente.numero
FROM libreriabuscalibre.cliente
JOIN libreriabuscalibre.telefono_cliente
ON libreriabuscalibre.cliente.cedula = libreriabuscalibre.telefono_cliente.cedula_cliente;
