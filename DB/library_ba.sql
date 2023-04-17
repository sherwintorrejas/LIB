-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2023 at 12:56 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ba`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `ISBN` int(20) NOT NULL,
  `TITTLE` varchar(150) NOT NULL,
  `GENRE` varchar(100) NOT NULL,
  `EDITION` int(50) NOT NULL,
  `QUANTITY` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`ISBN`, `TITTLE`, `GENRE`, `EDITION`, `QUANTITY`) VALUES
(1001, 'test', 'test', 1, 3),
(1002, 'test', 'test', 2, 4),
(1003, 'HOME', 'HORROR', 1, 1),
(1004, 'MUTANT', 'ACTION', 1, 3),
(1005, 'HOME', 'HORROR', 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `ISSUED_ID` int(100) NOT NULL,
  `ID` int(11) DEFAULT NULL,
  `ISBN` int(11) DEFAULT NULL,
  `TITTLE` varchar(150) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `LASTNAME` varchar(100) DEFAULT NULL,
  `ISSUED` date DEFAULT NULL,
  `DUE` date DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`ISSUED_ID`, `ID`, `ISBN`, `TITTLE`, `NAME`, `LASTNAME`, `ISSUED`, `DUE`, `STATUS`) VALUES
(1, 22, 1002, 'test', 'test user', '1', '2023-04-07', '2023-04-14', 'RETURNED'),
(2, 24, 1003, 'HOME', 'she', 'win', '2023-04-06', '2023-04-09', 'PENDING'),
(3, 23, 1001, 'test', 'user2', 'test', '2023-04-10', '2023-04-13', 'PENDING'),
(4, 22, 1003, 'HOME', 'test user', '1', '2023-04-02', '2023-04-05', 'PENDING'),
(5, 22, 1001, 'test', 'test user', '1', '2023-04-04', '2023-04-06', 'RETURNED'),
(6, 26, 1005, 'HOME', 'KIA', 'SAYABOC', '2023-04-11', '2023-04-18', 'PENDING');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `ID` int(10) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `LASTNAME` varchar(100) NOT NULL,
  `COURSE` varchar(100) NOT NULL,
  `YEAR` varchar(20) NOT NULL,
  `CONTACT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`ID`, `NAME`, `LASTNAME`, `COURSE`, `YEAR`, `CONTACT`) VALUES
(22, 'test user', '1', 'test', '1', 'test'),
(23, 'user2', 'test', 'test', 'test2', '23123'),
(24, 'she', 'win', 'it', '2', '216546'),
(25, 'USER ', '3', 'BA', '2', '149649'),
(26, 'KIA', 'SAYABOC', 'bsba', '4', '200000');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` int(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `contact`, `password`) VALUES
(5, 'sherwin', 'sherwin@gmail.com', 0, 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`ISSUED_ID`),
  ADD KEY `ID` (`ID`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `ISSUED_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
