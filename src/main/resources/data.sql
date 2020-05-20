INSERT INTO professors (name, last_name) VALUES ('Henry', 'Martinez');
INSERT INTO professors (name, last_name) VALUES ('Mario', 'Castro');
INSERT INTO professors (name, last_name) VALUES ('Julio', 'Gomez');
INSERT INTO professors (name, last_name) VALUES ('Hugo', 'Mosquera');
INSERT INTO professors (name, last_name) VALUES ('Cesar', 'Garcia');
INSERT INTO professors (name, last_name) VALUES ('Hernan', 'Alvitez');

INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Geografia', 10, 1, 201602, 'Ingenieria de Sistemas', 'Jueves', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Matematica', 10, 2, 201602, 'Ingenieria de Sistemas', 'Jueves', '10:00', '12:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Lenguaje', 10, 3, 201602, 'Ingenieria de Sistemas', 'Lunes', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Calculo', 10, 4, 201701, 'Administracion', 'Viernes', '13:00', '15:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Historia', 10, 5, 201801, 'Ingenieria de Software', 'Sabado', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Creatividad', 10, 6, 201601, 'Ingenieria Civil', 'Martes', '15:00', '17:00' );

INSERT INTO enrollments (semester) VALUES (201601); 
INSERT INTO enrollments (semester) VALUES (201602); 
INSERT INTO enrollments (semester) VALUES (201701); 
INSERT INTO enrollments (semester) VALUES (201702); 
INSERT INTO enrollments (semester) VALUES (201801); 
INSERT INTO enrollments (semester) VALUES (201802); 
INSERT INTO enrollments (semester) VALUES (201901); 
INSERT INTO enrollments (semester) VALUES (201902); 
INSERT INTO enrollments (semester) VALUES (202001); 
INSERT INTO enrollments (semester) VALUES (202002); 

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


INSERT INTO students (account_id, name, lastname, career, semester) VALUES (2, 'Jhon', 'Garcia', 'Ingenieria de Sistemas', 201601);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (3, 'Miguel', 'Calderon', 'Ingenieria de Sistemas', 201602);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (4, 'Ramiro', 'Ramirez', 'Ingenieria de Sistemas', 201701);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (5, 'Juan', 'Garcia', 'Ingenieria Civil', 201702);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (6, 'Maria', 'Gonzales', 'Ingenieria de Software', 201801);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (7, 'Fernanda', 'Aliaga', 'Administracion', 201701);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (8, 'Hector', 'Torres', 'Economia', 201702);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (9, 'Chi', 'Jin', 'Ingenieria Industrial', 201801);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (10, 'Vicesat', 'Martinez', 'Ingenieria Civil', 201802);


INSERT INTO students_courses (student_id, course_id, enrollment_id) VALUES (2, 2, 10);
INSERT INTO students_courses (student_id, course_id, enrollment_id) VALUES (2, 3, 10);
INSERT INTO students_courses (student_id, course_id, enrollment_id) VALUES (2, 4, 10);
INSERT INTO students_courses (student_id, course_id, enrollment_id) VALUES (2, 5, 9);

