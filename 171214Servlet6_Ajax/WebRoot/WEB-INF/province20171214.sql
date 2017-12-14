# Host: 127.0.0.1  (Version 5.6.26-log)
# Date: 2017-12-14 09:11:34
# Generator: MySQL-Front 5.3  (Build 8.3)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "province"
#

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `pid` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "province"
#

INSERT INTO `province` VALUES (1,'北京市'),(2,'天津市'),(3,'上海市'),(4,'重庆市'),(5,'河北省'),(6,'山西省'),(7,'台湾省'),(8,'辽宁省'),(9,'吉林省'),(10,'黑龙江省'),(11,'江苏省'),(12,'浙江省'),(13,'安徽省'),(14,'福建省'),(15,'江西省'),(16,'山东省'),(17,'河南省'),(18,'湖北省'),(19,'湖南省'),(20,'广东省'),(21,'甘肃省'),(22,'四川省'),(23,'贵州省'),(24,'海南省'),(25,'云南省'),(26,'青海省'),(27,'陕西省'),(28,'广西壮族自治区'),(29,'西藏自治区'),(30,'宁夏回族自治区'),(31,'新疆维吾尔自治区'),(32,'内蒙古自治区'),(33,'澳门特别行政区'),(34,'香港特别行政区');
