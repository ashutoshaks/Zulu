USE zulu;

INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (1, 'Tata', 'manku ka ghar', 2);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (2, '3M', 'manku ka school', 1);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (3, 'MRF', 'manku ka masjid', 1);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (4, 'Ceat', 'manku ka mandir', 2);


INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (1, 'tyre', 25.50, 5, 0, 0, 1, 'cycle', '2021-04-01');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (2, 'bumper', 20.00, 6, 0, 0, 4, 'asf', '2021-04-01');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (3, 'brakes', 21.01, 6, 0, 0, 3, 'sd', '2021-04-01');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (4, 'bumper', 69.69, 7, 0, 0, 4, 'sdvsd', '2021-04-01');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (5, 'brakes', 420.42, 8, 0, 0, 2, 'afds', '2021-04-01');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (6, 'tyre', 662.22, 7, 0, 0, 1, 'bike', '2021-04-01');