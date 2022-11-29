/*
 Navicat Premium Data Transfer

 Source Server         : CSP584
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : csp584

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 28/11/2022 20:35:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `userid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `creditcard` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `orderquantity` int DEFAULT '0',
  `zipcode` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createtime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `productname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (48, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '12345678888888', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 1, '60616', '2022-11-28 08:07:58', 349.99, 18, 'splash-financial-stu');
INSERT INTO `order` VALUES (49, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', '12345678888888', 'Illinois', 'Chicago', '2941 S Michigan Ave, 305', '3123949380', 1, '60616', '2022-11-28 08:07:58', 599.99, 14, 'biz2credit');
INSERT INTO `order` VALUES (50, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave', '03123949380', 1, '60616', '2022-11-28 08:10:30', 349.99, 18, 'splash-financial-stu');
INSERT INTO `order` VALUES (51, 'bgeng1@hawk.iit.edu', 'bgeng1@hawk.iit.edu', 'gengbinghan@gmail.com', '11111', 'IL', 'Chicago', '2941 S Michigan Ave', '03123949380', 1, '60616', '2022-11-28 08:10:30', 299.99, 13, 'lendingtree-per');
COMMIT;

-- ----------------------------
-- Table structure for productcatalog
-- ----------------------------
DROP TABLE IF EXISTS `productcatalog`;
CREATE TABLE `productcatalog` (
  `productid` int NOT NULL,
  `name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `loanamount` double DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `creditscore` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of productcatalog
-- ----------------------------
BEGIN;
INSERT INTO `productcatalog` VALUES (11, 'Attribute', 299.99, 100000, 'imagesNew/11.jpg', 'PersonalLoans', 4.5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (12, 'Marcus-per', 499.99, 40000, 'imagesNew/12.jpg', 'PersonalLoans', 4, 15, 'Loans', '580');
INSERT INTO `productcatalog` VALUES (13, 'lendingtree-per', 299.99, 50000, 'imagesNew/13.jpg', 'PersonalLoans', 5, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (14, 'biz2credit', 599.99, 6000000, 'imagesNew/14.jpg', 'BussinessLoans', 10, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (15, 'fundera', 499.99, 1000000, 'imagesNew/15.jpg', 'BussinessLoans', 10, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (16, 'lendio', 229.99, 2000000, 'imagesNew/16.jpg', 'BussinessLoans', 10, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (17, 'credible-stu', 199.99, 30000, 'imagesNew/17.jpg', 'StudentLoans', 10, 15, 'Loans', '580');
INSERT INTO `productcatalog` VALUES (18, 'splash-financial-stu', 349.99, 25000, 'imagesNew/18.jpg', 'StudentLoans', 10, 15, 'Loans', '590');
INSERT INTO `productcatalog` VALUES (19, 'mefa', 749, 35000, 'imagesNew/19.jpg', 'StudentLoans', 10, 15, 'Loans', '600');
INSERT INTO `productcatalog` VALUES (20, 'Ladder-life', 1150.99, NULL, 'imagesNew/20.jpg', 'LifeInsurance', 10, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (21, 'Lincole Financial', 1250, NULL, 'imagesNew/21.jpg', 'LifeInsurance', 10, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (22, 'Pacific Life', 499, NULL, 'imagesNew/22.png', 'LifeInsurance', 0, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (23, 'United Healthcare', 549, NULL, 'imagesNew/23.png', 'HealthInsurance', 0, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (24, 'Altrua', 749, NULL, 'imagesNew/24.png', 'HealthInsurance', 0, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (25, 'globe_life', 669, NULL, 'imagesNew/25.png', 'HealthInsurance', 0, 15, 'Insurances', NULL);
INSERT INTO `productcatalog` VALUES (26, 'Fidelity', 900, NULL, 'imagesNew/26.jpg', 'Stocks', 10, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (27, 'Merrill', 800, NULL, 'imagesNew/27.jpg', 'Stocks', 10, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (28, 'JPMorgan', 700, NULL, 'imagesNew/28.jpg', 'Stocks', 10, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (29, 'Bitcoin', 899.99, NULL, 'imagesNew/29.jpg', 'Cryptocurrency', 10, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (30, 'Ethereum\nApple - MacBook Pro - 13\" Display with Touch Bar - Intel Core i5 - 8GB Memory - 256GB SSD - Silver', 1299.99, NULL, 'imagesNew/30.jpg', 'Cryptocurrency', 10, 15, 'Investments', NULL);
INSERT INTO `productcatalog` VALUES (31, 'BUSD\nApple - MacBook Pro 15.4\" Display with Touch Bar - Intel Core i7 - 16GB Memory - AMD Radeon Pro 555X - 256GB SSD - Space Gray', 2099.99, NULL, 'imagesNew/31.jpg', 'Cryptocurrency', 10, 15, 'Investments', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mno` varchar(45) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('bgeng1@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng1@hawk.iit.edu', '3123949380', 0);
INSERT INTO `user` VALUES ('bgeng2@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng2@hawk.iit.edu', '3123949380', 1);
INSERT INTO `user` VALUES ('bgeng3@hawk.iit.edu', 'binghan', 'Binghan', 'Geng', 'bgeng3@hawk.iit.edu', '3123949380', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
