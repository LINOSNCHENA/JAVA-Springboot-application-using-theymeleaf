DROP TABLE IF EXISTS participantX;
CREATE TABLE participantX
 (
 id serial  PRIMARY KEY, -- POSTGRESS/MYSQL/MSSQ
 -- id INT AUTO_INCREMENT  PRIMARY KEY, --- h2 DataBase Version
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL 
  );

INSERT INTO 
	participantX (first_name, last_name, email) 
VALUES
  	('David Buchizya', 'Lusaka', 'buchizyad@lusaka.com'),
 	('Xi Jinping', 'Peking', 'jinping@kitai.com'),
	('Linos Nchena ', 'Engineer', 'linosnchena@gmail.com'),
	('Mark Zuckerberg,', 'Technologist', 'markzuck@facebook.com'),
	('Masautso Tembo', 'Scientist', 'matsausto@tembo.com');
SELECT * from participantX

