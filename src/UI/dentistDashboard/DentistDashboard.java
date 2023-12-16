package UI.dentistDashboard;

import UI.dentistDashboard.panels.ContentPanel;
import UI.dentistDashboard.panels.NavbarPanel;
import javax.swing.*;
import java.awt.*;

public class DentistDashboard extends JFrame {
    public DentistDashboard() {
        setTitle("Swing Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        ContentPanel contentPanel = new ContentPanel();
        NavbarPanel navbarPanel = new NavbarPanel(contentPanel);

        JPanel topPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("path/to/your/icon.png");
        JLabel iconLabel = new JLabel(icon);

        // Add text
        JLabel titleLabel = new JLabel("Dashboard Title");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        topPanel.add(iconLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Create the main layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(navbarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);

        setLocationRelativeTo(null); // Center the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DentistDashboard());
    }
}
