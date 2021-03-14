-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: air_management_system
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `factory_serial_number` varchar(255) DEFAULT NULL,
  `flight_distance` bigint NOT NULL,
  `fuel_capacity` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_of_flights` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `air_company_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp9yob98tmyb901cnu35k9uy43` (`air_company_id`),
  CONSTRAINT `FKp9yob98tmyb901cnu35k9uy43` FOREIGN KEY (`air_company_id`) REFERENCES `air_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (1,'Europe','1432F',10000,1000,'string',0,'string',1),(2,'Europe','1456FF',10000,1000,'QWE-1',0,'passenger\'s',2),(3,'Europe','Ф556FF',110000,20000,'TTT-1',0,'passenger\'s',3),(4,'Europe','Rff56FF',110000,20000,'ASD-1',0,'passenger\'s',4),(5,'Europe','RT8',110000,20000,'ABC-03',0,'passenger\'s',5),(6,'Europe','QWE90',110000,20000,'WWWW-04',0,'passenger\'s',4),(7,'Europe','ZZZ06',110000,20000,'ANN-04',0,'passenger\'s',3),(8,'Europe','ZZZ06',110000,20000,'ANN-04',0,'passenger\'s',1);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-14 17:49:45
