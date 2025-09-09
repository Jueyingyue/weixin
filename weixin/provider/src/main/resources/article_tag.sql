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

 Date: 01/09/2025 20:40:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标签唯一ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名称，如 技术、生活、随笔',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, '压力管理', '2025-08-12 22:49:51', NULL);
INSERT INTO `article_tag` VALUES (2, '沟通技巧', '2025-08-12 22:50:16', NULL);
INSERT INTO `article_tag` VALUES (3, '学习方法', '2025-08-12 22:50:22', NULL);
INSERT INTO `article_tag` VALUES (4, '情绪管理', '2025-08-12 22:50:29', NULL);
INSERT INTO `article_tag` VALUES (6, '自我提升', '2025-08-12 22:50:46', NULL);
INSERT INTO `article_tag` VALUES (7, '心理学习', '2025-08-12 22:50:55', NULL);
INSERT INTO `article_tag` VALUES (8, '人际关系', '2025-08-12 22:50:36', NULL);

SET FOREIGN_KEY_CHECKS = 1;
