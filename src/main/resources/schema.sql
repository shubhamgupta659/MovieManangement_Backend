use movie_management;

CREATE TABLE `employee_details` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `department` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hire_date` datetime DEFAULT NULL,
  `is_permanent` bit(1) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `files` (
  `file_id` bigint NOT NULL AUTO_INCREMENT,
  `file_data` longblob,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `movie_details` (
  `movie_id` bigint NOT NULL AUTO_INCREMENT,
  `movie_language` varchar(255) DEFAULT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `movie_rating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `register_user_details` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `register_user_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKm7inno19bameeaf0lse8roiim` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `movie_management`.`register_user_details` (`user_id`, `first_name`, `last_name`, `user_name`, `user_email`, `user_password`) VALUES ('1', 'admin_fn', 'admin_ln', 'admin', 'admin@gmaail.com', '$2a$10$.b2gi8qOw3y.um/76aff6uP7jLrvwawwplAbqk8FSWlel2QFw.dmS');

INSERT INTO `movie_management`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `movie_management`.`register_user_role` (`role_id`, `role_name`) VALUES ('1', 'ADMIN');
INSERT INTO `movie_management`.`register_user_role` (`role_id`, `role_name`) VALUES ('2', 'USER');

