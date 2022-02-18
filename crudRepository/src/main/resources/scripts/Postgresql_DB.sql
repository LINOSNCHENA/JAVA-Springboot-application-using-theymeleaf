use presly;
DROP TABLE IF EXISTS CUSTOMALIST;
CREATE TABLE CUSTOMALIST
(
	id serial PRIMARY KEY,
	first_name VARCHAR
	(250) NOT NULL,
	last_name VARCHAR
	(250) NOT NULL,
	email VARCHAR
	(250) DEFAULT NULL
);

INSERT INTO 
	CUSTOMALIST
	(first_name, last_name, email)
VALUES
	('NORIA Nicoles', 'Teacher', 'cathy.phiri@lsk.co.uk'),
	('MARTIN LOWLAND', 'Science', 'leon.lorena@kzn.zm'),
	('Nikolas Marvin ', 'Engineer', 'nikolas.marvina@gmail.ru'),
	('SEARCH WORKS', 'Nurse', 'marvin.works@pba.zm'),
	('ICE CUBE', 'Developer', 'elvis.presly@prg.cz');
SELECT *
from CUSTOMALIST