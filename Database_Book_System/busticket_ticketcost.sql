-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: busticket
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ticketcost`
--

DROP TABLE IF EXISTS `ticketcost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticketcost` (
  `costId` varchar(20) NOT NULL,
  `source` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `busId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`costId`),
  KEY `FK3sdm5i8h6o2tp2xo3bdkmisvk` (`busId`),
  CONSTRAINT `FK3sdm5i8h6o2tp2xo3bdkmisvk` FOREIGN KEY (`busId`) REFERENCES `bus` (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketcost`
--

LOCK TABLES `ticketcost` WRITE;
/*!40000 ALTER TABLE `ticketcost` DISABLE KEYS */;
INSERT INTO `ticketcost` VALUES ('CBus101','A','B',100,'Bus1'),('CBus102','B','C',100,'Bus1'),('CBus103','C','D',100,'Bus1'),('CBus104','D','E',100,'Bus1'),('CBus201','A','B',50,'Bus2'),('CBus202','B','C',50,'Bus2'),('CBus203','C','D',50,'Bus2'),('CBus204','D','E',50,'Bus2'),('CBus301','Hi-Tech','Nalgonda',100,'Bus3'),('CBus302','Nalgonda','Suryapet',100,'Bus3'),('CBus303','Suryapet','Miryalaguda',100,'Bus3'),('CBus304','Miryalaguda','Vijayawada',100,'Bus3'),('CBus401','Hi-Tech','Nalgonda',100,'Bus4'),('CBus402','Nalgonda','Suryapet',100,'Bus4'),('CBus403','Suryapet','Miryalaguda',100,'Bus4'),('CBus404','Miryalaguda','Vizag',100,'Bus4');
/*!40000 ALTER TABLE `ticketcost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 12:49:34
