-- Crear la base de datos marketflow si no existe
CREATE DATABASE IF NOT EXISTS marketflow;

-- Usar la base de datos marketflow
USE marketflow;

-- Crear la tabla user
CREATE TABLE IF NOT EXISTS user (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    telefono INT(15),
    password_hash VARCHAR(255)
);

-- Insertar un usuario inicial (si no existe)
INSERT INTO user (nombre, telefono, password_hash) 
VALUES ("Guillermo", 2721623675, "123456")
ON DUPLICATE KEY UPDATE id_user=id_user;
