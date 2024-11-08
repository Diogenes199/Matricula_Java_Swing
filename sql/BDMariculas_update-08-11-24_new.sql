CREATE DATABASE BDMatriculas;

USE BDMatriculas;

-- Tabla para roles de usuario
CREATE TABLE roles (
  id_rol VARCHAR(10) PRIMARY KEY NOT NULL,
  nombre_rol VARCHAR(50) NOT NULL
);

-- Tabla para usuarios
CREATE TABLE usuarios (
  id_usuario VARCHAR(10) PRIMARY KEY NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  apellido_paterno VARCHAR(100) NOT NULL,
  apellido_materno VARCHAR(100) NOT NULL,
  dni VARCHAR(20) NOT NULL,
  usuario VARCHAR(50) UNIQUE NOT NULL,
  contra VARCHAR(255) NOT NULL,
  celular1 VARCHAR(20),
  celular2 VARCHAR(20),
  direccion VARCHAR(200) NOT NULL,
  id_rol VARCHAR(10) NOT NULL,
  FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);

-- Tabla para tipos de documentos
CREATE TABLE tipos_documentos (
  id_tipo_documento VARCHAR(10) PRIMARY KEY NOT NULL,
  descripcion VARCHAR(50) NOT NULL
);

-- Tabla para clientes (estudiantes)
CREATE TABLE clientes (
  id_cliente VARCHAR(10) PRIMARY KEY NOT NULL,
  id_usuario VARCHAR(10) NOT NULL, 
  tipo_documento VARCHAR(10) NOT NULL, 
  numero_documento VARCHAR(20) UNIQUE NOT NULL,
  sexo VARCHAR(50) NOT NULL, 
  fecha_nacimiento DATE NOT NULL,
  ubigeo VARCHAR(6),
  pais VARCHAR(50),
  departamento VARCHAR(50),
  provincia VARCHAR(50),
  distrito VARCHAR(50),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
  FOREIGN KEY (tipo_documento) REFERENCES tipos_documentos(id_tipo_documento)
);

-- Tabla para cursos
CREATE TABLE cursos (
  id_curso VARCHAR(10) PRIMARY KEY NOT NULL,
  nombre_curso VARCHAR(100) NOT NULL,
  costo_inscripcion DECIMAL(10,2) NOT NULL,
  costo_libro DECIMAL(10,2) NOT NULL
);

-- Tabla para modalidades de clases
CREATE TABLE modalidades (
  id_modalidad VARCHAR(10) PRIMARY KEY NOT NULL,
  descripcion VARCHAR(50) NOT NULL
);

-- Tabla para horarios
CREATE TABLE horarios (
  id_horario VARCHAR(10) PRIMARY KEY NOT NULL,
  dia VARCHAR(10) NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL
);

-- Tabla para matriculas
CREATE TABLE matriculas (
  id_matricula VARCHAR(10) PRIMARY KEY NOT NULL,
  id_cliente VARCHAR(10) NOT NULL,
  id_curso VARCHAR(10) NOT NULL,
  id_modalidad VARCHAR(10) NOT NULL,
  id_horario VARCHAR(10) NOT NULL,
  fecha_inicio DATE NOT NULL,
  costo_total DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  FOREIGN KEY (id_curso) REFERENCES cursos(id_curso),
  FOREIGN KEY (id_modalidad) REFERENCES modalidades(id_modalidad),
  FOREIGN KEY (id_horario) REFERENCES horarios(id_horario)
);

-- Tabla para tipos de comprobantes
CREATE TABLE tipos_comprobantes (
  id_tipo_comprobante VARCHAR(10) PRIMARY KEY NOT NULL,
  descripcion VARCHAR(50) NOT NULL
);

-- Tabla para pagos
CREATE TABLE pagos (
  id_pago VARCHAR(10) PRIMARY KEY NOT NULL,
  id_matricula VARCHAR(10) NOT NULL,
  fecha_pago DATE NOT NULL,
  monto DECIMAL(10,2) NOT NULL,
  detalle VARCHAR(255),
  id_tipo_comprobante VARCHAR(10) NOT NULL,
  numero_comprobante VARCHAR(20) NOT NULL,
  id_usuario_registro VARCHAR(10) NOT NULL, 
  observaciones VARCHAR(200),
  FOREIGN KEY (id_matricula) REFERENCES matriculas(id_matricula),
  FOREIGN KEY (id_tipo_comprobante) REFERENCES tipos_comprobantes(id_tipo_comprobante),
  FOREIGN KEY (id_usuario_registro) REFERENCES usuarios(id_usuario)
);

SELECT * FROM roles;
SELECT * FROM usuarios;
SELECT * FROM tipos_documentos;
SELECT * FROM clientes;
SELECT * FROM cursos;
SELECT * FROM modalidades;
SELECT * FROM horarios;
SELECT * FROM matriculas;
SELECT * FROM tipos_comprobantes;
SELECT * FROM pagos;

