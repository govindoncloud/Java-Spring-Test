/**
 * CREATE Script for init of DB
 */

INSERT INTO account(id,username,password)
VALUES (1,'mytestuser','secret123');

-- Create 3 Users

insert into user (id, userid, first_name, last_name, password, deleted) values (1, 'gosankar','Govind','Sankar','password', false);

insert into user (id, userid, first_name, last_name, password, deleted) values (2, 'one','FirstOne','LastOne','password', false);

insert into user (id, userid, first_name, last_name, password, deleted) values (3, 'two','FirstTwo','LastTwo','password', false);





