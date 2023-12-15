package UI.sec;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Patient;
import services.ServiceSec;

public class SecDash extends JFrame {
/*
    private DefaultTableModel tableModel;
    private JTextField nameField, ageField;
    private JTable table;
    private ServiceSec serviceSec;

    public SecDash(ServiceSec serviceSec) {
        this.serviceSec = serviceSec;

        setTitle("CRUD Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        // (The rest of your existing code remains unchanged)

        // Add ActionListener for the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addData();
            }
        });
    }

    private void addData() {
        String name = nameField.getText();

        if (!name.isEmpty()) {
            // Create a new Patient instance
            Patient patient = new Patient(name, 12);

            // Add the patient to the service
            serviceSec.add(patient);

            // Update the table model with the new data
            Object[] rowData = {patient.getId(), patient.getName(), patient.getAge()};
            tableModel.addRow(rowData);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter values for all fields.");
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
    }*/
}
