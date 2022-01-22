/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Rv;
import entities.User;
import java.sql.Date;
import java.sql.Time;
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
public class RvDao implements IDao<Rv> {

    DataBase database = new DataBase();

    /*Request sql*/
    private final String SQL_INSERT = "INSERT INTO `rv` "
            + " ( `date`, `heure`,  `libelleR`, `idUser`) "
            + " VALUES ( ?, ?, ?, ?)";
    private final String SQL_DELETE = "Delete from rv where idR=?";
    private final String SQL_ALL = " SELECT * FROM rv";
    private final String SQL_ALL_SEC = " SELECT * FROM rv,users WHERE rv.idUser = users.id ";
    private final String SQL_ALL_VALIDE = " SELECT * FROM rv,users WHERE rv.idUser = users.id AND id_medecin>0 ";
    private final String SQL_idUser = " SELECT idUser FROM rv";
    private final String SQL_BY_ID = "SELECT * FROM `rv` WHERE idUser=?";
    private final String SQL_UPDATE = "UPDATE `rv` SET date = ? , heure = ? , libelleR = ? WHERE idR = ?;";
    private final String SQL_UPDATE_SEC = "UPDATE `rv` SET date = ? , heure = ? , libelleR = ?,id_medecin = ? WHERE rv.idR = ?;";


    private final String SQL_ALL_by_patient = " SELECT * FROM rv where id = ?";

    @Override
    public int insert(Rv rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Rv rv) {
        return 0;

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
    public List<Rv> findAll() {
        List<Rv> rvs = new ArrayList<>();
        try {
            database.openConnexion();
            database.initPrepareStatement(SQL_ALL_SEC);

            ResultSet rs = database.executeSelect(SQL_ALL_SEC);

            while (rs.next()) {
                Rv rv = new Rv();
                rv.setIdR(rs.getInt("idR"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getTime("heure"));
                rv.setLibelleR(rs.getString("libelleR"));
                rv.setIdUser(rs.getInt("idUser"));
                rv.setNom(rs.getString("nom"));
                rv.setPrenom(rs.getString("prenom"));
                rv.setId_medecin(rs.getInt("id_medecin"));

                rvs.add(rv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            database.closeConnexion();
        }
        System.out.print(rvs.size());
        return rvs;
    }

    @Override
    public List<Rv> findAllValide() {
        List<Rv> rvs = new ArrayList<>();
        try {
            database.openConnexion();
            database.initPrepareStatement(SQL_ALL_VALIDE);

            ResultSet rs = database.executeSelect(SQL_ALL_VALIDE);

            while (rs.next()) {
                Rv rv = new Rv();
                rv.setIdR(rs.getInt("idR"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getTime("heure"));
                rv.setLibelleR(rs.getString("libelleR"));
                rv.setIdUser(rs.getInt("idUser"));
                rv.setId_medecin(rs.getInt("id_medecin"));

                rvs.add(rv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            database.closeConnexion();
        }
        System.out.print(rvs.size());
        return rvs;
    }

    @Override
    public List<Rv> findRvById(int id) {
        List<Rv> rvs = new ArrayList<>();
        try {
            database.openConnexion();
            String request = SQL_BY_ID.replace("?", String.valueOf(id));
            database.initPrepareStatement(request);

            ResultSet rs = database.executeSelect(request);

            while (rs.next()) {
                Rv rv = new Rv();
                rv.setIdR(rs.getInt("idR"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getTime("heure"));
                rv.setLibelleR(rs.getString("libelleR"));
                rvs.add(rv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            database.closeConnexion();
        }
        System.out.print(rvs.size());
        return rvs;
    }

    public Rv insertRv(Date date, Time heure, String libelleR, int idUser) {
        Rv rv = null;
        int nbreLigne = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setDate(1, date);
            database.getPs().setTime(2, heure);
            database.getPs().setString(3, libelleR);
            database.getPs().setString(4, String.valueOf(idUser));

            nbreLigne = database.executeUpdate(SQL_INSERT);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rv;
    }

    public Rv updateRv(Date date, Time heure, String libelleR, int idR) {
        Rv rv = null;
        int result = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_UPDATE);
        try {

            database.getPs().setDate(1, date);
            database.getPs().setTime(2, heure);
            database.getPs().setString(3, libelleR);
            database.getPs().setInt(4, idR);

            result = database.executeUpdate(SQL_UPDATE);
        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rv;
    }

 
    public int updateRvSec(Rv rv) {
        int nbreLigne = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_UPDATE_SEC);
        try {

            database.getPs().setDate(1, rv.getDate());
            database.getPs().setTime(2, rv.getHeure());
            database.getPs().setString(3, rv.getLibelleR());
            database.getPs().setInt(4, rv.getId_medecin());
            database.getPs().setInt(5, rv.getIdR());
            nbreLigne = database.executeUpdate(SQL_UPDATE_SEC);
        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbreLigne;
    }

    public int updateRvMed(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rv annulerRv(int idR) {
        Rv rv = null;
        int result = 0;

        database.openConnexion();
        database.initPrepareStatement(SQL_DELETE);
        try {
            database.getPs().setInt(1, idR);

            result = database.executeUpdate(SQL_DELETE);
        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rv;

    }

    @Override
    public Rv findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rv> findAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
