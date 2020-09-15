# 数据库日志
create database spring_cache;
use spring_cache;

create table t_staff(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工信息',
  `lastName` varchar(32) DEFAULT NULL COMMENT '姓名',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `gender` int(4) DEFAULT '0' COMMENT '0 男 1 女',
  `d_id` int(11) DEFAULT '0' COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci