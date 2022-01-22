/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dto.ConsultationDTO;
import dto.RendezVousDTO;
import entities.Consultation;
import entities.DossierMedical;
import entities.Medicament;
import entities.Ordonance;
import entities.Rv;
import entities.User;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Abdulah ZOUBOYE
 */
public interface IService {

    //GERER_RV
    public int addRv(Rv rv);

    //public boolean updateRv(Rv rv);
    public boolean deleteRv(int id);

    public List<Rv> searchAllRv();
    
    public List<Rv> showAllRvValide();
    
    //listerRv
    public List<Rv> showAllRv();
    //listerCOnsultation
   
    
    
    public List<Rv> showUserRv(int id);
    public List<Consultation> showMedecinRv(int id);

    public Rv searchOneRv(int id);

    //faire un rv 
    public Rv addRv(Date date, Time heure, String libelle, int idUser);
    //modifierPatient
    public Rv updateRv(Date date, Time heure, String libelleR,int idR);
     //modifierSec
    public boolean updateRvSec(Rv rv);
    //modifier medecin
    public boolean updateRvMed(Consultation consultation);
    public boolean updateConsta(Consultation consultation) ;
    //annuler
    public Rv annulerRv(int idR);
    
    //lister COnsultation
    public List<Consultation> showAllConsultation(int id);

    //GERER_ORDONANCE
    public int addOrdonance(Ordonance ordonance);

    //public boolean updateOrdonance(Ordonance ordonance);
    //public boolean deleteOrdonance(int id);
    public List<Ordonance> searchAllOrdonance();

    public Ordonance searchOneOrdonance(int id);

    //GERER_MEDICAMENT
    public int addMedicament(Medicament medicament);

    public Ordonance searchOneMedicament(int id);

    //GERER_DOSSIER_MEDICAL
    public int addDossierMedical(DossierMedical dossierMedical);

    public boolean updateDossierMedical(DossierMedical dossierMedical);

    //public boolean deleteDossierMedical(int id);
    public List<DossierMedical> searchAllDossierMedical();

    public DossierMedical searchOneDossierMedical(int id);

    //GERER_USER
    public int addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);

    public List<User> searchAllUser();

    public User searchOneUser(int id);

    //seconnecter
    public User login(String login, String password);

    //inscription
    public User signin(String nom, String prenom, String login, String password);
    
    public List<RendezVousDTO> ShowAllRvDTO();
    //public List<ConsultationDTO> ShowConsultationDTO(int id);
    

}
