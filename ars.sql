-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2022 at 02:39 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ars`
--

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `Seat_id` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Source` varchar(50) NOT NULL,
  `Destination` varchar(50) NOT NULL,
  `Cost` double NOT NULL,
  `Payment_Method` varchar(50) NOT NULL,
  `Card_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `Seat_id`, `Username`, `Source`, `Destination`, `Cost`, `Payment_Method`, `Card_id`, `User_id`) VALUES
(72, 1, 'nermeen899', 'Dubai', 'Egypt', 10000, 'Visa', 1234, 7);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Check_Seat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`id`, `Name`, `Check_Seat`) VALUES
(1, '1S1', 1),
(2, '1S2', 1),
(3, '1S3', 1),
(4, '1S4', 1),
(5, '1S5', 1),
(6, '1S6', 1),
(7, '1S7', 1),
(8, '1S8', 1),
(9, '1S9', 1),
(10, '1S10', 1),
(11, '1S11', 1),
(12, '1S12', 1),
(13, '1S13', 1),
(14, '1S14', 1),
(15, '1S15', 1),
(16, '1S16', 1),
(17, '1S17', 1),
(18, '1S18', 1),
(19, '1S19', 1),
(20, '1S20', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `Country` varchar(20) NOT NULL,
  `Mobile` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `FirstName`, `LastName`, `Username`, `Password`, `DOB`, `address`, `Country`, `Mobile`) VALUES
(1, 'rana', 'ali', 'rana674', '674', '2001/6/26', 'rana@gmail.com', 'cairo', '01115917303'),
(2, 'haidy', 'mohamed', 'haidy56', '123', '2001/5/28', 'haidy@gmail.com', 'cairo', '01112120325'),
(3, 'nour', 'waleed', 'nour917', '123', '2000/11/17', 'nour@gmail.com', 'cairo', '01123168626'),
(4, 'omnia', 'mohamed', 'omnia78', '123', '2001/6/14', 'omnia@gmail.com', 'cairo', '01024053134'),
(7, 'nermeen', 'mmdouh', 'nermeen899', '123', '2001//8/17', 'nermeen2gmail.com', 'alex', '01110993843');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Seat` (`Seat_id`),
  ADD KEY `fk_User` (`User_id`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_Seat` FOREIGN KEY (`Seat_id`) REFERENCES `seat` (`id`),
  ADD CONSTRAINT `fk_User` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
