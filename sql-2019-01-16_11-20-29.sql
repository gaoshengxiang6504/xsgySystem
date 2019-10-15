/*
Navicat MySQL Data Transfer

Source Server         : jdbc
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : sql-2019-01-16_11-20-29

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-10-15 09:12:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apartinfo
-- ----------------------------
DROP TABLE IF EXISTS `apartinfo`;
CREATE TABLE `apartinfo` (
  `Bno` int(4) NOT NULL,
  `Dno` int(4) NOT NULL,
  `allpeo` int(4) DEFAULT '4',
  `livepeo` int(4) DEFAULT NULL,
  `belongSchool` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Bno`,`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apartinfo
-- ----------------------------
INSERT INTO `apartinfo` VALUES ('1', '101', '4', '4', '软件');
INSERT INTO `apartinfo` VALUES ('1', '102', '4', '1', '软件');
INSERT INTO `apartinfo` VALUES ('1', '103', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '104', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '105', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '106', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '107', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '108', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '109', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '110', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '111', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '112', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '113', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '114', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '115', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '116', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '117', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '118', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '201', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '202', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '203', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '204', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '205', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '206', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '207', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '208', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '209', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '210', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '211', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '212', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '213', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '214', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '215', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '216', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '217', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '218', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '301', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '302', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '303', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '304', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '305', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '306', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '307', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '308', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '309', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '310', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '311', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '312', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '313', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '314', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '315', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '316', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '317', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '318', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '401', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '402', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '403', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '404', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '405', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '406', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '407', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '408', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '409', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '410', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '411', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '412', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '413', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '414', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '415', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '416', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '417', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '418', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '501', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '502', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '503', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '504', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '505', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '506', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '507', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '508', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '509', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '510', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '511', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '512', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '513', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '514', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '515', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '516', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '517', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('1', '518', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '101', '4', '2', '软件');
INSERT INTO `apartinfo` VALUES ('2', '102', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '103', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '104', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '105', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '106', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '107', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '108', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '109', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '110', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '111', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '112', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '113', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '114', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '115', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '116', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '117', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '118', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '201', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '202', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '203', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '204', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '205', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '206', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '207', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '208', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '209', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '210', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '211', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '212', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '213', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '214', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '215', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '216', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '217', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '218', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '301', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '302', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '303', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '304', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '305', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '306', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '307', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '308', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '309', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '310', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '311', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '312', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '313', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '314', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '315', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '316', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '317', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '318', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '401', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '402', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '403', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '404', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '405', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '406', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '407', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '408', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '409', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '410', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '411', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '412', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '413', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '414', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '415', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '416', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '417', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '418', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '501', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '502', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '503', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '504', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '505', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '506', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '507', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '508', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '509', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '510', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '511', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '512', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '513', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '514', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '515', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '516', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '517', '4', '0', '软件');
INSERT INTO `apartinfo` VALUES ('2', '518', '4', '0', '软件');

-- ----------------------------
-- Table structure for asset
-- ----------------------------
DROP TABLE IF EXISTS `asset`;
CREATE TABLE `asset` (
  `pname` varchar(255) NOT NULL,
  `price` varchar(20) DEFAULT NULL,
  `ptotal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asset
-- ----------------------------
INSERT INTO `asset` VALUES ('凳子', '30', '178');
INSERT INTO `asset` VALUES ('水龙头', '20', '100');
INSERT INTO `asset` VALUES ('窗帘', '50', '80');
INSERT INTO `asset` VALUES ('门锁', '10', '290');
INSERT INTO `asset` VALUES ('风扇', '100', '20');

-- ----------------------------
-- Table structure for asset_history
-- ----------------------------
DROP TABLE IF EXISTS `asset_history`;
CREATE TABLE `asset_history` (
  `date` varchar(255) NOT NULL,
  `bno` int(4) DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `pcount` int(8) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asset_history
-- ----------------------------
INSERT INTO `asset_history` VALUES ('2019-01-15 09:31:17', '1', '凳子', '20', '李四');
INSERT INTO `asset_history` VALUES ('2019-01-15 09:59:49', '1', '门锁', '10', '张三');
INSERT INTO `asset_history` VALUES ('2019-01-15 10:34:36', '2', '凳子', '2', '王五');

-- ----------------------------
-- Table structure for in_or_out
-- ----------------------------
DROP TABLE IF EXISTS `in_or_out`;
CREATE TABLE `in_or_out` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `peoname` varchar(20) DEFAULT NULL,
  `peotype` varchar(255) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  `in_time` varchar(255) DEFAULT NULL,
  `out_time` varchar(255) DEFAULT NULL,
  `count_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of in_or_out
-- ----------------------------
INSERT INTO `in_or_out` VALUES ('8', '张三', '学生', '', '2019-01-15 16:5:55', '2019-10-15 09:00:04', '272天16时54分9秒');
INSERT INTO `in_or_out` VALUES ('9', '李四', '维修人员', '', '2019-01-15 16:6:01', '2019-01-15 18:24:39', '0天2时18分38秒');
INSERT INTO `in_or_out` VALUES ('10', '王五', '维修人员', '灯泡', '2019-01-15 16:6:08', '2019-01-15 18:24:40', '0天2时18分32秒');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` int(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `Bno` int(4) DEFAULT NULL,
  `Dno` int(4) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2016006501', '刘子健', '男', '软件', '软件工程', '1601', '1', '101');
INSERT INTO `student` VALUES ('2016006502', '李涛', '男', '软件', '软件工程', '1601', '1', '101');
INSERT INTO `student` VALUES ('2016006503', '孙波', '男', '软件', '软件工程', '1601', '1', '101');
INSERT INTO `student` VALUES ('2016006504', '郑洁茹', '男', '软件', '软件工程', '1601', '1', '101');
INSERT INTO `student` VALUES ('2016006505', '王琦', '男', '软件', '软件工程', '1602', '1', '102');
INSERT INTO `student` VALUES ('2016006506', '李丽', '女', '软件', '软件工程', '1601', '2', '101');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', 'CBCDCPCJHKFHKFKHEDIJEKAOEKIABPMD');
INSERT INTO `users` VALUES ('tylg', 'LHGOEBDCLKJABBMHHICKEFLICOLNOHAN');
DROP TRIGGER IF EXISTS `trigger1`;
DELIMITER ;;
CREATE TRIGGER `trigger1` BEFORE INSERT ON `asset_history` FOR EACH ROW BEGIN

  update asset set ptotal=ptotal-new.pcount where pname=new.pname;

END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `triggerInsert`;
DELIMITER ;;
CREATE TRIGGER `triggerInsert` BEFORE INSERT ON `student` FOR EACH ROW begin

  declare _dno int;

  declare _bno int;

  declare _livepeo int;

  declare _sex varchar(4);

  declare _allpeo int;

  declare _college varchar(20) character set utf8;



  set _college = new.college;

  set _sex = new.sex;

  select Bno into _bno from apartinfo where belongSchool = _college AND livepeo <4 AND Bno=if(_sex!='男','2','1') limit 1;

  select Dno into _dno from apartinfo where belongSchool = _college AND livepeo <4 AND Bno=if(_sex!='男','2','1') limit 1;

  update apartinfo set livepeo=livepeo+1 where belongSchool = _college AND livepeo <4 AND Bno=if(_sex!='男','2','1') limit 1;

  set new.Bno=_bno;

  set new.Dno=_dno;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `triggerDelete`;
DELIMITER ;;
CREATE TRIGGER `triggerDelete` AFTER DELETE ON `student` FOR EACH ROW begin

  declare _dno int;

  declare _bno int;

  declare _allpeo int;

  declare _college varchar(20) character set utf8;



  set _bno = old.Bno;

  set _dno = old.Dno;

  set _college = old.college;

  update apartinfo set livepeo=livepeo-1 where belongSchool = _college AND livepeo <4 AND Bno=_bno AND Dno = _dno;

end
;;
DELIMITER ;
