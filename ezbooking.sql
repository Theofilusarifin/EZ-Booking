-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 07:21 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ezbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) NOT NULL,
  `startHour` datetime DEFAULT NULL,
  `endHour` datetime DEFAULT NULL,
  `tablesCount` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `startHour`, `endHour`, `tablesCount`, `user_id`, `restaurant_id`) VALUES
(1, '2022-06-06 09:00:00', '2022-06-06 11:00:00', 2, 2, 2),
(2, '2022-06-06 10:00:00', '2022-06-06 11:00:00', 3, 3, 2),
(3, '2022-06-06 15:00:00', '2022-06-06 16:00:00', 1, 4, 2),
(4, '2022-06-06 18:00:00', '2022-06-06 19:00:00', 1, 2, 1),
(5, '2022-06-06 18:00:00', '2022-06-06 19:00:00', 2, 4, 1),
(6, '2022-06-07 11:00:00', '2022-06-07 12:00:00', 2, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `chats`
--

CREATE TABLE `chats` (
  `id` int(11) NOT NULL,
  `message` longtext DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `from` int(11) NOT NULL,
  `to` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chats`
--

INSERT INTO `chats` (`id`, `message`, `date`, `from`, `to`) VALUES
(1, 'selamat pagi kak, vegetarian pizza isinya apa saja ya?', '2022-06-06 07:34:23', 2, 6),
(2, 'ada red pepper, baby spinach, bawang, jamur, tomat, dan black olive', '2022-06-06 07:36:22', 6, 2),
(3, 'permisi, apa ada menu untuk anak-anak?', '2022-06-06 12:22:09', 2, 5),
(4, 'belum ada', '2022-06-06 12:34:01', 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `name`, `price`, `restaurant_id`) VALUES
(1, 'Cheeseburger', 45000, 1),
(2, 'Beef Burger', 40000, 1),
(3, 'French Fries', 20000, 1),
(4, 'Coca Cola', 10000, 1),
(5, 'Pepperoni Pizza', 90000, 2),
(6, 'Vegetarian Pizza', 85000, 2),
(7, 'Mushroom Pizza', 87000, 2),
(8, 'Margherita Pizza', 80000, 2),
(9, 'Mixed Salad', 50000, 3),
(10, 'Ribeye Steak', 120000, 3),
(11, 'Shrimp Roll', 35000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `preorders`
--

CREATE TABLE `preorders` (
  `booking_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `preorders`
--

INSERT INTO `preorders` (`booking_id`, `menu_id`, `amount`, `subtotal`) VALUES
(1, 5, 1, 90000),
(1, 6, 1, 85000),
(2, 7, 1, 87000),
(3, 8, 2, 160000),
(4, 1, 2, 90000),
(4, 2, 1, 40000),
(4, 4, 2, 20000),
(5, 1, 3, 135000),
(6, 10, 2, 240000);

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `openHour` time DEFAULT NULL,
  `closeHour` time DEFAULT NULL,
  `tablesCount` int(11) DEFAULT NULL,
  `peoplePerTable` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`, `address`, `phoneNumber`, `openHour`, `closeHour`, `tablesCount`, `peoplePerTable`, `user_id`) VALUES
(1, 'Rob\'s Burgers', '2312 Rob Street', '0932848822', '08:00:00', '20:00:00', 24, 5, 5),
(2, 'Sylvie\'s Pizza', '928 Sylvie Avenue', '027180922', '08:00:00', '16:00:00', 15, 6, 6),
(3, 'Don Eatery', '111 Don Street', '09929284', '10:00:00', '20:00:00', 30, 4, 7);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`, `name`) VALUES
(1, 'admin', 'password', 'admin', 'John'),
(2, 'customer1', 'password', 'customer', 'Betty'),
(3, 'customer2', 'password', 'customer', 'Pete'),
(4, 'customer3', 'password', 'customer', 'Frank'),
(5, 'restaurant1', 'password', 'restaurant', 'Rob'),
(6, 'restaurant2', 'password', 'restaurant', 'Sylvie'),
(7, 'restaurant3', 'password', 'restaurant', 'Don');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bookings_users1_idx` (`user_id`),
  ADD KEY `fk_bookings_restaurants1_idx` (`restaurant_id`);

--
-- Indexes for table `chats`
--
ALTER TABLE `chats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_chats_users1_idx` (`from`),
  ADD KEY `fk_chats_users2_idx` (`to`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_menus_restaurants1_idx` (`restaurant_id`);

--
-- Indexes for table `preorders`
--
ALTER TABLE `preorders`
  ADD PRIMARY KEY (`booking_id`,`menu_id`),
  ADD KEY `fk_bookings_has_menus_menus1_idx` (`menu_id`),
  ADD KEY `fk_bookings_has_menus_bookings1_idx` (`booking_id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_restaurants_users_idx` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `chats`
--
ALTER TABLE `chats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `fk_bookings_restaurants1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bookings_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chats`
--
ALTER TABLE `chats`
  ADD CONSTRAINT `fk_chats_users1` FOREIGN KEY (`from`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_chats_users2` FOREIGN KEY (`to`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `menus`
--
ALTER TABLE `menus`
  ADD CONSTRAINT `fk_menus_restaurants1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `preorders`
--
ALTER TABLE `preorders`
  ADD CONSTRAINT `fk_bookings_has_menus_bookings1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bookings_has_menus_menus1` FOREIGN KEY (`menu_id`) REFERENCES `menus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD CONSTRAINT `fk_restaurants_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
