package UI.dentistDashboard.panels;

import Database.FileDatabase;
import Static.Themes;
import models.Mutuelle;
import models.Patient;
import models.antecedantClasses.AntecedantMedical;
import models.antecedantClasses.CategorieAntecedentMedicaux;
import models.antecedantClasses.DossierMedical;
import models.antecedantClasses.Risque;
import services.PatientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

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


        // Form
        JPanel formPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(Themes.DEFAULTFONT);
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setFont(Themes.DEFAULTFONT);
        JTextField lastNameField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(Themes.DEFAULTFONT);
        JTextField addressField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(Themes.DEFAULTFONT);
        JTextField phoneField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(Themes.DEFAULTFONT);
        JTextField emailField = new JTextField();

        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(Themes.DEFAULTFONT);
        JTextField cinField = new JTextField();

        JLabel birthLabel = new JLabel("Birth:");
        birthLabel.setFont(Themes.DEFAULTFONT);
        JTextField birthField = new JTextField();

        JLabel mutuelleLabel = new JLabel("Mutuelle:");
        mutuelleLabel.setFont(Themes.DEFAULTFONT);

        JLabel antecedantLabel = new JLabel("Antecedant medical:");
        antecedantLabel.setFont(Themes.DEFAULTFONT);

        JLabel risqueLabel = new JLabel("Risque:");
        risqueLabel.setFont(Themes.DEFAULTFONT);

        Mutuelle[] mutuelleItems = {Mutuelle.CIMR, Mutuelle.CNAM, Mutuelle.CNOPS, Mutuelle.CNSS};
        CategorieAntecedentMedicaux[] categorieAntecedentMedicauxesItems = {CategorieAntecedentMedicaux.ALLERGIE,
                                                                            CategorieAntecedentMedicaux.CONTRE_INDICATION,
                                                                            CategorieAntecedentMedicaux.MALADIE_CHRONIQUE,
                                                                            CategorieAntecedentMedicaux.MALADIE_HEREDITAIRE,
                                                                            CategorieAntecedentMedicaux.AUTRE
                                                                            };
        Risque[] risqueItems = {Risque.FAIBLE, Risque.MOYEN, Risque.ELEVE, Risque.INCONNU};
        JComboBox mutuelleField = new JComboBox(mutuelleItems);
        JComboBox antecedantField = new JComboBox(categorieAntecedentMedicauxesItems);
        JComboBox risqueField = new JComboBox(risqueItems);



        JButton submitButton = new JButton("<html><font color='white'>Submit</font></html>");
        submitButton.setFont(Themes.DEFAULTFONT);
        submitButton.setBackground(Themes.BUTTONCOLOR);

        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(cinLabel);
        formPanel.add(cinField);
        formPanel.add(birthLabel);
        formPanel.add(birthField);
        formPanel.add(mutuelleLabel);
        formPanel.add(mutuelleField);
        formPanel.add(antecedantLabel);
        formPanel.add(antecedantField);
        formPanel.add(risqueLabel);
        formPanel.add(risqueField);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(submitButton);

        patientPanel.add(formPanel);

        add(patientPanel, BorderLayout.CENTER);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered information
                String fname = firstNameField.getText();
                String lname = lastNameField.getText();
                String birth = birthField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String cin = cinField.getText();
                Mutuelle selectedMutuelle = (Mutuelle) mutuelleField.getSelectedItem();
                CategorieAntecedentMedicaux selectedAntecedant = (CategorieAntecedentMedicaux) antecedantField.getSelectedItem();
                Risque selectedRisque = (Risque) risqueField.getSelectedItem();
                //System.out.println("name : " + name);
               // formPanel.add(mutuelleField);



                // Create a Patient object
                AntecedantMedical antecedant = new AntecedantMedical(selectedAntecedant);
                selectedAntecedant.setRisqueAssocie(selectedRisque);
                Patient newPatient = new Patient(fname, lname, address, phone, email, cin, LocalDate.now(), selectedMutuelle, antecedant, new DossierMedical());
                if (patientService != null) {
                    patientService.addPatient(newPatient);
                    System.out.println(patientService.getAllPatients());
                    System.out.println("Patient added: " + newPatient);

                } else {
                    System.out.println("PatientService not initialized.");
                }
            }
        });
        displayPatients();

        revalidate();
        repaint();
    }

    public void caisseContent() {
        removeAll();
        revalidate();
        repaint();
    }

    public void displayPatients() {
        //removeAll();
        //setLayout(new GridLayout(2,1));

        // Get the list of patients from the database
        ArrayList<Patient> patients = patientService.getAllPatients();

        // Define column names
        String[] columnNames = {"ID", "Full Name", "Phone", "Address", "Birth"};

        // Create a 2D array to hold data for the table
        Object[][] data = new Object[patients.size()][columnNames.length];

        // Populate the data array
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            data[i][0] = patient.getId();
            data[i][1] = patient.getNom() + " " + patient.getPrenom();
            data[i][2] = patient.getTelephone();
            data[i][3] = patient.getAdresse();
            data[i][4] = patient.getDateNaissance();
        }

        // Create a new table model with the data
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create a JTable with the table model
        JTable patientTable = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane tableScrollPane = new JScrollPane(patientTable);

        // Add the scroll pane to the panel
        add(tableScrollPane, BorderLayout.CENTER);
    }


    private Icon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
