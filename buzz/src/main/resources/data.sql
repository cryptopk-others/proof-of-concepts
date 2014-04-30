
delete from messages;
delete from users_roles;
delete from roles;
delete from users;


insert into roles(id, name) values(1,'ROLE_USER');
insert into roles(id, name) values(2,'ROLE_ADMIN');

insert into users(id, name, email, password) values(1,'Administrator','admin@gmail.com','$2a$10$EvXkH3oYTjGsuD1awP11NevHh511903zBz9Ncf7pUIHx/TYBTyg2u');
insert into users(id, name, email, password) values(2,'Siva','siva@gmail.com','$2a$10$j0SzhykJ9vzEz2Y8FRDeAeI3NCLwqIrlW0p3ppnZYoAuBrgGSRJNq');

insert into users_roles(user_id, role_id) values(1,1);
insert into users_roles(user_id, role_id) values(1,2);
insert into users_roles(user_id, role_id) values(2,1);

insert into messages(id, content, created_on, created_by) values(1, 'Tracking Exceptions - Part 5 - Scheduling With Spring http://java.dzone.com/articles/tracking-exceptions-part-5', now(), 1);
insert into messages(id, content, created_on, created_by) values(2, 'A NodeJS Perspective on What’s New in MongoDB 2.6, Part I: Text Search http://java.dzone.com/articles/nodejs-perspective-whats-new', now(), 1);
insert into messages(id, content, created_on, created_by) values(3, 'Talent Helps But Its Hard Work That Counts http://java.dzone.com/articles/talent-helps-its-hard-work', now(), 1);
insert into messages(id, content, created_on, created_by) values(4, 'Dagger: A Dependency Injection Framework for Android and Java http://java.dzone.com/articles/dagger-dependency-injection', now(), 2);
insert into messages(id, content, created_on, created_by) values(5, 'Java Garbage Collection in Jelastic Cloud http://java.dzone.com/articles/java-garbage-collection-1', now(), 1);
insert into messages(id, content, created_on, created_by) values(6, 'An intro so Groovy/Spock testing, why you should consider it http://java.dzone.com/articles/intro-so-groovyspock-testing', now(), 1);
insert into messages(id, content, created_on, created_by) values(7, 'The End of Cloud 1.0 is Near http://java.dzone.com/articles/end-cloud-10-near', now(), 1);
insert into messages(id, content, created_on, created_by) values(8, 'TED Talks Security: 3 Provoking Discussions http://java.dzone.com/articles/ted-talks-security-3-provoking', now(), 2);
insert into messages(id, content, created_on, created_by) values(9, 'Data security is not an IT problem? http://java.dzone.com/articles/data-security-not-it-problem', now(), 2);
insert into messages(id, content, created_on, created_by) values(10, 'Simplicity is Hard http://java.dzone.com/articles/simplicity-hard', now(), 1);
insert into messages(id, content, created_on, created_by) values(11, 'How to Find Bugs in MySQL http://java.dzone.com/articles/how-find-bugs-mysql', now(), 2);
insert into messages(id, content, created_on, created_by) values(12, 'Logs As Data: What Are the Top Use Cases For Your Logs? http://java.dzone.com/articles/logs-data-what-are-top-use', now(), 1);
insert into messages(id, content, created_on, created_by) values(13, 'RESTify your SQL Data http://java.dzone.com/articles/restify-your-sql-data', now(), 1);
insert into messages(id, content, created_on, created_by) values(14, 'Wildfly 8.0 Provides Seamless JSON Support via its JAXRS 2.0 Implementation http://java.dzone.com/articles/wildfly-80-provides-seamless', now(), 1);
insert into messages(id, content, created_on, created_by) values(15, 'Three Questions Every Program Manager Must Ask http://java.dzone.com/articles/three-questions-every-program', now(), 1);

/*
insert into messages(id, content, created_on, created_by) values(16, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(17, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(18, '', now(), 2);
insert into messages(id, content, created_on, created_by) values(19, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(20, '', now(), 2);
insert into messages(id, content, created_on, created_by) values(21, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(22, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(23, '', now(), 2);
insert into messages(id, content, created_on, created_by) values(24, '', now(), 1);
insert into messages(id, content, created_on, created_by) values(25, '', now(), 2);
*/