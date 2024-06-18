
package ec.edu.espe.SystemForBakery.utils;

public class UserProfile {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private User user; // Reference to the associated user

    public UserProfile(String firstName, String lastName, int age, String gender, User user) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.user = user;
    }

    // Getters and setters for the attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }
}
