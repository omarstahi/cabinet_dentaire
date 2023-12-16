package models.acte;

import models.InterventionMedecin;

import java.util.ArrayList;

public class Acte {
    private Long idActe;
    private Long index = 0L;
    private ArrayList<InterventionMedecin> interventions;
    private Double prixDeBase;
    private CategorieActe categorie;
    private String libelle;

    public Long getIdActe() {
        return idActe;
    }

    public void setIdActe() {
        this.idActe = index++;
    }

    public ArrayList<InterventionMedecin> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<InterventionMedecin> interventions) {
        this.interventions = interventions;
    }

    public Acte(Double prixDeBase, CategorieActe categorie, String libelle) {
        setIdActe();
        this.prixDeBase = prixDeBase;
        this.categorie = categorie;
        this.libelle = libelle;
    }

    public Double getPrixDeBase() {
        return prixDeBase;
    }

    public void setPrixDeBase(Double prixDeBase) {
        this.prixDeBase = prixDeBase;
    }

    public CategorieActe getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieActe categorie) {
        this.categorie = categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
