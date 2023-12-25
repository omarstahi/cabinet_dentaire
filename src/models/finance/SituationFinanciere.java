package models.finance;

import models.antecedantClasses.DossierMedical;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SituationFinanciere implements Serializable {
    private DossierMedical dossierMedical;
    private LocalDate dateCreation;
    private Double montantGlobalRestant;
    private Long idSDituationFinancier;
    private Double montantGolbalePaye;
    private List<Facture> factures = new ArrayList<Facture>();

    public SituationFinanciere() {
    }

    public SituationFinanciere(DossierMedical dossierMedical, LocalDate dateCreation, Double montantGlobalRestant, Long idSDituationFinancier, Double montantGolbalePaye, List<Facture> factures) {
        this.dossierMedical = dossierMedical;
        this.dateCreation = dateCreation;
        this.montantGlobalRestant = montantGlobalRestant;
        this.idSDituationFinancier = idSDituationFinancier;
        this.montantGolbalePaye = montantGolbalePaye;
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

    public void setMontantGlobalRestant(Double montantGlobalRestant) {
        this.montantGlobalRestant = montantGlobalRestant;
    }

    public Long getIdSDituationFinancier() {
        return idSDituationFinancier;
    }

    public void setIdSDituationFinancier(Long idSDituationFinancier) {
        this.idSDituationFinancier = idSDituationFinancier;
    }

    public Double getMontantGolbalePaye() {
        return montantGolbalePaye;
    }

    public void setMontantGolbalePaye(Double montantGolbalePaye) {
        this.montantGolbalePaye = montantGolbalePaye;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    @Override
    public String toString() {
        return "SituationFinanciere{" +
                "dossierMedical=" + dossierMedical +
                ", dateCreation=" + dateCreation +
                ", montantGlobalRestant=" + montantGlobalRestant +
                ", idSDituationFinancier=" + idSDituationFinancier +
                ", montantGolbalePaye=" + montantGolbalePaye +
                ", factures=" + factures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SituationFinanciere that = (SituationFinanciere) o;
        return Objects.equals(dossierMedical, that.dossierMedical) && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(montantGlobalRestant, that.montantGlobalRestant) && Objects.equals(idSDituationFinancier, that.idSDituationFinancier) && Objects.equals(montantGolbalePaye, that.montantGolbalePaye) && Objects.equals(factures, that.factures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dossierMedical, dateCreation, montantGlobalRestant, idSDituationFinancier, montantGolbalePaye, factures);
    }
}
