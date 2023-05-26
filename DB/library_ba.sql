-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2023 at 07:15 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

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
(1001, 'TEST ', 'TEST', 1, 10),
(1002, 'TEST ', 'TEST ', 2, 10),
(1003, 'HOME', 'HORROR', 1, 10),
(1004, 'MUTANT', 'ACTION', 1, 10),
(1005, 'HOME', 'HORROR', 2, 10),
(1006, 'THE BOOK WISE ', 'PHYCOLOGICAL ', 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `issued_bookdet`
--

CREATE TABLE `issued_bookdet` (
  `ISSUED_ID` int(255) NOT NULL,
  `ID` int(255) NOT NULL,
  `ISBN` int(255) NOT NULL,
  `ISSUED` date NOT NULL,
  `DUE` date NOT NULL,
  `STATUS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issued_bookdet`
--

INSERT INTO `issued_bookdet` (`ISSUED_ID`, `ID`, `ISBN`, `ISSUED`, `DUE`, `STATUS`) VALUES
(1, 23, 1005, '2023-05-05', '2023-05-19', 'RETURNED'),
(2, 32, 1006, '2023-05-01', '2023-05-08', 'PENDING'),
(3, 22, 1002, '2023-05-18', '2023-05-20', 'PENDING'),
(4, 22, 1001, '2023-05-25', '2023-05-30', 'PENDING'),
(5, 23, 1001, '2023-05-25', '2023-05-30', 'PENDING'),
(6, 23, 1002, '2023-05-25', '2023-05-30', 'PENDING'),
(7, 22, 1003, '2023-05-25', '2023-05-31', 'PENDING'),
(8, 24, 1004, '2023-05-25', '2023-05-26', 'RETURNED'),
(9, 23, 1004, '2023-05-25', '2023-05-19', 'PENDING'),
(10, 25, 1004, '2023-05-25', '2023-05-26', 'PENDING'),
(11, 31, 1002, '2023-05-25', '2023-05-27', 'PENDING'),
(12, 24, 1004, '2023-05-25', '2023-05-31', 'PENDING'),
(13, 24, 1006, '2023-05-25', '2023-05-31', 'PENDING'),
(14, 26, 1005, '2023-05-25', '2023-05-29', 'PENDING');

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
  `CONTACT` varchar(50) NOT NULL,
  `IMAGE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`ID`, `NAME`, `LASTNAME`, `COURSE`, `YEAR`, `CONTACT`, `IMAGE`) VALUES
(22, 'TEST USER ', '1 ', 'TEST ', '1ST', '151358', 'src/images/2.jpg'),
(23, 'USER2 ', 'TEST ', 'TEST ', '2ND', '23123', ''),
(24, 'she', 'win', 'it', '2ND', '216546', ''),
(25, 'USER ', '3', 'BA', '2ND', '149649', ''),
(26, 'KIA', 'SAYABOC', 'bsba', '4TH', '200000', ''),
(31, 'JUNMARK ', 'OMAMBACK ', 'BSIT', '2ND', '095666', ''),
(32, 'KYLE ', 'ISIDORO ', 'BSHM', '2ND', '4819684', ''),
(33, 'A ', 'S ', 'D ', '2ND', '1', 'src/images/2.jpg'),
(34, 'TEST', 'TEST', 'TEST', '1ST', '3', 'src/images/1.jpg'),
(35, 'GANA', 'NA', 'PLEASE', '1ST', '2222', ''),
(36, 'COMBO', 'BOX', 'SAMPLE', '3RD', '2113141', 'src/images/3.jpg'),
(37, 'SHERWIN', 'TORREJAS', 'BSIT', '2ND', '099956565', 'src/images/847px-Love_Heart_SVG.svg.png');

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
(5, 'sherwin', 'sherwin@gmail.com', 0, 'ADMIN'),
(6, 'ADMIN', 'TEST@TEST.TEST', 694848, '$2a$10$DUsLHWaxae3bU4ihdYIQUOZtVZhu1W8tMQVTVc3TAOWrJytsRu8y2'),
(7, 'A', 'A@A.COM', 11111, '$2a$10$jVwH9ByZO1Kua7d/KazoAuTttFNdQVyYtJR5z1pDrF9imbA0QoFj2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
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
-- AUTO_INCREMENT for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  MODIFY `ISSUED_ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued_bookdet`
--
ALTER TABLE `issued_bookdet`
  ADD CONSTRAINT `issued_bookdet_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_details` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `issued_bookdet_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `book_details` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
