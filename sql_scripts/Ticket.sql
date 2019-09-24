CREATE TABLE Ticket (
    ticket_id int(11) PRIMARY KEY AUTO_INCREMENT,
    cabinet_number int(11) NOT NULL,
    free bit(1) NOT NULL,
    service varchar(255) NOT NULL,
    ticket_date datetime NOT NULL,
    ticket_doctor_fk_id int(11) NOT NULL,
    polyclinic VARCHAR(255) NOT NULL,
    FOREIGN KEY (polyclinic) REFERENCES polyclinic (id),
    FOREIGN KEY (service) REFERENCES service (id)
)
