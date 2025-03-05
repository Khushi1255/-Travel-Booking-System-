CREATE DATABASE  IF NOT EXISTS `viajes` 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_0900_ai_ci;

USE `viajes`;

DROP TABLE IF EXISTS `hoteles`;

CREATE TABLE `hoteles` (
  `idHotel` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `categoria` int(10) UNSIGNED NOT NULL,
  `precio` double NOT NULL,
  `disponible` tinyint(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `hoteles` WRITE;

INSERT INTO `hoteles` VALUES (1,'Norte',3,120,1),(2,'Ritz',5,400,1),(3,'Estrella sur',4,190,0),(4,'Meridian',4,210,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `vuelos`;

CREATE TABLE `vuelos` (
  `idvuelo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `plazas` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idvuelo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `vuelos` WRITE;

INSERT INTO `vuelos` VALUES (1,'Iberia','10-12-2017',200,9),(2,'Air Europa','11-12-2027',170,6);

UNLOCK TABLES;

DROP TABLE IF EXISTS `reservas`;

CREATE TABLE `reservas` (
  `idreserva` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `hotel` int(10) UNSIGNED NOT NULL,
  `vuelo` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idreserva`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `reservas` WRITE;

INSERT INTO `reservas` VALUES (1,'ggggggg','7777777',2,1);

UNLOCK TABLES;
