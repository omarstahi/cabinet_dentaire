package models.antecedantClasses;

public enum CategorieAntecedentMedicaux{
    MALADIE_CHRONIQUE,
    CONTRE_INDICATION,
    AUTRE,
    MALADIE_HEREDITAIRE,
    ALLERGIE;
    private Risque risqueAssocie;

    private String description;

    public Risque getRisqueAssocie() {
        return risqueAssocie;
    }

    public void setRisqueAssocie(Risque risqueAssocie) {
        this.risqueAssocie = risqueAssocie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
