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

   

    // Método para crear las tablas y el usuario si no existen
    

    // Método para ejecutar un script SQL desde un archivo
   
}
