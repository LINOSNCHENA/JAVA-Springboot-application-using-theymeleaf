-- Create a new table called 'Banking' in schema 'dbo'
IF OBJECT_ID('dbo.bank2', 'U') IS NOT NULL
DROP TABLE dbo.tasks1
GO
-- Create the table in the specified schema
CREATE TABLE dbo.bank2
(
   id  INT PRIMARY KEY, -- primary key column
   names  [NVARCHAR](50) NOT NULL,   ---2
   status  [decimal](18,0) NOT NULL default '2',   ---3
   post  [NVARCHAR](100),--  NOT NULL,--4
   salary  INT,  --NOT NULL       --5
   status  [NVARCHAR](100) NOT NULL default "Temporal",
   created_at date not null default GETDATE() 
);
GO
-- Create the table in the specified schema
SELECT * FROM dbo.bank2

