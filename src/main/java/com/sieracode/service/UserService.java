package com.sieracode.service;

import com.sieracode.dao.UserDAO;
import com.sieracode.model.User;
import com.sieracode.util.PasswordHasher;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();  // DAO que maneja las consultas relacionadas con los usuarios
    }

    // Lógica para el inicio de sesión
    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            return false;
        }

        // Verifica la contraseña comparando el hash
        try {
            return PasswordHasher.verifyPassword(password, user.getPasswordHash());
        } catch (Exception e) {
            return false;
        }
    }

    // Lógica para registrar un nuevo usuario
    public boolean register(String username, long telefono, String password) {
        try {
            // Hash de la contraseña antes de guardarla (utilizando el método hash)
            String passwordHash = PasswordHasher.hashPassword(password);
            
            // Crea el usuario con el hash de la contraseña
            User user = new User(username, telefono, passwordHash);
            return userDAO.saveUser(user); // Guarda al usuario en la base de datos
        } catch (Exception e) {
            return false;
        }
    }
}
