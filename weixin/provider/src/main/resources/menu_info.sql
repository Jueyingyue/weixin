/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : weixin

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/09/2025 22:55:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `biz_type_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务类型代码',
  `index_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-第一板块 2-第二版块 3-第三版块',
  `biz_type_cn_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `biz_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`index_type`, `biz_type_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('happiness', '1', '幸福感', '3');
INSERT INTO `menu_info` VALUES ('PerfectType', '1', '完美型', '1');
INSERT INTO `menu_info` VALUES ('RealQuestionsExam312', '1', '情绪问题咨询', '2');
INSERT INTO `menu_info` VALUES ('SanguineType', '10', '性格-DISC性格', '3');
INSERT INTO `menu_info` VALUES ('futurePrediction', '11', '未来预测', '3');
INSERT INTO `menu_info` VALUES (' FortuneTendency', '12', '运势心理倾向', '1');
INSERT INTO `menu_info` VALUES ('MelancholicType', '12', '爱情-依恋类型', '3');
INSERT INTO `menu_info` VALUES ('MBTI', '13', '性格-MBTI测试', '3');
INSERT INTO `menu_info` VALUES ('PhlegmaticType', '14', '性格大五人格', '3');
INSERT INTO `menu_info` VALUES ('BileType', '15', '性格-九型人格', '3');
INSERT INTO `menu_info` VALUES ('ExtrovertType', '2', '爱情-恋爱风格', '3');
INSERT INTO `menu_info` VALUES ('IntroductionToPsychology', '2', '人际关系咨询', '2');
INSERT INTO `menu_info` VALUES ('LovingType', '2', '全爱型', '1');
INSERT INTO `menu_info` VALUES ('AchievingType', '3', '成就型', '1');
INSERT INTO `menu_info` VALUES ('IntrovertType', '3', '情商-情绪识别', '3');
INSERT INTO `menu_info` VALUES ('PsychologicalMeasurement', '3', '职业发展咨询', '2');
INSERT INTO `menu_info` VALUES ('ArtisticType', '4', '艺术型', '1');
INSERT INTO `menu_info` VALUES ('PsychologicalAndEducationalMeasurement', '4', '婚姻家庭咨询', '2');
INSERT INTO `menu_info` VALUES ('RationalType', '4', '情商-情绪管理', '3');
INSERT INTO `menu_info` VALUES ('IntellectualType', '5', '智慧型', '1');
INSERT INTO `menu_info` VALUES ('RealQuestionsUniversityExams', '5', '学习问题咨询', '2');
INSERT INTO `menu_info` VALUES ('WillpowerType', '5', '情商-同理心', '3');
INSERT INTO `menu_info` VALUES ('EmotionalType', '6', '情商-人际关系', '3');
INSERT INTO `menu_info` VALUES ('LoyalType', '6', '忠诚型', '1');
INSERT INTO `menu_info` VALUES ('RealQuestionsExam347', '6', '心理创伤咨询', '2');
INSERT INTO `menu_info` VALUES ('ActiveType', '7', '活跃型', '1');
INSERT INTO `menu_info` VALUES ('OpennessType', '7', '抑郁自评量表', '3');
INSERT INTO `menu_info` VALUES ('SocialPsychology', '7', '障碍性咨询', '2');
INSERT INTO `menu_info` VALUES ('EducationalPsychology  ', '8', '发展性咨询', '2');
INSERT INTO `menu_info` VALUES ('ExtraversionType', '8', '焦虑自评量表', '3');
INSERT INTO `menu_info` VALUES ('LeaderType', '8', '领袖型', '1');
INSERT INTO `menu_info` VALUES ('AgreeablenessType', '9', '压力测试', '3');
INSERT INTO `menu_info` VALUES ('DevelopmentalPsychology  ', '9', '健康性咨询', '2');
INSERT INTO `menu_info` VALUES ('PeaceType', '9', '和平型', '1');

SET FOREIGN_KEY_CHECKS = 1;
