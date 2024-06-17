
package ec.edu.espe.SystemForBakery.model;

/**
 
 * @autor CODE_CRAFTING_ENGINEERS
 */
public class SystemProfile {
    private String user;
    private String password;

    
    public SystemProfile(String user, String password) {
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.user = user;
        this.password = password;
    }

    
    public String getUser() {
        return user;
    }

   
    public void setUser(String user) {
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.user = user;
    }

   
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
    }

   
    public String toCSV() {
        return user + "," + password;
    }
}
