package models;

import models.antecedantClasses.AntecedantMedical;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Personne{
    private LocalDate dateNaissance;
    Mutuelle mutuelle;
    ArrayList<AntecedantMedical> AntecedantMedicaux;


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
