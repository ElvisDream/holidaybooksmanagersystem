/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : holidaylibrary

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 04/02/2020 19:22:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者',
  `publish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `book_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '书籍编号',
  `book_class_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '书籍类别',
  `book_language` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '语言',
  `introduction` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `price` decimal(5, 2) NULL DEFAULT NULL COMMENT '价格',
  `icon_address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `book_nums` int(8) NULL DEFAULT NULL COMMENT '剩余数量',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '书籍表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (10000002, 'Java编程思想', 'Bruce Eckel', '机械工业出版社', '978-7-111-21382-6', '1', '中文', '本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。', 108.00, '../dist/img/books/thinkInJava.jpg', 13, 0, 0, '2020-01-18 21:16:21', '2020-02-03 15:17:14');
INSERT INTO `book` VALUES (10000003, '金色梦乡', '(日)伊坂幸太郎', ' 南海出版公司', '9787544285025', '2', '日本', '《金色梦乡》讲述了一个激动人心的成人童话，从正面勾勒出人与人之间日渐稀缺的友情、爱情和亲情。没有英雄式的主角，每一个人都如此平凡，但他们会在紧要关头伸出援手，帮助你成为英雄', 37.10, '../dist/img/books/jsmx.jpg', 10, 0, 0, '2020-02-02 20:31:45', '2020-02-03 15:17:48');
INSERT INTO `book` VALUES (10000004, '哈利·波特 与魔法石', ' J·K·罗琳', '人民文学出版社', ' 9787020103294', '3', '英文', NULL, 29.00, '../dist/img/books/hlbt.jpg', 3, 0, 0, '2020-02-02 20:34:32', '2020-02-03 10:29:59');

