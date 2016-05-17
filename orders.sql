-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2016 a las 22:30:28
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `orders`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `ordenNo` int(10) NOT NULL AUTO_INCREMENT,
  `mesaNo` int(10) NOT NULL,
  `creado` date NOT NULL,
  `isActivo` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `plat1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `plat1price` float NOT NULL,
  `plat2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `plat2price` float NOT NULL,
  `plat3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `plat3price` float NOT NULL,
  `bebida` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `bebidaprice` float NOT NULL,
  PRIMARY KEY (`ordenNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`ordenNo`, `mesaNo`, `creado`, `isActivo`, `plat1`, `plat1price`, `plat2`, `plat2price`, `plat3`, `plat3price`, `bebida`, `bebidaprice`) VALUES
(1, 1, '0000-00-00', 'Y', 'Crepas con Fresa', 22, 'Pan', 3.2, '', 0, 'Tasa de Cafe', 16);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
