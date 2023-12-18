package controller;
import Database.FileDatabase;
import UI.Login.Login;
import services.PatientService;

public class AppLancher{
    public static void main(String[] args){
        FileDatabase fileDatabase = new FileDatabase();
        PatientService patientService = new PatientService(fileDatabase);
        Login l = new Login();
    }
}
