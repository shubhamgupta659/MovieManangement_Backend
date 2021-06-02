use movie_management;

create table movie_details(
movie_id bigint AUTO_INCREMENT,
movie_name varchar(255),
movie_rating varchar(255),
movie_language varchar(255),
PRIMARY KEY(user_id)
);

create table register_user_details(
user_id bigint AUTO_INCREMENT,
first_name varchar(255),
last_name varchar(255),
user_name varchar(255),
user_email varchar(255),
user_password varchar(255),
role_id bigint not null,
PRIMARY KEY(user_id)
);

create table users_roles(
user_id bigint AUTO_INCREMENT,
role_id bigint not null,
PRIMARY KEY(user_id)
);

create table register_user_role(
role_id bigint AUTO_INCREMENT,
role_name varchar(255),
PRIMARY KEY(role_id)
);

create table employee_details(
employee_id bigint AUTO_INCREMENT,
full_name varchar(255),
email varchar(255),
mobile varchar(255),
city varchar(255),
gender varchar(255),
department bigint,
hire_date date,
is_permanent boolean,
PRIMARY KEY(employee_id)
);
