-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: busticket
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `busservice`
--

DROP TABLE IF EXISTS `busservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busservice` (
  `serviceid` varchar(20) NOT NULL,
  `busid` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`serviceid`),
  KEY `FKliguaplpok8sxx5t3jo2udedx` (`busid`),
  CONSTRAINT `FKliguaplpok8sxx5t3jo2udedx` FOREIGN KEY (`busid`) REFERENCES `bus` (`busid`),
  CONSTRAINT `busservice_ibfk_1` FOREIGN KEY (`busid`) REFERENCES `bus` (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busservice`
--

LOCK TABLES `busservice` WRITE;
/*!40000 ALTER TABLE `busservice` DISABLE KEYS */;
INSERT INTO `busservice` VALUES ('SERBUS101','Bus1','2019-08-23'),('SERBUS102','Bus1','2019-08-24'),('SERBUS201','Bus2','2019-08-27'),('SERBUS202','Bus2','2019-08-31'),('SERBUS301','Bus3','2019-08-24'),('SERBUS302','Bus3','2019-08-25'),('SERBUS401','Bus4','2019-08-26'),('SERBUS402','Bus4','2019-08-24'),('SERBUS501','Bus5','2019-08-31'),('SERBUS502','Bus5','2019-09-01'),('SERBUS601','Bus6','2019-08-25'),('SERBUS602','Bus6','2019-08-26');
/*!40000 ALTER TABLE `busservice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-30 16:39:28
