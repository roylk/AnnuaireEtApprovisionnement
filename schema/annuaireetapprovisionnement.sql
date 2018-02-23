/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.7.19-log : Database - annuaireetapprovisionnement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`annuaireetapprovisionnement` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `annuaireetapprovisionnement`;

/*Table structure for table `agence` */

DROP TABLE IF EXISTS `agence`;

CREATE TABLE `agence` (
  `typeAgence` varchar(30) DEFAULT NULL,
  `responsableAgence` varchar(30) DEFAULT NULL,
  `horaires` varchar(30) DEFAULT NULL,
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `agence` */

insert  into `agence`(`typeAgence`,`responsableAgence`,`horaires`,`id`) values ('guichet','Mr daniel','tous les jours 24/24',1),('finance','jean jules','sauf le samedi',14),('point de collecte','clotilde TIANI','08h-18h30 de lundi à samedi',28),('type','Daniel','07h00-15h00',31);

/*Table structure for table `local` */

DROP TABLE IF EXISTS `local`;

CREATE TABLE `local` (
  `typeLocal` varchar(30) DEFAULT NULL,
  `responsableLocal` varchar(50) DEFAULT NULL,
  `superficieLocal` bigint(10) DEFAULT NULL,
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `local` */

insert  into `local`(`typeLocal`,`responsableLocal`,`superficieLocal`,`id`) values ('entrepos','Mr jean de Dieu',520,1),('entrepos','guy marchant',553,11),('appartements meublés','Armand KAMGA',620,15);

/*Table structure for table `site` */

DROP TABLE IF EXISTS `site`;

CREATE TABLE `site` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `adresse` text,
  `activite1` varchar(50) DEFAULT NULL,
  `id_agence` bigint(10) DEFAULT NULL,
  `id_local` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_local` (`id_local`),
  KEY `fk_id_agence` (`id_agence`),
  CONSTRAINT `fk_id_agence` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`),
  CONSTRAINT `fk_id_local` FOREIGN KEY (`id_local`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;

/*Data for the table `site` */

insert  into `site`(`id`,`nom`,`ville`,`adresse`,`activite1`,`id_agence`,`id_local`) values (1,'dalip','DOUALA','bp 1258 tel 699999999 akwa rue 15','finance',14,NULL),(2,'ETOA MEKI','YAOUNDE','djoungolo bp 0154 tel 656252545','point relais',NULL,1),(4,'SOMATEL','YAOUNDE','Montée aurore',NULL,NULL,NULL),(5,'local1','douala','akwa rue fosh','point relais',NULL,11),(7,'nom','ville','adresse','activite',NULL,NULL),(12,'BONADIBONG','DOUALA','BP 1545 DOUALA','GUICHET',1,NULL),(13,'IMMEUBLE ROSE','BAFOUSSAM','MARCHE B, face total bp 1542,tel 692482165','non définie',NULL,15),(15,'BONAKOUAMOUANG','DOUALA','Mobile bonakouamouang, en face direction générale S2i, BP:1589','gestion immobilière',NULL,NULL),(22,'BAFANG II','BAFANG','Quartier lieussieu, immeuble AES, BP:8514 tel 695548521','transfert de colis',28,NULL),(29,' le nouveau site',' ngaoundere','rue de l\'université','point de chute colis',NULL,NULL),(52,'ETOUGUEBE','YAOUNDE','MONTEE ANNE ROUGE','PARKING',NULL,NULL),(164,'agence2','douala','blalblal','activité ',31,NULL),(165,'NDOBIAN','NKONDJOCK','BP 1525','GUICHET',NULL,NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`login`,`password`) values (1,'objiscam','ObJiS'),(2,'ckroyl','RoyL');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
