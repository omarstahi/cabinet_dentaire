package services;

import Database.DossierDao;
import Database.FileDatabase;
import models.Patient;
import models.antecedantClasses.DossierMedical;

import java.util.ArrayList;

public class ServiceDossierMedical {
    private DossierDao fileDatabase;

    public ServiceDossierMedical(DossierDao fileDatabase) {
        this.fileDatabase = fileDatabase;
    }

    public void addDossier(DossierMedical dossier) {
        fileDatabase.addDossier(dossier);
    }

    public DossierMedical getDossierByNum(String patientId) {
        return fileDatabase.getDossierByNum(patientId);
    }

    public ArrayList<DossierMedical> getAllDossiers() {
        return fileDatabase.getAllDossiers();
    }

//    public void updatePatient(Patient updatedPatient) {fileDatabase.updatePatient(updatedPatient);}
}
