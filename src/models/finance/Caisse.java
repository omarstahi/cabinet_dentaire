package models.finance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Caisse {

    private List<SituationFinanciere> situationFinancieres = new ArrayList<SituationFinanciere>();
    private Double recetteDuJours;
    private Double RecetteDuMois;
    private Double RecetteDuLAnnee;
    private  Long idCaisse;

    public Caisse() {
    }

    public Caisse(List<SituationFinanciere> situationFinancieres, Double recetteDuJours, Double recetteDuMois, Double recetteDuLAnnee, Long idCaisse) {
        this.situationFinancieres = situationFinancieres;
        this.recetteDuJours = recetteDuJours;
        RecetteDuMois = recetteDuMois;
        RecetteDuLAnnee = recetteDuLAnnee;
        this.idCaisse = idCaisse;
    }

    public List<SituationFinanciere> getSituationFinancieres() {
        return situationFinancieres;
    }

    public void setSituationFinancieres(List<SituationFinanciere> situationFinancieres) {
        this.situationFinancieres = situationFinancieres;
    }

    public Double getRecetteDuJours() {
        return recetteDuJours;
    }

    public void setRecetteDuJours(Double recetteDuJours) {
        this.recetteDuJours = recetteDuJours;
    }

    public Double getRecetteDuMois() {
        return RecetteDuMois;
    }

    public void setRecetteDuMois(Double recetteDuMois) {
        RecetteDuMois = recetteDuMois;
    }

    public Double getRecetteDuLAnnee() {
        return RecetteDuLAnnee;
    }

    public void setRecetteDuLAnnee(Double recetteDuLAnnee) {
        RecetteDuLAnnee = recetteDuLAnnee;
    }

    public Long getIdCaisse() {
        return idCaisse;
    }

    public void setIdCaisse(Long idCaisse) {
        this.idCaisse = idCaisse;
    }

    @Override
    public String toString() {
        return "Caisse{" +
                "situationFinancieres=" + situationFinancieres +
                ", recetteDuJours=" + recetteDuJours +
                ", RecetteDuMois=" + RecetteDuMois +
                ", RecetteDuLAnnee=" + RecetteDuLAnnee +
                ", idCaisse=" + idCaisse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caisse caisse = (Caisse) o;
        return Objects.equals(situationFinancieres, caisse.situationFinancieres) && Objects.equals(recetteDuJours, caisse.recetteDuJours) && Objects.equals(RecetteDuMois, caisse.RecetteDuMois) && Objects.equals(RecetteDuLAnnee, caisse.RecetteDuLAnnee) && Objects.equals(idCaisse, caisse.idCaisse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(situationFinancieres, recetteDuJours, RecetteDuMois, RecetteDuLAnnee, idCaisse);
    }
}
