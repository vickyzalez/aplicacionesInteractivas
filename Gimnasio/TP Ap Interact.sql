create table Socios(
	dni int ,
	nombre varchar(30),
	apellido varchar(30),
	domicilio varchar(30),
	telefono varchar(30),
	mail varchar(30),
	fechaCertificado varchar(30),
	nombreProfesional varchar(30),
	observaciones varchar(30),
	codigoIns int,
	
	CONSTRAINT pk_dni PRIMARY KEY (dni),
	CONSTRAINT uk_instituto UNIQUE (dni, codigoIns)
	
)

create table Inscripciones(
	codigo int ,
	dniSocio int,
	codAbono int,
	codEmpresa int,
	fecha date,
	
	CONSTRAINT pk_codIns PRIMARY KEY (codigo),
	CONSTRAINT uk_socio UNIQUE (codigo, dniSocio),
	CONSTRAINT uk_abono UNIQUE (codigo, codAbono),
	CONSTRAINT uk_empresa UNIQUE (codigo, codEmpresa),
)

create table Empresas(
	codigo int ,
	descripcion varchar(30),
	
	CONSTRAINT pk_codEmpresa PRIMARY KEY (codigo)
)

create table Abonos(
	codigo int ,
	nombre varchar(30),
	precio float,
	vigencia date,
	
	CONSTRAINT pk_codAbono PRIMARY KEY (codigo),
)


create table DiaSemana(
	codigo int ,
	nombre varchar(30),
	
	CONSTRAINT pk_codSemana PRIMARY KEY (codigo),
)

insert into DiaSemana VALUES (1,'Lunes')
insert into DiaSemana VALUES (2,'Martes')
insert into DiaSemana VALUES (3,'Miercoles')
insert into DiaSemana VALUES (4,'Jueves')
insert into DiaSemana VALUES (5,'Viernes')
insert into DiaSemana VALUES (6,'Sabado')
insert into DiaSemana VALUES (7,'Domingo')

create table Contratados(
	dni int ,
	nombre varchar(30),
	apellido varchar(30),
	domicilio varchar(30),
	mail varchar(30),
	sueldo float,
	retencion float,
	impuesto float,
	tipo varchar(15),
	valorHora float,
	
	
	CONSTRAINT pk_codContratado PRIMARY KEY (dni),
)


create table Deportes(
	codigo int ,
	titulo varchar(30),
	descripcion varchar(50),
	
	
	CONSTRAINT pk_codDeporte PRIMARY KEY (codigo),
)

create table Actividades(
	idDep int,
	codigo int ,
	descripcion varchar(50),
	profesorCodigo int,
	
	
	CONSTRAINT pk_codActividad PRIMARY KEY (codigo),
)

create table Deporte_Actividad(
	codigoDeporte int,
	codigoActividad int,
	
	
	CONSTRAINT pk_coddepact PRIMARY KEY (codigoDeporte, codigoActividad),
	

)

create table Clases(
	idAct int,
	idClase int,
	horaDesde int,
	horaHasta int,
	idDia int,
	
	
	CONSTRAINT pk_codClase PRIMARY KEY (idClase),
)

create table Actividad_Clase(
	codigoActividad int,
	codigoClase int,
	
	
	CONSTRAINT pk_codactclas PRIMARY KEY (codigoActividad, codigoClase),
	

)

create table Inscripcion_Clase(
	codigoInscripcion int,
	codigoClase int,
	
	
	CONSTRAINT pk_codinsclas PRIMARY KEY (codigoInscripcion , codigoClase),
	

)
