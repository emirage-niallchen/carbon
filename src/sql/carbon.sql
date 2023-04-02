/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : carbon

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/03/2023 19:39:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agriculture
-- ----------------------------
DROP TABLE IF EXISTS `agriculture`;
CREATE TABLE `agriculture`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `irrigation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `machinery` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fertilizer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of agriculture
-- ----------------------------
INSERT INTO `agriculture` VALUES (13, 2010, '北京', '16.26', '276.0', '13.7', '31.7');
INSERT INTO `agriculture` VALUES (14, 2011, '北京', '16.31', '265.2', '13.8', '30.3');
INSERT INTO `agriculture` VALUES (15, 2012, '北京', '15.92', '241.1', '13.7', '28.3');
INSERT INTO `agriculture` VALUES (16, 2013, '北京', '15.44', '207.7', '12.8', '24.2');
INSERT INTO `agriculture` VALUES (17, 2014, '北京', '15.83', '195.8', '11.6', '20.0');
INSERT INTO `agriculture` VALUES (18, 2015, '北京', '13.73', '185.9', '10.5', '17.7');
INSERT INTO `agriculture` VALUES (19, 2016, '北京', '12.85', '144.4', '9.7', '15.0');
INSERT INTO `agriculture` VALUES (20, 2017, '北京', '11.55', '133.5', '8.5', '12.6');
INSERT INTO `agriculture` VALUES (21, 2018, '北京', '10.97', '125.6', '7.3', '10.6');
INSERT INTO `agriculture` VALUES (22, 2019, '北京', '10.92', '122.8', '6.2', '9.2');
INSERT INTO `agriculture` VALUES (23, 2020, '北京', '10.36', '120.2', '6.1', '10.2');
INSERT INTO `agriculture` VALUES (33, 2019, '河北', '448.21', '7830.73', '297.27', '813.27');
INSERT INTO `agriculture` VALUES (34, 2020, '河北', '447.00', '7965.74', '285.71', '808.94');
INSERT INTO `agriculture` VALUES (35, 2018, '河北', '449.51', '7706.2', '312.4', '819.71');
INSERT INTO `agriculture` VALUES (36, 2017, '河北', '447.46', '7580.6', '321.98', '838.17');
INSERT INTO `agriculture` VALUES (37, 2016, '河北', '445.76', '7402', '331.79', '846.73');
INSERT INTO `agriculture` VALUES (38, 2015, '河北', '444.79', '11102.81', '335.49', '845.78');
INSERT INTO `agriculture` VALUES (39, 2014, '河北', '440.42', '10942.9', '335.61', '845.49');
INSERT INTO `agriculture` VALUES (40, 2013, '河北', '434.90', '10786.4', '331.04', '841.60');
INSERT INTO `agriculture` VALUES (41, 2012, '河北', '416.50', '10553.8', '329.33', '836.19');
INSERT INTO `agriculture` VALUES (42, 2011, '河北', '459.66', '10349.2', '326.28', '827.83');
INSERT INTO `agriculture` VALUES (43, 2010, '河北', '452.08', '10151.3', '312.4', '826.08');
INSERT INTO `agriculture` VALUES (44, 2010, '天津', '34.46', '587.79', '25.54', '43.93');
INSERT INTO `agriculture` VALUES (45, 2011, '天津', '33.80', '583.87', '24.39', '44.33');
INSERT INTO `agriculture` VALUES (46, 2012, '天津', '33.70', '568.13', '24.45', '44.99');
INSERT INTO `agriculture` VALUES (47, 2013, '天津', '30.89', '554.18', '24.34', '44.21');
INSERT INTO `agriculture` VALUES (48, 2014, '天津', '30.89', '552.41', '23.30', '44.43');
INSERT INTO `agriculture` VALUES (49, 2015, '天津', '30.89', '546.92', '21.78', '43.47');
INSERT INTO `agriculture` VALUES (50, 2016, '天津', '30.66', '470.00', '21.36', '44.37');
INSERT INTO `agriculture` VALUES (51, 2017, '天津', '30.53', '464.65', '18.01', '43.95');
INSERT INTO `agriculture` VALUES (52, 2018, '天津', '30.47', '347.98', '16.95', '42.93');
INSERT INTO `agriculture` VALUES (53, 2019, '天津', '30.48', '359.84', '16.24', '41.03');
INSERT INTO `agriculture` VALUES (54, 2020, '天津', '29.91', '365.08', '15.29', '41.92');
INSERT INTO `agriculture` VALUES (55, 2021, '天津', '29.51', '372.48', '15.66', '43.70');

-- ----------------------------
-- Table structure for basic
-- ----------------------------
DROP TABLE IF EXISTS `basic`;
CREATE TABLE `basic`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `economy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `population` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic
-- ----------------------------
INSERT INTO `basic` VALUES (8, 2010, '河北', '18003.6', '7193.6');
INSERT INTO `basic` VALUES (9, 2011, '河北', '21384.7', '7231.86');
INSERT INTO `basic` VALUES (10, 2012, '河北', '23077.5', '7262.00');
INSERT INTO `basic` VALUES (11, 2013, '河北', '24259.6', '7287.59');
INSERT INTO `basic` VALUES (12, 2014, '河北', '25208.9', '7322.9');
INSERT INTO `basic` VALUES (13, 2015, '河北', '26398.4', '7345.2');
INSERT INTO `basic` VALUES (14, 2016, '河北', '28474.1', '7374.99');
INSERT INTO `basic` VALUES (15, 2017, '河北', '30640.8', '7409.14');
INSERT INTO `basic` VALUES (16, 2018, '河北', '32494.6', '7426.37');
INSERT INTO `basic` VALUES (17, 2019, '河北', '34978.6', '7446.56');
INSERT INTO `basic` VALUES (18, 2020, '河北', '36206.9', '7463.84');
INSERT INTO `basic` VALUES (19, 2010, '天津', '6830.76', '1299.29');
INSERT INTO `basic` VALUES (20, 2011, '天津', '8112.51', '1341.00');
INSERT INTO `basic` VALUES (21, 2012, '天津', '9043.02', '1378');
INSERT INTO `basic` VALUES (22, 2013, '天津', '9945.44', '1410.00');
INSERT INTO `basic` VALUES (23, 2014, '天津', '10640.62', '1429.00');
INSERT INTO `basic` VALUES (24, 2015, '天津', '10879.51', '1439.00');
INSERT INTO `basic` VALUES (25, 2016, '天津', '11477.20', '1443.00');
INSERT INTO `basic` VALUES (26, 2017, '天津', '12450.56', '1410.00');
INSERT INTO `basic` VALUES (27, 2018, '天津', '13362.92', '1383.00');
INSERT INTO `basic` VALUES (28, 2019, '天津', '14055.46', '1385.00');
INSERT INTO `basic` VALUES (29, 2020, '天津', '14007.99', '1386.60');
INSERT INTO `basic` VALUES (30, 2021, '天津', '15695.05', '1373.00');
INSERT INTO `basic` VALUES (31, 2010, '北京', '14964.0', '1961.9');
INSERT INTO `basic` VALUES (32, 2011, '北京', '17188.8', '2023.8');
INSERT INTO `basic` VALUES (33, 2012, '北京', '19024.7', '2077.5');
INSERT INTO `basic` VALUES (34, 2013, '北京', '21134.6', '2125.4');
INSERT INTO `basic` VALUES (35, 2014, '北京', '22926.0', '2171.1');
INSERT INTO `basic` VALUES (36, 2015, '北京', '24779.1', '2188.3');
INSERT INTO `basic` VALUES (37, 2016, '北京', '27041.2', '2195.4');
INSERT INTO `basic` VALUES (38, 2017, '北京', '29883.0', '2194.4');
INSERT INTO `basic` VALUES (40, 2018, '北京', '33106.0', '2191.7');
INSERT INTO `basic` VALUES (41, 2019, '北京', '35445.1', '2190.1');
INSERT INTO `basic` VALUES (42, 2020, '北京', '36102.6', '2189.0');

