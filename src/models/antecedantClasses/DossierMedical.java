package models.antecedantClasses;

import models.Dentiste;
import models.Patient;
import models.consultation.Consultation;
import models.finance.SituationFinanciere;
import models.finance.StatutPaiement;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DossierMedical implements Serializable {
    private List <Consultation> Consultations = new ArrayList<Consultation>();
    private LocalDate dateCreation ;
    private Patient patient;
    private SituationFinanciere situationFinanciere;
    private Dentiste medcinTraitant;
    private String numeroDossier;
    private StatutPaiement statutPaiement;

    public DossierMedical() {
    }

    public DossierMedical(List<Consultation> consultations, LocalDate dateCreation, Patient patient, SituationFinanciere situationFinanciere, Dentiste medcinTraitant, String numeroDossier, StatutPaiement statutPaiement) {
        Consultations = consultations;
        this.dateCreation = dateCreation;
        this.patient = patient;
        this.situationFinanciere = situationFinanciere;
        this.medcinTraitant = medcinTraitant;
        this.numeroDossier = numeroDossier;
        this.statutPaiement = statutPaiement;
    }

    public List<Consultation> getConsultations() {
        return Consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        Consultations = consultations;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public SituationFinanciere getSituationFinanciere() {
        return situationFinanciere;
    }

    public void setSituationFinanciere(SituationFinanciere situationFinanciere) {
        this.situationFinanciere = situationFinanciere;
    }

    public Dentiste getMedcinTraitant() {
        return medcinTraitant;
    }

    public void setMedcinTraitant(Dentiste medcinTraitant) {
        this.medcinTraitant = medcinTraitant;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public StatutPaiement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutPaiement statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "Consultations=" + Consultations +
                ", dateCreation=" + dateCreation +
                ", patient=" + patient +
                ", situationFinanciere=" + situationFinanciere +
                ", medcinTraitant=" + medcinTraitant +
                ", numeroDossier='" + numeroDossier + '\'' +
                ", statutPaiement=" + statutPaiement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierMedical that = (DossierMedical) o;
        return Objects.equals(Consultations, that.Consultations) && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(patient, that.patient) && Objects.equals(situationFinanciere, that.situationFinanciere) && Objects.equals(medcinTraitant, that.medcinTraitant) && Objects.equals(numeroDossier, that.numeroDossier) && statutPaiement == that.statutPaiement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Consultations, dateCreation, patient, situationFinanciere, medcinTraitant, numeroDossier, statutPaiement);
    }
}
