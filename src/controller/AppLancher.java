package controller;
import Database.FileDatabase;
import UI.Login.Login;
import services.PatientService;

public class AppLancher{
    public static void main(String[] args){
        new Login();
        FileDatabase DB = new FileDatabase();
        new PatientService(DB);
    }
}
