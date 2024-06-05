
package ec.edu.espe.SystemForBakery.model;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class SystemProfile {
    private int profileId;
    private String nameProfile;
    private String description;

    public SystemProfile(int profileId, String nameProfile, String description) {
        this.profileId = profileId;
        this.nameProfile = nameProfile;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SystemProfile{" + "profileId=" + profileId + ", nameProfile=" + nameProfile + ", description=" + description + '}';
    }
    
    

    /**
     * @return the profileId
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * @return the nameProfile
     */
    public String getNameProfile() {
        return nameProfile;
    }

    /**
     * @param nameProfile the nameProfile to set
     */
    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
