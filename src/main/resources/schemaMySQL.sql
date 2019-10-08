DROP TABLE IF EXISTS customers;

CREATE TABLE customers
 (
 id serial  PRIMARY KEY, -- POSTGRESS/MYSQL/MSSQ
 -- id INT AUTO_INCREMENT  PRIMARY KEY, --- h2 DataBase Version
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL 
  );


