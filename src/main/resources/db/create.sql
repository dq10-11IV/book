/* 创建user 表*/
CREATE TABLE `bd_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID主键',
  `USER_EMAIL` varchar(100) NOT NULL COMMENT '用户邮件',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `USER_LEVEL` int(11) DEFAULT NULL COMMENT '用户等级',
  `USER_PASSWORD` char(20) NOT NULL COMMENT '用户密码',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;
commit;
/* 创建book表*/
CREATE TABLE `bd_book` (
  `BOOK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '书的ID,自增长主键',
  `ISBN` varchar(100) DEFAULT NULL COMMENT 'Isbn 13 ',
  `BOOK_NAME` varchar(100) NOT NULL COMMENT '书名',
  `AUTHOR` varchar(100) DEFAULT NULL COMMENT '该书的作者',
  `BOOK_PRICE` decimal(11,0) DEFAULT NULL COMMENT '该书的价格',
  `BOOK_PRESS` varchar(100) DEFAULT NULL COMMENT '该书的出版社',
  `PUBLISH_DATE` datetime DEFAULT NULL COMMENT '该书的出版时间',
  `BOOK_VERSION` int(11) DEFAULT NULL COMMENT '该书的版本',
  `CREAT_DATE` datetime DEFAULT NULL COMMENT '创建的时间',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '最后更新的时间',
  `BOOK_SUMMARY` varchar(3000) DEFAULT NULL COMMENT '简介',
  `BOOK_IMAGE_URL` varchar(256) DEFAULT NULL COMMENT '图书图片的url',
  PRIMARY KEY (`BOOK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
COMMIT;
/* user_book 表的创建*/
CREATE TABLE `bd_user_book_ass` (
  `USER_BOOK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'USER_BOOK 的主键',
  `BOOK_ID` int(11) NOT NULL COMMENT 'BOOK 的Id',
  `USER_ID` int(11) NOT NULL COMMENT 'book 拥有者的ID',
  `IS_ONHAND` tinyint(1) DEFAULT NULL COMMENT '该书是否在拥有者的手上',
  `IS_ANY_PERSON_WANTED` tinyint(1) DEFAULT NULL COMMENT '现在是否有人想要借',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '该记录的创建时间',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '该记录的最新更新时间',
  PRIMARY KEY (`USER_BOOK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
commit;
/*创建label 表*/
CREATE TABLE `bd_label` (
  `LABEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签的主键ID',
  `LABEL_NAME` varchar(100) DEFAULT NULL COMMENT '标签的名字',
  `CREATOR_ID` int(11) DEFAULT NULL COMMENT '标签创建者ID',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '该标签的创建时间',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '标签最后更新的时间',
  PRIMARY KEY (`LABEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
commit;
/*创建user_label 关联表*/
CREATE TABLE `bd_user_label` (
  `USER_LABEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'USER_LABLE 主键',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `LABEL_ID` int(11) NOT NULL COMMENT '相关的label ID',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`USER_LABEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
