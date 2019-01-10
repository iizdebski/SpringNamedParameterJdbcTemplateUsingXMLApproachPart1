DROP DATABASE IF EXISTS springwithjdbcdb;
CREATE DATABASE springwithjdbcdb CHARACTER SET utf8 COLLATE utf8_general_ci;

USE springwithjdbcdb;

DROP TABLE IF EXISTS employee_table;


CREATE TABLE employee_table(
                               employee_id INT AUTO_INCREMENT
                               PRIMARY KEY,
                               employee_name VARCHAR(45) NOT NULL,
                               salary DOUBLE NOT NULL,
                               email VARCHAR(45) NOT NULL,
                               gender VARCHAR(10) NOT NULL,
                               CONSTRAINT employee_id_UNIQUE
                                 UNIQUE (employee_id)

);