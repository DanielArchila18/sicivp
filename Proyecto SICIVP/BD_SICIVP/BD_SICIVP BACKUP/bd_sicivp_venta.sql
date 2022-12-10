CREATE DATABASE  IF NOT EXISTS `bd_sicivp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_sicivp`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_sicivp
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `Id_Detalle_Venta` bigint NOT NULL AUTO_INCREMENT,
  `Cantidad` bigint DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Total` bigint DEFAULT NULL,
  `Fk_Comprobante_Venta` bigint DEFAULT NULL,
  `Fk_Pedidos` bigint DEFAULT NULL,
  `Fk_Persona` bigint DEFAULT NULL,
  `Fk_Producto` bigint DEFAULT NULL,
  `Fk_Rol` bigint DEFAULT NULL,
  PRIMARY KEY (`Id_Detalle_Venta`),
  KEY `FK_Venta_Fk_Persona` (`Fk_Persona`),
  KEY `FK_Venta_Fk_Pedidos` (`Fk_Pedidos`),
  KEY `FK_Venta_Fk_Rol` (`Fk_Rol`),
  KEY `FK_Venta_Fk_Producto` (`Fk_Producto`),
  KEY `FK_Venta_Fk_Comprobante_Venta` (`Fk_Comprobante_Venta`),
  CONSTRAINT `FK_Venta_Fk_Comprobante_Venta` FOREIGN KEY (`Fk_Comprobante_Venta`) REFERENCES `comprobantes_ventas` (`Id_Comprobante_Venta`),
  CONSTRAINT `FK_Venta_Fk_Pedidos` FOREIGN KEY (`Fk_Pedidos`) REFERENCES `pedidos` (`Id_Domicilio`),
  CONSTRAINT `FK_Venta_Fk_Persona` FOREIGN KEY (`Fk_Persona`) REFERENCES `personas` (`Id_Persona`),
  CONSTRAINT `FK_Venta_Fk_Producto` FOREIGN KEY (`Fk_Producto`) REFERENCES `productos` (`Id_Producto`),
  CONSTRAINT `FK_Venta_Fk_Rol` FOREIGN KEY (`Fk_Rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,5,'2022-09-24 07:44:36',100000,1,NULL,NULL,1,NULL),(2,10,'2022-09-24 07:45:25',200000,3,2,NULL,1,NULL),(3,10,'2022-09-24 11:42:14',200000,4,5,NULL,1,NULL),(4,12,'2022-09-24 14:51:35',240000,5,NULL,NULL,1,NULL),(5,4,'2022-09-24 17:03:05',80000,6,NULL,NULL,1,NULL),(6,12,'2022-09-24 17:05:10',240000,7,9,NULL,1,NULL),(7,12,'2022-09-24 17:06:26',240000,8,10,NULL,1,NULL),(8,3,'2022-09-24 21:46:15',60000,9,13,NULL,1,NULL),(9,5,'2022-09-25 18:26:45',100000,10,14,NULL,3,NULL),(10,5,'2022-09-25 18:27:31',100000,11,15,NULL,3,NULL),(11,5,'2022-09-25 18:32:23',100000,13,NULL,NULL,3,NULL),(12,2,'2022-09-25 18:32:30',40000,13,NULL,NULL,1,NULL),(13,2,'2022-09-25 18:33:17',40000,14,NULL,NULL,1,NULL),(14,5,'2022-09-25 18:38:37',150000,15,NULL,NULL,4,NULL),(15,5,'2022-09-25 18:45:41',100000,16,18,NULL,3,NULL),(16,8,'2022-09-25 19:33:13',160000,17,NULL,NULL,3,NULL),(17,8,'2022-09-25 20:02:38',160000,18,NULL,NULL,1,NULL),(18,8,'2022-09-25 20:07:51',160000,19,NULL,NULL,3,NULL),(19,5,'2022-09-25 20:10:02',150000,20,23,NULL,4,NULL),(20,1,'2022-09-25 20:10:11',20000,20,23,NULL,3,NULL),(21,10,'2022-09-25 20:29:59',500000,21,NULL,NULL,6,NULL),(22,5,'2022-09-25 20:34:58',100000,22,NULL,NULL,5,NULL),(23,7,'2022-09-25 20:37:06',140000,23,27,NULL,5,NULL),(24,5,'2022-09-26 06:36:10',100000,24,28,NULL,1,NULL),(25,5,'2022-09-26 06:36:43',150000,25,29,NULL,4,NULL),(26,5,'2022-09-26 06:39:10',100000,26,30,NULL,3,NULL),(27,3,'2022-09-26 08:56:25',60000,28,32,NULL,1,NULL),(28,3,'2022-09-26 08:57:13',90000,29,33,NULL,4,NULL),(29,5,'2022-09-26 08:57:20',100000,29,33,NULL,1,NULL),(30,7,'2022-09-26 08:57:36',140000,29,33,NULL,5,NULL),(31,7,'2022-09-26 08:59:30',140000,30,NULL,NULL,3,NULL),(32,0,'2022-09-26 08:59:40',0,30,NULL,NULL,3,NULL),(33,30,'2022-09-26 09:07:10',600000,32,NULL,NULL,7,NULL),(34,1,'2022-09-26 09:07:25',30000,32,NULL,NULL,4,NULL),(35,12,'2022-10-08 18:12:11',240000,37,NULL,NULL,1,NULL),(36,10,NULL,200000,41,NULL,NULL,1,NULL),(37,10,NULL,200000,42,NULL,NULL,1,NULL),(38,10,NULL,200000,43,NULL,NULL,1,NULL),(39,10,NULL,200000,44,NULL,NULL,1,NULL),(40,10,NULL,200000,45,NULL,NULL,1,NULL),(41,10,NULL,200000,46,NULL,NULL,1,NULL),(42,10,NULL,200000,47,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-10 16:37:42