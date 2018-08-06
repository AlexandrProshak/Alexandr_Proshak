--// Creating table company
CREATE TABLE company (
	id SERIAL NOT NULL,
	name character varying,
	CONSTRAINT company_pkey PRIMARY KEY (id)
);

--// Creating table person
CREATE TABLE person (
	id SERIAL NOT NULL,
	name character varying,
	company_id integer,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

--// Populate table company
INSERT INTO company(name) VALUES('samsung');
INSERT INTO company(name) VALUES('logitech');
INSERT INTO company(name) VALUES('avaya');
INSERT INTO company(name) VALUES('transcend');
INSERT INTO company(name) VALUES('schneider');
INSERT INTO company(name) VALUES('crane');

--// Populate table person
INSERT INTO person(name, company_id) VALUES('Sara', 1);
INSERT INTO person(name, company_id) VALUES('Miake', 2);
INSERT INTO person(name, company_id) VALUES('Niky', 3);
INSERT INTO person(name, company_id) VALUES('Piter', 4);
INSERT INTO person(name, company_id) VALUES('John', 5);
INSERT INTO person(name, company_id) VALUES('Katty', 6);
INSERT INTO person(name, company_id) VALUES('Monica', 2);
INSERT INTO person(name, company_id) VALUES('Mickle', 3);
INSERT INTO person(name, company_id) VALUES('Anthony', 4);
INSERT INTO person(name, company_id) VALUES('Matthew', 5);
INSERT INTO person(name, company_id) VALUES('Mode', 5);

--// 1) Retrieve in a single query:
--// - names of all persons that are NOT in the company with id = 5
--// - company name for each person
SELECT p.id, p.name, c.name 
FROM person AS p
	INNER JOIN company AS c ON
		p.company_id != 5 AND  p.company_id = c.id;


--// 2) Select the name of the company with the maximum number of persons + number of persons in this company
---- variant # 1
SELECT company.name AS "company", COUNT(person.company_id) AS "amount" 
FROM person 
	 INNER JOIN company ON person.company_id = company.id
	 	GROUP BY company.name
	 	ORDER BY COUNT(person.company_id) DESC
	 	LIMIT 1;

---- variant # 2
SELECT company.name AS company, COUNT(person.company_id) AS amount 
FROM company
    INNER JOIN person ON company.id = person.company_id
        GROUP BY company.name
    HAVING (COUNT(person.company_id)) = (SELECT MAX(amount)
    FROM (SELECT COUNT(person.company_id) AS "amount"
    FROM person
        INNER JOIN company ON person.company_id = company.id
        GROUP BY company.name) AS amount);

