import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    public LoginPage(LoginSystem loginSystem) {
        setSize(500,700);
        setLayout(new GridLayout(5,2));
        JLabel email = new JLabel("Enter email");
        JTextField enteredEmail = new JTextField();

        JLabel password = new JLabel("Enter password");
        JTextField enteredPassword = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                IntroPageGraphics introPageGraphics = new IntroPageGraphics(loginSystem);
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
}
