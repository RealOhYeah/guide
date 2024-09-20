/*
 Navicat Premium Data Transfer

 Source Server         : Guide
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : 192.168.0.211:3306
 Source Schema         : guide

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 20/09/2024 21:00:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guide
-- ----------------------------
DROP TABLE IF EXISTS `guide`;
CREATE TABLE `guide`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网址名',
  `to_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网址链接',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态（0：普通，1：管理）',
  `del_flag` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除（0：未删除，1：已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guide
-- ----------------------------
INSERT INTO `guide` VALUES (3, 'abilibili666666666', 'https://www.bilibili.com/', '2024-04-09 00:00:00', 3, '2024-04-10 00:00:00', 4, 0, 0);
INSERT INTO `guide` VALUES (4, '百a度', 'https://fanyi.baidu.com/', '2024-04-10 09:16:09', 4, '2024-04-16 00:00:00', 5, 1, 1);
INSERT INTO `guide` VALUES (5, '微a博', 'https://m.weibo.cn/', '2024-03-15 06:00:00', 1, '2024-03-15 14:13:00', 1, 0, 0);
INSERT INTO `guide` VALUES (27, '淘宝', 'https://www.taobao.com/', '2024-04-10 15:13:13', 1, '2024-04-10 15:13:13', 1, 0, 0);
INSERT INTO `guide` VALUES (29, '123', '123', '2024-05-06 16:00:00', 123, '2024-05-23 16:00:00', 123, 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名字',
  `role` int NULL DEFAULT NULL COMMENT '权限',
  `org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  `del_flag` int NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-20 16:26:36', 0, 0);
INSERT INTO `user` VALUES (3, 'a', 'a', NULL, NULL, NULL, NULL, NULL, NULL, '2024-06-09 23:12:49', 0, 0);
INSERT INTO `user` VALUES (4, 'b', 'b', NULL, NULL, NULL, NULL, '2024-03-14 22:14:31', NULL, '2024-04-26 12:33:01', 0, 0);
INSERT INTO `user` VALUES (5, 'c', 'c', NULL, NULL, NULL, NULL, '2024-03-14 22:46:39', NULL, '2024-03-14 22:46:39', 0, 0);
INSERT INTO `user` VALUES (6, 'e', 'e', NULL, NULL, NULL, NULL, '2024-03-15 15:16:13', NULL, '2024-03-15 15:16:13', 0, 0);
INSERT INTO `user` VALUES (7, '1234', '1234', NULL, NULL, NULL, NULL, '2024-04-01 18:40:26', NULL, '2024-04-04 11:53:57', 0, 0);
INSERT INTO `user` VALUES (8, '123123', '', NULL, NULL, NULL, NULL, '2024-04-08 17:54:07', NULL, '2024-04-08 17:54:07', 0, 0);
INSERT INTO `user` VALUES (9, '123', '123', NULL, NULL, NULL, NULL, '2024-04-08 17:59:42', NULL, '2024-05-14 13:57:52', 0, 0);
INSERT INTO `user` VALUES (10, '12', '12', NULL, NULL, NULL, NULL, '2024-04-09 19:51:20', NULL, '2024-04-09 19:52:10', 0, 0);
INSERT INTO `user` VALUES (11, '1', '', NULL, NULL, NULL, NULL, '2024-04-10 14:14:59', NULL, '2024-04-10 14:14:59', 0, 0);
INSERT INTO `user` VALUES (12, '111', '111', NULL, NULL, NULL, NULL, '2024-04-10 14:28:40', NULL, '2024-04-11 15:52:23', 0, 0);
INSERT INTO `user` VALUES (13, '555', '555', NULL, NULL, NULL, NULL, '2024-04-10 14:29:21', NULL, '2024-04-10 14:29:21', 0, 0);
INSERT INTO `user` VALUES (14, '222', '222', NULL, NULL, NULL, NULL, '2024-04-10 15:00:42', NULL, '2024-04-10 15:00:45', 0, 0);
INSERT INTO `user` VALUES (15, 'f', 'f', NULL, NULL, NULL, NULL, '2024-04-10 16:21:47', NULL, '2024-04-10 16:21:47', 0, 0);
INSERT INTO `user` VALUES (16, 'g', 'g', NULL, NULL, NULL, NULL, '2024-04-10 16:22:24', NULL, '2024-04-10 16:22:24', 0, 0);
INSERT INTO `user` VALUES (17, '666', '666', NULL, NULL, NULL, NULL, '2024-04-10 18:33:01', NULL, '2024-04-10 18:33:01', 0, 0);
INSERT INTO `user` VALUES (18, '7', '7', NULL, NULL, NULL, NULL, '2024-04-11 15:07:08', NULL, '2024-04-11 15:07:40', 0, 0);
INSERT INTO `user` VALUES (19, '4', '4', NULL, NULL, NULL, NULL, '2024-04-11 16:12:01', NULL, '2024-04-11 16:12:01', 0, 0);
INSERT INTO `user` VALUES (20, '5', '5', NULL, NULL, NULL, NULL, '2024-04-11 16:13:03', NULL, '2024-04-11 16:13:06', 0, 0);
INSERT INTO `user` VALUES (21, '2', '2', NULL, NULL, NULL, NULL, '2024-04-11 16:16:26', NULL, '2024-04-11 17:02:30', 0, 0);
INSERT INTO `user` VALUES (22, '9', '9', NULL, NULL, NULL, NULL, '2024-04-11 16:50:21', NULL, '2024-04-11 16:50:23', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
