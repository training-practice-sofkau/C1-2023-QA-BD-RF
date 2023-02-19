USE zoodb;


SELECT * FROM Proveedor;
SELECT * FROM factura;
SELECT * FROM logistico;
SELECT * FROM entrenador;
SELECT * FROM orden_compra;
SELECT * FROM alimento;
SELECT * FROM proveedor_alimento;
SELECT * FROM dieta;
SELECT * FROM animal;
SELECT * FROM alimento_animal;
SELECT * FROM informe_animal;
SELECT * FROM veterinario;
SELECT * FROM veterinario_informe;
SELECT * FROM veterinario_dieta;

DELETE FROM veterinario_dieta;
DELETE FROM veterinario_informe;
DELETE FROM veterinario;
DELETE FROM informe_animal;
DELETE FROM alimento_animal;
DELETE FROM animal;
DELETE FROM dieta;
DELETE FROM proveedor_alimento;
DELETE FROM alimento;
DELETE FROM orden_compra;
DELETE FROM entrenador;
DELETE FROM logistico;
DELETE FROM factura;
DELETE FROM Proveedor