
package utils;

/**
 
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class SystemProfile {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    private String user;
    private String password;

    // Constructor para inicializar la instancia de SystemProfile con los valores válidos
    public SystemProfile() {
        this.user = VALID_USERNAME;
        this.password = VALID_PASSWORD;
    }

    // Método para validar el nombre de usuario y la contraseña
    public boolean authenticate(String username, String password) {
        return this.user.equals(username) && this.password.equals(password);
    }
    
}
