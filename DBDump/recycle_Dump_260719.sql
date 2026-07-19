-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.46 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.20.0.7320
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- recycle 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `recycle` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `recycle`;

-- 테이블 recycle.eventlog 구조 내보내기
CREATE TABLE IF NOT EXISTS `eventlog` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `robotId` bigint NOT NULL,
  `eventType` varchar(50) NOT NULL,
  `message` varchar(50) NOT NULL,
  `note` text,
  `status` varchar(50) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='이벤트 로그';

-- 테이블 데이터 recycle.eventlog:~10 rows (대략적) 내보내기
INSERT INTO `eventlog` (`uid`, `robotId`, `eventType`, `message`, `note`, `status`, `createTime`) VALUES
	(1, 1, 'PATROL_START', '순찰 시작', NULL, 'Task', '2026-07-19 18:56:15'),
	(2, 1, 'OBJECT_DETECTED', '물체 감지', 'object:"plastic_bottle",\n confidence:0.87,\n class_id:1', 'Detect', '2026-07-19 18:56:57'),
	(3, 1, 'OBJECT_PICKUP_START', '수거 시작', NULL, 'Task', '2026-07-19 18:57:44'),
	(4, 1, 'OBJECT_PICKUP_SUCCESS', '수거 성공', NULL, 'Task', '2026-07-19 18:57:59'),
	(5, 1, 'PATROL_COMPLETE', '순찰 종료', NULL, 'Task', '2026-07-19 18:58:41'),
	(6, 1, 'BATTERY_LOW', '배터리 부족', '배터리가 30% 이하입니다.', 'Warning', '2026-07-19 19:01:27'),
	(7, 1, 'PATROL_RESUME', '순찰 재개', NULL, 'Task', '2026-07-19 20:51:47'),
	(8, 1, 'OBJECT_PICKUP_FAIL', '수거 실패', NULL, 'Error', '2026-07-19 20:52:28'),
	(9, 1, 'USER_COMMAND', '사용자 명령', '순찰 시작', 'Task', '2026-07-19 20:53:05'),
	(10, 1, 'USER_COMMAND', '사용자 명령', '순찰 종료', 'Task', '2026-07-19 20:54:57');

-- 테이블 recycle.recyclehistory 구조 내보내기
CREATE TABLE IF NOT EXISTS `recyclehistory` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `objectType` varchar(50) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0' COMMENT '물체 수거 성공 여부',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='물체 수거 로그';

-- 테이블 데이터 recycle.recyclehistory:~0 rows (대략적) 내보내기
INSERT INTO `recyclehistory` (`uid`, `objectType`, `status`, `createTime`) VALUES
	(1, 'Plastic', 'True', '2026-07-19 20:08:29'),
	(2, 'Can', 'True', '2026-07-19 20:08:38'),
	(3, 'Paper', 'True', '2026-07-19 20:08:51');

-- 테이블 recycle.robot 구조 내보내기
CREATE TABLE IF NOT EXISTS `robot` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `model` varchar(50) NOT NULL,
  `rosVersion` varchar(50) NOT NULL,
  `currentVersion` varchar(50) NOT NULL,
  `runTime` bigint NOT NULL DEFAULT (0),
  `lastInspection` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='로봇 종류';

-- 테이블 데이터 recycle.robot:~0 rows (대략적) 내보내기
INSERT INTO `robot` (`uid`, `name`, `model`, `rosVersion`, `currentVersion`, `runTime`, `lastInspection`) VALUES
	(1, 'turtlebot3-01', 'Turtlebot3 Waffle Pi', 'ROS2 Humble', 'v1.2.0', 0, '2026-07-19 00:00:00');

-- 테이블 recycle.setting 구조 내보내기
CREATE TABLE IF NOT EXISTS `setting` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `detectionSensitivity` float DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 recycle.setting:~0 rows (대략적) 내보내기
INSERT INTO `setting` (`uid`, `detectionSensitivity`) VALUES
	(1, 0.5);

-- 테이블 recycle.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자';

-- 테이블 데이터 recycle.user:~2 rows (대략적) 내보내기
INSERT INTO `user` (`uid`, `id`, `password`, `name`) VALUES
	(2, '1234', '$2a$10$4HgE3NUT8Mb/aNKfyAkbD.etkhe7Hr4K9O6K/Gt55PdX/zXZSmbuK', '1234'),
	(3, 'qwer', '$2a$10$Z6OUWXOrvqPcKY5f4T9yae095A81bulAg6eWPtXUObZ2m3qCOQ8dm', 'qwer');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
