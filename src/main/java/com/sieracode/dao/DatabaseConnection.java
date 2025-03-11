package com.sieracode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private DatabaseConfig config;

    // Constructor privado para evitar la creación de instancias múltiples
    private DatabaseConnection() {
        config = new DatabaseConfig();
        try {
            // Registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Crear la conexión a la base de datos usando los datos del archivo de configuración
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    // Método estático para obtener la instancia única de DatabaseConnection
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método que devuelve la conexión para ser usada por otros objetos
    public Connection getConnection() {
        return connection;
    }

    // Método para cerrar la conexión a la base de datos
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
