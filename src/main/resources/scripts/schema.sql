create database library;

use library;

CREATE TABLE ebook (
                        id INT NOT NULL,
                        title VARCHAR(225) NOT NULL,
                        author VARCHAR(225) NOT NULL,
                        genre VARCHAR(225),
                        link VARCHAR(225) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE location (
                          id INT NOT NULL,
                          shelf_name VARCHAR(225) NOT NULL,
                          placement INT,
                          position INT,
                          PRIMARY KEY (id)
);

CREATE TABLE user (
                       id INT NOT NULL,
                       username VARCHAR(225) NOT NULL,
                       password VARCHAR(225) NOT NULL,
                       authorities VARCHAR(225) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE reader (
                        id INT NOT NULL,
                        create_date DATETIME,
                        last_modified DATETIME,
                        deleted TINYINT,
                        name VARCHAR(225),
                        surname VARCHAR(225),
                        email VARCHAR(225),
                        address VARCHAR(225),
                        phone_number VARCHAR(225),
                        user_id INT,
                        PRIMARY KEY (id),
                        CONSTRAINT user_id
                            FOREIGN KEY (user_id)
                                REFERENCES user (id)
);

CREATE TABLE reservation (
                              id INT NOT NULL,
                              create_date DATETIME,
                              last_modified DATETIME,
                              deleted TINYINT,
                              reader_id INT,
                              PRIMARY KEY (id),
                              CONSTRAINT reader_id
                                  FOREIGN KEY (reader_id)
                                      REFERENCES reader (id)
);

CREATE TABLE book (
                       isbn INT NOT NULL,
                       title VARCHAR(225) NOT NULL,
                       author VARCHAR(225) NOT NULL,
                       genre VARCHAR(225) NOT NULL,
                       copies INT NOT NULL,
                       copies_available INT NOT NULL,
                       location_id INT NOT NULL,
                       PRIMARY KEY (isbn),
                       CONSTRAINT location_id
                           FOREIGN KEY (location_id)
                               REFERENCES location (id)
);

CREATE TABLE book_reservation (
                                   id INT NOT NULL,
                                   create_date DATETIME,
                                   last_modified DATETIME,
                                   return_date DATETIME,
                                   deleted TINYINT,
                                   status VARCHAR(225),
                                   book_id INT NOT NULL,
                                   reservation_id INT NOT NULL,
                                   CONSTRAINT book_id
                                       FOREIGN KEY (book_id)
                                           REFERENCES book (isbn),
                                   CONSTRAINT reservation_id
                                       FOREIGN KEY (reservation_id)
                                           REFERENCES reservation (id)
);