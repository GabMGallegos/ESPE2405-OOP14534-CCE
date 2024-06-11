package utils;

import java.util.UUID;

public class ProfileId {
    // Método para generar un identificador único
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // Método para validar un identificador
    public static boolean isValidId(String id) {
        // Verifica si el identificador no es nulo ni está vacío
        return id != null && !id.isEmpty();
    }
}
