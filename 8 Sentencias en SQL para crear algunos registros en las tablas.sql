SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

USE `TiendaPepe` ;

SELECT * FROM tiendapepe.proveedor;
INSERT INTO `TiendaPepe`.`Proveedor`(`ID_proveedor`,`nombre_prov`)
VALUES
('PROV01','Soluciones logisticas de transporte'),
('PROV02','Cargolargo'),
('PROV03','Transportes la garza');

SELECT * FROM tiendapepe.tel_proveedor;
INSERT INTO `TiendaPepe`.`Tel_proveedor`(`ID_proveedor`,`telefono_prov`)
VALUES
('PROV01','3193202102'),
('PROV02','3196966956'),
('PROV03','3195858499');

SELECT * FROM tiendapepe.categoria;
INSERT INTO `TiendaPepe`.`Categoria`(`ID_categoria`,`nombre_cat`,`almacenamiento`,`observaciones`) 
VALUES
('CA01', 'carnes','Almacenamiento en congelador','Llevar tiempos de viaje y almacenamiento'),
('CA02', 'granos','Almacenaiento en lugar fresco','Acomodar periodicamente'),
('CA03', 'vegetales','Almacenaiento en lugar fresco','Revisar el estado y hacer cambio'),
('CA04', 'frutas','Almacenaiento en lugar fresco','Revisar el estado y hacer cambio'),
('CA05', 'lacteos','Almacenamiento en congelador','Llevar tiempos de viaje y almacenamiento'),
('CA06', 'Aseo y hogar','Almacenamiento al aire libre','Limpiar con trapo húmedo cada 3 días');

SELECT * FROM tiendapepe.producto;
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO01','Jabón líquido','Axion','Colombiano','fotografía1','59','42','50','13000','14500','CA06');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO02','Carne de res','Frigor','Argentina','fotografía2','23','10','500','12000','15000','CA01');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO03','Frijol rojo','Luker','Colombia','fotografía3','87','5','100','4000','6000','CA02');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO04','Leche deslactosada','Alpina','Colombia','fotografía4','48','5','1000','4000','6000','CA05');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO05','Tomate','Del huerto','Colombia','fotografía5','72','2','50','1500','2000','CA03');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO06','Manzana','La Montaña','Colombia','fotografía6','65','2','60','2500','3000','CA04');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO07','Arroz','Diana','Colombia','fotografía7','91','10','500','5000','7000','CA02');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO08','Yogurt','Alquería','Colombia','fotografía8','36','5','800','2500','3500','CA05');
INSERT INTO `TiendaPepe`.`producto` (`ID_producto`,`nombre_prod`,`marca`,`origen`,`fotografia`,`unidades_disponibles`,`volumen`,`peso`,`valor_compra`,`valor_venta`,`ID_categoria`) 
VALUES 
('PRO09','Atún en lata','Van Camps','México','fotografía9','64','5','100','4000','5000','CA02');


SELECT * FROM tiendapepe.cesta;
INSERT INTO `TiendaPepe`.`Cesta`(`ID_cesta`,`ID_producto`,`cantidad`,`codigo_pedido`) 
VALUES
('C01', 'PRO01','12','P01'),
('C02', 'PRO04','5','P01'),
('C03', 'PRO09','16','P01'),
('C04', 'PRO03','12','P01'),
('C05', 'PRO08','4','P02'),
('C06', 'PRO05','11','P03'),
('C07', 'PRO01','12','P03'),
('C08', 'PRO04','9','P03'),
('C09', 'PRO06','1','P03');

SELECT * FROM tiendapepe.domiciliario;
INSERT INTO `TiendaPepe`.`Domiciliario`(`cedula_dom`,`primer_nombre`,`primer_apellido`,`ID_zona`) 
VALUES
('896698', 'Duran','Deles','Zona1'),
('852258', 'Dario','Durango','Zona2'),
('874478', 'Demian','Dolores','Zona3');

SELECT * FROM tiendapepe.tel_domiciliario;
INSERT INTO `TiendaPepe`.`Tel_domiciliario`(`cedula_dom`,`telefono_dom`) 
VALUES
('896698', '320896698'),
('852258', '320852258'),
('874478', '320874478');

SELECT * FROM tiendapepe.cliente;
INSERT INTO `TiendaPepe`.`Cliente`(`ID_cli`,`cedula_cli`,`primer_nombre`,`primer_apellido`,`direccion_cli`,`email_cli`,`contraseña_cli`,`ID_zona`) 
VALUES
('Cli1','456654','Carlos','Cubides','Dirección1','carlos@gmail.com','carlos1234','Zona1'),
('Cli2','478874','Carla','Claron','Dirección2','carla@gmail.com','carla1234','Zona2'),
('Cli3','423324','Cintia','Camero','Dirección3','cintia@gmail.com','cintia1234','Zona3');

SELECT * FROM tiendapepe.furgoneta;
INSERT INTO `TiendaPepe`.`Furgoneta`(`matricula_fur`,`estado_fur`,`cedula_dom`) 
VALUES
('MCK-896','operativa','896698'),
('BAS-852','en mantenimiento','852258'),
('LOD-874','operativa','874478');

SELECT * FROM tiendapepe.pedido;
INSERT INTO `TiendaPepe`.`Pedido`(`codigo_pedido`,`fecha_pedido`,`total_importe`,`numero_tarjeta_pago`,`fecha_caducidad_tarjeta`,`estado`,`cedula_res`,`cedula_dom`,`ID_cli`) 
VALUES
('P01','17/02/2023','658000','123321','17/05/2024','En ruta','987789','896698','Cli1'),
('P02','17/02/2023','120000','145541','17/06/2025','En ruta','963369','852258','Cli2'),
('P03','17/02/2023','340000','159951','28/04/2025','Entregado a cliente','951159','874478','Cli3');

SELECT * FROM tiendapepe.factura;
INSERT INTO `TiendaPepe`.`Factura`(`ID_factura`,`total`,`codigo_pedido`) 
VALUES
('F01','658000','P01'),
('F02','120000','P02'),
('F03','340000','P03');

SELECT * FROM tiendapepe.responsable;
INSERT INTO `TiendaPepe`.`Responsable`(`cedula_res`, `primer_nombre`,`primer_apellido` ) 
VALUES
('987789', 'Rita','Ruales'),
('963369', 'Román','Rincón'),
('951159', 'Rina','Romelo');

SELECT * FROM tiendapepe.tel_responsable;
INSERT INTO `TiendaPepe`.`Tel_responsable`(`cedula_res`, `telefono_res`) 
VALUES
('987789', '311987789'),
('963369', '311963369'),
('951159', '311951159');

SELECT * FROM tiendapepe.producto_proveedor;
INSERT INTO `TiendaPepe`.`Producto_Proveedor`(`ID_producto_ID_proveedor`,`ID_producto`,`ID_proveedor`) 
VALUES
('PP01','PRO01','PROV02'),
('PP02','PRO02','PROV02'),
('PP03','PRO03','PROV02');

SELECT * FROM tiendapepe.zona;
INSERT INTO `TiendaPepe`.`Zona`(`ID_zona`,`codigo_postal`,`localidad_zona`) 
VALUES
('Zona1','111111','Localidad1'),
('Zona2','222222','Localidad2'),
('Zona3','333333','Localidad3');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;