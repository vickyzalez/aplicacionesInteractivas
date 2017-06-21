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
	
	CONSTRAINT pk_codigo PRIMARY KEY (codigo),
	CONSTRAINT uk_socio UNIQUE (codigo, dniSocio),
	CONSTRAINT uk_abono UNIQUE (codigo, codAbono),
	CONSTRAINT uk_empresa UNIQUE (codigo, codEmpresa),
)

create table Empresas(
	codigo int ,
	descripcion varchar(30),
	
	CONSTRAINT pk_codigo PRIMARY KEY (codigo)
)

create table Abonos(
	codigo int ,
	nombre varchar(30),
	precio float,
	vigencia date,
	
	CONSTRAINT pk_codigo PRIMARY KEY (codigo),
