package maujmasti;

import java.awt.*;
import java.awt.event.*;

public class LoginLogoutApp extends Frame implements ActionListener {
    TextField usernameField;
    TextField passwordField;
    Button loginButton, logoutButton;
    Label messageLabel;

    public LoginLogoutApp() {
        setTitle("Login and Logout Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

       
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField(15);
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField(15);
        passwordField.setEchoChar('*'); 

        loginButton = new Button("Login");
        logoutButton = new Button("Logout");
        logoutButton.setEnabled(false); 

        messageLabel = new Label("");

     
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(logoutButton);
        add(messageLabel);

      
        loginButton.addActionListener(this);
        logoutButton.addActionListener(this);

       
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Login")) {
            String username = usernameField.getText();
            String password = passwordField.getText();

      
            if (username.equals("admin") && password.equals("1234")) {
                messageLabel.setText("Login Successful!");
                logoutButton.setEnabled(true);
                loginButton.setEnabled(false);
                usernameField.setEnabled(false);
                passwordField.setEnabled(false);
            } else {
                messageLabel.setText("Invalid Credentials!");
            }
        } else if (command.equals("Logout")) {
            messageLabel.setText("Logged out.");
            logoutButton.setEnabled(false);
            loginButton.setEnabled(true);
            usernameField.setEnabled(true);
            passwordField.setEnabled(true);
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginLogoutApp();
    }
}