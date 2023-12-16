package models.finance;

import models.consultation.Consultation;

import java.time.LocalDate;
import java.util.Objects;

public class Facture {
    private Double montantRestant;
    private  SituationFinanciere situationFinanciere;
    private Double montantPaye;
    private  Long idFacture;
    private LocalDate dateFactureation;
    private Double MontantTotal ;
    private Consultation consultation;
    private TypePaiement typePaiement;

    public Facture() {
    }

    public Facture(Double montantRestant, SituationFinanciere situationFinanciere, Double montantPaye, Long idFacture, LocalDate dateFactureation, Double montantTotal, Consultation consultation, TypePaiement typePaiement) {
        this.montantRestant = montantRestant;
        this.situationFinanciere = situationFinanciere;
        this.montantPaye = montantPaye;
        this.idFacture = idFacture;
        this.dateFactureation = dateFactureation;
        MontantTotal = montantTotal;
        this.consultation = consultation;
        this.typePaiement = typePaiement;
    }

    public Double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(Double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public SituationFinanciere getSituationFinanciere() {
        return situationFinanciere;
    }

    public void setSituationFinanciere(SituationFinanciere situationFinanciere) {
        this.situationFinanciere = situationFinanciere;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public LocalDate getDateFactureation() {
        return dateFactureation;
    }

    public void setDateFactureation(LocalDate dateFactureation) {
        this.dateFactureation = dateFactureation;
    }

    public Double getMontantTotal() {
        return MontantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        MontantTotal = montantTotal;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "montantRestant=" + montantRestant +
                ", situationFinanciere=" + situationFinanciere +
                ", montantPaye=" + montantPaye +
                ", idFacture=" + idFacture +
                ", dateFactureation=" + dateFactureation +
                ", MontantTotal=" + MontantTotal +
                ", consultation=" + consultation +
                ", typePaiement=" + typePaiement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Objects.equals(montantRestant, facture.montantRestant) && Objects.equals(situationFinanciere, facture.situationFinanciere) && Objects.equals(montantPaye, facture.montantPaye) && Objects.equals(idFacture, facture.idFacture) && Objects.equals(dateFactureation, facture.dateFactureation) && Objects.equals(MontantTotal, facture.MontantTotal) && Objects.equals(consultation, facture.consultation) && typePaiement == facture.typePaiement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(montantRestant, situationFinanciere, montantPaye, idFacture, dateFactureation, MontantTotal, consultation, typePaiement);
    }
}
