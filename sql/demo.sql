/*
Navicat MySQL Data Transfer

Source Server         : MySQLRoot
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-19 01:21:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dep
-- ----------------------------
DROP TABLE IF EXISTS `dep`;
CREATE TABLE `dep` (
  `depId` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dep
-- ----------------------------
INSERT INTO `dep` VALUES ('01', '总公司');
INSERT INTO `dep` VALUES ('0101', '第一分公司');
INSERT INTO `dep` VALUES ('010101', '开发部');
INSERT INTO `dep` VALUES ('010102', '测试部');
INSERT INTO `dep` VALUES ('0102', '第二分公司');
INSERT INTO `dep` VALUES ('010201', '开发部');
INSERT INTO `dep` VALUES ('012020', '测试部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `depId` varchar(20) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `USER_FK` (`depId`),
  CONSTRAINT `USER_FK` FOREIGN KEY (`depId`) REFERENCES `dep` (`depId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user0001', '张三1', '010101', '男');
INSERT INTO `user` VALUES ('user0002', '张三2', '010101', '男');
INSERT INTO `user` VALUES ('user0003', '张三3', '010102', '男');
INSERT INTO `user` VALUES ('user0004', '张三4', '010201', '男');
INSERT INTO `user` VALUES ('user0005', '张三5', '010201', '男');
INSERT INTO `user` VALUES ('user0008', '张三7', '010102', '男');
INSERT INTO `user` VALUES ('user0009', '张三7', '010102', '男');
