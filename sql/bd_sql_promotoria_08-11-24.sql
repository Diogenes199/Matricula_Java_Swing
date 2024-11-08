DROP DATABASE  IF EXISTS bd_prototipo;

CREATE DATABASE bd_prototipo;

USE bd_prototipo;

CREATE TABLE Acceso (
    id_acceso VARCHAR(10) PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contra VARCHAR(50) NOT NULL
);

CREATE TABLE Promotoria (
    id_recep VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    id_acceso VARCHAR(10),
    FOREIGN KEY (id_acceso) REFERENCES Acceso(id_acceso)
);

CREATE TABLE Cursos (
    id_curso VARCHAR(10) PRIMARY KEY,
    nom_curso VARCHAR(50) NOT NULL,
    nivel VARCHAR(20),
    descrip TEXT,
    fInicio DATE NOT NULL,
    duracion VARCHAR(20),
    costo DECIMAL(10, 2) NOT NULL CHECK (costo >= 0)
);

CREATE TABLE PreMatriculas (
    id_prematricula VARCHAR(10) PRIMARY KEY,
    nombres VARCHAR(30) NOT NULL,
    apaterno VARCHAR(20) NOT NULL,
    amaterno VARCHAR(20),
    dni VARCHAR(10) NOT NULL UNIQUE,
    tipo_documento VARCHAR(20) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    fnacimiento DATE NOT NULL,
    celular VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    direccion VARCHAR(100),
    pais VARCHAR(50),
    departamento VARCHAR(50),
    provincia VARCHAR(50),
    id_recep VARCHAR(10),
    id_curso VARCHAR(10),
    FOREIGN KEY (id_recep) REFERENCES Promotoria(id_recep),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

CREATE TABLE Pagos (
    id_pago VARCHAR(10) PRIMARY KEY,
    id_curso VARCHAR(10) NOT NULL,
    monto DECIMAL(10, 2) NOT NULL CHECK (monto >= 0),
    fecha_pago DATE NOT NULL,
    tipo_pago VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

CREATE TABLE Estudiantes (
    id_estudiante VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Matriculas (
    id_matricula VARCHAR(10) PRIMARY KEY,
    id_estu VARCHAR(10) NOT NULL,
    id_pago VARCHAR(10) NOT NULL,
    fecha_inicio DATE NOT NULL,
    estado VARCHAR(20) DEFAULT 'Confirmada',
    FOREIGN KEY (id_estu) REFERENCES Estudiantes(id_estudiante),
    FOREIGN KEY (id_pago) REFERENCES Pagos(id_pago)
);

CREATE TABLE Comprobantes (
    id_comprobante VARCHAR(10) PRIMARY KEY,
    id_pago VARCHAR(10) NOT NULL,
    numero_comprobante VARCHAR(20) NOT NULL,
    fecha_emision DATE NOT NULL,
    FOREIGN KEY (id_pago) REFERENCES Pagos(id_pago)
);

CREATE TABLE Reportes (
    id_reporte VARCHAR(10) PRIMARY KEY,
    id_matricula VARCHAR(10) NOT NULL,
    descripcion VARCHAR(255),
    fecha_reporte DATE NOT NULL,
    FOREIGN KEY (id_matricula) REFERENCES Matriculas(id_matricula)
);

DROP DATABASE IF EXISTS bd_prototipo;
CREATE DATABASE bd_prototipo;
USE bd_prototipo;

CREATE TABLE Acceso (
    id_acceso VARCHAR(10) PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contra VARCHAR(255) NOT NULL,  
    rol VARCHAR(20) NOT NULL
);

CREATE TABLE Promotoria (
    id_promotor VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    id_acceso VARCHAR(10),
    FOREIGN KEY (id_acceso) REFERENCES Acceso(id_acceso)
);

CREATE TABLE Cursos (
    id_curso VARCHAR(10) PRIMARY KEY,
    nom_curso VARCHAR(50) NOT NULL,
    nivel VARCHAR(20),
    descrip TEXT,
    fInicio DATE NOT NULL,
    duracion VARCHAR(20),
    costo DECIMAL(10, 2) NOT NULL CHECK (costo >= 0),
    cupos INT DEFAULT 0,
    horario VARCHAR(50)
);

CREATE TABLE PreMatriculas (
    id_prematricula VARCHAR(10) PRIMARY KEY,
    nombres VARCHAR(30) NOT NULL,
    apaterno VARCHAR(20) NOT NULL,
    amaterno VARCHAR(20),
    dni VARCHAR(10) NOT NULL UNIQUE,
    tipo_documento VARCHAR(20) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    fnacimiento DATE NOT NULL,
    celular VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    direccion VARCHAR(100),
    pais VARCHAR(50),
    departamento VARCHAR(50),
    provincia VARCHAR(50),
    id_promotor VARCHAR(10),
    id_curso VARCHAR(10),
    FOREIGN KEY (id_promotor) REFERENCES Promotoria(id_promotor),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

CREATE TABLE Pagos (
    id_pago VARCHAR(10) PRIMARY KEY,
    id_curso VARCHAR(10) NOT NULL,
    monto DECIMAL(10, 2) NOT NULL CHECK (monto >= 0),
    fecha_pago DATE NOT NULL,
    tipo_pago VARCHAR(20) NOT NULL,
    estado_pago ENUM('Pendiente', 'Pagado', 'Anulado') DEFAULT 'Pendiente',
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

CREATE TABLE Estudiantes (
    id_estudiante VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(10) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    direccion VARCHAR(100)
);

CREATE TABLE Matriculas (
    id_matricula VARCHAR(10) PRIMARY KEY,
    id_estudiante VARCHAR(10) NOT NULL,
    id_pago VARCHAR(10) NOT NULL,
    fecha_inicio DATE NOT NULL,
    estado ENUM('Confirmada', 'Pendiente') DEFAULT 'Confirmada',
    FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante),
    FOREIGN KEY (id_pago) REFERENCES Pagos(id_pago)
);

CREATE TABLE Comprobantes (
    id_comprobante VARCHAR(10) PRIMARY KEY,
    id_pago VARCHAR(10) NOT NULL,
    numero_comprobante VARCHAR(20) NOT NULL,
    fecha_emision DATE NOT NULL,
    FOREIGN KEY (id_pago) REFERENCES Pagos(id_pago)
);

CREATE TABLE Reportes_Academicos (
    id_reporte VARCHAR(10) PRIMARY KEY,
    id_matricula VARCHAR(10) NOT NULL,
    descripcion VARCHAR(255),
    fecha_reporte DATE NOT NULL,
    tipo_reporte VARCHAR(20) DEFAULT 'Académico',
    FOREIGN KEY (id_matricula) REFERENCES Matriculas(id_matricula)
);


-- Ingreso de datos en la tabla Acceso
INSERT INTO Acceso (id_acceso, usuario, contra, rol) VALUES 
('ACC001', 'agente1', '12345', 'Admin'),
('ACC002', 'agente2', '123456', 'Promotor');

-- Ingreso de datos en la tabla Promotoria
INSERT INTO Promotoria (id_promotor, nombre, apellidos, id_acceso) VALUES 
('PROM001', 'Juan', 'Pérez', 'ACC001'),
('PROM002', 'Ana', 'Gómez', 'ACC002');

-- Ingreso de datos en la tabla Cursos
INSERT INTO Cursos (id_curso, nom_curso, nivel, descrip, fInicio, duracion, costo, cupos, horario) VALUES 
('CUR001', 'Inglés Básico', 'Básico', 'Curso de inglés para principiantes', '2024-01-10', '3 meses', 300.00, 20, 'Lunes y Miércoles 6:00 PM'),
('CUR002', 'Inglés Intermedio', 'Intermedio', 'Curso de inglés para niveles intermedios', '2024-02-15', '3 meses', 350.00, 15, 'Martes y Jueves 5:00 PM'),
('CUR003', 'Inglés Avanzado', 'Avanzado', 'Curso de inglés para niveles avanzados', '2024-03-20', '3 meses', 400.00, 10, 'Lunes y Viernes 7:00 PM');

-- Ingreso de datos en la tabla PreMatriculas
INSERT INTO PreMatriculas (id_prematricula, nombres, apaterno, amaterno, dni, tipo_documento, sexo, fnacimiento, celular, email, direccion, pais, departamento, provincia, id_promotor, id_curso) VALUES 
('PRE001', 'Carlos', 'Sánchez', 'Lopez', '12345678', 'DNI', 'Masculino', '2000-05-15', '987654321', 'carlos@gmail.com', 'Av. Siempre Viva 123', 'Perú', 'Lima', 'Lima', 'PROM001', 'CUR001'),
('PRE002', 'Lucía', 'Martinez', 'Gonzalez', '87654321', 'DNI', 'Femenino', '1998-08-20', '987654322', 'lucia@gmail.com', 'Calle Falsa 456', 'Perú', 'Lima', 'Lima', 'PROM002', 'CUR002');

-- Ingreso de datos en la tabla Pagos
INSERT INTO Pagos (id_pago, id_curso, monto, fecha_pago, tipo_pago, estado_pago) VALUES 
('PAG001', 'CUR001', 300.00, '2024-01-05', 'Tarjeta de crédito', 'Pagado'),
('PAG002', 'CUR002', 350.00, '2024-02-10', 'Transferencia', 'Pagado');

-- Ingreso de datos en la tabla Estudiantes
INSERT INTO Estudiantes (id_estudiante, nombre, apellidos, dni, telefono, email, direccion) VALUES 
('EST001', 'Carlos', 'Sánchez', '12345678', '987654321', 'carlos@gmail.com', 'Av. Siempre Viva 123'),
('EST002', 'Lucía', 'Martinez', '87654321', '987654322', 'lucia@gmail.com', 'Calle Falsa 456');

-- Ingreso de datos en la tabla Matriculas
INSERT INTO Matriculas (id_matricula, id_estudiante, id_pago, fecha_inicio, estado) VALUES 
('MAT001', 'EST001', 'PAG001', '2024-01-10', 'Confirmada'),
('MAT002', 'EST002', 'PAG002', '2024-02-15', 'Confirmada');

-- Ingreso de datos en la tabla Comprobantes
INSERT INTO Comprobantes (id_comprobante, id_pago, numero_comprobante, fecha_emision) VALUES 
('COM001', 'PAG001', 'C001-2024', '2024-01-06'),
('COM002', 'PAG002', 'C002-2024', '2024-02-11');

-- Ingreso de datos en la tabla Reportes_Academicos
INSERT INTO Reportes_Academicos (id_reporte, id_matricula, descripcion, fecha_reporte, tipo_reporte) VALUES 
('REP001', 'MAT001', 'Reporte de avance del curso', '2024-01-20', 'Académico'),
('REP002', 'MAT002', 'Reporte de asistencia', '2024-02-20', 'Académico');
