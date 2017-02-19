CREATE DATABASE  IF NOT EXISTS `homeAccount` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `homeAccount`;
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
-- Table structure for table `Payment_Schedule`
--

DROP TABLE IF EXISTS `Payment_Schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payment_Schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `next_payment_due` date DEFAULT NULL,
  `balance_due` double DEFAULT NULL,
  `Account_id` int(11) NOT NULL,
  `auto_payment` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Payment_Schedule_Account1_idx` (`Account_id`),
  CONSTRAINT `fk_Payment_Schedule_Account1` FOREIGN KEY (`Account_id`) REFERENCES `Account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment_Schedule`
--

LOCK TABLES `Payment_Schedule` WRITE;
/*!40000 ALTER TABLE `Payment_Schedule` DISABLE KEYS */;
INSERT INTO `Payment_Schedule` VALUES (1,'2016-11-20',46,1,NULL),(2,'2016-11-16',771.18,11,1),(3,'2016-12-14',458.9,8,1),(4,'2016-11-20',458.85,9,1),(5,'2016-11-26',40,2,1),(6,'2016-12-23',45.75,4,1),(7,'2016-12-07',50,5,NULL),(8,'2016-11-16',244.69,10,1),(9,'2016-10-28',60,3,1),(10,'2016-11-28',29,6,1),(11,'2016-11-18',150,7,0),(12,'2017-01-11',303.15,13,1);
/*!40000 ALTER TABLE `Payment_Schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-18 21:22:24
