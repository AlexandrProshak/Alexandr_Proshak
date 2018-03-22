INSERT INTO Rules (name, description) VALUES ('create', 'create new data');
INSERT INTO Rules (name, description) VALUES ('update', 'update data');
INSERT INTO Rules (name, description) VALUES ('delete', 'delete data');
INSERT INTO Rules (name, description) VALUES ('create', 'create users');
INSERT INTO Rules (name, description) VALUES ('update', 'update users data');
INSERT INTO Rules (name, description) VALUES ('delete', 'delete users');

INSERT INTO Roles (name, description) VALUES ('super_administrator', 'can do everything');
INSERT INTO Roles (name, description) VALUES ('user_administrator', 'can administrate users rights');
INSERT INTO Roles (name, description) VALUES ('super_user', 'can create, update, delete data');
INSERT INTO Roles (name, description) VALUES ('user', 'can create and update new data');

INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 1);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 2);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 3);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 4);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 5);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (1, 6);

INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (2, 4);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (2, 5);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (2, 6);

INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (3, 1);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (3, 2);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (3, 3);

INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (4, 1);
INSERT INTO Rules_to_Roles (roles_id, rules_id) VALUES (4, 2);

INSERT INTO States (name, description) VALUES ('new', 'new Item');
INSERT INTO States (name, description) VALUES ('opened', 'opened Item');
INSERT INTO States (name, description) VALUES ('closed', 'closed Item');
INSERT INTO States (name, description) VALUES ('reopen', 'reopen Item');

INSERT INTO Categories (name, description) VALUES ('major', 'very important');
INSERT INTO Categories (name, description) VALUES ('normal', 'important');
INSERT INTO Categories (name, description) VALUES ('minor', 'not very important');

INSERT INTO Items (name, description, user_id, category_id, state_id) VALUES ('Order', 'new customer order', 1, 2, 1);
INSERT INTO Items (name, description, user_id, category_id, state_id) VALUES ('Complaint order', 'bad service', 1, 1, 4);
INSERT INTO Items (name, description, user_id, category_id, state_id) VALUES ('Thanks order', 'god service', 2, 2, 3);

INSERT INTO Users (login, password, roles_id, item_id) VALUES ('Nick', '12345', 2, 2);
INSERT INTO Users (login, password, roles_id, item_id) VALUES ('Mick', 'qwert', 1, 3);

INSERT INTO Comments (name, description, item_id) VALUES ('First comment', 'Comment for the first order', 1);
INSERT INTO Comments (name, description, item_id) VALUES ('Secomd comment', 'Comment about bad service', 2);
INSERT INTO Comments (name, description, item_id) VALUES ('Comment', 'Thanks comment', 3);

INSERT INTO Attachments (name, description, attachment, item_id) VALUES ('Attachment', 'Welcome pictures', 'http://trata.ta/index.html');
INSERT INTO Attachments (name, description, attachment, item_id) VALUES ('Attachment', 'Picture', 'http://trata.ta/...');