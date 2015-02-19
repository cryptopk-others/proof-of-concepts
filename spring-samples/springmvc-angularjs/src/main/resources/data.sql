
delete from contacts;
delete from users;

insert into users(user_id, email, password, firstname, lastname, dob, enabled) values(1,'admin@gmail.com','admin','Administrator',null, '1983-06-25', true);
insert into users(user_id, email, password, firstname, lastname, dob, enabled) values(2,'siva@gmail.com','siva','Siva','Prasad', '1983-06-25', true);

insert into contacts(contact_id, user_id, firstname, lastname, email, phone, dob) values(1,1,'Ramu','P','ramu@gmail.com','99999999','1982-01-23');
insert into contacts(contact_id, user_id, firstname, lastname, email, phone, dob) values(2,2,'Suman','A','suman@gmail.com','99999999','1982-01-23');
insert into contacts(contact_id, user_id, firstname, lastname, email, phone, dob) values(3,2,'Suresh','U','suresh@gmail.com','99999999','1982-01-23');
