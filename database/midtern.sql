-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 09, 2023 lúc 10:03 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `midtern`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `b_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`b_id`, `name`) VALUES
(1, 'Khác'),
(2, 'Samsung'),
(3, 'Apple'),
(4, 'Xiaomi'),
(5, 'Google');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand_seq`
--

CREATE TABLE `brand_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `brand_seq`
--

INSERT INTO `brand_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card`
--

CREATE TABLE `card` (
  `card_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `quality` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `card`
--

INSERT INTO `card` (`card_id`, `p_id`, `c_id`, `quality`) VALUES
(502, 52, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card_seq`
--

CREATE TABLE `card_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `card_seq`
--

INSERT INTO `card_seq` (`next_val`) VALUES
(601);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`cate_id`, `name`) VALUES
(1, 'Khác'),
(6, 'Điện thoại'),
(7, 'Máy tính bảng'),
(8, 'Laptop');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`c_id`, `username`, `password`, `email`, `name`, `phone`, `address`, `role`) VALUES
(1, 'admin', 'admin', 'admin@gmail.com', 'Trần Vũ Luân', '0123456789', 'myadrress', 'admin'),
(2, 'vuluan', '123456', 'vuluan@gmail.com', 'Luân test', '1234560789', 'my test address', 'member'),
(3, 'test', 'test', 'test@gmail.com', 'test', '1234567890', 'test', 'member');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer_seq`
--

CREATE TABLE `customer_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer_seq`
--

INSERT INTO `customer_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `o_id` int(11) NOT NULL,
  `shipping_fee` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `delivery_date` datetime NOT NULL,
  `status` varchar(255) NOT NULL,
  `c_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`o_id`, `shipping_fee`, `total_price`, `delivery_date`, `status`, `c_id`) VALUES
(353, 20, 82500, '2023-04-10 00:40:14', 'shipping', 2),
(402, 20, 14500, '2023-04-10 02:02:04', 'shipping', 2),
(452, 20, 63000, '2023-04-10 02:12:43', 'shipping', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail_seq`
--

CREATE TABLE `order_detail_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_detail_seq`
--

INSERT INTO `order_detail_seq` (`next_val`) VALUES
(551);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_unit`
--

CREATE TABLE `order_unit` (
  `ou_id` int(11) NOT NULL,
  `quatity` int(11) NOT NULL,
  `o_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `unit_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_unit`
--

INSERT INTO `order_unit` (`ou_id`, `quatity`, `o_id`, `p_id`, `unit_price`) VALUES
(405, 1, 353, 7, 25000),
(406, 1, 353, 6, 35000),
(407, 1, 353, 5, 22500),
(452, 1, 402, 2, 5500),
(453, 1, 402, 3, 3500),
(454, 1, 402, 2, 5500),
(502, 1, 452, 6, 35000),
(503, 1, 452, 5, 22500),
(504, 1, 452, 2, 5500);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_unit_seq`
--

CREATE TABLE `order_unit_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_unit_seq`
--

INSERT INTO `order_unit_seq` (`next_val`) VALUES
(601);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `p_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `brand_id` int(11) NOT NULL DEFAULT 1,
  `cate_id` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`p_id`, `name`, `price`, `description`, `image`, `brand_id`, `cate_id`) VALUES
(1, 'Samsung galaxy A73', 9500, 'This is samsung galaxy A73', 'ss-a73.jpg', 2, 6),
(2, 'Samsung galaxy A53', 5500, 'This is samsung phone', 'ss-53.jpg', 2, 6),
(3, 'Samsung galaxy A33', 3500, 'This is Samsung galaxy A33', 'ss-a33.jpg', 2, 6),
(4, 'Samsung galaxy S22', 19500, 'This is Samsung galaxy S22', 'ss-s22.jpg', 2, 6),
(5, 'Samsung galaxy S23', 22500, 'This is Samsung galaxy S23', 'ss-23.jpeg', 2, 6),
(6, 'Iphone 14 Pro Max', 35000, 'this is Iphone 14 Pro Max', 'ip-14-pro.jpg', 3, 6),
(7, 'Iphone 14', 25000, 'this is Iphone 14', 'ip-14.jpg', 3, 6),
(52, 'Laptop Asus TUF Gaming F15 FX506LHB', 17500, 'Nếu bạn đang tìm kiếm một chiếc laptop gaming nhưng vẫn sở hữu một mức giá phải chăng thì laptop Asus TUF Gaming F15 FX506LHB i5 (HN188W) sẽ là sự lựa chọn đáng cân nhắc với card đồ họa rời NVIDIA GeForce GTX mạnh mẽ cùng phong cách thiết kế cứng cáp, độc đáo. ', 'bd309eb26c9d474fb58077627480ad94.jpg', 1, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(151);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`b_id`);

--
-- Chỉ mục cho bảng `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`card_id`),
  ADD KEY `p_id` (`p_id`),
  ADD KEY `c_id` (`c_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`o_id`),
  ADD KEY `c_id` (`c_id`);

--
-- Chỉ mục cho bảng `order_unit`
--
ALTER TABLE `order_unit`
  ADD PRIMARY KEY (`ou_id`),
  ADD KEY `p_id` (`p_id`),
  ADD KEY `o_id` (`o_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `cate_id` (`cate_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `card`
--
ALTER TABLE `card`
  MODIFY `card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=503;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `cate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `o_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=453;

--
-- AUTO_INCREMENT cho bảng `order_unit`
--
ALTER TABLE `order_unit`
  MODIFY `ou_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=505;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `card_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  ADD CONSTRAINT `card_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `customer` (`c_id`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`c_id`);

--
-- Các ràng buộc cho bảng `order_unit`
--
ALTER TABLE `order_unit`
  ADD CONSTRAINT `order_unit_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  ADD CONSTRAINT `order_unit_ibfk_2` FOREIGN KEY (`o_id`) REFERENCES `order_detail` (`o_id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`b_id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
