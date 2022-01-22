/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Abdulah ZOUBOYE
 */
public class Medicament {
    private int codeM;
    private String nomM;
    private String pesologie;

    public Medicament() {
            
    }
    public Medicament(int codeM, String nomM, String pesologie) {
        this.codeM = codeM;
        this.nomM = nomM;
        this.pesologie = pesologie;
    }

    public int getCodeM() {
        return codeM;
    }

    public void setCodeM(int codeM) {
        this.codeM = codeM;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPesologie() {
        return pesologie;
    }

    public void setPesologie(String pesologie) {
        this.pesologie = pesologie;
    }
    



    
}
