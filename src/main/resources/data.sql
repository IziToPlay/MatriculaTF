INSERT INTO professors (name, last_name) VALUES ('Henry', 'Martinez');
INSERT INTO professors (name, last_name) VALUES ('Mario', 'Castro');
INSERT INTO professors (name, last_name) VALUES ('Julio', 'Gomez');
INSERT INTO professors (name, last_name) VALUES ('Hugo', 'Mosquera');
INSERT INTO professors (name, last_name) VALUES ('Cesar', 'Garcia');
INSERT INTO professors (name, last_name) VALUES ('Hernan', 'Alvitez');

INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Geografia', 10, 1, 2, 'Ingenieria de Sistemas', 'Jueves', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Matematica', 10, 2, 2, 'Ingenieria de Sistemas', 'Jueves', '10:00', '12:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Lenguaje', 10, 3, 2, 'Ingenieria de Sistemas', 'Lunes', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Calculo', 10, 4, 3, 'Administracion', 'Viernes', '13:00', '15:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Historia', 10, 5, 5, 'Ingenieria de Software', 'Sabado', '07:00', '09:00' );
INSERT INTO courses (name, amount, professor_id, semester, career, day, start_time, end_time) VALUES ('Creatividad', 10, 6, 1, 'Ingenieria Civil', 'Martes', '15:00', '17:00' );

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

INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$12GHs98dakOMeXnDOlc//uKGjX6tuaU1tTBmukz3Xa20Ga6kktVMG','admin1');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$JWYb0OnTUoAW.9OKtCuVzeqcWrpKDiQ9PXjvv6Mr2ADOyU2UOOSuW','%%%%%%%%');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$jkDJGLGy33byW09rVbDaXOToDGS9/9cAtekwBbvwv6.RfojERrBYq','alfreud2');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$NaM0bZdfTl5dpifzkVGG4OurFqFyPPafcXaSxNPKMi2QHtArrJDFy','alfreud3');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$x2lFdBPxjWfNzkIZUhPGM.xTBM8gKVQwRCVTNz2.axpZShwzVFC06','alfreud4');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$oZPd/WisnTlzUnRQ5As1O.fAN7LNyRHJbKACu6j7.RD0owp.948MK','alfreud5');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$1VjCP27b2qFw/5zErj5mtOKr7aElkLGN2VLTYTd92I0e1FBkuCQw2','alfreud6');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$ckpFyvW.Q6LqrJiGCrODHOurNhHL6TARBBIZiR1SP.PWd5pgUHbMe','alfreud7');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$qQZwyEsiPwj9PQkc9Z9PFOWAED9UdG7CBijAkgG24ZU3vqeEVGpya','alfreud8');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$hjK9FUn.G4ZXiLPe1YOTSeAXgGofeZ5iGY2UhB.I5Yy4Qw7cQN4hK','alfreud9');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$MEIGbkA0I6h2C9OXRVtAUOgpDAz2nUM8.MCNVIMP2KTu70wBUgLcq','alfreud10');
INSERT INTO  accounts(enabled,password,user_name) VALUES(true,'$2a$10$A/MYr2lVeaAGxJdThnst7eTta24VHaD3v4Lie0MrI3UtAn1cYbR0W','alfreud11');

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
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',12);

INSERT INTO students (account_id, name, lastname, career, semester) VALUES (3, 'Jhon', 'Garcia', 'Ingenieria de Sistemas', 1);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (4, 'Miguel', 'Calderon', 'Ingenieria de Sistemas', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (5, 'Ramiro', 'Ramirez', 'Ingenieria de Sistemas', 2);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (6, 'Juan', 'Garcia', 'Ingenieria Civil', 4);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (7, 'Maria', 'Gonzales', 'Ingenieria de Software', 5);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (8, 'Fernanda', 'Aliaga', 'Administracion', 3);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (9, 'Hector', 'Torres', 'Economia', 4);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (10, 'Chi', 'Jin', 'Ingenieria Industrial', 5);
INSERT INTO students (account_id, name, lastname, career, semester) VALUES (11, 'Vicesat', 'Martinez', 'Ingenieria Civil', 6);





