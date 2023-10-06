import java.time.LocalDate;

public class Profile {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String password;
    private String email;

    public Profile(String firstName, String lastName, String gender, int age,
                   String password,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    public boolean containsEmail(String checkEmail) {
        return email.equals(checkEmail);
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
