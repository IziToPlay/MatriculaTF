INSERT INTO professors (name, last_name) VALUES ('Henry', 'Martinez');
INSERT INTO professors (name, last_name) VALUES ('Mario', 'Castro');
INSERT INTO professors (name, last_name) VALUES ('Julio', 'Gomez');
INSERT INTO professors (name, last_name) VALUES ('Hugo', 'Mosquera');
INSERT INTO professors (name, last_name) VALUES ('Cesar', 'Garcia');
INSERT INTO professors (name, last_name) VALUES ('Hernan', 'Alvitez');

INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Geografia', 10, 1, 2, 'Ingenieria ambiental', 'Jueves', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Matematica', 10, 2, 3, 'Ingenieria industrial', 'Jueves', '10:00', '12:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Lenguaje', 10, 3, 4, 'Ingenieria de sistemas', 'Lunes', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Calculo', 10, 4, 2, 'Ingenieria textil', 'Viernes', '13:00', '15:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Historia', 10, 5, 5, 'Ingenieria ambiental', 'Sabado', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Creatividad', 10, 6, 1, 'Ingenieria ambiental', 'Martes', '15:00', '17:00' );

INSERT INTO enrollments (semester) VALUES (1); 
INSERT INTO enrollments (semester) VALUES (2); 
INSERT INTO enrollments (semester) VALUES (3); 
INSERT INTO enrollments (semester) VALUES (4); 
INSERT INTO enrollments (semester) VALUES (5); 
INSERT INTO enrollments (semester) VALUES (6); 
INSERT INTO enrollments (semester) VALUES (7); 
INSERT INTO enrollments (semester) VALUES (8); 
INSERT INTO enrollments (semester) VALUES (9); 
INSERT INTO enrollments (semester) VALUES (10); 

INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'12345','profesor');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'123456','alumno');

INSERT INTO authorities(authority,user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',2);

INSERT INTO students (account_id, name, lastname, career, semester) VALUES (2, 'Jhon', 'Garcia', 'Ingenieria ambiental', 2);