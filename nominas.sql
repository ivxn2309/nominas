-- =====================================================
-- Nominas BD
-- Creado el 15/01/2015
-- =====================================================
-- ------------------------------------------------
-- Definición de usuario
-- ------------------------------------------------
SELECT PASSWORD('nomina2015');
CREATE USER 'gestor_nominas' IDENTIFIED BY PASSWORD '*915B119C8FFE36DE8E242DD40ABF0EB3D6D12637';
-- ------------------------------------------------
-- Definición de base de  datos y permisos para el usuario
-- ------------------------------------------------
CREATE DATABASE `nominas` CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON `nominas`.* TO `gestor_nominas`@localhost IDENTIFIED BY 'nomina2015';
FLUSH PRIVILEGES;

-- ------------------------------------------------
-- DROPS
-- ------------------------------------------------
DROP TABLE IF EXISTS Percepciones;
DROP TABLE IF EXISTS Deducciones;
DROP TABLE IF EXISTS Empleados;
DROP TABLE IF EXISTS ListaNominas;
DROP TABLE IF EXISTS Puestos;
DROP TABLE IF EXISTS Departamentos;
DROP TABLE IF EXISTS User;

-- ------------------------------------------------
-- Usuario
-- ------------------------------------------------
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    username VARCHAR(64) NOT NULL,
    password VARCHAR(100) NOT NULL,
    usertype INT(1) NOT NULL,
    PRIMARY KEY(username)
);
-- ------------------------------------------------
-- Departamentos
-- ------------------------------------------------
DROP TABLE IF EXISTS Departamentos;
CREATE TABLE IF NOT EXISTS Departamentos (
    id_dep INT(4) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_dep)
);
-- ------------------------------------------------
-- Funciones de Personal
-- ------------------------------------------------
DROP TABLE IF EXISTS Puestos;
CREATE TABLE IF NOT EXISTS Puestos (
    id_puesto INT(4) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_puesto)
);
-- ------------------------------------------------
-- Nominas Existentes
-- ------------------------------------------------
DROP TABLE IF EXISTS ListaNominas;
CREATE TABLE IF NOT EXISTS ListaNominas (
    id INT(4) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);
-- ------------------------------------------------
-- Empleados
-- ------------------------------------------------
DROP TABLE IF EXISTS Empleados;
CREATE TABLE IF NOT EXISTS Empleados (
    id_empleado INT(8) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    rfc VARCHAR(100),
    curp VARCHAR(100),
    imss VARCHAR(100),
    departamento INT(4),
    puesto INT(4),
    fecha_ingreso DATE NOT NULL,
    fecha_salida DATE,
    horas_dia INT(2),
    dias_jornada INT(2),
    nomina INT(4),
    salario DECIMAL(8,2),
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(departamento) REFERENCES Departamentos(id_dep),
    FOREIGN KEY(puesto) REFERENCES Puestos(id_puesto),
    FOREIGN KEY(nomina) REFERENCES ListaNominas(id)
);

-- ------------------------------------------------
-- Deducciones
-- ------------------------------------------------
DROP TABLE IF EXISTS Deducciones;
CREATE TABLE IF NOT EXISTS Deducciones (
    id_deduccion INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    empleado INT(8) NOT NULL,
    cantidad DECIMAL(8,2) NOT NULL,
    fecha DATE NOT NULL,
    fin DATE,
    PRIMARY KEY(id_deduccion),
    FOREIGN KEY(empleado) REFERENCES Empleados(id_empleado)
);

-- ------------------------------------------------
-- Perecepciones
-- ------------------------------------------------
DROP TABLE IF EXISTS Percepciones;
CREATE TABLE IF NOT EXISTS Percepciones (
    id_percepcion INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    empleado INT(8) NOT NULL,
    cantidad DECIMAL(8,2) NOT NULL,
    fecha DATE NOT NULL,
    fin DATE,
    PRIMARY KEY(id_percepcion),
    FOREIGN KEY(empleado) REFERENCES Empleados(id_empleado)
);

