package models.acte;

import models.InterventionMedecin;

import java.util.ArrayList;
import java.util.UUID;

public class Acte {
    private String idActe;
    private Long index = 0L;
    private ArrayList<InterventionMedecin> interventions = new ArrayList<>();
    private Double prixDeBase;
    private CategorieActe categorie;
    private String libelle;

    public String getIdActe() {
        return idActe;
    }

    public void setIdActe() {
        this.idActe = UUID.randomUUID().toString();
    }

    public ArrayList<InterventionMedecin> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<InterventionMedecin> interventions) {
        this.interventions = interventions;
    }

    public Acte() {}

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
