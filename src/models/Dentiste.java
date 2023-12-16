package models;

import models.finance.SituationFinanciere;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dentiste extends User{

    private LocalDate dateRetourConge;

    public Dentiste(String username, String password) {
        super(username, password);
    }

}
