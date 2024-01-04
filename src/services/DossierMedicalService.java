package services;

import Database.dao.DossierDao;
import models.antecedantClasses.DossierMedical;
import models.finance.SituationFinanciere;

import java.util.ArrayList;

public class DossierMedicalService {
    private DossierDao fileDatabase;

    public DossierMedicalService(DossierDao fileDatabase) {
        this.fileDatabase = fileDatabase;
    }

    public void addDossier(DossierMedical dossier) {
        fileDatabase.save(dossier);
    }

    public DossierMedical getDossierByNum(String patientId) {
        return fileDatabase.findById(patientId);
    }

    public ArrayList<DossierMedical> getAllDossiers() {
        return fileDatabase.findAll();
    }

    public void updateDossier(DossierMedical updatedDossier) {fileDatabase.update(updatedDossier);}

    public void updateDossierWithSituation(DossierMedical dossierMedical, SituationFinanciere situationFinanciere){
        fileDatabase.update(dossierMedical, situationFinanciere);
    }
}
