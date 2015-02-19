
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS permissions;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS groups;

CREATE TABLE  groups (
  group_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (group_id),
  UNIQUE KEY UK_GROUP_NAME (name)
);



CREATE TABLE  menus (
  menu_id int(11) NOT NULL AUTO_INCREMENT,
  className varchar(255) DEFAULT NULL,
  iconCls varchar(255) DEFAULT NULL,
  text varchar(50) NOT NULL,
  parent_id int(11) DEFAULT NULL,
  PRIMARY KEY (menu_id),
  FOREIGN KEY (parent_id) REFERENCES menus (menu_id)
);

CREATE TABLE  permissions (
  group_id int(11) NOT NULL,
  menu_id int(11) NOT NULL,
  PRIMARY KEY (group_id,menu_id),
  FOREIGN KEY (group_id) REFERENCES groups (group_id),
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id)
);

CREATE TABLE  users 
(
  user_id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  picture varchar(255) DEFAULT NULL,
  username varchar(50) NOT NULL,
  group_id int(11) DEFAULT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UK_USERNAME (username),
  FOREIGN KEY (group_id) REFERENCES groups (group_id)
);

INSERT INTO groups (group_id,name) VALUES (1,'admin');

INSERT INTO menus (menu_id, text, iconCls) VALUES (1, 'menu1', 'menu_admin');
INSERT INTO menus (menu_id, text, iconCls, parent_id,className) VALUES (2, 'menu11', 'menu_groups', 1, 'panel');
INSERT INTO menus (menu_id, text, iconCls, parent_id,className) VALUES (3, 'menu12', 'menu_users', 1, 'users');
INSERT INTO menus (menu_id, text, iconCls) VALUES ('4', 'staticData', 'menu_staticdata');
INSERT INTO menus (menu_id, text, iconCls, parent_id, className) VALUES (5,'actors', 'menu_actor', '4', 'actorsgrid');
INSERT INTO menus (menu_id, text, iconCls, parent_id, className) VALUES (6,'categories', 'menu_category', '4', 'categoriesgrid');
INSERT INTO menus (menu_id, text, iconCls, parent_id, className) VALUES (7,'languages', 'menu_language', '4', 'languagesgrid');
INSERT INTO menus (menu_id, text, iconCls, parent_id, className) VALUES (8,'cities', 'menu_city', '4', 'citiesgrid');
INSERT INTO menus (menu_id, text, iconCls, parent_id, className) VALUES (9,'countries', 'menu_country', '4', 'countriesgrid');

INSERT INTO permissions (menu_id, group_id) VALUES ('1', '1'), ('2', '1'), ('3', '1');
INSERT INTO permissions (menu_id, group_id) VALUES ('4', '1'), ('5', '1'), ('6', '1'), ('7', '1'), ('8', '1'), ('9', '1');

INSERT INTO users (user_id,email,name,password,picture,username,group_id) VALUES (1,'admin@gmail.com','Administrator','admin',NULL,'admin',1);
INSERT INTO users (user_id,email,name,password,picture,username,group_id) VALUES (2,'siva@gmail.com','Siva','siva',NULL,'siva',1);


