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
import java.util.UUID;

public class DossierMedical implements Serializable {
    private ArrayList <Consultation> Consultations = new ArrayList<>();
    private LocalDate dateCreation ;
    private Patient patient;
    private SituationFinanciere situationFinanciere;
    private String numeroDossier;
    private StatutPaiement statutPaiement;

    public DossierMedical() {
    }

    public DossierMedical(ArrayList<Consultation> consultations, LocalDate dateCreation, Patient patient, SituationFinanciere situationFinanciere, StatutPaiement statutPaiement) {
        setNumeroDossier();
        Consultations = consultations;
        this.dateCreation = dateCreation;
        this.patient = patient;
        this.situationFinanciere = situationFinanciere;
        this.numeroDossier = numeroDossier;
        this.statutPaiement = statutPaiement;
    }

    public List<Consultation> getConsultations() {
        return Consultations;
    }

    public void setConsultations(ArrayList<Consultation> consultations) {
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

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier() {
        this.numeroDossier = UUID.randomUUID().toString();
    }

    public StatutPaiement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutPaiement statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public void addConsultation(Consultation consultation) {
        Consultations.add(consultation);
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
       //         "Consultations=" + Consultations +
         //       ", dateCreation=" + dateCreation +
                ", patient=" + patient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierMedical that = (DossierMedical) o;
        return Objects.equals(Consultations, that.Consultations) && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(patient, that.patient) && Objects.equals(situationFinanciere, that.situationFinanciere) && Objects.equals(numeroDossier, that.numeroDossier) && statutPaiement == that.statutPaiement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Consultations, dateCreation, patient, situationFinanciere, numeroDossier, statutPaiement);
    }
}
