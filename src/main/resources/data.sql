INSERT INTO `USER`(name, email, password) VALUES('Student', 'student@email.com', '$2a$10$ThY1hrNjLXN/uu1.PwHL1OQBs7.tXX.lkEQrpwaslh62fZoo7mZhK');
INSERT INTO `USER`(name, email, password) VALUES('Admin', 'admin@email.com', '$2a$10$ThY1hrNjLXN/uu1.PwHL1OQBs7.tXX.lkEQrpwaslh62fZoo7mZhK');

INSERT INTO ROLE(id, name) values (1, 'ROLE_STUDENT');
INSERT INTO ROLE(id, name) values (2, 'ROLE_ADMIN');

INSERT INTO USER_ROLES(user_id, roles_id) VALUES(1, 1);
INSERT INTO USER_ROLES(user_id, roles_id) VALUES(2, 2);

INSERT INTO COURSE(name, subject) VALUES('Spring Boot', 'Programação');
INSERT INTO COURSE(name, subject) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);