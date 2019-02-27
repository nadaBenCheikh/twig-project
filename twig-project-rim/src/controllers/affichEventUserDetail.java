/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import static controllers.loginController.userConnect;
import entities.event;
import entities.jointureTable;
import entities.participant;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import service.eventService;
import service.participantService;

/**
 *
 * @author rim
 */
public class affichEventUserDetail implements Initializable{
   
 
    @FXML
    private TableView<event> tableview;

    @FXML
    private TableColumn<event, String> image;

    @FXML
    private TableColumn<event, Date> dateCreation;

    @FXML
    private TableColumn<event , Integer> nmbreMax;

    @FXML
    private TableColumn<event, String> adresse;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<event, String> description;

  

    @FXML
    private TableColumn<event, Integer> id;

    @FXML
    private TableColumn<event, String> title;
        @FXML
    private Button particierEvent;

    @FXML
    private TableColumn<event, String> category;
        @FXML
   
    private MenuItem txtDetails;
            @FXML
    private Button particiEvent;
         
  
             @FXML
    void afficherDetails(ActionEvent event) throws IOException {
      event e = tableview.getSelectionModel().getSelectedItem();
           FXMLLoader loader =new FXMLLoader(getClass().getResource("../Fxml/detailEvent_1.fxml"));
                Parent root = loader.load();
           detailEventController de= (detailEventController) loader.getController();
de.detail(e);

        Stage stage = new Stage(StageStyle.DECORATED);
                        stage.setTitle("Detail de l'événement");
                        stage.setScene(new Scene(root));
                        stage.show();
    }
          
  
 

    @FXML
    void partciper(ActionEvent event) {
         event e = tableview.getSelectionModel().getSelectedItem();
         participant p = new participant();
         p.setEventID(e.getId());
         //  après l'integration du projet, freelancerId sera récupérer de l'object userConnect
         p.setFeelancerID(e.getId()) ;
        
         participantService ps = new participantService();
         ps.insertPST(p);
         JOptionPane.showMessageDialog(null, "votre participation est enregistrée");
         
                 
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventService ev=new eventService();
        ArrayList <event> list = (ArrayList <event>) ev.getAll() ;
        ObservableList <event> obslist= FXCollections.observableArrayList(list);
        
        
     id.setCellValueFactory(new PropertyValueFactory <>("id"));
      title.setCellValueFactory(new PropertyValueFactory <>("titre"));
      description.setCellValueFactory(new PropertyValueFactory <>("description"));
        dateCreation.setCellValueFactory(new PropertyValueFactory <>("dateCreation"));
           
         adresse.setCellValueFactory(new PropertyValueFactory <>("adresse"));
          nmbreMax.setCellValueFactory(new PropertyValueFactory <>("nmbreMax"));
          category.setCellValueFactory(new PropertyValueFactory <>("category"));
          
            image.setCellValueFactory(new PropertyValueFactory <>("image"));//title
        
       tableview.setItems(obslist);
   
}
}

    

