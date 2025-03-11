
import com.sieracode.dao.DatabaseConfig;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConfigTest {

    @Test
    public void testLoadConfig() {
        DatabaseConfig config = new DatabaseConfig();

        // Verifica si los valores obtenidos son los correctos
        assertNotNull(config.getUrl());
        assertNotNull(config.getUser());
        assertNotNull(config.getPassword());

        // Verifica que los valores coincidan con los valores definidos en el archivo properties
        assertEquals("jdbc:mysql://localhost:3306/marketflow", config.getUrl());
        assertEquals("root", config.getUser());
        assertEquals("soy root#", config.getPassword());
    }
}
