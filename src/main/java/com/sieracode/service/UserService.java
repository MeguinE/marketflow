package com.sieracode.service;

import com.sieracode.dao.UserDAO;
import com.sieracode.model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();  // DAO que maneja las consultas relacionadas con los usuarios
    }

    // Lógica para el inicio de sesión
    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPasswordHash().equals(password); // Compara la contraseña (idealmente hasheada)
    }

    // Lógica para registrar un nuevo usuario
    public boolean register(String username, long telefono, String password) {
        // Hash de la contraseña antes de guardarla (usualmente se usaría algo como bcrypt)
        String passwordHash = password;  // Aquí se debería aplicar un hash, como BCrypt
        User user = new User(username, telefono, passwordHash);
        return userDAO.saveUser(user); // Guarda al usuario en la base de datos
    }
}
