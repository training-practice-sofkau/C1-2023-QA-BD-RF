CREATE DATABASE barberia CHARACTER set utf8 collate utf8_spanish_ci;
use barberia;
CREATE TABLE IF NOT EXISTS `tb_provedor` (
  `id_provedor` INT NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_provedor`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `tb_productos` (
  `id_referencia` INT NOT NULL,
  `nombre_producto` VARCHAR(100) NULL,
  `precio` VARCHAR(45) NULL,
  `id_provedor_tabla` INT NOT NULL,
  PRIMARY KEY (`id_referencia`),
  INDEX `id_provedor_productos` (`id_provedor_tabla` ASC) VISIBLE,
  CONSTRAINT `FKidproducto` FOREIGN KEY (`id_provedor_tabla`) REFERENCES `tb_provedor` (`id_provedor`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `tb_factura` (
  `id_factura` INT NOT NULL,
  `valor` VARCHAR(45) NULL,
  `fecha` VARCHAR(45) NULL,
  PRIMARY KEY (`id_factura`)
) ENGINE=InnoDB;

CREATE TABLE dll_producto_factura(
  `id_producto_factura` INT NOT NULL,
  `id_producto_tabla` INT NOT NULL,
  `id_factura_tabla` INT NOT NULL,
  PRIMARY KEY (`id_producto_factura`, `id_producto_tabla`, `id_factura_tabla`),
  CONSTRAINT `id_producto_tabla`FOREIGN KEY (`id_producto_tabla`) 
  REFERENCES `barberia`.`tb_productos` (`id_referencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_factura_tabla` FOREIGN KEY (`id_factura_tabla`)
    REFERENCES `barberia`.`tb_factura` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS `tb_empleado` (
  `id_empleado` INT NOT NULL,
  `c.c` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `nombre_especialidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB;

    
 CREATE TABLE dll_empleado_factura(
  `id_empleado_factura` INT NOT NULL,
  `id_empleado_tab` INT NOT NULL,
  `id_factura_tab` INT NOT NULL,
  PRIMARY KEY (`id_empleado_factura`, `id_empleado_tab`, `id_factura_tab`),
  CONSTRAINT `id_empleado_tab`FOREIGN KEY (`id_empleado_tab`) 
  REFERENCES `barberia`.`tb_empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_factura_tab` FOREIGN KEY (`id_factura_tab`)
    REFERENCES `barberia`.`tb_factura` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION);   
    
    CREATE TABLE IF NOT EXISTS `tb_historial_servicio` (
  `id_historial_servicio` INT NOT NULL,
  `fecha` VARCHAR(20) NULL,
  `insumo` VARCHAR(45) NULL,
  `duracion_servicio` VARCHAR(45) NULL,
  `id_empleado_tabl` INT NOT NULL,
  PRIMARY KEY (`id_historial_servicio`),
  INDEX `id_empleado_tabl_historial_servicio` (`id_empleado_tabl` ASC) VISIBLE,
  CONSTRAINT `FKid_historial_servic` FOREIGN KEY (`id_empleado_tabl`) REFERENCES 
  `tb_empleado` (`id_empleado`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `id_cliente` INT NOT NULL,
  `c.c` VARCHAR(20) NULL,
  `nombre` VARCHAR(100) NULL,
  `edad` VARCHAR(10) NULL,
  `telefono` VARCHAR(20) NULL,
  `direccion` VARCHAR(45) NULL,
  `correo` VARCHAR(70) NULL,
  `profesion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB;

CREATE TABLE dll_producto_cliente(
  `id_producto_cliente` INT NOT NULL,
  `id_producto_tablaa` INT NOT NULL,
  `id_cliente_tablaa` INT NOT NULL,
  PRIMARY KEY (`id_producto_cliente`, `id_producto_tablaa`, `id_cliente_tablaa`),
  CONSTRAINT `id_producto_tablaa`FOREIGN KEY (`id_producto_tablaa`) 
  REFERENCES `barberia`.`tb_productos` (`id_referencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_cliente_tablaa` FOREIGN KEY (`id_cliente_tablaa`)
    REFERENCES `barberia`.`tb_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION);   
   
   
   CREATE TABLE IF NOT EXISTS `tb_reserva` (
  `id_reserva` INT NOT NULL,
  `descripcion` VARCHAR(200) NULL,
  `fecha` VARCHAR(40) NULL,
  `id_cliente_reserva` INT NOT NULL,
  PRIMARY KEY (`id_reserva`),
  INDEX `id_cliente_reserva` (`id_cliente_reserva` ASC) VISIBLE,
  CONSTRAINT `FKid_cliente` FOREIGN KEY (`id_cliente_reserva`) REFERENCES `tb_cliente` (`id_cliente`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `tb_insumo` (
  `id_insumo` INT NOT NULL,
  `nombre_insumo` VARCHAR(100) NULL,
  PRIMARY KEY (`id_insumo`)
) ENGINE=InnoDB;
   
   CREATE TABLE tb_cita(
  `id_cita` INT NOT NULL,
  `fecha` VARCHAR(20) NULL,
  `hora` VARCHAR(10) NULL,
  `id_historial_servicio_cliente` INT NOT NULL,
  `id_reserva_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cita`, `id_historial_servicio_cliente`, `id_reserva_cliente`),
  CONSTRAINT `id_historial_servicio_cliente`FOREIGN KEY (`id_historial_servicio_cliente`) 
  REFERENCES `barberia`.`tb_historial_servicio` (`id_historial_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_reserva_cliente` FOREIGN KEY (`id_reserva_cliente`)
    REFERENCES `barberia`.`tb_reserva` (`id_reserva`) ON DELETE NO ACTION ON UPDATE NO ACTION);   


CREATE TABLE IF NOT EXISTS `tb_servicio` (
  `id_servicio` INT NOT NULL,
  `nombre_procedimiento` VARCHAR(100) NULL,
  `id_cita_servicio` INT NOT NULL,
  PRIMARY KEY (`id_servicio`),
  INDEX `id_cita_servicio` (`id_cita_servicio` ASC) VISIBLE,
  CONSTRAINT `FKid_cita_servicio` FOREIGN KEY (`id_cita_servicio`) REFERENCES 
  `tb_cita` (`id_cita`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE dll_empleado_servicio(
  `id_empleado_servicio` INT NOT NULL,
  `id_empleado_tabla2` INT NOT NULL,
  `id_servicio_tabla2` INT NOT NULL,
  PRIMARY KEY (`id_empleado_servicio`, `id_empleado_tabla2`, `id_servicio_tabla2`),
  CONSTRAINT `id_empleado_tabla2`FOREIGN KEY (`id_empleado_tabla2`) 
  REFERENCES `barberia`.`tb_empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_servicio_tabla2` FOREIGN KEY (`id_servicio_tabla2`)
    REFERENCES `barberia`.`tb_servicio` (`id_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION);   
   
 CREATE TABLE dll_insumo_servicio(
  `id_insumo_servicio` INT NOT NULL,
  `id_insumo_serv_tab` INT NOT NULL,
  `id_servicio_insu_tab` INT NOT NULL,
  PRIMARY KEY (`id_insumo_servicio`, `id_insumo_serv_tab`, `id_servicio_insu_tab`),
  CONSTRAINT `id_insumo_serv_tab`FOREIGN KEY (`id_insumo_serv_tab`) 
  REFERENCES `barberia`.`tb_insumo` (`id_insumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_servicio_insu_tab` FOREIGN KEY (`id_servicio_insu_tab`)
    REFERENCES `barberia`.`tb_servicio` (`id_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION);   
   
 CREATE TABLE dll_factura_insumo(
  `id_factura_insumo` INT NOT NULL,
  `id_insumo_fact_tab` INT NOT NULL,
  `id_factura_ins_tab` INT NOT NULL,
  PRIMARY KEY (`id_factura_insumo`, `id_insumo_fact_tab`, `id_factura_ins_tab`),
  CONSTRAINT `id_insumo_fact_tab`FOREIGN KEY (`id_insumo_fact_tab`) 
  REFERENCES `barberia`.`tb_insumo` (`id_insumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_factura_ins_tab` FOREIGN KEY (`id_factura_ins_tab`)
    REFERENCES `barberia`.`tb_factura` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION);   
    