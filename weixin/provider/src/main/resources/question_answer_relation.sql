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

 Date: 31/08/2025 19:54:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question_answer_relation
-- ----------------------------
DROP TABLE IF EXISTS `question_answer_relation`;
CREATE TABLE `question_answer_relation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '关联记录唯一标识（自增主键）',
  `question_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '问题表中的问题ID，如：问题表中的 _id',
  `answer_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回答表中的回答ID，如：回答表中的 _id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '问题与回答关联表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
