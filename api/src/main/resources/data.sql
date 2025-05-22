DROP TABLE IF EXISTS employees;
 
CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  birth_date DATE
);
 
INSERT INTO employees (first_name, last_name, mail, password, birth_date) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent', '1990-05-20'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie', '1985-12-11'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe', '1993-08-02'),
  ('Lucas', 'Bernard', 'lucas.bernard@mail.com', 'lucas', '1988-03-17'),
  ('Emma', 'Lemoine', 'emma.lemoine@mail.com', 'emma', '1995-07-24'),
   ('Emma', 'Lemoine', 'emma.lemoine@mail.com', 'emma', '1995-05-19'),
    ('Emma', 'Lemoine', 'emma.lemoine@mail.com', 'emma', '1995-05-17'),
     ('Emma', 'Lemoine', 'emma.lemoine@mail.com', 'emma', '1995-05-25'),
      ('Emma', 'Lemoine', 'emma.lemoine@mail.com', 'emma', '1995-05-27');;