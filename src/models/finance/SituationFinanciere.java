package models.finance;

import models.antecedantClasses.DossierMedical;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SituationFinanciere implements Serializable {
    private DossierMedical dossierMedical;
    private LocalDate dateCreation;
    private Double montantGlobalRestant;
    private String idSituationFinancier;
    private Double montantGlobalePaye;
    private List<Facture> factures = new ArrayList<Facture>();

    public SituationFinanciere() {
        this.montantGlobalePaye = 0.0;
        this.montantGlobalRestant = 0.0;
    }

    public SituationFinanciere(DossierMedical dossierMedical, LocalDate dateCreation, Double montantGlobalRestant, Double montantGolbalePaye, List<Facture> factures) {
        this.dossierMedical = dossierMedical;
        this.dateCreation = dateCreation;
        this.montantGlobalRestant = montantGlobalRestant;
        this.montantGlobalePaye = montantGolbalePaye;
        this.factures = factures;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getMontantGlobalRestant() {
        return montantGlobalRestant;
    }

    public void setMontantGlobalRestant(Double montantRestant) {
        montantGlobalRestant = montantRestant;
    }

    public String getIdSituationFinancier() {
        return idSituationFinancier;
    }

    public void setIdSituationFinancier() {
        this.idSituationFinancier = UUID.randomUUID().toString();
    }

    public Double getMontantGolbalePaye() {
        return montantGlobalePaye;
    }

    public void setMontantGolbalePaye(Double montantPaye) {
        this.montantGlobalePaye = montantPaye;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public void addFacture(Facture facture){
        factures.add(facture);
    }

    @Override
    public String toString() {
        return "SituationFinanciere{" +
                "dossierMedical=" + dossierMedical +
                ", dateCreation=" + dateCreation +
                ", montantGlobalRestant=" + montantGlobalRestant +
                ", montantGolbalePaye=" + montantGlobalePaye +
                ", factures=" + factures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SituationFinanciere that = (SituationFinanciere) o;
        return Objects.equals(dossierMedical, that.dossierMedical) && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(montantGlobalRestant, that.montantGlobalRestant) && Objects.equals(montantGlobalePaye, that.montantGlobalePaye) && Objects.equals(factures, that.factures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dossierMedical, dateCreation, montantGlobalRestant, montantGlobalePaye, factures);
    }
}