-- ------------------------------------------------
-- Volcado de datos
-- ------------------------------------------------
-- Usuario
-- ------------------------------------------------
INSERT INTO User VALUES('ivxn2309', SHA('password'), 1);
INSERT INTO User VALUES('pepe', SHA('password'), 0);
-- ------------------------------------------------
-- Departamentos
-- ------------------------------------------------
INSERT INTO Departamentos VALUES(1, "Secretaria");
INSERT INTO Departamentos VALUES(2, "Tesoreria");
INSERT INTO Departamentos VALUES(3, "Contabilidad");
INSERT INTO Departamentos VALUES(4, "Obras Publicas");
INSERT INTO Departamentos VALUES(5, "Desarrollo Economico");
INSERT INTO Departamentos VALUES(6, "Recursos Materiales");
INSERT INTO Departamentos VALUES(7, "Gestion Social y Apoyo a Migrantes");
INSERT INTO Departamentos VALUES(8, "Procuraduria del Dif");
INSERT INTO Departamentos VALUES(9, "Oportunidades");
INSERT INTO Departamentos VALUES(10, "Contraloria");
INSERT INTO Departamentos VALUES(11, "Ecologia");
INSERT INTO Departamentos VALUES(12, "Educacion");
INSERT INTO Departamentos VALUES(13, "Proyectos");
INSERT INTO Departamentos VALUES(14, "Agropecuario");
INSERT INTO Departamentos VALUES(15, "Inmuvi");
INSERT INTO Departamentos VALUES(16, "Injuvi");
INSERT INTO Departamentos VALUES(17, "Turismo");
INSERT INTO Departamentos VALUES(18, "Sindicatura");
INSERT INTO Departamentos VALUES(19, "Catastro");
INSERT INTO Departamentos VALUES(20, "Deporte");
INSERT INTO Departamentos VALUES(21, "Recursos Humanos");
INSERT INTO Departamentos VALUES(22, "Juridico");
INSERT INTO Departamentos VALUES(23, "Dif Municipal");
INSERT INTO Departamentos VALUES(24, "Casa De Cultura");
INSERT INTO Departamentos VALUES(25, "Bibliotecas");
INSERT INTO Departamentos VALUES(26, "Seguridad Publica");
INSERT INTO Departamentos VALUES(27, "Proteccion Civil");
-- ------------------------------------------------
-- Funciones de Personal
-- ------------------------------------------------
INSERT INTO Puestos VALUES(1, "Auxiliar");
INSERT INTO Puestos VALUES(2, "Fontanero");
INSERT INTO Puestos VALUES(3, "Chofer");
INSERT INTO Puestos VALUES(4, "Jardinero");
INSERT INTO Puestos VALUES(5, "Mecanico");
INSERT INTO Puestos VALUES(6, "Carpintero");
INSERT INTO Puestos VALUES(7, "Director");
INSERT INTO Puestos VALUES(8, "Directora");
INSERT INTO Puestos VALUES(9, "Encargada");
INSERT INTO Puestos VALUES(10, "Encargado");
INSERT INTO Puestos VALUES(11, "Subdirector");
INSERT INTO Puestos VALUES(12, "Subdirectora");
INSERT INTO Puestos VALUES(13, "Oficial");
INSERT INTO Puestos VALUES(14, "Intendente");
INSERT INTO Puestos VALUES(15, "Archivista");
INSERT INTO Puestos VALUES(16, "Bibliotecaria");
INSERT INTO Puestos VALUES(17, "Bibliotecario");
INSERT INTO Puestos VALUES(18, "Vulcanizadora");
INSERT INTO Puestos VALUES(19, "Cargador De Rastro");
INSERT INTO Puestos VALUES(20, "Tabla Rastro");
INSERT INTO Puestos VALUES(21, "Peon");
INSERT INTO Puestos VALUES(22, "Secretaria");
INSERT INTO Puestos VALUES(23, "Secretario");
INSERT INTO Puestos VALUES(24, "Velador");
INSERT INTO Puestos VALUES(25, "Electricista");
INSERT INTO Puestos VALUES(26, "Presidente Municipal");
INSERT INTO Puestos VALUES(27, "Sindica");
INSERT INTO Puestos VALUES(28, "Secretario De Gobierno");
-- ------------------------------------------------
-- Nominas Existentes
-- ------------------------------------------------
INSERT INTO ListaNominas VALUES(1, "Sindicato");
INSERT INTO ListaNominas VALUES(2, "Seguridad Publica");
INSERT INTO ListaNominas VALUES(3, "Jefes");
INSERT INTO ListaNominas VALUES(4, "H. Ayuntamiento");
INSERT INTO ListaNominas VALUES(5, "Base");
INSERT INTO ListaNominas VALUES(6, "Confianza");
INSERT INTO ListaNominas VALUES(7, "Contrato");
INSERT INTO ListaNominas VALUES(8, "Nuevo Ingreso");
INSERT INTO ListaNominas VALUES(9, "Obras Publicas Gasto Corriente");
INSERT INTO ListaNominas VALUES(10, "Obras Publicas P.M.O. ");
INSERT INTO ListaNominas VALUES(11, "Ecologia Servicio De Limpia");
INSERT INTO ListaNominas VALUES(12, "Ecologia Hormiguitas");
INSERT INTO ListaNominas VALUES(13, "Dif Municipal");
INSERT INTO ListaNominas VALUES(14, "Casa De Cultura");
INSERT INTO ListaNominas VALUES(15, "Pensionados");

