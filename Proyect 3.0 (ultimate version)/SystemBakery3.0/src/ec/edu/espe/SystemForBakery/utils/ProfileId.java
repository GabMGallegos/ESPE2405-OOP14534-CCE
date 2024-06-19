package ec.edu.espe.SystemForBakery.utils;

import java.util.UUID;

public class ProfileId {
    // Method to generate a unique identifier
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // Method to validate an identifier
    public static boolean isValidId(String id) {
        // Verify if the identifier is not null and not empty
        return id != null && !id.isEmpty();
    }
}
