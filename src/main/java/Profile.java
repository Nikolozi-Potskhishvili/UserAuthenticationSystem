import java.time.LocalDate;

public class Profile {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private LocalDate bithDay;
    private String password;
    private String email;

    public Profile(String firstName, String lastName, String gender, int age, LocalDate bithDay,
                   String password,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.bithDay = bithDay;
        this.password = password;
        this.email = email;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
