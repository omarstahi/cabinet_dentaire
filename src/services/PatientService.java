package services;

import Database.FileDatabase;
import models.Patient;
import java.util.List;

public class PatientService {

    private FileDatabase fileDatabase;

    public PatientService(FileDatabase fileDatabase) {
        this.fileDatabase = fileDatabase;
    }

    public void addPatient(Patient patient) {
        fileDatabase.addPatient(patient);
    }

    public Patient getPatientById(String patientId) {
        return fileDatabase.getPatientById(patientId);
    }

    public List<Patient> getAllPatients() {
        return fileDatabase.getAllPatients();
    }

    public void updatePatient(Patient updatedPatient) {
        fileDatabase.updatePatient(updatedPatient);
    }

    public void deletePatient(String patientId) {
        fileDatabase.deletePatient(patientId);
    }
}
