package controllers;

import entite.Freelancer;
import entite.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import service.FreelancerService;


public class profilController {

     @FXML
    private TextField languages;

    @FXML
    private TextField maxHourlyFee;

    @FXML
    private TextField gender;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField ranking;

    @FXML
    private Button Ajouter;

    @FXML
    private TextField minHourlyFee;

    @FXML
    private TextField cvLink;

    @FXML
    void Ajouter(ActionEvent event) {
     
  
         FreelancerService fservice=new FreelancerService();
         fservice.insert(new Freelancer(1,languages.getText(), Integer.parseInt(minHourlyFee.getText())
                 ,Integer.parseInt(gender.getText()) ,cvLink.getText(),
                 Integer.parseInt(maxHourlyFee.getText()) , 
                 ranking.getText()
         ));
         System.out.println("ajout");
         

    }

}
