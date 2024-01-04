package Database.dao;

import models.antecedantClasses.DossierMedical;
import models.consultation.Consultation;
import models.finance.SituationFinanciere;
import services.ConsultationService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DossierDao implements IDao<DossierMedical>{
    private static final String DOSSIERS_FILE = "src/Database/files/dossierMedical.txt";


    public void save(DossierMedical dossier) {
        List<DossierMedical> dossiers = findAll();
        dossiers.add(dossier);
        saveDossiersToFile(dossiers);
    }

    public DossierMedical findById(String numeroDossier) {
        List<DossierMedical> dossiers = findAll();
        for (DossierMedical dossierMedical : dossiers) {
            if (dossierMedical.getNumeroDossier().equals(numeroDossier)) {
                return dossierMedical;
            }
        }
        return null;
    }

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

    public void update(DossierMedical updatedDossier) {
        List<DossierMedical> dossiers = findAll();
        for (int i = 0; i < dossiers.size(); i++) {
            if (dossiers.get(i).getNumeroDossier().equals(updatedDossier.getNumeroDossier())) {
                dossiers.set(i, updatedDossier);
                break;
            }
        }
        saveDossiersToFile(dossiers);
    }

    public void update(DossierMedical updatedDossier, SituationFinanciere situationFinanciere) {
        List<DossierMedical> dossiers = findAll();
        for (int i = 0; i < dossiers.size(); i++) {
            if (dossiers.get(i).getNumeroDossier().equals(updatedDossier.getNumeroDossier())) {
                DossierMedical existingDossier = dossiers.get(i);

                // Update the situationFinanciere in the existingDossier
                existingDossier.setSituationFinanciere(situationFinanciere);


                break;
            }
        }
        saveDossiersToFile(dossiers);
    }


    /*  public void updateConsultationInDossier(Consultation consultation, String dossierId) {
        DossierMedical dossierMedical = findById(dossierId);
        ConsultationDao consultationDao = new ConsultationDao();
        List<Consultation> consultations = consultationDao.findAll();
        for (int i = 0; i < consultations.size(); i++) {
            if (consultations.get(i).getIdConsultation().equals(consultation.getIdConsultation())) {
                consultations.set(i, consultation);
                break;
            }
        }
        saveDossiersToFile(dossiers);
    }
*/
    private void saveDossiersToFile(List<DossierMedical> dossiers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DOSSIERS_FILE))) {
            for (DossierMedical dossier : dossiers) {
                oos.writeObject(dossier);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
