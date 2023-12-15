package UI.sec;

import Static.Themes;

import javax.swing.*;
import java.awt.*;

public class SecretaireDashboard extends JFrame {

    public SecretaireDashboard() {
        setTitle("Secretaire Dashboard");
        setSize(300, 150);
        setLocationRelativeTo(null);
        //setLayout(new GroupLayout.Group());
        JButton managePatients = new JButton("<html><font color='white'>Manage patients</font></font></html>");
        JButton b1 = new JButton("<html><font color='white'>button1</font></font></html>");
        JButton b2 = new JButton("<html><font color='white'>button2</font></font></html>");

        managePatients.setBounds(120, 50, 80, 25);
        managePatients.setBackground(Themes.BUTTONCOLOR);
        b1.setBounds(120, 50, 80, 25);
        b1.setBackground(Themes.BUTTONCOLOR);
        b2.setBounds(120, 50, 80, 25);
        b2.setBackground(Themes.BUTTONCOLOR);
        // Add ActionListener for the button (replace with your desired functionality)
        managePatients.addActionListener(e -> {
            // Your logic for the "add" button goes here

        });

        add(managePatients);
        add(b1);
        add(b2);

        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SecretaireDashboard());
    }
}
