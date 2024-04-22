CREATE DATABASE  IF NOT EXISTS `shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `publication_year` int NOT NULL,
  `genre_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `description` text NOT NULL,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `created_by` bigint NOT NULL,
  `modified_by` bigint DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `genre_id_fk_idx` (`genre_id`),
  KEY `created_by_fk_idx` (`created_by`),
  KEY `modified_by_fk_idx` (`modified_by`),
  CONSTRAINT `genre_id_fk` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `modified_by_fk` FOREIGN KEY (`modified_by`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Book 1','Author 1','1234567890123',2010,1,19.99,13,'Description for Book 1','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(2,'Book 2','Author 2','2345678901234',2011,2,24.99,5,'Description for Book 2','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(3,'Book 3','Author 3','3456789012345',2012,3,14.99,15,'Description for Book 3','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(4,'Book 4','Author 4','4567890123456',2013,4,29.99,58,'Description for Book 4','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(5,'Book 5','Author 5','5678901234567',2014,5,12.99,70,'Description for Book 5','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(6,'Book 6','Author 6','6789012345678',2015,6,34.99,80,'Description for Book 6','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(7,'Book 7','Author 7','7890123456789',2016,7,39.99,90,'Description for Book 7','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(8,'Book 8','Author 8','8901234567890',2017,8,17.99,100,'Description for Book 8','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(9,'Book 9','Author 9','9012345678901',2018,9,22.99,110,'Description for Book 9','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(10,'Book 10','Author 10','0123456789012',2019,10,18.99,120,'Description for Book 10','2024-03-17 15:13:55',0,1,1,'2024-03-19 20:28:18'),(11,'Book 11','Author 11','1122334455667',2020,11,27.99,130,'Description for Book 11','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(12,'Book 12','Author 12','2233445566778',2021,12,31.99,140,'Description for Book 12','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(13,'Book 13','Author 13','3344556677889',2022,13,16.99,150,'Description for Book 13','2024-03-17 15:13:55',1,1,1,'2024-03-19 20:28:18'),(14,'Book update22222222','Author update','1234567890123',1999,1,20.10,5,'update','2024-03-20 19:43:43',1,1,1,'2024-03-20 19:43:43'),(15,'Book update','Author update','1234567890123',1999,1,20.10,5,'update','2024-03-20 19:31:20',1,1,1,'2024-03-20 19:22:45'),(58,'Book 112321321','Author 13','3344556677889',2022,2,16.99,20,'testttt',NULL,1,1,NULL,'2024-03-25 19:02:07'),(59,'string','string','string',1999,2,20.20,4,'string',NULL,1,1,NULL,'2024-03-26 13:46:42'),(60,'strdsfsdfdsfdsfdsfsing','string','string',1999,2,20.20,4,'string',NULL,1,1,NULL,'2024-03-26 18:09:45'),(61,'sdfdsfsdfdsfdsfsd','string','string',1999,2,20.20,4,'string',NULL,1,1,NULL,'2024-03-26 18:22:12'),(62,'update test loged in','string','string',1999,2,20.20,200,'string','2024-03-29 13:39:14',1,1,1,'2024-03-27 08:01:01');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='categories table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Fiction','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(2,'Non-fiction','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(3,'Science Fiction','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(4,'Mystery','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(5,'Thriller','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(6,'Romance','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(7,'Fantasy','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(8,'Horror','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(9,'Biography','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(10,'History','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(11,'Self-help','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(12,'Cookbook','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(13,'Poetry','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(14,'Drama','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(15,'Adventure','2024-03-17 13:55:34','2024-03-17 13:55:34',1),(16,'name create test','2024-03-31 15:51:54','2024-03-31 16:04:45',0);
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(20,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id_book_id_uniq` (`book_id`,`order_id`),
  KEY `order_id_idx` (`order_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,14,4,21.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',4),(2,5,3,12.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',5),(3,2,1,24.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',8),(4,13,5,16.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',6),(5,4,3,29.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',3),(6,6,5,34.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',6),(7,8,2,17.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',6),(8,15,3,26.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',9),(9,1,4,19.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',7),(10,12,2,31.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',9),(11,9,1,22.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',1),(12,10,1,18.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',7),(13,3,1,14.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',1),(14,7,4,39.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',10),(15,11,5,27.99,'2024-03-17 15:26:19','2024-03-17 15:28:45',5),(61,1,10,19.99,'2024-04-04 13:19:39',NULL,124),(62,2,10,24.99,'2024-04-04 13:19:39',NULL,124),(63,3,10,14.99,'2024-04-04 13:19:39',NULL,124),(64,1,10,19.99,'2024-04-04 15:50:49',NULL,125),(65,2,10,24.99,'2024-04-04 15:50:49',NULL,125),(66,3,10,14.99,'2024-04-04 15:50:49',NULL,125),(67,1,2,19.99,'2024-04-04 15:51:23',NULL,126),(68,2,2,24.99,'2024-04-04 15:51:23',NULL,126),(69,3,2,14.99,'2024-04-04 15:51:23',NULL,126),(70,1,2,19.99,'2024-04-04 15:51:29',NULL,127),(71,2,2,24.99,'2024-04-04 15:51:29',NULL,127),(72,3,2,14.99,'2024-04-04 15:51:29',NULL,127),(73,1,2,19.99,'2024-04-04 16:27:24',NULL,128),(74,2,2,24.99,'2024-04-04 16:27:24',NULL,128),(75,4,1,29.99,'2024-04-04 16:27:24',NULL,128),(76,1,2,19.99,'2024-04-04 17:01:25',NULL,129),(77,2,2,24.99,'2024-04-04 17:01:25',NULL,129),(78,4,1,29.99,'2024-04-04 17:01:25',NULL,129),(79,1,2,19.99,'2024-04-05 14:05:39',NULL,130),(80,2,2,24.99,'2024-04-05 14:05:39',NULL,130),(81,3,1,14.99,'2024-04-05 14:05:39',NULL,130),(82,1,17,19.99,'2024-04-05 16:42:01',NULL,131),(83,2,5,24.99,'2024-04-05 16:42:01',NULL,131),(84,3,10,14.99,'2024-04-05 16:42:01',NULL,131);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `status` enum('PENDING','APPROVED','CANCELED','DELIVERED') NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `modified_by` bigint DEFAULT NULL COMMENT 'status modified by',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shipping_address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `shiping_address_fk_idx` (`shipping_address_id`),
  KEY `orders_ibfk_2` (`modified_by`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`modified_by`) REFERENCES `users` (`id`),
  CONSTRAINT `shiping_address_fk` FOREIGN KEY (`shipping_address_id`) REFERENCES `shipping_addresses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,3,'PENDING',1,1,'2024-03-17 15:23:00','2024-04-05 14:44:25',1),(2,4,'APPROVED',1,2,'2024-03-17 15:23:00','2024-04-05 14:44:25',2),(3,5,'PENDING',1,1,'2024-03-17 15:23:00','2024-04-05 14:44:25',3),(4,6,'APPROVED',1,2,'2024-03-17 15:23:00','2024-04-05 14:44:25',4),(5,7,'PENDING',1,1,'2024-03-17 15:23:00','2024-04-05 14:44:25',5),(6,8,'PENDING',1,2,'2024-03-17 15:23:00','2024-04-05 14:44:25',6),(7,9,'PENDING',1,1,'2024-03-17 15:23:00','2024-04-05 14:44:25',7),(8,10,'PENDING',1,2,'2024-03-17 15:23:00','2024-04-05 14:44:25',8),(9,11,'PENDING',1,1,'2024-03-17 15:23:00','2024-04-05 14:44:25',9),(10,3,'PENDING',1,2,'2024-03-17 15:23:00','2024-04-05 14:44:25',10),(124,4,'PENDING',1,NULL,'2024-04-04 13:19:39','2024-04-05 14:44:25',4),(125,4,'PENDING',1,NULL,'2024-04-04 15:50:49','2024-04-05 14:44:25',4),(126,4,'PENDING',1,NULL,'2024-04-04 15:51:23','2024-04-05 14:44:25',4),(127,4,'PENDING',1,NULL,'2024-04-04 15:51:29','2024-04-05 14:44:25',4),(128,4,'PENDING',1,NULL,'2024-04-04 16:27:24','2024-04-05 14:44:25',4),(129,4,'PENDING',1,NULL,'2024-04-04 17:01:25','2024-04-05 14:44:25',4),(130,4,'PENDING',1,NULL,'2024-04-05 14:05:39','2024-04-05 14:44:25',4),(131,39,'PENDING',1,NULL,'2024-04-05 16:42:01',NULL,52);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `role` varchar(45) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='roles table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin','2024-03-16 14:35:04'),(2,'operator','2024-03-16 14:35:04'),(3,'user','2024-03-16 14:35:04');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_addresses`
--

DROP TABLE IF EXISTS `shipping_addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_addresses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `recipient_name` varchar(255) NOT NULL,
  `address_line1` varchar(255) NOT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `state_province` varchar(100) DEFAULT NULL,
  `postal_code` varchar(20) NOT NULL,
  `country` varchar(100) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `shipping_addresses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_addresses`
--

LOCK TABLES `shipping_addresses` WRITE;
/*!40000 ALTER TABLE `shipping_addresses` DISABLE KEYS */;
INSERT INTO `shipping_addresses` VALUES (1,3,'Recipient 1','Address Line 10','Address Line 2','City 1','State/Province 1','12345','Country 1','1234567890',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(2,3,'Recipient 2','Address Line 11','Address Line 2','City 2','State/Province 2','23456','Country 2','2345678901',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(3,4,'string','Address Line 12','strinsadsag','string','string','string','string','string',1,'2024-03-17 15:16:50','2024-04-02 19:11:35'),(4,4,'Recipient 4','Address Line 13','Address Line 2','City 4','State/Province 4','45678','Country 4','4567890123',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(5,5,'Recipient 5','Address Line 14','Address Line 2','City 5','State/Province 5','56789','Country 5','5678901234',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(6,5,'Recipient 6','Address Line 15','Address Line 2','City 6','State/Province 6','67890','Country 6','6789012345',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(7,6,'Recipient 7','Address Line 16','Address Line 2','City 7','State/Province 7','78901','Country 7','7890123456',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(8,6,'Recipient 8','Address Line 17','Address Line 2','City 8','State/Province 8','89012','Country 8','8901234567',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(9,7,'Recipient 9','Address Line 18','Address Line 2','City 9','State/Province 9','90123','Country 9','9012345678',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(10,7,'Recipient 10','Address Line 19','Address Line 2','City 10','State/Province 10','01234','Country 10','0123456789',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(11,8,'Recipient 11','Address Line 20','Address Line 2','City 11','State/Province 11','12340','Country 11','1234567890',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(12,8,'Recipient 12','Address Line 21','Address Line 2','City 12','State/Province 12','23450','Country 12','2345678901',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(13,9,'Recipient 13','Address Line 22','Address Line 2','City 13','State/Province 13','34560','Country 13','3456789012',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(14,9,'Recipient 14','Address Line 23','Address Line 2','City 14','State/Province 14','45670','Country 14','4567890123',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(15,10,'Recipient 15','Address Line 24','Address Line 2','City 15','State/Province 15','56780','Country 15','5678901234',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(16,10,'Recipient 16','Address Line 25','Address Line 2','City 16','State/Province 16','67890','Country 16','6789012345',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(17,11,'Recipient 17','Address Line 26','Address Line 2','City 17','State/Province 17','78900','Country 17','7890123456',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(18,11,'Recipient 18','Address Line 27','Address Line 2','City 18','State/Province 18','89010','Country 18','8901234567',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(19,3,'Recipient 19','Address Line 28','Address Line 2','City 19','State/Province 19','90120','Country 19','9012345678',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(20,4,'Recipient 20','Address Line 29','Address Line 2','City 20','State/Province 20','01230','Country 20','0123456789',1,'2024-03-17 15:16:50','2024-03-31 22:17:22'),(51,4,'string','Address Line 12','strinsadsag','string','string','string','string','string',0,'2024-04-02 17:25:48','2024-04-02 19:11:35'),(52,39,'string','Address Line 12','string22','string','string','string','string','string',1,'2024-04-05 16:41:14',NULL);
/*!40000 ALTER TABLE `shipping_addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(254) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `role_id_fk_idx` (`role_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='users table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@admin.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','admin','admin','1234','2024-03-16 14:49:18','2024-03-22 18:09:16',1,1),(2,'operator@operator.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','operator','operator','123','2024-03-17 15:06:04','2024-03-22 18:09:16',1,2),(3,'user@user.com','$2a$10$d7p4D2yR3Bi64AVdQpZ80eftNFf9y9U3Gp.N7KRm6jDVwVA4U9nGK','update','update','update','2024-03-17 15:06:04','2024-03-27 10:24:28',1,3),(4,'user1@example.com','$2a$10$9Ehd8KtgFaSXs77Go2f68.08vrVWEF5uyUXTUPT7dMCknHRW1O5Hu','update','updatetessssss','6787687','2024-03-17 15:08:01','2024-04-05 16:34:29',1,3),(5,'user2@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Jane','Doe','987654321','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(6,'user3@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Michael','Smith','555555555','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(7,'user4@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Emily','Johnson','111111111','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(8,'user5@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','William','Brown','222222222','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(9,'user6@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Emma','Jones','333333333','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(10,'user7@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Matthew','Taylor','444444444','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(11,'user8@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Olivia','Wilson','666666666','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(12,'user9@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Daniel','Martinez','777777777','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(13,'user10@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Sophia','Anderson','888888888','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(14,'user11@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','James','Hernandez','999999999','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(15,'user12@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Isabella','Garcia','1010101010','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(16,'user13@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Logan','Young','1212121212','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(17,'user14@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Ella','King','1313131313','2024-03-17 15:08:01','2024-03-22 18:09:16',1,3),(18,'user15@example.com','$2a$10$fiPBbFBEn6Yfut7veJJ4Y.4FT4t801xUMbGHJFVFsy3XXkdX0Y/wu','Benjamin','Lee','1414141414','2024-03-17 15:08:01','2024-03-22 18:09:16',0,3),(35,'testregister@test.com','$2a$10$0XO3CHeF.e9GiafmAUE7buLNb/iTuFgCNyZ5Rlupf.1FbgZ2cCSZS','testregister','testregister','123456789','2024-03-22 18:09:21',NULL,1,3),(36,'testttt@gmail.com','$2a$10$DViY0FlQRi7Rt/SZz3aMoOFHyuribzn1tQJpbGEw/2FwgXojx1cua','string','string','string','2024-03-23 22:43:41',NULL,1,3),(38,'userTESTTTT@user.com','$2a$10$0e.U5VqBtu.QY5x.iul6duzYsEI2psUxaV9bwUglQNqlakJFI9v0y','string','string','string','2024-04-05 16:29:38',NULL,0,3),(39,'TEstfinal@user.com','$2a$10$neHa2QA8EWXFSPWkPW9K/.1O7J69CzBDIqefx/QE0qZzdIqHhJCRO','string','string','string','2024-04-05 16:31:22',NULL,1,3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 11:19:38
