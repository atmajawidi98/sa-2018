-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2018 at 02:32 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datamat`
--

-- --------------------------------------------------------

--
-- Table structure for table `datam`
--

CREATE TABLE `datam` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `SKS` int(11) NOT NULL,
  `JAM_AWAL` varchar(10) NOT NULL,
  `JAM_AKHIR` varchar(10) NOT NULL,
  `DOSEN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datam`
--

INSERT INTO `datam` (`ID`, `NAMA`, `SKS`, `JAM_AWAL`, `JAM_AKHIR`, `DOSEN`) VALUES
(1, 'KALKULUS', 4, '08:00', '10:00', ''),
(2, 'ALJABAR LINEAR DAN MATRIKS', 3, '10:30', '12:30', ''),
(3, 'BAHASA INGGRIS 1', 3, '01:00', '03:00', ''),
(4, 'PENGANTAR TEKNOLOGI INFORMASI', 3, '08:00', '10:00', ''),
(5, 'KECAKAPAN INTERPERSONAL', 2, '03:00', '04:30', ''),
(6, 'ALGORITMA DAN STRUCKTUR DATA 1', 3, '10:00', '12:00', ''),
(7, 'MATEMATIKA DISKRIT', 3, '08:00', '10:00', ''),
(8, 'SISTEM INFORMASI', 3, '01:00', '03:00', ''),
(9, 'BASIS DATA', 3, '10:00', '12:00', ''),
(10, 'PRAKTIKUM BASIS DATA', 1, '03:00', '05:00', ''),
(11, 'STATISTIKA', 3, '08:00', '10:00', ''),
(12, 'PROGRAM DASAR 1', 3, '10:00', '12:00', ''),
(13, 'PRAKTIKUM PROGRAM DASAR 1', 1, '01:00', '03:00', ''),
(14, 'ORGANISASI DAN ARSITEKTUR KOMPUTER', 3, '10:00', '12:00', ''),
(15, 'LOGIKA INFORMATIKA', 3, '08:00', '10:00', ''),
(16, 'ANALISA DAN PERANCANGAN SISTEM INFORMASI', 4, '10:00', '12:00', ''),
(17, 'BASIS DATA LANJUT', 3, '01:00', '03:00', ''),
(18, 'SISTEM OPERASI', 3, '03:00', '05:00', ''),
(19, 'PRAKTIKUM SISTEM OPERASI', 1, '03:00', '05:00', ''),
(20, 'PROGRAM DASAR 2', 3, '08:00', '10:00', ''),
(21, 'PRAKTIKUM PROGRAM DASAR 2', 1, '01:00', '03:00', ''),
(22, 'ALGORITMA DAN STRUKTUR DATA 2', 3, '10:00', '12:00', ''),
(23, 'ARTIFICIAL INTELEGENCE', 3, '08:00', '10:00', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datam`
--
ALTER TABLE `datam`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datam`
--
ALTER TABLE `datam`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
