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

use `nominas`;
-- ------------------------------------------------
-- DROPS
-- ------------------------------------------------
DROP TABLE IF EXISTS Institucion;
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
-- Institucion
-- ------------------------------------------------
DROP TABLE IF EXISTS Institucion;
CREATE TABLE IF NOT EXISTS Institucion (
    id INT(1) NOT NULL,    
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    imss VARCHAR(100) NOT NULL,
    rfc VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

-- ------------------------------------------------
-- Volcado de datos
-- ------------------------------------------------
-- Institucion
-- ------------------------------------------------
INSERT INTO Institucion VALUES(1, "H. Ayuntamiento de Villanueva 2013 - 2016", 
"Plaza Principal No.1; Col. Centro; Villanueva, Zac.",
"R0910080109",
"MVI-650101-HF1");
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
(`id_empleado`, `nombre`, `apellido`, `email`, `rfc`, `curp`, `imss`, `departamento`, `puesto`, `fecha_ingreso`, `fecha_salida`, `horas_dia`, `dias_jornada`, `nomina`, `salario`) 
VALUES 
(NULL, "JOSE ANTONIO",  "ORTEGA MUÑOZ", "ortegamuñoza@hotmail.com", "OEMA6706046HA", "OEMA670604HDFRXN01", "34876705764", 1, 1, FROM_DAYS(729535), NULL, 8, 15, 1, 436.09),
(NULL, "ANITA",  "MARQUEZ DE AVILA", "anita_marquez90@gmail.com", "MAAA640830HX7", "MAAA640830MZSRVN01", "34876402859", 1, 22, FROM_DAYS(726848), NULL, 8, 15, 1, 399.61),
(NULL, "ARTURO",  "RAMIREZ REVELES", "ramirezarturo@live.com.mx", "RARA661225PS9", "RARA661225HZSMVR03", "34916601213", 1, 7, FROM_DAYS(726864), NULL, 8, 15, 1, 463.24),
(NULL, "MANUEL",  "MORALES CARLOS", "morales_carlos89@hotmail.com", "MOCM6209017P5", "MOCM620901HZSRRN06", "34896401956", 1, 1, FROM_DAYS(726664), NULL, 8, 15, 1, 247.52),
(NULL, "SALVADOR",  "GUTIERREZ MARTINEZ", "chava_gutmar@yahoo.com", "GUMS560917MX4", "GUMS560917HZSTRL01", "34896401956", 1, 1, FROM_DAYS(724427), NULL, 8, 15, 1, 324.76),
(NULL, "RAMON",  "BELMONTES GOMEZ", "belmontesramon30@hotmail.com", "BERG580830NQ5", "BERG580830HZSLMM05", "34795802353", 2, 1, FROM_DAYS(726542), NULL, 8, 15, 2, 271.14),
(NULL, "JESUS MANUEL",  "ROJAS VAZQUEZ", "rojas_vaz_jesus@gmail.com.mx", "ROVJ7003204J6", "ROVJ700320HZSJSS03", "34927001841", 2, 1, FROM_DAYS(727698), NULL, 8, 15, 2, 296.16),
(NULL, "JUAN",  "RAYGOZA SANDOVAL", "raygozajuanito67@hotmail.com.mx", "RASJ670608BZ0", "RASJ670608HASYNN08", "34906703771", 2, 1, FROM_DAYS(726680), NULL, 8, 15, 2, 278.62),
(NULL, "FLAVIO",  "NUÑEZ ROSAS", "nunes_rosas_flavio@yahoo.com.mx", "NURF6402229G5", "NURF640222HZSXSL09", "34816211774", 2, 7, FROM_DAYS(724701), NULL, 8, 15, 3, 360.53),
(NULL, "LUIS MARTIN RENE",  "RAYGOZA SANCHEZ", "raigosaluisrene69@live.com", "RASL690129IDI", "RASL690129HZSYNS08", "34926902064", 2, 1, FROM_DAYS(727046), NULL, 8, 15, 2, 473.12),
(NULL, "RAUL",  "AGUAYO MARTINEZ", "raulaguayo68@hotmail.com", "AUMR680501RK9", "AUMR680501HDFGRL07", "34926801761", 3, 1, FROM_DAYS(724471), NULL, 8, 15, 2, 306.65),
(NULL, "MARTHA",  "PUENTE GOMEZ", "martha_puente65@hotmail.com", "PEGM650116IT4", "PEGM650116MZSNMR06", "34836510726", 3, 1, FROM_DAYS(726468), NULL, 8, 15, 4, 474.82),
(NULL, "RAMON",  "VARGAS FRAUSTO", "ramonfrausto@live.com.mx", "VAFR650831851", "VAFR650831HZSRRM08", "34876502021", 3, 7, FROM_DAYS(725676), NULL, 8, 15, 3, 413.44),
(NULL, "OMAR",  "MONTOYA FLORES", "montoyafloresomar74@gmail.com", "MOFO740822K85", "MOFO740822HZSNLM01", "34897495163", 3, 1, FROM_DAYS(730285), NULL, 8, 15, 4, 443.44),
(NULL, "CARLOS AUGUSTO",  "SORIANO ALVAREZ", "soriano_carlitros09@hotmail.com", "SOAC77091476A", "SOAC770914HASRLR01", "34957701039", 3, 1, FROM_DAYS(728987), NULL, 8, 15, 4, 305.76),
(NULL, "PEDRO",  "MUÑOZ SORIANO", "munospedrinsoriano@yahoo.com", "MUSP710607PM2", "MUSP710607HZSXRD00", "34137100821", 4, 2, FROM_DAYS(734899), NULL, 8, 15, 4, 174.29),
(NULL, "RUBEN",  "CABRERA MARQUEZ", "cabreramarruben68@hotmail.com", "CAMR680109UV7", "CAMR680109HZSBRB00", "34926801902", 4, 3, FROM_DAYS(724655), NULL, 8, 15, 5, 318.92),
(NULL, "MA. DEL REFUGIO",  "MEJIA MIRANDA", "mejia_miranda_ma@live.com", "MEMM640322T12", "MEMM640322MZSJRF03", "34926401315", 4, 1, FROM_DAYS(724624), NULL, 8, 15, 5, 231.05),
(NULL, "ENGRACIA",  "MEJIA MIRANDA", "mejia_miranda_engra@hotmail.com", "MEME5908264S6", "MEME590826MZSJRN07", "34865900103", 4, 1, FROM_DAYS(725363), NULL, 8, 15, 5, 256.56),
(NULL, "MARTHA ",  "ORTEGA RUIZ", "ortegaruizmartha@hotmail.com", "OERM750105S22", "OERM750105MDFRZR00", "34927503572", 4, 22, FROM_DAYS(727659), NULL, 8, 15, 5, 183.98),
(NULL, "BEATRIZ",  "GONZALEZ BERMUDEZ", NULL, "GOBB7903233B5", "GOBB790323MZSNRT02", "34937902723", 4, 22, FROM_DAYS(730019), NULL, 8, 15, 5, 291.2),
(NULL, "J GUADALUPE",  "FLORES MARQUEZ", NULL, "FOMJ301228HQ2", "FOMJ301228HZSRLX09", "34993000107", 4, 6, FROM_DAYS(728917), NULL, 8, 15, 6, 194.98),
(NULL, "JUAN LUIS",  "IBARRA ESCAREÑO", NULL, "IAEJ700829JXA", "IAEJ700829HZSBSN08", "34947002787", 4, 7, FROM_DAYS(729024), NULL, 8, 15, 3, 252.87),
(NULL, "BENJAMIN",  "GONZALEZ DELGADO", NULL, "GODB530107IE7", "GODB530107HZSNLN01", "34005300651", 4, 24, FROM_DAYS(730755), NULL, 8, 15, 6, 215.27),
(NULL, "JAVIER",  "GONZALEZ RAMIREZ", NULL, "GORJ711229Q92", "GORJ711229HZSNMV15", "34007102727", 4, 25, FROM_DAYS(730073), NULL, 8, 15, 6, 260.72),
(NULL, "RAMON",  "DE LOERA VARGAS", NULL, "LOVR581202UK0", "LOVR581202HZSRRM09", "34815902450", 5, 7, FROM_DAYS(727438), NULL, 8, 15, 3, 204.35),
(NULL, "JAIME ",  "CARLOS GARCIA", NULL, "CAGJ580301JT1", "CAGJ580301HZSRRM07", "54835840817", 5, 1, FROM_DAYS(730531), NULL, 8, 15, 6, 197.1),
(NULL, "MARIA DE JESUS",  "AGUILAR RODARTE", NULL, "AURJ680701GU2", "AURJ680701MZSGDS05", "34916800914", 5, 1, FROM_DAYS(726848), NULL, 8, 15, 7, 380.43),
(NULL, "MANUEL",  "SOTO SANCHEZ", NULL, "SOSM790729R22", "SOSM790729HZSTNN03", "34007903361", 5, 1, FROM_DAYS(730014), NULL, 8, 15, 7, 204.36),
(NULL, "ARACELI",  "ESCAREÑO ROSALES", NULL, "EARA7306039Z2", "EARA730603MZSSSR03", "34937303369", 5, 1, FROM_DAYS(727975), NULL, 8, 15, 7, 438.82),
(NULL, "ANA LILIA",  "QUIROZ RIOS", NULL, "QURA720125AK4", "QURA720125MZSRSN02", "34927201870", 5, 22, FROM_DAYS(727177), NULL, 8, 15, 7, 434.01),
(NULL, "SAMUEL",  "SANCHEZ VILLAGRANA", NULL, "SAVS730825K19", "SAVS730825HZSNLM04", "34897300249", 5, 11, FROM_DAYS(730015), NULL, 8, 15, 8, 362.27),
(NULL, "ANA MARGARITA",  "RODRIGUEZ MURO", NULL, "ROMA690611FE4", "ROMA690611MZSDRN05", "34866900250", 6, 8, FROM_DAYS(726108), NULL, 8, 15, 3, 363.69),
(NULL, "LUIZ MARIA",  "RAMIREZ HERNANDEZ", NULL, "RAHL770323AN6", "RAHL770323MZSMRZ08", "34967705475", 6, 22, FROM_DAYS(730013), NULL, 8, 15, 1, 340.02),
(NULL, "MARIA LOURDES",  "RODRIGUEZ PEREZ", NULL, "ROPL6707265F6", "ROPL670726MZSDRR01", "34856700322", 6, 1, FROM_DAYS(725007), NULL, 8, 15, 2, 439.31),
(NULL, "MARIA DEL SOCORRO",  "REVELES ROBLES", NULL, "RERS760210DT7", "RERS760210MZSVBC05", "34947605263", 7, 8, FROM_DAYS(730013), NULL, 8, 15, 3, 288.76),
(NULL, "ANA LUZ",  "SANCHEZ GONZALEZ", NULL, "SAGA6907246H4", "SAGA690724MZSNNN00", "34907006687", 7, 1, FROM_DAYS(726849), NULL, 8, 15, 7, 266.47),
(NULL, "LEONARDO",  "DE LOERA REVELES", NULL, "LORL540820S15", "LORL540820HZSRVN05", "34975400168", 8, 7, FROM_DAYS(730894), NULL, 8, 15, 3, 189.26),
(NULL, "MARIA ELENA",  "CHAVEZ TORRES", NULL, "CATE7503235GA", "CATE750323MZSHRL09", "34907563352", 8, 1, FROM_DAYS(729343), NULL, 8, 15, 6, 425.42),
(NULL, "YOLANDA",  "ROBLES REVELES", NULL, "RORY710615LM1", "RORY710615MZSBVL08", "34907108533", 9, 8, FROM_DAYS(726880), NULL, 8, 15, 3, 434.01),
(NULL, "FRANCIS DIANNE",  "RENTERIA RODRIGUEZ", NULL, "RERF750314G75", "RERF7850314MZSNDR00", "34927502145", 9, 22, FROM_DAYS(727199), NULL, 8, 15, 9, 474.12),
(NULL, "MARIA DEL REFUGIO",  "PADILLA DE SANTIAGO", NULL, "PASR7107036P2", "PASR710703MZSDNF09", "34927101294", 10, 8, FROM_DAYS(726878), NULL, 8, 15, 3, 467.25),
(NULL, "MARTIN",  "ROJAS NUÑEZ", NULL, "RONM630217CE7", "RONM630217HJCJXR09", "34966300252", 10, 1, FROM_DAYS(727646), NULL, 8, 15, 4, 173.05),
(NULL, "DANTE",  "VILLALOBOS FLORES", NULL, "VIFD790224K81", "VIFD790224HASLLN02", "34987914800", 11, 7, FROM_DAYS(734899), NULL, 8, 15, 3, 177.55),
(NULL, "HILARIO",  "CABRERA SANCHEZ", NULL, "CASH730426Q42", "CASH730426HZSBNL08", "34977302172", 11, 14, FROM_DAYS(730286), NULL, 8, 15, 5, 216.66),
(NULL, "ANGEL",  "CAMPOS DAVILA", NULL, "CADA651001G93", "CADA651001HZSMVN07", "34866502387", 12, 7, FROM_DAYS(727941), NULL, 8, 15, 3, 212.72),
(NULL, "RAMIRO",  "AGUAYO MARTINEZ", NULL, "AUMR630830KD3", "AUMR630830HDFGRM05", "34906300370", 12, 1, FROM_DAYS(726663), NULL, 8, 15, 6, 331.59),
(NULL, "MARIO",  "LOZANO HUERTA", NULL, "LOHM630822PY4", "LOHM630822HZSZRR08", "34886301794", 13, 7, FROM_DAYS(727016), NULL, 8, 15, 3, 349.44),
(NULL, "LIBRADA ",  "CERROS MARQUEZ", NULL, "CEML620818AG8", "CEML620818MZSRRB02", "34836200963", 13, 1, FROM_DAYS(731674), NULL, 8, 15, 5, 181.49),
(NULL, "GUSTAVO",  "GRANADOS CALVILLO", NULL, "GACG801215IT4", "GACG801215HZSRLS06", "34038002779", 14, 7, FROM_DAYS(732874), NULL, 8, 15, 3, 176.79),
(NULL, "SANTIAGO ERNESTO",  "RODRIGUEZ PACHECO", NULL, "ROPS8304017G2", "ROPS830401HZSDCN02", "34078301016", 14, 1, FROM_DAYS(732295), NULL, 8, 15, 5, 321.05),
(NULL, "JAIME ",  "MEDINA PALOS", NULL, "MEPJ710114BY2", "MEPJ710114HZSDLM00", "34087100730", 14, 1, FROM_DAYS(734000), NULL, 8, 15, 4, 129.64),
(NULL, "ELISA",  "RODRIGUEZ MENDEZ", NULL, "ROME800923GF4", "ROME800923MZSDNL09", "34138001283", 15, 8, FROM_DAYS(735359), NULL, 8, 15, 3, 182.18),
(NULL, "ANTONIO",  "CALDERA MARTINEZ", NULL, "CAMA6001208K7", "CAMA600120HZSLRN09", "34806102322", 15, 1, FROM_DAYS(734882), NULL, 8, 15, 7, 310.63),
(NULL, "JOSE ALBERTO",  "SANTACRUZ GARCIA", NULL, "SAGA730420G98", "SAGA730420HZSNRL17", "34067300151", 15, 1, FROM_DAYS(732311), NULL, 8, 15, 1, 170.37),
(NULL, "GILLERMO",  "RODRIGUEZ HERRERA", NULL, "ROHG731022AN0", "ROHG731022HMCDRL00", "92937392667", 16, 7, FROM_DAYS(732017), NULL, 8, 15, 3, 170.37),
(NULL, "SALVADOR ",  "LOPEZ ALONSO", NULL, "LOAS450507FA5", "LOAS450507HZSPLL04", "06654512158", 16, 1, FROM_DAYS(732953), NULL, 8, 15, 7, 170.36),
(NULL, "MARGARITO",  "RODRIGUEZ JIMENEZ", NULL, "ROJM730828RD6", "ROJM730828HZSDMR01", "34917390212", 17, 7, FROM_DAYS(732892), NULL, 8, 15, 3, 170.36),
(NULL, "HERMELINDA",  "MUÑOZ DE LOERA", NULL, "MULH741202SG9", "MULH741202HZSRVL02", "34117400365", 17, 1, FROM_DAYS(734300), NULL, 8, 15, 7, 162),
(NULL, "FERMIN",  "UREÑO MARIN", NULL, "UEMF690519DX9", "UEMF690519HZSRRR02", "4866702246", 17, 22, FROM_DAYS(734503), NULL, 8, 15, 7, 152.65),
(NULL, "ANDRES",  "BELMONTES CHAVEZ", NULL, "BECA601201LA1", "BECA601201HZSLHN01", "34866001331", 18, 7, FROM_DAYS(732638), NULL, 8, 15, 3, 230.38),
(NULL, "MARIO",  "HERNADEZ DURAN", NULL, "HEDM771020RS4", "HEDM771020HZSRRR09", "34117700442", 18, 1, FROM_DAYS(734553), NULL, 8, 15, 6, 152.65),
(NULL, "OVAD CESAR",  "ECHEVERRIA HERNANDEZ", NULL, "EEHO770310CG4", "EEHO770310HDFCRV06", "34007704363", 19, 7, FROM_DAYS(734562), NULL, 8, 15, 3, 152.65),
(NULL, "ROSENDO",  "MARTINEZ MENDOZA", NULL, "MAMR750201T90", "MAMR750201HZSRNS07", "34917516485", 19, 22, FROM_DAYS(734534), NULL, 8, 15, 5, 152.65),
(NULL, "AGUSTIN",  "ECHEVERRIA HERNANDEZ", NULL, "EEHA750824DC3", "EEHA750824HDFCRG04", "34987501415", 19, 1, FROM_DAYS(734868), NULL, 8, 15, 5, 152.65),
(NULL, "BEATRIZ ADRANA",  "ROBLES MIRAMONTES", NULL, "ROMB810710MB1", "ROMB810710MJCBRT04", "34988302781", 19, 1, FROM_DAYS(735083), NULL, 8, 15, 5, 152.65),
(NULL, "MANUEL DE JESUS",  "RIVERA MARQUEZ", NULL, "RIMM8612247H3", "RIMM861224MZSVRN05", "34128603494", 20, 1, FROM_DAYS(735004), NULL, 8, 15, 6, 152.65);
