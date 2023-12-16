package models;

import java.time.LocalDate;
import java.util.Objects;

public class Secretaire extends User{

    private  Double SalaireDeBase;
    private LocalDate dateDeRetoure;
    private Assurance assurance;
    private StatusEmploye statusEmploye;
    private Double prime;

    public Secretaire(String username, String password) {
        super(username, password);
    }

    public Secretaire(String username, String password, Double salaireDeBase, LocalDate dateDeRetoure, Assurance assurance, StatusEmploye statusEmploye, Double prime) {
        super(username, password);
        SalaireDeBase = salaireDeBase;
        this.dateDeRetoure = dateDeRetoure;
        this.assurance = assurance;
        this.statusEmploye = statusEmploye;
        this.prime = prime;
    }

    public Double getSalaireDeBase() {
        return SalaireDeBase;
    }

    public void setSalaireDeBase(Double salaireDeBase) {
        SalaireDeBase = salaireDeBase;
    }

    public LocalDate getDateDeRetoure() {
        return dateDeRetoure;
    }

    public void setDateDeRetoure(LocalDate dateDeRetoure) {
        this.dateDeRetoure = dateDeRetoure;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public StatusEmploye getStatusEmploye() {
        return statusEmploye;
    }

    public void setStatusEmploye(StatusEmploye statusEmploye) {
        this.statusEmploye = statusEmploye;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secretaire that = (Secretaire) o;
        return Objects.equals(SalaireDeBase, that.SalaireDeBase) && Objects.equals(dateDeRetoure, that.dateDeRetoure) && assurance == that.assurance && statusEmploye == that.statusEmploye && Objects.equals(prime, that.prime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SalaireDeBase, dateDeRetoure, assurance, statusEmploye, prime);
    }
}
