use presly;
DROP TABLE IF EXISTS Customerentity;
CREATE TABLE Customerentity
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
	Customerentity
	(firstname, lastname, email)
VALUES
	('Catherine Nchena', 'Teacher', 'cathy.phiri@lsk.co.uk'),
	('Diana Merphias', 'Teacher', 'mucus.gavey@jka.zm'),
	('Nikolas Marvin ', 'Engineer', 'nikolas.marvina@gmail.ru'),
	('Kelvin Mwemba', 'Nurse', 'marvin.mwemba@pba.zm'),
	('Elvis Presly', 'Scientist', 'elvis.presly@prg.cz');
SELECT *
from Customerentity