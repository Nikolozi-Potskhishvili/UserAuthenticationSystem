import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnectionManager {
    public DatabaseConnectionManager() {
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
            String sql = "INSERT INTO profiles(first_name,last_name,gender,age,password,email) " +
                    "Values('Nika','Potskhishvili','Male','20','1131','ninjanika3@gmail.com')";
            int rowsAffected = st.executeUpdate(sql);
            if(rowsAffected > 0) {
                System.out.println("YEES!!!");
            } else {
                System.out.println(":(");
            }
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