-- Inserción de datos en la tabla roles
INSERT INTO roles (id_rol, nombre_rol) VALUES ('R0001', 'Administrador');
INSERT INTO roles (id_rol, nombre_rol) VALUES ('R0002', 'Promotor');

-- Inserción de datos en la tabla usuarios
INSERT INTO usuarios (id_usuario, nombre, apellido_paterno, apellido_materno, dni, usuario, contra, celular1, celular2, direccion, id_rol) 
VALUES ('U0001', 'MASHIEL', 'JUAREZ', 'VARGAS', '12345678', 'ADMIN', '12345', '999999999', '888888888', 'LIMA', 'R0001');
INSERT INTO usuarios (id_usuario, nombre, apellido_paterno, apellido_materno, dni, usuario, contra, celular1, celular2, direccion, id_rol) 
VALUES ('U0002', 'LESNER', 'URBANO', 'ALEJO', '23456789', 'PROMO01', '23451', '777777777', '666666666', 'LIMA', 'R0002');

-- Inserción de datos en la tabla tipos_documentos
INSERT INTO tipos_documentos (id_tipo_documento, descripcion) VALUES ('D0001', 'DNI');
INSERT INTO tipos_documentos (id_tipo_documento, descripcion) VALUES ('D0002', 'CARNE EXTRANJERÍA');

-- Inserción de datos en la tabla clientes
INSERT INTO clientes (id_cliente, id_usuario, tipo_documento, numero_documento, sexo, fecha_nacimiento, ubigeo, pais, departamento, provincia, distrito) 
VALUES ('C0001', 'U0001', 'D0001', '12345678', 'Femenino', '1990-01-01', '150101', 'Peru', 'Lima', 'Lima', 'Miraflores');
INSERT INTO clientes (id_cliente, id_usuario, tipo_documento, numero_documento, sexo, fecha_nacimiento, ubigeo, pais, departamento, provincia, distrito) 
VALUES ('C0002', 'U0002', 'D0002', '87654321', 'Masculino', '1992-02-02', '150102', 'Peru', 'Lima', 'Lima', 'San Isidro');

-- Inserción de datos en la tabla cursos
INSERT INTO cursos (id_curso, nombre_curso, costo_inscripcion, costo_libro) 
VALUES ('CUR0001', 'Inglés Americano', 20.00, 89.00);

-- Inserción de datos en la tabla modalidades
INSERT INTO modalidades (id_modalidad, descripcion) VALUES ('MOD0001', 'Presencial');
INSERT INTO modalidades (id_modalidad, descripcion) VALUES ('MOD0002', 'Virtual');

-- Inserción de datos en la tabla horarios
INSERT INTO horarios (id_horario, dia, hora_inicio, hora_fin) 
VALUES ('H0001', 'Sabados', '08:00:00', '11:00:00');
INSERT INTO horarios (id_horario, dia, hora_inicio, hora_fin) 
VALUES ('H0002', 'Domingos', '11:00:00', '14:00:00');

-- Inserción de datos en la tabla matriculas
INSERT INTO matriculas (id_matricula, id_cliente, id_curso, id_modalidad, id_horario, fecha_inicio, costo_total) 
VALUES ('M0001', 'C0001', 'CUR0001', 'MOD0001', 'H0001', '2025-01-15', 109.00);
INSERT INTO matriculas (id_matricula, id_cliente, id_curso, id_modalidad, id_horario, fecha_inicio, costo_total) 
VALUES ('M0002', 'C0002', 'CUR0001', 'MOD0002', 'H0002', '2025-02-01', 109.00);

-- Inserción de datos en la tabla tipos_comprobantes
INSERT INTO tipos_comprobantes (id_tipo_comprobante, descripcion) VALUES ('TC0001', 'Boleta');
INSERT INTO tipos_comprobantes (id_tipo_comprobante, descripcion) VALUES ('TC0002', 'Factura');

-- Inserción de datos en la tabla pagos
INSERT INTO pagos (id_pago, id_matricula, fecha_pago, monto, detalle, id_tipo_comprobante, numero_comprobante, id_usuario_registro, observaciones) 
VALUES ('P0001', 'M0001', '2024-11-15', 20.00, 'Pago de inscripcion', 'TC0001', 'B00001', 'U0001', 'PAGO LA INSCRIPCION QUEDA PENDIENTE EL PAGO DEL LIBRO');
INSERT INTO pagos (id_pago, id_matricula, fecha_pago, monto, detalle, id_tipo_comprobante, numero_comprobante, id_usuario_registro, observaciones) 
VALUES ('P0002', 'M0002', '2024-11-20', 109.00, 'Pago completo de inscripcion y libro', 'TC0002', 'F00001', 'U0002', 'PAGO LA INSCRIPCION Y LIBRO');

SELECT * FROM roles;
SELECT * FROM usuarios;
SELECT * FROM tipos_documentos;
SELECT * FROM clientes;
SELECT * FROM cursos;
SELECT * FROM modalidades;
SELECT * FROM horarios;
SELECT * FROM matriculas;
SELECT * FROM tipos_comprobantes;
SELECT * FROM pagos;


