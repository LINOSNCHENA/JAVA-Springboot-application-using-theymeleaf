DROP TABLE IF EXISTS ContactsList;
CREATE TABLE Contactslist
(
    ID serial PRIMARY KEY,
    NAME varchar (45) NOT NULL,
    MOBILE varchar
    (45) NOT NULL,
    OFFICE varchar
    (45) NOT NULL,
    STARS float NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);

INSERT INTO ContactsList
    (NAME, MOBILE, OFFICE, STARS)
VALUES('POLICE-MOBILE', "timestamp", "22346", 7.0),
    ('ZambiaSTARS', "MOBILE", "1235", 67.87),
    ('POTORIKA', "MOBILE", "PUFFY", 67.87),
    ('ZambiaSTARS', "second", "contactslits", 67.87);

select *
from ContactsList