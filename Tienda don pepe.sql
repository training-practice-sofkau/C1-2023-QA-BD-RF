-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendadonpepe
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `carrito_compra_producto`
--

DROP TABLE IF EXISTS `carrito_compra_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito_compra_producto` (
  `id_carrito_compra` int NOT NULL,
  `nombre_producto` varchar(60) NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_carrito_compra`,`nombre_producto`),
  KEY `nombre_producto` (`nombre_producto`),
  CONSTRAINT `carrito_compra_producto_ibfk_1` FOREIGN KEY (`id_carrito_compra`) REFERENCES `carrito_de_compra` (`id_carrito`),
  CONSTRAINT `carrito_compra_producto_ibfk_2` FOREIGN KEY (`nombre_producto`) REFERENCES `producto` (`nom_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_compra_producto`
--

LOCK TABLES `carrito_compra_producto` WRITE;
/*!40000 ALTER TABLE `carrito_compra_producto` DISABLE KEYS */;
INSERT INTO `carrito_compra_producto` VALUES (0,'Awesome Leather Lamp',4),(0,'Enormous Plastic Shirt',3),(0,'Ergonomic Concrete Gloves',1),(0,'Fantastic Linen Bench',2),(0,'Gorgeous Concrete Watch',1),(0,'Intelligent Steel Hat',3),(0,'Sleek Cotton Watch',3),(2,'Enormous Leather Hat',4),(2,'Enormous Plastic Shirt',3),(2,'Practical Aluminum Coat',4),(2,'Sleek Iron Bench',1),(3,'Rustic Plastic Keyboard',3),(3,'Sleek Cotton Watch',3),(3,'Sleek Wool Lamp',3),(4,'Awesome Cotton Bench',1),(4,'Ergonomic Rubber Bag',2),(4,'Fantastic Linen Bench',4),(7,'Ergonomic Aluminum Shoes',1),(7,'Intelligent Steel Hat',1),(7,'Rustic Aluminum Clock',2),(7,'Sleek Cotton Watch',1),(8,'Enormous Plastic Shirt',3),(8,'Ergonomic Iron Pants',4),(8,'Mediocre Marble Watch',1),(9,'Aerodynamic Silk Wallet',5),(9,'Sleek Linen Shirt',1),(12,'Ergonomic Iron Pants',2),(12,'Fantastic Linen Bench',5),(12,'Heavy Duty Iron Table',4),(12,'Rustic Plastic Keyboard',2),(13,'Incredible Wool Bench',1),(13,'Sleek Linen Shirt',1),(14,'Heavy Duty Iron Car',5),(14,'Intelligent Steel Hat',1),(14,'Mediocre Marble Watch',5),(15,'Ergonomic Iron Pants',1),(15,'Sleek Iron Bench',5),(17,'Ergonomic Rubber Bag',4),(18,'Enormous Plastic Shirt',5),(18,'Incredible Concrete Keyboard',1),(18,'Intelligent Cotton Coat',4),(18,'Sleek Cotton Watch',5),(20,'Heavy Duty Wooden Gloves',3),(20,'Lightweight Granite Bottle',4),(20,'Mediocre Wooden Shoes',5),(20,'Small Steel Gloves',4),(20,'Synergistic Leather Bottle',4),(21,'Aerodynamic Silk Wallet',1),(21,'Awesome Leather Lamp',2),(21,'Ergonomic Iron Pants',1),(22,'Awesome Leather Lamp',3),(22,'Gorgeous Concrete Watch',5),(23,'Heavy Duty Concrete Lamp',2),(23,'Incredible Cotton Watch',4),(23,'Rustic Aluminum Clock',4),(23,'Rustic Plastic Keyboard',3),(24,'Enormous Leather Hat',2),(24,'Incredible Concrete Keyboard',3),(24,'Sleek Iron Bench',3),(25,'Ergonomic Concrete Gloves',2),(25,'Heavy Duty Concrete Lamp',2),(25,'Incredible Cotton Watch',1),(25,'Mediocre Wooden Shoes',3),(25,'Small Steel Watch',2),(26,'Heavy Duty Bronze Gloves',4),(26,'Heavy Duty Wooden Shoes',4),(26,'Intelligent Steel Hat',3),(26,'Synergistic Wool Watch',1),(27,'Enormous Plastic Shirt',3),(27,'Intelligent Cotton Coat',1),(27,'Rustic Aluminum Clock',4),(27,'Synergistic Leather Bottle',5),(28,'Awesome Leather Lamp',4),(28,'Durable Wool Lamp',3),(28,'Heavy Duty Iron Car',1),(28,'Incredible Cotton Watch',5),(28,'Lightweight Granite Bottle',4),(29,'Sleek Cotton Watch',4),(30,'Heavy Duty Iron Table',2),(31,'Aerodynamic Silk Wallet',4),(31,'Sleek Copper Keyboard',5),(33,'Rustic Aluminum Clock',5),(35,'Intelligent Cotton Coat',4),(36,'Incredible Iron Gloves',2),(37,'Intelligent Cotton Coat',5),(37,'Rustic Plastic Plate',1),(38,'Sleek Iron Bench',3),(38,'Small Steel Watch',3),(38,'Synergistic Wool Watch',4),(39,'Awesome Leather Lamp',1),(39,'Heavy Duty Iron Car',4),(39,'Incredible Wool Bench',2),(39,'Intelligent Steel Hat',1),(39,'Sleek Linen Shirt',2),(40,'Durable Wool Lamp',5),(40,'Synergistic Wool Watch',1),(41,'Awesome Cotton Bench',5),(41,'Heavy Duty Concrete Lamp',5),(41,'Heavy Duty Wooden Gloves',2),(41,'Rustic Plastic Plate',5),(42,'Incredible Iron Gloves',2),(42,'Mediocre Marble Watch',4),(43,'Awesome Marble Plate',2),(43,'Mediocre Wooden Shoes',3),(43,'Sleek Wool Lamp',3),(43,'Synergistic Leather Bottle',3),(44,'Mediocre Wooden Shoes',4),(44,'Sleek Linen Shirt',1),(45,'Intelligent Cotton Coat',2),(46,'Durable Wool Lamp',1),(47,'Durable Wool Lamp',5),(47,'Rustic Plastic Keyboard',5),(48,'Incredible Iron Gloves',5),(48,'Intelligent Steel Hat',3),(48,'Synergistic Wool Watch',1),(49,'Heavy Duty Wooden Gloves',4),(49,'Mediocre Wooden Shoes',1),(49,'Practical Aluminum Coat',4),(49,'Rustic Aluminum Clock',2),(49,'Synergistic Leather Bottle',5),(50,'Ergonomic Iron Pants',3),(50,'Heavy Duty Concrete Lamp',5),(50,'Rustic Plastic Plate',2),(50,'Sleek Copper Keyboard',4),(50,'Synergistic Leather Bottle',4);
/*!40000 ALTER TABLE `carrito_compra_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrito_de_compra`
--

DROP TABLE IF EXISTS `carrito_de_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito_de_compra` (
  `id_carrito` int NOT NULL,
  PRIMARY KEY (`id_carrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_de_compra`
--

LOCK TABLES `carrito_de_compra` WRITE;
/*!40000 ALTER TABLE `carrito_de_compra` DISABLE KEYS */;
INSERT INTO `carrito_de_compra` VALUES (0),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(18),(19),(20),(21),(22),(23),(24),(25),(26),(27),(28),(29),(30),(31),(32),(33),(34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(45),(46),(47),(48),(49),(50);
/*!40000 ALTER TABLE `carrito_de_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `almacenamiento` varchar(30) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Books & Sports','laudantium','Explicabo enim dolores omnis rerum.'),(2,'Jewelry & Sports','consequuntur','Delectus ad labore ut maiores totam.'),(6,'Outdoors','qui','Enim blanditiis rerum eligendi ut pariatur non molestias.'),(8,'Kids','hic','Eaque et distinctio consequatur molestiae consequatur.'),(14,'Garden & Movies','cupiditate','Sit nam vero consectetur.'),(16,'Books & Movies','nesciunt','Voluptatem quis consequatur rerum perferendis facilis.'),(18,'Books & Clothing','id','Excepturi ut dolorem.'),(19,'Clothing','corrupti','Et voluptas reiciendis ipsam tenetur.'),(20,'Automotive','vel','Eius itaque dolores.'),(21,'Shoes, Tools & Toys','neque','Iste aut totam cumque quia enim tenetur omnis.'),(25,'Grocery, Kids & Sports','quis','Quod nihil iusto.'),(27,'Shoes','corporis','Sint sed iure quo maxime perspiciatis nobis omnis.'),(28,'Computers & Shoes','nulla','Qui ab ab.'),(29,'Automotive & Shoes','fuga','Non ut numquam nulla officiis pariatur.'),(30,'Electronics','qui','Blanditiis sapiente vel aut voluptates.'),(32,'Computers, Industrial & Jewelry','architecto','Omnis repellendus atque provident voluptatem.'),(35,'Automotive','aspernatur','Qui aspernatur nisi dolor.'),(36,'Automotive, Games & Toys','iure','Quo ea voluptas neque.'),(40,'Shoes','quis','Explicabo doloremque quasi vel optio necessitatibus.'),(42,'Automotive, Books & Industrial','repellendus','Quisquam impedit molestias facilis pariatur.'),(43,'Electronics, Garden & Outdoors','sit','Nesciunt aliquid est blanditiis doloremque exercitationem labore nihil.'),(47,'Clothing','veritatis','Vero minus aut consequatur vel.'),(48,'Grocery','autem','Repellendus voluptatem sequi sint accusantium.'),(51,'Games, Garden & Movies','qui','Occaecati exercitationem harum modi magni sit et dolores.'),(53,'Tools','non','Enim sint tempore voluptatum rerum quae sequi minus.'),(56,'Books','vero','Quaerat numquam sit id.'),(59,'Garden, Kids & Tools','et','Optio sapiente animi et sed eum.'),(63,'Electronics & Toys','sit','Sint ipsa doloribus esse.'),(69,'Electronics & Outdoors','provident','Aperiam dicta rerum.'),(70,'Clothing','nobis','Ab expedita numquam accusamus architecto pariatur.'),(71,'Clothing, Music & Toys','reprehenderit','Et consequatur dolore ut.'),(75,'Clothing','adipisci','Quo nostrum perspiciatis autem voluptatem sed.'),(76,'Kids','distinctio','Minima nesciunt similique ad.'),(77,'Beauty, Electronics & Jewelry','quia','Enim autem aut sint delectus minus ut.'),(78,'Industrial','aut','Sint similique sunt dicta harum expedita ea.'),(79,'Automotive, Movies & Toys','repellendus','Dignissimos ut culpa odit amet dignissimos consequatur quis.'),(84,'Health & Kids','est','Perferendis eligendi omnis illo voluptate eum cum.'),(86,'Kids, Shoes & Sports','et','Inventore voluptatibus est sint.'),(88,'Beauty, Industrial & Jewelry','esse','Corporis atque laudantium delectus.'),(91,'Clothing, Industrial & Movies','quas','Harum eaque dignissimos sapiente dolor odit.'),(98,'Industrial','dolor','Est quis nobis dolor quo.');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ced_cliente` varchar(15) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(25) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  `codigo_postal` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ced_cliente`),
  KEY `codigo_postal` (`codigo_postal`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`codigo_postal`) REFERENCES `zona` (`cod_postal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('000-15-8302','Jerrell Walker','Anibal Harbors','matthew.roob@hotmail.com','fwe4pf9d','35826-4363'),('011-58-8871','Chadwick Farrell MD','Burton Freeway','garret.herzog@hotmail.com','g3nd55wiira6','26298'),('014-74-6551','Ralph Johnson','Brekke Junction','arlinda.ritchie@hotmail.com','kzrepx3j0','09747-9262'),('038-21-2078','Keenan Hodkiewicz','Grimes Burg','britt.armstrong@hotmail.com','lvue7qjs','70802-7699'),('042-70-5994','Rudy Roob III','Brande Turnpike','treva.ernser@gmail.com','4jx9apyl','08972-8761'),('053-04-8684','Mikki Johns','Becker Station','ellsworth.green@hotmail.com','d8jetprqofwi8g','61032-3674'),('058-52-6818','Renaldo Harber','Florentina Shoal','cathey.haag@hotmail.com','atjd2evhkqeu0aj','08972-8761'),('088-81-2452','Aura Toy','Jill Stream','anja.brakus@hotmail.com','kizidm9bl','32318-2684'),('114-28-7840','Norma Homenick','Walter Ridge','colin.spencer@yahoo.com','g3wgbu74g','91005-1468'),('12343','maria','callee','mad @fv','vava','05553'),('207-72-0420','Kenny Willms','Mohamed Center','audry.okeefe@hotmail.com','x7uyjdug6','32318-2684'),('235-55-7397','Alyse Senger II','Vella Streets','tamera.ritchie@gmail.com','1hcncdko1k0lk30','41674-6659'),('269-99-2436','Kathline Russel','Chrissy Ridges','jeri.pouros@yahoo.com','lfikk77jexnti','55799'),('278-23-0918','Hong Gottlieb','Schmitt Burg','weldon.monahan@hotmail.com','yqrjs3t4dsj5ai','33651'),('283-75-2202','Deedra Johnston','Doyle Trail','lashawna.brakus@hotmail.com','ue5r89fpw','93062-3820'),('320-33-1853','Miquel West I','Rudolf Parkway','ferdinand.mclaughlin@gmail.com','40io5nwku4','10997-1229'),('342-49-2983','Dr. Alvin Bahringer','Yadira Square','gayla.rowe@hotmail.com','rvuvnuzl','17904'),('362-93-4278','Margarett Kuhlman V','DuBuque Ways','kirby.rolfson@hotmail.com','qfwf77g9zb','24515'),('387-81-8655','Nia Hammes III','Stokes Branch','charles.swift@hotmail.com','oyolavvzcr4x','12900-6966'),('392-64-1605','Vida Wolf','Kutch Underpass','laverne.murray@yahoo.com','2fou7cky2fy9c4','82663-9115'),('412-53-0932','Lavenia Olson','Hank Grove','georgia.gleichner@yahoo.com','ayihz97t4z25hmy','76812-0965'),('431-23-3962','Magda MacGyver','Osinski Burg','allan.watsica@hotmail.com','3g0mbx0u77rg','48126'),('432-30-8315','Kelly Reichel','Dickinson Mission','bo.hilpert@gmail.com','6taucax2lmbki','08972-8761'),('437-80-6062','Malcom Friesen III','Migdalia Curve','edwin.prosacco@yahoo.com','1k7rphbow0','12900-6966'),('472-27-4748','Alline Monahan Sr.','Carter Cliffs','vonnie.fritsch@gmail.com','hsje5zcajdcd','26298'),('472-41-7513','Ward Shanahan DVM','Lang Meadows','manual.nader@hotmail.com','czwmwmewcxp5gm','93062-3820'),('539-50-6923','Bettye Purdy','Rath Groves','marilou.brown@gmail.com','7vebqqjrtml4r','87656'),('551-91-7918','Wm Lind','Upton Mews','donald.champlin@yahoo.com','3gmuv3h7n848','02877-8529'),('615-95-3489','Gerda Feeney','Roberts Valley','lorita.kunde@gmail.com','46e155h15k8pw','17014'),('633-35-9726','Joleen Denesik III','Jaskolski Inlet','christin.padberg@gmail.com','93e6zvck0iv5','48001'),('638-27-5210','Raleigh Gislason','Fadel Islands','suzan.weimann@gmail.com','tkdudkbm4z6','60065'),('648-66-4172','Harley Bauch DDS','Perry Turnpike','mariann.ritchie@hotmail.com','joo52ghqq4ce','20903'),('651-83-3382','Steve Bahringer','Drew Hollow','pearle.hettinger@hotmail.com','yncyjdeumvthfb','48458-0362'),('653-46-2605','Lynetta Jenkins','Danelle Extensions','salvador.batz@hotmail.com','7qhzuf8a3fsc','20903'),('661-15-8360','Gerald Tremblay','Hartmann Locks','drew.kling@gmail.com','dsu991g9','93062-3820'),('667-96-5733','Gwyn Considine','Vandervort Mission','marcus.jast@hotmail.com','xez6or9ijbq','83411-1246'),('676-16-9835','Donte Hudson','Hackett Vista','suzette.botsford@hotmail.com','dnpp9frnfsam29r','82663-9115'),('678-67-4128','Douglas Corwin MD','Otto Plains','tanika.welch@gmail.com','rdwxju17r6zkrtg','43463'),('682-57-8229','Nicolas Kovacek','Moore Brooks','glynis.hoeger@yahoo.com','yb4uoh68xqqwr','17904'),('713-69-3671','Mohammed Abernathy MD','Pfannerstill Village','lela.hilpert@gmail.com','0oiztqx1m3pn','88590-3139'),('718-11-9001','Darrick Dach','Krajcik Square','matt.sipes@hotmail.com','rongcxf5239i','41674-6659'),('742-76-0799','Miss Hans Welch','Koelpin Row','roni.toy@gmail.com','ub213hnr','02877-8529'),('743-37-1826','Norbert Kovacek','Laine Springs','oscar.flatley@gmail.com','fbaw2ufd0cy','70802-7699'),('753-25-3598','Mazie Rohan','Luke Station','arnita.yundt@gmail.com','11pyv4twwb','60065'),('798-25-0777','Mary Jaskolski','Loida Road','edwin.goyette@yahoo.com','lf7oxx97','43463'),('800-67-7241','Joesph Boyle','Irving Inlet','myung.mertz@hotmail.com','iyp609y9u8m','22790-4821'),('814-44-6983','Oliver Bode DDS','Hoppe Curve','maryam.davis@hotmail.com','v9vt8ro6x7wj53','05553'),('824-01-1574','Wilfred West','Randi Lights','lynne.oberbrunner@gmail.com','9nti594ypluffm','88528-3719'),('837-76-1597','Oliver Witting','Tandra Green','refugio.erdman@hotmail.com','avm7d1zfpk6m3ub','61032-3674'),('838-52-4289','Lane Dooley','Nienow Gardens','chung.wolf@hotmail.com','asbbi2dshbaixz','80526-5183'),('840-97-0138','Deangelo Lueilwitz','Paulina Prairie','austin.hermann@gmail.com','xam1e54u3h','82663-9115'),('851-92-8904','Don Cummings','Skiles Ridge','augustus.wilderman@hotmail.com','4agljewd0nz','35826-4363');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_de_cambios_tienda_pepe`
--

DROP TABLE IF EXISTS `control_de_cambios_tienda_pepe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_de_cambios_tienda_pepe` (
  `usuario` varchar(45) DEFAULT NULL,
  `accion` varchar(45) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_de_cambios_tienda_pepe`
--

LOCK TABLES `control_de_cambios_tienda_pepe` WRITE;
/*!40000 ALTER TABLE `control_de_cambios_tienda_pepe` DISABLE KEYS */;
INSERT INTO `control_de_cambios_tienda_pepe` VALUES ('Luisa mendez','Agregar Categoria','2023-02-18 21:44:47'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:47'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:47'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:48'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:49'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:50'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:50'),('Luisa mendez','Agregar Categoria','2023-02-18 21:44:50'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:13'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:14'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:15'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:16'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:16'),('Luisa mendez','Agregar Proveedor','2023-02-18 21:47:16');
/*!40000 ALTER TABLE `control_de_cambios_tienda_pepe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domiciliario`
--

DROP TABLE IF EXISTS `domiciliario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domiciliario` (
  `cedula_domiciliario` varchar(15) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `num_matricula` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cedula_domiciliario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domiciliario`
--

LOCK TABLES `domiciliario` WRITE;
/*!40000 ALTER TABLE `domiciliario` DISABLE KEYS */;
INSERT INTO `domiciliario` VALUES ('021-09-7100','Norbert','SKW-445'),('048-38-1959','Ervin','FNV-873'),('056-16-4554','Olive','PEW-148'),('114-94-8498','Luana','WRR-642'),('134-76-9905','Gaylord','ETN-416'),('140-05-1097','Alex','PRE-198'),('170-58-2725','Augustine','FVR-312'),('195-59-5358','Arturo','CJK-795'),('199-40-0835','Burt','PTG-892'),('217-03-1349','Robby','QKM-716'),('224-24-5453','Josue','ICQ-363'),('231-31-0728','Mckinley','CBH-371'),('257-53-4301','Timothy','RMO-620'),('279-06-8808','Junior','OCN-582'),('343-65-9741','Errol','PDK-793'),('347-08-6995','Dwight','IDU-345'),('357-91-5501','Mac','IKS-399'),('360-64-7313','Tom','YDA-537'),('393-25-5655','Remona','MLF-758'),('414-19-4172','Dwayne','TNV-015'),('422-33-5676','Ted','NQY-210'),('442-09-8182','Shanna','CSQ-183'),('449-08-5939','Gilberto','NVA-778'),('452-95-2076','Charles','UUI-379'),('471-93-1151','Nona','FEP-609'),('479-42-4607','Dion','ERL-796'),('490-91-4566','Katelyn','PVV-970'),('504-75-3367','Audrey','GTZ-196'),('508-40-6490','Mohamed','TSL-911'),('509-11-5052','Jodi','QNC-065'),('541-50-4215','Genaro','IFI-143'),('541-79-3502','Freeman','SIQ-087'),('550-47-1652','Ila','IPM-049'),('556-51-0146','Felipe','HNM-336'),('558-92-7485','Lon','BTM-815'),('559-91-3775','Warren','JDV-017'),('561-94-7497','Lidia','HEX-581'),('598-09-8467','Val','ABD-462'),('618-24-2405','Marty','HPN-198'),('692-54-2760','Zane','GOG-000'),('704-83-9348','Randolph','RAT-955'),('713-46-7082','Louie','NUW-550'),('736-02-5908','Julienne','VRD-573'),('752-04-5653','Deneen','HYW-511'),('765-70-5307','Shanon','YFC-255'),('790-05-7157','Dick','CIT-668'),('806-81-6957','Long','ZSD-352'),('810-49-8724','Vickie','VAL-839'),('875-97-8714','Vince','AXH-799'),('891-22-3008','Mariela','YXF-387'),('896-22-2276','Rocco','QVN-071');
/*!40000 ALTER TABLE `domiciliario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `codigo_factura` varchar(20) NOT NULL,
  `total` int DEFAULT NULL,
  `ced_domiciliario` varchar(20) DEFAULT NULL,
  `cedula_cliente` varchar(15) DEFAULT NULL,
  `cod_pedido` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_factura`),
  KEY `ced_domiciliario` (`ced_domiciliario`),
  KEY `cedula_cliente` (`cedula_cliente`),
  KEY `cod_pedido` (`cod_pedido`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`ced_domiciliario`) REFERENCES `domiciliario` (`cedula_domiciliario`),
  CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`cedula_cliente`) REFERENCES `cliente` (`ced_cliente`),
  CONSTRAINT `factura_ibfk_3` FOREIGN KEY (`cod_pedido`) REFERENCES `pedido` (`codigo_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id_inventario` int NOT NULL,
  `cant_disponible` int DEFAULT NULL,
  `nombre_producto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_inventario`),
  KEY `nombre_producto` (`nombre_producto`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`nombre_producto`) REFERENCES `producto` (`nom_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,85,'Intelligent Steel Hat'),(2,91,'Rustic Plastic Plate'),(3,77,'Synergistic Leather Bottle'),(4,90,'Practical Aluminum Coat'),(5,85,'Rustic Plastic Keyboard'),(6,92,'Enormous Leather Hat'),(7,94,'Small Steel Gloves'),(8,98,'Rustic Plastic Plate'),(9,98,'Intelligent Steel Hat'),(10,92,'Synergistic Wool Watch'),(11,92,'Ergonomic Rubber Bag'),(12,92,'Heavy Duty Iron Table'),(13,88,'Awesome Leather Lamp'),(14,84,'Enormous Plastic Shirt'),(15,98,'Synergistic Leather Bottle'),(16,98,'Enormous Plastic Shirt'),(17,89,'Ergonomic Iron Pants'),(18,88,'Heavy Duty Iron Car'),(19,90,'Incredible Cotton Watch'),(20,98,'Awesome Leather Lamp'),(21,88,'Aerodynamic Silk Wallet'),(22,98,'Synergistic Leather Bottle'),(23,93,'Gorgeous Concrete Watch'),(24,95,'Ergonomic Concrete Gloves'),(25,98,'Practical Aluminum Coat'),(26,87,'Fantastic Linen Bench'),(27,86,'Incredible Iron Gloves'),(28,83,'Durable Wool Lamp'),(29,98,'Gorgeous Concrete Watch'),(30,91,'Heavy Duty Wooden Gloves'),(31,88,'Sleek Linen Shirt'),(32,98,'Heavy Duty Iron Table'),(33,98,'Incredible Iron Gloves'),(34,92,'Sleek Wool Lamp'),(35,98,'Small Steel Gloves'),(36,98,'Enormous Plastic Shirt'),(37,79,'Mediocre Wooden Shoes'),(38,90,'Lightweight Granite Bottle'),(39,94,'Heavy Duty Bronze Gloves'),(40,98,'Incredible Cotton Watch'),(41,97,'Ergonomic Aluminum Shoes'),(42,98,'Incredible Iron Gloves'),(43,98,'Small Steel Gloves'),(44,92,'Awesome Cotton Bench'),(45,95,'Incredible Wool Bench'),(46,98,'Rustic Plastic Plate'),(47,93,'Small Steel Watch');
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `codigo_pedido` varchar(20) NOT NULL,
  `fecha` date DEFAULT NULL,
  `num_tarjeta` varchar(20) DEFAULT NULL,
  `fecha_caducidad` date DEFAULT NULL,
  `id_carrito_compra` int DEFAULT NULL,
  PRIMARY KEY (`codigo_pedido`),
  KEY `id_carrito_compra` (`id_carrito_compra`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_carrito_compra`) REFERENCES `carrito_de_compra` (`id_carrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('0 ','1968-01-30','3','1985-06-07',0),('1 ','1968-07-16','7','2002-11-27',1),('10 ','1963-06-21','1','1968-07-09',10),('11 ','1976-04-24','1','1976-11-30',11),('12 ','1965-08-04','7','1963-03-02',12),('13 ','1983-10-14','5','1966-03-22',13),('14 ','1983-04-19','0','1982-11-18',14),('15 ','1998-02-13','8','1969-06-09',15),('16 ','2000-04-15','8','1973-11-10',16),('17 ','1980-07-13','6','1966-05-26',17),('18 ','1986-01-05','4','1975-07-30',18),('19 ','1984-12-02','2','1984-06-22',19),('2 ','2002-10-16','2','1972-01-18',2),('20 ','1960-09-05','3','1971-01-15',20),('21 ','1968-04-08','7','1973-02-05',21),('22 ','1958-10-24','9','1963-01-21',22),('23 ','1969-07-19','2','1966-01-23',23),('24 ','1974-01-17','8','1964-12-14',24),('25 ','1997-08-17','5','1978-08-16',25),('26 ','1966-01-05','2','1990-06-19',26),('27 ','1988-03-18','0','1960-09-13',27),('28 ','1975-11-24','8','1963-07-07',28),('29 ','1965-07-01','9','1986-04-06',29),('3 ','1989-12-20','3','1998-09-05',3),('30 ','1969-08-22','7','1975-05-31',30),('31 ','1967-09-29','8','1985-11-24',31),('32 ','1965-04-15','6','1967-04-30',32),('33 ','1981-09-19','2','1996-03-10',33),('34 ','1969-11-16','3','1989-12-19',34),('35 ','1966-12-25','2','1977-01-17',35),('36 ','1976-09-16','4','2001-07-30',36),('37 ','1963-09-23','2','1960-06-09',37),('38 ','1992-10-03','0','2003-09-26',38),('39 ','1963-04-27','2','1975-04-06',39),('4 ','1999-08-06','5','1979-11-15',4),('40 ','1988-08-07','5','1966-04-17',40),('41 ','1979-10-29','6','1982-03-22',41),('42 ','1981-02-23','3','1995-08-07',42),('43 ','1960-11-11','1','1965-01-14',43),('44 ','1964-06-09','6','1964-10-21',44),('45 ','1976-07-10','6','1977-08-04',45),('46 ','1989-01-29','7','1982-08-15',46),('47 ','1959-08-16','7','1964-11-26',47),('48 ','1966-09-24','2','1969-05-04',48),('49 ','1975-09-08','2','1965-02-18',49),('5 ','2002-06-02','2','1966-07-23',5),('50 ','1992-03-23','6','1969-03-06',50),('6 ','1989-12-26','3','1969-05-15',6),('7 ','1980-08-20','9','1989-12-09',7),('8 ','1969-09-26','4','1978-09-04',8),('9 ','1998-04-15','1','1963-10-04',9);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `nom_producto` varchar(60) NOT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `dimension` varchar(15) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_categorias` int DEFAULT NULL,
  PRIMARY KEY (`nom_producto`),
  KEY `id_categorias` (`id_categorias`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_categorias`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('Aerodynamic Silk Wallet','Champlin-Barton','181gr','Aerodynamic Silk Walletpng',45.8,35),('Awesome Cotton Bench','Hermiston-Borer','138gr','Awesome Cotton Benchpng',36.1,32),('Awesome Leather Lamp','Cartwright Inc','159gr','Awesome Leather Lamppng',28.84,35),('Awesome Marble Plate','McClure and Sons','194gr','Awesome Marble Platepng',70.71,70),('Durable Wool Lamp','Rice, Kunze and Gulgowski','125gr','Durable Wool Lamppng',11.78,6),('Enormous Leather Hat','Schimmel and Sons','134gr','Enormous Leather Hatpng',70.75,28),('Enormous Plastic Shirt','Franecki and Sons','83gr','Enormous Plastic Shirtpng',6.03,19),('Ergonomic Aluminum Shoes','Bogisich-Watsica','165gr','Ergonomic Aluminum Shoespng',69.98,86),('Ergonomic Concrete Gloves','Rogahn-Stroman','100gr','Ergonomic Concrete Glovespng',77.84,8),('Ergonomic Iron Pants','Veum Group','53gr','Ergonomic Iron Pantspng',32.75,35),('Ergonomic Rubber Bag','Price-Feest','203gr','Ergonomic Rubber Bagpng',87.08,86),('Fantastic Linen Bench','Buckridge LLC','64gr','Fantastic Linen Benchpng',43.41,32),('Gorgeous Concrete Watch','Leffler-Nitzsche','60gr','Gorgeous Concrete Watchpng',93.22,18),('Heavy Duty Aluminum Car','Hudson Inc','157gr','Heavy Duty Aluminum Carpng',99.07,79),('Heavy Duty Bronze Gloves','Gleichner and Sons','147gr','Heavy Duty Bronze Glovespng',85.66,25),('Heavy Duty Concrete Lamp','Pfeffer-Hahn','171gr','Heavy Duty Concrete Lamppng',72.02,71),('Heavy Duty Iron Car','McClure-Rutherford','177gr','Heavy Duty Iron Carpng',49.87,29),('Heavy Duty Iron Table','Johnson, Olson and Koch','131gr','Heavy Duty Iron Tablepng',49.57,51),('Heavy Duty Wooden Gloves','Rosenbaum-Crist','231gr','Heavy Duty Wooden Glovespng',94.8,84),('Heavy Duty Wooden Shoes','Runte-Stoltenberg','238gr','Heavy Duty Wooden Shoespng',70.48,56),('Incredible Concrete Keyboard','Mills-Jast','69gr','Incredible Concrete Keyboardpng',57.06,18),('Incredible Cotton Watch','Crooks, Crona and Ondricka','121gr','Incredible Cotton Watchpng',30.03,21),('Incredible Iron Gloves','Bogisich-Emmerich','180gr','Incredible Iron Glovespng',89.43,86),('Incredible Wool Bench','Toy, Stehr and Morissette','143gr','Incredible Wool Benchpng',35.1,75),('Intelligent Cotton Coat','Fadel, Koelpin and Hegmann','240gr','Intelligent Cotton Coatpng',17.09,42),('Intelligent Steel Hat','Wintheiser, Zulauf and Kshlerin','215gr','Intelligent Steel Hatpng',46.11,53),('jamon','zenu','125gr','zenu.png',15.5,1),('Lightweight Granite Bottle','Heaney, Kuvalis and Kreiger','170gr','Lightweight Granite Bottlepng',31.64,53),('Mediocre Marble Watch','DuBuque and Sons','53gr','Mediocre Marble Watchpng',71.1,29),('Mediocre Wooden Shoes','Carter, Bechtelar and Abbott','99gr','Mediocre Wooden Shoespng',92.57,63),('Practical Aluminum Coat','Johns-Pouros','159gr','Practical Aluminum Coatpng',4.5,14),('Rustic Aluminum Clock','Cruickshank, Kuvalis and Marks','58gr','Rustic Aluminum Clockpng',14.58,51),('Rustic Linen Car','Mosciski-Wyman','121gr','Rustic Linen Carpng',66.07,79),('Rustic Plastic Keyboard','Muller, Hayes and Wyman','213gr','Rustic Plastic Keyboardpng',80.47,21),('Rustic Plastic Plate','Reichert, Kuphal and Lubowitz','177gr','Rustic Plastic Platepng',4.61,70),('Sleek Copper Keyboard','Wisozk-Kuphal','102gr','Sleek Copper Keyboardpng',47.98,69),('Sleek Cotton Watch','Kertzmann-Nader','88gr','Sleek Cotton Watchpng',75.74,18),('Sleek Iron Bench','Abernathy Group','120gr','Sleek Iron Benchpng',49.38,35),('Sleek Linen Shirt','Hickle and Sons','201gr','Sleek Linen Shirtpng',3.65,14),('Sleek Wool Lamp','Raynor, Littel and Veum','54gr','Sleek Wool Lamppng',81.98,2),('Small Silk Bottle','West, Ratke and Feeney','52gr','Small Silk Bottlepng',57.68,35),('Small Steel Gloves','Quitzon-O\'Connell','235gr','Small Steel Glovespng',33.48,88),('Small Steel Watch','Corwin-Roberts','108gr','Small Steel Watchpng',60.77,86),('Synergistic Leather Bottle','Rowe LLC','242gr','Synergistic Leather Bottlepng',91.4,29),('Synergistic Wool Watch','Orn-Champlin','210gr','Synergistic Wool Watchpng',20.14,63);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_proveedor`
--

DROP TABLE IF EXISTS `producto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_proveedor` (
  `razon_social` varchar(50) NOT NULL,
  `nombre_prod` varchar(60) NOT NULL,
  PRIMARY KEY (`razon_social`,`nombre_prod`),
  KEY `nombre_prod` (`nombre_prod`),
  CONSTRAINT `producto_proveedor_ibfk_1` FOREIGN KEY (`razon_social`) REFERENCES `proveedor` (`razon_social`),
  CONSTRAINT `producto_proveedor_ibfk_2` FOREIGN KEY (`nombre_prod`) REFERENCES `producto` (`nom_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_proveedor`
--

LOCK TABLES `producto_proveedor` WRITE;
/*!40000 ALTER TABLE `producto_proveedor` DISABLE KEYS */;
INSERT INTO `producto_proveedor` VALUES ('Kub, Gottlieb and Robel','Aerodynamic Silk Wallet'),('Stoltenberg-Gerhold','Aerodynamic Silk Wallet'),('Wiegand Group','Aerodynamic Silk Wallet'),('Beer-Cremin','Awesome Cotton Bench'),('Brekke-Greenfelder','Awesome Cotton Bench'),('Sawayn and Sons','Awesome Cotton Bench'),('Baumbach-McKenzie','Awesome Leather Lamp'),('Borer, Breitenberg and Lind','Awesome Leather Lamp'),('Cole Group','Awesome Leather Lamp'),('Kreiger-Dicki','Awesome Marble Plate'),('Runolfsson-Hintz','Awesome Marble Plate'),('VonRueden, Hand and Hartmann','Awesome Marble Plate'),('Jacobson Inc','Durable Wool Lamp'),('Legros, O\'Keefe and McClure','Durable Wool Lamp'),('Ondricka Inc','Durable Wool Lamp'),('Feest and Sons','Enormous Leather Hat'),('Jacobson Inc','Enormous Leather Hat'),('Towne-Friesen','Enormous Leather Hat'),('Stark, Hackett and Dickens','Enormous Plastic Shirt'),('Tromp-Cummerata','Enormous Plastic Shirt'),('VonRueden, Hand and Hartmann','Enormous Plastic Shirt'),('Becker, Grant and Tromp','Ergonomic Aluminum Shoes'),('Mosciski, Adams and Leffler','Ergonomic Aluminum Shoes'),('Wisozk-Schaden','Ergonomic Aluminum Shoes'),('Bednar, Vandervort and McClure','Ergonomic Concrete Gloves'),('Beer-Cremin','Ergonomic Concrete Gloves'),('Runte-Lebsack','Ergonomic Concrete Gloves'),('Pfannerstill-Cole','Ergonomic Iron Pants'),('Smith-Kuhlman','Ergonomic Iron Pants'),('Stroman-Johnston','Ergonomic Iron Pants'),('Borer, Breitenberg and Lind','Ergonomic Rubber Bag'),('DuBuque, Johnson and Metz','Ergonomic Rubber Bag'),('Runolfsdottir Inc','Ergonomic Rubber Bag'),('Gleason, Nitzsche and Heaney','Fantastic Linen Bench'),('Nolan Inc','Fantastic Linen Bench'),('Pfannerstill-Cole','Fantastic Linen Bench'),('Bruen-Lemke','Gorgeous Concrete Watch'),('Hamill-Schaden','Gorgeous Concrete Watch'),('Thiel-Murazik','Gorgeous Concrete Watch'),('Mosciski, Adams and Leffler','Heavy Duty Aluminum Car'),('Reichel-Robel','Heavy Duty Aluminum Car'),('Stroman-Johnston','Heavy Duty Aluminum Car'),('Runolfsdottir Inc','Heavy Duty Bronze Gloves'),('Runolfsson-Hintz','Heavy Duty Bronze Gloves'),('Stoltenberg-Gerhold','Heavy Duty Bronze Gloves'),('Gleason, Nitzsche and Heaney','Heavy Duty Concrete Lamp'),('Jaskolski and Sons','Heavy Duty Concrete Lamp'),('Towne-Friesen','Heavy Duty Concrete Lamp'),('Becker, Grant and Tromp','Heavy Duty Iron Car'),('Borer, Breitenberg and Lind','Heavy Duty Iron Car'),('Fahey, Rodriguez and Wintheiser','Heavy Duty Iron Car'),('Fahey, Rodriguez and Wintheiser','Heavy Duty Iron Table'),('Sawayn and Sons','Heavy Duty Iron Table'),('Willms, Wisozk and Schiller','Heavy Duty Iron Table'),('Smith-Kuhlman','Heavy Duty Wooden Gloves'),('Stark, Hackett and Dickens','Heavy Duty Wooden Gloves'),('Towne-Friesen','Heavy Duty Wooden Gloves'),('Becker, Grant and Tromp','Heavy Duty Wooden Shoes'),('Borer, Breitenberg and Lind','Heavy Duty Wooden Shoes'),('Pfannerstill-Cole','Heavy Duty Wooden Shoes'),('Gislason-Kuhlman','Incredible Concrete Keyboard'),('Runolfsdottir Inc','Incredible Concrete Keyboard'),('Tillman Inc','Incredible Concrete Keyboard'),('Beer-Cremin','Incredible Cotton Watch'),('Jacobson Inc','Incredible Cotton Watch'),('Tromp-Cummerata','Incredible Cotton Watch'),('Feest and Sons','Incredible Iron Gloves'),('Kub, Gottlieb and Robel','Incredible Iron Gloves'),('Waelchi-Morar','Incredible Iron Gloves'),('Mosciski, Adams and Leffler','Incredible Wool Bench'),('Stark, Hackett and Dickens','Incredible Wool Bench'),('Cummerata, Trantow and Crona','Intelligent Cotton Coat'),('Legros, O\'Keefe and McClure','Intelligent Cotton Coat'),('Bednar, Vandervort and McClure','Intelligent Steel Hat'),('Mosciski, Adams and Leffler','Intelligent Steel Hat'),('Lemke-Durgan','jamon'),('Towne-Friesen','jamon'),('Bednar, Vandervort and McClure','Lightweight Granite Bottle'),('Stark, Hackett and Dickens','Lightweight Granite Bottle'),('Beer-Cremin','Mediocre Marble Watch'),('Kub, Gottlieb and Robel','Mediocre Marble Watch'),('Cummerata, Trantow and Crona','Mediocre Wooden Shoes'),('Steuber-Ernser','Mediocre Wooden Shoes'),('Becker, Grant and Tromp','Practical Aluminum Coat'),('Jaskolski and Sons','Practical Aluminum Coat'),('DuBuque, Johnson and Metz','Rustic Aluminum Clock'),('Stroman-Johnston','Rustic Aluminum Clock'),('Hamill-Schaden','Rustic Linen Car'),('Steuber-Ernser','Rustic Linen Car'),('Baumbach-McKenzie','Rustic Plastic Keyboard'),('Runte-Lebsack','Rustic Plastic Keyboard'),('Reichel-Robel','Rustic Plastic Plate'),('Runte-Lebsack','Rustic Plastic Plate'),('Feest and Sons','Sleek Copper Keyboard'),('Thiel-Murazik','Sleek Copper Keyboard'),('Baumbach-McKenzie','Sleek Cotton Watch'),('Stoltenberg-Gerhold','Sleek Cotton Watch'),('Lemke-Durgan','Sleek Iron Bench'),('Wiegand Group','Sleek Iron Bench'),('Feil-Hagenes','Sleek Linen Shirt'),('Kub, Gottlieb and Robel','Sleek Linen Shirt'),('Gleason, Nitzsche and Heaney','Sleek Wool Lamp'),('Stroman-Johnston','Sleek Wool Lamp'),('Beer, Streich and Purdy','Small Silk Bottle'),('Ziemann, Torphy and Schimmel','Small Silk Bottle'),('Stark, Hackett and Dickens','Small Steel Gloves'),('VonRueden, Hand and Hartmann','Small Steel Gloves'),('Mosciski, Adams and Leffler','Small Steel Watch'),('Stoltenberg-Gerhold','Small Steel Watch'),('Jacobson Inc','Synergistic Leather Bottle'),('Ziemann, Torphy and Schimmel','Synergistic Leather Bottle'),('Sawayn and Sons','Synergistic Wool Watch'),('Stark, Hackett and Dickens','Synergistic Wool Watch');
/*!40000 ALTER TABLE `producto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `razon_social` varchar(50) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`razon_social`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('Auer-Jaskolski','(288) 306-0788','normand.schmidt@gmail.com'),('Baumbach-McKenzie','(679) 166-2986','maximo.kautzer@gmail.com'),('Becker, Grant and Tromp','922-790-3120','vilma.lockman@yahoo.com'),('Bednar, Vandervort and McClure','810.564.8915','kerry.zemlak@gmail.com'),('Beer-Cremin','(407) 098-1425','cyril.ohara@gmail.com'),('Beer, Streich and Purdy','1-222-109-9341','catrina.funk@gmail.com'),('Borer, Breitenberg and Lind','1-525-620-8257','louisa.williamson@gmail.com'),('Brekke-Greenfelder','726.790.6244','maxine.botsford@gmail.com'),('Bruen-Lemke','1-786-487-3894','minna.mclaughlin@hotmail.com'),('Cole Group','1-196-467-9252','titus.bednar@hotmail.com'),('Cummerata, Trantow and Crona','551-841-9879','bernita.muller@yahoo.com'),('DuBuque, Johnson and Metz','(537) 441-7307','owen.barrows@gmail.com'),('Fahey, Rodriguez and Wintheiser','1-415-088-0047','ellis.krajcik@hotmail.com'),('Feest and Sons','235.320.1850','donnell.kemmer@gmail.com'),('Feil-Hagenes','835-838-5732','bart.ruecker@gmail.com'),('Gislason-Kuhlman','(038) 994-9720','jerry.collins@hotmail.com'),('Gislason, Boyer and Volkman','529-056-2503','rubin.boyer@hotmail.com'),('Gleason, Nitzsche and Heaney','(521) 084-1259','alysha.nitzsche@yahoo.com'),('Hamill-Schaden','(124) 162-0243','quincy.waelchi@gmail.com'),('Herzog LLC','1-668-627-0595','brooke.larkin@yahoo.com'),('Jacobson Inc','603-568-5898','ka.corwin@yahoo.com'),('Jaskolski and Sons','610.129.3126','tynisha.ullrich@yahoo.com'),('Kreiger-Dicki','860-287-2230','christian.morar@yahoo.com'),('Kub, Gottlieb and Robel','1-546-792-9833','oren.schuster@yahoo.com'),('Legros, O\'Keefe and McClure','1-400-144-3495','robbyn.marquardt@gmail.com'),('Lemke-Durgan','919.594.2150','leo.feest@hotmail.com'),('Lueilwitz-Ankunding','600.822.1431','gil.witting@gmail.com'),('Mosciski, Adams and Leffler','240-142-1349','linnea.schamberger@gmail.com'),('Nolan Inc','024-820-7319','yvonne.moore@gmail.com'),('Ondricka Inc','684.795.5770','tana.kub@yahoo.com'),('Pfannerstill-Cole','940.292.4715','lakiesha.cartwright@hotmail.com'),('Reichel-Robel','635-747-7950','palmer.weber@gmail.com'),('Runolfsdottir Inc','(382) 838-6809','emil.brakus@yahoo.com'),('Runolfsson-Hintz','(333) 221-1841','kirk.kihn@yahoo.com'),('Runte-Lebsack','151-139-1563','roman.walker@hotmail.com'),('Sawayn and Sons','366.768.7727','arlyne.schuster@gmail.com'),('Smith-Kuhlman','(007) 662-1911','sabine.blick@yahoo.com'),('Stark, Hackett and Dickens','1-659-205-2429','annika.huels@hotmail.com'),('Steuber-Ernser','870.517.1445','delmer.durgan@yahoo.com'),('Stoltenberg-Gerhold','450.763.8547','savannah.harris@yahoo.com'),('Stroman-Johnston','777-978-2621','elodia.koelpin@yahoo.com'),('Thiel-Murazik','(961) 385-4836','china.keebler@gmail.com'),('Tillman Inc','1-727-988-6740','lucius.lebsack@yahoo.com'),('Towne-Friesen','(294) 492-8463','michiko.dietrich@yahoo.com'),('Tromp-Cummerata','(865) 973-3427','derrick.moen@yahoo.com'),('VonRueden, Hand and Hartmann','1-849-356-9385','lonnie.jerde@yahoo.com'),('Waelchi-Morar','(178) 378-7924','todd.mccullough@hotmail.com'),('Wiegand Group','(609) 806-6088','laurence.kris@hotmail.com'),('Willms, Wisozk and Schiller','(556) 116-2536','kris.schoen@hotmail.com'),('Wisozk-Schaden','496-831-9657','arron.funk@gmail.com'),('Ziemann, Torphy and Schimmel','045.981.1368','shizuko.olson@yahoo.com');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zona` (
  `cod_postal` varchar(15) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cod_postal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES ('02877-8529','Suite 497'),('05553','Apt. 355'),('08972-8761','Apt. 667'),('09747-9262','Apt. 773'),('10997-1229','Suite 549'),('12900-6966','Apt. 771'),('13635','Apt. 776'),('17014','Apt. 512'),('17904','Apt. 484'),('18330','Apt. 442'),('20595-7020','Suite 153'),('20903','Suite 008'),('22790-4821','Apt. 958'),('24515','Suite 597'),('26298','Suite 136'),('32318-2684','Suite 520'),('33651','Suite 615'),('35826-4363','Apt. 041'),('40860-0814','Apt. 854'),('41216-9393','Suite 039'),('41674-6659','Apt. 853'),('42521','Suite 395'),('43463','Apt. 758'),('48001','Suite 876'),('48126','Apt. 583'),('48458-0362','Apt. 854'),('52372','Suite 470'),('55799','Suite 404'),('55939','Apt. 639'),('56679-6864','Suite 831'),('60065','Suite 218'),('60608','Apt. 782'),('61032-3674','Suite 398'),('62594-2180','Apt. 736'),('70437','Suite 498'),('70802-7699','Apt. 469'),('72192','Apt. 084'),('76413-2714','Apt. 287'),('76812-0965','Apt. 758'),('80526-5183','Suite 193'),('82663-9115','Suite 756'),('83411-1246','Suite 915'),('84469','Suite 261'),('87656','Apt. 502'),('88528-3719','Suite 688'),('88590-3139','Apt. 727'),('91005-1468','Suite 012'),('93062-3820','Apt. 492'),('93989-2952','Apt. 308'),('95599-7984','Suite 170');
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19 16:31:06