-- ----------------------------
-- Table structure for book_class
-- ----------------------------
DROP TABLE IF EXISTS `book_class`;
CREATE TABLE `book_class`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `class_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '书籍类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_class
-- ----------------------------
INSERT INTO `book_class` VALUES (10000002, '编程类书籍', 0, 0, '2020-01-18 21:17:00', '2020-01-18 21:17:00');

-- ----------------------------
-- Table structure for diboot_column_ext
-- ----------------------------
DROP TABLE IF EXISTS `diboot_column_ext`;
CREATE TABLE `diboot_column_ext`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `table_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
  `col_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '列名',
  `ref_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联类型',
  `ref_relationship` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联关系',
  `ref_table` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联表',
  `ref_column` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联字段',
  `as_column` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示字段',
  `on_target_bind` tinyint(1) NULL DEFAULT NULL COMMENT '在目标中绑定',
  `form_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'INPUT' COMMENT '表单类型',
  `extensions` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展配置',
  `is_deleted` tinyint(1) NULL DEFAULT NULL COMMENT '删除标记',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_diboot_column_ext`(`table_name`, `col_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 173 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'diboot列定义扩展' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diboot_column_ext
-- ----------------------------
INSERT INTO `diboot_column_ext` VALUES (35, 'user_role', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-01-18 20:58:15', '2020-01-18 20:58:15');
INSERT INTO `diboot_column_ext` VALUES (36, 'user_role', 'role_id', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 20:58:15', '2020-01-18 20:58:15');
INSERT INTO `diboot_column_ext` VALUES (37, 'user_role', 'user_id', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 20:58:15', '2020-01-18 20:58:15');
INSERT INTO `diboot_column_ext` VALUES (38, 'user_role', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 20:58:15', '2020-01-18 20:58:15');
INSERT INTO `diboot_column_ext` VALUES (39, 'user_role', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 20:58:15', '2020-01-18 20:58:15');
INSERT INTO `diboot_column_ext` VALUES (70, 'book', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (71, 'book', 'book_name', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (72, 'book', 'author', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (73, 'book', 'publish', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (74, 'book', 'book_code', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (75, 'book', 'book_class_id', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (76, 'book', 'book_language', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (77, 'book', 'introduction', '', '', '', '', '', 0, 'RICH_TEXT', 'float', 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (78, 'book', 'price', '', '', '', '', '', 0, 'INPUT', 'float', 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (79, 'book', 'icon_address', '', '', '', '', '', 0, 'TEXTAREA', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (80, 'book', 'book_nums', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (81, 'book', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (82, 'book', 'create_by', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (83, 'book', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (84, 'book', 'update_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:16:21', '2020-01-18 21:16:21');
INSERT INTO `diboot_column_ext` VALUES (91, 'book_class', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (92, 'book_class', 'class_name', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (93, 'book_class', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (94, 'book_class', 'create_by', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (95, 'book_class', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (96, 'book_class', 'update_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:18:01', '2020-01-18 21:18:01');
INSERT INTO `diboot_column_ext` VALUES (106, 'role', 'id', 'T', 'n-n', 'menu', 'id', '', 0, 'SELECT', 'unsigned', 0, '2020-01-18 21:23:11', '2020-01-18 21:23:11');
INSERT INTO `diboot_column_ext` VALUES (107, 'role', 'role_name', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:23:11', '2020-01-18 21:23:11');
INSERT INTO `diboot_column_ext` VALUES (108, 'role', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:23:11', '2020-01-18 21:23:11');
INSERT INTO `diboot_column_ext` VALUES (109, 'role', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:23:11', '2020-01-18 21:23:11');
INSERT INTO `diboot_column_ext` VALUES (110, 'menu', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-01-18 21:24:01', '2020-01-18 21:24:01');
INSERT INTO `diboot_column_ext` VALUES (111, 'menu', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:24:01', '2020-01-18 21:24:01');
INSERT INTO `diboot_column_ext` VALUES (112, 'menu', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:24:01', '2020-01-18 21:24:01');
INSERT INTO `diboot_column_ext` VALUES (113, 'role_menu', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-01-18 21:24:37', '2020-01-18 21:24:37');
INSERT INTO `diboot_column_ext` VALUES (114, 'role_menu', 'menu_id', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:24:37', '2020-01-18 21:24:37');
INSERT INTO `diboot_column_ext` VALUES (115, 'role_menu', 'role_id', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-01-18 21:24:37', '2020-01-18 21:24:37');
INSERT INTO `diboot_column_ext` VALUES (116, 'role_menu', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-01-18 21:24:37', '2020-01-18 21:24:37');
INSERT INTO `diboot_column_ext` VALUES (117, 'role_menu', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-01-18 21:24:37', '2020-01-18 21:24:37');
INSERT INTO `diboot_column_ext` VALUES (158, 'user', 'id', 'T', 'n-n', 'role', 'id', '', 0, 'SELECT', 'unsigned', 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (159, 'user', 'user_name', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (160, 'user', 'user_pwd', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (161, 'user', 'phone', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (162, 'user', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (163, 'user', 'create_by', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (164, 'user', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (165, 'user', 'update_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (166, 'user', 'email', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-02-01 16:49:15', '2020-02-01 16:49:15');
INSERT INTO `diboot_column_ext` VALUES (167, 'rent_info', 'id', '', '', '', '', '', 0, 'NONE', 'unsigned', 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');
INSERT INTO `diboot_column_ext` VALUES (168, 'rent_info', 'user_id', 'T', 'n-1', 'user', 'id', '', 0, 'SELECT', NULL, 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');
INSERT INTO `diboot_column_ext` VALUES (169, 'rent_info', 'book_id', 'T', 'n-1', 'book', 'id', '', 0, 'SELECT', NULL, 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');
INSERT INTO `diboot_column_ext` VALUES (170, 'rent_info', 'book_nums', '', '', '', '', '', 0, 'INPUT', NULL, 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');
INSERT INTO `diboot_column_ext` VALUES (171, 'rent_info', 'is_deleted', '', '', '', '', '', 0, 'NONE', NULL, 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');
INSERT INTO `diboot_column_ext` VALUES (172, 'rent_info', 'create_time', '', '', '', '', '', 0, 'NONE', 'yyyy-MM-dd HH:mm', 0, '2020-02-03 14:20:30', '2020-02-03 14:20:30');

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` int(10) UNSIGNED NOT NULL COMMENT '父ID',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
  `item_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '显示名',
  `item_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储值',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述说明',
  `extdata` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展JSON',
  `sort_id` smallint(6) NOT NULL DEFAULT 99 COMMENT '排序号',
  `is_editable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可改',
  `is_deletable` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可删',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_directory`(`type`, `item_value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '目录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (10000002, 0, '2020-01-18 21:24:01');

-- ----------------------------
-- Table structure for rent_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_info`;
CREATE TABLE `rent_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外键，租借人id',
  `book_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外键，外借书籍编号',
  `book_nums` int(8) NULL DEFAULT NULL COMMENT '书籍数量',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_rent_info_user_id`(`user_id`) USING BTREE,
  INDEX `idx_rent_info_book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租借表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (10000002, NULL, 0, '2020-01-18 20:52:00');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `menu_id` bigint(20) NOT NULL COMMENT 'menu_id',
  `role_id` bigint(20) NOT NULL COMMENT 'role_id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_menu_relation`(`menu_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关联中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (10000002, 10000002, 10000002, 0, '2020-01-18 21:24:37');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000021 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10000002, 'admin', '123', '13600000000', 0, 0, '2020-01-18 20:51:00', '2020-01-19 22:13:00', '123@136.com');
INSERT INTO `user` VALUES (10000006, 'elvis', '123', '', 0, 0, '2020-01-31 21:56:25', '2020-01-31 21:56:25', '');
INSERT INTO `user` VALUES (10000009, 'aaa', '123', NULL, 0, 0, '2020-02-03 22:44:12', '2020-02-03 22:44:12', NULL);
INSERT INTO `user` VALUES (10000010, 'bbb', NULL, NULL, 0, 0, '2020-02-03 22:44:19', '2020-02-03 22:44:19', NULL);
INSERT INTO `user` VALUES (10000011, 'ccc', NULL, NULL, 0, 0, '2020-02-03 22:44:27', '2020-02-03 22:44:27', NULL);
INSERT INTO `user` VALUES (10000012, 'ddd', NULL, NULL, 0, 0, '2020-02-03 22:44:32', '2020-02-03 22:44:32', NULL);
INSERT INTO `user` VALUES (10000013, 'eee', NULL, NULL, 0, 0, '2020-02-03 22:44:36', '2020-02-03 22:44:36', NULL);
INSERT INTO `user` VALUES (10000014, 'ffff', NULL, NULL, 0, 0, '2020-02-03 22:44:40', '2020-02-03 22:44:40', NULL);
INSERT INTO `user` VALUES (10000015, 'ggg', NULL, NULL, 0, 0, '2020-02-03 22:44:44', '2020-02-03 22:44:44', NULL);
INSERT INTO `user` VALUES (10000016, 'hhhh', NULL, NULL, 0, 0, '2020-02-03 22:44:50', '2020-02-03 22:44:50', NULL);
INSERT INTO `user` VALUES (10000017, 'sdfd', NULL, NULL, 0, 0, '2020-02-03 22:44:55', '2020-02-03 22:44:55', NULL);
INSERT INTO `user` VALUES (10000018, 'wew', NULL, NULL, 0, 0, '2020-02-03 22:44:58', '2020-02-03 22:44:58', NULL);
INSERT INTO `user` VALUES (10000019, 'uyu', NULL, NULL, 0, 0, '2020-02-03 22:45:02', '2020-02-03 22:45:02', NULL);
INSERT INTO `user` VALUES (10000020, 'ili', NULL, NULL, 0, 0, '2020-02-03 22:45:06', '2020-02-03 22:45:06', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(20) NOT NULL COMMENT 'role_id',
  `user_id` bigint(20) NOT NULL COMMENT 'user_id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_role_relation`(`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关联中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (10000002, 10000002, 10000002, 0, '2020-01-18 20:52:00');

SET FOREIGN_KEY_CHECKS = 1;
