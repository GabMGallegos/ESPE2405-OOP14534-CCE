
package utils;

import java.util.Scanner;

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
    
    public void login() {
        Scanner scanner = new Scanner(System.in);
        SystemProfile systemProfile = new SystemProfile();

        int intentosRestantes = 3;
        boolean accesoConcedido = false;

        while (intentosRestantes > 0 && !accesoConcedido) {
            System.out.println("Ingrese el usuario:");
            String username = scanner.nextLine();

            System.out.println("Ingrese su contrasenia:");
            String password = scanner.nextLine();

            if (systemProfile.authenticate(username, password)) {
                accesoConcedido = true;
            } else {
                intentosRestantes--;
                System.out.println("Nombre de usuario o contrasenia incorrectos. Intentos restantes: " + intentosRestantes);
            }
        }

        if (accesoConcedido) {
            System.out.println("Acceso concedido.");
        } else {
            System.out.println("Acceso denegado. Ha superado el número de intentos permitidos.");
        }
    }
}
