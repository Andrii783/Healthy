CREATE TABLE Address (
    address_id Integer PRIMARY KEY AUTO_INCREMENT,
    appartment int(11) NOT NULL,
    build int(11) NOT NULL,
    private_sector bit(1) NOT NULL,
    street varchar(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    FOREIGN KEY (city) REFERENCES city (id)
)
