package UI.dentistDashboard.panels;

import Database.FileDatabase;
import Static.Themes;
import models.Mutuelle;
import models.Patient;
import models.antecedantClasses.AntecedantMedical;
import services.PatientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContentPanel extends JPanel {
    FileDatabase filedatabase;
    PatientService patientService;

    public ContentPanel(FileDatabase filedatabase) {
        setLayout(null);
        this.filedatabase = filedatabase;
        this.patientService = new PatientService(filedatabase);
    }

    public void profileContent() {
        removeAll();
        setLayout(null);
        //icons
        JLabel adresse = new JLabel(new ImageIcon("src/Static/icons/adresse.png"));
        JLabel phone = new JLabel(new ImageIcon("src/Static/icons/phone.png"));
        JLabel email = new JLabel(new ImageIcon("src/Static/icons/email.png"));

        //labels
        JLabel adresseLabel = new JLabel("diyar");
        JLabel phoneLabel = new JLabel("06040483265");
        JLabel emailLabel = new JLabel("test@gmail.com");

        //style
        adresseLabel.setFont(Themes.DEFAULTFONT);
        phoneLabel.setFont(Themes.DEFAULTFONT);
        emailLabel.setFont(Themes.DEFAULTFONT);
        adresse.setBounds(50, 80, 50, 50);
        adresseLabel.setBounds(120, 80, 150, 50);
        phone.setBounds(50, 180, 50, 50);
        phoneLabel.setBounds(120, 180, 150, 50);
        email.setBounds(50, 280, 50, 50);
        emailLabel.setBounds(120, 280, 250, 50);
        add(adresse);
        add(adresseLabel);
        add(phone);
        add(phoneLabel);
        add(email);
        add(emailLabel);
        revalidate();
        repaint();
    }

    public void patientContent() {
        removeAll();
        setLayout(new GridLayout(2,1));
        // Create a panel to hold the components
        JPanel patientPanel = new JPanel(new GridLayout(2, 1));

        // Table
        JTable patientTable = new JTable(5, 5);
        JScrollPane tableScrollPane = new JScrollPane(patientTable);
        patientPanel.add(tableScrollPane);

        // Form
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(Themes.DEFAULTFONT);
        JTextField nameField = new JTextField();
        JLabel birthLabel = new JLabel("Age:");
        birthLabel.setFont(Themes.DEFAULTFONT);
        JTextField birthField = new JTextField();
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(Themes.DEFAULTFONT);
        submitButton.setBackground(Themes.BUTTONCOLOR);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(birthLabel);
        formPanel.add(birthField);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(submitButton);

        patientPanel.add(formPanel);

        add(patientPanel, BorderLayout.CENTER);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered information
                String name = nameField.getText();
                String birth = birthField.getText();
                System.out.println("name : " + name);


                // Create a Patient object
                Patient newPatient = new Patient(name, "a", "a", "a", "a", "a", LocalDate.now(), Mutuelle.CNOPS, new ArrayList<>());
                    // Call the addPatient method from the PatientService
                // Note: You need to have an instance of PatientService in your ContentPanel class
                // and set it accordingly before calling this method
                if (patientService != null) {
                    patientService.addPatient(newPatient);
                    System.out.println(patientService.getAllPatients());

                    System.out.println("Patient added: " + newPatient);
                } else {
                    System.out.println("PatientService not initialized.");
                }
            }
        });
        revalidate();
        repaint();
    }


    public void caisseContent() {
        removeAll();
        revalidate();
        repaint();
    }
    private Icon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
