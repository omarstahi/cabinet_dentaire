package services;

import models.Patient;
import java.util.ArrayList;

public class ServiceSec {
    private ArrayList<Patient> patients = new ArrayList<>();

    public void add(Patient patient) {
        // Assign an ID to the patient before adding
        //patient.setId(patients.size() + 1);
        patients.add(patient);
    }


    // (Other methods can be added as needed)
}
