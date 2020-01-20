use presly;
DROP TABLE IF EXISTS pemba1;
CREATE TABLE pemba1 (
 --- id serial  PRIMARY KEY, -- POSTGRESS/MYSQL/MSSQL
  id INT AUTO_INCREMENT  PRIMARY KEY, --- MSYSQL/H2 DataBase Version
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL);

INSERT INTO 
	pemba1 (first_name, last_name, email) 
VALUES
  	('David Buchizya', 'Lusaka', 'buchizyad@lusaka.com'),
 	('Marcus Gurvey', 'Peking', 'jinping@kit.com'),
	('Linos Marvin ', 'Engineer', 'linosmarvina@gmail.com'),
	('Mark Darglas', 'Technologist', 'markdaglas@facebook.com'),
	('Elvis Presly', 'Scientist', 'elvispresly@utb.com');
SELECT * from pemba1