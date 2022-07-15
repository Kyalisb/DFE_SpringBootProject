DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
    `id` BIGINT AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY(`id`)
    );