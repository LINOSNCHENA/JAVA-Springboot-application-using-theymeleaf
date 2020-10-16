use presly;
DROP TABLE IF EXISTS CUSTOMERLIST;
CREATE TABLE CUSTOMERLIST
(
	id serial PRIMARY KEY,
	firstname VARCHAR
	(250) NOT NULL,
	lastname VARCHAR
	(250) NOT NULL,
	email VARCHAR
	(250) DEFAULT NULL
);

INSERT INTO 
	CUSTOMERLIST
	(firstname, lastname, email)
VALUES
	('NORIA Nicoles', 'Teacher', 'cathy.phiri@lsk.co.uk'),
	('Diana Lorena', 'Science', 'leon.lorena@kzn.zm'),
	('Nikolas Marvin ', 'Engineer', 'nikolas.marvina@gmail.ru'),
	('SEARCH WORKS', 'Nurse', 'marvin.works@pba.zm'),
	('Elvis Presly', 'Developer', 'elvis.presly@prg.cz');
SELECT *
from CUSTOMERLIST