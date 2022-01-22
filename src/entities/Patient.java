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
public class Patient extends User{
    private int codeP;
    private String antecedent;
    private final String ROLE="ROLE_PATIENT";

    public Patient() {
        this.role=ROLE;
    }

    public Patient(int codeP, String antecedent, String nom, String prenom, String login, String pwd, String role) {
        super(nom, prenom, login, pwd, role);
        this.codeP = codeP;
        this.antecedent = antecedent;
        this.role=ROLE;
    }

    public Patient(int codeP, String antecedent, String nom, String prenom) {
        super(nom, prenom);
        this.codeP = codeP;
        this.antecedent = antecedent;
        this.role=ROLE;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPwd() {
        return pwd;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
    
}
