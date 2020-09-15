use  spring_boot;
drop table `t_person` if exists ;

create table `t_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `last_name` varchar (64) default null ,
  `sex` varchar (32) default 'MAN',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8