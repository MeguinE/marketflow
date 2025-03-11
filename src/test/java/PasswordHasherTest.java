import com.sieracode.util.PasswordHasher;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordHasherTest {

    @Test
    public void testHashPasswordAndVerify() throws Exception {
        String password = "miContraseñaSegura";

        // Hash de la contraseña
        String passwordHash = PasswordHasher.hashPassword(password);

        // Verificación de la contraseña
        boolean isValid = PasswordHasher.verifyPassword(password, passwordHash);

        // La contraseña debe ser válida
        assertTrue(isValid, "La contraseña debería ser válida después de hash y verificación.");
    }

    @Test
    public void testIncorrectPasswordVerification() throws Exception {
        String password = "miContraseñaSegura";
        String incorrectPassword = "contraseñaIncorrecta";

        // Hash de la contraseña original
        String passwordHash = PasswordHasher.hashPassword(password);

        // Verificación con una contraseña incorrecta
        boolean isValid = PasswordHasher.verifyPassword(incorrectPassword, passwordHash);

        // La contraseña incorrecta no debería ser válida
        assertFalse(isValid, "La contraseña incorrecta no debería ser válida.");
    }

    @Test
    public void testHashConsistency() throws Exception {
        String password = "miContraseñaSegura";

        // Generar hash de la misma contraseña varias veces
        String hash1 = PasswordHasher.hashPassword(password);
        String hash2 = PasswordHasher.hashPassword(password);

        // Los hashes deben ser diferentes debido al salt aleatorio
        assertNotEquals(hash1, hash2, "Los hashes generados para la misma contraseña deben ser diferentes.");
    }
}
