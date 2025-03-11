package com.sieracode.util;


import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher {

    private static final int SALT_LENGTH = 16; // longitud del salt
    private static final int HASH_ITERATIONS = 10000; // número de iteraciones
    private static final int HASH_LENGTH = 256; // longitud del hash (SHA-256)

    // Método para generar el hash de la contraseña
    public static String hashPassword(String password) throws Exception {
        byte[] salt = generateSalt();
        byte[] hash = hashPasswordWithSalt(password, salt);
        return bytesToHex(salt) + ":" + bytesToHex(hash); // Devuelve el salt + el hash en formato hex
    }

    // Método para verificar la contraseña durante el login
    public static boolean verifyPassword(String password, String storedHash) throws Exception {
        String[] parts = storedHash.split(":");
        byte[] salt = hexToBytes(parts[0]);
        byte[] storedHashBytes = hexToBytes(parts[1]);
        byte[] hash = hashPasswordWithSalt(password, salt);
        return MessageDigest.isEqual(storedHashBytes, hash);
    }

    // Método para generar un salt aleatorio
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    // Método para hacer el hash de la contraseña con el salt
    private static byte[] hashPasswordWithSalt(String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, HASH_ITERATIONS, HASH_LENGTH);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return keyFactory.generateSecret(spec).getEncoded();
    }

    // Método para convertir bytes en formato hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    // Método para convertir cadena hexadecimal en bytes
    private static byte[] hexToBytes(String hex) {
        int length = hex.length();
        byte[] bytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
        }
        return bytes;
    }
}