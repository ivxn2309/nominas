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