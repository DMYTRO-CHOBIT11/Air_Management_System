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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `delay_started_at` datetime(6) DEFAULT NULL,
  `departure_country` varchar(255) DEFAULT NULL,
  `destination_country` varchar(255) DEFAULT NULL,
  `distance` int NOT NULL,
  `ended_at` datetime(6) DEFAULT NULL,
  `estimated_flight_time` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `air_company_id` bigint DEFAULT NULL,
  `airplane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKebvst1vfvhmhgn73mqs1vt8m7` (`air_company_id`),
  KEY `FKb8t4272gfgo1feyyidvscbjm0` (`airplane_id`),
  CONSTRAINT `FKb8t4272gfgo1feyyidvscbjm0` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`id`),
  CONSTRAINT `FKebvst1vfvhmhgn73mqs1vt8m7` FOREIGN KEY (`air_company_id`) REFERENCES `air_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'2021-03-07 15:31:24.673000','2021-03-11 19:50:14.361000','Ukraine','Italy',1000,'2021-03-11 15:31:24.673000',10,'DELAYED',1,1),(2,'2021-03-08 15:31:24.673000','2021-03-09 15:31:24.673000','Latvia','Italy',10000,'2021-03-11 15:31:24.673000',6,'COMPLETED',1,1),(3,'2021-03-05 15:31:24.673000','2021-03-04 15:31:24.673000','Italy','Ukraine',10000,'2021-03-11 15:31:24.673000',10,'PENDING',2,2),(4,'2021-03-08 15:31:24.673000','2021-03-10 15:31:24.673000','USA','Ukraine',100000,'2021-03-11 15:31:24.673000',14,'DELAYED',3,3),(5,'2021-03-10 15:31:24.673000','2021-03-11 11:31:24.673000','Ukraine','USA',100000,'2021-03-11 15:31:24.673000',14,'ACTIVE',4,4),(6,'2021-03-04 15:31:24.673000','2021-03-05 15:31:24.673000','Italy','USA',90000,'2021-03-11 15:31:24.673000',12,'PENDING',5,5);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
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
