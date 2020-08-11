DROP TABLE IF EXISTS bank2;
CREATE TABLE bank2
(
	id serial PRIMARY KEY,
	-- POSTGRESS/MYSQL/MSSQL
	--- id INT AUTO_INCREMENT  PRIMARY KEY, --- MSYSQL/H2 DataBase Version
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL,
	email VARCHAR(250) DEFAULT NULL
);

INSERT INTO 
	bank2
	(first_name, last_name, email)
VALUES
	('Leon Lorena Banda', 'Proffessor', 'david.banda@lsk.co.uk'),
	('Marcus Gavey', 'Teacher', 'mucus.gavey@jka.zm'),
	('Nikolas Marvin ', 'Engineer', 'nikolas.marvina@gmail.ru'),
	('Marvin Mwemba', 'Technologist', 'marvin.mwemba@pba.zm'),
	('Elvis Presly', 'Scientist', 'elvis.presly@prg.cz');
SELECT *
from bank2