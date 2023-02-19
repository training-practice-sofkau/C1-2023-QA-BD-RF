-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zoologico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zoologico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zoologico` DEFAULT CHARACTER SET utf8 ;
USE `zoologico` ;

-- -----------------------------------------------------
-- Table `zoologico`.`Dieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Dieta` (
  `idDieta` VARCHAR(10) NOT NULL,
  `nombreDieta` VARCHAR(45) NOT NULL,
  `dosisDieta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDieta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Animal` (
  `idAnimal` VARCHAR(10) NOT NULL,
  `nombreAnimal` VARCHAR(45) NOT NULL,
  `especie_id` VARCHAR(10) NOT NULL,
  `dieta_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idAnimal`),
   INDEX `especie_id_idx` (`especie_id` ASC) VISIBLE,
  CONSTRAINT `especie_id`
    FOREIGN KEY (`especie_id`)
    REFERENCES `zoologico`.`especie` (`idEspecie`),
  INDEX `dieta_id_idx` (`dieta_id` ASC) VISIBLE,
  CONSTRAINT `dieta_id`
    FOREIGN KEY (`dieta_id`)
    REFERENCES `zoologico`.`Dieta` (`idDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Table `zoologico`.`Entrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`especie` (
  `idEspecie` VARCHAR(10) NOT NULL,
  `nombreEspecie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEspecie`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `zoologico`.`Entrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Entrenador` (
  `idEntrenador` VARCHAR(10) NOT NULL,
  `nombreEntrenador` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEntrenador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`telefonoEntrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`telefonoEntrenador` (
  `idtelefonoEntrenador` VARCHAR(10) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idtelefonoEntrenador`, `numero`),
  CONSTRAINT `idtelefonoEntrenador`
    FOREIGN KEY (`idtelefonoEntrenador`)
    REFERENCES `zoologico`.`Entrenador` (`idEntrenador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Veterinario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Veterinario` (
  `idVeterinario` VARCHAR(10) NOT NULL,
  `nombreVeterinario` VARCHAR(45) NULL,
  PRIMARY KEY (`idVeterinario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`telefonoVeterinario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`telefonoVeterinario` (
  `idtelefonoVeterinario` VARCHAR(10) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idtelefonoVeterinario`, `numero`),
  CONSTRAINT `idtelefonoVeterinario`
    FOREIGN KEY (`idtelefonoVeterinario`)
    REFERENCES `zoologico`.`Veterinario` (`idVeterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`VeterinarioDieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`VeterinarioDieta` (
  `idVeterinarioDieta` VARCHAR(10) NOT NULL,
  `dietaVeterinarioId` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idVeterinarioDieta`, `dietaVeterinarioId`),
  INDEX `dietaVeterinarioId_idx` (`dietaVeterinarioId` ASC) VISIBLE,
  CONSTRAINT `idVeterinarioDieta`
    FOREIGN KEY (`idVeterinarioDieta`)
    REFERENCES `zoologico`.`Veterinario` (`idVeterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dietaVeterinarioId`
    FOREIGN KEY (`dietaVeterinarioId`)
    REFERENCES `zoologico`.`Dieta` (`idDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Informe_peso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Informe_peso` (
  `idInforme` VARCHAR(10) NOT NULL,
  `pesoAnimal` VARCHAR(45) NOT NULL,
  `entrenadorId` VARCHAR(45) NOT NULL,
  `veterinarioId` VARCHAR(45) NOT NULL,
  `animalId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInforme`),
  INDEX `entrenadorId_idx` (`entrenadorId` ASC) VISIBLE,
  INDEX `veterinarioId_idx` (`veterinarioId` ASC) VISIBLE,
  INDEX `animalId_idx` (`animalId` ASC) VISIBLE,
  CONSTRAINT `entrenadorId`
    FOREIGN KEY (`entrenadorId`)
    REFERENCES `zoologico`.`Entrenador` (`idEntrenador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `veterinarioId`
    FOREIGN KEY (`veterinarioId`)
    REFERENCES `zoologico`.`Veterinario` (`idVeterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `animalId`
    FOREIGN KEY (`animalId`)
    REFERENCES `zoologico`.`Animal` (`idAnimal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Alimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Alimento` (
  `nombreAlimento` VARCHAR(20) NOT NULL,
  `tipoAlimento` VARCHAR(45) NULL,
  PRIMARY KEY (`nombreAlimento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Alimento_Dieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Alimento_Dieta` (
  `dietaAlimentoId` VARCHAR(10) NOT NULL,
  `Alimento_Dieta_Nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`dietaAlimentoId`, `Alimento_Dieta_Nombre`),
  INDEX `Alimento_Dieta_Nombre_idx` (`Alimento_Dieta_Nombre` ASC) VISIBLE,
  CONSTRAINT `dietaAlimentoId`
    FOREIGN KEY (`dietaAlimentoId`)
    REFERENCES `zoologico`.`Dieta` (`idDieta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Alimento_Dieta_Nombre`
    FOREIGN KEY (`Alimento_Dieta_Nombre`)
    REFERENCES `zoologico`.`Alimento` (`nombreAlimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`EmpleadoLogistico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`EmpleadoLogistico` (
  `idEmpleadoLogistico` VARCHAR(10) NOT NULL,
  `nombreLogistico` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpleadoLogistico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`telefono_logistico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`telefono_logistico` (
  `logisticoId` VARCHAR(10) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`logisticoId`, `numero`),
  CONSTRAINT `logisticoId`
    FOREIGN KEY (`logisticoId`)
    REFERENCES `zoologico`.`EmpleadoLogistico` (`idEmpleadoLogistico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Proveedor` (
  `idproveedor` VARCHAR(10) NOT NULL,
  `nombreProveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`telefonoProveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`telefonoProveedor` (
  `proveedorId` VARCHAR(10) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`proveedorId`, `numero`),
  CONSTRAINT `proveedorId`
    FOREIGN KEY (`proveedorId`)
    REFERENCES `zoologico`.`Proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`Factura` (
  `idFactura` VARCHAR(10) NOT NULL,
  `alimento_factura` VARCHAR(10) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `proveedorIdFactura` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `proveedorIdFactura_idx` (`proveedorIdFactura` ASC) VISIBLE,
  CONSTRAINT `proveedorIdFactura`
    FOREIGN KEY (`proveedorIdFactura`)
    REFERENCES `zoologico`.`Proveedor` (`idproveedor`),
     INDEX `alimento_factura_idx` (`alimento_factura` ASC) VISIBLE,
  CONSTRAINT `alimento_factura`
    FOREIGN KEY (`alimento_factura`)
    REFERENCES `zoologico`.`alimento` (`nombreAlimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoologico`.`OrdenesCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoologico`.`OrdenesCompra` (
  `idOrdenesCompra` VARCHAR(10) NOT NULL,
  `nombreOrden` VARCHAR(45) NOT NULL,
  `fechaOrden` VARCHAR(10) NOT NULL,
  `OrdenesCompracol` VARCHAR(45) NOT NULL,
  `ordenProveedorId` VARCHAR(10) NOT NULL,
  `logisticoIdOrden` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idOrdenesCompra`),
  INDEX `ordenProveedorId_idx` (`ordenProveedorId` ASC) VISIBLE,
  INDEX `logisticoIdOrden_idx` (`logisticoIdOrden` ASC) VISIBLE,
  CONSTRAINT `ordenProveedorId`
    FOREIGN KEY (`ordenProveedorId`)
    REFERENCES `zoologico`.`Proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `logisticoIdOrden`
    FOREIGN KEY (`logisticoIdOrden`)
    REFERENCES `zoologico`.`EmpleadoLogistico` (`idEmpleadoLogistico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE zoologico.auditoria(
	usuario VARCHAR (10),
    accion VARCHAR (20),
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP); 


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
