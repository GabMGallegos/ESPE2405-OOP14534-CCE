
package ec.edu.espe.SystemForBakery.utils;

import java.util.List;

public class ProfileMethods {
    public ProfileMethods() {
    }
    
    public static UserProfile findProfileByUsername(List<UserProfile> profiles, String username) {
        for (UserProfile profile : profiles) {
            if (profile.getUser().getUsername().equals(username)) {
                return profile; 
            }
        }
        return null; 
    }
    
    public static boolean profileExistsByUsername(List<UserProfile> profiles, String username) {
        for (UserProfile profile : profiles) {
            if (profile.getUser().getUsername().equals(username)) {
                return true; 
            }
        }
        return false; 
    }
}
