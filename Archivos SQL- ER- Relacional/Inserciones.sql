use zoologico;
INSERT INTO zoologico.especie (idEspecie, nombreEspecie) VALUES ('ESP1', 'Mamifero');
INSERT INTO zoologico.especie (idEspecie, nombreEspecie) VALUES ('ESP2', 'Ave');
INSERT INTO zoologico.especie (idEspecie, nombreEspecie) VALUES ('ESP3', 'Reptil');

INSERT INTO zoologico.dieta (idDieta, nombreDieta, dosisDieta) VALUES ('D1', 'Dieta carnivora', '2 kilos por dia');
INSERT INTO zoologico.dieta (idDieta, nombreDieta, dosisDieta) VALUES ('D2', 'Dieta aviaria', '2 gramos por dia');
INSERT INTO zoologico.dieta (idDieta, nombreDieta, dosisDieta) VALUES ('D3', 'Dieta vegetal', '1 kilo por dia');


INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A1', 'Paloma', 'ESP2', 'D2');
INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A2', 'Leon', 'ESP1', 'D1');
INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A3', 'Tigre', 'ESP1', 'D1');
INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A4', 'Cocodrilo', 'ESP3', 'D1');
INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A5', 'Caiman', 'ESP3', 'D1');
INSERT INTO zoologico.animal (idAnimal, nombreAnimal, especie_id, dieta_id) VALUES ('A6', 'Elefante', 'ESP1', 'D3');



INSERT INTO zoologico.veterinario (idVeterinario, nombreVeterinario) VALUES ('V1', 'Juan Perez');
INSERT INTO zoologico.veterinario (idVeterinario, nombreVeterinario) VALUES ('V2', 'Juan Peña');

INSERT INTO zoologico.alimento (idAlimento,nombreAlimento, tipoAlimento) VALUES ('Al1', 'Carne de res', 'CARNES');
INSERT INTO zoologico.alimento (idAlimento,nombreAlimento, tipoAlimento) VALUES ('Al2', 'Mojarra', 'PECES');

INSERT INTO zoologico.empleadologistico (idEmpleadoLogistico, nombreLogistico) VALUES ('EM1', 'Pedro Peña');
INSERT INTO zoologico.empleadologistico (idEmpleadoLogistico, nombreLogistico) VALUES ('EM2', 'Jaime Peña');
INSERT INTO zoologico.empleadologistico (idEmpleadoLogistico, nombreLogistico) VALUES ('EM3', 'Tran Peña');

INSERT INTO zoologico.entrenador (idEntrenador, nombreEntrenador) VALUES ('EME1', 'Omar Peña');
INSERT INTO zoologico.entrenador (idEntrenador, nombreEntrenador) VALUES ('EME2', 'Luis Peña');
INSERT INTO zoologico.entrenador (idEntrenador, nombreEntrenador) VALUES ('EME3', 'Don Peña');


INSERT INTO zoologico.proveedor (idproveedor, nombreProveedor) VALUES ('PRO1', 'Karla Roña');
INSERT INTO zoologico.proveedor (idproveedor, nombreProveedor) VALUES ('PRO2', 'Ñoño Roña');
INSERT INTO zoologico.proveedor (idproveedor, nombreProveedor) VALUES ('PRO3', 'Chavo Roña');


INSERT INTO zoologico.alimento_dieta (dietaAlimentoId, alimento_Dieta_ID) VALUES ('D1', 'Al1');
INSERT INTO zoologico.alimento_dieta (dietaAlimentoId, alimento_Dieta_ID) VALUES ('D2', 'Al2');


INSERT INTO zoologico.factura (idFactura, id_alimento_factura, cantidad, precio, proveedorIdFactura) VALUES ('FA1', 'Al1', '20' ,'3000', 'PRO1');
INSERT INTO zoologico.factura (idFactura, id_alimento_factura, cantidad, precio, proveedorIdFactura) VALUES ('FA2', 'Al2', '10' ,'3000', 'PRO1');


INSERT INTO zoologico.informe_peso (idInforme, pesoAnimal, entrenadorId, veterinarioId, animalId) VALUES ('IN1', '12 Kilos', 'EME1', 'V1', 'A2');
INSERT INTO zoologico.informe_peso (idInforme, pesoAnimal, entrenadorId, veterinarioId, animalId) VALUES ('IN2', '13 Kilos', 'EME2', 'V2', 'A1');

INSERT INTO zoologico.ordenescompra (idOrdenesCompra, nombreOrden, fechaOrden, descripcion, ordenProveedorId, logisticoIdOrden) 
VALUES ('ORD1', 'Comprar carne', '2023-17-02', 'Comprar carne fresca', 'PRO1', 'EM1');

INSERT INTO zoologico.ordenescompra (idOrdenesCompra, nombreOrden, fechaOrden, descripcion, ordenProveedorId, logisticoIdOrden) 
VALUES ('ORD2', 'Comprar pescado', '2023-17-02', 'Comprar pescado fresca', 'PRO2', 'EM2');

INSERT INTO zoologico.veterinariodieta (idVeterinarioDieta, dietaVeterinarioId) VALUES ('V1', 'D1');
INSERT INTO zoologico.veterinariodieta (idVeterinarioDieta, dietaVeterinarioId) VALUES ('V2', 'D2');