-- ----------------------------
-- Table structure for energy
-- ----------------------------
DROP TABLE IF EXISTS `energy`;
CREATE TABLE `energy`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oil` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `coal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gas` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of energy
-- ----------------------------
INSERT INTO `energy` VALUES (47, 2011, '北京', '2105.99', '1705.52', '896.90', '6397.3');
INSERT INTO `energy` VALUES (48, 2012, '北京', '2074.88', '1655.44', '1123.10', '6564.10');
INSERT INTO `energy` VALUES (49, 2013, '北京', '2164.45', '1567.36', '1223.76', '6723.90');
INSERT INTO `energy` VALUES (50, 2014, '北京', '2224.17', '1391.47', '1440.65', '6831.23');
INSERT INTO `energy` VALUES (51, 2015, '北京', '2299.41', '887.80', '1985.11', '6802.79');
INSERT INTO `energy` VALUES (52, 2016, '北京', '2292.29', '637.74', '2205.14', '6916.12');
INSERT INTO `energy` VALUES (53, 2017, '北京', '2409.92', '358.65', '2268.16', '7088.33');
INSERT INTO `energy` VALUES (54, 2018, '北京', '2481.98', '201.38', '2484.16', '7269.76');
INSERT INTO `energy` VALUES (55, 2019, '北京', '2542.88', '133.22', '2502.40', '7360.32');
INSERT INTO `energy` VALUES (56, 2020, '北京', '1979.23', '101.43', '2512.76', '6762.10');
INSERT INTO `energy` VALUES (57, 2021, '北京', '2036.01', '102.30', '2568.10', '7103.62');
INSERT INTO `energy` VALUES (58, 2010, '北京', '1967.63', '1881.77', '1004.80', '6359.49');
INSERT INTO `energy` VALUES (61, 2010, '天津', '1566.79', '4806.79', '22.93', '6818.08');
INSERT INTO `energy` VALUES (64, 2012, '天津', '1544.62', '5298.12', '32.05', '8208.01');
INSERT INTO `energy` VALUES (65, 2011, '天津', '1754.02', '5261.50', '25.52', '7598.45');
INSERT INTO `energy` VALUES (67, 2013, '天津', '1759.15', '5278.67', '37.27', '7881.83');
INSERT INTO `energy` VALUES (69, 2014, '天津', '954.39', '5027.28', '45.09', '8145.06');
INSERT INTO `energy` VALUES (70, 2015, '天津', '1616.72', '4538.83', '63.62', '8260.13');
INSERT INTO `energy` VALUES (71, 2016, '天津', '1433.60', '4230.16', '74.06', '8244.68');
INSERT INTO `energy` VALUES (72, 2017, '天津', '1624.85', '3875.61', '82.31', '7831.72');
INSERT INTO `energy` VALUES (73, 2018, '天津', '1688.23', '3832.89', '101.92', '7973.29');
INSERT INTO `energy` VALUES (74, 2019, '天津', '1693.35', '3766.10', '108.49', '8240.70');
INSERT INTO `energy` VALUES (75, 2020, '天津', '1394.16', '3745.28', '117.03', '8104.60');
INSERT INTO `energy` VALUES (76, 2021, '天津', '1722.47', '3723.27', '123.45', '8205.69');
INSERT INTO `energy` VALUES (77, 2010, '河北', '2030.58', '23342.47', '395.64', '26201.41');
INSERT INTO `energy` VALUES (78, 2011, '河北', '2279.69', '25012.02', '466.05', '28075.03');
INSERT INTO `energy` VALUES (79, 2012, '河北', '2151.40', '25557.91', '586.75', '28762.47');
INSERT INTO `energy` VALUES (80, 2013, '河北', '2141.74', '26309.33', '661.51', '29664.38');
INSERT INTO `energy` VALUES (81, 2014, '河北', '2046.54', '25936.47', '744.72', '29320.21');
INSERT INTO `energy` VALUES (82, 2015, '河北', '1859.05', '27569.28', '971.43', '31036.73');
INSERT INTO `energy` VALUES (83, 2016, '河北', '1959.83', '27472.27', '1075.86', '31458.05');
INSERT INTO `energy` VALUES (84, 2017, '河北', '1969.83', '27606.56', '1264.03', '32082.56');
INSERT INTO `energy` VALUES (85, 2018, '河北', '2082.37', '26909.88', '1766.96', '32185.24');
INSERT INTO `energy` VALUES (86, 2019, '河北', '1907.14', '25854.23', '2151.22', '32545.43');
INSERT INTO `energy` VALUES (87, 2020, '河北', '1858.74', '26392.79', '2294.74', '32782.76');

-- ----------------------------
-- Table structure for husbandry
-- ----------------------------
DROP TABLE IF EXISTS `husbandry`;
CREATE TABLE `husbandry`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pig` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cow` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sheep` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of husbandry
-- ----------------------------
INSERT INTO `husbandry` VALUES (50, 2010, '北京', '495.06', '31.78', '147.07');
INSERT INTO `husbandry` VALUES (51, 2011, '北京', '491.54', '32.49', '136.39');
INSERT INTO `husbandry` VALUES (52, 2012, '北京', '493.5', '33.24', '129.87');
INSERT INTO `husbandry` VALUES (53, 2013, '北京', '503.62', '31.59', '130.24');
INSERT INTO `husbandry` VALUES (54, 2014, '北京', '485.36', '28.88', '137.02');
INSERT INTO `husbandry` VALUES (55, 2015, '北京', '450.03', '25.92', '140.34');
INSERT INTO `husbandry` VALUES (56, 2016, '北京', '440.6', '23.6', '129.2');
INSERT INTO `husbandry` VALUES (57, 2017, '北京', '354.3', '21.2', '99.7');
INSERT INTO `husbandry` VALUES (58, 2018, '北京', '214.8', '15.9', '59.8');
INSERT INTO `husbandry` VALUES (59, 2019, '北京', '41.6', '12.3', '39.5');
INSERT INTO `husbandry` VALUES (60, 2020, '北京', '49.8', '10.7', '29.5');
INSERT INTO `husbandry` VALUES (61, 2021, '北京', '89.9', '10.7', '29.4');
INSERT INTO `husbandry` VALUES (62, 2010, '天津', '545.17', '46.92', '104.22');
INSERT INTO `husbandry` VALUES (63, 2011, '天津', '543.96', '47.36', '102.03');
INSERT INTO `husbandry` VALUES (64, 2012, '天津', '567.96', '48.16', '106.4');
INSERT INTO `husbandry` VALUES (65, 2013, '天津', '582.67', '47.37', '110.35');
INSERT INTO `husbandry` VALUES (66, 2014, '天津', '586.28', '49.39', '113.88');
INSERT INTO `husbandry` VALUES (67, 2015, '天津', '574.94', '48.9', '116.54');
INSERT INTO `husbandry` VALUES (68, 2016, '天津', '536.23', '43.28', '107.33');
INSERT INTO `husbandry` VALUES (69, 2017, '天津', '477.17', '45.34', '98.7');
INSERT INTO `husbandry` VALUES (70, 2018, '天津', '475.47', '41.26', '91.1');
INSERT INTO `husbandry` VALUES (71, 2019, '天津', '322.04', '39.78', '73.44');
INSERT INTO `husbandry` VALUES (72, 2020, '天津', '356.32', '42.55', '81.27');
INSERT INTO `husbandry` VALUES (73, 2021, '天津', '375.05', '44', '90.87');
INSERT INTO `husbandry` VALUES (74, 2010, '河北', '5246.5', '380.62', '1397.8');
INSERT INTO `husbandry` VALUES (75, 2011, '河北', '5346.2', '371.33', '1443.2');
INSERT INTO `husbandry` VALUES (76, 2012, '河北', '5522.1', '368.35', '1397.2');
INSERT INTO `husbandry` VALUES (77, 2013, '河北', '5719.3', '351.69', '1435.6');
INSERT INTO `husbandry` VALUES (78, 2014, '河北', '5949.8', '356.84', '1503');
INSERT INTO `husbandry` VALUES (79, 2015, '河北', '5853', '360.31', '1425.1');
INSERT INTO `husbandry` VALUES (80, 2016, '河北', '5725.1', '340.74', '1359.8');
INSERT INTO `husbandry` VALUES (81, 2017, '河北', '5743.1', '359.5', '1228.1');
INSERT INTO `husbandry` VALUES (82, 2018, '河北', '5530.4', '342.03', '1179.6');
INSERT INTO `husbandry` VALUES (83, 2019, '河北', '4538.2', '350.11', '1194.9');
INSERT INTO `husbandry` VALUES (84, 2020, '河北', '4656.4', '358.59', '1270.3');

