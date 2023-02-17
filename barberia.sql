-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: barberia
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `id_cita` varchar(20) NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `fecha` varchar(60) DEFAULT NULL,
  `id_cliente_cita` varchar(20) DEFAULT NULL,
  `id_empleado_cita` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `id_cliente_cita` (`id_cliente_cita`),
  KEY `id_empleado_cita` (`id_empleado_cita`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`id_cliente_cita`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`id_empleado_cita`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES ('3001','08:30','01/01/91','001','1001'),('3002','09:30','01/01/92','002','1002'),('3003','10:30','01/01/93','003','1003'),('3006','13:30','01/02/94','002','1002');
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita_cancelada`
--

DROP TABLE IF EXISTS `cita_cancelada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita_cancelada` (
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita_cancelada`
--

LOCK TABLES `cita_cancelada` WRITE;
/*!40000 ALTER TABLE `cita_cancelada` DISABLE KEYS */;
INSERT INTO `cita_cancelada` VALUES ('root@localhost','2023-02-17 02:05:19'),('root@localhost','2023-02-17 02:11:03');
/*!40000 ALTER TABLE `cita_cancelada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` varchar(20) NOT NULL,
  `CC` varchar(20) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `profesion` varchar(40) DEFAULT NULL,
  `correo` varchar(40) DEFAULT NULL,
  `edad` varchar(3) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('001','1115456123','Ash Ketchup','Entrenador pokemon','Ash@hotmail.com','12','Calle pueblo # paleta'),('002','1115456124','Goku Armando','Peleador de MMA','Goku@hotmail.com','27','Namekusei'),('003','1115456125','Mario Bros','Fontanero','Mario@hotmail.com','20','Reino champinion'),('004','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('10','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('11','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('12','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('13','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('14','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('15','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('16','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('17','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('18','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('19','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('20','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('21','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('22','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('23','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('24','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('25','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('26','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('27','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('28','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('29','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('30','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('31','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('32','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('33','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('34','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('35','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('36','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('37','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('38','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('39','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('40','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('41','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('42','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('43','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('44','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('45','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('46','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('47','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('48','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('49','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('5','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('50','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('51','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('52','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('53','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('54','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('6','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('7','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('8','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123'),('9','1115789456','Pablo Emilio','Jugador','@.com','37','calle falsa 123');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_producto_compra` varchar(20) NOT NULL,
  `id_cliente_compra` varchar(20) NOT NULL,
  `cantidad_producto` varchar(5) DEFAULT NULL,
  `total` varchar(10) DEFAULT NULL,
  `fecha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_producto_compra`,`id_cliente_compra`),
  KEY `id_cliente_compra` (`id_cliente_compra`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_producto_compra`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_cliente_compra`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES ('2001','001','5','250000',NULL),('2001','003','1','50000',NULL),('2002','002','2','10000',NULL),('2003','003','5','30000',NULL),('2006','5','5','10000','01/01/21'),('2007','6','5','10000','01/01/21'),('2008','7','5','10000','01/01/21'),('2009','8','5','10000','01/01/21'),('2010','9','5','10000','01/01/21'),('2011','10','5','10000','01/01/21'),('2012','11','5','10000','01/01/21'),('2013','12','5','10000','01/01/21'),('2014','13','5','10000','01/01/21'),('2015','14','5','10000','01/01/21'),('2016','15','5','10000','01/01/21'),('2017','16','5','10000','01/01/21'),('2018','17','5','10000','01/01/21'),('2019','18','5','10000','01/01/21'),('2020','19','5','10000','01/01/21'),('2021','20','5','10000','01/01/21'),('2022','21','5','10000','01/01/21'),('2023','22','5','10000','01/01/21'),('2024','23','5','10000','01/01/21'),('2025','24','5','10000','01/01/21'),('2026','25','5','10000','01/01/21'),('2027','26','5','10000','01/01/21'),('2028','27','5','10000','01/01/21'),('2029','28','5','10000','01/01/21'),('2030','29','5','10000','01/01/21'),('2031','30','5','10000','01/01/21'),('2032','31','5','10000','01/01/21'),('2033','32','5','10000','01/01/21'),('2034','33','5','10000','01/01/21'),('2035','34','5','10000','01/01/21'),('2036','35','5','10000','01/01/21'),('2037','36','5','10000','01/01/21'),('2038','37','5','10000','01/01/21'),('2039','38','5','10000','01/01/21'),('2040','39','5','10000','01/01/21'),('2041','40','5','10000','01/01/21'),('2042','41','5','10000','01/01/21'),('2043','42','5','10000','01/01/21'),('2044','43','5','10000','01/01/21'),('2045','44','5','10000','01/01/21'),('2046','45','5','10000','01/01/21'),('2047','46','5','10000','01/01/21'),('2048','47','5','10000','01/01/21'),('2049','48','5','10000','01/01/21'),('2050','49','5','10000','01/01/21'),('2051','50','5','10000','01/01/21'),('2052','51','5','10000','01/01/21'),('2053','52','5','10000','01/01/21'),('2054','53','5','10000','01/01/21'),('2055','54','5','10000','01/01/21');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacto_cliente`
--

DROP TABLE IF EXISTS `contacto_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacto_cliente` (
  `id_cliente_contacto` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente_contacto`,`telefono`),
  CONSTRAINT `contacto_cliente_ibfk_1` FOREIGN KEY (`id_cliente_contacto`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto_cliente`
--

LOCK TABLES `contacto_cliente` WRITE;
/*!40000 ALTER TABLE `contacto_cliente` DISABLE KEYS */;
INSERT INTO `contacto_cliente` VALUES ('001','315789123'),('002','315789124'),('003','315789125'),('003','315789126'),('10','315687954'),('11','315687954'),('12','315687954'),('13','315687954'),('14','315687954'),('15','315687954'),('16','315687954'),('17','315687954'),('18','315687954'),('19','315687954'),('20','315687954'),('21','315687954'),('22','315687954'),('23','315687954'),('24','315687954'),('25','315687954'),('26','315687954'),('27','315687954'),('28','315687954'),('29','315687954'),('30','315687954'),('31','315687954'),('32','315687954'),('33','315687954'),('34','315687954'),('35','315687954'),('36','315687954'),('37','315687954'),('38','315687954'),('39','315687954'),('40','315687954'),('41','315687954'),('42','315687954'),('43','315687954'),('44','315687954'),('45','315687954'),('46','315687954'),('47','315687954'),('48','315687954'),('49','315687954'),('5','315687954'),('50','315687954'),('51','315687954'),('52','315687954'),('53','315687954'),('54','315687954'),('6','315687954'),('7','315687954'),('8','315687954'),('9','315687954');
/*!40000 ALTER TABLE `contacto_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacto_proveedor`
--

DROP TABLE IF EXISTS `contacto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacto_proveedor` (
  `id_proveedor_contacto` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`id_proveedor_contacto`,`telefono`),
  CONSTRAINT `contacto_proveedor_ibfk_1` FOREIGN KEY (`id_proveedor_contacto`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto_proveedor`
--

LOCK TABLES `contacto_proveedor` WRITE;
/*!40000 ALTER TABLE `contacto_proveedor` DISABLE KEYS */;
INSERT INTO `contacto_proveedor` VALUES ('101','315789129'),('102','315789128'),('103','315789127'),('103','315789128'),('104','315645987'),('105','315645987'),('106','315645987'),('107','315645987'),('108','315645987'),('109','315645987'),('110','315645987'),('111','315645987'),('112','315645987'),('113','315645987'),('114','315645987'),('115','315645987'),('116','315645987'),('117','315645987'),('118','315645987'),('119','315645987'),('120','315645987'),('121','315645987'),('122','315645987'),('123','315645987'),('124','315645987'),('125','315645987'),('126','315645987'),('127','315645987'),('128','315645987'),('129','315645987'),('130','315645987'),('131','315645987'),('132','315645987'),('133','315645987'),('134','315645987'),('135','315645987'),('136','315645987'),('137','315645987'),('138','315645987'),('139','315645987'),('140','315645987'),('141','315645987'),('142','315645987'),('143','315645987'),('144','315645987'),('145','315645987'),('146','315645987'),('147','315645987'),('148','315645987'),('149','315645987'),('150','315645987'),('151','315645987'),('152','315645987'),('153','315645987');
/*!40000 ALTER TABLE `contacto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_cambios_cita`
--

DROP TABLE IF EXISTS `control_cambios_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_cambios_cita` (
  `usuario` varchar(30) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_cambios_cita`
--

LOCK TABLES `control_cambios_cita` WRITE;
/*!40000 ALTER TABLE `control_cambios_cita` DISABLE KEYS */;
INSERT INTO `control_cambios_cita` VALUES ('root@localhost','creo cita','2023-02-17 02:17:15'),('root@localhost','modifico','2023-02-17 02:21:29'),('root@localhost','creo producto','2023-02-17 02:29:00'),('root@localhost','creo producto','2023-02-17 11:19:57'),('root@localhost','creo producto','2023-02-17 11:19:57'),('root@localhost','creo producto','2023-02-17 11:19:57'),('root@localhost','creo producto','2023-02-17 11:19:57'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:58'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:19:59'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00'),('root@localhost','creo producto','2023-02-17 11:20:00');
/*!40000 ALTER TABLE `control_cambios_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` varchar(20) NOT NULL,
  `CC` varchar(60) DEFAULT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `liga` double DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('1001','1115456111','Empleado1',1000),('1002','1115456112','Empleado2',2000),('1003','1115456113','Empleado3',3000),('1004','1115789456','Empleado4',2000),('1005','1116987132','Nombre',2000),('1006','1116987132','Nombre',2000),('1007','1116987132','Nombre',2000),('1008','1116987132','Nombre',2000),('1009','1116987132','Nombre',2000),('1010','1116987132','Nombre',2000),('1011','1116987132','Nombre',2000),('1012','1116987132','Nombre',2000),('1013','1116987132','Nombre',2000),('1014','1116987132','Nombre',2000),('1015','1116987132','Nombre',2000),('1016','1116987132','Nombre',2000),('1017','1116987132','Nombre',2000),('1018','1116987132','Nombre',2000),('1019','1116987132','Nombre',2000),('1020','1116987132','Nombre',2000),('1021','1116987132','Nombre',2000),('1022','1116987132','Nombre',2000),('1023','1116987132','Nombre',2000),('1024','1116987132','Nombre',2000),('1025','1116987132','Nombre',2000),('1026','1116987132','Nombre',2000),('1027','1116987132','Nombre',2000),('1028','1116987132','Nombre',2000),('1029','1116987132','Nombre',2000),('1030','1116987132','Nombre',2000),('1031','1116987132','Nombre',2000),('1032','1116987132','Nombre',2000),('1033','1116987132','Nombre',2000),('1034','1116987132','Nombre',2000),('1035','1116987132','Nombre',2000),('1036','1116987132','Nombre',2000),('1037','1116987132','Nombre',2000),('1038','1116987132','Nombre',2000),('1039','1116987132','Nombre',2000),('1040','1116987132','Nombre',2000),('1041','1116987132','Nombre',2000),('1042','1116987132','Nombre',2000),('1043','1116987132','Nombre',2000),('1044','1116987132','Nombre',2000),('1045','1116987132','Nombre',2000),('1046','1116987132','Nombre',2000),('1047','1116987132','Nombre',2000),('1048','1116987132','Nombre',2000),('1049','1116987132','Nombre',2000),('1050','1116987132','Nombre',2000),('1051','1116987132','Nombre',2000),('1052','1116987132','Nombre',2000),('1053','1116987132','Nombre',2000),('1054','1116987132','Nombre',2000);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_vende`
--

DROP TABLE IF EXISTS `empleado_vende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_vende` (
  `id_empleado_vende` varchar(20) NOT NULL,
  `id_producto_vende` varchar(20) NOT NULL,
  PRIMARY KEY (`id_empleado_vende`,`id_producto_vende`),
  KEY `id_producto_vende` (`id_producto_vende`),
  CONSTRAINT `empleado_vende_ibfk_1` FOREIGN KEY (`id_empleado_vende`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `empleado_vende_ibfk_2` FOREIGN KEY (`id_producto_vende`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_vende`
--

LOCK TABLES `empleado_vende` WRITE;
/*!40000 ALTER TABLE `empleado_vende` DISABLE KEYS */;
INSERT INTO `empleado_vende` VALUES ('1001','2001'),('1002','2002'),('1003','2003'),('1005','2006'),('1006','2007'),('1007','2008'),('1008','2009'),('1009','2010'),('1010','2011'),('1011','2012'),('1012','2013'),('1013','2014'),('1014','2015'),('1015','2016'),('1016','2017'),('1017','2018'),('1018','2019'),('1019','2020'),('1020','2021'),('1021','2022'),('1022','2023'),('1023','2024'),('1024','2025'),('1025','2026'),('1026','2027'),('1027','2028'),('1028','2029'),('1029','2030'),('1030','2031'),('1031','2032'),('1032','2033'),('1033','2034'),('1034','2035'),('1035','2036'),('1036','2037'),('1037','2038'),('1038','2039'),('1039','2040'),('1040','2041'),('1041','2042'),('1042','2043'),('1043','2044'),('1044','2045'),('1045','2046'),('1046','2047'),('1047','2048'),('1048','2049'),('1049','2050'),('1050','2051'),('1051','2052'),('1052','2053'),('1053','2054'),('1054','2055');
/*!40000 ALTER TABLE `empleado_vende` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id_empleado_especialidad` varchar(20) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  PRIMARY KEY (`id_empleado_especialidad`,`especialidad`),
  CONSTRAINT `especialidad_ibfk_1` FOREIGN KEY (`id_empleado_especialidad`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES ('1001','cejas'),('1002','cabello'),('1003','cabello'),('1003','piel'),('1005','cabello'),('1006','cabello'),('1007','cabello'),('1008','cabello'),('1009','cabello'),('1010','cabello'),('1011','cabello'),('1012','cabello'),('1013','cabello'),('1014','cabello'),('1015','cabello'),('1016','cabello'),('1017','cabello'),('1018','cabello'),('1019','cabello'),('1020','cabello'),('1021','cabello'),('1022','cabello'),('1023','cabello'),('1024','cabello'),('1025','cabello'),('1026','cabello'),('1027','cabello'),('1028','cabello'),('1029','cabello'),('1030','cabello'),('1031','cabello'),('1032','cabello'),('1033','cabello'),('1034','cabello'),('1035','cabello'),('1036','cabello'),('1037','cabello'),('1038','cabello'),('1039','cabello'),('1040','cabello'),('1041','cabello'),('1042','cabello'),('1043','cabello'),('1044','cabello'),('1045','cabello'),('1046','cabello'),('1047','cabello'),('1048','cabello'),('1049','cabello'),('1050','cabello'),('1051','cabello'),('1052','cabello'),('1053','cabello'),('1054','cabello');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!50001 DROP VIEW IF EXISTS `facturas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `facturas` AS SELECT 
 1 AS `cedula`,
 1 AS `cliente`,
 1 AS `producto`,
 1 AS `precio`,
 1 AS `cantidad`,
 1 AS `total`,
 1 AS `fecha compra`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `historial_de_servicios`
--

DROP TABLE IF EXISTS `historial_de_servicios`;
/*!50001 DROP VIEW IF EXISTS `historial_de_servicios`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `historial_de_servicios` AS SELECT 
 1 AS `cliente`,
 1 AS `empleado`,
 1 AS `productos_consumidos`,
 1 AS `servicio`,
 1 AS `duracion`,
 1 AS `fecha`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `informacion_proveedores`
--

DROP TABLE IF EXISTS `informacion_proveedores`;
/*!50001 DROP VIEW IF EXISTS `informacion_proveedores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `informacion_proveedores` AS SELECT 
 1 AS `idProveedor`,
 1 AS `proveedor`,
 1 AS `productos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mejores_clientes`
--

DROP TABLE IF EXISTS `mejores_clientes`;
/*!50001 DROP VIEW IF EXISTS `mejores_clientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mejores_clientes` AS SELECT 
 1 AS `total`,
 1 AS `cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `cantidad` varchar(40) DEFAULT NULL,
  `precio` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('2001','Shampoo anti caspa','Descripcion1','100','50000'),('2002','Tinte','Descripcion2','100','5000'),('2003','Prestobarba','Descripcion13','100','6000'),('2004','Acondicionador','Descripcion4','100','2000'),('2005','Gel','Descripcion5','100','1000'),('2006','Gel ego','descripcion','100','2000'),('2007','Gel ego','descripcion','100','2000'),('2008','Gel ego','descripcion','100','2000'),('2009','Gel ego','descripcion','100','2000'),('2010','Gel ego','descripcion','100','2000'),('2011','Gel ego','descripcion','100','2000'),('2012','Gel ego','descripcion','100','2000'),('2013','Gel ego','descripcion','100','2000'),('2014','Gel ego','descripcion','100','2000'),('2015','Gel ego','descripcion','100','2000'),('2016','Gel ego','descripcion','100','2000'),('2017','Gel ego','descripcion','100','2000'),('2018','Gel ego','descripcion','100','2000'),('2019','Gel ego','descripcion','100','2000'),('2020','Gel ego','descripcion','100','2000'),('2021','Gel ego','descripcion','100','2000'),('2022','Gel ego','descripcion','100','2000'),('2023','Gel ego','descripcion','100','2000'),('2024','Gel ego','descripcion','100','2000'),('2025','Gel ego','descripcion','100','2000'),('2026','Gel ego','descripcion','100','2000'),('2027','Gel ego','descripcion','100','2000'),('2028','Gel ego','descripcion','100','2000'),('2029','Gel ego','descripcion','100','2000'),('2030','Gel ego','descripcion','100','2000'),('2031','Gel ego','descripcion','100','2000'),('2032','Gel ego','descripcion','100','2000'),('2033','Gel ego','descripcion','100','2000'),('2034','Gel ego','descripcion','100','2000'),('2035','Gel ego','descripcion','100','2000'),('2036','Gel ego','descripcion','100','2000'),('2037','Gel ego','descripcion','100','2000'),('2038','Gel ego','descripcion','100','2000'),('2039','Gel ego','descripcion','100','2000'),('2040','Gel ego','descripcion','100','2000'),('2041','Gel ego','descripcion','100','2000'),('2042','Gel ego','descripcion','100','2000'),('2043','Gel ego','descripcion','100','2000'),('2044','Gel ego','descripcion','100','2000'),('2045','Gel ego','descripcion','100','2000'),('2046','Gel ego','descripcion','100','2000'),('2047','Gel ego','descripcion','100','2000'),('2048','Gel ego','descripcion','100','2000'),('2049','Gel ego','descripcion','100','2000'),('2050','Gel ego','descripcion','100','2000'),('2051','Gel ego','descripcion','100','2000'),('2052','Gel ego','descripcion','100','2000'),('2053','Gel ego','descripcion','100','2000'),('2054','Gel ego','descripcion','100','2000'),('2055','Gel ego','descripcion','100','2000');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_proveedor`
--

DROP TABLE IF EXISTS `producto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_proveedor` (
  `id_proveedor_producto` varchar(20) NOT NULL,
  `id_producto_proveedor` varchar(20) NOT NULL,
  PRIMARY KEY (`id_proveedor_producto`,`id_producto_proveedor`),
  KEY `id_producto_proveedor` (`id_producto_proveedor`),
  CONSTRAINT `producto_proveedor_ibfk_1` FOREIGN KEY (`id_proveedor_producto`) REFERENCES `proveedor` (`id_proveedor`),
  CONSTRAINT `producto_proveedor_ibfk_2` FOREIGN KEY (`id_producto_proveedor`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_proveedor`
--

LOCK TABLES `producto_proveedor` WRITE;
/*!40000 ALTER TABLE `producto_proveedor` DISABLE KEYS */;
INSERT INTO `producto_proveedor` VALUES ('101','2001'),('102','2002'),('103','2003'),('103','2004'),('104','2006'),('105','2007'),('106','2008'),('107','2009'),('108','2010'),('109','2011'),('110','2012'),('111','2013'),('112','2014'),('113','2015'),('114','2016'),('115','2017'),('116','2018'),('117','2019'),('118','2020'),('119','2021'),('120','2022'),('121','2023'),('122','2024'),('123','2025'),('124','2026'),('125','2027'),('126','2028'),('127','2029'),('128','2030'),('129','2031'),('130','2032'),('131','2033'),('132','2034'),('133','2035'),('134','2036'),('135','2037'),('136','2038'),('137','2039'),('138','2040'),('139','2041'),('140','2042'),('141','2043'),('142','2044'),('143','2045'),('144','2046'),('145','2047'),('146','2048'),('147','2049'),('148','2050'),('149','2051'),('150','2052'),('151','2053'),('152','2054'),('153','2055');
/*!40000 ALTER TABLE `producto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_servicio`
--

DROP TABLE IF EXISTS `producto_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_servicio` (
  `id_producto_servicio` varchar(20) NOT NULL,
  `id_servicio_producto` varchar(20) NOT NULL,
  PRIMARY KEY (`id_producto_servicio`,`id_servicio_producto`),
  KEY `id_servicio_producto` (`id_servicio_producto`),
  CONSTRAINT `producto_servicio_ibfk_1` FOREIGN KEY (`id_producto_servicio`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `producto_servicio_ibfk_2` FOREIGN KEY (`id_servicio_producto`) REFERENCES `servicio` (`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_servicio`
--

LOCK TABLES `producto_servicio` WRITE;
/*!40000 ALTER TABLE `producto_servicio` DISABLE KEYS */;
INSERT INTO `producto_servicio` VALUES ('2001','4001'),('2004','4001'),('2002','4002'),('2003','4003');
/*!40000 ALTER TABLE `producto_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id_proveedor` varchar(20) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('101','Proveedor1','Calle falsa 123'),('102','Proveedor2','Calle falsa 124'),('103','Proveedor3','Calle falsa 125'),('104','Proveedor','Calle falsa 123456'),('105','Proveedor','Calle falsa 123456'),('106','Proveedor','Calle falsa 123456'),('107','Proveedor','Calle falsa 123456'),('108','Proveedor','Calle falsa 123456'),('109','Proveedor','Calle falsa 123456'),('110','Proveedor','Calle falsa 123456'),('111','Proveedor','Calle falsa 123456'),('112','Proveedor','Calle falsa 123456'),('113','Proveedor','Calle falsa 123456'),('114','Proveedor','Calle falsa 123456'),('115','Proveedor','Calle falsa 123456'),('116','Proveedor','Calle falsa 123456'),('117','Proveedor','Calle falsa 123456'),('118','Proveedor','Calle falsa 123456'),('119','Proveedor','Calle falsa 123456'),('120','Proveedor','Calle falsa 123456'),('121','Proveedor','Calle falsa 123456'),('122','Proveedor','Calle falsa 123456'),('123','Proveedor','Calle falsa 123456'),('124','Proveedor','Calle falsa 123456'),('125','Proveedor','Calle falsa 123456'),('126','Proveedor','Calle falsa 123456'),('127','Proveedor','Calle falsa 123456'),('128','Proveedor','Calle falsa 123456'),('129','Proveedor','Calle falsa 123456'),('130','Proveedor','Calle falsa 123456'),('131','Proveedor','Calle falsa 123456'),('132','Proveedor','Calle falsa 123456'),('133','Proveedor','Calle falsa 123456'),('134','Proveedor','Calle falsa 123456'),('135','Proveedor','Calle falsa 123456'),('136','Proveedor','Calle falsa 123456'),('137','Proveedor','Calle falsa 123456'),('138','Proveedor','Calle falsa 123456'),('139','Proveedor','Calle falsa 123456'),('140','Proveedor','Calle falsa 123456'),('141','Proveedor','Calle falsa 123456'),('142','Proveedor','Calle falsa 123456'),('143','Proveedor','Calle falsa 123456'),('144','Proveedor','Calle falsa 123456'),('145','Proveedor','Calle falsa 123456'),('146','Proveedor','Calle falsa 123456'),('147','Proveedor','Calle falsa 123456'),('148','Proveedor','Calle falsa 123456'),('149','Proveedor','Calle falsa 123456'),('150','Proveedor','Calle falsa 123456'),('151','Proveedor','Calle falsa 123456'),('152','Proveedor','Calle falsa 123456'),('153','Proveedor','Calle falsa 123456');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `registro_de_ventas`
--

DROP TABLE IF EXISTS `registro_de_ventas`;
/*!50001 DROP VIEW IF EXISTS `registro_de_ventas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `registro_de_ventas` AS SELECT 
 1 AS `producto`,
 1 AS `cliente`,
 1 AS `empleado`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id_servicio` varchar(20) NOT NULL,
  `fecha` varchar(20) DEFAULT NULL,
  `descripcion` varchar(20) DEFAULT NULL,
  `precio` varchar(20) DEFAULT NULL,
  `id_cita_servicio` varchar(20) DEFAULT NULL,
  `duracion` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `id_cita_servicio` (`id_cita_servicio`),
  CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`id_cita_servicio`) REFERENCES `cita` (`id_cita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES ('4001','02/02/92','descripcion1','30000','3001',NULL),('4002','02/02/93','descripcion2','20000','3002',NULL),('4003','02/02/94','descripcion3','10000','3003',NULL);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `facturas`
--

/*!50001 DROP VIEW IF EXISTS `facturas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `facturas` AS select `cliente`.`CC` AS `cedula`,`cliente`.`nombre` AS `cliente`,`producto`.`nombre` AS `producto`,`producto`.`precio` AS `precio`,`compra`.`cantidad_producto` AS `cantidad`,`compra`.`total` AS `total`,`compra`.`fecha` AS `fecha compra` from ((`cliente` join `compra` on((`compra`.`id_cliente_compra` = `cliente`.`id_cliente`))) join `producto` on((`producto`.`id_producto` = `compra`.`id_producto_compra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `historial_de_servicios`
--

/*!50001 DROP VIEW IF EXISTS `historial_de_servicios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `historial_de_servicios` AS select `cliente`.`nombre` AS `cliente`,`empleado`.`nombre` AS `empleado`,group_concat(`producto`.`nombre` separator ', ') AS `productos_consumidos`,`servicio`.`descripcion` AS `servicio`,`servicio`.`duracion` AS `duracion`,`servicio`.`fecha` AS `fecha` from (((((`cliente` join `cita` on((`cita`.`id_cliente_cita` = `cliente`.`id_cliente`))) join `empleado` on((`empleado`.`id_empleado` = `cita`.`id_empleado_cita`))) join `servicio` on((`servicio`.`id_cita_servicio` = `cita`.`id_cita`))) join `producto_servicio` on((`producto_servicio`.`id_servicio_producto` = `servicio`.`id_servicio`))) join `producto` on((`producto`.`id_producto` = `producto_servicio`.`id_producto_servicio`))) group by `servicio`.`id_servicio` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `informacion_proveedores`
--

/*!50001 DROP VIEW IF EXISTS `informacion_proveedores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `informacion_proveedores` AS select `proveedor`.`id_proveedor` AS `idProveedor`,`proveedor`.`nombre` AS `proveedor`,group_concat(`producto`.`nombre` separator ', ') AS `productos` from ((`producto` join `producto_proveedor` on((`producto_proveedor`.`id_producto_proveedor` = `producto`.`id_producto`))) join `proveedor` on((`proveedor`.`id_proveedor` = `producto_proveedor`.`id_proveedor_producto`))) group by `proveedor`.`id_proveedor` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mejores_clientes`
--

/*!50001 DROP VIEW IF EXISTS `mejores_clientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mejores_clientes` AS select sum(`compra`.`total`) AS `total`,`cliente`.`nombre` AS `cliente` from ((`compra` join `producto` on((`producto`.`id_producto` = `compra`.`id_producto_compra`))) join `cliente` on((`cliente`.`id_cliente` = `compra`.`id_cliente_compra`))) group by `compra`.`id_cliente_compra` order by `total` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `registro_de_ventas`
--

/*!50001 DROP VIEW IF EXISTS `registro_de_ventas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `registro_de_ventas` AS select `producto`.`nombre` AS `producto`,`cliente`.`nombre` AS `cliente`,`empleado`.`nombre` AS `empleado` from ((((`empleado` join `empleado_vende` on((`empleado_vende`.`id_empleado_vende` = `empleado`.`id_empleado`))) join `producto` on((`producto`.`id_producto` = `empleado_vende`.`id_producto_vende`))) join `compra` on((`compra`.`id_producto_compra` = `producto`.`id_producto`))) join `cliente` on((`cliente`.`id_cliente` = `compra`.`id_cliente_compra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 12:44:02
