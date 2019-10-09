---MySQL dataBase Aganist MSSQL
---ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Monze2019@';

use presly;
DROP TABLE IF EXISTS bank2 ;

CREATE TABLE bank2 (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
names VARCHAR(50) NOT NULL,
dept VARCHAR(50) NOT NULL,
post VARCHAR(50),salary int,
status VARCHAR(50) default "Temporal",
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO bank2 ( names,dept,post,salary )
   VALUES
   ( "Leon", "Nchena","Director", 21200 ),
   ( "Lorena nchena", "Engineer","post", 8500 ),
   ( "Nikolas nchena", "Engineer","post", 8500 ),
   ( "Kristopher Mwepu", "cmis","Lecturer", 13500 );
   
select * from Bank2





