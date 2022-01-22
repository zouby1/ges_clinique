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
public class Prestation extends Rv{
    private int idP;
    private String libelleP;

    public Prestation() {
    }

    public Prestation(int idP, String libelle) {
        this.idP = idP;
        this.libelleR = libelle;
    }

    public Prestation(int idP, String libelleP, Date date, Time heure, String libelle) {
        super(date, heure, libelle);
        this.idP = idP;
        this.libelleP = libelleP;
    }
    

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }
    
    
}

