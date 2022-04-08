use movie_management;

INSERT INTO `movie_management`.`register_user_details` (`user_id`, `first_name`, `last_name`, `user_name`, `user_email`, `user_password`) VALUES ('1', 'admin_fn', 'admin_ln', 'admin', 'admin@gmaail.com', '$2a$10$.b2gi8qOw3y.um/76aff6uP7jLrvwawwplAbqk8FSWlel2QFw.dmS');

INSERT INTO `movie_management`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `movie_management`.`register_user_role` (`role_id`, `role_name`) VALUES ('1', 'ADMIN');
INSERT INTO `movie_management`.`register_user_role` (`role_id`, `role_name`) VALUES ('2', 'USER');

