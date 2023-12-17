package UI.dentistDashboard.panels;

import Static.Themes;
import UI.dentistDashboard.panels.ContentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class NavbarPanel extends JPanel {
    private ContentPanel contentPanel;

    public NavbarPanel(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Themes.BUTTONCOLOR);

        // Increase vertical spacing
        add(Box.createVerticalStrut(20));

        JButton profileButton = new JButton("<html><font color='white'>Profile</font></html>", resizeIcon(new ImageIcon("src/Static/icons/profile.png"), 40, 40));
        profileButton.setPreferredSize(new Dimension(150, 40)); // Adjust the size as needed
        JButton patientButton = new JButton("<html><font color='white'>Patients</font></html>");
        patientButton.setPreferredSize(new Dimension(150, 40)); // Adjust the size as needed
        JButton caisseButton = new JButton("<html><font color='white'>Caisse</font></html>", resizeIcon(new ImageIcon("src/Static/icons/caisse.png"), 40, 40));
        caisseButton.setPreferredSize(new Dimension(150, 40)); // Adjust the size as needed

        profileButton.setContentAreaFilled(false);
        patientButton.setContentAreaFilled(false);
        caisseButton.setContentAreaFilled(false);

        add(profileButton);
        add(Box.createVerticalStrut(10)); // Add some vertical spacing
        add(patientButton);
        add(Box.createVerticalStrut(10)); // Add some vertical spacing
        add(caisseButton);

        // Set action listeners for navbar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.profileContent();
            }
        });

        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.patientContent();
            }
        });

        caisseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.caisseContent();
            }
        });
    }

    private Icon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
