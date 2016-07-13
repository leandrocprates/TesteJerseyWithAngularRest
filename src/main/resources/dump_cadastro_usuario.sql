CREATE DATABASE  IF NOT EXISTS `teste_peopleway` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `teste_peopleway`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: teste_peopleway
-- ------------------------------------------------------
-- Server version	5.5.45

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
-- Table structure for table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idade` tinyint(1) NOT NULL,
  `data_cad` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES (1,'leandro',32,'2016-09-21 00:00:00'),(2,'leandro 2',43,'2016-09-21 00:00:00'),(3,'leandro 3',21,'2019-09-12 00:00:00'),(4,'leandro4',43,'2018-09-21 00:00:00'),(5,'vdsvdv',12,'2010-08-23 00:00:00'),(6,'leandro 6',21,'2019-09-12 00:00:00'),(7,'leandro prates',60,'2020-12-03 00:00:00'),(8,'leandro 33',41,'2015-12-21 00:00:00');
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_candidato`
--

DROP TABLE IF EXISTS `dados_candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_candidato` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_candidato` int(10) unsigned NOT NULL,
  `endereco` text NOT NULL,
  `pretensao_salario` double NOT NULL,
  `telefone_fixo` bigint(20) unsigned NOT NULL,
  `telefone_celular` bigint(20) unsigned NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dados_candidato` (`id_candidato`),
  CONSTRAINT `FK_dados_candidato` FOREIGN KEY (`id_candidato`) REFERENCES `candidato` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_candidato`
--

LOCK TABLES `dados_candidato` WRITE;
/*!40000 ALTER TABLE `dados_candidato` DISABLE KEYS */;
INSERT INTO `dados_candidato` VALUES (1,6,'endereco teste',2233,1144556677,1122334455,'vazio'),(2,8,'paulista 2585',7485,1147859658,1198745214,'vazio');
/*!40000 ALTER TABLE `dados_candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'teste_peopleway'
--

--
-- Dumping routines for database 'teste_peopleway'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-13 11:40:08
