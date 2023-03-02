# drop database moviereservation;
create database moviereservation;

use moviereservation;

CREATE TABLE online_user (
    id VARCHAR(10),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cinema (
    id VARCHAR(10),
    cinema_name VARCHAR(50) NOT NULL,
    no_of_theatre INT,
    PRIMARY KEY (id)
);

CREATE TABLE theatre (
    id VARCHAR(10),
    cinema_id VARCHAR(10),
    no_of_seats INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cinema_id)
        REFERENCES cinema (id)
);

CREATE TABLE movie (
    id VARCHAR(10),
    title VARCHAR(100) NOT NULL,
    subtitle VARCHAR(10),
    genre VARCHAR(20),
    PRIMARY KEY (id)
);

CREATE TABLE screening (
    id INT NOT NULL AUTO_INCREMENT,
    show_date DATE NOT NULL,
    show_time TIME NOT NULL,
    seats_left INT NOT NULL,
    theatre_id VARCHAR(10),
    movie_id VARCHAR(10),
    PRIMARY KEY (id),
    FOREIGN KEY (theatre_id)
        REFERENCES theatre (id),
    FOREIGN KEY (movie_id)
        REFERENCES movie (id)
);

CREATE TABLE booking (
    id VARCHAR(20),
    no_of_tickets INT NOT NULL,
    total_cost INT NOT NULL,
    online_user_id VARCHAR(10),
    screening_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (online_user_id)
        REFERENCES online_user (id),
    FOREIGN KEY (screening_id)
        REFERENCES screening (id)
);
