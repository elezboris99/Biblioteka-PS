/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - biblioteka
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biblioteka` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `biblioteka`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `AdministratorID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Boris','Elez','boris','boris123'),
(2,'Marko','Markovic','marko','marko123');

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `KnjigaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivKnjige` varchar(70) NOT NULL,
  `Pisac` varchar(70) NOT NULL,
  `Opis` varchar(200) NOT NULL,
  `CenaKnjige` decimal(10,2) NOT NULL,
  `Izdanje` int(7) NOT NULL,
  `ZanrID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`KnjigaID`),
  KEY `fk_zanr_id` (`ZanrID`),
  CONSTRAINT `fk_zanr_id` FOREIGN KEY (`ZanrID`) REFERENCES `zanr` (`ZanrID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `knjiga` */

insert  into `knjiga`(`KnjigaID`,`NazivKnjige`,`Pisac`,`Opis`,`CenaKnjige`,`Izdanje`,`ZanrID`) values 
(1,'Cetiri sporazuma','Don Miguel Ruis','Ovo je knjiga s kakvom se čovek zapadne civilizacije ne sreće često.',700.00,2005,1),
(2,'Budni u 5','Robin S. Sharma','Knjiga o povecanju produktivnosti, poboljsavanju zdravstevnog stanja i cuvanja smirenosti.',900.00,2010,2),
(3,'Bogati otac, siromasni otac','Robert Kiosaki i Seron Lehter','Knjiga o tome kako postati bogati preduzetnik.',1000.00,2013,3),
(4,'Kaludjer koji je prodao svog ferarija','Robin Sharma','Uh, mnogo dobra.',1200.00,2018,3),
(5,'Grimove bajke','Braća Grim','Zbirka poznatih priča za djecu',800.00,2002,4),
(6,'Anatomija čoveka: deskriptivna i funkcionalna','Marjan S Bošković','Knjiga koja će studentima medicine pomoći da razumiju anatomiju čoveka',1600.00,2005,5);

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `KupacID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ImeKupca` varchar(20) NOT NULL,
  `PrezimeKupca` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `TipKupca` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`KupacID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kupac` */

insert  into `kupac`(`KupacID`,`ImeKupca`,`PrezimeKupca`,`Email`,`TipKupca`) values 
(1,'Marko','Markovic','mare@gmail.com','PREMIUM'),
(2,'Petar','Petrovic','petar@gmail.com','ULTRA'),
(3,'Ana','Anic','ana@gmail.com','FREE');

/*Table structure for table `porudzbina` */

DROP TABLE IF EXISTS `porudzbina`;

CREATE TABLE `porudzbina` (
  `PorudzbinaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `DatumVreme` datetime NOT NULL,
  `DatumIsporuke` date NOT NULL,
  `Grad` varchar(30) NOT NULL,
  `Adresa` varchar(70) NOT NULL,
  `Cena` decimal(10,2) NOT NULL,
  `Popust` decimal(10,2) NOT NULL,
  `KonacnaCena` decimal(10,2) NOT NULL,
  `KupacID` bigint(10) unsigned NOT NULL,
  `AdministratorID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`PorudzbinaID`),
  KEY `fk_kupac_id` (`KupacID`),
  KEY `fk_administrator_id` (`AdministratorID`),
  CONSTRAINT `fk_administrator_id` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`),
  CONSTRAINT `fk_kupac_id` FOREIGN KEY (`KupacID`) REFERENCES `kupac` (`KupacID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `porudzbina` */

insert  into `porudzbina`(`PorudzbinaID`,`DatumVreme`,`DatumIsporuke`,`Grad`,`Adresa`,`Cena`,`Popust`,`KonacnaCena`,`KupacID`,`AdministratorID`) values 
(4,'2023-09-13 15:49:41','2023-10-18','Beograd','Sejkina 50d',900.00,10.00,810.00,1,1),
(5,'2023-09-13 15:53:11','2023-10-18','Beograd','Humska 1',2200.00,10.00,1980.00,1,1);

/*Table structure for table `stavkaporudzbine` */

DROP TABLE IF EXISTS `stavkaporudzbine`;

CREATE TABLE `stavkaporudzbine` (
  `PorudzbinaID` bigint(10) unsigned NOT NULL,
  `RbStavke` int(7) NOT NULL,
  `Kolicina` int(7) NOT NULL,
  `CenaStavke` decimal(10,2) NOT NULL,
  `KnjigaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`PorudzbinaID`,`RbStavke`),
  KEY `fk_knjiga_id` (`KnjigaID`),
  CONSTRAINT `fk_knjiga_id` FOREIGN KEY (`KnjigaID`) REFERENCES `knjiga` (`KnjigaID`),
  CONSTRAINT `fk_porudzbina_id` FOREIGN KEY (`PorudzbinaID`) REFERENCES `porudzbina` (`PorudzbinaID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaporudzbine` */

insert  into `stavkaporudzbine`(`PorudzbinaID`,`RbStavke`,`Kolicina`,`CenaStavke`,`KnjigaID`) values 
(4,1,1,900.00,2),
(5,1,1,1200.00,4),
(5,2,1,1000.00,3);

/*Table structure for table `zanr` */

DROP TABLE IF EXISTS `zanr`;

CREATE TABLE `zanr` (
  `ZanrID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivZanra` varchar(100) NOT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `zanr` */

insert  into `zanr`(`ZanrID`,`NazivZanra`) values 
(1,'Religija i mitologija'),
(2,'Popularna psihologija'),
(3,'Licne finansije, preduzetnistvo, biznis, investiranje, ekonomija'),
(4,'Bajke'),
(5,'Strucna literatura');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
