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
public class Medecin extends User {
    private String statu;
    private final String ROLE="ROLE_MEDECIN";

    public Medecin() {
        this.role=ROLE;
    }

    public Medecin(String statu, int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.statu = statu;
        this.role=ROLE;
    }

    public Medecin(String statu, int id, String nom, String prenom, String login, String pwd, String role) {
        super(id, nom, prenom, login, pwd, role);
        this.statu = statu;
        this.role=ROLE;
    }

    public Medecin(String statu, String nom, String prenom) {
        super(nom, prenom);
        this.statu = statu;
        this.role=ROLE;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
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

    /**
     *
     * @param nom
     */
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
