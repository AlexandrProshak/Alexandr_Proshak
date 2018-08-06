CREATE TABLE kinds (
	id 		SERIAL NOT NULL PRIMARY KEY,
	name 	CHARACTER VARYING(50) NOT NULL
);

CREATE TABLE products (
	id SERIAL       NOT NULL PRIMARY KEY,
	name 			CHARACTER VARYING(50) NOT NULL,
	kind_id 		INTEGER REFERENCES kinds(id),
	expired_date 	TIMESTAMP NOT NULL,
	price 			INTEGER NOT NULL,
	amount 			INTEGER
);

INSERT INTO kinds (name) VALUES ('СЫР');
INSERT INTO kinds (name) VALUES ('МОЛОКО');
INSERT INTO kinds (name) VALUES ('ХЛЕБ');
INSERT INTO kinds (name) VALUES ('ЯЙЦА');
INSERT INTO kinds (name) VALUES ('ДРОЖЖИ');
INSERT INTO kinds (name) VALUES ('МОРОЖЕНОЕ');

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Голландский', 1, '2018-03-30', 250, 25);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Гауда', 1, '2018-04-30', 200, 5);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Пармезан', 1, '2018-05-30', 300, 2);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Дружба', 1, '2018-03-28', 15, 1);

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Здоровье', 2, '2018-03-25', 25, 100);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Молодильное', 2, '2018-04-05', 35, 200);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Пастеризированное', 2, '2018-08-25', 20, 1000);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Козье', 2, '2018-04-25', 20, 9);

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Хлеб', 3, '2018-03-30', 10, 100);

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Большие', 4, '2018-04-25', 20, 90);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Средние', 4, '2018-04-20', 15, 50);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Битые', 4,'2018-03-24', 5, 5);

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Пекарские', 5, '2018-05-24', 35, 150);

INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Мороженное детское', 6, '2018-08-24', 5, 450);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Мороженное большое', 6, '2018-07-24', 25, 250);
INSERT INTO products (name, kind_id, expired_date, price, amount) VALUES ('Мороженное рожек', 6, '2018-07-14', 15, 150);

--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM products 
	where (kind_id = (SELECT kinds.id FROM kinds where (name = 'СЫР')));

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM products 
	where (products.name LIKE '%Мороженное%');

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM products 
	where (products.expired_date < '2018-04-01');

--4. Написать запрос, который вывод самый дорогой продукт.
SELECT * FROM Products
	WHERE Products.price = (SELECT MAX(Products.price) FROM Products);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT SUM(Products.amount) FROM Products
	WHERE Products.kind_id = (SELECT kinds.id FROM kinds WHERE kinds.name = 'ХЛЕБ');

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО".
SELECT * FROM Products
	WHERE Products.kind_id IN (SELECT Kinds.id FROM Kinds WHERE Kinds.name IN ('СЫР', 'МОЛОКО'));

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
SELECT * FROM Kinds
	WHERE Kinds.id IN (SELECT Products.kind_id FROM Products WHERE Products.amount < 10);

--8. Вывести все продукты и их тип.
SELECT p.id, k.name, p.name FROM Products AS p
INNER JOIN Kinds AS k ON p.kind_id = k.id;