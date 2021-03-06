CREATE DATABASE zulu;
USE zulu;

CREATE TABLE `owner` (
    `uid` INT NOT NULL,
    `name` VARCHAR(200) DEFAULT NULL,
    `username` VARCHAR(200) DEFAULT NULL,
    `password` VARCHAR(200) DEFAULT NULL,
    `initial_date` DATE DEFAULT NULL,
    `curr_date` DATE DEFAULT NULL,
    PRIMARY KEY (`uid`)
);

CREATE TABLE `manufacturers` (
    `manufacturer_uid` INT NOT NULL,
    `name` VARCHAR(200) DEFAULT NULL,
    `address` VARCHAR(400) DEFAULT NULL,
    `item_count` INT DEFAULT NULL,
    PRIMARY KEY (`manufacturer_uid`)
);

CREATE TABLE `items` (
    `item_uid` INT NOT NULL,
    `type` VARCHAR(200) DEFAULT NULL,
    `price` FLOAT(2) DEFAULT NULL,
    `quantity` INT DEFAULT NULL,
    `day_sale` INT DEFAULT NULL,
    `total_sale` INT DEFAULT NULL,
    `manufacturer_uid` INT NOT NULL,
    `vehicle_type` VARCHAR(200) DEFAULT NULL,
    `start_date` DATE DEFAULT NULL,
    PRIMARY KEY (`item_uid`)
);

CREATE TABLE `sales` (
    `day_number` INT NOT NULL AUTO_INCREMENT,
    `sale_date` DATE DEFAULT NULL,
    `total_amount` FLOAT(2) DEFAULT NULL,
    PRIMARY KEY(`day_number`)
);

INSERT INTO `owner` (`uid`, `name`, `username`, `password`, `initial_date`, `curr_date`) VALUES (1, 'Zulu Malik', 'VASachcha', 'OKZulu!', '2021-04-06', '2021-04-06');