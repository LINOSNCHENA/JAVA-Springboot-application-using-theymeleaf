use presly;
-- Create a new table called 'Banking' in schema 'dbo'
IF OBJECT_ID('dbo.CUSTOMALIST', 'U') IS NOT NULL
DROP TABLE dbo.customalist
GO
-- Create the table in the specified schema
CREATE TABLE dbo.CUSTOMALIST
(
   id INT PRIMARY KEY,
   names [NVARCHAR](50) NOT NULL,
   status [decimal](18,0) NOT NULL default '2',
   post [NVARCHAR](100),--  NOT NULL,--4
   salary INT,
   status [NVARCHAR](100) NOT NULL default "Temporal",
   created_at date not null default GETDATE()
);
GO
-- Create the table in the specified schema
SELECT *
FROM dbo.CUSTOMALIST