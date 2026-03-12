-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien` (
  `ma_sv` varchar(10) NOT NULL,
  `ho_ten` varchar(100) NOT NULL,
  `ngay_sinh` date NOT NULL,
  `nganh_dao_tao` varchar(10) NOT NULL,
  `diem_tb` double NOT NULL,
  `lop_sinh_hoat` varchar(20) NOT NULL,
  PRIMARY KEY (`ma_sv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES ('4551050001','Nguyen Van Hung','2005-05-15','CNTT',8.5,'CNTT45A'),('4551050002','Tran Thi Kim Chi','2004-02-20','CNTT',7,'CNTT45A'),('4551050003','Hoang Nam','2005-11-10','CNTT',9,'CNTT45A'),('4551050004','Minh Tuan','2003-08-05','CNTT',7.5,'CNTT44B'),('4551050005','Ngoc Ha','2005-12-12','CNTT',8.3,'CNTT46B'),('4551050006','Dao Quang Vinh','2004-01-30','CNTT',6.4,'CNTT45B'),('4551050007','Trinh Duong Anh Tuan','2005-05-10','CNTT',9.4,'CNTTK46D'),('4551090001','Nguyen Hoai Thu','2005-03-25','KTPM',7.5,'KTPM46'),('4551090002','Phan Van Duc','2005-07-14','KTPM',8.3,'KTPM46'),('4551090003','Lam Gia Bao','2004-09-01','KTPM',7.3,'KTPM45'),('4551090004','Bui Thu Thao','2005-05-18','KTPM',8.5,'KTPM46');
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-12 23:51:39
