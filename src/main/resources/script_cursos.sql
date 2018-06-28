DROP DATABASE IF EXISTS cursos;
CREATE DATABASE IF NOT EXISTS cursos;
USE cursos;

CREATE TABLE profesor (
  id     INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL
) ENGINE=InnoDB;
CREATE TABLE curso (
  id         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  titulo     VARCHAR(50),
  activo     BOOLEAN,
  horas      INT(8),
  nivel      VARCHAR(20),
  idProfesor INT REFERENCES PROFESOR (id)
)ENGINE=InnoDB;

INSERT INTO profesor (nombre) VALUES ('Roberto Canales Mora');
INSERT INTO profesor (nombre) VALUES ('Lorena Sánchez Pérez');
INSERT INTO profesor (nombre) VALUES ('Jesús Velázquez González');
INSERT INTO profesor (nombre) VALUES ('Valeria Arévalo Romero');
INSERT INTO profesor (nombre) VALUES ('José Gutiérrez Jiménez');
INSERT INTO profesor (nombre) VALUES ('Emilia Delgado');
INSERT INTO profesor (nombre) VALUES ('Isabel Toledano Vázquez');
INSERT INTO profesor (nombre) VALUES ('María López González');
INSERT INTO profesor (nombre) VALUES ('Diego Marti Vega');
INSERT INTO profesor (nombre) VALUES ('Berta Santos Ruíz');
INSERT INTO profesor (nombre) VALUES ('Alma Ortiz Méndez');
INSERT INTO profesor (nombre) VALUES ('Isabel Toledano Vázquez');

INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Introducción a JSF2', 1, 25,'Intermedio', 1 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Novedades en Spring 3', 1, 16,'Intermedio', 2 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Java 01', 1, 25,'Básico', 3 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Java 02', 1, 25,'Intermedio', 4 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Java 03', 0, 35,'Avanzado', 5 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Programación reactiva', 1, 45,'Avanzado', 6 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Patrones de diseño', 0, 25,'intermedio', 7 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Servicios REST', 1, 20,'Intermedio', 8 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Arquitectura SOAP', 0, 25,'Avanzado', 9 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Arquitectura SOA', 1, 25,'Avanzado', 9 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('J2EE', 1, 40,'Avanzado', 7 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Java 10', 1, 20,'Intermedio', 2 );
INSERT INTO curso (titulo,activo,horas,nivel,idProfesor) VALUES ('Programación OOP', 1, 15,'Básico', 3 );

CREATE TABLE TEMARIO(
  id    INT(8) PRIMARY KEY REFERENCES CURSO(id),
  nombre VARCHAR(50),
  extension VARCHAR(50),
  bytes MEDIUMBLOB
)ENGINE=InnoDB;