-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: homeAccount
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `Payment_History`
--

DROP TABLE IF EXISTS `Payment_History`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payment_History` (
  `idPayment_History` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` double NOT NULL,
  `date_paid` date NOT NULL,
  `date_modified` datetime DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `Account_id` int(11) NOT NULL,
  PRIMARY KEY (`idPayment_History`),
  KEY `fk_Payment_History_Account1_idx` (`Account_id`),
  CONSTRAINT `fk_Payment_History_Account1` FOREIGN KEY (`Account_id`) REFERENCES `Account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment_History`
--

LOCK TABLES `Payment_History` WRITE;
/*!40000 ALTER TABLE `Payment_History` DISABLE KEYS */;
INSERT INTO `Payment_History` VALUES (1,50,'2016-10-07',NULL,NULL,1),(2,50,'2016-11-07',NULL,NULL,1),(5,127.55,'2016-09-28',NULL,'2016-11-24 09:17:38',3),(6,50,'2016-11-21',NULL,'2016-11-24 13:35:33',5),(7,39,'2016-10-27',NULL,'2016-11-24 13:45:19',2),(8,40,'2016-11-27',NULL,'2016-11-24 13:47:03',2);
/*!40000 ALTER TABLE `Payment_History` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-26 11:20:34
