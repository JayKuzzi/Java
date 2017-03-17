/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : shopdb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 12/19/2016 13:45:30 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
create database shopdb;
use shopdb;
-- ----------------------------
--  Table structure for `GOODS`
-- ----------------------------
DROP TABLE IF EXISTS `GOODS`;
CREATE TABLE `GOODS` (
  `GID` int(11) NOT NULL,
  `GNAME` varchar(20) DEFAULT NULL,
  `GPRICE` double(18,1) DEFAULT NULL,
  `GNUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `GOODS`
-- ----------------------------
BEGIN;
INSERT INTO `GOODS` VALUES ('1', 'wangwang', '12.5', '12'), ('2', 'yili', '11.5', '8'), ('3', 'yifu', '49.9', '6'), ('4', 'xie', '102.5', '20'), ('5', 'naifen', '299.0', '15'), ('6', 'niaobushi', '146.0', '6'), ('8', 'iphonr7', '7000.0', '16'), ('9', 'bb', '99.0', '4');
COMMIT;

-- ----------------------------
--  Table structure for `GSALES`
-- ----------------------------
DROP TABLE IF EXISTS `GSALES`;
CREATE TABLE `GSALES` (
  `GSID` int(11) NOT NULL,
  `GID` int(11) DEFAULT NULL,
  `SID` int(11) DEFAULT NULL,
  `SDATE` date DEFAULT NULL,
  `SNUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`GSID`),
  KEY `FK_GID` (`GID`),
  KEY `FK_SID` (`SID`),
  CONSTRAINT `FK_GID` FOREIGN KEY (`GID`) REFERENCES `GOODS` (`GID`),
  CONSTRAINT `FK_SID` FOREIGN KEY (`SID`) REFERENCES `SALESMAN` (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `GSALES`
-- ----------------------------
BEGIN;
INSERT INTO `GSALES` VALUES ('1', '1', '2', '2016-12-13', '1'), ('2', '6', '2', '2016-12-13', '1');
COMMIT;

-- ----------------------------
--  Table structure for `SALESMAN`
-- ----------------------------
DROP TABLE IF EXISTS `SALESMAN`;
CREATE TABLE `SALESMAN` (
  `SID` int(11) NOT NULL,
  `SPASSWORD` varchar(20) DEFAULT NULL,
  `SNAME` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `SALESMAN`
-- ----------------------------
BEGIN;
INSERT INTO `SALESMAN` VALUES ('1', '123', 'wangbo'), ('2', '456', 'sunte'), ('3', '789', 'wangwei'), ('4', '000', 'huohuo');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
