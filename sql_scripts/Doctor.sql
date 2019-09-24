CREATE TABLE Doctor (
    doctor_id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    category varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    gender varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    patronymic varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    profile varchar(255) NOT NULL,
    date_of_birth varchar(255) DEFAULT NULL)
    FOREIGN KEY (profile) REFERENCES profile (id),
    FOREIGN KEY (category) REFERENCES category (id),
    FOREIGN KEY (gender) REFERENCES gender (id),
    )
