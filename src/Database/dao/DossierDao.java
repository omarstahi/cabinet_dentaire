package Database.dao;

import models.antecedantClasses.DossierMedical;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DossierDao implements IDao<DossierMedical>{
    private static final String DOSSIERS_FILE = "src/Database/files/dossierMedical.txt";


    // Méthode pour ajouter un patient
    public void save(DossierMedical dossier) {
        List<DossierMedical> dossiers = findAll();
        dossiers.add(dossier);
        saveDossiersToFile(dossiers);
    }

    // Méthode pour récupérer un patient par ID
    public DossierMedical findById(String numeroDossier) {
        List<DossierMedical> dossiers = findAll();
        for (DossierMedical dossierMedical : dossiers) {
            if (dossierMedical.getNumeroDossier().equals(numeroDossier)) {
                return dossierMedical;
            }
        }
        return null;
    }

    // Méthode pour récupérer tous les patients
    public ArrayList<DossierMedical> findAll() {
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

    // Méthode pour mettre à jour un patient
    public void update(DossierMedical updatedDossier) {
        List<DossierMedical> patients = findAll();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getNumeroDossier().equals(updatedDossier.getNumeroDossier())) {
                patients.set(i, updatedDossier);
                break;
            }
        }
        saveDossiersToFile(patients);
    }

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