-- ----------------------------
-- Table structure for industrial
-- ----------------------------
DROP TABLE IF EXISTS `industrial`;
CREATE TABLE `industrial`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `steel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ammonia` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of industrial
-- ----------------------------
INSERT INTO `industrial` VALUES (5, 2010, '北京', '794.0', '1049.0', '0');
INSERT INTO `industrial` VALUES (6, 2011, '北京', '287.0', '911.5', '0');
INSERT INTO `industrial` VALUES (7, 2012, '北京', '253.8', '874.5', '0');
INSERT INTO `industrial` VALUES (8, 2013, '北京', '221.8', '868.4', '0');
INSERT INTO `industrial` VALUES (9, 2014, '北京', '195.0', '703.1', '0');
INSERT INTO `industrial` VALUES (10, 2015, '北京', '175.0', '553.5', '0');
INSERT INTO `industrial` VALUES (11, 2016, '北京', '162.8', '510.3', '0');
INSERT INTO `industrial` VALUES (12, 2017, '北京', '179.0', '374.4', '0');
INSERT INTO `industrial` VALUES (13, 2018, '北京', '179.1', '397.0', '0');
INSERT INTO `industrial` VALUES (14, 2019, '北京', '170.7', '318.7', '0');
INSERT INTO `industrial` VALUES (15, 2020, '北京', '171.4', '400', '0');
INSERT INTO `industrial` VALUES (16, 2021, '北京', '171.4', '400', '0');
INSERT INTO `industrial` VALUES (17, 2010, '天津', '2162.11', '809.71', '0');
INSERT INTO `industrial` VALUES (19, 2011, '天津', '2295.75', '765.53', '0');
INSERT INTO `industrial` VALUES (20, 2012, '天津', '2124.25', '784.26', '0');
INSERT INTO `industrial` VALUES (21, 2013, '天津', '2305.06', '971.50', '0');
INSERT INTO `industrial` VALUES (22, 2014, '天津', '2287.13', '957.93', '0');
INSERT INTO `industrial` VALUES (23, 2015, '天津', '2068.91', '777.59', '0');
INSERT INTO `industrial` VALUES (24, 2016, '天津', '1798.93', '788.61', '0');
INSERT INTO `industrial` VALUES (25, 2017, '天津', '1812.55', '418.56', '0');
INSERT INTO `industrial` VALUES (26, 2018, '天津', '1808.79', '653.84', '0');
INSERT INTO `industrial` VALUES (27, 2019, '天津', '2194.77', '687.74', '0');
INSERT INTO `industrial` VALUES (28, 2020, '天津', '2171.82', '551.50', '0');
INSERT INTO `industrial` VALUES (29, 2021, '天津', '1825.25', '632.03', '0');
INSERT INTO `industrial` VALUES (30, 2010, '河北', '14458.79', '12594.30', '296.06');
INSERT INTO `industrial` VALUES (31, 2011, '河北', '16452.24', '14093.34', '286.45');
INSERT INTO `industrial` VALUES (32, 2012, '河北', '18048.38', '12809.79', '305.6');
INSERT INTO `industrial` VALUES (33, 2013, '河北', '18849.63', '12676.23', '307.91');
INSERT INTO `industrial` VALUES (34, 2014, '河北', '23995.24', '10625.46', '290.73');
INSERT INTO `industrial` VALUES (35, 2015, '河北', '25245.31', '9073.23', '274.24');
INSERT INTO `industrial` VALUES (36, 2016, '河北', '26150.42', '9861.22', '231.17');
INSERT INTO `industrial` VALUES (37, 2017, '河北', '24551.08', '8963.45', '180.42');
INSERT INTO `industrial` VALUES (38, 2018, '河北', '26908.74', '8936.03', '222.38');
INSERT INTO `industrial` VALUES (39, 2019, '河北', '28409.63', '10231.49', '211.42');
INSERT INTO `industrial` VALUES (40, 2020, '河北', '31320.12', '11717.45', '218.39');

