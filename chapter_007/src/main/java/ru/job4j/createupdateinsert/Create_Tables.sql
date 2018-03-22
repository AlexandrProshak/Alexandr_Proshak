CREATE TABLE Rules (
	id 			SERIAL,
	name 		CHARACTER VARYING(50)	NOT NULL,
	description TEXT 					NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Roles (
	id 			SERIAL, 
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Rules_to_Roles (
	id 			SERIAL,
	rules_id 	INTEGER REFERENCES Rules (id),
	roles_id 	INTEGER REFERENCES Roles (id),
	PRIMARY KEY (id)
);

CREATE TABLE States (
	id 			SERIAL,
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Categories (
	id 			SERIAL,
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	PRIMARY KEY (id)	
);

CREATE TABLE Items (
	id 			SERIAL,
	create_date TIMESTAMP 				NOT NULL DEFAULT NOW(),
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	user_id 	INTEGER 				REFERENCES Users (id),
	category_id INTEGER					REFERENCES Categories (id),
	state_id	INTEGER					REFERENCES States (id),
	PRIMARY KEY (id)
);

CREATE TABLE Users (
	id 			SERIAL,
	login 		CHARACTER VARYING(50) 	NOT NULL,
	password 	CHARACTER VARYING(50) 	NOT NULL,
	roles_id	INTEGER 				REFERENCES Roles (id),
	item_id 	INTEGER 				REFERENCES Items (id),
	PRIMARY KEY(id)	
);

CREATE TABLE Comments (
	id 			SERIAL,
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	item_id 	INTEGER 				REFERENCES Items (id)
	PRIMARY KEY (id)
);

CREATE TABLE Attachments (
	id 			SERIAL,
	name 		CHARACTER VARYING(50) 	NOT NULL,
	description TEXT 					NOT NULL,
	attachment	TEXT					NOT NULL,
	item_id 	INTEGER 	 			REFERENCES Items (id),
	PRIMARY KEY (id)
);