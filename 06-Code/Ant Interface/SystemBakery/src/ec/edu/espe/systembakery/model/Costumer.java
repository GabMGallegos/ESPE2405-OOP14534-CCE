/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systembakery.model;

/**
 *
 * @author leydi
 */
public class Costumer {
    String user;
    String password;

    public Costumer() {
    }

    public Costumer(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (user != null && !user.trim().isEmpty()) {
            this.user = user;
        } else {
            throw new IllegalArgumentException("User cannot be null or empty");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return "Costumer{" + "user='" + user + '\'' + ", password='" + password + '\'' + '}';
    }
    
    
}
