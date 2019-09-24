CREATE TABLE Client (
  client_id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  date_of_birth date NOT NULL,
  email varchar(255) DEFAULT NULL,
  first_name varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  patronymic varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  client_address_fk_id int(11) NOT NULL)
  FOREIGN KEY (gender) REFERENCES gender (id),