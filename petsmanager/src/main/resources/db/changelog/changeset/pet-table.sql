CREATE TABLE pet (
                     id bigint PRIMARY KEY AUTO_INCREMENT,
                     pet_name varchar(200) NOT NULL,
                     pet_code varchar(200) NOT NULL,
                     type varchar(200) NOT NULL,
                     color varchar(200) NOT NULL,
                     country varchar(200) NOT NULL
);

INSERT INTO pet (pet_name, pet_code, type, color, country)
VALUES ('Mustikas', '202211151535', 'Cat', 'Black', 'Estonia');

INSERT INTO pet (pet_name, pet_code, type, color, country)
VALUES ('Roy', '202211151536', 'Dog', 'Brown', 'Latvia');

INSERT INTO pet (pet_name, pet_code, type, color, country)
VALUES ('Charles', '202211151536', 'Horse', 'White', 'Norway');

CREATE SEQUENCE pet_sequence
    START WITH 4
    INCREMENT BY 1;