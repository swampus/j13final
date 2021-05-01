CREATE TABLE IF NOT EXISTS `country` (
    `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(MAX),
    `capital_city` varchar(MAX),
    `population` bigint

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;