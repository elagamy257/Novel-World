-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2024 at 05:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `novel`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `username`, `password`) VALUES
(1, 'elagamy@gmail.com', 'elagamy', '2572004'),
(2, 'elagamy@gmail.com', 'aya', '123456'),
(4, 'bia@gmail.com', 'bia', '7102003'),
(5, 'elagamy@gmail.com', 'elagamy', '123456'),
(6, 'nor@gmail.com', 'nor', '123456'),
(7, 'radwa@gmail.com', 'radwa', '123456'),
(11, 'AyaElagamy257@gmail.com', 'Aya Elagamy', '2572004');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `book_id` int(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `pub_date` date DEFAULT NULL,
  `price` double NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `book_id`, `title`, `author`, `type`, `pub_date`, `price`, `image`) VALUES
(1, 1, 'Ekadoly', 'Dr.Hanan lashin', 'Fantasy', '2017-01-23', 50, 'D:\\cours\\java\\tasks java\\NovelsWorld\\src\\novelsworld\\image book\\h1.jpg'),
(2, 2, 'Obal', 'Dr.Hanan lashin', 'Fantazy', '2018-02-25', 50, 'D:\\cours\\java\\tasks java\\NovelsWorld\\src\\novelsworld\\image book\\h2.jpg'),
(14, 3, 'Amanos', 'Dr.Hanan lashin', 'Fantasy', '2019-02-26', 50, 'D:\\cours\\java\\tasks java\\NovelsWorld\\src\\novelsworld\\image book\\h3.jpg'),
(15, 4, 'Kwekl', 'Dr.Hanan lashin', 'Fantasy', '2020-01-20', 50, 'D:\\cours\\java\\tasks java\\NovelsWorld\\src\\novelsworld\\image book\\h4.jpg'),
(16, 5, 'Soktory', 'Dr.Hanan lashin', 'Fantasy', '2021-01-19', 50, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\h5.jpg'),
(17, 6, 'Serosh', 'Dr.Hanan lashin', 'Fantasy', '2024-02-15', 50, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\h6.jpg'),
(18, 7, 'Blue collar girl', 'Amr Abedl-HAmid', 'Adventure', '2022-01-21', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3a.jpg'),
(19, 8, 'Amarita (2)', 'Amr Abdl-HAmid', 'Adventure', '2023-01-21', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3b.jpg'),
(20, 9, 'Zekola(3)', 'Amr Abdl-HAmid', 'Adventure', '2024-01-30', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3c.jpg'),
(21, 10, 'Neighbors rules', 'Amr Abdl-HAmid', 'Fantasy', '2018-01-23', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3d.jpg'),
(22, 11, 'Shamo beats', 'Amr Abdl-HAmid', 'Fantasy', '2019-01-25', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3e.jpg'),
(23, 12, 'Akma waves', 'Amr Abdl-HAmid', 'Fantasy', '2020-02-19', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3f.jpg'),
(24, 13, 'In the rat passage', 'Ahmed Kh Tawfiq', ' Science Fiction', '2016-03-22', 100, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\k2.jpg'),
(25, 14, 'Supernatural', 'Ahmed Kh Tawfiq', 'Fantasy', '2014-05-21', 500, 'D:\\\\\\\\cours\\\\\\\\java\\\\\\\\tasks java\\\\\\\\NovelsWorld\\\\\\\\src\\\\\\\\novelsworld\\\\\\\\image book\\\\\\\\k2.jpg'),
(26, 15, 'Utopia', 'Ahmed Kh Tawfiq', ' Social ', '2008-07-20', 150, 'D:\\cours\\java\\tasks java\\NovelsWorld\\src\\novelsworld\\image book\\k1.jpg'),
(27, 16, 'Crime and punishment ', ' Dostoevsky', 'Psychological and philosophical.', '1866-09-12', 60, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\d2.jpg'),
(28, 17, 'White Nights', ' Dostoevsky', 'Emotional', '1848-02-23', 60, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\d1.jpg'),
(30, 19, 'In my heart is a Hebrew female', 'Khawla Hamdi', ' drama', '2013-01-15', 70, 'C:\\\\Users\\\\SMART-it\\\\OneDrive\\\\Pictures\\\\Novels\\\\q.png'),
(33, 20, 'Zekola', 'Amr Abdel-Hamid', 'Adventure', '2022-09-21', 70, 'D:\\\\cours\\\\java\\\\tasks java\\\\NovelsWorld\\\\src\\\\novelsworld\\\\image book\\\\3z.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `book_id` int(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `quantity` int(100) NOT NULL,
  `price` double NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customer_id`, `book_id`, `title`, `author`, `type`, `quantity`, `price`, `date`) VALUES
(1, 1, 2, 'Amanos', 'D.Hanan lashin', 'imagin', 3, 150, '2024-09-22'),
(2, 1, 4, 'blue girl ', 'Dr.Hanan lasin', 'imagin', 2, 90, '2024-09-22'),
(3, 1, 4, 'blue girl ', 'Dr.Hanan lasin', 'imagin', 2, 90, '2024-09-22'),
(4, 1, 3, 'ekadoly', 'Dr.Hanan lasin', 'imagin', 5, 300, '2024-09-22'),
(5, 1, 11, 'Amareta', '3mr abd elglel', 'imagin', 1, 100, '2024-09-22'),
(6, 2, 5, 'opal', 'D.Hanan Lashin', 'imagin', 3, 240, '2024-09-22'),
(7, 3, 3, 'ekadoly', 'Dr.Hanan lasin', 'imagin', 2, 120, '2024-09-22'),
(8, 3, 4, 'blue girl ', 'Dr.Hanan lasin', 'imagin', 4, 180, '2024-09-22'),
(9, 4, 12, 'Not end', 'sandra serag', 'novel', 1, 50, '2024-09-22'),
(10, 4, 12, 'Not end', 'sandra serag', 'novel', 1, 50, '2024-09-22'),
(11, 4, 5, 'opal', 'D.Hanan Lashin', 'imagin', 3, 240, '2024-09-22'),
(12, 4, 9, 'What we didnt say', 'Sandra Serag', 'Novel', 5, 350, '2024-09-22'),
(13, 4, 1, 'kwikl', 'D.Hanan lashin', 'imagin', 3, 150, '2024-09-22'),
(14, 5, 5, 'opal', 'D.Hanan Lashin', 'imagin', 5, 400, '2024-09-22'),
(15, 6, 4, 'blue girl ', 'Dr.Hanan lasin', 'imagin', 3, 135, '2024-09-22'),
(16, 6, 3, 'ekadoly', 'Dr.Hanan lasin', 'imagin', 4, 240, '2024-09-22'),
(17, 7, 4, 'blue girl ', 'Dr.Hanan lasin', 'vantazi', 7, 315, '2024-09-23'),
(18, 8, 11, 'Amareta', '3mr abd elglel', 'imagin', 3, 300, '2024-09-23'),
(19, 8, 3, 'ekadoly', 'Dr.Hanan lasin', 'imagin', 4, 240, '2024-09-23'),
(20, 9, 1, 'kwikl', 'D.Hanan lashin', 'imagin', 0, 0, '2024-09-23'),
(21, 9, 4, 'blue girl ', 'Dr.Hanan lasin', 'vantazi', 2, 90, '2024-09-23'),
(22, 9, 2, 'Amanos', 'D.Hanan lashin', 'imagin', 2, 100, '2024-09-23'),
(23, 9, 13, 'zekola', 'Amr Abdel Hamid', 'imagin', 3, 210, '2024-09-23'),
(24, 9, 11, 'Amareta', '3mr abd Hamid', 'imagin', 3, 300, '2024-09-24'),
(25, 9, 5, 'opal', 'D.Hanan Lashin', 'imagin', 9, 720, '2024-09-24'),
(26, 10, 9, 'What we didnt say', 'Sandra Serag', 'Novel', 3, 210, '2024-09-25'),
(27, 10, 1, 'Ekadoly', 'Dr.Hanan lashin', 'Fantasy', 1, 50, '2024-09-25'),
(28, 10, 2, 'Obal', 'Dr.Hanan lashin', 'Fantazy', 2, 100, '2024-09-25'),
(29, 10, 6, 'Serosh', 'Dr.Hanan lashin', 'Fantasy', 3, 150, '2024-09-25'),
(30, 11, 7, 'Zekola', 'Amr Abdl-HAmid', 'Adventure', 2, 140, '2024-09-25'),
(31, 11, 1, 'Ekadoly', 'Dr.Hanan lashin', 'Fantasy', 2, 100, '2024-09-25'),
(32, 11, 8, 'Amarita (2)', 'Amr Abdl-HAmid', 'Adventure', 2, 140, '2024-09-25'),
(33, 11, 2, 'Obal', 'Dr.Hanan lashin', 'Fantazy', 2, 100, '2024-09-25'),
(34, 12, 3, 'Amanos', 'Dr.Hanan lashin', 'Fantasy', 2, 100, '2024-09-25'),
(35, 12, 4, 'Kwekl', 'Dr.Hanan lashin', 'Fantasy', 0, 0, '2024-09-25'),
(36, 12, 17, 'White Nights', ' Dostoevsky', 'Emotional', 1, 60, '2024-09-25'),
(37, 12, 14, 'Supernatural', 'Ahmed Kh Tawfiq', 'Fantasy', 2, 1000, '2024-09-25'),
(38, 12, 10, 'Neighbors rules', 'Amr Abdl-HAmid', 'Fantasy', 1, 70, '2024-09-25'),
(39, 12, 7, 'Zekola', 'Amr Abdl-HAmid', 'Adventure', 3, 210, '2024-09-25'),
(40, 12, 15, 'Utopia', 'Ahmed Kh Tawfiq', ' Social ', 1, 50, '2024-09-25'),
(41, 13, 3, 'Amanos', 'Dr.Hanan lashin', 'Fantasy', 0, 0, '2024-09-25'),
(42, 13, 7, 'Blue collar girl', 'Amr Abedl-HAmid', 'Adventure', 2, 140, '2024-09-25'),
(43, 13, 20, 'Zekola', 'Amr Abdel-Hamid', 'Adventure', 3, 210, '2024-09-25'),
(44, 14, 3, 'Amanos', 'Dr.Hanan lashin', 'Fantasy', 2, 100, '2024-09-25'),
(45, 14, 6, 'Serosh', 'Dr.Hanan lashin', 'Fantasy', 3, 150, '2024-09-25'),
(46, 14, 9, 'Zekola(3)', 'Amr Abdl-HAmid', 'Adventure', 2, 140, '2024-09-25'),
(47, 14, 15, 'Utopia', 'Ahmed Kh Tawfiq', ' Social ', 1, 150, '2024-09-25'),
(48, 14, 11, 'Shamo beats', 'Amr Abdl-HAmid', 'Fantasy', 2, 140, '2024-09-25'),
(49, 14, 1, 'Ekadoly', 'Dr.Hanan lashin', 'Fantasy', 2, 100, '2024-09-25');

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `total` double NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`id`, `customer_id`, `total`, `date`) VALUES
(1, 1, 730, '2024-09-22'),
(2, 2, 240, '2024-09-22'),
(3, 3, 300, '2024-09-22'),
(4, 4, 840, '2024-09-22'),
(5, 5, 400, '2024-09-22'),
(6, 6, 375, '2024-09-22'),
(7, 7, 315, '2024-09-23'),
(8, 8, 540, '2024-09-23'),
(9, 9, 1420, '2024-09-25'),
(10, 10, 510, '2024-09-25'),
(11, 11, 480, '2024-09-25'),
(12, 12, 1490, '2024-09-25'),
(13, 13, 350, '2024-09-25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
