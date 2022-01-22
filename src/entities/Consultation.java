/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Abdulah ZOUBOYE
 */
public class Consultation extends Rv{
    private int idC;
    private double temperature;
    private double tension;
    private String prestationAf;
    
    
        //User
    protected int idUser;
    protected String nom;
    protected String prenom;
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Consultation() {
    }

    public Consultation(int idC, double temperature, double tension, String prestationAf) {
        this.idC = idC;
        this.temperature = temperature;
        this.tension = tension;
        this.prestationAf = prestationAf;
    }

    public Consultation(int idC, double temperature, double tension, String prestationAf, Date date, Time heure, String libelle) {
        super(date, heure, libelle);
        this.idC = idC;
        this.temperature = temperature;
        this.tension = tension;
        this.prestationAf = prestationAf;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public String getPrestationAf() {
        return prestationAf;
    }

    public void setPrestationAf(String prestationAf) {
        this.prestationAf = prestationAf;
    }
    
}
