CREATE DATABASE  IF NOT EXISTS `hibernatelazy`;
USE `hibernatelazy`;

DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `Student` VALUES (1,'Sharan','Arumugam'),(2,'Omkar','Shetkar');

DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `community` varchar(255) DEFAULT NULL,
  `flat` smallint(6) DEFAULT NULL,
  `floor` smallint(6) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6wgxxgelastu3blt5vd883rdo` (`student`),
  CONSTRAINT `FK6wgxxgelastu3blt5vd883rdo` FOREIGN KEY (`student`) REFERENCES `Student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `Address` VALUES (1,'Home',2,4,'Bangalore',1),(2,'Home',1,1,'Bangalore',1),(3,'Roome',2,2,'West TN',2),(4,'Native',1,1,'North KA',2);
