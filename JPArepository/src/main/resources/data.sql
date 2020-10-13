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
VALUES('POLICE', "879474637", "984442346", 71.010),
    ('HOSPITAL', "89756757756", "666661235", 17.27),
    ('FIRE', "879222221", "87333331", 63.37),
    ('EMMERGENCY', "897111123", "89884758", 67.87);

select *
from ContactsList