/*
 Navicat MySQL Data Transfer

 Source Server         : winfrid
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 8.129.215.34:3306
 Source Schema         : morning_csu

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 04/03/2021 20:35:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for badge
-- ----------------------------
DROP TABLE IF EXISTS `badge`;
CREATE TABLE `badge`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `days7_badge` int(4) NULL DEFAULT 0 COMMENT '7天徽章',
  `days21_badge` int(4) NULL DEFAULT 0 COMMENT '21天徽章',
  `days28_badge` int(4) NULL DEFAULT 0 COMMENT '28天徽章',
  `days60_badge` int(4) NULL DEFAULT 0 COMMENT '60天徽章',
  `days90_badge` int(4) NULL DEFAULT 0 COMMENT '90天徽章',
  `days100_badge` int(4) NULL DEFAULT 0 COMMENT '100天徽章',
  `days120_badge` int(4) NULL DEFAULT 0 COMMENT '120天徽章',
  `days150_badge` int(4) NULL DEFAULT 0 COMMENT '150天徽章',
  `days180_badge` int(4) NULL DEFAULT 0 COMMENT '180天徽章',
  `days210_badge` int(4) NULL DEFAULT 0 COMMENT '210天徽章',
  `days240_badge` int(4) NULL DEFAULT 0 COMMENT '240天徽章',
  `days270_badge` int(4) NULL DEFAULT 0 COMMENT '270天徽章',
  `days300_badge` int(4) NULL DEFAULT 0 COMMENT '300天徽章',
  `days330_badge` int(4) NULL DEFAULT 0 COMMENT '330天徽章',
  `days365_badge` int(4) NULL DEFAULT 0 COMMENT '365天徽章',
  `activity_badge` int(4) NULL DEFAULT 0 COMMENT '活跃徽章',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '徽章信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `media_id` bigint(20) NOT NULL COMMENT '媒体文件id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `media_id`(`media_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 226 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for media_file
-- ----------------------------
DROP TABLE IF EXISTS `media_file`;
CREATE TABLE `media_file`  (
  `media_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '媒体文件id',
  `media_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '音视频标题',
  `media_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '音视频文件地址',
  `media_type` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型，视频/音频',
  `introduction` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本内容',
  `duration` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时长',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0表示未通过，1表示通过',
  PRIMARY KEY (`media_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3342 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '媒体文件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `notice_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`notice_id`) USING BTREE,
  UNIQUE INDEX `notice_title`(`notice_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for notice_img
-- ----------------------------
DROP TABLE IF EXISTS `notice_img`;
CREATE TABLE `notice_img`  (
  `notice_img_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知图片id',
  `notice_img_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知图片地址',
  `notice_id` int(4) NOT NULL COMMENT '通知id',
  PRIMARY KEY (`notice_img_id`) USING BTREE,
  INDEX `notice_id`(`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知图片表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sign_in_record
-- ----------------------------
DROP TABLE IF EXISTS `sign_in_record`;
CREATE TABLE `sign_in_record`  (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '签到ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `month` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月份，用年+月表示，如(202010)',
  `counts` int(2) NULL DEFAULT 0 COMMENT '该月签到次数',
  `milliseconds` int(10) NULL DEFAULT 0 COMMENT '签到毫秒数，用于签到次数相同时的排序',
  `continuous_counts` int(2) NULL DEFAULT 0 COMMENT '该月连续签到次数',
  `record_bits` char(31) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0000000000000000000000000000000' COMMENT '31位标志每月签到记录',
  PRIMARY KEY (`record_id`) USING BTREE,
  UNIQUE INDEX `month`(`month`, `user_id`) USING BTREE,
  INDEX `month_2`(`month`, `counts`, `milliseconds`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '每月签到数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openid` char(28) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信ID',
  `nick_name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '微信昵称',
  `avatar` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `last_sign_in_date` date NOT NULL COMMENT '上次签到日期',
  `total_counts` int(4) NULL DEFAULT 0 COMMENT '总签到次数',
  `total_continuous_counts` int(4) NULL DEFAULT 0 COMMENT '总连续签到次数',
  `notice_read` tinyint(1) NULL DEFAULT 0 COMMENT '通知是否已读(0未读,1已读)',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `openid`(`openid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8471 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
