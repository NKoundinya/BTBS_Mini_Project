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
-- Table structure for table `seatallocation`
--

DROP TABLE IF EXISTS `seatallocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seatallocation` (
  `seatId` varchar(20) NOT NULL,
  `serviceid` varchar(20) DEFAULT NULL,
  `source` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`seatId`),
  KEY `FK77dqawa6sjjpbamdl6am7amq8` (`serviceid`),
  CONSTRAINT `FK77dqawa6sjjpbamdl6am7amq8` FOREIGN KEY (`serviceid`) REFERENCES `busservice` (`serviceid`),
  CONSTRAINT `seatallocation_ibfk_1` FOREIGN KEY (`serviceid`) REFERENCES `busservice` (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatallocation`
--

LOCK TABLES `seatallocation` WRITE;
/*!40000 ALTER TABLE `seatallocation` DISABLE KEYS */;
INSERT INTO `seatallocation` VALUES ('SBus101-1','SERBUS101','A','B',50),('SBus101-2','SERBUS102','A','B',50),('SBus102-1','SERBUS101','B','C',50),('SBus102-2','SERBUS102','B','C',50),('SBus103-1','SERBUS101','C','D',50),('SBus103-2','SERBUS102','C','D',50),('SBus104-1','SERBUS101','D','E',50),('SBus104-2','SERBUS102','D','E',50),('SBus201-1','SERBUS201','A','B',48),('SBus201-2','SERBUS202','A','B',50),('SBus202-1','SERBUS201','B','C',50),('SBus202-2','SERBUS202','B','C',50),('SBus203-1','SERBUS201','C','D',50),('SBus203-2','SERBUS202','C','D',50),('SBus204-1','SERBUS201','D','E',50),('SBus204-2','SERBUS202','D','E',50),('SBus301-1','SERBUS301','Hi-Tech','Nalgonda',50),('SBus301-2','SERBUS302','Hi-Tech','Nalgonda',50),('SBus302-1','SERBUS301','Nalgonda','Suryapet',50),('SBus302-2','SERBUS302','Nalgonda','Suryapet',50),('SBus303-1','SERBUS301','Suryapet','Miryalaguda',50),('SBus303-2','SERBUS302','Suryapet','Miryalaguda',50),('SBus304-1','SERBUS301','Miryalaguda','Vijayawada',50),('SBus304-2','SERBUS302','Miryalaguda','Vijayawada',50),('SBus401-1','SERBUS401','Hi-Tech','Nalgonda',50),('SBus401-2','SERBUS402','Hi-Tech','Nalgonda',50),('SBus402-1','SERBUS401','Nalgonda','Suryapet',50),('SBus402-2','SERBUS402','Nalgonda','Suryapet',50),('SBus403-1','SERBUS401','Suryapet','Miryalaguda',50),('SBus403-2','SERBUS402','Suryapet','Miryalaguda',50),('SBus404-1','SERBUS401','Miryalaguda','Vizag',50),('SBus404-2','SERBUS402','Miryalaguda','Vizag',50);
/*!40000 ALTER TABLE `seatallocation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 12:49:32
