USE zulu;

INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (1, 'Tata', 'manku ka ghar', 2);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (2, '3M', 'manku ka school', 1);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (3, 'MRF', 'manku ka masjid', 1);
INSERT INTO `manufacturers` (`manufacturer_uid`, `name`, `address`, `item_count`) VALUES (4, 'Ceat', 'manku ka mandir', 2);


INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (1, 'tyre', 25.50, 5, 6, 4, 1, 'fdsf', '2021-10-03');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (2, 'bumper', 20.00, 63, 4, 555, 4, 'asf', '2021-10-03');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (3, 'brakes', 21.01, 68, 45, 538, 3, 'sd', '2021-10-03');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (4, 'bumper', 69.69, 7, 38, 88, 4, 'sdvsd', '2021-10-03');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (5, 'brakes', 420.42, 8, 88, 38, 2, 'afds', '2021-10-03');
INSERT INTO `items` (`item_uid`, `type`, `price`, `quantity`, `day_sale`, `total_sale`, `manufacturer_uid`, `vehicle_type`, `start_date`) VALUES (6, 'tyre', 621662.22, 7, 886, 86, 1, 'assa', '2021-10-03');