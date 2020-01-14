/*INSERT INTO users (apellidos,nombre,username, password, enabled,telefono) VALUES('Carlos','Hernandez','andres', '$2a$10$pXSjZhKajePgUvQZplTkOuA6n4ee/wHaOF/UJWornHmRxhN3D0Cd6', 1,71208113);
INSERT INTO users (apellidos,nombre,username, password, enabled,telefono) VALUES('Vanessa','Ramirez','admin', '$2a$10$pLiT5n4R/wOZ8SyKgNvvOeRuMd07/m9QzguNQFJPfphWUB0ktQ2zS', 1,83208113);
INSERT INTO users (apellidos,nombre,username, password, enabled,telefono) VALUES('Juan','Carlos','JUAK', '$2a$10$fpZ3pU63UnhsJcAPopsz1.hBzYFe5ptoCXcP4UXkqwv8MBwdHV6x6', 1,7220853);
INSERT INTO users (apellidos,nombre,username, password, enabled,telefono) VALUES('Marlon','Perez','MP123', '$2a$10$IBncau/R54WrXROHE/QEnObji7HOoH5TjrLQSzuJnoVsVlSF73stO', 1,7283113);

INSERT INTO roles (user_id, authority) VALUES(1, 'ROLE_USER');
INSERT INTO roles (user_id, authority) VALUES(2, 'ROLE_ADMIN');
INSERT INTO roles (user_id, authority) VALUES(3, 'ROLE_ADMIN');
INSERT INTO roles (user_id, authority) VALUES(4, 'ROLE_ADMIN');
INSERT INTO roles (user_id, authority) VALUES(4, 'ROLE_USER');

INSERT INTO genero VALUES(NULL,"MASCULINO");
INSERT INTO genero VALUES(NULL,"FEMENINO");

INSERT INTO estado VALUES(1,'Soltero');
INSERT INTO estado VALUES(2,'Casado');
INSERT INTO estado VALUES(3,'Viudo');
INSERT INTO estado VALUES(4,'Acompañado');
INSERT INTO estado VALUES(5,'Quemandose');

INSERT INTO celula VALUES(null,"Brisas");
INSERT INTO celula VALUES(null,"San Jose");
INSERT INTO celula VALUES(null,"Matazano");
INSERT INTO celula VALUES(null,"San Luis");
INSERT INTO celula VALUES(null,"Santos 1");
INSERT INTO celula VALUES(null,"Santos 2");
INSERT INTO celula VALUES(null,"Corinto");
INSERT INTO celula VALUES(null,"Miralvalle");
INSERT INTO celula VALUES(null,"San Antorio");
INSERT INTO celula VALUES(null,"San Francisco");
INSERT INTO celula VALUES(null,"Altavista");
INSERT INTO celula VALUES(null,"San Ernesto");

insert into miembro values(null,'Maldonado','1995-08-30','CHR951',"2019-11-27",'cristofr5248@gmail.com',null,'Christopher','52486139',1,1,1);
insert into miembro values(null,'Pineda','1996-08-30','ARM961',"2018-10-22",'armando@gmail.com',null,'Armando','52486136',2,1,1); 	
insert into miembro values(null,'Campos','1998-04-20','OSW981',"2018-10-22",'oswald@gmail.com',null,'Oswaldo','524864f6',2,1,1); 	
insert into miembro values(null,'Rauda','1999-03-22','ROC991',"2018-10-22",'rocio@gmail.com',null,'Rocio','52sf6',2,1,2); 	
insert into miembro values(null,'Carlos','1999-03-22','JUA991',"2015-06-25",'juanc@gmail.com',null,'Juan','d2s4ff6',4,1,1); 	
insert into miembro values(null,'Peña','1994-03-22','NAP991',"2012-06-25",'natalyp@gmail.com',null,'Nataly','d2sf4ff6',4,1,2); 	

-- INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01', '');
-- INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02', '');
-- INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03', '');
-- INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04', '');
-- INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05', '');
*/
INSERT INTO `celula` VALUES (1,'Brisas'),(2,'San Jose'),(3,'Matazano'),(4,'San Luis'),(5,'Santos 1'),(6,'Santos 2'),(7,'Corinto'),(8,'Miralvalle'),(9,'San Antorio'),(10,'San Francisco'),(11,'Altavista'),(12,'San Ernesto');
INSERT INTO `estado` VALUES (1,'Soltero'),(2,'Casado'),(3,'Viudo'),(4,'Acompañado'),(5,'Quemandose');
INSERT INTO `genero` VALUES (1,'MASCULINO'),(2,'FEMENINO');
INSERT INTO `miembro` VALUES (1,'Maldonado','1995-08-30','CHR951','2019-11-27','cristofr5248@gmail.com',NULL,'Christopher','52486139',1,1,1),(2,'Pineda','1996-08-30','ARM961','2018-10-22','armando@gmail.com',NULL,'Armando','52486136',2,1,1),(3,'Campos','1998-04-20','OSW981','2018-10-22','oswald@gmail.com',NULL,'Oswaldo','524864f6',2,1,1),(4,'Rauda','1999-03-22','ROC991','2018-10-22','rocio@gmail.com',NULL,'Rocio','52sf6',2,1,2),(5,'Carlos','1999-03-22','JUA991','2015-06-25','juanc@gmail.com',NULL,'Juan','d2s4ff6',4,1,1),(6,'Peña','1994-03-22','NAP991','2012-06-25','natalyp@gmail.com',NULL,'Nataly','d2sf4ff6',4,1,2);
INSERT INTO `roles` VALUES (1,'ROLE_USER',1),(2,'ROLE_ADMIN',2),(3,'ROLE_ADMIN',3),(4,'ROLE_ADMIN',4),(5,'ROLE_USER',4);
INSERT INTO `users` VALUES (1,'Carlos',NULL,NULL,'',NULL,'Hernandez','$2a$10$pXSjZhKajePgUvQZplTkOuA6n4ee/wHaOF/UJWornHmRxhN3D0Cd6',71208113,'andres'),(2,'Vanessa',NULL,NULL,'',NULL,'Ramirez','$2a$10$pLiT5n4R/wOZ8SyKgNvvOeRuMd07/m9QzguNQFJPfphWUB0ktQ2zS',83208113,'admin'),(3,'Juan',NULL,NULL,'',NULL,'Carlos','$2a$10$fpZ3pU63UnhsJcAPopsz1.hBzYFe5ptoCXcP4UXkqwv8MBwdHV6x6',7220853,'JUAK'),(4,'Marlon',NULL,NULL,'',NULL,'Perez','$2a$10$IBncau/R54WrXROHE/QEnObji7HOoH5TjrLQSzuJnoVsVlSF73stO',7283113,'MP123');
