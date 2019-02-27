/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import controllers.AfficherFront;
import controllers.AfficherFrontTasks;
import entities.Offers;
import entities.ProjectJoinTasks;
import entities.Projects;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.OffersService;
import services.ValidationService;
import javafx.scene.control.TextField;
import services.ProjectsService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PostulerController implements Initializable {

    @FXML
    private TextField apply_title;
    @FXML
    private TextField apply_description;
    @FXML
    private TextField apply_category;
    @FXML
    private Button apply_button;
    @FXML
    private TextField apply_bid;
    @FXML
    private TextField apply_estimatedDuration;
    @FXML
    private TextArea apply_motivationLetter;
    @FXML
    private TextField textArea_idTask;
    @FXML
    private TextField textArea_idProject;
    //  private Label errormsg;
    @FXML
    private Label errormsg1;
    @FXML
    private Label errormsg2;
    @FXML
    private Label errormsg3;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OffersService post_task = new OffersService();
        ProjectsService post_project = new ProjectsService();

        Projects p = new Projects();
        ArrayList<ProjectJoinTasks> tab = new ArrayList();

        p = (Projects) post_project.getById(AfficherFrontTasks.idPro);

        tab = (ArrayList<ProjectJoinTasks>) post_task.getOffersBytask(AfficherFrontTasks.idTask, AfficherFrontTasks.idPro);
        // System.out.println(tab.get(0));
        if (AfficherFrontTasks.idTask != 0) // postuler pour un task
        {
            System.out.println("heyyyyy!!!!");
            apply_title.setText(tab.get(0).getTitleT());
            apply_description.setText(tab.get(0).getDescriptionT());
            apply_category.setText(tab.get(0).getCategory());
            // apply_bid.getText()
            // apply_estimatedDuration
            //apply_motivationLetter

            textArea_idTask.setText(Integer.toString(tab.get(0).getIdT()));
            textArea_idProject.setText(Integer.toString(tab.get(0).getId()));

        } else // // postuler pour un projet
        {

            apply_title.setText(p.getTitle());
            apply_description.setText(p.getDescription());
            apply_category.setText(p.getCategory());

            //  textArea_idTask.setText(Integer.toString());
            textArea_idProject.setText(Integer.toString(p.getId()));

        }

        //*********************************************************************************
        //**********************************************************************************
        // recuperation des id pour postuler
        int idp = AfficherFrontTasks.idPro;
        System.out.println(" id projet récupéré: " + idp);

        Integer idt = AfficherFrontTasks.idTask;
        System.out.println(" id task récupéré: " + idt);

        apply_button.setOnAction(e -> {
            // controle de saisie :
            boolean validform = true;

            ValidationService validservice = new ValidationService();
            if (!validservice.validateTextField(apply_bid)) {
                errormsg1.setText("The price is required");
                validform = false;
            }

            if (!validservice.validateTextField(apply_estimatedDuration)) {
                errormsg2.setText("The estimated duration is required");
                validform = false;
            }
            if (!validservice.validateTextArea(apply_motivationLetter)) {
                errormsg3.setText("The motivation letter is required");
                validform = false;
            }

            OffersService ps = new OffersService();
            //  Offers(int taskId, int projectId, int freelancerId, int bid, int duration, Date offerDate, String motivationalLetter

            //(java.sql.Date) new Date() ghaltaa lezem na3ml sql date
            // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            // new Date(System.currentTimeMillis());
            try {
                if (idt == 0) {
                    // Integer taskId, int projectId, int freelancerId, int bid, int duration, java.sql.Date offerDate, String motivationalLetter)
                    Offers o = new Offers(null, Integer.parseInt(textArea_idProject.getText()), 5, Integer.parseInt(apply_bid.getText()), Integer.parseInt(apply_estimatedDuration.getText()), apply_motivationLetter.getText());
                    ps.insert(o);

                    System.out.println("Postultion enregistrée");

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Apply success");
                    alert.setContentText("You applied for a Project successfully");

                    alert.showAndWait();

                    // ps.insert(new Offers(null,Integer.parseInt(textArea_idProject.getText()), 5, Integer.parseInt(apply_bid.getText()), Integer.parseInt(apply_estimatedDuration.getText()), apply_motivationLetter.getText()));
                } else {
                    ps.insert(new Offers(Integer.parseInt(textArea_idTask.getText()), Integer.parseInt(textArea_idProject.getText()), 5, Integer.parseInt(apply_bid.getText()), Integer.parseInt(apply_estimatedDuration.getText()), apply_motivationLetter.getText()));
                    
                    
                    System.out.println("Postultion enregistrée");

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Apply success");
                    alert.setContentText("You applied for a Task successfully");

                    alert.showAndWait();
                }

                // errormsg1.setText("");
            } catch (NumberFormatException ex) {
                System.out.println("entrer des valeurs dans les chanps price et duration");
            }

            Parent root;

            // redirection seulement si les champs sont valides 
            // lezem nzid condition lhné

            /*   try {
                root = FXMLLoader.load(getClass().getResource("AfficherOffers.fxml"));
                apply_button.getScene().setRoot(root);
           
                
            } catch (IOException ex) {
                Logger.getLogger(PostulerController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        });

    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

}
