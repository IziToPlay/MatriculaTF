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

INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'12345','admin1');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'123456','alumno1');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'abcd','alumno2');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'efg','alumno3');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'hij','alumno4');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'klm','alumno5');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'nop','alumno6');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'qrs','alumno7');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'tuv','alumno8');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'wxy','alumno9');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'z123','alumno10');

INSERT INTO authorities(authority,user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',2);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',3);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',4);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',5);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',6);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',7);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',8);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',9);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',10);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',11);


INSERT INTO students (account_id, name, lastname, career, semester) VALUES (2, 'Jhon', 'Garcia', 'Ingenieria ambiental', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (3, 'Miguel', 'Calderon', 'Ingenieria ambiental', 3);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (4, 'Ramiro', 'Ramirez', 'Ingenieria industrial', 4);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (5, 'Juan', 'Garcia', 'Ingenieria ambiental', 5);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (6, 'Maria', 'Gonzales', 'Ingenieria ambiental', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (7, 'Fernanda', 'Aliaga', 'Ingenieria ambiental', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (8, 'Hector', 'Torres', 'Ingenieria ambiental', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (9, 'Chi', 'Jin', 'Ingenieria ambiental', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (10, 'Vicesat', 'Martinez', 'Ingenieria ambiental', 2);

