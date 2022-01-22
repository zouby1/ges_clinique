/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.User;
import entities.UserHolder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdulah ZOUBOYE
 */
public class AcceuilMedecinController implements Initializable {

    @FXML
    private Text msgBienvenue;
    @FXML
    private Button btnDeconnecter;
    @FXML
    private Button btnListerRv;
    @FXML
    private Button Rv;
    
    private User currentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserHolder userHolder = UserHolder.getInstance();
        currentUser = userHolder.getUser();
        msgBienvenue.setText("Bienvenue "+ currentUser.getNom() + " " + currentUser.getPrenom());
        msgBienvenue.setVisible(true);
    }

    @FXML
    private void ListerRv(ActionEvent event) {
        try {
            //Cacher la fenetre
            this.msgBienvenue.getScene().getWindow().hide();
            AnchorPane root = null;

            //charger une autre fenetre
            root = FXMLLoader.load(getClass().getResource("/views/ListerRvMedecin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BtnRv(ActionEvent event) {
        try {
            //Cacher la fenetre
            this.msgBienvenue.getScene().getWindow().hide();
            AnchorPane root = null;

            //charger une autre fenetre
            root = FXMLLoader.load(getClass().getResource("/views/RvMedecin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void seDeconnecter(ActionEvent event) {
        try {
            //Cacher la fenetre
            this.msgBienvenue.getScene().getWindow().hide();
            AnchorPane root = null;

            //charger une autre fenetre
            root = FXMLLoader.load(getClass().getResource("/views/Connexion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
