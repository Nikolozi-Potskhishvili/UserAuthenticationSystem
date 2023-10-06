import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame{
    private LoginSystem loginSystem;
    private String finalPassword;
    public RegisterPage(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        init();
    }
    private void init() {
        setSize(500,700);
        setTitle("Register page");
        setLayout(new GridLayout(8,2));

        JLabel firstName = new JLabel("Enter first name: ");
        JLabel lastName = new JLabel("Enter last name: ");
        JLabel gender = new JLabel("Enter gender:");
        JLabel age = new JLabel("Enter age:");
        JLabel email = new JLabel("Enter email:");
        JLabel password = new JLabel("Enter password");
        JLabel confirmPassword = new JLabel("Confirm your password:");

        JTextField firstNameTextArea = new JTextField();
        JTextField lastNameTextArea = new JTextField();
        JTextField genderTextArea = new JTextField();
        JTextField ageNameTextArea = new JTextField();
        JTextField emailTextArea = new JTextField();
        JTextField passwordTextArea = new JTextField();
        JTextField confirmPasswordTextArea = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile currentProfile = new Profile(firstName.getText(),lastName.getText(),gender.getText(),
                        Integer.valueOf(age.getText()), emailTextArea.getText(), confirmPasswordTextArea.getText());
                if(loginSystem.containsProfile(currentProfile)) {

                } else {
                    loginSystem.addProfile(currentProfile);
                }
                dispose();
                IntroPageGraphics introPageGraphics= new IntroPageGraphics(loginSystem);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                IntroPageGraphics introPageGraphics= new IntroPageGraphics(loginSystem);
            }
        });

        add(firstName);
        add(firstNameTextArea);

        add(lastName);
        add(lastNameTextArea);

        add(gender);
        add(genderTextArea);

        add(age);
        add(ageNameTextArea);

        add(email);
        add(emailTextArea);

        add(password);
        add(passwordTextArea);

        add(confirmPassword);
        add(confirmPasswordTextArea);

        add(okButton);
        add(cancelButton);

        setVisible(true);
    }

    private boolean passwordIsCorrect() {
        return false;
    }

    private boolean checkProfile(Profile profile) {
        return true;
    }

}
