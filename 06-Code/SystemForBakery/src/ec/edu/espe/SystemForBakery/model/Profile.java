package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class Profile {

    private int profile_id;
    private String nameProfile;
    private String description;

    public Profile() {
    }

    public Profile(int profile_id, String nameProfile, String description) {
        this.profile_id = profile_id;
        this.nameProfile = nameProfile;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Profile{" + "profile_id=" + profile_id + ", nameProfile=" + nameProfile + ", description=" + description + '}';
    }
    
    

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
