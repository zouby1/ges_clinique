/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Rv;
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
public class ConsultationDao implements IDao<Consultation> {

    DataBase database = new DataBase();
    private final String SQL_BY_ID = "SELECT * FROM `rv` WHERE id_medecin=?";
    private final String SQL_ALL_MED = " SELECT * FROM rv,users WHERE rv.idUser = users.id and id_medecin = ?";
    private final String SQL_UPDATE_CONSTAT = "UPDATE `rv` SET temperature = ?, tension = ? WHERE rv.idR = ?;";

    @Override
    public int insert(Consultation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Consultation ogj) {
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
    public List<Consultation> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Consultation> findAllById(int id) {
        List<Consultation> rvs = new ArrayList<>();
        try {
            database.openConnexion();
            String request = SQL_ALL_MED.replace("?", String.valueOf(id));
            database.initPrepareStatement(request);

            ResultSet rs = database.executeSelect(SQL_ALL_MED);

            while (rs.next()) {
                Consultation rv = new Consultation();
                rv.setIdR(rs.getInt("idR"));
                rv.setDate(rs.getDate("date"));
                rv.setHeure(rs.getTime("heure"));
                rv.setLibelleR(rs.getString("libelleR"));
                rv.setIdUser(rs.getInt("idUser"));
                rv.setNom(rs.getString("nom"));
                rv.setPrenom(rs.getString("prenom"));
                rv.setTemperature(rs.getDouble("temperature"));
                rv.setTension(rs.getDouble("tension"));
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
    public List<Consultation> findRvById(int id) {
        List<Consultation> rvs = new ArrayList<>();
        try {
            database.openConnexion();
            String request = SQL_BY_ID.replace("?", String.valueOf(id));
            database.initPrepareStatement(request);

            ResultSet rs = database.executeSelect(request);

            while (rs.next()) {
                Consultation cons = new Consultation();
                cons.setIdR(rs.getInt("idR"));
                cons.setDate(rs.getDate("date"));
                cons.setHeure(rs.getTime("heure"));
                cons.setLibelleR(rs.getString("libelleR"));
                rvs.add(cons);
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
    public Consultation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> findAllValide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRvSec(Rv rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRvMed(Consultation consultation) {
        int nbreLigne = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_UPDATE_CONSTAT);
        try {
            database.getPs().setInt(1, consultation.getIdR());
            database.getPs().setDouble(2, consultation.getTemperature());
            database.getPs().setDouble(3, consultation.getTension());
            nbreLigne = database.executeUpdate(SQL_UPDATE_CONSTAT);
        } catch (SQLException ex) {
            Logger.getLogger(RvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbreLigne;
        
    }

}
