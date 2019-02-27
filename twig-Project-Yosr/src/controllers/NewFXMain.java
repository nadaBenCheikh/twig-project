package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author esprit
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


      //  Parent root= FXMLLoader.load(getClass().getResource("../Fxml/ajouterAmis.fxml"));
       //  Parent root = FXMLLoader.load(getClass().getResource("../Fxml/RecommanderUnAmi.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("../Fxml/PrivateMessagesInbox.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("../Fxml/BarChart.fxml"));
       //  Parent root= FXMLLoader.load(getClass().getResource("../Fxml/Apply.fxml"));
        // Parent root= FXMLLoader.load(getClass().getResource("../Fxml/AfficherOffers.fxml"));
      //  Parent root= FXMLLoader.load(getClass().getResource("../Fxml/displayAllFriends.fxml"));
      
       //Parent root= FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
   
      Parent root= FXMLLoader.load(getClass().getResource("../Fxml/HomeYosr.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
