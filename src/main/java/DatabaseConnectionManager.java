import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DatabaseConnectionManager {
    private Connection conn;

    public DatabaseConnectionManager() {
        connectDatabase();
    }

    public void disconnectDatabase() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void connectDatabase() {
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
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String email, String password) {
        if(containsProfile(email)) {
            try {
                Statement st = conn.createStatement();
                String sql = "SELECT password FROM profiles WHERE email = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,email);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    String storedPassword  = resultSet.getString("password");
                    return storedPassword.equals(password);
                } else {
                    System.out.println("No matching email found");

                    return false;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("This email is not registered");
            return false;
        }

    }

    public void removeProfile(String email) {
        if(containsProfile(email)) {
            try {
                Statement st = conn.createStatement();
                String sql = "DELETE FROM profiles where email = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,email);
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected > 0) {
                    System.out.println("Profile deleted successfully!!!!");
                } else {
                    System.out.println("Failed delete profile:(");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Profile doesn't exist....");
    }

    public boolean containsProfile(String email) {
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM profiles WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addProfile(String firstName,String lastName,String gender,int age, String password,String email) {
        if(!containsProfile(email)) {
            try {
                String sql = "INSERT INTO profiles(first_name, last_name, gender, age, password, email) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, gender);
                preparedStatement.setInt(4, age);
                preparedStatement.setString(5, password);
                preparedStatement.setString(6, email);
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected > 0) {
                    System.out.println("Profile added successfully!!!!");
                } else System.out.println("Failed to add profile:(");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Profile already exists");
    }

}
