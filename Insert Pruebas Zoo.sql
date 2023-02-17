USE zoodb;

INSERT INTO proveedor (nit, nombre, telefono, correo, direccion) VALUES
('123456789-0', 'Proveedor 1', '1234567890', 'proveedor1@ejemplo.com', 'Dirección proveedor 1'),
('987654321-0', 'Proveedor 2', '0987654321', 'proveedor2@ejemplo.com', 'Dirección proveedor 2');

INSERT INTO factura (id_factura, total, nit_proveedor_factura) VALUES
('FAC-001', '1500000', '123456789-0'),
('FAC-002', '2000000', '987654321-0');

INSERT INTO logistico (id_logistico, nombre, apellido, telefono) VALUES
('LOG-001', 'Logístico 1', 'Apellido 1', '1111111111'),
('LOG-002', 'Logístico 2', 'Apellido 2', '2222222222');

INSERT INTO orden_compra (id_orden, fecha_emision, fecha_entrega, descripcion, nit_proveedor_orden, id_logistico_orden) VALUES
('ORD-001', '2022-01-15', '2022-01-22', 'Orden de compra 1', '123456789-0', 'LOG-001'),
('ORD-002', '2022-02-01', '2022-02-08', 'Orden de compra 2', '987654321-0', 'LOG-002');

INSERT INTO alimento (id_alimento, nombre_alimento, tipo_alimento, cantidad) VALUES
('ALI-001', 'Alimento 1', 'Tipo 1', '1000 gr'),
('ALI-002', 'Alimento 2', 'Tipo 2', '500 gr');

INSERT INTO proveedor_alimento (id_proveedor_alimento, id_alimento_proveedor) VALUES
('123456789-0', 'ALI-001'),
('987654321-0', 'ALI-002');

INSERT INTO dieta (id_dieta, tipo_alimento, dosis) VALUES
('DIE-001', 'Tipo 1', '50 gr'),
('DIE-002', 'Tipo 2', '30 gr');

INSERT INTO animal (id_animal, nombre, clase, especie, fecha_nacimiento, id_dieta_animal) VALUES
('ANI-001', 'Animal 1', 'Clase 1', 'Especie 1', '2021-01-01', 'DIE-001'),
('ANI-002', 'Animal 2', 'Clase 2', 'Especie 2', '2021-02-01', 'DIE-002');

INSERT INTO alimento_animal (id_alimento_animal, id_animal_alimento) VALUES
('ALI-001', 'ANI-001'),
('ALI-002', 'ANI-002');

INSERT INTO entrenador (id_entrenador, nombre, apellido, telefono) VALUES
('ENT-001', 'Entrenador 1', 'Apellido 1', '1111111111'),
('ENT-002', 'Entrenador 2', 'Apellido 2', '2222222222');

INSERT INTO informe_animal (id_informe, fecha_peso, peso_registrado, detalles, id_animal_informe, id_entrenador_informe)
VALUES ('INF001', '2022-11-01', '150 kg', 'buen estado de salud y comportamiento', 'ANI-001', 'ENT-001');

INSERT INTO informe_animal (id_informe, fecha_peso, peso_registrado, detalles, id_animal_informe, id_entrenador_informe)
VALUES ('INF002', '2023-01-15', '160 kg', 'aumento de peso moderado y buen apetito', 'ANI-002', 'ENT-002');

INSERT INTO veterinario (id_veterinario, nombre, apellido, telefono)
VALUES ('VET001', 'Maria', 'Garcia', '555-1234');

INSERT INTO veterinario (id_veterinario, nombre, apellido, telefono)
VALUES ('VET002', 'Carlos', 'Perez', '555-5678');

INSERT INTO veterinario_informe (id_veterinario_informe, id_informe_veterinario)
VALUES ('VET001', 'INF001');

INSERT INTO veterinario_informe (id_veterinario_informe, id_informe_veterinario)
VALUES ('VET002', 'INF002');

INSERT INTO veterinario_dieta (id_veterinario_dieta, id_dieta_veterinario)
VALUES ('VET001', 'DIE-001');

INSERT INTO veterinario_dieta (id_veterinario_dieta, id_dieta_veterinario)
VALUES ('VET002', 'DIE-002');