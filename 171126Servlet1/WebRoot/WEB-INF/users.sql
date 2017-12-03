# Host: localhost  (Version 5.6.26-log)
# Date: 2017-12-03 18:19:42
# Generator: MySQL-Front 5.3  (Build 8.3)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `user_pwd` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'雷克斯','lks'),(2,'常青','changq'),(3,'唐战','tangz'),(4,'马克思','max'),(5,'老司机','lks'),(6,'南方人','nfr'),(7,'北方人','bfr'),(8,'我是中国人','admin'),(9,'张三','admin');
