-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: penjualan
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang` (
  `kd_brg` char(6) COLLATE utf8mb4_general_ci NOT NULL,
  `nm_brg` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `satuan` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `harga_jual` double DEFAULT '0',
  `harga_beli` double DEFAULT '0',
  `stok` int DEFAULT NULL,
  `stok_min` int DEFAULT NULL,
  PRIMARY KEY (`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES ('LP0001','Laptop ASUS','Laptop',8500000,7500000,10,1),('LP0002','Laptop Lenovo','Laptop',7000000,6000000,15,1),('LP001','Laptop ASUS','Laptop',8500000,7500000,15,2),('LP002','Dell Latitude 3410','Laptop',5000000,4300000,10,1);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beli`
--

DROP TABLE IF EXISTS `beli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beli` (
  `no_beli` varchar(50) NOT NULL,
  `kd_sup` char(6) NOT NULL,
  `tgl_beli` date DEFAULT NULL,
  `jenis` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`no_beli`),
  KEY `kd_sup` (`kd_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beli`
--

LOCK TABLES `beli` WRITE;
/*!40000 ALTER TABLE `beli` DISABLE KEYS */;
INSERT INTO `beli` VALUES ('BL0001','SP0001','2026-06-20',1),('BL0002','SP0002','2026-06-25',0);
/*!40000 ALTER TABLE `beli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbeli`
--

DROP TABLE IF EXISTS `dbeli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbeli` (
  `no_beli` varchar(50) NOT NULL,
  `kd_brg` char(6) NOT NULL,
  `harga_beli` float DEFAULT NULL,
  `jml_beli` int DEFAULT NULL,
  PRIMARY KEY (`no_beli`,`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbeli`
--

LOCK TABLES `dbeli` WRITE;
/*!40000 ALTER TABLE `dbeli` DISABLE KEYS */;
INSERT INTO `dbeli` VALUES ('BL0001','LP001',7500000,5),('BL0002','LP002',4300000,3);
/*!40000 ALTER TABLE `dbeli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `djual`
--

DROP TABLE IF EXISTS `djual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `djual` (
  `no_jual` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `kd_brg` char(6) COLLATE utf8mb4_general_ci NOT NULL,
  `harga_jual` double DEFAULT '0',
  `jml_jual` int DEFAULT NULL,
  PRIMARY KEY (`no_jual`,`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `djual`
--

LOCK TABLES `djual` WRITE;
/*!40000 ALTER TABLE `djual` DISABLE KEYS */;
INSERT INTO `djual` VALUES ('J-0001','LP0001',8500000,1),('J-0001','LP0002',7000000,2),('J-0002','LP001',8500000,1),('J-0003','LP002',5000000,1),('J-0004','LP0001',8500000,1);
/*!40000 ALTER TABLE `djual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jual`
--

DROP TABLE IF EXISTS `jual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jual` (
  `no_jual` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `kd_kons` char(6) COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_jual` date DEFAULT NULL,
  PRIMARY KEY (`no_jual`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jual`
--

LOCK TABLES `jual` WRITE;
/*!40000 ALTER TABLE `jual` DISABLE KEYS */;
INSERT INTO `jual` VALUES ('J-0001','K-0001','2026-06-19'),('J-0002','K-0001','2026-06-20'),('J-0003','K-0001','2026-06-25'),('J-0004','K-0001','2026-06-26');
/*!40000 ALTER TABLE `jual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konsumen`
--

DROP TABLE IF EXISTS `konsumen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konsumen` (
  `kd_kons` char(6) COLLATE utf8mb4_general_ci NOT NULL,
  `nm_kons` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `alm_kons` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `kota_kons` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `kd_pos` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`kd_kons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konsumen`
--

LOCK TABLES `konsumen` WRITE;
/*!40000 ALTER TABLE `konsumen` DISABLE KEYS */;
INSERT INTO `konsumen` VALUES ('K-0001','Najwa','PM1','Mranggentina','59567','085602004718','najwa@gmail.com');
/*!40000 ALTER TABLE `konsumen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suplier`
--

DROP TABLE IF EXISTS `suplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suplier` (
  `kd_sup` char(6) NOT NULL,
  `nm_sup` varchar(50) NOT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kd_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suplier`
--

LOCK TABLES `suplier` WRITE;
/*!40000 ALTER TABLE `suplier` DISABLE KEYS */;
INSERT INTO `suplier` VALUES ('SP0001','CV. Sumber Makmur','Semarang','024-5551111'),('SP0002','PT. Global Distribusi','Jakarta','021-4442222'),('SUP001','PT. INDO SENTOSA','Semarang','024-1234567'),('SUP002','CV. MEGA PRATAMA','Jakarta','021-9876543'),('SUP003','PT. SINAR JAYA','Surabaya','031-1112223');
/*!40000 ALTER TABLE `suplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin1','Admin Utama','admin1'),(2,'user1','User Pertama','user1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_penjualan`
--

DROP TABLE IF EXISTS `v_penjualan`;
/*!50001 DROP VIEW IF EXISTS `v_penjualan`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_penjualan` AS SELECT 
 1 AS `no_jual`,
 1 AS `tgl_jual`,
 1 AS `nm_kons`,
 1 AS `kd_brg`,
 1 AS `nm_brg`,
 1 AS `harga_jual`,
 1 AS `jml_jual`,
 1 AS `totjual`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_penjualan`
--

/*!50001 DROP VIEW IF EXISTS `v_penjualan`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_penjualan` AS select `j`.`no_jual` AS `no_jual`,`j`.`tgl_jual` AS `tgl_jual`,coalesce(`k`.`nm_kons`,'') AS `nm_kons`,`d`.`kd_brg` AS `kd_brg`,coalesce(`b`.`nm_brg`,'Barang Hilang') AS `nm_brg`,`d`.`harga_jual` AS `harga_jual`,`d`.`jml_jual` AS `jml_jual`,(`d`.`harga_jual` * `d`.`jml_jual`) AS `totjual` from (((`jual` `j` left join `konsumen` `k` on((`j`.`kd_kons` = `k`.`kd_kons`))) join `djual` `d` on((`j`.`no_jual` = `d`.`no_jual`))) left join `barang` `b` on((`d`.`kd_brg` = `b`.`kd_brg`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-03 10:06:48
