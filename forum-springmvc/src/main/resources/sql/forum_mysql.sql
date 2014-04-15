

--CREATE DATABASE IF NOT EXISTS forum;
--USE forum;

DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS forums;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS config_params;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;



CREATE TABLE users (
  user_id int NOT NULL auto_increment,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  firstname varchar(50) NOT NULL,
  lastname varchar(50) default NULL,
  dob date default NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY UK_USER_EMAIL (email)
) ;


CREATE TABLE roles (
  role_id int NOT NULL auto_increment,
  role_name varchar(255) NOT NULL,
  user_id int NOT NULL,
  PRIMARY KEY  (role_id),
  CONSTRAINT FK_ROLE_USER FOREIGN KEY (user_id) REFERENCES users (user_id)
) ;


CREATE TABLE categories (
  cat_id int NOT NULL auto_increment,
  name varchar(255) NOT NULL,
  description varchar(255) default NULL,
  display_order int default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (cat_id)
) ;


CREATE TABLE forums (
  forum_id int NOT NULL auto_increment,
  name varchar(255) NOT NULL,
  description varchar(255) default NULL,
  cat_id int NOT NULL,
  display_order int default NULL,
  last_topic_id int default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (forum_id),
  CONSTRAINT FK_FORUM_CATEGORY FOREIGN KEY (cat_id) REFERENCES categories (cat_id)
) ;


CREATE TABLE topics (
  topic_id int NOT NULL auto_increment,
  title varchar(255) NOT NULL,
  forum_id int NOT NULL,
  last_post_id int default NULL,
  created_by int NOT NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (topic_id),
  CONSTRAINT FK_TOPIC_CREATED_BY FOREIGN KEY (created_by) REFERENCES users (user_id),
  CONSTRAINT FK_TOPIC_FORUM FOREIGN KEY (forum_id) REFERENCES forums (forum_id)
) ;


CREATE TABLE posts (
  post_id int NOT NULL auto_increment,
  title varchar(255) NOT NULL,
  content varchar(255) default NULL,
  topic_id int default NULL,
  created_by int NOT NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (post_id),
  CONSTRAINT FK_POST_CREATED_BY FOREIGN KEY (created_by) REFERENCES users (user_id),
  CONSTRAINT FK_POST_TOPIC FOREIGN KEY (topic_id) REFERENCES topics (topic_id)
) ;


CREATE TABLE config_params (
  param_id int NOT NULL auto_increment,
  param_name varchar(255) NOT NULL,
  param_value varchar(255) NOT NULL,
  description varchar(255) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (param_id),
  UNIQUE KEY UK_CONFIG_PARAN_NAME (param_name)
) ;


--ALTER TABLE forums ADD CONSTRAINT FK_FORUM_LAST_TOPIC FOREIGN KEY (last_topic_id) REFERENCES topics (topic_id);
--ALTER TABLE topics ADD CONSTRAINT FK_TOPIC_LAST_POST FOREIGN KEY (last_post_id) REFERENCES posts (post_id);


INSERT INTO users (user_id,dob,email,enabled,firstname,lastname,password) VALUES 
 (1,'1983-06-25','admin@gmail.com',1,'SivaLabs','Admin','admin'),
 (2,'1983-06-25','siva@gmail.com',1,'Siva','Prasad','siva');
 

INSERT INTO roles (role_id,role_name,user_id) VALUES 
 (1,'ROLE_USER',1),
 (2,'ROLE_ADMIN',1),
 (3,'ROLE_USER',2);
 

INSERT INTO config_params (param_id,created_on,description,param_name,updated_on,param_value) VALUES 
 (1,NULL,'Support Email','support_email',NULL,'siva@gmail.com'),
 (2,NULL,'Email Server','smtp_server',NULL,'smtp.gmail.com'),
 (3,NULL,'Email server port','smtp_port',NULL,'625');
 
 
INSERT INTO categories (cat_id,created_on,description,name,display_order,updated_on) VALUES 
 (1,NULL,'Java Programming Language','Java',NULL,NULL),
 (2,NULL,'Microsoft .NET framework','MS.NET',NULL,NULL),
 (3,NULL,'Database Management Systems','Databases',NULL,NULL),
 (4,NULL,'NoSQL Databases','NoSQL',NULL,NULL),
 (5,'2014-02-09 11:03:47','Data Warehousing','Data Warehousing',NULL,NULL),
 (6,'2014-02-09 11:04:01','Testing','Testing',NULL,NULL),
 (7,'2014-02-09 11:04:28','Systems Administration','Systems Administration',NULL,NULL);


INSERT INTO forums (forum_id,created_on,description,name,updated_on,cat_id,last_topic_id,display_order) VALUES 
 (1,NULL,'Core Java discussions','Core Java',NULL,1,NULL,NULL),
 (2,NULL,'Java Database Connectivity','JDBC',NULL,1,NULL,NULL),
 (3,NULL,'Spring Core Framework','Spring Core',NULL,1,NULL,NULL),
 (4,NULL,'Spring MVC framework','Spring MVC',NULL,1,NULL,NULL),
 (5,NULL,'Java Enterprise Edition','JavaEE',NULL,1,NULL,NULL),
 (6,NULL,'MySQL Database','MySQL',NULL,3,NULL,NULL),
 (7,NULL,'Oracle Database','Oracle',NULL,3,NULL,NULL),
 (8,NULL,'ASP.NET framework','ASP.NET',NULL,2,NULL,NULL),
 (9,NULL,'LINQ ','LINQ',NULL,2,NULL,NULL),
 (10,NULL,'MongoDB document database','MongoDB',NULL,4,NULL,NULL),
 (11,'2014-02-09 11:14:36','ADO.NET','ADO.NET',NULL,2,NULL,NULL);
 
 
 
 



