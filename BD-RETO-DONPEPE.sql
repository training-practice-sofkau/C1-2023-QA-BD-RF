CREATE SCHEMA IF NOT EXISTS `DonPepe` DEFAULT CHARACTER SET utf8 ;
USE `DonPepe` ;

/*TABLA ZONA*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Zona` (
  `codigo_postal` INT auto_increment NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `barrio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_postal`))

/*TABLA CLIENTE*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Cliente` (
  `ID` INT auto_increment NOT NULL,
  `cedula` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `codigo_postal` INT NOT NULL,
  PRIMARY KEY (`ID`), 
    FOREIGN KEY (`codigo_postal`)
    REFERENCES `Zona` (`codigo_postal`)
    );

/*TABLA DOMICILIARIO*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Domiciliario` (
  `ID` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `matricula_furgoneta` VARCHAR(45) NOT NULL,
  `codigo_postal` INT NOT NULL,
  PRIMARY KEY (`ID`),
    FOREIGN KEY (`codigo_postal`)
    REFERENCES `DonPepe`.`Zona` (`codigo_postal`)
   );


/*TABLA PEDIDO*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Pedido` (
  `ID` INT AUTO_INCREMENT NOT NULL,
  `fecha_caducidad` VARCHAR(45) NOT NULL,
  `numero_tarjeta` VARCHAR(45) NOT NULL,
  `fecha_pedido` VARCHAR(45) NOT NULL,
  `direccion_entrega` VARCHAR(45) NOT NULL,
  `importe_total_pedido` VARCHAR(45) NOT NULL,
  `ID_cliente` INT NOT NULL,
  `ID_domiciliario` INT NOT NULL,
  PRIMARY KEY (`ID`),  
    FOREIGN KEY (`ID_cliente`)
    REFERENCES `DonPepe`.`Cliente` (`ID`),  
    FOREIGN KEY (`ID_domiciliario`)
    REFERENCES `DonPepe`.`Domiciliario` (`ID`));
   
/*TABLA PROVEEDOR*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Proveedor` (
  `NIT` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NIT`));

/*TABLA CATEGORIA*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Categoria` (
  `ID` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  `condiciones_almacenamiento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));

/*TABLA PRODUCTO*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Producto` (
  `ID` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `origen` VARCHAR(45) NOT NULL,
  `volumen` VARCHAR(45) NOT NULL,
  `precio` double NOT NULL,
  `peso` VARCHAR(45) NOT NULL,
  `foto` VARCHAR(45) NOT NULL,
  `ID_proveedor` VARCHAR(10)  NOT NULL,
  `ID_categoria` INT  NOT NULL,
  PRIMARY KEY (`ID`),   
    FOREIGN KEY (`ID_proveedor`)
    REFERENCES `DonPepe`.`Proveedor` (`NIT`),  
    FOREIGN KEY (`ID_categoria`)
    REFERENCES `DonPepe`.`Categoria` (`ID`)
    );

/*TABLA DETALLE_PEDIDO*/
CREATE TABLE IF NOT EXISTS `DonPepe`.`Detalle_pedido` (
  `ID_producto` INT  NOT NULL,
  `ID_pedido`INT NOT NULL,
  PRIMARY KEY (`ID_producto`, `ID_pedido`),  
    FOREIGN KEY (`ID_producto`)
    REFERENCES `DonPepe`.`Producto` (`ID`),  
    FOREIGN KEY (`ID_pedido`)
    REFERENCES `DonPepe`.`Pedido` (`ID`)
    )




