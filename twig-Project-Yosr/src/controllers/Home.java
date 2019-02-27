/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Home implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnListProject;
    @FXML
    private Button btnOffers;
    @FXML
    private Button btnColabs;
    @FXML
    private Button btnAddProject;
    @FXML
    private Button btnAddTask;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherAllProjectsFront(ActionEvent event) throws IOException {
       /* Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
       
       pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    private void afficherListProject(ActionEvent event) throws IOException {
        /*
       Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/AfficherOffers.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
        
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/AfficherOffers.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    private void afficherOffer(ActionEvent event) throws IOException {
      /*  Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/displayAllFriends.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
      
           pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/displayAllFriends.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    private void afficherColabs(ActionEvent event) throws IOException {
        /*
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/PrivateMessagesInbox.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
        
              
           pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/PrivateMessagesInbox.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
  
    }

    @FXML
    private void addProject(ActionEvent event) throws IOException {
        /*
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/BarChart.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
        
                      
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/BarChart.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
        
    }

    @FXML
    private void addTask(ActionEvent event) {
    }
    
}
