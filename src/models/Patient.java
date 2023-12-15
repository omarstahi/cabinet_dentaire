package models;

import models.Mutuelle;
import models.Personne;
import models.antecedantClasses.AntecedantMedical;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Personne {
    private LocalDate dateNaissance;
    Mutuelle mutuelle;
    ArrayList<AntecedantMedical> AntecedantMedicaux;

    public Patient(String nom, String prenom, String adresse, String telephone, String email, String cin, LocalDate dateNaissance, Mutuelle mutuelle, ArrayList<AntecedantMedical> antecedantMedicaux) {
        super(nom, prenom, adresse, telephone, email, cin);
        this.dateNaissance = dateNaissance;
        this.mutuelle = mutuelle;
        AntecedantMedicaux = antecedantMedicaux;
    }

    public Patient(String nom, String prenom, String adresse, String telephone, String email, String cin) {
        super(nom, prenom, adresse, telephone, email, cin);
    }


    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
        this.mutuelle = mutuelle;
    }

    public ArrayList<AntecedantMedical> getAntecedantMedicaux() {
        return AntecedantMedicaux;
    }

    public void setAntecedantMedicaux(ArrayList<AntecedantMedical> antecedantMedicaux) {
        AntecedantMedicaux = antecedantMedicaux;
    }
}