-- -----------------------------------------------------------
-- Testing
-- -----------------------------------------------------------
INSERT INTO `nominas`.`empleados` 
(`id_empleado`, `nombre`, `apellido`, `email`, `rfc`, `imss`, `departamento`, `puesto`, `fecha_ingreso`, `horas_dia`, `dias_jornada`, `nomina`, `salario`, `curp`) 
VALUES 
(NULL, 'Juan', 'Perez', 'juanito@yahoo.com', 'PEPE12345678', '234567890-1', '5', '1', '2015-01-12', '5', '15', '7', '150', 'PEPE12345678'),
(NULL, 'Lupe', 'Gonzales', 'lupita@yahoo.com', 'GPEL12345678', '234517890-1', '4', '8', '2015-01-12', '8', '14', '2', '100', 'GPEL12345678'),
(NULL, 'Pedro', 'Stalling', 'pedrito@yahoo.com', 'STAP12345678', '233567890-1', '6', '7', '2015-01-12', '8', '10', '7', '110', 'adri@yahoo.com'),
(NULL, 'Adrian', 'Fernandez', 'adri@yahoo.com', 'FEAS12345678', '2343267890-1', '5', '10', '2015-01-12', '8', '15', '3', '120', 'FEAS12345678'),
(NULL, 'Jorge', 'Jimenez', 'george@yahoo.com', 'JITJ12345678', '234987890-1', '4', '10', '2015-01-12', '8', '15', '3', '120', 'JITJ12345678'),
(NULL, 'Pepe', 'Veraz', 'pepitoveraz@yahoo.com', 'VEPE12345678', '234501790-1', '1', '10', '2015-01-12', '8', '15', '3', '120', 'VEPE12345678'), 
(NULL, 'Lorenzo', 'Morales', 'lencho_mora@yahoo.com', 'MOLO12345678', '385567890-1', '1', '10', '2015-01-12', '8', '5', '3', '120', 'MOLO12345678'), 
(NULL, 'Ivan', 'Tovar', 'ivxn2309@hotmail.com', 'TOVF12345678', '234560967-1', '5', '10', '2015-01-12', '8', '15', '5', '190', 'TOVF920923HZSV00R2'), 
(NULL, 'Filigonio', 'Garcia', 'filiga@yahoo.com', 'GAFI123456789', '15356689-3', '8', '5', '2014-08-05', '8', '10', '2', '100', 'GAFI123456789');