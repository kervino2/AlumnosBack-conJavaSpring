-- Datos de prueba para Alumnos
INSERT INTO alumnos (nombre, apellido, email, fecha_nacimiento) VALUES
('Juan', 'Perez', 'juan.perez@email.com', '2000-05-15'),
('Maria', 'Gomez', 'maria.gomez@email.com', '2001-08-22'),
('Carlos', 'Lopez', 'carlos.lopez@email.com', '1999-11-30'),
('Ana', 'Martinez', 'ana.martinez@email.com', '2002-03-18');

-- Datos de prueba para Materias
INSERT INTO materias (nombre, codigo, creditos) VALUES
('Matemáticas', 'MAT101', 3),
('Física', 'FIS101', 4),
('Programación', 'PRO101', 4),
('Bases de Datos', 'BD101', 3);

-- Datos de prueba para Notas
INSERT INTO notas (valor, fecha_registro, alumno_id, materia_id) VALUES
(4.5, '2026-03-15', 1, 1),
(3.8, '2026-03-16', 1, 2),
(5.0, '2026-03-14', 2, 1),
(4.2, '2026-03-15', 2, 3),
(3.5, '2026-03-16', 3, 2),
(4.8, '2026-03-14', 4, 4);