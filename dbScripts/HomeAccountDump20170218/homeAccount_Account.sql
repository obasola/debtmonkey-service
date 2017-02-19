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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) NOT NULL,
  `original_balance` double DEFAULT NULL,
  `current_balance` double DEFAULT NULL,
  `date_last_payment` date DEFAULT NULL,
  `date_opened` date DEFAULT NULL,
  `date_closed` date DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `Account_Type_Id` int(11) NOT NULL,
  `auto_payment` tinyint(4) DEFAULT NULL,
  `User_account_id` int(11) DEFAULT NULL,
  `Account_Address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Acct_Type` (`Account_Type_Id`),
  KEY `fk_Account_User_Account1_idx` (`User_account_id`),
  KEY `fk_Account_Address_idx` (`Account_Address_id`),
  CONSTRAINT `FK_Acct_Type` FOREIGN KEY (`Account_Type_Id`) REFERENCES `Account_Type` (`id`),
  CONSTRAINT `fk_Account_Address` FOREIGN KEY (`Account_Address_id`) REFERENCES `Account_Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account_User_Account1` FOREIGN KEY (`User_account_id`) REFERENCES `User_Account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1,'Wayfair',1653.99,1271,'2016-11-17','2016-04-27',NULL,'2016-09-05 16:25:09','2017-02-12 17:49:32',13,1,1,NULL),(2,'Merrick Bank',1600,461.41,'2016-11-24','2014-12-28',NULL,'2016-09-05 19:55:00','2017-02-12 17:49:56',11,NULL,1,NULL),(3,'Blaze Bank',500,123.45,'2016-11-26','2015-02-27',NULL,'2016-09-05 19:55:00','2017-02-12 17:50:05',11,NULL,1,NULL),(4,'First Savings Bank',2500,0,'2017-02-13','2014-09-23',NULL,'2016-09-05 19:55:00','2017-02-12 17:50:13',11,NULL,1,NULL),(5,'Emblem CC',1925,899.95,'2016-11-10','2013-08-28',NULL,'2016-09-05 19:55:00','2017-02-12 17:50:29',11,NULL,1,NULL),(6,'CapitalOne MC',800,0,'2016-10-31','2014-12-29',NULL,'2016-09-05 20:09:13','2017-02-12 17:50:39',11,NULL,1,NULL),(7,'CapitalOne QuickSilver',2500,1254.56,'2016-11-16','2014-12-29',NULL,'2016-09-05 20:09:13','2017-02-12 17:50:51',11,NULL,1,NULL),(8,'Nissan Motors',25800,14450,'2016-11-08','2016-02-25','2016-12-29','2016-09-05 20:12:07','2017-02-12 17:51:17',14,NULL,1,NULL),(9,'Lending Group',14500,7825,'2016-11-16','2015-05-28',NULL,'2016-09-05 20:12:07','2017-02-12 17:51:29',15,NULL,1,NULL),(10,'Citi Bank',500,77.59,'2016-11-12','2016-07-18',NULL,'2016-09-06 17:04:48','2017-02-18 10:50:49',11,NULL,1,1),(11,'FedLoan',150000,143900,'2016-11-14','2005-12-29',NULL,'2016-09-11 15:10:40','2017-02-12 17:51:47',16,NULL,1,NULL),(12,'Lending Group (acct2)',14000,14000,NULL,'2016-11-27',NULL,'2016-12-03 10:35:43','2017-02-12 17:51:57',15,NULL,1,NULL),(13,'Ally Car Refinance',16500,16500,NULL,'2016-12-29',NULL,'2017-01-08 11:32:41','2017-02-12 17:52:07',14,NULL,1,NULL);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `homeAccount`.`Account_BEFORE_INSERT` BEFORE INSERT ON `Account` FOR EACH ROW
BEGIN
   SET NEW.date_created = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `homeAccount`.`Account_BEFORE_UPDATE` BEFORE UPDATE ON `Account` FOR EACH ROW
BEGIN
   SET NEW.date_modified = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-18 21:22:23