-- ----------------------------
-- Table structure for plant_cover
-- ----------------------------
DROP TABLE IF EXISTS `plant_cover`;
CREATE TABLE `plant_cover`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `forest` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `farmland` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `greening` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plant_cover
-- ----------------------------
INSERT INTO `plant_cover` VALUES (5, 2010, '北京', '66.61', '31.7', '6.27');
INSERT INTO `plant_cover` VALUES (6, 2011, '北京', '67.34', '30.3', '6.35');
INSERT INTO `plant_cover` VALUES (7, 2012, '北京', '69.13', '28.3', '6.55');
INSERT INTO `plant_cover` VALUES (8, 2013, '北京', '71.65', '24.2', '6.7');
INSERT INTO `plant_cover` VALUES (9, 2014, '北京', '73.45', '20', '8.02');
INSERT INTO `plant_cover` VALUES (10, 2015, '北京', '74.5', '17.7', '8.13');
INSERT INTO `plant_cover` VALUES (11, 2016, '北京', '75.6', '15', '8.21');
INSERT INTO `plant_cover` VALUES (12, 2017, '北京', '76.77', '12.6', '8.35');
INSERT INTO `plant_cover` VALUES (13, 2018, '北京', '77.76', '10.6', '8.53');
INSERT INTO `plant_cover` VALUES (14, 2019, '北京', '79.2', '9.2', '8.87');
INSERT INTO `plant_cover` VALUES (15, 2020, '北京', '84.83', '10.2', '9.27');
INSERT INTO `plant_cover` VALUES (16, 2021, '北京', '85.27', '12.2', '9.31');
INSERT INTO `plant_cover` VALUES (17, 2010, '天津', '21.08', '43.93', '1.92');
INSERT INTO `plant_cover` VALUES (19, 2011, '天津', '21.19', '44.33', '2.17');
INSERT INTO `plant_cover` VALUES (20, 2012, '天津', '21.46', '44.99', '2.23');
INSERT INTO `plant_cover` VALUES (21, 2013, '天津', '22.17', '44.21', '2.32');
INSERT INTO `plant_cover` VALUES (22, 2014, '天津', '22.61', '44.43', '2.53');
INSERT INTO `plant_cover` VALUES (23, 2015, '天津', '25.91', '43.47', '2.84');
INSERT INTO `plant_cover` VALUES (24, 2016, '天津', '28.81', '44.37', '3.34');
INSERT INTO `plant_cover` VALUES (25, 2017, '天津', '29.3', '43.95', '4.43');
INSERT INTO `plant_cover` VALUES (26, 2018, '天津', '28.04', '42.93', '4.65');
INSERT INTO `plant_cover` VALUES (27, 2019, '天津', '28.76', '41.03', '4.29');
INSERT INTO `plant_cover` VALUES (28, 2020, '天津', '29.32', '41.92', '4.37');
INSERT INTO `plant_cover` VALUES (29, 2021, '天津', '30.89', '43.7', '4.61');
INSERT INTO `plant_cover` VALUES (30, 2010, '河北', '418.33', '826.08', '6.9');
INSERT INTO `plant_cover` VALUES (31, 2011, '河北', '426.53', '827.83', '7.11');
INSERT INTO `plant_cover` VALUES (32, 2012, '河北', '431.92', '836.19', '7.35');
INSERT INTO `plant_cover` VALUES (33, 2013, '河北', '439.33', '841.6', '7.6');
INSERT INTO `plant_cover` VALUES (34, 2014, '河北', '447.81', '845.49', '7.94');
INSERT INTO `plant_cover` VALUES (35, 2015, '河北', '453.95', '845.78', '8.13');
INSERT INTO `plant_cover` VALUES (36, 2016, '河北', '461.33', '846.73', '8.54');
INSERT INTO `plant_cover` VALUES (37, 2017, '河北', '476.59', '838.17', '8.83');
INSERT INTO `plant_cover` VALUES (38, 2018, '河北', '487.36', '819.71', '9.14');
INSERT INTO `plant_cover` VALUES (39, 2019, '河北', '496.47', '813.27', '9.37');
INSERT INTO `plant_cover` VALUES (40, 2020, '河北', '502.69', '808.94', '9.88');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` VALUES (2, 'ROLE_USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '陈小虎', '{noop}123', 1);
INSERT INTO `user` VALUES (4, '陈博云', '123', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(0) NOT NULL,
  `role_id` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for waste
-- ----------------------------
DROP TABLE IF EXISTS `waste`;
CREATE TABLE `waste`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `province` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `incineration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `landfill` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oxygen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of waste
-- ----------------------------
INSERT INTO `waste` VALUES (1, 2010, '北京', '89.1', '445.4', '9.2');
INSERT INTO `waste` VALUES (2, 2011, '北京', '94.5', '429.6', '19.3');
INSERT INTO `waste` VALUES (3, 2012, '北京', '94.7', '443.2', '18.65');
INSERT INTO `waste` VALUES (4, 2013, '北京', '97.8', '489.9', '17.85');
INSERT INTO `waste` VALUES (5, 2014, '北京', '156.1', '488.6', '16.88');
INSERT INTO `waste` VALUES (6, 2015, '北京', '209.4', '325.8', '16.15');
INSERT INTO `waste` VALUES (7, 2016, '北京', '272.5', '472.8', '8.71');
INSERT INTO `waste` VALUES (8, 2017, '北京', '326.5', '438', '8.18');
INSERT INTO `waste` VALUES (9, 2018, '北京', '399.7', '393.8', '5.6');
INSERT INTO `waste` VALUES (10, 2019, '北京', '548.9', '292', '5.1');
INSERT INTO `waste` VALUES (11, 2020, '北京', '507.2', '111.6', '5.36');
INSERT INTO `waste` VALUES (12, 2021, '北京', '476.1', '57.3', '4.87');
INSERT INTO `waste` VALUES (13, 2010, '天津', '58.3', '125.4', '13.2');
INSERT INTO `waste` VALUES (14, 2011, '天津', '69.3', '120.7', '23.58');
INSERT INTO `waste` VALUES (15, 2012, '天津', '82.3', '103.1', '22.94');
INSERT INTO `waste` VALUES (16, 2013, '天津', '81.3', '112.2', '22.15');
INSERT INTO `waste` VALUES (17, 2014, '天津', '106.6', '102.1', '21.43');
INSERT INTO `waste` VALUES (18, 2015, '天津', '114.2', '109.1', '20.91');
INSERT INTO `waste` VALUES (19, 2016, '天津', '140', '113.4', '10.33');
INSERT INTO `waste` VALUES (20, 2017, '天津', '137.6', '152.2', '9.26');
INSERT INTO `waste` VALUES (21, 2018, '天津', '136.5', '142', '9.15');
INSERT INTO `waste` VALUES (22, 2019, '天津', '191.3', '79.7', '16.73');
INSERT INTO `waste` VALUES (23, 2020, '天津', '195.7', '79.3', '15.63');
INSERT INTO `waste` VALUES (24, 2021, '天津', '309.8', '0.1', '15.52');
INSERT INTO `waste` VALUES (25, 2010, '河北', '58.9', '311.6', '54.61');
INSERT INTO `waste` VALUES (26, 2011, '河北', '92.2', '294.2', '138.9');
INSERT INTO `waste` VALUES (27, 2012, '河北', '114.3', '310.4', '134.91');
INSERT INTO `waste` VALUES (28, 2013, '河北', '95.2', '367.1', '130.99');
INSERT INTO `waste` VALUES (29, 2014, '河北', '150.5', '376.3', '126.85');
INSERT INTO `waste` VALUES (30, 2015, '河北', '220.4', '384.9', '120.81');
INSERT INTO `waste` VALUES (31, 2016, '河北', '288.6', '408.4', '41.12');
INSERT INTO `waste` VALUES (32, 2017, '河北', '284.8', '391.1', '48.68');
INSERT INTO `waste` VALUES (33, 2018, '河北', '343.3', '386.1', '67.92');
INSERT INTO `waste` VALUES (34, 2019, '河北', '380', '387', '116.13');
INSERT INTO `waste` VALUES (35, 2020, '河北', '447.2', '309.7', '127.42');
INSERT INTO `waste` VALUES (36, 2021, '河北', '572.6', '175.8', '153.53');

SET FOREIGN_KEY_CHECKS = 1;
