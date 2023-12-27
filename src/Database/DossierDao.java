package Database;

import models.antecedantClasses.DossierMedical;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DossierDao {
    private static final String DOSSIERS_FILE = "src/Database/files/dossierMedical.txt";


    // Méthode pour ajouter un patient
    public void addDossier(DossierMedical dossier) {
        List<DossierMedical> dossiers = getAllDossiers();
        dossiers.add(dossier);
        saveDossiersToFile(dossiers);
    }

    // Méthode pour récupérer un patient par ID
    public DossierMedical getDossierByNum(String numeroDossier) {
        List<DossierMedical> dossiers = getAllDossiers();
        for (DossierMedical dossierMedical : dossiers) {
            if (dossierMedical.getNumeroDossier().equals(numeroDossier)) {
                return dossierMedical;
            }
        }
        return null;
    }

    // Méthode pour récupérer tous les patients
    public ArrayList<DossierMedical> getAllDossiers() {
        ArrayList<DossierMedical> dossiers = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DOSSIERS_FILE))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof DossierMedical) {
                        dossiers.add((DossierMedical) obj);
                    }
                } catch (EOFException e) {
                    break; // Fin du fichier
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dossiers;
    }

/*    // Méthode pour mettre à jour un patient
    public void updatePatient(DossierMedical updatedDossier) {
        List<Patient> patients = getAllPatients();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(updatedPatient.getId())) {
                patients.set(i, updatedPatient);
                break;
            }
        }
        savePatientsToFile(patients);
    }
*/
    // Méthode privée pour sauvegarder les patients dans le fichier
    private void saveDossiersToFile(List<DossierMedical> dossiers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DOSSIERS_FILE))) {
            for (DossierMedical patient : dossiers) {
                oos.writeObject(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
