CREATE DATABASE casolaboratorio2;

\c casolaboratorio2;

CREATE TABLE empleado (
    id SERIAL PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    area VARCHAR(50) NOT NULL,
    sueldo DECIMAL(10,2) NOT NULL,
    fecha_ingreso DATE NOT NULL
);

INSERT INTO empleado (dni, nombres, area, sueldo, fecha_ingreso) VALUES
('45678901', 'Ana Gómez', 'Tecnología', 2800.00, '2023-04-12'),
('45678902', 'Luis Paredes', 'Ventas', 2450.00, '2022-08-21'),
('45678903', 'María Sol', 'Administración', 2600.00, '2021-11-05'),
('45678904', 'Pedro Rojas', 'Logística', 2300.00, '2024-02-18');
