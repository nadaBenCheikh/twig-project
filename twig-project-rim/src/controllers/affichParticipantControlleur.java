/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  
package controllers;
import static controllers.loginController.userConnect;
import entite.users;

import entities.jointureParticipant;
import entities.jointureTable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import service.eventService;
import service.participantService;

public class affichParticipantControlleur implements Initializable{

    @FXML
    private TableColumn<jointureParticipant, Integer> phone;

    @FXML
    private TableColumn<jointureParticipant, String> name;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableView<jointureParticipant> tableview;

    @FXML
    private TableColumn<jointureParticipant, String> prenom;

    @FXML
    private TableColumn<jointureTable, String> email;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        
        
      participantService ev=new participantService();
        ArrayList <jointureParticipant> list = (ArrayList <jointureParticipant>) ev.displaypPArtici();
        ObservableList <jointureParticipant> olist= FXCollections.observableArrayList(list);
        
        
     name.setCellValueFactory(new PropertyValueFactory <>("firstName"));
       prenom.setCellValueFactory(new PropertyValueFactory <>("lastName"));
      email.setCellValueFactory(new PropertyValueFactory <>("email"));
          phone.setCellValueFactory(new PropertyValueFactory <>("phone"));

      
       
        
     tableview.setItems(olist);

}
}



