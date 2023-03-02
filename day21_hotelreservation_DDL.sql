/*
create database if not exists hotelreservation;

use hotelreservation;

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE room (
    id INT NOT NULL AUTO_INCREMENT,
    room_type ENUM('standard', 'deluxe', 'president', 'suite') NOT NULL,
    price INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reservation (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    room_id INT NOT NULL,
    start_date DATE,
    end_date DATE,
    total_cost DECIMAL(8 , 2 ) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id),
    FOREIGN KEY (room_id)
        REFERENCES room (id)
);

CREATE TABLE dependant (
    id INT NOT NULL AUTO_INCREMENT,
    employee_id INT NOT NULL,
    dependant_name VARCHAR(100) NOT NULL,
    relationship VARCHAR(100) NOT NULL,
    birth_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (employee_id)
        REFERENCES employee (id)
)
*/