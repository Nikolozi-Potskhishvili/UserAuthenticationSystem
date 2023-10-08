import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroPageGraphics extends JFrame {
    private LoginSystem loginSystem;

    private DatabaseConnectionManager databaseConnectionManager;
    public IntroPageGraphics(LoginSystem loginSystem, DatabaseConnectionManager databaseConnectionManager) {
        this.databaseConnectionManager = databaseConnectionManager;
        this.loginSystem = loginSystem;
        init();
    }

    private void init() {
        setSize(450,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));


        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage loginPage = new LoginPage(loginSystem, databaseConnectionManager);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegisterPage registerPage = new RegisterPage(loginSystem, databaseConnectionManager);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(loginButton);
        add(registerButton);
        add(exitButton);
        setVisible(true);
    }
}
