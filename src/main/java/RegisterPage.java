import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame{
    private LoginSystem loginSystem;
    private DatabaseConnectionManager databaseConnectionManager;
    private String finalPassword;
    private JTextField passwordTextArea;
    private JTextField confirmPasswordTextArea;
    private JTextField emailTextArea;
    public RegisterPage(LoginSystem loginSystem, DatabaseConnectionManager databaseConnectionManager) {
        this.databaseConnectionManager = databaseConnectionManager;
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
        JTextField ageTextArea = new JTextField();
        emailTextArea = new JTextField();
        passwordTextArea = new JTextField();
        confirmPasswordTextArea = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(databaseConnectionManager.containsProfile(getEnteredEmail())) {
                    JOptionPane.showMessageDialog(new Frame(),"This email already is registered");
                } else {
                    if(!passwordIsCorrect()) {
                        JOptionPane.showMessageDialog(new Frame(),"Your passwords do not match");
                    } else {
                        databaseConnectionManager.addProfile(firstNameTextArea.getText().toString(),lastNameTextArea.getText().toString(),
                                genderTextArea.getText().toString(), Integer.parseInt(ageTextArea.getText().toString()),getEnteredConfirmedPassword(),getEnteredEmail());
                        JOptionPane.showMessageDialog(new Frame(),"You successfully created new account");
                    }
                }
                dispose();
                IntroPageGraphics introPageGraphics= new IntroPageGraphics(loginSystem, databaseConnectionManager);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                IntroPageGraphics introPageGraphics= new IntroPageGraphics(loginSystem, databaseConnectionManager);
            }
        });

        add(firstName);
        add(firstNameTextArea);

        add(lastName);
        add(lastNameTextArea);

        add(gender);
        add(genderTextArea);

        add(age);
        add(ageTextArea);

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
        return getEnteredPassword().equals(getEnteredConfirmedPassword());
    }

    private String getEnteredEmail() {
        return emailTextArea.getText().toString();
    }

    private String getEnteredPassword() {
        return passwordTextArea.getText().toString();
    }

    private String getEnteredConfirmedPassword() {
        return confirmPasswordTextArea.getText().toString();
    }

}
