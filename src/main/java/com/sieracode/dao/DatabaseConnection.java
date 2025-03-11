package com.sieracode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            
            // Conectar a MySQL sin especificar la base de datos (esto es para crear la base de datos)
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            
             // Crear la base de datos si no existe
            createDatabaseIfNeeded();
            // Crear la conexión a la base de datos usando los datos del archivo de configuración
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            
            // Crear las tablas y el usuario inicial si no existen
            createTablesIfNeeded();
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
            }
        }
    }
     // Método para crear la base de datos si no existe
    private void createDatabaseIfNeeded() throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "CREATE DATABASE IF NOT EXISTS marketflow";
        stmt.executeUpdate(sql);
    }

    // Método para crear las tablas y el usuario si no existen
    private void createTablesIfNeeded() {
        try (Statement stmt = connection.createStatement()) {
            // Ejecutar el script de SQL para crear la base de datos, las tablas y el usuario
            executeSqlScript(stmt, "src/main/resources/create_database.sql");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear las tablas o el usuario en la base de datos.", e);
        }
    }

    // Método para ejecutar un script SQL desde un archivo
    private void executeSqlScript(Statement stmt, String filePath) throws SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            stmt.executeUpdate(sql.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de script SQL.", e);
        }
    }
}
