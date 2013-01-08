-- MySQL dump 10.13  Distrib 5.5.27, for Win64 (x86)
--
-- Host: localhost    Database: workflowdb
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `actions`
--

DROP TABLE IF EXISTS `actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actions` (
  `ActionId` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) DEFAULT NULL,
  `ActionName` varchar(30) DEFAULT NULL,
  `ActionDescription` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ActionId`),
  KEY `WFTypeID` (`WFTypeID`),
  CONSTRAINT `actions_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actions`
--

LOCK TABLES `actions` WRITE;
/*!40000 ALTER TABLE `actions` DISABLE KEYS */;
INSERT INTO `actions` VALUES (201,1,'apply','applied'),(202,1,'approve','approval action'),(203,1,'reject','rejected'),(204,2,'apply','applied'),(205,2,'check availability','check asset availability'),(206,2,'approve','approval action'),(207,2,'reject','rejected');
/*!40000 ALTER TABLE `actions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(25) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'wfadmin','wfadmin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventhistory`
--

DROP TABLE IF EXISTS `eventhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventhistory` (
  `EventHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) NOT NULL,
  `WFInstanceID` int(11) NOT NULL,
  `SeqID` int(11) NOT NULL,
  `EventDateTime` datetime DEFAULT NULL,
  `CreatorMemberID` int(11) NOT NULL,
  `ActorMemberID` int(11) NOT NULL,
  PRIMARY KEY (`EventHistoryID`),
  KEY `WFTypeID` (`WFTypeID`),
  KEY `WFInstanceID` (`WFInstanceID`),
  KEY `SeqID` (`SeqID`),
  KEY `CreatorMemberID` (`CreatorMemberID`),
  KEY `ActorMemberID` (`ActorMemberID`),
  CONSTRAINT `eventhistory_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`),
  CONSTRAINT `eventhistory_ibfk_2` FOREIGN KEY (`WFInstanceID`) REFERENCES `workflowinstance` (`WFInstanceID`),
  CONSTRAINT `eventhistory_ibfk_3` FOREIGN KEY (`SeqID`) REFERENCES `statesequencetable` (`SeqID`),
  CONSTRAINT `eventhistory_ibfk_4` FOREIGN KEY (`CreatorMemberID`) REFERENCES `member` (`MemberID`),
  CONSTRAINT `eventhistory_ibfk_5` FOREIGN KEY (`ActorMemberID`) REFERENCES `member` (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=322 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventhistory`
--

LOCK TABLES `eventhistory` WRITE;
/*!40000 ALTER TABLE `eventhistory` DISABLE KEYS */;
INSERT INTO `eventhistory` VALUES (301,1,11,501,'2012-12-12 12:12:12',1001,1004),(302,1,11,502,'2012-12-13 15:30:20',1001,1006),(303,1,12,501,'2012-12-14 10:15:00',1002,1005),(304,1,11,503,'2012-12-14 14:14:05',1001,1007),(305,1,12,502,'2012-12-15 09:30:06',1002,1006),(306,1,11,504,'2012-12-15 13:45:12',1001,1008),(307,1,12,503,'2012-12-16 17:20:20',1002,1007),(308,1,13,501,'2012-12-18 00:00:00',1003,1004),(309,1,13,502,'2012-12-18 13:50:05',1003,1006),(310,1,12,504,'2012-12-17 14:30:06',1002,1008),(311,1,13,503,'2012-12-19 11:50:12',1003,1007),(312,1,13,504,'2012-12-20 12:39:20',1003,1008),(313,2,14,510,'2012-12-21 09:30:00',1009,1011),(314,2,14,511,'2012-12-21 11:45:05',1009,1011),(315,2,14,514,'2012-12-21 16:15:06',1009,1012),(316,2,15,510,'2012-12-22 10:15:12',1010,1011),(317,2,15,511,'2012-12-22 11:00:20',1010,1012),(318,2,15,513,'2012-12-22 15:30:00',1010,1012),(319,2,14,515,'2012-12-22 12:30:05',1009,1013),(320,2,14,517,'2012-12-22 15:15:06',1009,1014),(321,2,14,513,'2012-12-22 17:30:06',1009,1012);
/*!40000 ALTER TABLE `eventhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `MemberID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `Fname` varchar(30) DEFAULT NULL,
  `Lname` varchar(30) DEFAULT NULL,
  `emailID` varchar(30) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `ManagerMemberid` int(11) DEFAULT NULL,
  PRIMARY KEY (`MemberID`),
  KEY `RoleId` (`RoleId`),
  KEY `ManagerMemberid` (`ManagerMemberid`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleID`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`ManagerMemberid`) REFERENCES `member` (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=1015 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1001,401,'Appula','Apparao','apparao.appu@gmail.com',9190002002,'Apparao','Password1','Flat 301, Appu Apts, Koramangala',NULL),(1002,401,'Kharchula','Kantha Reddy','kharchula@yahoo.com',9880988080,'Kantha Reddy','Password2','Phase 1, E.City',NULL),(1003,401,'UltaPulta','Udhaar','ultapulta@yahoo.co.in',9716789023,'Udhaar','Password3','7th cross, Indira Nagar',NULL),(1004,402,'Gundu','Gumaastha','nenu.gunduboss@gmail.com',8090706050,'Gumaastha','Password4','4th Block, Jaya Nagar',NULL),(1005,402,'Rathnala','Rathaiah','rathnalu.ivvanu@gmail.com',9869058704,'Rathaiah','Password5','8th Main, Richmond Circle',NULL),(1006,403,'Khulla','Khullam','khullam.khulla@gmail.com',9776045673,'Khullam','Password6','9th Street, Cubbon Road',NULL),(1007,404,'Sollu','Kamitee','idi_sollu@yahoo.com',8990123456,'Kamitee','Password7','18th Block, Jaya Nagar',NULL),(1008,405,'Manjooru','Mallanna','na_peru_mallanna@yahoo.com',9786954923,'Mallanna','Password8','H.No-12, Singasandra',NULL),(1009,406,'ManchiPanodu','Satthi','o.manchipanodu@gmail.com',9999988888,'Satthi','Password9','33rd cross, WhiteField',NULL),(1010,406,'Katthi','Karmikudu','nenu_Katthi@yahoo.co.in',9786453120,'Karmikudu','Password10','12th Main, Marathahalli',NULL),(1011,407,'Yejamani','Yenkaiah','Yenkaiah007@yahoo.com',8795462130,'Yenkaiah','Password11','Phase 2, BTM Layout',NULL),(1012,408,'Saha','Sahayakudu','Saha12345@gmail.com',9080701234,'Sahayakudu','Password12','3rd block, J P Nagar',NULL),(1013,409,'Alajadi','Adhikari','Alajadi_000@yahoo.com',9848082919,'Adhikari','Password13','11th Main, 3rd street, Rajaji Nagar',NULL),(1014,410,'Jambalakadi','Pamba Rao','jumbo.jamba@gmail.com',9887766554,'Pamba Rao','Password14','10th Cross, Bannerghatta',NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) DEFAULT NULL,
  `RoleName` varchar(20) DEFAULT NULL,
  `Description` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`RoleID`),
  KEY `WFTypeID` (`WFTypeID`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=414 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (401,1,'Customer','Customer who applies for loan'),(402,1,'Bank Teller','Bank Teller who verifies background'),(403,1,'Loan_Officer_ahdj','Loan officer who reviews the application'),(404,1,'Loan Committee','Decides the credit limit'),(405,1,'Loan Manager','Grant/Reject the loan'),(406,2,'Employee','Employee who requests the asset'),(407,2,'ReportingManager','Manager to whom employee reports'),(408,2,'ITHelpdeskEmp','Helpdesk Employee'),(409,2,'ITManager','IT manager'),(410,2,'AssetManager','Asset Dept head'),(411,2,'abcde','fghij'),(412,2,'nm','gcf'),(413,3,'Test Role','Test role added_gnn');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `StateID` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) DEFAULT NULL,
  `StateName` varchar(40) DEFAULT NULL,
  `StateDescription` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`StateID`),
  KEY `WFTypeID` (`WFTypeID`),
  CONSTRAINT `states_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (111,1,'default','Initial default state'),(112,1,'loan applied','loan applied'),(113,1,'background verified','background verified'),(114,1,'loan application reviewed','loan application reviewed'),(115,1,'credit limit established','credit limit established'),(116,1,'loan granted','loan granted'),(117,1,'loan rejected','loan rejected'),(118,2,'default','Initial default state'),(119,2,'asset requested','asset requested'),(120,2,'asset approved','asset approved'),(121,2,'asset purchased','asset purchased'),(122,2,'asset rejected','asset rejected'),(123,2,'asset issued','asset issued');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statesequencetable`
--

DROP TABLE IF EXISTS `statesequencetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statesequencetable` (
  `SeqID` int(11) NOT NULL DEFAULT '0',
  `WFTypeID` int(11) DEFAULT NULL,
  `RoleID` int(11) DEFAULT NULL,
  `PreviousStateID` int(11) DEFAULT NULL,
  `NextStateID` int(11) DEFAULT NULL,
  `ActionID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SeqID`),
  KEY `WFTypeID` (`WFTypeID`),
  KEY `RoleID` (`RoleID`),
  KEY `ActionID` (`ActionID`),
  KEY `PreviousStateID` (`PreviousStateID`),
  KEY `NextStateID` (`NextStateID`),
  CONSTRAINT `statesequencetable_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`),
  CONSTRAINT `statesequencetable_ibfk_2` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`),
  CONSTRAINT `statesequencetable_ibfk_3` FOREIGN KEY (`ActionID`) REFERENCES `actions` (`ActionId`),
  CONSTRAINT `statesequencetable_ibfk_4` FOREIGN KEY (`PreviousStateID`) REFERENCES `states` (`StateID`),
  CONSTRAINT `statesequencetable_ibfk_5` FOREIGN KEY (`NextStateID`) REFERENCES `states` (`StateID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statesequencetable`
--

LOCK TABLES `statesequencetable` WRITE;
/*!40000 ALTER TABLE `statesequencetable` DISABLE KEYS */;
INSERT INTO `statesequencetable` VALUES (501,1,401,111,112,201),(502,1,402,112,113,202),(503,1,402,112,117,203),(504,1,403,113,114,202),(505,1,403,113,117,203),(506,1,404,114,115,202),(507,1,404,114,117,203),(508,1,405,115,116,202),(509,1,405,115,117,203),(510,2,406,118,119,204),(511,2,407,119,120,206),(512,2,407,119,122,207),(513,2,408,120,123,205),(514,2,408,120,119,205),(515,2,409,119,120,206),(516,2,409,119,122,207),(517,2,410,120,121,205);
/*!40000 ALTER TABLE `statesequencetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `wfinstancedetails`
--

DROP TABLE IF EXISTS `wfinstancedetails`;
/*!50001 DROP VIEW IF EXISTS `wfinstancedetails`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `wfinstancedetails` (
  `wfinstanceid` tinyint NOT NULL,
  `ownerid` tinyint NOT NULL,
  `ownername` tinyint NOT NULL,
  `wfname` tinyint NOT NULL,
  `wfitemcategory` tinyint NOT NULL,
  `wfitemname` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `statedescription` tinyint NOT NULL,
  `creationdatetime` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `workflowdata`
--

DROP TABLE IF EXISTS `workflowdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowdata` (
  `WFDataID` int(11) NOT NULL AUTO_INCREMENT,
  `WFDataDefID` int(11) DEFAULT NULL,
  `WFInstanceID` int(11) DEFAULT NULL,
  `Value` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`WFDataID`),
  KEY `WFDataDefID` (`WFDataDefID`),
  KEY `WFInstanceID` (`WFInstanceID`),
  CONSTRAINT `workflowdata_ibfk_1` FOREIGN KEY (`WFDataDefID`) REFERENCES `workflowdatadef` (`WFDataDefID`),
  CONSTRAINT `workflowdata_ibfk_2` FOREIGN KEY (`WFInstanceID`) REFERENCES `workflowinstance` (`WFInstanceID`)
) ENGINE=InnoDB AUTO_INCREMENT=1209 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowdata`
--

LOCK TABLES `workflowdata` WRITE;
/*!40000 ALTER TABLE `workflowdata` DISABLE KEYS */;
INSERT INTO `workflowdata` VALUES (1201,1101,11,'50000'),(1202,1102,11,'Asst Professor'),(1203,1103,11,'33'),(1204,1104,11,'600000'),(1205,1105,11,'100000'),(1206,1106,11,'800000'),(1207,1107,14,'Software Engineer'),(1208,1107,16,'Database Administrator');
/*!40000 ALTER TABLE `workflowdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowdatadef`
--

DROP TABLE IF EXISTS `workflowdatadef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowdatadef` (
  `WFDataDefID` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `isreadonly` int(11) DEFAULT NULL,
  `constantvalue` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`WFDataDefID`),
  KEY `WFTypeID` (`WFTypeID`),
  CONSTRAINT `workflowdatadef_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=1108 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowdatadef`
--

LOCK TABLES `workflowdatadef` WRITE;
/*!40000 ALTER TABLE `workflowdatadef` DISABLE KEYS */;
INSERT INTO `workflowdatadef` VALUES (1101,1,'Salary','Salary of the person applying loan',0,NULL),(1102,1,'Profession','Profession of the person applying loan',0,NULL),(1103,1,'Age','Age of the person applying loan',0,NULL),(1104,1,'Loan Amount','Loan amount for which the customer is applying',0,NULL),(1105,1,'Loan Lower Limit','Lower limit for loan amount',1,'200000'),(1106,1,'Loan Upper Limit','Upper limit for loan amount',1,'1000000'),(1107,2,'Designation','Designation of the employee applying for the asset',0,NULL);
/*!40000 ALTER TABLE `workflowdatadef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowinstance`
--

DROP TABLE IF EXISTS `workflowinstance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowinstance` (
  `WFInstanceID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` int(11) NOT NULL,
  `WFTypeID` int(11) NOT NULL,
  `CreationDateTime` datetime DEFAULT NULL,
  `CurrentState` int(11) DEFAULT NULL,
  `WFItemID` int(11) DEFAULT NULL,
  PRIMARY KEY (`WFInstanceID`),
  KEY `MemberID` (`MemberID`),
  KEY `CurrentState` (`CurrentState`),
  KEY `WFTypeID` (`WFTypeID`),
  KEY `WFItemID` (`WFItemID`),
  CONSTRAINT `workflowinstance_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `member` (`MemberID`),
  CONSTRAINT `workflowinstance_ibfk_2` FOREIGN KEY (`CurrentState`) REFERENCES `states` (`StateID`),
  CONSTRAINT `workflowinstance_ibfk_3` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`),
  CONSTRAINT `workflowinstance_ibfk_4` FOREIGN KEY (`WFItemID`) REFERENCES `workflowitem` (`WFItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowinstance`
--

LOCK TABLES `workflowinstance` WRITE;
/*!40000 ALTER TABLE `workflowinstance` DISABLE KEYS */;
INSERT INTO `workflowinstance` VALUES (11,1001,1,'2012-12-12 12:12:12',116,902),(12,1002,1,'2012-12-14 10:15:00',116,902),(13,1003,1,'2012-12-20 12:39:49',116,904),(14,1009,2,'2012-12-22 15:30:25',123,905),(15,1010,2,'2012-12-22 17:30:12',123,914),(16,1009,2,'2012-12-28 22:40:02',118,914),(17,1009,2,'2013-01-01 16:18:54',118,915);
/*!40000 ALTER TABLE `workflowinstance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowitem`
--

DROP TABLE IF EXISTS `workflowitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowitem` (
  `WFItemID` int(11) NOT NULL AUTO_INCREMENT,
  `WFTypeID` int(11) DEFAULT NULL,
  `WFItemType` varchar(30) DEFAULT NULL,
  `WFItemCategory` varchar(30) DEFAULT NULL,
  `WFItemName` varchar(30) DEFAULT NULL,
  `QuantityAvail` int(11) DEFAULT NULL,
  PRIMARY KEY (`WFItemID`),
  KEY `WFTypeID` (`WFTypeID`),
  CONSTRAINT `workflowitem_ibfk_1` FOREIGN KEY (`WFTypeID`) REFERENCES `workflowtype` (`WFTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=916 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowitem`
--

LOCK TABLES `workflowitem` WRITE;
/*!40000 ALTER TABLE `workflowitem` DISABLE KEYS */;
INSERT INTO `workflowitem` VALUES (901,1,'Bank Loan','Education Loan','Shiksha',10),(902,1,'Bank Loan','Vehicle Loan','Aapka Gaadi',5),(903,1,'Bank Loan','House Loan','Ghar ke liye',15),(904,1,'Bank Loan','Gold Loan','Sona',10),(905,2,'Asset','Hardware','Headphone',20),(906,2,'Asset','Hardware','Laptop',5),(907,2,'Asset','Hardware','Speaker',15),(908,2,'Asset','Hardware','Keyboard',20),(909,2,'Asset','Hardware','Mouse',10),(910,2,'Asset','Hardware','RAM',3),(911,2,'Asset','Software','OS',5),(912,2,'Asset','Software','Trend Micro Antivirus',10),(913,2,'Asset','Software','MS Office',4),(914,2,'Asset','Software','Oracle 11g',3),(915,2,'Asset','Software','Tortoise SVN',2);
/*!40000 ALTER TABLE `workflowitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflowtype`
--

DROP TABLE IF EXISTS `workflowtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflowtype` (
  `WFTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `WFName` varchar(30) NOT NULL,
  `Description` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`WFTypeID`),
  UNIQUE KEY `WFName` (`WFName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflowtype`
--

LOCK TABLES `workflowtype` WRITE;
/*!40000 ALTER TABLE `workflowtype` DISABLE KEYS */;
INSERT INTO `workflowtype` VALUES (1,'Bank Loan','This workflow deals with bank loan processing'),(2,'Asset Allocation','This workflow deals allocating hardware/software assets in a company'),(3,'TestWorkflow_1','This is test'),(4,'sjfsdf','jkafjksdf');
/*!40000 ALTER TABLE `workflowtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `wfinstancedetails`
--

/*!50001 DROP TABLE IF EXISTS `wfinstancedetails`*/;
/*!50001 DROP VIEW IF EXISTS `wfinstancedetails`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `wfinstancedetails` AS select `i`.`WFInstanceID` AS `wfinstanceid`,`i`.`MemberID` AS `ownerid`,concat(`m`.`Fname`,' ',`m`.`Lname`) AS `ownername`,`w`.`WFName` AS `wfname`,`wi`.`WFItemCategory` AS `wfitemcategory`,`wi`.`WFItemName` AS `wfitemname`,`s`.`StateName` AS `state`,`s`.`StateDescription` AS `statedescription`,`i`.`CreationDateTime` AS `creationdatetime` from ((((`workflowinstance` `i` join `workflowtype` `w`) join `member` `m`) join `workflowitem` `wi`) join `states` `s`) where ((`i`.`WFTypeID` = `w`.`WFTypeID`) and (`i`.`MemberID` = `m`.`MemberID`) and (`wi`.`WFItemID` = `i`.`WFItemID`) and (`s`.`StateID` = `i`.`CurrentState`) and exists(select `member`.`MemberID` from `member` where (`member`.`RoleId` in (select `statesequencetable`.`RoleID` from `statesequencetable` where `statesequencetable`.`PreviousStateID` in (select `states`.`StateID` from `states` where (`states`.`StateName` = 'default'))) and (`member`.`MemberID` = 1011))) and (`i`.`MemberID` = 1011)) union all select `i`.`WFInstanceID` AS `wfinstanceid`,`i`.`MemberID` AS `ownerid`,concat(`m`.`Fname`,' ',`m`.`Lname`) AS `ownername`,`w`.`WFName` AS `wfname`,`wi`.`WFItemCategory` AS `wfitemcategory`,`wi`.`WFItemName` AS `wfitemname`,`s`.`StateName` AS `state`,`s`.`StateDescription` AS `statedescription`,`i`.`CreationDateTime` AS `creationdatetime` from ((((`workflowinstance` `i` join `workflowtype` `w`) join `member` `m`) join `workflowitem` `wi`) join `states` `s`) where ((`i`.`WFTypeID` = `w`.`WFTypeID`) and (`i`.`MemberID` = `m`.`MemberID`) and (`wi`.`WFItemID` = `i`.`WFItemID`) and (`s`.`StateID` = `i`.`CurrentState`) and `w`.`WFTypeID` in (select `r`.`WFTypeID` from (`role` `r` join `member` `m`) where ((`m`.`RoleId` = `r`.`RoleID`) and (`m`.`MemberID` = 1011))) and (not(exists(select `member`.`MemberID` from `member` where (`member`.`RoleId` in (select `statesequencetable`.`RoleID` from `statesequencetable` where `statesequencetable`.`PreviousStateID` in (select `states`.`StateID` from `states` where (`states`.`StateName` = 'default'))) and (`member`.`MemberID` = 1011)))))) */;
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

-- Dump completed on 2013-01-09  0:21:20
