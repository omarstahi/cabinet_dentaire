package UI.dentistDashboard.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPanel extends JPanel {
    public ContentPanel() {
        setLayout(new BorderLayout());
    }

    public void profileContent() {
        removeAll();
        add(new JButton(), BorderLayout.CENTER);
        add(new JCheckBox(), BorderLayout.NORTH);
        revalidate();
        repaint();
    }
    public void patientContent() {
        removeAll();
        add(new JTable(5,5), BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public void caisseContent() {
        removeAll();
        revalidate();
        repaint();
    }
}
