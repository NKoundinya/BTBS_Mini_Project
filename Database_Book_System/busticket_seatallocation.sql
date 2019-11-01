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
-- Table structure for table `seatallocation`
--

DROP TABLE IF EXISTS `seatallocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatallocation`
--

LOCK TABLES `seatallocation` WRITE;
/*!40000 ALTER TABLE `seatallocation` DISABLE KEYS */;
INSERT INTO `seatallocation` VALUES ('SBus101-1','SERBUS101','A','B',42),('SBus101-2','SERBUS102','A','B',50),('SBus102-1','SERBUS101','B','C',43),('SBus102-2','SERBUS102','B','C',50),('SBus103-1','SERBUS101','C','D',43),('SBus103-2','SERBUS102','C','D',50),('SBus104-1','SERBUS101','D','E',45),('SBus104-2','SERBUS102','D','E',50),('SBus201-1','SERBUS201','A','B',47),('SBus201-2','SERBUS202','A','B',50),('SBus202-1','SERBUS201','B','C',47),('SBus202-2','SERBUS202','B','C',50),('SBus203-1','SERBUS201','C','D',47),('SBus203-2','SERBUS202','C','D',50),('SBus204-1','SERBUS201','D','E',47),('SBus204-2','SERBUS202','D','E',50),('SBus301-1','SERBUS301','Hi-Tech','Nalgonda',40),('SBus301-2','SERBUS302','Hi-Tech','Nalgonda',46),('SBus302-1','SERBUS301','Nalgonda','Suryapet',40),('SBus302-2','SERBUS302','Nalgonda','Suryapet',46),('SBus303-1','SERBUS301','Suryapet','Miryalaguda',40),('SBus303-2','SERBUS302','Suryapet','Miryalaguda',46),('SBus304-1','SERBUS301','Miryalaguda','Vijayawada',40),('SBus304-2','SERBUS302','Miryalaguda','Vijayawada',46),('SBus401-1','SERBUS401','Hi-Tech','Nalgonda',50),('SBus401-2','SERBUS402','Hi-Tech','Nalgonda',49),('SBus402-1','SERBUS401','Nalgonda','Suryapet',50),('SBus402-2','SERBUS402','Nalgonda','Suryapet',49),('SBus403-1','SERBUS401','Suryapet','Miryalaguda',50),('SBus403-2','SERBUS402','Suryapet','Miryalaguda',49),('SBus404-1','SERBUS401','Miryalaguda','Vizag',50),('SBus404-2','SERBUS402','Miryalaguda','Vizag',49),('SBus501-1','SERBUS501','Hi-Tech','Nalgonda',46),('SBus501-2','SERBUS501','Nalgonda','Suryapet',42),('SBus501-3','SERBUS501','Suryapet','Miryalaguda',46),('SBus501-4','SERBUS501','Miryalaguda','Vijayawada',50),('SBus502-1','SERBUS502','Hi-Tech','Nalgonda',50),('SBus502-2','SERBUS502','Nalgonda','Suryapet',50),('SBus502-3','SERBUS502','Suryapet','Miryalaguda',50),('SBus502-4','SERBUS502','Miryalaguda','Vijayawada',50),('SBus601-1','SERBUS601','Hi-Tech','Nalgonda',49),('SBus601-2','SERBUS601','Nalgonda','Suryapet',49),('SBus601-3','SERBUS601','Suryapet','Miryalaguda',49),('SBus601-4','SERBUS601','Miryalaguda','Vizag',49),('SBus602-1','SERBUS602','Hi-Tech','Nalgonda',50),('SBus602-2','SERBUS602','Nalgonda','Suryapet',50),('SBus602-3','SERBUS602','Suryapet','Miryalaguda',50),('SBus602-4','SERBUS602','Miryalaguda','Vizag',50);
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

-- Dump completed on 2019-08-30 16:39:28
