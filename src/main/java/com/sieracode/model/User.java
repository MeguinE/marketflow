package com.sieracode.model;

public class User {
    private int idUser;
    private String nombre;
    private long telefono;
    private String passwordHash;

    // Constructor para registrar un nuevo usuario
    public User(String nombre, long telefono, String passwordHash) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.passwordHash = passwordHash;
    }

    // Constructor para recuperar datos de un usuario desde la base de datos
    public User(int idUser, String nombre, long telefono, String passwordHash) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.telefono = telefono;
        this.passwordHash = passwordHash;
    }

    // Getters y setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
