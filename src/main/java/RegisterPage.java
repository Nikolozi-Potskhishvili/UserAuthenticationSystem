import javax.swing.*;
import java.awt.*;

public class RegisterPage extends JFrame{
    public RegisterPage(LoginSystem loginSystem) {
        setSize(500,700);
        setLayout(new GridLayout(5,2));
        JLabel email = new JLabel("Enter email");
        JTextField enteredEmail = new JTextField();

        JLabel password = new JLabel("Enter password");
        JTextField enteredPassword = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        add(email);
        add(enteredEmail);

        add(password);
        add(enteredPassword);

        add(okButton);
        add(cancelButton);

        setVisible(true);
    }
}
