/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.20-nt-max : Database - watch-world
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`watch-world` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci */;

USE `watch-world`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `ActivityPicturePath` varchar(45) collate utf8_czech_ci default NULL,
  `StoreID` int(11) default NULL,
  KEY `FK_activity` (`StoreID`),
  CONSTRAINT `FK_activity` FOREIGN KEY (`StoreID`) REFERENCES `store_info` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `activity` */

/*Table structure for table `admin_info` */

DROP TABLE IF EXISTS `admin_info`;

CREATE TABLE `admin_info` (
  `AdminID` varchar(15) collate utf8_czech_ci NOT NULL,
  `Pwd` varchar(15) collate utf8_czech_ci NOT NULL default '',
  PRIMARY KEY  (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `admin_info` */

/*Table structure for table `goods_display` */

DROP TABLE IF EXISTS `goods_display`;

CREATE TABLE `goods_display` (
  `GoodsID` int(11) default NULL,
  `Brand` varchar(15) collate utf8_czech_ci default NULL,
  `Time` time default NULL,
  KEY `FK_goods_display` (`GoodsID`),
  CONSTRAINT `FK_goods_display` FOREIGN KEY (`GoodsID`) REFERENCES `goods_info` (`GoodsID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `goods_display` */

/*Table structure for table `goods_info` */

DROP TABLE IF EXISTS `goods_info`;

CREATE TABLE `goods_info` (
  `GoodsID` int(15) NOT NULL auto_increment,
  `GoodsName` varchar(45) collate utf8_czech_ci default NULL,
  `GoodsPicturePath` varchar(45) collate utf8_czech_ci default NULL,
  `Price` float default NULL,
  `Brand` varchar(15) collate utf8_czech_ci default NULL,
  `Color` varchar(15) collate utf8_czech_ci default NULL,
  `Model` varchar(15) collate utf8_czech_ci default NULL,
  `Number` int(11) default NULL,
  `StoreID` int(11) default NULL,
  `SalesVolumes` int(11) default NULL,
  PRIMARY KEY  (`GoodsID`),
  KEY `FK_goods_info` (`StoreID`),
  CONSTRAINT `FK_goods_info` FOREIGN KEY (`StoreID`) REFERENCES `store_info` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `goods_info` */

insert  into `goods_info`(`GoodsID`,`GoodsName`,`GoodsPicturePath`,`Price`,`Brand`,`Color`,`Model`,`Number`,`StoreID`,`SalesVolumes`) values (2,'手表2','customer/IMG/pic3.jpg',1001,'劳力士2','颜色2','型号2',102,8891,0),(3,'KOOLIFE 华为荣耀7钢化玻璃膜 高透膜 手机屏幕保护贴膜','url1',1000,'劳力士1','颜色1','型号1',3,8892,35),(6,'手表4','url4',1003,'劳力士4','颜色4','型号4',104,8891,4),(8,'手表6','url6',1005,'劳力士6','颜色6','型号6',106,8891,6),(9,'手表7','logo.png.png',1006,'劳力士7','#000000','型号7',107,8890,7),(10,'手表8','url8',1007,'劳力士8','颜色8','型号8',108,8891,8),(11,'手表11','url9',1008,'劳力士9','颜色9','型号9',85,8892,43),(12,'手表0','url0',999,'劳力士0','颜色0','型号0',100,8890,0),(13,'手表1','url1',1000,'劳力士1','颜色1','型号1',101,8890,1),(14,'手表2','url2',1001,'劳力士2','颜色2','型号2',102,8890,2),(15,'手表3','url3',1002,'劳力士3','颜色3','型号3',103,8890,3),(16,'手表4','url4',1003,'劳力士4','颜色4','型号4',104,8890,4),(17,'手表5','url5',1004,'劳力士5','颜色5','型号5',105,8890,5),(18,'手表6','url6',1005,'劳力士6','颜色6','型号6',106,8890,6),(19,'手表7','url7',1006,'劳力士7','颜色7','型号7',107,8890,7),(20,'手表8','url8',1007,'劳力士8','颜色8','型号8',108,8890,8),(21,'手表9','url9',1008,'劳力士9','颜色9','型号9',109,8890,9),(22,'1234','1495684497596.png',1234,'1234','#ff8000','1234',1234,8890,0),(23,'海明威(HEMINGWAY)手表 男士手表日历防水石英表德国潮流男表 H8700M-51','1495799886591.png',368,'HEMINGWAY','#002c57','H8700M-51',12,8892,0),(24,'1234','1495819298500.png',222,'222','#000000','222',222,8892,0),(25,'111','1495819320149.png',111,'111','#000000','1111',1111,8892,0),(26,'123','1495843238068.png',123,'123','#000000','123',123,8892,0);

/*Table structure for table `goods_review` */

DROP TABLE IF EXISTS `goods_review`;

CREATE TABLE `goods_review` (
  `GoodsID` varchar(15) collate utf8_czech_ci default NULL,
  `UserName` varchar(15) collate utf8_czech_ci default NULL,
  `Comment` varchar(100) collate utf8_czech_ci default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `goods_review` */

/*Table structure for table `order_goods` */

DROP TABLE IF EXISTS `order_goods`;

CREATE TABLE `order_goods` (
  `OrderID` varchar(15) collate utf8_czech_ci default NULL,
  `GoodsID` varchar(15) collate utf8_czech_ci default NULL,
  `GoodsName` varchar(45) collate utf8_czech_ci default NULL,
  `StoreID` varchar(15) collate utf8_czech_ci default NULL,
  `Price` int(11) default NULL,
  `Brand` varchar(15) collate utf8_czech_ci default NULL,
  `Color` varchar(15) collate utf8_czech_ci default NULL,
  `Model` varchar(15) collate utf8_czech_ci default NULL,
  `BuyAmount` int(11) default NULL,
  `GoodsPicturePath` varchar(45) collate utf8_czech_ci default NULL,
  KEY `FK_order_goods` (`OrderID`),
  CONSTRAINT `FK_order_goods` FOREIGN KEY (`OrderID`) REFERENCES `order_info` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `order_goods` */

insert  into `order_goods`(`OrderID`,`GoodsID`,`GoodsName`,`StoreID`,`Price`,`Brand`,`Color`,`Model`,`BuyAmount`,`GoodsPicturePath`) values ('123456789','3','海明威(HEMINGWAY)手表 男士手表日历防水石英表德国潮流男表 H8700M-51','8892',NULL,NULL,NULL,NULL,1,NULL),('123456789','11','海明威(HEMINGWAY)手表 男士手表日历防水石英表德国潮流男表 H8700M-51','8892',NULL,NULL,NULL,NULL,1,NULL),('456','11','海明威(HEMINGWAY)手表 男士手表日历防水石英表德国潮流男表 H8700M-51','8892',NULL,NULL,NULL,NULL,1,NULL);

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `OrderID` varchar(15) collate utf8_czech_ci NOT NULL default '',
  `OrderStatus` varchar(15) collate utf8_czech_ci default NULL,
  `PaymentTime` timestamp NULL default NULL,
  `SendGoodsTime` timestamp NULL default NULL,
  `StoreName` varchar(15) collate utf8_czech_ci default NULL,
  `UserName` varchar(15) collate utf8_czech_ci default NULL,
  `TotalPrice` int(11) default NULL,
  `Address` varchar(45) collate utf8_czech_ci default NULL,
  `Telephone` varchar(11) collate utf8_czech_ci default NULL,
  PRIMARY KEY  (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `order_info` */

insert  into `order_info`(`OrderID`,`OrderStatus`,`PaymentTime`,`SendGoodsTime`,`StoreName`,`UserName`,`TotalPrice`,`Address`,`Telephone`) values ('123456789','已发货','2017-05-26 13:11:11','2017-05-26 21:02:11','手表店1',NULL,NULL,NULL,NULL),('456','已发货','2017-05-26 13:11:11','2017-05-26 21:08:16','手表店1',NULL,NULL,NULL,NULL);

/*Table structure for table `return` */

DROP TABLE IF EXISTS `return`;

CREATE TABLE `return` (
  `ReturnID` varchar(15) collate utf8_czech_ci NOT NULL,
  `OrderID` varchar(15) collate utf8_czech_ci default NULL,
  `TotalPrice` int(11) default NULL,
  PRIMARY KEY  (`ReturnID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `return` */

/*Table structure for table `store_info` */

DROP TABLE IF EXISTS `store_info`;

CREATE TABLE `store_info` (
  `StoreID` int(11) NOT NULL auto_increment,
  `LoginName` varchar(15) collate utf8_czech_ci default NULL,
  `Pwd` varchar(15) collate utf8_czech_ci default NULL,
  `StoreName` varchar(15) collate utf8_czech_ci default NULL,
  `Owner` varchar(15) collate utf8_czech_ci default NULL,
  `RegTime` varchar(45) collate utf8_czech_ci default NULL,
  `Telephone` varchar(11) collate utf8_czech_ci default NULL,
  PRIMARY KEY  (`StoreID`),
  UNIQUE KEY `LoginName` (`LoginName`),
  UNIQUE KEY `StoreName` (`StoreName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci MIN_ROWS=8888 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `store_info` */

insert  into `store_info`(`StoreID`,`LoginName`,`Pwd`,`StoreName`,`Owner`,`RegTime`,`Telephone`) values (8890,'1234','2234','手表店4','张4','2017年05月15日','18832223124'),(8891,'哈哈3','123456','手表店2','张2','2017年05月15日','1882'),(8892,'12','12','手表店1','张1','2017年05月15日','1881'),(8893,'1','123','123','3','2017年05月17日','13214142866'),(8894,'4','4','5','5','2017年05月17日','55555555555'),(8895,'sd','11','WW','23222','2017年05月17日','98292738333'),(8896,'用户','mima','店铺','店主','2017年05月17日','12345678919'),(8897,'wq','w','我','水电费','2017年05月17日','12345678910'),(8898,'哈哈','2','33','11','2017年05月17日','12222222222'),(8899,'随时随地','sd','收到','收到','2017年05月17日','11111111121'),(8900,'娃儿我v','sdf','是是是','十三','2017年05月17日','33112233211'),(8901,'123','123','新店铺','123','2017年05月17日','18814142866'),(8902,'dsf','123','手表店','sdfsdfsdf','2017年05月18日','18814142886'),(8903,'史蒂夫','sdf','史蒂夫旗舰店','史蒂夫','2017年05月19日','18814142887'),(8904,'3456','123','12333','12333','2017年05月20日','15119662432'),(8905,'34567','123','123332','123332','2017年05月20日','15119662433'),(8906,'234','234','234','234','2017年05月21日','15116789876');

/*Table structure for table `user_data` */

DROP TABLE IF EXISTS `user_data`;

CREATE TABLE `user_data` (
  `UserId` varchar(15) collate utf8_czech_ci NOT NULL,
  `UserName` varchar(15) collate utf8_czech_ci default NULL,
  `Age` int(11) default NULL,
  `Sex` varchar(10) collate utf8_czech_ci default NULL,
  `Portrait` varchar(100) collate utf8_czech_ci default NULL,
  `Address` varchar(50) collate utf8_czech_ci default NULL,
  `Telephone` varchar(15) collate utf8_czech_ci default NULL,
  PRIMARY KEY  (`UserId`),
  CONSTRAINT `FK_userdata` FOREIGN KEY (`UserId`) REFERENCES `user_info` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `user_data` */

/*Table structure for table `user_goods` */

DROP TABLE IF EXISTS `user_goods`;

CREATE TABLE `user_goods` (
  `GoodsID` int(15) default NULL,
  `UserID` varchar(15) collate utf8_czech_ci default NULL,
  `Number` int(11) default NULL,
  KEY `FK_user_goods` (`GoodsID`),
  KEY `FK_user_info` (`UserID`),
  CONSTRAINT `FK_user_goods` FOREIGN KEY (`GoodsID`) REFERENCES `goods_info` (`GoodsID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_info` FOREIGN KEY (`UserID`) REFERENCES `user_info` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `user_goods` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `UserID` varchar(15) collate utf8_czech_ci NOT NULL default '',
  `Pwd` varchar(15) collate utf8_czech_ci NOT NULL default '',
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_info` */

insert  into `user_info`(`UserID`,`Pwd`) values ('123','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
