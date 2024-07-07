package ec.edu.espe.SystemForBakery.utils;

import java.util.Scanner;

/**
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class SystemProfile {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    private String user;
    private String password;

    // Constructor to initialize the instance of SystemProfile with valid values
    public SystemProfile() {
        this.user = VALID_USERNAME;
        this.password = VALID_PASSWORD;
    }

    // Method to validate the username and password
    public boolean authenticate(String username, String password) {
        return this.user.equals(username) && this.password.equals(password);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        SystemProfile systemProfile = new SystemProfile();

        int remainingAttempts = 3;
        boolean accessGranted = false;

        while (remainingAttempts > 0 && !accessGranted) {
            System.out.println("Enter the username:");
            String username = scanner.nextLine();

            System.out.println("Enter the password:");
            String password = scanner.nextLine();

            if (systemProfile.authenticate(username, password)) {
                accessGranted = true;
            } else {
                remainingAttempts--;
                System.out.println("Invalid username or password. Remaining attempts: " + remainingAttempts);
            }
        }

        if (accessGranted) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied. You have exceeded the allowed number of attempts.");
            System.exit(0);
        }
    }
}
