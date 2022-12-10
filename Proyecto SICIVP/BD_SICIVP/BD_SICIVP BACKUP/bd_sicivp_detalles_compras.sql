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
-- Table structure for table `detalles_compras`
--

DROP TABLE IF EXISTS `detalles_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_compras` (
  `Id_Detalle_Compra` bigint NOT NULL AUTO_INCREMENT,
  `Cantidad` int DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Total` int DEFAULT NULL,
  `Fk_Orden_Compra` bigint DEFAULT NULL,
  `Fk_Persona` bigint DEFAULT NULL,
  `Fk_Producto` bigint DEFAULT NULL,
  `Fk_Proveedor` bigint DEFAULT NULL,
  `Fk_Rol` bigint DEFAULT NULL,
  PRIMARY KEY (`Id_Detalle_Compra`),
  KEY `FK_Detalles_Compras_Fk_Orden_Compra` (`Fk_Orden_Compra`),
  KEY `FK_Detalles_Compras_Fk_Producto` (`Fk_Producto`),
  KEY `FK_Detalles_Compras_Fk_Proveedor` (`Fk_Proveedor`),
  KEY `FK_Detalles_Compras_Fk_Rol` (`Fk_Rol`),
  KEY `FK_Detalles_Compras_Fk_Persona` (`Fk_Persona`),
  CONSTRAINT `FK_Detalles_Compras_Fk_Orden_Compra` FOREIGN KEY (`Fk_Orden_Compra`) REFERENCES `ordenes_compras` (`Id_Compra`),
  CONSTRAINT `FK_Detalles_Compras_Fk_Persona` FOREIGN KEY (`Fk_Persona`) REFERENCES `personas` (`Id_Persona`),
  CONSTRAINT `FK_Detalles_Compras_Fk_Producto` FOREIGN KEY (`Fk_Producto`) REFERENCES `productos` (`Id_Producto`),
  CONSTRAINT `FK_Detalles_Compras_Fk_Proveedor` FOREIGN KEY (`Fk_Proveedor`) REFERENCES `proveedores` (`Id_Proveedor`),
  CONSTRAINT `FK_Detalles_Compras_Fk_Rol` FOREIGN KEY (`Fk_Rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_compras`
--

LOCK TABLES `detalles_compras` WRITE;
/*!40000 ALTER TABLE `detalles_compras` DISABLE KEYS */;
INSERT INTO `detalles_compras` VALUES (1,100,'2022-09-24 07:41:48',0,1,NULL,1,NULL,NULL),(2,5,'2022-09-24 17:04:17',0,3,NULL,1,NULL,NULL),(3,60,'2022-09-24 22:00:56',0,4,NULL,3,NULL,NULL),(4,100,'2022-09-25 18:37:27',0,5,NULL,4,NULL,NULL),(5,100,'2022-09-25 20:03:55',0,7,NULL,5,NULL,NULL),(6,45,'2022-09-25 20:27:47',0,8,NULL,6,NULL,NULL),(7,100,'2022-09-26 09:04:40',0,9,NULL,7,NULL,NULL),(8,50,'2022-09-26 09:04:53',0,9,NULL,4,NULL,NULL),(9,100,'2022-10-09 07:55:54',0,10,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `detalles_compras` ENABLE KEYS */;
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
