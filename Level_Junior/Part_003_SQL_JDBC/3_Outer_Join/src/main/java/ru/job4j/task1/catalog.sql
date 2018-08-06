-- 2. Создать структур данных в базе. Таблицы. Трансмиссия. Двигатель, Коробка передач.
CREATE TABLE transmissions (
	id 		SERIAL NOT NULL PRIMARY KEY,
	name 	CHARACTER VARYING(200) NOT NULL
);

CREATE TABLE engines (
	id 		SERIAL NOT NULL PRIMARY KEY,
	name 	CHARACTER VARYING(200) NOT NULL,
	volume INTEGER
);

CREATE TABLE gearboxes (
	id 		SERIAL NOT NULL PRIMARY KEY,
	name 	CHARACTER VARYING(200) NOT NULL,
	gears INTEGER
);

CREATE TABLE cars (
	id SERIAL NOT NULL PRIMARY KEY,
	name CHARACTER VARYING(200) NOT NULL,
	engine_id INTEGER REFERENCES engines(id),
	transmission_id INTEGER REFERENCES transmissions(id),
	gearbox_id INTEGER REFERENCES gearboxes(id)
);


INSERT INTO engines(name, volume) values('mercedes', 2000);
INSERT INTO engines(name, volume) values('fiat', 1500);
INSERT INTO engines(name, volume) values('reno', 1900);
INSERT INTO engines(name, volume) values('volkswagen', 2000);

INSERT INTO transmissions(name) values('front-wheel drive');
INSERT INTO transmissions(name) values('rear drive');
INSERT INTO transmissions(name) values('four-wheel drive');

INSERT INTO gearboxes(name, gears) values('manual', 6);
INSERT INTO gearboxes(name, gears) values('automat', 5);
INSERT INTO gearboxes(name, gears) values('tiptronic', 6);
INSERT INTO gearboxes(name, gears) values('robot', 8);

INSERT INTO cars(name, engine_id, transmission_id, gearbox_id) values ('c200', 1, 1, 2);
INSERT INTO cars(name, engine_id, transmission_id, gearbox_id) values ('golf 4 alltrack', 4, 3, 1);
INSERT INTO cars(name, engine_id, transmission_id, gearbox_id) values ('laguna', 3, 1, 2);

-- 4. Вывести все машины
SELECT cr.name, en.name, tr.name, gr.name FROM cars AS cr
INNER JOIN engines AS en ON cr.engine_id = en.id
INNER JOIN transmissions AS tr ON cr.transmission_id = tr.id
INNER JOIN gearboxes AS gr ON cr.gearbox_id = gr.id;

-- 5. Вывести все неиспользуемые детали.
SELECT en.name AS "Unused parts" FROM engines AS en
LEFT OUTER JOIN cars AS cr ON en.id = cr.engine_id
WHERE cr.id IS NULL
UNION
SELECT tr.name FROM transmissions AS tr
LEFT OUTER JOIN cars AS cr ON tr.id = cr.transmission_id
WHERE cr.id IS NULL
UNION
SELECT gr.name FROM gearboxes AS gr
LEFT OUTER JOIN cars AS cr ON gr.id = cr.gearbox_id
WHERE cr.id IS NULL;