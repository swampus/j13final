CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(MAX),
    `email` varchar(MAX),
    `personal_code` varchar(2000),
    `address` varchar(1000),
    `favorite_book` varchar(200)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;