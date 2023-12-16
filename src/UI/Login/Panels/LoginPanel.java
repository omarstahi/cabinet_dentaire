package UI.Login.Panels;
import Static.Themes;
import UI.dentistDashboard.DentistDashboard;
import UI.sec.SecretaireDashboard;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel() {
        placeComponents();
    }

    private void placeComponents() {
        setLayout(new BorderLayout());
        // Top Panel for the login text
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel loginText = new JLabel("<html><font color='blue'>Login </font><font color='black'>your account</font></html>");
        loginText.setFont(Themes.TITLEFONT);
        topPanel.add(loginText);
        topPanel.setBackground(Color.WHITE);  // Set background color

        add(topPanel, BorderLayout.NORTH);
        // Center Panel for the form
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.WHITE);  // Set background color


        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(35, 40, 80, 25);
        centerPanel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(125, 40, 165, 25);
        centerPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(35, 100, 80, 25);
        centerPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(125, 100, 165, 25);
        centerPanel.add(passwordField);

        JButton loginButton = new JButton("<html><font color='white'>Login</font></html>");
        loginButton.setBounds(155, 180, 80, 25);
        loginButton.setBackground(Themes.BUTTONCOLOR);
        centerPanel.add(loginButton);

        // Add ActionListener for the login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            if ("doctor".equals(username) && "doctor".equals(new String(password))) {
                new DentistDashboard();
            } else if ("sec".equals(username) && "sec".equals(new String(password))) {
                new SecretaireDashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Try again.");
            }

            // Clear the fields after login attempt
            usernameField.setText("");
            passwordField.setText("");
        });

        add(centerPanel, BorderLayout.CENTER);
    }
}
