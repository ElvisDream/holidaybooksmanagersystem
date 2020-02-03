-- 2020-01-18 21:04:10 by Elvis
ALTER TABLE `user` ADD COLUMN `user_name` varchar(32) COMMENT '用户名' AFTER `id`;
-- 2020-01-18 21:04:10 by Elvis
ALTER TABLE `user` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `user_name`;
-- 2020-01-18 21:05:48 by Elvis
ALTER TABLE `user` ADD COLUMN `user_pwd` varchar(32) COMMENT '密码' AFTER `user_name`;
-- 2020-01-18 21:05:48 by Elvis
ALTER TABLE `user` ADD COLUMN `phone` varchar(32) COMMENT '电话' AFTER `user_pwd`;
-- 2020-01-18 21:05:48 by Elvis
ALTER TABLE `user` ADD COLUMN `address` varchar(255) COMMENT '住址' AFTER `phone`;
-- 2020-01-18 21:05:48 by Elvis
ALTER TABLE `user` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `address`;
-- 2020-01-18 21:07:20 by Elvis
ALTER TABLE `user` ADD COLUMN `gender` varchar(10) COMMENT '性别' AFTER `address`;
-- 2020-01-18 21:07:20 by Elvis
ALTER TABLE `user` ADD COLUMN `birthday` date NULL COMMENT '生日' AFTER `gender`;
-- 2020-01-18 21:07:20 by Elvis
ALTER TABLE `user` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `birthday`;
-- 2020-01-18 21:08:49 by Elvis
ALTER TABLE `role` ADD COLUMN `role_name` varchar(32) COMMENT '角色名称' AFTER `id`;
-- 2020-01-18 21:08:49 by Elvis
ALTER TABLE `role` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `role_name`;
-- 2020-01-18 21:09:30 by Elvis
CREATE TABLE `book`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '书籍表';
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `book_name` varchar(255) COMMENT '书籍名称' AFTER `id`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `author` varchar(255) COMMENT '作者' AFTER `book_name`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `publish` varchar(255) COMMENT '出版社' AFTER `author`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `book_code` varchar(255) COMMENT '书籍编号' AFTER `publish`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `book_class_id` varchar(32) COMMENT '书籍类别' AFTER `book_code`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `book_language` varchar(32) COMMENT '语言' AFTER `book_class_id`;
-- 2020-01-18 21:16:20 by Elvis
ALTER TABLE `book` ADD COLUMN `introduction` varchar(2000) COMMENT '简介' AFTER `book_language`;
-- 2020-01-18 21:16:21 by Elvis
ALTER TABLE `book` ADD COLUMN `price` decimal(5,2) COMMENT '价格' AFTER `introduction`;
-- 2020-01-18 21:16:21 by Elvis
ALTER TABLE `book` ADD COLUMN `icon_address` varchar(500) COMMENT '图标' AFTER `price`;
-- 2020-01-18 21:16:21 by Elvis
ALTER TABLE `book` ADD COLUMN `book_nums` int(8) COMMENT '剩余数量' AFTER `icon_address`;
-- 2020-01-18 21:16:21 by Elvis
ALTER TABLE `book` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `book_nums`;
-- 2020-01-18 21:16:48 by Elvis
CREATE TABLE `book_class`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '书籍类别表';
-- 2020-01-18 21:17:58 by Elvis
ALTER TABLE `book_class` ADD COLUMN `class_name` varchar(32) COMMENT '类别名称' AFTER `id`;
-- 2020-01-18 21:17:58 by Elvis
ALTER TABLE `book_class` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `class_name`;
-- 2020-01-18 21:18:40 by Elvis
CREATE TABLE `rent_info`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '租借表';
-- 2020-01-18 21:20:52 by Elvis
ALTER TABLE `rent_info` ADD COLUMN `user_id` varchar(100) COMMENT '外键，租借人id' AFTER `id`;
-- 2020-01-18 21:20:52 by Elvis
CREATE INDEX idx_rent_info_user_id ON `rent_info`(user_id);
-- 2020-01-18 21:20:52 by Elvis
ALTER TABLE `rent_info` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `user_id`;
-- 2020-01-18 21:22:17 by Elvis
ALTER TABLE `rent_info` ADD COLUMN `book_id` varchar(100) COMMENT '外键，外借书籍编号' AFTER `user_id`;
-- 2020-01-18 21:22:17 by Elvis
CREATE INDEX idx_rent_info_book_id ON `rent_info`(book_id);
-- 2020-01-18 21:22:17 by Elvis
ALTER TABLE `rent_info` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `book_id`;
-- 2020-01-18 21:22:33 by Elvis
CREATE TABLE `menu`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '目录表';
-- 2020-01-18 21:23:11 by Elvis
CREATE TABLE `role_menu`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '关联中间表';
-- 2020-01-18 21:23:11 by Elvis
ALTER TABLE `role_menu` ADD COLUMN `menu_id` bigint NOT NULL COMMENT '关联字段' AFTER `id`;
-- 2020-01-18 21:23:11 by Elvis
ALTER TABLE `role_menu` ADD COLUMN `role_id` bigint NOT NULL COMMENT '关联字段' AFTER `menu_id`;
-- 2020-01-18 21:23:11 by Elvis
CREATE INDEX idx_role_menu_relation ON `role_menu`(menu_id,role_id);
-- 2020-01-18 21:24:37 by Elvis
ALTER TABLE `role_menu` MODIFY COLUMN `menu_id` bigint NOT NULL COMMENT 'menu_id' AFTER `id`;
-- 2020-01-18 21:24:37 by Elvis
ALTER TABLE `role_menu` MODIFY COLUMN `role_id` bigint NOT NULL COMMENT 'role_id' AFTER `menu_id`;
-- 2020-01-31 20:14:09 by Elvis
ALTER TABLE `user` ADD COLUMN `email` varchar(100) COMMENT '邮箱' AFTER `update_time`;
-- 2020-02-01 16:49:15 by Elvis
ALTER TABLE `user` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `phone`;
-- 2020-02-01 16:49:15 by Elvis
ALTER TABLE `user` DROP COLUMN `address`;
-- 2020-02-01 16:49:15 by Elvis
ALTER TABLE `user` DROP COLUMN `gender`;
-- 2020-02-01 16:49:15 by Elvis
ALTER TABLE `user` DROP COLUMN `birthday`;
-- 2020-02-03 14:20:30 by Elvis
ALTER TABLE `rent_info` ADD COLUMN `book_nums` int(8) COMMENT '书籍数量' AFTER `book_id`;
-- 2020-02-03 14:20:30 by Elvis
ALTER TABLE `rent_info` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `book_nums`;
