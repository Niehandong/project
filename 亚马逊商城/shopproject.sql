/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.20 : Database - shopproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopproject` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shopproject`;

/*Table structure for table `easybuy_comment` */

DROP TABLE IF EXISTS `easybuy_comment`;

CREATE TABLE `easybuy_comment` (
  `hC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HC_REPLY` varchar(200) DEFAULT NULL,
  `HC_CONTENT` varchar(200) DEFAULT NULL,
  `HC_CREATE_TIME` datetime DEFAULT NULL,
  `HC_REPLY_TIME` datetime DEFAULT NULL,
  `HC_NICK_NAME` varchar(200) DEFAULT NULL,
  `HC_STATE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`hC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_comment` */

insert  into `easybuy_comment`(`hC_ID`,`HC_REPLY`,`HC_CONTENT`,`HC_CREATE_TIME`,`HC_REPLY_TIME`,`HC_NICK_NAME`,`HC_STATE`) values (1,'新年不夜夏，通宵也是开张啦','新年不夜夏，通宵也是开张啦','2012-03-09 16:53:11','2012-03-09 16:53:11','新年',NULL);

/*Table structure for table `hwua_cart` */

DROP TABLE IF EXISTS `hwua_cart`;

CREATE TABLE `hwua_cart` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(10) DEFAULT NULL,
  `QUANTITY` int(10) DEFAULT NULL,
  `USERID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `hwua_cart` */

insert  into `hwua_cart`(`ID`,`PID`,`QUANTITY`,`USERID`) values (6,3,100,3);

/*Table structure for table `hwua_comment` */

DROP TABLE IF EXISTS `hwua_comment`;

CREATE TABLE `hwua_comment` (
  `HC_ID` int(10) NOT NULL AUTO_INCREMENT,
  `HC_REPLY` varchar(200) DEFAULT NULL,
  `HC_CONTENT` varchar(200) NOT NULL,
  `HC_CREATE_TIME` date NOT NULL,
  `HC_REPLY_TIME` date DEFAULT NULL,
  `HC_NICK_NAME` varchar(50) NOT NULL,
  `HC_STATE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`HC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `hwua_comment` */

insert  into `hwua_comment`(`HC_ID`,`HC_REPLY`,`HC_CONTENT`,`HC_CREATE_TIME`,`HC_REPLY_TIME`,`HC_NICK_NAME`,`HC_STATE`) values (1,'最新酷睿笔记本','i7超强配置，赶快下手啦!','2012-03-08','2012-03-08','天天',NULL),(2,'团购无忧','团购上拉手拉手上团购','2012-03-08','2012-03-08','拉手',NULL),(3,'会员特惠月开始','积分大返利，机不可失失不再来!','2012-03-08','2012-03-08','会员',NULL),(4,'加入会员，赢千万大礼包','我是会员我快乐啦啦啦啦啦','2012-03-08','2012-03-08','我是神',NULL),(5,'赢双旦促销大酬宾','元旦圣诞超级大礼包等你拿啦','2012-03-08','2012-03-08','双蛋',NULL),(6,NULL,'我的留言','2017-08-03',NULL,'yang',NULL),(7,NULL,'dafadsf','2017-08-18',NULL,'asdf',NULL),(8,NULL,'adf','2017-08-18',NULL,'asdf',NULL);

/*Table structure for table `hwua_news` */

DROP TABLE IF EXISTS `hwua_news`;

CREATE TABLE `hwua_news` (
  `HN_ID` int(10) NOT NULL,
  `HN_TITLE` varchar(80) NOT NULL,
  `HN_CONTENT` varchar(1000) NOT NULL,
  `HN_CREATE_TIME` date NOT NULL,
  PRIMARY KEY (`HN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hwua_news` */

insert  into `hwua_news`(`HN_ID`,`HN_TITLE`,`HN_CONTENT`,`HN_CREATE_TIME`) values (1,'会员特惠月开始','积分大返利，机不可失失不再来!','2012-03-08'),(2,'加入会员，赢千万大礼包','我是会员我快乐啦啦啦啦啦','2012-03-08'),(3,'积分兑换开始了','积分兑换开始了积分兑换开始了积分兑换开始了','2012-03-08'),(4,'配货通知','开始配货开始配货开始配货开始配货!','2012-03-08'),(5,'团购阿迪1折起','团购阿迪1折起团购阿迪1折起团购阿迪1折起！','2012-03-08'),(6,'汇源果汁大甩卖','甩卖甩卖甩卖甩卖甩卖甩卖','2012-03-08'),(7,'苹果手机不要钱','不要不要钱不要钱不要钱不要钱','2012-03-08');

/*Table structure for table `hwua_order` */

DROP TABLE IF EXISTS `hwua_order`;

CREATE TABLE `hwua_order` (
  `HO_ID` int(10) NOT NULL AUTO_INCREMENT,
  `HO_USER_ID` int(10) DEFAULT NULL,
  `HO_USER_NAME` varchar(50) NOT NULL,
  `HO_USER_ADDRESS` varchar(200) NOT NULL,
  `HO_CREATE_TIME` date NOT NULL,
  `HO_COST` int(10) NOT NULL,
  `HO_STATUS` int(6) NOT NULL,
  `HO_TYPE` int(6) NOT NULL,
  PRIMARY KEY (`HO_ID`),
  KEY `HO_USER_ID_FK` (`HO_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `hwua_order` */

insert  into `hwua_order`(`HO_ID`,`HO_USER_ID`,`HO_USER_NAME`,`HO_USER_ADDRESS`,`HO_CREATE_TIME`,`HO_COST`,`HO_STATUS`,`HO_TYPE`) values (1,1000,'234','123','2012-03-19',100,2,1),(2,1001,'朱琦','重庆','2012-03-19',22191,1,1),(3,1000,'234','123','2012-03-19',100,1,1),(4,1000,'234','123','2012-03-19',100,1,1),(5,1000,'234','123','2012-03-19',100,1,1),(6,1000,'234','123','2012-03-19',100,1,1),(7,1000,'234','123','2012-03-19',100,1,1),(8,1000,'234','123','2012-03-19',100,1,1),(9,1000,'234','123','2012-03-19',100,1,1),(10,1000,'234','123','2012-03-19',100,1,1),(11,5,'admin','上海','2017-08-29',5580,1,1),(12,5,'admin','上海','2017-08-29',0,1,1),(13,5,'admin','上海','2017-09-01',300,1,1),(14,5,'admin','上海','2017-09-01',578,1,1),(15,8,'xiaoye','æ¹åæ­¦æ±','2017-10-19',4199,1,1);

/*Table structure for table `hwua_order_detail` */

DROP TABLE IF EXISTS `hwua_order_detail`;

CREATE TABLE `hwua_order_detail` (
  `HOD_ID` int(10) NOT NULL AUTO_INCREMENT,
  `HO_ID` int(10) DEFAULT NULL,
  `HP_ID` int(10) DEFAULT NULL,
  `HOD_QUANTITY` int(10) NOT NULL,
  `HOD_COST` int(10) NOT NULL,
  PRIMARY KEY (`HOD_ID`),
  KEY `HOD_ID_FK` (`HO_ID`),
  KEY `HOD_HP_ID_FK` (`HP_ID`),
  CONSTRAINT `HOD_HP_ID_FK` FOREIGN KEY (`HP_ID`) REFERENCES `hwua_product` (`HP_ID`),
  CONSTRAINT `HOD_ID_FK` FOREIGN KEY (`HO_ID`) REFERENCES `hwua_order` (`HO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `hwua_order_detail` */

insert  into `hwua_order_detail`(`HOD_ID`,`HO_ID`,`HP_ID`,`HOD_QUANTITY`,`HOD_COST`) values (1,1,1,1,1),(2,2,2,2,2),(3,1,23,20,2345),(4,NULL,2,20,5580),(5,NULL,3,12,50388),(6,NULL,5,7,483),(7,NULL,4,3,300),(8,NULL,3,1,4199),(9,NULL,18,2,578),(10,NULL,3,1,4199);

/*Table structure for table `hwua_product` */

DROP TABLE IF EXISTS `hwua_product`;

CREATE TABLE `hwua_product` (
  `HP_ID` int(10) NOT NULL,
  `HP_NAME` varchar(50) NOT NULL,
  `HP_DESCRIPTION` varchar(100) DEFAULT NULL,
  `HP_PRICE` int(10) NOT NULL,
  `HP_STOCK` int(10) NOT NULL,
  `HPC_ID` int(10) DEFAULT NULL,
  `HPC_CHILD_ID` int(10) DEFAULT NULL,
  `HP_FILE_NAME` varchar(200) NOT NULL,
  PRIMARY KEY (`HP_ID`),
  KEY `HPC_ID_FK` (`HPC_ID`),
  KEY `HPC_CHILD_ID` (`HPC_CHILD_ID`),
  CONSTRAINT `HPC_CHILD_ID` FOREIGN KEY (`HPC_CHILD_ID`) REFERENCES `hwua_product_category` (`HPC_ID`),
  CONSTRAINT `HPC_ID_FK` FOREIGN KEY (`HPC_ID`) REFERENCES `hwua_product_category` (`HPC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hwua_product` */

insert  into `hwua_product`(`HP_ID`,`HP_NAME`,`HP_DESCRIPTION`,`HP_PRICE`,`HP_STOCK`,`HPC_ID`,`HPC_CHILD_ID`,`HP_FILE_NAME`) values (1,'乐扣普通型保鲜盒圣诞7件套','圣诞7件套',69,20,2,7,'images/product/2.jpg'),(2,'欧珀莱均衡保湿四件套','均衡保湿四件套',279,30,2,8,'images/product/3.jpg'),(3,'联想笔记本电脑 高速独立显存','高速独立显存 I7处理器',4199,36,2,16,'images/product/4.jpg'),(4,'德菲丝巧克力','108.00',100,108,1,4,'images/product/1.jpg'),(5,'Genius925纯银施华洛世奇水晶吊坠','华洛世奇水晶吊坠',69,43,2,12,'images/product/6.jpg'),(6,'利仁2018M福满堂电饼铛 好用实惠','福满堂电饼铛 好用实惠',268,50,2,15,'images/product/7.jpg'),(7,'达派高档拉杆箱20寸 经典款式','高档拉杆箱20寸 经典款式',198,50,2,14,'images/product/8.jpg'),(8,'爱国者MP4 全屏触摸多格式播放 4G','全屏触摸多格式播放 4G',289,50,2,11,'images/product/0.jpg'),(9,'多美滋金装金盾3阶段幼儿配方奶粉','金盾3阶段幼儿配方奶粉',186,50,1,10,'images/product/10.jpg'),(10,'德菲丝巧克力','巧克力500g/盒',108,100,1,10,'images/product/1.jpg'),(11,'乐扣普通型保鲜盒圣诞7件套','圣诞7件套',69,2000,2,7,'images/product/2.jpg'),(12,'欧珀莱均衡保湿四件套','均衡保湿四件套',279,50,2,8,'images/product/3.jpg'),(13,'联想笔记本电脑 高速独立显存','高速独立显存 I7处理器',4199,50,2,16,'images/product/4.jpg'),(14,'上衣','红色上衣',199,100,2,19,'images/product/clothes2.jpg'),(15,'Genius925纯银施华洛世奇水晶吊坠','华洛世奇水晶吊坠',69,50,2,12,'images/product/6.jpg'),(16,'利仁2018M福满堂电饼铛 好用实惠','福满堂电饼铛 好用实惠',268,50,2,15,'images/product/7.jpg'),(17,'达派高档拉杆箱20寸 经典款式','高档拉杆箱20寸 经典款式',198,50,2,14,'images/product/8.jpg'),(18,'爱国者MP4 全屏触摸多格式播放 4G','全屏触摸多格式播放 4G',289,48,2,11,'images/product/0.jpg'),(19,'多美滋金装金盾3阶段幼儿配方奶粉','金盾3阶段幼儿配方奶粉',186,50,1,10,'images/product/10.jpg'),(20,'上衣','夹克',99,100,2,19,'images/product/clothes3.jpg'),(21,'上衣','粉色上衣',96,100,2,19,'images/product/clothes5.jpg'),(22,'上衣','灰色上衣',299,100,2,19,'images/product/clothes6.jpg'),(23,'上衣','红色上衣',199,100,2,19,'images/product/clothes7.jpg'),(24,'上衣','银色上衣',599,100,2,19,'images/product/clothes8.jpg'),(25,'上衣','蓝色上衣',399,100,2,19,'images/product/clothes9.jpg'),(26,'上衣','浅蓝色上衣',499,100,2,19,'images/product/clothes10.jpg'),(27,'上衣','白色上衣',68,100,2,19,'images/product/clothes4.jpg'),(28,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes1.jpg'),(29,'皮鞋','灰色皮鞋',299,100,21,14,'images/product/shoes2.jpg'),(30,'皮鞋','蓝色皮鞋',299,100,21,14,'images/product/shoes3.jpg'),(31,'皮鞋','灰色皮鞋',299,100,21,14,'images/product/shoes4.jpg'),(32,'皮鞋','棕色皮鞋',299,100,21,14,'images/product/shoes5.jpg'),(33,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes6.jpg'),(34,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes7.jpg'),(35,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes8.jpg'),(36,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes9.jpg'),(37,'皮鞋','黑色皮鞋',299,100,21,14,'images/product/shoes10.jpg'),(38,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass1.jpg'),(39,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass2.jpg'),(40,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass3.jpg'),(41,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass4.jpg'),(42,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass5.jpg'),(43,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass6.jpg'),(44,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass7.jpg'),(45,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass8.jpg'),(46,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass9.jpg'),(47,'眼镜','太阳镜',299,100,2,12,'images/product/sunglass10.jpg'),(48,'电视','彩电',1299,100,2,15,'images/product/television1.jpg'),(49,'电视','彩电',1299,100,2,15,'images/product/television2.jpg'),(50,'电视','彩电',2299,100,2,15,'images/products/television3.jpg'),(51,'电视','彩电',2299,100,2,15,'images/product/television4.jpg'),(52,'电视','彩电',3299,100,2,15,'images/product/television5.jpg'),(53,'电视','彩电',2299,100,2,15,'images/product/television6.jpg'),(54,'电视','彩电',4299,100,2,15,'images/product/television7.jpg'),(55,'电视','彩电',5299,100,2,15,'images/product/television8.jpg'),(56,'电视','彩电',2299,100,2,15,'images/product/television9.jpg'),(57,'电视','彩电',6299,100,2,15,'images/product/television10.jpg'),(58,'卡地亚','见证你的爱情',22122,100,2,13,'images/product/20.jpg'),(59,'卡地亚','见证你的爱情',22122,100,22,22,'images/product/20.jpg'),(60,'双色球','来吧',2,1000,2,20,'images/product/21.jpg'),(61,'变形金刚','大黄蜂',222,1000,21,17,'images/product/23.jpg'),(62,'GPS','导航仪',2222,1000,21,18,'images/product/24.jpg'),(63,'123',NULL,100,111,2,9,'imagesproduct133214492473826.jpg');

/*Table structure for table `hwua_product_category` */

DROP TABLE IF EXISTS `hwua_product_category`;

CREATE TABLE `hwua_product_category` (
  `HPC_ID` int(10) NOT NULL,
  `HPC_NAME` varchar(50) NOT NULL,
  `HPC_PARENT_ID` int(10) NOT NULL,
  PRIMARY KEY (`HPC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hwua_product_category` */

insert  into `hwua_product_category`(`HPC_ID`,`HPC_NAME`,`HPC_PARENT_ID`) values (1,'图音',1),(2,'百货',2),(4,'音乐',1),(5,'运动健康',0),(7,'家居',2),(8,'美妆',22),(9,'母婴',2),(10,'食品',2),(11,'手机数码',2),(12,'家居首饰',2),(13,'手表饰品',2),(14,'鞋包',21),(15,'家电',2),(16,'电脑办公',2),(17,'玩具文具',21),(18,'汽车用品',21),(19,'服饰',2),(20,'彩票充值',2),(21,'品牌',21),(22,'团购',22),(23,'易买社区',23),(28,'qq',1);

/*Table structure for table `hwua_user` */

DROP TABLE IF EXISTS `hwua_user`;

CREATE TABLE `hwua_user` (
  `HU_USER_ID` bigint(10) NOT NULL AUTO_INCREMENT,
  `HU_USER_NAME` varchar(20) NOT NULL,
  `HU_PASSWORD` varchar(20) NOT NULL,
  `HU_SEX` char(2) NOT NULL,
  `HU_BIRTHDAY` date DEFAULT NULL,
  `HU_IDENTITY_CODE` varchar(60) DEFAULT NULL,
  `HU_EMAIL` varchar(80) DEFAULT NULL,
  `HU_MOBILE` varchar(11) DEFAULT NULL,
  `HU_ADDRESS` varchar(200) NOT NULL,
  `HU_STATUS` int(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`HU_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `hwua_user` */

insert  into `hwua_user`(`HU_USER_ID`,`HU_USER_NAME`,`HU_PASSWORD`,`HU_SEX`,`HU_BIRTHDAY`,`HU_IDENTITY_CODE`,`HU_EMAIL`,`HU_MOBILE`,`HU_ADDRESS`,`HU_STATUS`) values (1,'朱琦','1234','0','1999-09-10','500235198907026299','sa@sina.com','13011092066','重庆',1),(2,'朱琅','1234','1','2007-12-12','500235198907026299','sa@sina.com','13011092066','重庆',1),(3,'刁星辰','1234','1','1997-12-12','123123123123123','web@sohu.com','12312312312','东北',1),(4,'刘博','1234','0','2009-09-09','500235198907026299','sa@sina.com','13011092066','北京',1),(5,'admin','1234','0','1998-12-12','12345678912345612X','sa@sina.com','13011092066','上海',1),(8,'xiaoye','xiaoye','0','1999-10-10','422201198302167919','hong@qq.com','12345678909','æ¹åæ­¦æ±',1),(9,'xiaocai','xiaoye','0','1999-10-10','422201198302167919','yang@qq.com','12345678909','æ¹åä¸iæ­¦æ±',1),(10,'xiaoye01','xiaoye','0','1999-09-09','422201198302167919','yang@qq.com','12345678901','湖北武汉',1),(11,'xiaoye2','xiaoye','0','1999-10-10','422201198302167919','hong@qq.com','12345678901','æ¹åæ­¦æ±',1),(12,'xiaoye3','xiaoye','0','1999-10-10','433301198708087919','xiao@qq.com','12345678901','湖北孝感',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
