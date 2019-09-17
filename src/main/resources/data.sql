DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
 id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL );

INSERT INTO 
	customers (first_name, last_name, email) 
VALUES
  	('Leon', 'Lorena', 'leonlorena@yahoo.com'),
	  	('Nikolas', 'Marvin', 'nikolasmavin@gmail.com'),
		  	('Mavin', 'Lorena', 'mavinlorena@gmail.com'),
			  	('Lorena', 'Nikolas', 'lorenanikolas@hotmail.com');