package com.sieracode.dao;

import com.sieracode.model.User;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        // Aquí obtienes la conexión correcta desde DatabaseConnection
        this.connection = DatabaseConnection.getInstance().getConnection(); // Devuelve un objeto Connection, no DatabaseConnection
    }

    // Método para obtener un usuario por su nombre
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM user WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idUser = rs.getInt("id_user");
                    String nombre = rs.getString("nombre");
                    long telefono = rs.getLong("telefono");
                    String passwordHash = rs.getString("password_hash");

                    return new User(idUser, nombre, telefono, passwordHash);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Si no se encuentra el usuario
    }

    // Método para guardar un nuevo usuario
    public boolean saveUser(User user) {
        String query = "INSERT INTO user (nombre, telefono, password_hash) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getNombre());
            stmt.setLong(2, user.getTelefono());
            stmt.setString(3, user.getPasswordHash());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

