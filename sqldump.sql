DROP DATABASE IF EXISTS `usermanagement`;
CREATE DATABASE `usermanagement`;
USE `usermanagement`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `user` AUTO_INCREMENT = 1;

INSERT INTO `user` (name, email) VALUES
("Sergiu", "sergiu@mail.com"),
("Blaj", "blaj@mail.com"),
("Emanuel", "emanuel@mail.com");


# CREATE TABLE `animal` (
#   `id` int NOT NULL AUTO_INCREMENT,
#   `name` varchar(45) DEFAULT NULL,
#   `age` int DEFAULT NULL,
#   `dtype` varchar(31) NOT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# ALTER TABLE `animal` AUTO_INCREMENT = 1;
#
# CREATE TABLE `user` (
#   `id` int NOT NULL AUTO_INCREMENT,
#   `name` varchar(45) DEFAULT NULL,
#   `email` varchar(45) DEFAULT NULL,
#   `animal_id` int DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `animal_idx` (`animal_id`),
#   CONSTRAINT `animal` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# ALTER TABLE `user` AUTO_INCREMENT = 1;
#
# CREATE TABLE `mark` (
#   `id` int NOT NULL AUTO_INCREMENT,
#   `grade` int DEFAULT NULL,
#   `klass` varchar(45) DEFAULT NULL,
#   `user_id` int DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `user_idx` (`user_id`),
#   CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# ALTER TABLE `mark` AUTO_INCREMENT = 1;
#
# CREATE TABLE `review` (
#   `id` int NOT NULL AUTO_INCREMENT,
#   `comment` varchar(45) DEFAULT NULL,
#   `mark_id` int DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `mark_idx` (`mark_id`),
#   CONSTRAINT `mark` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# ALTER TABLE `review` AUTO_INCREMENT = 1;