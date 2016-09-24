-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2015 at 02:13 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `creationary`
--

-- --------------------------------------------------------

--
-- Table structure for table `arraylist`
--

CREATE TABLE `arraylist` (
  `userId` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `accesslvl` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `arraylist`
--

INSERT INTO `arraylist` (`userId`, `username`, `accesslvl`, `password`, `email`, `address`) VALUES
(1, ' Customer', 1, 'Customer', 'email@email.com', 'my house '),
(2, ' Customer1', 1, 'Password1', 'email@email.com', 'address, lines, lol');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `iditems` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`iditems`, `type`, `name`, `description`, `price`, `weight`, `quantity`) VALUES
(1, 'pen', 'bic', 'blue pen', 0.45, 0.2, 390),
(2, 'pen', 'blue bic', 'black pen', 0.4, 0.3, 83),
(3, 'pen', 'black bic', 'black pen', 0.4, 0.3, 88),
(4, 'folder', 'A4- folder', 'Plastic folder', 2.99, 0.3, 45),
(5, 'folder', 'paper folder', 'simple paper folder', 0.99, 0.3, 47);

-- --------------------------------------------------------

--
-- Table structure for table `orderqueue`
--

CREATE TABLE `orderqueue` (
  `name` varchar(25) NOT NULL,
  `quantity` int(11) NOT NULL,
  `customer` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderqueue`
--

INSERT INTO `orderqueue` (`name`, `quantity`, `customer`) VALUES
('bic', 10, 'Customer1'),
('blue bic', 5, 'Customer1'),
('bic', 4, 'Customer'),
('paper folder', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `idusers` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `accesslvl` int(11) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idusers`, `username`, `accesslvl`, `password`, `email`, `address`) VALUES
(1, 'Customer', 1, 'Customer', 'email@email.com', 'my house '),
(2, 'Customer1', 1, 'Password1', 'email@email.com', 'address, lines, lol'),
(3, 'Manager', 4, 'Manager', 'admin@admin.com', 'admins house'),
(4, 'Logistics', 3, 'Logistics', 'rgeg', 'rgeg'),
(5, 'Warehouse', 2, 'Warehouse', 'rgegrgdrd', 'rgeggdrr'),
(6, 'newManger', 4, 'manager', 'man@ger.com', 'hioubvser');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`iditems`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idusers`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
