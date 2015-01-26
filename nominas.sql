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
-- Volcado de datos
-- ------------------------------------------------
-- Usuario
-- ------------------------------------------------
INSERT INTO User VALUES('ivxn2309', SHA('password'), 1);
INSERT INTO User VALUES('pepe', SHA('password'), 0);
