import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Properties;

public class LoginSystem {

    private ArrayList<Profile> database;

    public LoginSystem() throws Exception {
        IntroPageGraphics graphics = new IntroPageGraphics(this);


    }

    public void addProfile(Profile profile) {
        database.add(profile);
    }

    public boolean containsProfileWithEmail(String email) {
        for(Profile profile : database) {
            if(profile.containsEmail(email)) return true;
        }
        return false;
    }

    public boolean containsProfile(Profile check) {
        for(Profile profile : database) {
            if(profile.equals(check)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            //LoginSystem loginSystem = new LoginSystem();
            var databaseConnectionManager = new DatabaseConnectionManager();
            databaseConnectionManager.addProfile("Nika","Postkhishvili","Male",20,"1131","ninjanika3@gmail.com");
            System.out.println(databaseConnectionManager.containsProfile("ninjanika3@gmail.com"));
            //databaseConnectionManager.removeProfile("ninjanika3@gmail.com");
            System.out.println(databaseConnectionManager.checkPassword("ninjanika3@gmail.com","1131"));
            System.out.println(databaseConnectionManager.checkPassword("ninjanika3@gmail.com","1231"));
            //System.out.println(databaseConnectionManager.containsProfile("ninjanika3@gmail.com"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
