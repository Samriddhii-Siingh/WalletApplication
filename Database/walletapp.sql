-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2022 at 04:25 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `walletapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE `logininfo` (
  `userID` int(4) NOT NULL,
  `Username` varchar(40) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Bank` varchar(40) NOT NULL,
  `Account_Number` varchar(10) NOT NULL,
  `Balance_Current` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`userID`, `Username`, `Password`, `Bank`, `Account_Number`, `Balance_Current`) VALUES
(1, 'Samriddhi', 'Singh18', 'Union Bank of India', 'UN90128712', 6932),
(2, 'Ojasvi', 'ojasvi101', 'IDFC Bank', 'IDF5619130', 7550),
(3, 'Bhamini', '123456', 'HDFC Bank', 'HD08101003', 19812),
(4, 'Krishna', 'krytax', 'Punjab National Bank', 'PNB5609238', 60),
(5, 'Aditi', 'ghs7', 'ICICI Bank', 'ICC9012983', 7129),
(6, 'Navya', 'nyb713', 'State Bank of India', 'SB89324309', 2367),
(7, 'Avijit', 'user1234', 'Union Bank of India', 'UN90791812', 9013),
(8, 'Sujeet', 'sk092', 'Punjab National Bank', 'PNB5641819', 6001),
(9, 'Robin', 'robs56', 'HDFC Bank', 'HD09012742', 17226),
(10, 'Allen', '09ad', 'IDFC Bank', 'IDF5678122', 6999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logininfo`
--
ALTER TABLE `logininfo`
  ADD PRIMARY KEY (`userID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logininfo`
--
ALTER TABLE `logininfo`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;
