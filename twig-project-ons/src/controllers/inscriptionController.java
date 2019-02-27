package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class inscriptionController {

    @FXML
    private Button entreprise;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button freelancer;

   
    @FXML
    void inscriredonneur(ActionEvent event) throws IOException {
      
        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("../Fxml/ajouterdon_1.fxml"));
        Scene scene = new Scene(root);
   
        primaryStage.setTitle("Sign up Project Owner");
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void inscrirefreelancer(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("../Fxml/ajouterf_1_1.fxml"));
        Scene scene = new Scene(root);
   
        primaryStage.setTitle("Sign up Freelancer");
        
        
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
