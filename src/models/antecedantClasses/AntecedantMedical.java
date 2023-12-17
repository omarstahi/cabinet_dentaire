package models.antecedantClasses;

import models.Patient;

import java.util.ArrayList;

public class AntecedantMedical{
    private Long idAntecedant;

    public Long getIdAntecedant() {
        return idAntecedant;
    }

    public void setIdAntecedant(Long idAntecedant) {
        this.idAntecedant = idAntecedant;
    }

    public ArrayList<Patient> getPatientAvecCeAntecedantMedacal() {
        return patientAvecCeAntecedantMedacal;
    }

    public void setPatientAvecCeAntecedantMedacal(ArrayList<Patient> patientAvecCeAntecedantMedacal) {
        this.patientAvecCeAntecedantMedacal = patientAvecCeAntecedantMedacal;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public CategorieAntecedentMedicaux getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieAntecedentMedicaux categorie) {
        this.categorie = categorie;
    }

    private ArrayList<Patient> patientAvecCeAntecedantMedacal = new ArrayList<>();
    private String libelle;
    private CategorieAntecedentMedicaux categorie;
}
