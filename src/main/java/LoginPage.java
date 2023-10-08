import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private final JTextField enteredPassword;

    private final JTextField enteredEmail;
    public LoginPage(LoginSystem loginSystem, DatabaseConnectionManager databaseConnectionManager) {
        setSize(500,700);
        setTitle("Login page");
        setLayout(new GridLayout(5,2));
        JLabel email = new JLabel("Enter email");
        enteredEmail = new JTextField();

        JLabel password = new JLabel("Enter password");
        enteredPassword = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(databaseConnectionManager.containsProfile(getEnteredEmail())) {
                    if(databaseConnectionManager.checkPassword(getEnteredEmail(),getEnteredPassword())) {
                        JOptionPane.showMessageDialog(new JFrame(),"You successfully have logined");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),"Password is incorrect");
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),"Email is not valid");
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                IntroPageGraphics introPageGraphics = new IntroPageGraphics(loginSystem, databaseConnectionManager);
            }
        });

        add(email);
        add(enteredEmail);

        add(password);
        add(enteredPassword);

        add(okButton);
        add(cancelButton);

        setVisible(true);
    }

    private String getEnteredEmail() {
        return enteredEmail.getText().toString();
    }

    private String getEnteredPassword() {
        return enteredPassword.getText().toString();
    }

}
