CREATE TABLE categoria (
	id_categoria SERIAL CONSTRAINT PK_CATEGORIA PRIMARY KEY,
	descripcion TEXT
);

CREATE TABLE usuario (
	id_usuario SERIAL PRIMARY KEY,
	nombre VARCHAR(100),
	apellido VARCHAR(100),
	login_name VARCHAR(30),
	password VARCHAR(50),
	tipo_usuario INTEGER 
);


CREATE TABLE producto (
	id_producto SERIAL PRIMARY KEY,
	descripcion VARCHAR(100),
	id_categoria INTEGER,
	precio_unitario INTEGER,
	cantidad INTEGER,
	link_image TEXT,

	CONSTRAINT FK_PRODUCTO_CATEGORIA FOREIGN KEY (id_categoria)
REFERENCES categoria (id_categoria)

);

