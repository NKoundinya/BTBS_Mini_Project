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
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `idProof` varchar(255) DEFAULT NULL,
  `seats` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `journey_serviceId` varchar(255) DEFAULT NULL,
  `source` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `pnr` varchar(100) NOT NULL,
  PRIMARY KEY (`pnr`),
  KEY `FKof6jlvagg91lru2cg4kajssov` (`journey_serviceId`),
  CONSTRAINT `FKof6jlvagg91lru2cg4kajssov` FOREIGN KEY (`journey_serviceId`) REFERENCES `busservice` (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('123456712345',1,'Koundin','SERBUS101','A','E','TSERBUS101Cn45'),('123123456456',1,'Maneesh','SERBUS101','A','B','TSERBUS101cW60'),('098765142312',1,'Luqman','SERBUS101','D','E','TSERBUS101gh40'),('111222333444',3,'Harsha','SERBUS101','A','E','TSERBUS101hq62'),('123098123098',1,'Luqman','SERBUS101','A','D','TSERBUS101IB44'),('123456123456',2,'Koundin','SERBUS101','A','D','TSERBUS101tl70'),('098564712341',3,'Sahit','SERBUS201','A','E','TSERBUS201WM69'),('100023010287',3,'Harsha Raj','SERBUS301','Hi-Tech','Vijayawada','TSERBUS301DM98'),('019882725361',3,'Rakesh','SERBUS301','Hi-Tech','Vijayawada','TSERBUS301HK68'),('019191888272',4,'Akkineni','SERBUS301','Hi-Tech','Vijayawada','TSERBUS301Id82'),('111222555777',4,'Suri','SERBUS302','Hi-Tech','Vijayawada','TSERBUS302vj20'),('123444316662',1,'Shravya','SERBUS402','Hi-Tech','Vizag','TSERBUS402WQ57'),('291231234531',4,'Naveen','SERBUS501','Hi-Tech','Miryalaguda','TSERBUS501Rr43'),('123123456456',4,'Aravind','SERBUS501','Nalgonda','Suryapet','TSERBUS501yy47'),('111222333111',1,'Suribabu','SERBUS601','Hi-Tech','Vizag','TSERBUS601LN24');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-30 16:39:27
