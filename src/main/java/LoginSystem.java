import java.util.ArrayList;

public class LoginSystem {

    private ArrayList<Profile> database;

    public LoginSystem() {
        IntroPageGraphics graphics = new IntroPageGraphics(this);
    }

    private void addProfile(Profile profile) {
        database.add(profile);
    }

    public boolean containsProfile(Profile profile) {
        return database.contains(profile);
    }
    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
    }
}
