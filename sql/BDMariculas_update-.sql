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
  tipo_documento VARCHAR(10) NOT NULL,
  numero_documento VARCHAR(20) UNIQUE NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellido_paterno VARCHAR(100) NOT NULL,
  apellido_materno VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  celular1 VARCHAR(20),
  celular2 VARCHAR(20),
  sexo VARCHAR(50) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  ubigeo VARCHAR(6),
  pais VARCHAR(50),
  departamento VARCHAR(50),
  provincia VARCHAR(50),
  distrito VARCHAR(50),
  id_usuario_registro VARCHAR(10) NOT NULL,
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (tipo_documento) REFERENCES tipos_documentos(id_tipo_documento),
  FOREIGN KEY (id_usuario_registro) REFERENCES usuarios(id_usuario)
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
  id_usuario_registro VARCHAR(10) NOT NULL,
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  FOREIGN KEY (id_curso) REFERENCES cursos(id_curso),
  FOREIGN KEY (id_modalidad) REFERENCES modalidades(id_modalidad),
  FOREIGN KEY (id_horario) REFERENCES horarios(id_horario),
  FOREIGN KEY (id_usuario_registro) REFERENCES usuarios(id_usuario)
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
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  observaciones VARCHAR(200),
  igv DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (id_matricula) REFERENCES matriculas(id_matricula),
  FOREIGN KEY (id_tipo_comprobante) REFERENCES tipos_comprobantes(id_tipo_comprobante),
  FOREIGN KEY (id_usuario_registro) REFERENCES usuarios(id_usuario)
);

CREATE TABLE devoluciones (
  id_devolucion VARCHAR(10) PRIMARY KEY NOT NULL,
  id_pago VARCHAR(10) NOT NULL,
  fecha_devolucion DATE NOT NULL,
  monto_devuelto DECIMAL(10,2) NOT NULL,
  motivo VARCHAR(255),
  id_usuario_autorizacion VARCHAR(10) NOT NULL,
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_pago) REFERENCES pagos(id_pago),
  FOREIGN KEY (id_usuario_autorizacion) REFERENCES usuarios(id_usuario)
);

-- Insertar datos en la tabla roles
INSERT INTO roles (id_rol, nombre_rol) VALUES 
('ROL001', 'Administrador'),
('ROL002', 'Promotor');

-- Verificar datos en la tabla roles
SELECT * FROM roles;

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (id_usuario, nombre, apellido_paterno, apellido_materno, dni, usuario, contra, celular1, celular2, direccion, id_rol) VALUES 
('USR001', 'LESNER', 'URBANO', 'ALEJO', '12345678', 'ADMIN', '12345', '987654321', '912345678', 'EL AGUSTINO', 'ROL001'),
('USR002', 'MASHIEL', 'JUAREZ', 'VARGAS', '87654321', 'PROMOTOR', '12345', '998765432', NULL, 'LOS OLIVOS', 'ROL002');

-- Verificar datos en la tabla usuarios
SELECT * FROM usuarios;

-- Insertar datos en la tabla tipos_documentos
INSERT INTO tipos_documentos (id_tipo_documento, descripcion) VALUES 
('DOC001', 'DNI'),
('DOC002', 'Pasaporte');

-- Verificar datos en la tabla tipos_documentos
SELECT * FROM tipos_documentos;

-- Insertar datos en la tabla clientes
INSERT INTO clientes (id_cliente, tipo_documento, numero_documento, nombres, apellido_paterno, apellido_materno, email, celular1, celular2, sexo, fecha_nacimiento, ubigeo, pais, departamento, provincia, distrito, id_usuario_registro) VALUES 
('C000001', 'DOC001', '12345678', 'Juan', 'Ramirez', 'Sanchez', 'juan.ramirez@gmail.com', '912345678', '987654321', 'Masculino', '1990-05-15', '150101', 'Perú', 'Lima', 'Lima', 'San Isidro', 'USR001'),
('C000002', 'DOC002', 'A1234567', 'Maria', 'Lopez', 'Gonzales', 'maria.lopez@hotmail.com', '912345679', NULL, 'Femenino', '1985-09-20', '150102', 'Perú', 'Lima', 'Lima', 'Miraflores', 'USR002');

-- Verificar datos en la tabla clientes
SELECT * FROM clientes;

-- Insertar datos en la tabla cursos
INSERT INTO cursos (id_curso, nombre_curso, costo_inscripcion, costo_libro) VALUES 
('CUR001', 'Inglés Básico Escolares', 20.00, 89.00),
('CUR002', 'Inglés Básico Adultos', 20.00, 89.00);

-- Verificar datos en la tabla cursos
SELECT * FROM cursos;

-- Insertar datos en la tabla modalidades
INSERT INTO modalidades (id_modalidad, descripcion) VALUES 
('MOD001', 'Presencial'),
('MOD002', 'Virtual');

-- Verificar datos en la tabla modalidades
SELECT * FROM modalidades;

-- Insertar datos en la tabla horarios
INSERT INTO horarios (id_horario, dia, hora_inicio, hora_fin) VALUES 
('HOR001', 'Sabados', '08:00:00', '11:00:00'),
('HOR002', 'Domingos', '08:00:00', '11:00:00');

-- Verificar datos en la tabla horarios
SELECT * FROM horarios;

-- Insertar datos en la tabla matriculas
INSERT INTO matriculas (id_matricula, id_cliente, id_curso, id_modalidad, id_horario, fecha_inicio, costo_total, id_usuario_registro) VALUES 
('MAT000001', 'C000001', 'CUR001', 'MOD001', 'HOR001', '2024-11-15', 109.00, 'USR001'),
('MAT000002', 'C000002', 'CUR002', 'MOD002', 'HOR002', '2024-11-20', 109.00, 'USR002');

-- Verificar datos en la tabla matriculas
SELECT * FROM matriculas;

-- Insertar datos en la tabla tipos_comprobantes
INSERT INTO tipos_comprobantes (id_tipo_comprobante, descripcion) VALUES 
('TC001', 'Boleta de Venta'),
('TC002', 'Factura');

-- Verificar datos en la tabla tipos_comprobantes
SELECT * FROM tipos_comprobantes;

-- Insertar datos en la tabla pagos
INSERT INTO pagos (id_pago, id_matricula, fecha_pago, monto, detalle, id_tipo_comprobante, numero_comprobante, id_usuario_registro, observaciones, igv) VALUES 
('PAG000001', 'MAT000001', '2024-11-16', 109.00, 'Pago completo por curso de Inglés Básico', 'TC001', 'B001-000001', 'USR001', 'Fecha de inicio: 2024-11-15', 0),
('PAG000002', 'MAT000002', '2024-11-21', 20.00, 'Pago de inscripción del curso', 'TC001', 'B001-000002', 'USR002', 'Pago realizado en dos partes, falta pago del Libro', 0);
-- Verificar datos en la tabla pagos
SELECT * FROM pagos;

-- Insertar datos en la tabla devoluciones
INSERT INTO devoluciones (id_devolucion, id_pago, fecha_devolucion, monto_devuelto, motivo, id_usuario_autorizacion) VALUES 
('DEV000001', 'PAG000002', '2024-11-17', 20.00, 'No Inicio Curso', 'USR001');

-- Verificar datos en la tabla devoluciones
SELECT * FROM devoluciones;
