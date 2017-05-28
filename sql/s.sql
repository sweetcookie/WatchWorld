/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : watch-world

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-29 03:59:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `ActivityPicturePath` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `StoreID` int(11) DEFAULT NULL,
  KEY `FK_activity` (`StoreID`),
  CONSTRAINT `FK_activity` FOREIGN KEY (`StoreID`) REFERENCES `store_info` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('customer/IMG/pic1.jpg', '8891');
INSERT INTO `activity` VALUES ('customer/IMG/pic2.jpg', '8893');

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `AdminID` varchar(15) COLLATE utf8_czech_ci NOT NULL,
  `Pwd` varchar(15) COLLATE utf8_czech_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- ----------------------------
-- Records of admin_info
-- ----------------------------

-- ----------------------------
-- Table structure for goods_display
-- ----------------------------
DROP TABLE IF EXISTS `goods_display`;
CREATE TABLE `goods_display` (
  `GoodsID` int(11) DEFAULT NULL,
  `Brand` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Time` time DEFAULT NULL,
  KEY `FK_goods_display` (`GoodsID`),
  CONSTRAINT `FK_goods_display` FOREIGN KEY (`GoodsID`) REFERENCES `goods_info` (`GoodsID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods_display
-- ----------------------------

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `GoodsID` int(15) NOT NULL AUTO_INCREMENT,
  `GoodsName` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `GoodsPicturePath` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Brand` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Color` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Model` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `StoreID` int(11) DEFAULT NULL,
  `SalesVolumes` int(11) DEFAULT NULL,
  PRIMARY KEY (`GoodsID`),
  KEY `FK_goods_info` (`StoreID`),
  CONSTRAINT `FK_goods_info` FOREIGN KEY (`StoreID`) REFERENCES `store_info` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES ('2', '手表2', 'customer/IMG/pic3.jpg', '1001', '劳力士2', '颜色2', '型号2', '102', '8891', '11');
INSERT INTO `goods_info` VALUES ('3', '手表3', 'url1', '1000', '劳力士1', '颜色1', '型号1', '17', '8892', '21');
INSERT INTO `goods_info` VALUES ('6', '手表4', 'url4', '1003', '劳力士4', '颜色4', '型号4', '104', '8891', '4');
INSERT INTO `goods_info` VALUES ('8', '手表6', 'url6', '1005', '劳力士6', '颜色6', '型号6', '106', '8891', '6');
INSERT INTO `goods_info` VALUES ('9', '手表7', 'logo.png.png', '1006', '劳力士7', '#000000', '型号7', '107', '8890', '7');
INSERT INTO `goods_info` VALUES ('10', '手表8', 'url8', '1007', '劳力士8', '颜色8', '型号8', '108', '8891', '8');
INSERT INTO `goods_info` VALUES ('11', '手表11', 'url9', '1008', '劳力士9', '颜色9', '型号9', '5', '8892', '23');
INSERT INTO `goods_info` VALUES ('12', '手表0', 'url0', '999', '劳力士0', '颜色0', '型号0', '100', '8890', '0');
INSERT INTO `goods_info` VALUES ('13', '手表1', 'url1', '1000', '劳力士1', '颜色1', '型号1', '101', '8890', '1');
INSERT INTO `goods_info` VALUES ('14', '手表2', 'url2', '1001', '劳力士2', '颜色2', '型号2', '102', '8890', '2');
INSERT INTO `goods_info` VALUES ('15', '手表3', 'url3', '1002', '劳力士3', '颜色3', '型号3', '103', '8890', '3');
INSERT INTO `goods_info` VALUES ('16', '手表4', 'url4', '1003', '劳力士4', '颜色4', '型号4', '104', '8890', '4');
INSERT INTO `goods_info` VALUES ('17', '手表5', 'url5', '1004', '劳力士5', '颜色5', '型号5', '105', '8890', '5');
INSERT INTO `goods_info` VALUES ('18', '手表6', 'url6', '1005', '劳力士6', '颜色6', '型号6', '106', '8890', '6');
INSERT INTO `goods_info` VALUES ('19', '手表7', 'url7', '1006', '劳力士7', '颜色7', '型号7', '107', '8890', '7');
INSERT INTO `goods_info` VALUES ('20', '手表8', 'url8', '1007', '劳力士8', '颜色8', '型号8', '108', '8890', '8');
INSERT INTO `goods_info` VALUES ('21', '手表9', 'url9', '1008', '劳力士9', '颜色9', '型号9', '109', '8890', '9');
INSERT INTO `goods_info` VALUES ('22', '1234', '1495684497596.png', '1234', '1234', '#ff8000', '1234', '1234', '8890', '0');

-- ----------------------------
-- Table structure for goods_review
-- ----------------------------
DROP TABLE IF EXISTS `goods_review`;
CREATE TABLE `goods_review` (
  `GoodsID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `UserName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Comment` varchar(100) COLLATE utf8_czech_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods_review
-- ----------------------------

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `OrderID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `GoodsID` int(15) DEFAULT NULL,
  `GoodsName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `StoreID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `Brand` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Color` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Model` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `BuyAmount` int(11) DEFAULT NULL,
  `GoodsPicturePath` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  KEY `FK_order_goods` (`OrderID`),
  CONSTRAINT `FK_order_goods` FOREIGN KEY (`OrderID`) REFERENCES `order_info` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES ('222', '3', null, '8892', null, null, null, null, '1', null);
INSERT INTO `order_goods` VALUES ('222', '11', null, '8892', null, null, null, null, '1', null);
INSERT INTO `order_goods` VALUES ('456', '11', null, '8892', null, null, null, null, '1', null);
INSERT INTO `order_goods` VALUES ('1827504863', '2', '手表2', '8891', '1001', '劳力士2', '颜色2', '型号2', '10', 'customer/IMG/pic3.jpg');
INSERT INTO `order_goods` VALUES ('0256287877', '3', '手表3', '8892', '1000', '劳力士1', '颜色1', '型号1', '1', 'url1');
INSERT INTO `order_goods` VALUES ('0256287877', '11', '手表11', '8892', '1008', '劳力士9', '颜色9', '型号9', '1', 'url9');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `OrderID` varchar(15) COLLATE utf8_czech_ci NOT NULL DEFAULT '',
  `OrderStatus` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `PaymentTime` timestamp NULL DEFAULT NULL,
  `SendGoodsTime` timestamp NULL DEFAULT NULL,
  `StoreName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `UserName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `TotalPrice` int(11) DEFAULT NULL,
  `Address` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `Telephone` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `UserID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_userID` (`UserID`),
  CONSTRAINT `FK_userID` FOREIGN KEY (`UserID`) REFERENCES `user_info` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('0256287877', '已签收', '2017-05-29 02:56:28', null, '手表店1', '123', '2008', 'sdfs', '123123', '123');
INSERT INTO `order_info` VALUES ('1827504863', '未发货', '2017-05-28 18:27:50', null, '手表店2', '123', '10010', 'sdfs', '123123', null);
INSERT INTO `order_info` VALUES ('222', '已发货', null, null, '手表店1', null, null, null, null, null);
INSERT INTO `order_info` VALUES ('456', '未发货', null, null, '手表店1', null, null, null, null, null);

-- ----------------------------
-- Table structure for return
-- ----------------------------
DROP TABLE IF EXISTS `return`;
CREATE TABLE `return` (
  `ReturnID` varchar(15) COLLATE utf8_czech_ci NOT NULL,
  `OrderID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `TotalPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`ReturnID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- ----------------------------
-- Records of return
-- ----------------------------

-- ----------------------------
-- Table structure for store_info
-- ----------------------------
DROP TABLE IF EXISTS `store_info`;
CREATE TABLE `store_info` (
  `StoreID` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Pwd` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `StoreName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Owner` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `RegTime` varchar(45) COLLATE utf8_czech_ci DEFAULT NULL,
  `Telephone` varchar(11) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`StoreID`),
  UNIQUE KEY `LoginName` (`LoginName`),
  UNIQUE KEY `StoreName` (`StoreName`)
) ENGINE=InnoDB AUTO_INCREMENT=8907 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci MIN_ROWS=8888 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of store_info
-- ----------------------------
INSERT INTO `store_info` VALUES ('8890', '1234', '2234', '手表店4', '张4', '2017年05月15日', '18832223124');
INSERT INTO `store_info` VALUES ('8891', '哈哈3', '123456', '手表店2', '张2', '2017年05月15日', '1882');
INSERT INTO `store_info` VALUES ('8892', '哈哈4', '123456', '手表店1', '张1', '2017年05月15日', '1881');
INSERT INTO `store_info` VALUES ('8893', '1', '123', '123', '3', '2017年05月17日', '13214142866');
INSERT INTO `store_info` VALUES ('8894', '4', '4', '5', '5', '2017年05月17日', '55555555555');
INSERT INTO `store_info` VALUES ('8895', 'sd', '11', 'WW', '23222', '2017年05月17日', '98292738333');
INSERT INTO `store_info` VALUES ('8896', '用户', 'mima', '店铺', '店主', '2017年05月17日', '12345678919');
INSERT INTO `store_info` VALUES ('8897', 'wq', 'w', '我', '水电费', '2017年05月17日', '12345678910');
INSERT INTO `store_info` VALUES ('8898', '哈哈', '2', '33', '11', '2017年05月17日', '12222222222');
INSERT INTO `store_info` VALUES ('8899', '随时随地', 'sd', '收到', '收到', '2017年05月17日', '11111111121');
INSERT INTO `store_info` VALUES ('8900', '娃儿我v', 'sdf', '是是是', '十三', '2017年05月17日', '33112233211');
INSERT INTO `store_info` VALUES ('8901', '123', '123', '新店铺', '123', '2017年05月17日', '18814142866');
INSERT INTO `store_info` VALUES ('8902', 'dsf', '123', '手表店', 'sdfsdfsdf', '2017年05月18日', '18814142886');
INSERT INTO `store_info` VALUES ('8903', '史蒂夫', 'sdf', '史蒂夫旗舰店', '史蒂夫', '2017年05月19日', '18814142887');
INSERT INTO `store_info` VALUES ('8904', '3456', '123', '12333', '12333', '2017年05月20日', '15119662432');
INSERT INTO `store_info` VALUES ('8905', '34567', '123', '123332', '123332', '2017年05月20日', '15119662433');
INSERT INTO `store_info` VALUES ('8906', '234', '234', '234', '234', '2017年05月21日', '15116789876');

-- ----------------------------
-- Table structure for user_data
-- ----------------------------
DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data` (
  `UserId` varchar(15) COLLATE utf8_czech_ci NOT NULL,
  `UserName` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Sex` varchar(10) COLLATE utf8_czech_ci DEFAULT NULL,
  `Portrait` varchar(100) COLLATE utf8_czech_ci DEFAULT NULL,
  `Address` varchar(50) COLLATE utf8_czech_ci DEFAULT NULL,
  `Telephone` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  CONSTRAINT `FK_userdata` FOREIGN KEY (`UserId`) REFERENCES `user_info` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- ----------------------------
-- Records of user_data
-- ----------------------------
INSERT INTO `user_data` VALUES ('123', '123', '12', '男', 'customer/IMG/portrait/123.jpg', 'sdfs', '123123');
INSERT INTO `user_data` VALUES ('123123', '带份', '12', '男', '', '的说法是否', '12312312');

-- ----------------------------
-- Table structure for user_goods
-- ----------------------------
DROP TABLE IF EXISTS `user_goods`;
CREATE TABLE `user_goods` (
  `GoodsID` int(15) DEFAULT NULL,
  `UserID` varchar(15) COLLATE utf8_czech_ci DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  KEY `FK_user_goods` (`GoodsID`),
  KEY `FK_user_info` (`UserID`),
  CONSTRAINT `FK_user_goods` FOREIGN KEY (`GoodsID`) REFERENCES `goods_info` (`GoodsID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_info` FOREIGN KEY (`UserID`) REFERENCES `user_info` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

-- ----------------------------
-- Records of user_goods
-- ----------------------------
INSERT INTO `user_goods` VALUES ('10', '123', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `UserID` varchar(15) COLLATE utf8_czech_ci NOT NULL DEFAULT '',
  `Pwd` varchar(15) COLLATE utf8_czech_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('123', '123');
INSERT INTO `user_info` VALUES ('123123', '123123');
