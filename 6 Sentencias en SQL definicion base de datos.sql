SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `TiendaPepe` DEFAULT CHARACTER SET utf8 ;
USE `TiendaPepe` ;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Responsable` (
  `cedula_res` VARCHAR(50) NOT NULL,
  `primer_nombre` VARCHAR(50) NOT NULL,
  `primer_apellido` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cedula_res`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Tel_responsable` (
  `cedula_res` VARCHAR(50) NOT NULL,
  `telefono_res` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cedula_res`),
  CONSTRAINT `Tel_responsable_Responsable`
    FOREIGN KEY (`cedula_res`)
    REFERENCES `TiendaPepe`.`Responsable`(`cedula_res`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Domiciliario` (
  `cedula_dom` VARCHAR(50) NOT NULL,
  `primer_nombre` VARCHAR(50) NOT NULL,
  `primer_apellido` VARCHAR(50) NOT NULL,
  `ID_zona` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cedula_dom`),
  CONSTRAINT `Domiciliario_Zona`
    FOREIGN KEY (`ID_zona`)
    REFERENCES `TiendaPepe`.`Zona`(`ID_zona`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Tel_domiciliario` (
  `cedula_dom` VARCHAR(50) NOT NULL,
  `telefono_dom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cedula_dom`),
  CONSTRAINT `Telefono_dom_Domiciliario`
    FOREIGN KEY (`cedula_dom`)
    REFERENCES `TiendaPepe`.`Domiciliario`(`cedula_dom`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Furgoneta` (
  `matricula_fur` VARCHAR(50) NOT NULL,
  `estado_fur` VARCHAR(50) NOT NULL,
  `cedula_dom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`matricula_fur`),
  CONSTRAINT `Furgoneta_Domiciliario`
    FOREIGN KEY (`cedula_dom`)
    REFERENCES `TiendaPepe`.`Domiciliario`(`cedula_dom`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Cliente` (
  `ID_cli` VARCHAR(50) NOT NULL,
  `cedula_cli` VARCHAR(50) NOT NULL,
  `primer_nombre` VARCHAR(50) NOT NULL,
  `primer_apellido` VARCHAR(50) NOT NULL,
  `direccion_cli` VARCHAR(50) NOT NULL,
  `email_cli` VARCHAR(50) NOT NULL,
  `contraseña_cli` VARCHAR(50) NOT NULL,
  `ID_zona` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_cli`),
  CONSTRAINT `Cliente_Zona`
    FOREIGN KEY (`ID_zona`)
    REFERENCES `TiendaPepe`.`Zona`(`ID_zona`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Zona` (
  `ID_zona` VARCHAR(50) NOT NULL,
  `codigo_postal` VARCHAR(50) NOT NULL,
  `localidad_zona` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_zona`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Factura` (
  `ID_factura` VARCHAR(45) NOT NULL,
  `total` VARCHAR(45) NOT NULL,
  `codigo_pedido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_factura`),
  FOREIGN KEY (`codigo_pedido`) 
  REFERENCES `TiendaPepe`.`Pedido`(`codigo_pedido`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Pedido` (
  `codigo_pedido` VARCHAR(45) NOT NULL,
  `fecha_pedido` VARCHAR(45) NOT NULL,
  `total_importe` VARCHAR(45) NOT NULL,
  `numero_tarjeta_pago` VARCHAR(16) NOT NULL,
  `fecha_caducidad_tarjeta` VARCHAR(16) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cedula_res` VARCHAR(45) NOT NULL,
  `cedula_dom` VARCHAR(45) NOT NULL,
  `ID_cli` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  CONSTRAINT `Pedido_Domiciliario1`
    FOREIGN KEY (`cedula_dom`)
    REFERENCES `TiendaPepe`.`Domiciliario` (`cedula_dom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Pedido_Responsable1`
    FOREIGN KEY (`cedula_res`)
    REFERENCES `TiendaPepe`.`Responsable` (`cedula_res`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `Cliente_Pedido_Cliente1`
    FOREIGN KEY (`ID_cli`)
    REFERENCES `TiendaPepe`.`Cliente` (`ID_cli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Cesta` (
  `ID_cesta` VARCHAR(45) NOT NULL,
  `ID_producto` VARCHAR(45) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  `codigo_pedido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_cesta`),
  CONSTRAINT `Cesta_Producto1`
    FOREIGN KEY (`ID_producto`)
    REFERENCES `TiendaPepe`.`Producto` (`ID_producto`),
  CONSTRAINT `Cesta_Pedido1`
    FOREIGN KEY (`codigo_pedido`)
    REFERENCES `TiendaPepe`.`Pedido` (`codigo_pedido`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Categoria` (
  `ID_categoria` VARCHAR(45) NOT NULL,
  `nombre_cat` VARCHAR(45) NOT NULL,
  `almacenamiento` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_categoria`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Producto` (
  `ID_producto` VARCHAR(45) NOT NULL,
  `nombre_prod` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `origen` VARCHAR(45) NOT NULL,
  `fotografia` VARCHAR(45) NOT NULL,
  `unidades_disponibles` VARCHAR(45) NOT NULL,
  `volumen` VARCHAR(45) NOT NULL,
  `peso` VARCHAR(45) NOT NULL,
  `valor_compra` VARCHAR(45) NOT NULL,
  `valor_venta` VARCHAR(45) NOT NULL,
  `ID_categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_producto`),
  FOREIGN KEY (`ID_categoria`) 
  REFERENCES `TiendaPepe`.`Categoria`(`ID_categoria`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Producto_Proveedor` (
  `ID_producto_ID_proveedor` VARCHAR(45) NOT NULL,
  `ID_producto` VARCHAR(45) NOT NULL,
  `ID_proveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_producto_ID_proveedor`,`ID_producto`,`ID_proveedor`),
  FOREIGN KEY (`ID_producto`) 
  REFERENCES `TiendaPepe`.`Producto`(`ID_producto`),
  FOREIGN KEY (`ID_proveedor`) 
  REFERENCES `TiendaPepe`.`Proveedor`(`ID_proveedor`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Proveedor` (
  `ID_proveedor` VARCHAR(45) NOT NULL,
  `nombre_prov` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_proveedor`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TiendaPepe`.`Tel_proveedor` (
  `ID_proveedor` VARCHAR(45) NOT NULL,
  `telefono_prov` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_proveedor`),
  FOREIGN KEY (`ID_proveedor`) 
  REFERENCES `TiendaPepe`.`Proveedor`(`ID_proveedor`)
) ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;