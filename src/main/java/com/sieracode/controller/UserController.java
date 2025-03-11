package com.sieracode.controller;

import com.sieracode.service.UserService;

public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserService();  // Llama al servicio para manejar la lógica de negocio
    }

    // Método para gestionar el inicio de sesión
    public boolean login(String username, String password) {
        return userService.login(username, password);  // Llama al servicio de login
    }

    // Método para gestionar el registro de un nuevo usuario
    public boolean register(String username, long telefono, String password) {
        return userService.register(username, telefono, password);  // Llama al servicio de registro
    }
}
