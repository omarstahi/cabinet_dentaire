package models;

import models.acte.Acte;
import models.consultation.Consultation;

public class InterventionMedecin {
    private Long idIntervention;
    private static Long index = 0L;
    private String noteMedecin;
    private Double prixPatient;
    private Long dent;
    private Acte acte;
    private Consultation consultation;

    public Long getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention() {
        this.idIntervention = index++;
    }

    public static Long getIndex() {
        return index;
    }

    public static void setIndex(Long index) {
        InterventionMedecin.index = index;
    }

    public String getNoteMedecin() {
        return noteMedecin;
    }

    public void setNoteMedecin(String noteMedecin) {
        this.noteMedecin = noteMedecin;
    }

    public Double getPrixPatient() {
        return prixPatient;
    }

    public void setPrixPatient(Double prixPatient) {
        this.prixPatient = prixPatient;
    }

    public Long getDent() {
        return dent;
    }

    public void setDent(Long dent) {
        this.dent = dent;
    }

    public Acte getActe() {
        return acte;
    }

    public InterventionMedecin(String noteMedecin, Double prixPatient, Long dent, Acte acte, Consultation consultation) {
        setIdIntervention();
        this.noteMedecin = noteMedecin;
        this.prixPatient = prixPatient;
        this.dent = dent;
        this.acte = acte;
        this.consultation = consultation;
    }

    public void setActe(Acte acte) {
        this.acte = acte;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "InterventionMedecin{" +
                "noteMedecin='" + noteMedecin + '\'' +
                ", prixPatient=" + prixPatient +
                ", dent=" + dent +
                //", acte=" + acte +
                //", consultation=" + consultation +
                '}';
    }
}
