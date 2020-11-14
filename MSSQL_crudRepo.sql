use presly;
-- Create a new table called 'Banking' in schema 'dbo'
DROP TABLE IF EXISTS dbo.CUSTOMALIST

GO
-- Create the table in the specified schema
CREATE TABLE dbo.CUSTOMALIST
(
   id int IDENTITY, 
   first_name [NVARCHAR] (250) NOT NULL,
   last_name [NVARCHAR](250) NOT NULL,
   email [NVARCHAR](250) NOT NULL default 'Temporal',
   created_at date not null default GETDATE()
);
GO

	 INSERT INTO dbo.CUSTOMALIST (first_name, last_name ,email)
 VALUES
 ('MUntu', 'David','2000-12-06'),
  ('MUFASA', 'David','2000-12-06'),
   ('MUnga', 'David','2000-12-06'),
    ('Mwemba', 'David','2000-12-06'),
     ('Mfonta', 'David','2000-12-06'),
      ('Mwenza', 'David','2000-12-06')
-- Create the table in the specified schema
SELECT *
FROM dbo.CUSTOMALIST