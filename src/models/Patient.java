package models;

import models.Mutuelle;
import models.Personne;
import models.antecedantClasses.AntecedantMedical;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Personne implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;

    private LocalDate dateNaissance;
    private Mutuelle mutuelle;
    private ArrayList<AntecedantMedical> AntecedantMedicaux = new ArrayList<>();

    public Patient() {

        // Empty constructor
    }

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

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + this.getNom() + '\'' +
                ", date=" + this.getDateNaissance() +
                ", mutuelle=" + this.getMutuelle() +
                ", ID=" + this.getId() +
                '}';
    }
}
