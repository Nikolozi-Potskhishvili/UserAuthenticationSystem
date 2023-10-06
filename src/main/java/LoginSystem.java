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
        //LoginSystem loginSystem = new LoginSystem();
        Properties properties = new Properties();
        try (InputStream is = LoginSystem.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error loading application.properties", e);
        }

        String dbUrl = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM persons";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String res = rs.getString(5);
            conn.close();
            System.out.println(res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
