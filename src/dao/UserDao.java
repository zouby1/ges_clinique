/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Rv;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdulah ZOUBOYE
 */
public class UserDao implements IDao<User> {

    private final String SQL_MEDECIN = "SELECT * FROM users where role LIKE 'medecin'";
    private final String SQL_ALL = "SELECT * FROM users";
    private final String SQL_LOGIN = "SELECT * FROM users WHERE login =  ? AND password = ? ";
    private final String SQL_BY_ID = "SELECT * FROM users WHERE id =  ?";
    private final String SQL_INSERT = "INSERT INTO `users` (`nom`, `prenom`, `login`, `password`) VALUES (?, ?, ?, ?)";
    private final DataBase database = new DataBase();

    @Override
    public int insert(User ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(User ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancel(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        List<User> usr = new ArrayList<>();
        try {
            database.openConnexion();
            database.initPrepareStatement(SQL_MEDECIN);

            ResultSet rs = database.executeSelect(SQL_MEDECIN);

            while (rs.next()) {
                User us = new User();

                us.setId(rs.getInt("id"));
                us.setNom(rs.getString("nom"));
                us.setPrenom(rs.getString("prenom"));
                us.setLogin(rs.getString("login"));
                us.setRole(rs.getString("role"));
                usr.add(us);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            database.closeConnexion();
        }
        System.out.print(usr.size());
        return usr;
    }

    @Override
    public User findById(int id) {
        User user = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }
//se connecter

    public User findUserLoginAndPassword(String login, String password) {
        User user = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_LOGIN);
        try {
            database.getPs().setString(1, login);
            database.getPs().setString(2, password);
            ResultSet rs = database.executeSelect(SQL_LOGIN);

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    //s'inscrire
    public User insertUser(String nom, String prenom, String login, String password) {
        User user = null;
        int nbreLigne = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setString(1, nom);
            database.getPs().setString(2, prenom);
            database.getPs().setString(3, login);
            database.getPs().setString(4, password);

            nbreLigne = database.executeUpdate(SQL_INSERT);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> findRvById(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllValide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRvSec(Rv rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRvMed(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
