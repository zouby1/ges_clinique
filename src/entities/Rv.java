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
public class Rv {
    protected int idR;
    protected Date date;
    protected Time heure;
    protected String libelleR;
    
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
    //medecin
    protected int id_medecin;
    protected String nom_medecin;
    protected String prenom_medecin;
    

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public String getNom_medecin() {
        return nom_medecin;
    }

    public void setNom_medecin(String nom_medecin) {
        this.nom_medecin = nom_medecin;
    }

    public String getPrenom_medecin() {
        return prenom_medecin;
    }

    public void setPrenom_medecin(String prenom_medecin) {
        this.prenom_medecin = prenom_medecin;
    }
    
    
    
    


    public Rv() {
    }

    public Rv(int idR, Date date, Time heure, String libeller) {
        this.idR = idR;
        this.date = date;
        this.heure = heure;
        this.libelleR = libelleR;
    }

    public Rv(Date date, Time heure, String libeller) {
        this.date = date;
        this.heure = heure;
        this.libelleR = libelleR;
    }
    public Rv(int idR, String libelleR) {
        this.idR = idR;
        this.libelleR = libelleR;
    }


    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public String getLibelleR() {
        return libelleR;
    }

    public void setLibelleR(String libelleR) {
        this.libelleR = libelleR;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    
    @Override
    public String toString() {
        return "Rv{" + "idR=" + idR + ", date=" + date + ", heure=" + heure + ", libelleR=" + libelleR + '}';
    }

 
    
    
}
