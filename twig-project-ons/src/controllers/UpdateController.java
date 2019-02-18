package controllers;

import entite.Freelancer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import service.FreelancerService;

public class UpdateController {

    @FXML
    private TextField languages;

    @FXML
    private TextField maxHourlyFee;

    @FXML
    private TextField gender;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button update;

    @FXML
    private TextField ranking;

    @FXML
    private TextField minHourlyFee;

    @FXML
    private TextField cvLink;

   
    @FXML
    void update(ActionEvent event) {
         FreelancerService fservice=new FreelancerService();
         fservice.update(new Freelancer(1,languages.getText(), Integer.parseInt(minHourlyFee.getText())
                 ,Integer.parseInt(gender.getText()) ,cvLink.getText(),
                 Integer.parseInt(maxHourlyFee.getText()) , 
                 ranking.getText()
         ));
         System.out.println("modifier");

    }

}
