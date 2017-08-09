package whoyouquote.yero007.com.whoyouquote.data;

/**
 * Created by Dani on 16.06.2015.
 */
public class Player {

    private String name;
    private int avatarId;
    private int level;
    private int experience;

    Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
