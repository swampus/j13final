CREATE TABLE IF NOT EXISTS `loyalty_card` (
    `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `num` varchar(30),
    `type` varchar(10),
    `user_id` bigint

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;