-- phpMyAdmin SQL Dump
-- version 4.3.13.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 05, 2017 at 06:59 PM
-- Server version: 5.6.25
-- PHP Version: 5.3.29

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `yenterprises`
--
CREATE DATABASE IF NOT EXISTS `yenterprises` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `yenterprises`;

-- --------------------------------------------------------

--
-- Table structure for table `modification`
--

CREATE TABLE IF NOT EXISTS `modification` (
  `postId` int(11) NOT NULL,
  `modifierId` varchar(20) NOT NULL,
  `dateModified` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `postId` int(11) NOT NULL,
  `creatorId` varchar(20) NOT NULL,
  `dateCreated` date NOT NULL,
  `title` varchar(20) NOT NULL,
  `shortDesc` varchar(50) NOT NULL,
  `longDesc` varchar(2000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`postId`, `creatorId`, `dateCreated`, `title`, `shortDesc`, `longDesc`) VALUES
(1, 'fidel', '2017-06-04', 'History Will Absolve', 'Ending of a speech made by Fidel Castro on 16 Octo', 'But I do not fear prison, as I do not fear the fury of the miserable tyrant who took the lives of 70 of my comrades. Condemn me. It does not matter. History will absolve me.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `dateRegistered` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `pwd`, `firstName`, `lastName`, `dateRegistered`) VALUES
('fidel', 'castro', 'fidel', 'castro', '2017-06-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `modification`
--
ALTER TABLE `modification`
  ADD PRIMARY KEY (`postId`,`modifierId`), ADD KEY `fk_posts_has_users_users1_idx` (`modifierId`), ADD KEY `fk_posts_has_users_posts1_idx` (`postId`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`postId`), ADD UNIQUE KEY `id_UNIQUE` (`postId`), ADD KEY `fk_posts_users_idx` (`creatorId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`), ADD UNIQUE KEY `id_UNIQUE` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `postId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `modification`
--
ALTER TABLE `modification`
ADD CONSTRAINT `fk_posts_has_users_posts1` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_posts_has_users_users1` FOREIGN KEY (`modifierId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
ADD CONSTRAINT `fk_posts_users` FOREIGN KEY (`creatorId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
