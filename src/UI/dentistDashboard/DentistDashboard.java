package UI.dentistDashboard;

import Database.FileDatabase;
import Static.Themes;
import UI.dentistDashboard.panels.ContentPanel;
import UI.dentistDashboard.panels.NavbarPanel;
import services.PatientService;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DentistDashboard extends JFrame {
    FileDatabase filedatabase;
    public DentistDashboard() {
        filedatabase = new FileDatabase();
        setTitle("Dentist Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        ContentPanel contentPanel = new ContentPanel(filedatabase);
        NavbarPanel navbarPanel = new NavbarPanel(contentPanel);

        JPanel topPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/Static/icons/logo2.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(0, 0, 20, 20);

        // Add text
        JLabel titleLabel = new JLabel("      Dashboard Title");
        titleLabel.setFont(Themes.DEFAULTFONT);

        topPanel.add(iconLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Add shadowed separator
        JSeparator separator = createShadowedSeparator();
        topPanel.add(separator, BorderLayout.SOUTH);

        // Create the main layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(navbarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);

        setLocationRelativeTo(null); // Center the JFrame
        setVisible(true);

    }

    private JSeparator createShadowedSeparator() {
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        Border border = separator.getBorder();
        Border margin = new EmptyBorder(5, 0, 0, 0);
        separator.setBorder(new CompoundBorder(border, margin));
        return separator;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DentistDashboard());
    }
}
