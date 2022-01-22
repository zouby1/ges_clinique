/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DataBase;
import entities.Rv;;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Abdulah ZOUBOYE
 */
public class mainTest {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        DataBase data = new DataBase();
        
        
        data.openConnexion();
        
        
        
       String sql="select * FROM rv";
       data.initPrepareStatement(sql);
       ResultSet rs=data.executeSelect(sql);
       List<Rv> rvs=new ArrayList();
       while (rs.next()){
           //Mapping relationnelle to objet
           Rv rv=new Rv(rs.getInt("idR"),rs.getDate("date"),rs.getTime("heure"),rs.getString("libelleR"));
           rvs.add(rv);
           
       }
       
       //fermeture connexion
       data.closeConnexion();
       rvs.forEach(System.out::println);

    }
    
}
