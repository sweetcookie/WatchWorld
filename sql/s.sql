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
  `GoodsName` varchar(15) collate utf8_czech_ci default NULL,
  `GoodsPicturePath` varchar(45) collate utf8_czech_ci default NULL,
  `Price` float default NULL,
  `Brand` varchar(15) collate utf8_czech_ci default NULL,
  `MovementStyle` varchar(15) collate utf8_czech_ci default NULL,
  `Color` varchar(15) collate utf8_czech_ci default NULL,
  `Material` varchar(15) collate utf8_czech_ci default NULL,
  `Shape` varchar(15) collate utf8_czech_ci default NULL,
  `Waterproof` varchar(15) collate utf8_czech_ci default NULL,
  `Style` varchar(15) collate utf8_czech_ci default NULL,
  `Model` varchar(15) collate utf8_czech_ci default NULL,
  `Number` int(11) default NULL,
  `StoreID` int(11) default NULL,
  `SalesVolumes` int(11) default NULL,
  PRIMARY KEY  (`GoodsID`),
  KEY `FK_goods_info` (`StoreID`),
  CONSTRAINT `FK_goods_info` FOREIGN KEY (`StoreID`) REFERENCES `store_info` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `goods_info` */

insert  into `goods_info`(`GoodsID`,`GoodsName`,`GoodsPicturePath`,`Price`,`Brand`,`MovementStyle`,`Color`,`Material`,`Shape`,`Waterproof`,`Style`,`Model`,`Number`,`StoreID`,`SalesVolumes`) values (1,'手表','url',10000,'卡西欧','机芯类型','红色','材质','形状','防水深度','风格','型号',100,8888,0),(2,'手表','url',999,'劳力士','机芯类型','颜色','材质','形状','防水深度','风格','型号',100,8888,0);

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
  `GoodsName` varchar(15) collate utf8_czech_ci default NULL,
  `StoreID` varchar(15) collate utf8_czech_ci default NULL,
  `Price` varchar(15) collate utf8_czech_ci default NULL,
  `Brand` varchar(15) collate utf8_czech_ci default NULL,
  `MovementStyle` varchar(15) collate utf8_czech_ci default NULL,
  `Color` varchar(15) collate utf8_czech_ci default NULL,
  `Material` varchar(15) collate utf8_czech_ci default NULL,
  `Shape` varchar(15) collate utf8_czech_ci default NULL,
  `Waterproof` varchar(15) collate utf8_czech_ci default NULL,
  `Style` varchar(15) collate utf8_czech_ci default NULL,
  `Model` varchar(15) collate utf8_czech_ci default NULL,
  `BuyAmount` int(11) default NULL,
  `Staus` varchar(15) collate utf8_czech_ci default NULL,
  `GoodsPicturePath` varchar(45) collate utf8_czech_ci default NULL,
  KEY `FK_order_goods` (`OrderID`),
  CONSTRAINT `FK_order_goods` FOREIGN KEY (`OrderID`) REFERENCES `order_info` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `order_goods` */

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `OrderID` varchar(15) collate utf8_czech_ci NOT NULL default '',
  `OrderStatus` varchar(15) collate utf8_czech_ci default NULL,
  `PaymentTime` varchar(15) collate utf8_czech_ci default NULL,
  `SendGoodsTime` varchar(15) collate utf8_czech_ci default NULL,
  `Dealtime` varchar(15) collate utf8_czech_ci default NULL,
  `Seller` varchar(15) collate utf8_czech_ci default NULL,
  `Customer` varchar(15) collate utf8_czech_ci default NULL,
  `TotalPrice` float default NULL,
  PRIMARY KEY  (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `order_info` */

/*Table structure for table `return` */

DROP TABLE IF EXISTS `return`;

CREATE TABLE `return` (
  `ReturnID` varchar(15) collate utf8_czech_ci NOT NULL,
  `OrderID` varchar(15) collate utf8_czech_ci default NULL,
  `TotalPrice` float default NULL,
  PRIMARY KEY  (`ReturnID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `return` */

/*Table structure for table `store_info` */

DROP TABLE IF EXISTS `store_info`;

CREATE TABLE `store_info` (
  `StoreID` int(11) NOT NULL auto_increment,
  `Pwd` varchar(15) collate utf8_czech_ci NOT NULL default '',
  `StoreName` varchar(15) collate utf8_czech_ci default NULL,
  `Owner` varchar(15) collate utf8_czech_ci default NULL,
  `RegTime` varchar(45) collate utf8_czech_ci default NULL,
  `Telephone` varchar(15) collate utf8_czech_ci default NULL,
  PRIMARY KEY  (`StoreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci MIN_ROWS=8888 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `store_info` */

insert  into `store_info`(`StoreID`,`Pwd`,`StoreName`,`Owner`,`RegTime`,`Telephone`) values (8888,'王',NULL,NULL,NULL,NULL);

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
  `OrderID` varchar(15) collate utf8_czech_ci default NULL,
  `UserID` varchar(15) collate utf8_czech_ci default NULL,
  `Number` int(11) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

/*Data for the table `user_goods` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `UserID` varchar(15) collate utf8_czech_ci NOT NULL default '',
  `Pwd` varchar(15) collate utf8_czech_ci NOT NULL default '',
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
