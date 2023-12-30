package UI.secretaireDashboard.panels;

import Database.dao.DossierDao;
import Database.dao.PatientDao;
import Static.Themes;
import UI.AlternatingRowColorRenderer;
import models.Mutuelle;
import models.Patient;
import models.antecedantClasses.AntecedantMedical;
import models.antecedantClasses.CategorieAntecedentMedicaux;
import models.antecedantClasses.DossierMedical;
import models.antecedantClasses.Risque;
import models.consultation.Consultation;
import models.finance.SituationFinanciere;
import models.finance.StatutPaiement;
import services.DossierMedicalService;
import services.PatientService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ContentPanel extends JPanel {
    PatientDao patientDao;
    PatientService patientService;
    DossierDao dossierDao;
    DossierMedicalService dossierMedicalService;
    private Patient newPatient;
    private Consultation consultation = new Consultation();
    private DossierMedical dossierMedical = new DossierMedical();

    public ContentPanel(PatientDao patientDao, DossierDao dossierDao) {
        setLayout(null);
        this.patientDao = patientDao;
        this.dossierDao = new DossierDao();
        this.patientService = new PatientService(patientDao);
        this.dossierMedicalService = new DossierMedicalService(dossierDao);
        profileContent();
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
        JPanel patientPanel = new JPanel(new GridLayout(1, 1));


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

        JLabel birthLabel = new JLabel("Birth (YYYY-MM-DD):");
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
                dossierMedical = new DossierMedical(new ArrayList<>(), LocalDate.now(), new Patient(), new SituationFinanciere(), StatutPaiement.IMPAYE);

                AntecedantMedical antecedant = new AntecedantMedical(selectedAntecedant);
                selectedAntecedant.setRisqueAssocie(selectedRisque);
                try {
                    newPatient = new Patient(fname, lname, address, phone, email, cin, LocalDate.parse(birth), selectedMutuelle, antecedant, dossierMedical);
                    if (fname.isEmpty() || lname.isEmpty() || birth.isEmpty() || address.isEmpty() ||
                            phone.isEmpty() || email.isEmpty() || cin.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Fields warning", JOptionPane.WARNING_MESSAGE);
                        return;  // Exit the method if any field is empty
                    }
                    if (patientService != null) {
                        dossierMedical.setPatient(newPatient);
                        //newPatient.setDossierMedical(dossierMedical);
                        patientService.addPatient(newPatient);
                        dossierMedicalService.addDossier(dossierMedical);
                        System.out.println(dossierMedicalService.getAllDossiers());

//                        System.out.println(patientService.getAllPatients());
                        System.out.println("Patient added: " + newPatient);
                        refreshContent();

                    } else {
                        System.out.println("PatientService not initialized.");
                    }
                } catch (DateTimeParseException exp){
                    System.out.println("ghjkl");
                    JOptionPane.showMessageDialog(null, "Please fill the date of birth field with the correct format", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        displayPatients(dossierMedical);

        revalidate();
        repaint();
    }

    public void caisseContent() {
        removeAll();
        revalidate();
        repaint();
    }

    public void displayPatients(DossierMedical dossierMedical) {
        //removeAll();
        //setLayout(new GridLayout(2,1));

        ArrayList<Patient> patients = patientService.getAllPatients();

        String[] columnNames = {"ID", "Full Name", "Phone", "Address", "Birth"};

        Object[][] data = new Object[patients.size()][columnNames.length];

        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            data[i][0] = patient.getId();
            data[i][1] = patient.getNom() + " " + patient.getPrenom();
            data[i][2] = patient.getTelephone();
            data[i][3] = patient.getAdresse();
            data[i][4] = patient.getDateNaissance();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        JTable patientTable = new JTable(tableModel);
        patientTable.setDefaultRenderer(Object.class, new AlternatingRowColorRenderer());
        JTableHeader header = patientTable.getTableHeader();
        header.setBackground(Themes.BUTTONCOLOR);
        header.setForeground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(patientTable);

        add(tableScrollPane, BorderLayout.CENTER);
        ListSelectionModel selectionModel = patientTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = patientTable.getSelectedRow();

                    if (selectedRow != -1) {
                        // Retrieve the patient ID from the selected row
                        Object patientId = patientTable.getValueAt(selectedRow, 0);
                        dossierMedicalContent((String)patientId);
                    }
                }
            }
        });
    }

    public void dossierMedicalContent(String patientId) {
        removeAll();


        // Create three panels
        JPanel leftPanel = new JPanel();
        JPanel topRightPanel = new JPanel(new GridLayout(1, 1));
        JPanel bottomRightPanel = new JPanel(new GridLayout(1, 1));

        // Set background colors
        leftPanel.setBackground(Color.WHITE);
        topRightPanel.setBackground(Color.RED);
        bottomRightPanel.setBackground(Color.BLUE);

        // Customize the content of each panel (you can add your components here)

        // Add panels to the main content panel using BorderLayout
        add(leftPanel, BorderLayout.WEST);
        add(topRightPanel, BorderLayout.CENTER);

        // Use another BorderLayout for the bottom right panel
        JPanel rightPanelContainer = new JPanel(new BorderLayout());
        rightPanelContainer.add(bottomRightPanel, BorderLayout.NORTH);
        add(rightPanelContainer, BorderLayout.EAST);

        revalidate();
        repaint();
    }








    public void refreshContent() {
        removeAll();
        patientContent();
        revalidate();
        repaint();
    }




    private Icon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}