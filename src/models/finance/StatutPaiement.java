package models.finance;

public enum StatutPaiement {
    EN_ATTENTTE,
    IMPAYE,
    PAYE;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
