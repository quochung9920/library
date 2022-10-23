-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bookingticketdb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Xe khách thường '),(2,'Xe khách VIP');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(500) DEFAULT NULL,
  `createddate` datetime NOT NULL,
  `customer_id` int NOT NULL,
  `trip_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trip_comment_idx` (`trip_id`),
  KEY `fk_user_comment_idx` (`customer_id`),
  CONSTRAINT `fk_trip_comment` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_comment` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Trải nghiệm tuyệt vời','2022-08-03 00:00:00',6,6),(2,'Tuyệt','2022-08-05 00:00:00',9,6),(3,'Tôi cảm thấy dịch vụ rất tốt','2022-08-05 00:00:00',10,6),(4,'Phục vụ rất tốt','2022-08-05 00:00:00',30,6),(5,'Nhân viên rất chuyên nghiệp','2022-08-05 00:00:00',31,6),(6,'Đáng để trải nghiệm','2022-08-05 00:00:00',32,6),(7,'Dịch vụ vận tải đường dài mà tôi hài lòng nhất','2022-08-05 00:00:00',33,6),(8,'5 sao cho công ty','2022-08-05 00:00:00',34,6),(9,'A tài xế chuyến xe tôi đi rất thân thiện','2022-08-05 00:00:00',37,6),(10,'Mọi thứ đều ổn','2022-08-05 00:00:00',40,6),(11,'Rất ok','2022-08-05 00:00:00',41,6),(12,'Wonderfull trip','2022-08-05 00:00:00',42,6);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver` (
  `user_id_driver` int NOT NULL,
  `identitycard` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dateofbirth` date NOT NULL,
  `license` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id_driver`),
  KEY `fk_user_driver_idx` (`user_id_driver`),
  CONSTRAINT `fk_user_driver` FOREIGN KEY (`user_id_driver`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (3,'215571830','Bình Định','1970-12-07','E1'),(7,'215574356','Phú Yên','1960-12-13','E1'),(8,'215571832','Đồng Nai','1975-12-25','E1'),(15,'215571839','Quãng Ngãi','1985-05-23','E1'),(21,'215574512','TP HCM','1968-10-22','E1'),(22,'215545123','Đà Nẵng','1999-09-01','D1'),(23,'215554781','Nha Trang','1995-11-23','D1'),(24,'215523120','Quảng Nam','2000-08-26','D1'),(25,'215257895','Bến Tre','1997-06-21','D1'),(54,'221345678','Bình Định','1990-05-04','E1'),(65,'223456734','Bắc Ninh','1994-07-22','E1'),(67,'223452345','Hà Nội','1966-03-18','D1'),(68,'223456324','Hải Phòng','1991-08-19','D1'),(89,'044400657784','Quảng Trị','1997-04-04','E1'),(91,'054300675543','Phú Yên','1993-08-06','E1');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driverdetail`
--

DROP TABLE IF EXISTS `driverdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driverdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NOT NULL,
  `user_id_driver` int NOT NULL,
  `driverrole` enum('Assistant','Driver','MainDriver') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_driver_trip_idx` (`trip_id`,`user_id_driver`),
  KEY `fk_driver_driverdetail_idx` (`user_id_driver`),
  CONSTRAINT `fk_driver_driverdetail` FOREIGN KEY (`user_id_driver`) REFERENCES `driver` (`user_id_driver`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_trip_driverdetail` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driverdetail`
--

LOCK TABLES `driverdetail` WRITE;
/*!40000 ALTER TABLE `driverdetail` DISABLE KEYS */;
INSERT INTO `driverdetail` VALUES (8,6,3,'MainDriver'),(9,6,21,'Assistant'),(10,6,15,'Driver'),(11,7,7,'MainDriver'),(12,7,23,'Assistant'),(13,8,8,'MainDriver'),(14,9,15,'MainDriver'),(15,9,24,'Assistant'),(17,8,7,'Assistant'),(18,24,7,'MainDriver'),(19,24,8,'Assistant'),(20,25,15,'MainDriver'),(21,26,21,'MainDriver'),(22,27,22,'MainDriver'),(23,28,23,'MainDriver'),(24,29,25,'MainDriver'),(25,30,54,'MainDriver'),(26,31,65,'MainDriver');
/*!40000 ALTER TABLE `driverdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `user_id_employee` int NOT NULL,
  `identitycard` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dateofbirth` date NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`user_id_employee`),
  KEY `fk_user_employee_idx` (`user_id_employee`),
  CONSTRAINT `fk_user_employee` FOREIGN KEY (`user_id_employee`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'221510836','Bình Định','2001-07-12','Nữ'),(2,'215571830','Đà Nẵng','1999-03-18','Nam'),(4,'225647810','Phú Yên','2001-10-06','Nữ'),(11,'221487982','Kiên Giang','1997-05-09','Nữ'),(12,'225647892','Đồng Tháp ','1996-04-12','Nam'),(13,'226987314','Đà Nẵng ','1999-05-08','Nữ'),(14,'224897120','Bạc Liêu','1995-05-05','Nam'),(35,'223453432','Đồng Nai','2001-03-26','Nữ'),(47,'223456754','Bình Định','2000-03-28','Nữ'),(66,'223453456','Lâm Đồng','1998-07-16','Nữ'),(69,'223412345','Huế','1995-11-06','Nữ'),(86,'053005467783','Phú Yên','1999-05-15','Nam'),(87,'046700234444','TP HCM','1998-03-22','Nam'),(88,'222345678','TP HCM','1995-03-26','Nam'),(92,'223423123','Đà Nẵng','2000-04-06','Nữ');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengercar`
--

DROP TABLE IF EXISTS `passengercar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengercar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `numberplate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `seats` int NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_passengecar_idx` (`category_id`),
  CONSTRAINT `fk_category_passengecar` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengercar`
--

LOCK TABLES `passengercar` WRITE;
/*!40000 ALTER TABLE `passengercar` DISABLE KEYS */;
INSERT INTO `passengercar` VALUES (1,'Xe7700002','77_B1',34,2),(2,'Xe7700003','77_B2',34,1),(3,'Xe7700069','77_B3',34,2),(4,'Xe7700099','77_A1',34,1),(5,'Xe7700079','77_A2',34,1),(6,'Xe7700008','77_A3',34,1),(7,'Xe7800006','78_C1',34,1),(8,'Xe7800456','78_C2',34,2),(9,'Xe7804953','78_C3',34,1),(10,'Xe7804648','78_A1',34,1),(11,'Xe7804078','78_A2',34,1),(12,'Xe7806666','78_A3',34,1),(13,'Xe5900569','59_H1',34,2),(14,'Xe5105239','51_G1',34,1),(15,'Xe5905555','59_B2',34,2),(16,'Xe5905656','59_G2',34,2),(17,'Xe5106578','51_D2',34,2),(18,'Xe7106868','71_A1',34,1),(19,'Xe7106686','71_D1',34,1),(20,'Xe7107301','71_c2',34,2),(21,'Xe7100001','71_G2',34,1),(22,'Xe7100041','71_H2',34,2),(23,'Xe4300035','43_M1',34,1),(24,'Xe4300039','43_H4',34,2),(25,'Xe4300077','43_K2',34,2),(26,'Xe4300033','43_G1',34,2),(27,'Xe4300067','43_D2',34,2),(28,'Xe2900006','29_A1',34,1),(29,'Xe3300003','33_A2',34,2),(30,'Xe4000041','40_D2',34,2),(31,'Xe3006868','30_D7',34,2),(32,'Xe3109979','31_C1',34,2),(65,'Xe6500066','65_A5',34,1),(66,'Xe6500009','65_B1',34,2),(67,'Xe6500079','65_C2',34,1),(68,'Xe6500005','65_D4',34,2),(69,'Xe6506578','65_A1',34,2),(70,'Xe4900035','49_H1',34,2),(71,'Xe4900039','49_M1',34,2),(72,'Xe4900003','49_E1',34,1),(73,'Xe4900079','49_A3',34,2),(74,'Xe4905656','49_D2',34,1),(75,'Xe6800009','68_E1',34,1),(76,'Xe6800068','68_H1',34,1),(77,'Xe6806868','68_D1',34,1),(78,'Xe6807979','68_A3',34,1),(79,'Xe6805239','68_C2',34,1),(80,'Xe6805555','68_A4',34,1);
/*!40000 ALTER TABLE `passengercar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `routename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `startingpoint` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `destination` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `specialprice` double DEFAULT NULL,
  `image` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `stretch` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `time` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (99,'HCM-BĐ','Sài Gòn','Bình Định',300000,0.3,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660380977/routes/binh-dinh-route.jpg','12',600),(100,'HCM-PY','Sài Gòn','Phú Yên',250000,0.2,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381111/routes/tour-phu-yen-1-ngay-13_a5isfc.jpg','10',520),(101,'BL-HCM','Bạc Liêu','Sài Gòn',390000,0.15,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381618/routes/Ve-may-bay-di-sai-gon-600x399_thgtip.jpg','4',150),(102,'HCM-BT','Sài Gòn','Bến Tre',70000,0.2,'https://res.cloudinary.com/ddqevaeix/image/upload/v1661534021/routes/Mekong-Delta-Palm-Trees_evrhtq.jpg','3',100),(103,'HCM-ĐN','Sài Gòn','Đà Nẵng',400000,0.3,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381230/routes/ttxvn_da_nang_nam_moi_nlqipd.jpg','15',700),(104,'HN-ĐN','Hà Nội','Đà Nẵng',350000,0.25,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381763/routes/h_E1_BB_93-g_C6_B0_C6_A1m-du-l_E1_BB_8Bch-H_C3_A0-N_E1_BB_99i-ivivu_tx7qpw.jpg','24',1000),(105,'HCM-ĐL','Sài Gòn','Đà Lạt',240000,0.1,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381383/routes/fur1616991815_wtm7fy.png','7',300),(106,'HCM-CT','Sài Gòn','Cần Thơ',130000,0.15,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660381430/routes/ve-may-bay-gia-re-di-can-tho-1_ajhv14.png','5',250),(107,'HCM-KG','Sài Gòn','Kiên Giang',145000,0.1,'https://res.cloudinary.com/ddqevaeix/image/upload/v1660369064/routes/Sa_CC_80i-Go_CC_80n-di-Kie_CC_82n-Giang-bao-nhie_CC.jpg','7',200),(108,'BĐ-HCM','Bình Định','Sài Gòn',300000,0.3,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662446956/routes/QUY-NHON-NEW-CITY-BINH-DINH_hlxfcv.jpg','12',600),(109,'PY-HCM','Phú Yên','Sài Gòn',250000,0.2,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447005/routes/san-ho-tran-bao-hoa-11594598_mm7qbz.jpg','10',520),(110,'HCM-BL','Sài Gòn','Bạc Liêu',390000,0.15,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447051/routes/bac_20lieu_rfx8sr.jpg','4',150),(111,'BT-HCM','Bến Tre','Sài Gòn',70000,0.2,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447093/routes/ae_zuuypu.jpg','3',100),(112,'ĐN-HCM','Đà Nẵng','Sài Gòn',400000,0.3,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447134/routes/88c21fcf6c49e6b744be507a7c7263f25fb3613c92033fa49d3927022ed55a73_drbgtt.jpg','15',700),(113,'ĐN-HN','Đà Nẵng','Hà Nội',350000,0.25,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447180/routes/caption_o92unt.jpg','24',1000),(114,'ĐL-HCM','Đà Lạt','Sài Gòn',240000,0.1,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447215/routes/44b5739e-45bb-494c-80fb-298660872ca5_dg5ser.jpg','7',300),(115,'CT-HCM','Cần Thơ','Sài Gòn',130000,0.15,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447269/routes/photo0jpg_lgskxu.jpg','5',250),(116,'KG-HCM','Kiên Giang','Sài Gòn',145000,0.1,'https://res.cloudinary.com/ddqevaeix/image/upload/v1662447333/routes/9736567857_13b1aa0026_k_idvxl5.jpg','7',200);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `seatrow` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A01','A'),(2,'A02','A'),(3,'A03','A'),(4,'A04','A'),(5,'A05','A'),(6,'A06','A'),(7,'A07','A'),(8,'A08','A'),(9,'A09','A'),(10,'A10','A'),(11,'A11','A'),(12,'A12','A'),(13,'A13','A'),(14,'A14','A'),(15,'A15','A'),(16,'A16','A'),(17,'A17','A'),(18,'B01','B'),(19,'B02','B'),(20,'B03','B'),(21,'B04','B'),(22,'B05','B'),(23,'B06','B'),(24,'B07','B'),(25,'B08','B'),(26,'B09','B'),(27,'B10','B'),(28,'B11','B'),(29,'B12','B'),(30,'B13','B'),(31,'B14','B'),(32,'B15','B'),(33,'B16','B'),(34,'B17','B');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketdetail`
--

DROP TABLE IF EXISTS `ticketdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat_id` int DEFAULT NULL,
  `paymentmethod` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `totalprice` decimal(10,0) NOT NULL,
  `createddate` datetime NOT NULL,
  `passengercar_id` int DEFAULT NULL,
  `trip_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `note` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_passengercar_ticketdetail_idx` (`passengercar_id`),
  KEY `fk_trip_ticketdetail_idx` (`trip_id`),
  KEY `fk_employee_ticketdetail_idx` (`user_id`),
  KEY `fk_seat_ticketdetail_idx` (`seat_id`),
  CONSTRAINT `fk_employee_ticketdetail` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_passengercar_ticketdetail` FOREIGN KEY (`passengercar_id`) REFERENCES `passengercar` (`id`),
  CONSTRAINT `fk_seat_ticketdetail` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `fk_trip_ticketdetail` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketdetail`
--

LOCK TABLES `ticketdetail` WRITE;
/*!40000 ALTER TABLE `ticketdetail` DISABLE KEYS */;
INSERT INTO `ticketdetail` VALUES (2,1,'Tiền mặt',300000,'2022-08-03 15:00:00',1,6,14,NULL),(3,2,'Momo',300000,'2022-08-06 16:00:00',1,6,14,NULL),(4,3,'Tiền mặt',300000,'2022-08-08 17:30:00',1,6,14,NULL),(5,4,'Tiền mặt',300000,'2022-08-08 17:30:00',1,6,14,NULL),(6,5,'Tiền mặt',300000,'2022-08-08 17:30:00',1,6,14,NULL),(7,6,'Tiền mặt',300000,'2022-08-08 17:30:00',1,6,14,NULL),(8,7,'Tiền mặt',300000,'2022-08-08 17:30:00',1,6,11,NULL),(9,8,'Tiền mặt',300000,'2022-08-09 11:28:30',1,6,12,NULL),(10,9,'Momo',300000,'2022-08-09 11:28:30',1,6,12,NULL),(11,10,'Tiền mặt',300000,'2022-08-09 11:28:30',1,6,12,NULL),(12,18,'Tiền mặt',300000,'2022-08-12 08:22:13',1,6,11,NULL),(13,19,'Tiền mặt',300000,'2022-08-12 08:22:13',1,6,12,NULL),(14,20,'Momo',300000,'2022-08-12 08:22:13',1,6,11,NULL),(15,21,'Tiền mặt',300000,'2022-08-12 08:22:13',1,6,12,NULL),(16,22,'Tiền mặt',300000,'2022-08-15 10:10:15',1,6,13,NULL),(17,23,'Tiền mặt',300000,'2022-08-15 10:10:15',1,6,13,NULL),(18,24,'Momo',300000,'2022-08-15 10:10:15',1,6,13,NULL),(19,25,'Tiền mặt',300000,'2022-08-15 10:10:15',1,6,13,NULL),(26,26,'Momo',300000,'2022-08-16 15:23:10',1,6,6,NULL),(27,27,'Momo',300000,'2022-08-17 17:20:40',1,6,9,NULL),(28,5,'Momo',300000,'2022-08-17 17:20:40',7,7,10,NULL),(29,19,'Momo',300000,'2022-08-17 17:20:40',7,7,30,NULL),(30,2,'Momo',300000,'2022-08-17 17:20:40',7,7,9,NULL),(77,3,'Momo',300000,'2022-08-17 17:20:40',7,7,9,NULL),(78,8,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(79,7,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(80,6,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(81,9,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(82,20,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(83,26,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(84,29,'Tiền mặt',250000,'2022-08-18 23:00:46',8,8,4,NULL),(85,11,'Tiền mặt',300000,'2022-08-20 14:36:15',1,6,40,NULL),(86,28,'Tiền mặt',300000,'2022-08-20 14:36:15',1,6,40,NULL),(87,29,'Tiền mặt',300000,'2022-08-20 14:36:15',1,6,40,NULL),(88,12,'Tiền mặt',300000,'2022-08-20 14:36:15',1,6,40,NULL),(89,6,'Tiền mặt',70000,'2022-08-25 13:17:04',23,24,40,NULL),(90,7,'Tiền mặt',70000,'2022-08-25 13:17:04',23,24,40,NULL),(91,8,'Tiền mặt',70000,'2022-08-25 13:17:04',23,24,40,NULL),(92,9,'Tiền mặt',70000,'2022-08-25 13:17:04',23,24,40,NULL),(93,10,'Tiền mặt',70000,'2022-08-25 13:17:04',23,24,40,NULL),(94,9,'Tiền mặt',300000,'2022-08-26 14:12:36',2,9,50,NULL),(95,10,'Tiền mặt',300000,'2022-08-26 14:12:36',2,9,50,NULL),(96,6,'Tiền mặt',400000,'2022-08-26 14:58:33',65,25,68,NULL),(97,7,'Tiền mặt',400000,'2022-08-26 14:58:33',65,25,68,NULL),(98,26,'Tiền mặt',70000,'2022-08-26 15:51:35',23,24,4,NULL),(99,27,'Tiền mặt',70000,'2022-08-26 15:51:36',23,24,4,NULL),(100,28,'Tiền mặt',70000,'2022-08-26 15:51:36',23,24,4,NULL),(101,8,'Tiền mặt',400000,'2022-08-26 15:52:59',65,25,4,NULL),(102,9,'Tiền mặt',400000,'2022-08-26 15:52:59',65,25,4,NULL),(103,10,'Tiền mặt',400000,'2022-08-26 15:52:59',65,25,4,NULL),(104,11,'Tiền mặt',400000,'2022-08-26 15:52:59',65,25,4,NULL),(105,12,'Tiền mặt',70000,'2022-08-26 16:18:12',23,24,69,NULL),(106,13,'Tiền mặt',70000,'2022-08-26 16:18:12',23,24,69,NULL),(107,26,'Tiền mặt',300000,'2022-08-26 10:43:18',2,9,69,NULL),(108,27,'Tiền mặt',300000,'2022-08-26 10:43:18',2,9,69,NULL),(109,28,'Tiền mặt',300000,'2022-08-26 10:43:18',2,9,69,NULL),(110,12,'Tiền mặt',300000,'2022-08-26 10:43:18',2,9,4,NULL),(111,13,'Tiền mặt',300000,'2022-08-27 20:07:10',2,9,69,NULL),(112,14,'Tiền mặt',300000,'2022-08-27 20:07:10',2,9,69,NULL),(113,29,'Tiền mặt',300000,'2022-08-28 20:09:00',2,9,69,NULL),(114,30,'Tiền mặt',300000,'2022-08-28 20:09:00',23,9,69,NULL),(115,29,'Tiền mặt',70000,'2022-08-28 20:15:14',23,24,69,NULL),(116,14,'Tiền mặt',70000,'2022-08-28 20:20:36',23,24,69,NULL),(117,23,'Tiền mặt',250000,'2022-08-29 20:21:10',8,8,4,NULL),(118,24,'Tiền mặt',250000,'2022-08-29 20:21:10',8,8,4,NULL),(119,13,'Tiền mặt',300000,'2022-08-30 14:52:02',1,6,2,NULL),(120,14,'Tiền mặt',300000,'2022-08-30 14:52:03',1,6,2,NULL),(121,15,'Tiền mặt',300000,'2022-08-30 14:52:03',1,6,2,NULL),(122,16,'Tiền mặt',300000,'2022-08-30 14:53:24',1,6,11,NULL),(123,30,'Tiền mặt',300000,'2022-08-30 14:53:24',1,6,11,NULL),(124,31,'Tiền mặt',300000,'2022-08-30 14:53:24',1,6,11,NULL),(125,32,'Tiền mặt',300000,'2022-08-30 14:54:25',1,6,12,NULL),(126,33,'Tiền mặt',300000,'2022-08-30 14:54:25',1,6,12,NULL),(127,17,'Tiền mặt',300000,'2022-08-30 14:55:26',1,6,13,NULL),(128,34,'Tiền mặt',300000,'2022-08-30 14:55:26',1,6,13,NULL),(129,3,'Tiền mặt',300000,'2022-08-30 14:55:57',2,9,13,NULL),(130,4,'Tiền mặt',300000,'2022-08-30 14:55:58',2,9,13,NULL),(131,6,'Momo',300000,'2022-08-30 14:58:57',2,9,13,NULL),(132,7,'Momo',300000,'2022-08-30 14:58:57',2,9,13,NULL),(133,8,'Momo',300000,'2022-08-30 14:58:57',2,9,13,NULL),(134,23,'Momo',300000,'2022-08-30 14:59:32',2,9,10,NULL),(135,24,'Momo',300000,'2022-08-30 14:59:32',2,9,10,NULL),(136,25,'Momo',300000,'2022-08-30 14:59:32',2,9,10,NULL),(137,1,'Momo',300000,'2022-08-30 15:00:24',2,9,30,NULL),(138,2,'Momo',300000,'2022-08-31 15:00:24',2,9,30,NULL),(139,5,'Momo',300000,'2022-08-31 15:00:24',2,9,30,NULL),(140,18,'Momo',300000,'2022-08-31 15:00:59',2,9,31,NULL),(141,19,'Momo',300000,'2022-08-31 15:00:59',2,9,31,NULL),(142,20,'Momo',300000,'2022-08-31 15:00:59',2,9,31,NULL),(143,21,'Momo',300000,'2022-08-31 15:00:59',2,9,31,NULL),(144,22,'Momo',300000,'2022-08-31 15:00:59',2,9,31,NULL),(145,16,'Momo',300000,'2022-09-03 15:01:31',2,9,32,NULL),(146,17,'Momo',300000,'2022-09-03 15:01:31',2,9,32,NULL),(147,11,'Momo',300000,'2022-09-03 15:01:31',2,9,32,NULL),(148,31,'Momo',300000,'2022-09-03 15:01:31',2,9,32,NULL),(149,15,'Momo',300000,'2022-09-03 15:01:31',2,9,32,NULL);
/*!40000 ALTER TABLE `ticketdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coachname` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `departureday` date NOT NULL,
  `departuretime` time NOT NULL,
  `arrivaltime` time NOT NULL,
  `image` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  `route_id` int DEFAULT NULL,
  `user_id_employee` int DEFAULT NULL,
  `passengercar_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_route_trip_idx` (`route_id`),
  KEY `fk_employee_trip_idx` (`user_id_employee`),
  KEY `fk_passengercar_trip_idx` (`passengercar_id`),
  CONSTRAINT `fk_employee_trip` FOREIGN KEY (`user_id_employee`) REFERENCES `employee` (`user_id_employee`),
  CONSTRAINT `fk_passengercar_trip` FOREIGN KEY (`passengercar_id`) REFERENCES `passengercar` (`id`),
  CONSTRAINT `fk_route_trip` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (6,'HCM-BĐ-2922','2022-09-02','16:00:00','04:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1660451872/trip/top-9-xe-khach-di-ninh-binh-tu-ha-noi-chat-luong-tot-nhat-1640513468_ycohxn.jpg',0,99,2,1),(7,'HCM-PY-3922','2022-09-03','19:00:00','06:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1660451863/trip/xe-khach-hai-phong-3_ttb20d.jpg',0,100,11,7),(8,'HCM-PY-2922','2022-09-02','19:00:00','05:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1660451814/trip/1_p1kr6c.jpg',0,100,12,8),(9,'HCM-BĐ-4922','2022-09-04','17:00:00','06:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1660451648/trip/xe-khach-ha-noi-lang-son_ot86ca.jpg',0,99,13,2),(24,'HCM-ĐN-5922','2022-09-05','13:00:00','09:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1660576371/trip/xe-dong-ha-da-nang-02.jpg_gacr5l.jpg',0,103,14,23),(25,'HCM-CT-69221','2022-09-06','09:00:00','13:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788654/trip/xe-giuong-nam-thaco-mobihome-muaxegiatot-vn-5_ioaspo.jpg',0,106,66,65),(26,'HCM-CT-69222','2022-09-06','13:00:00','15:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788653/trip/LESO3679-HDR-min-scaled_ogsrtk.jpg',0,106,69,66),(27,'HCM-CT-69223','2022-09-06','15:00:00','17:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788657/trip/xe_20giuong_20nam_ht8hgu.jpg',0,106,86,67),(28,'HCM-CT-69224','2022-09-06','17:00:00','19:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788660/trip/tim-hieu-thong-tin-lai-xe-giuong-nam-thi-can-bang-gi_xrblkl.jpg',0,106,87,68),(29,'HCM-CT-69225','2022-09-06','19:00:00','21:00:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788664/trip/xe-giu_CC_9Bo_CC_9B_CC_80ng-na_CC_86_CC_80m_y2kcfi.jpg',0,106,88,69),(30,'HCM-BT-79221','2022-09-07','17:45:00','20:45:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788676/trip/dcar_khach_san_di_dong_1_dygvfi.png',0,102,12,18),(31,'HCM-BT-79222','2022-09-07','18:45:00','21:45:00','https://res.cloudinary.com/ddqevaeix/image/upload/v1661788657/trip/xe_20giuong_20nam_ht8hgu.jpg',0,102,14,19),(32,'HCM-BĐ-8922','2022-09-08','17:00:00','05:00:00','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662454535/meeysrl4xz8wowoquflg.jpg',1,99,13,3),(33,'HCM-BT-8922','2022-09-08','19:00:00','20:00:00','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662454636/sex4qwfowo61flfoxvm0.jpg',1,102,12,18),(34,'HCM-PY-8922','2022-09-08','20:00:00','07:00:00','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662454713/hwkka7wtvf52urnueuqm.jpg',1,100,86,8);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  `userrole` enum('Customer','Admin','Employee','Driver') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'Customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Phan Thị Diệu Hiền','phanhien','$2a$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','hien123456@gmail.com','0154789642','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789184/samples/landscapes/image_user/1200px-Cat03_pqsyrc.jpg',1,'Admin'),(2,'Nguyễn Hà Bảo','habao','$2a$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','bao@gmail.com','0356478910','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498389/samples/people/smiling-man.jpg',1,'Employee'),(3,'Hà Văn Cao','caoooo','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','cao@gmail.com','0147845962','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788766/samples/landscapes/lovepik-driver-driving-a-car-picture_501434297_sw9mk7.jpg',1,'Driver'),(4,'Huỳnh Kim Loan','huynhloan1','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG','loan@gmail.com','0339587121','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498399/samples/animals/kitten-playing.gif',1,'Admin'),(6,'Văn Ngọc','vanngoc','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0578964512','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(7,'Nguyễn Tấn Tạ','ta','$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','ta@gmail.com','0569784123','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788768/samples/landscapes/layer-12_qhgcrv.jpg',1,'Driver'),(8,'Huỳnh Hải Hà','ha','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','ha@gmail.com','0154789451','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788770/samples/landscapes/nhung-luu-y-danh-cho-lai-moi-4_p0xgkg.jpg',1,'Driver'),(9,'Diệu Hiền','hien1','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG',NULL,'0147845631','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789073/samples/landscapes/image_user/2048px-Crystal_Clear_kdm_user_female.svg_ydt3wb.png',1,'Customer'),(10,'Kim Loan','loan','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0145784236','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789073/samples/landscapes/image_user/2048px-Crystal_Clear_kdm_user_female.svg_ydt3wb.png',1,'Customer'),(11,'Nguyễn Võ Như Ngọc','nhungoc','$2a$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','ngoc@gmail.com','0154789410','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498409/cld-sample.jpg',1,'Employee'),(12,'Phạm Hà Hưng','hahung','$2a$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','hung@gmail.com','0347895214','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498389/samples/people/smiling-man.jpg',1,'Employee'),(13,'Hà Thị Thục Đan','dan','$2a$10$Ws/MaKcA3QbIoHTJuhDZI.VodTjSc1NgP486la5BdTtR1Xc3lbDBe','dan@gmail.com','0154789432','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498409/cld-sample.jpg',1,'Employee'),(14,'Trần Quốc Cao','cao','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','cao0805@gmail.com','0134569874','https://res.cloudinary.com/ddqevaeix/image/upload/v1659498389/samples/people/smiling-man.jpg',1,'Employee'),(15,'Đỗ Trọng Phúc','phuc','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','phuc@gmail.com','0457841236','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788768/samples/landscapes/layer-12_qhgcrv.jpg',1,'Driver'),(21,'Võ Văn Vân','van','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','van@gmail.com','0147854123','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788770/samples/landscapes/nhung-luu-y-danh-cho-lai-moi-4_p0xgkg.jpg',1,'Driver'),(22,'Phạm Trung Nghĩa','nghia','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','nghia@gmail.com','0147895412','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788766/samples/landscapes/lovepik-driver-driving-a-car-picture_501434297_sw9mk7.jpg',1,'Driver'),(23,'Phạm Ngọc Ngọc','ngoc','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','ngocdr@gmail.com','0145789632','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788768/samples/landscapes/layer-12_qhgcrv.jpg',1,'Driver'),(24,'Võ Hà Ân','an','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','an@gmail.com','0569874123','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788770/samples/landscapes/nhung-luu-y-danh-cho-lai-moi-4_p0xgkg.jpg',1,'Driver'),(25,'Phan Phúc Bá','baphan','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','ba@gmail.com','0254678952','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788766/samples/landscapes/lovepik-driver-driving-a-car-picture_501434297_sw9mk7.jpg',1,'Driver'),(30,'Hồng Hạnh','hanh','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0145796320','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789073/samples/landscapes/image_user/2048px-Crystal_Clear_kdm_user_female.svg_ydt3wb.png',1,'Customer'),(31,'Thuận Thảo','thaothuan','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG','thaott@gmail.com','0214569872','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(32,'Huỳnh Ân','huynhaa','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0236547895','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(33,'Công Nhân','nhan','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0458796310','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(34,'Văn Quyết','quyet','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG',NULL,'0154687923','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(35,'Hiền Phan','hi','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG','hien@email.com','0387214794','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789073/samples/landscapes/image_user/2048px-Crystal_Clear_kdm_user_female.svg_ydt3wb.png',1,'Admin'),(37,'Nguyen Tai','tai','$2a$10$VyWFfaE25n9cb38iAkM.gu9zMKdFMj5KSQ.t1NY28PBuNTr69lrRG','tai@gmail.com','098537133','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(40,'Dieu Hien 123','dh123','$2a$10$cNyPgtfeC8DvML.9UCwDBO28hgfBX9bOL8Nx0oAFk.SjUdnz0sBX2','dh123@email.com','083368484','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789073/samples/landscapes/image_user/2048px-Crystal_Clear_kdm_user_female.svg_ydt3wb.png',1,'Customer'),(41,'Phạm Thoại','phamthoai','$2a$10$NrrkoKYyaujN.wa8KVuOvuEeiLi.LbgecyvO9Y.NSl6o.xpDwEJTG','phamthoai@gmail.com','097683643','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(42,'Nguyễn Thị Thúy Ngân','thuyngan','$2a$10$EfwVhBKFWi8sOaO1dKmaKePkayGw2/1pEjPNYySCJ0fTcJ7uphhlu','nguyenthithuyngan0701@gmail.com','0965931468','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660185988/mfsqepcxlbwt1hze6o8r.jpg',1,'Customer'),(43,'Hữu Thành','huuthanh','$2a$10$883v0nbK4A9/zAfkb4tOEOzrggiMyidR04oYJwk7MU.oGA3S.0ep2','thanh@email.com','0387214794','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660198286/e2zryxm0039g4ddcqq03.jpg',1,'Customer'),(47,'Phan Diệu Hiền','hiendieu','$2a$10$X.VnDtuOlBe8kQ/Y1v2tLOaf6GMEp0YZ80R2QKlywEz7BNIjmojAG','hiendieu@gmail.com','0387214794','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660198286/e2zryxm0039g4ddcqq03.jpg',1,'Admin'),(49,'Phan Thị Diệu Hiền','thuyngan1','$2a$10$7ta8R5T83tTLJRlmRiDPhOpLJWrXJ5.VEuaPsyzecS3ajL86YZTFC','td@gmail.com','0387214794','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660216930/bgwlmhmwxkwztnjgy4fc.jpg',1,'Customer'),(50,'Nguyễn Thị A','a','$2a$10$U.gIn6dWWXX7.dO3VeVsUeuOfVch/hD3YNBk7gLWQpomOIK/u9yEy','aaa@gmail.com','0154673282','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660408631/bix8uqxr2wgea3d6im7v.jpg',1,'Customer'),(51,'Nguyễn Văn Ba','vanaa','$2a$10$XlQokGAsQvBt1r1zSv1BpeW4axfJ3HNzY0IWY1iyOJUpv61vBje7i','aavan@gmail.com','0234567824','https://res.cloudinary.com/dvsqhstsi/image/upload/v1660408631/bix8uqxr2wgea3d6im7v.jpg',1,'Customer'),(53,'Nguyễn Văn Bê','vanbe','$2a$10$WOQ/dykFA9bRMQaYyEA/sezMyE6W1G1Hurvmge9GY9BB5Ou3M1UeC','bevan@gmail.com','0234567724','https://res.cloudinary.com/ddqevaeix/image/upload/v1659789077/samples/landscapes/image_user/icon-256x256_ngtfyy.png',1,'Customer'),(54,'Hà Quốc Việt','quocviet','$2a$10$cNcwd1OJXDqhjrv8L7GCCOjWGI1ebxrLK7FQ72bcPmSWolHNyVBHO','vietha@gmail.com','0234567341','https://res.cloudinary.com/ddqevaeix/image/upload/v1659788768/samples/landscapes/layer-12_qhgcrv.jpg',1,'Driver'),(65,'Võ An Bình','annn','$2a$10$7p4zhoWCYFIOo7YvxAXFV.qLFgOz4kIYXffkthOGWNnDR5Fr0wzu.','annn@gmail.com','0234567899','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661963624/w32b5s6ys87ibakd47ah.jpg',1,'Driver'),(66,'Nguyễn Thị Hà Ngân','hanganne','$2a$10$0xgSx/3bvlXwUlBSY1aWCOSak4RRajFEcrZ1ow6xvlZwOItesWt3W','beo123@gmail.com','0234567891','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661592044/wmgg6g5722kfljed1abw.jpg',1,'Employee'),(67,'Võ Bá Tài Tình','taitinh','$2a$10$cUKxt2Slm3espCdMZEWg9uNJ0md17UR2r/tYk1CysyrvLK/oRDgGe','taitinh@gmail.com','0234567892','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661603365/r09l5j1lxthkkoes6rmb.jpg',1,'Driver'),(68,'Cao Bá Kiến','bakien91','$2a$10$A4oaec31Mi9oNTibtWThYuh96fsyfNHZ4GzAWZ3opzV9L0ZuhbcDa','bakien34@gmail.com','0337925345','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661962380/mp3hr8awfblk7mmstqxm.jpg',1,'Driver'),(69,'Hồ Hà Bảo Ngọc','ngocho95','$2a$10$zZHLPAFsHIWuGE05CBtRF.MM3JWh0r7Aea.zMLyBDcVFlFJ7lj3VC','ngoc.hnb@gmail.com','0234567121','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661670677/rqlxysl1gznj40jtqzbt.jpg',1,'Employee'),(86,'Nguyễn Bá Hải Duy','baduy99','$2a$10$Zftn6l5eziV5FbjA7ILk7eh7/bdkpyRTTlBb40DyY6eM7aWqmPlfq','duy.nbh@gmail.com','0345678765','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661673706/jc4frabq1k9qtboatnyj.jpg',1,'Employee'),(87,'Hà Ngọc Hậu','hau98','$2a$10$0JjxPhvIbK4zGnkUS0ZbAOiCEw0EWiabsgwTknmk6fi2GD9FcZFgG','hau.hn@gmail.com','0345672345','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661674183/xiqomrglhekangjdi7jp.jpg',1,'Employee'),(88,'Cao Thái Sơn','soncao','$2a$10$diBMRTdNbQv6q2rGZkRoBOX7rV9jPvMfOtCaTkLZ8w1JQvGVAhaMC','son.ct@gmail.com','0234567861','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661674504/da78vjymxu8dlz7qqgp5.jpg',1,'Employee'),(89,'Phạm Bá Hải','hai.pb97','$2a$10$bAPohJAQXLmGbN/n3gHRGuYhG4ZW0JrfCZQ4F.6tPy2ikvXFtAL9a','haiba@gmail.com','0345684533','https://res.cloudinary.com/dvsqhstsi/image/upload/v1661766605/mogpqsoiraw9kz8fgo91.jpg',1,'Driver'),(90,'Hà Thị Hân','han','$2a$10$oysihd3a4OlPmgiJ5TryneSiwMNOKM1FDI0fX5bSm95gi74S2ax..','han.ht@gmail.com','0456345234','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662291261/oy3pyaon1ni6w9qkkwml.jpg',1,'Customer'),(91,'Nguyễn Văn Hùng','hung.nv','$2a$10$aEDPEKG4vKEYsmaCspngou77J905vty6QO7BPpi6/k3GnTUJTz2fm','hung.nv@gmail.com','0342345324','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662454982/wzzgsnsjlkc35k3yfayp.jpg',1,'Driver'),(92,'Nguyễn Châu Báu','bau','$2a$10$wEstLdmGCM4kDRcAPe7QbeUB/a5Ptf0QWosQPSMu/M8dVajx89Hoe','bau.nc@gmail.com','0833684322','https://res.cloudinary.com/dvsqhstsi/image/upload/v1662455109/jkvt1pklvujai0k79xx5.jpg',1,'Employee');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-07 20:11:50
