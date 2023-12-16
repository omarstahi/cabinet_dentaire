package UI.dentistDashboard.panels;

import Static.Themes;
import UI.dentistDashboard.panels.ContentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavbarPanel extends JPanel {
    private ContentPanel contentPanel;

    public NavbarPanel(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Themes.BUTTONCOLOR);
        JButton profileButton = new JButton("<html><font color='white'>Profile</font></html>");
        JButton patientButton = new JButton("<html><font color='white'>Patient</font></html>");
        JButton caisseButton = new JButton("<html><font color='white'>Caisse</font></html>");
        profileButton.setContentAreaFilled(false);
        patientButton.setContentAreaFilled(false);
        caisseButton.setContentAreaFilled(false);
        add(profileButton);
        add(patientButton);
        add(caisseButton);

        // Set action listeners for navbar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.profileContent(new JTable());
            }
        });


        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.patientContent(new JTextField());
            }
        });


        caisseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.caisseContent(new JTextField());
            }
        });
    }
}
