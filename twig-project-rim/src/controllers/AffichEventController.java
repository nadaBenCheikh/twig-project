package controllers;

import entities.event;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.eventService;

public class AffichEventController implements Initializable{
    boolean verif=false;
    
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
    private TableColumn<event, String> category;
        @FXML
    private Button delete;
           @FXML
    private MenuItem txtDetails;
         @FXML
    private MenuItem txtUpdate;
             @FXML
    void afficherDetails(ActionEvent event) {
      event e1 = tableview.getSelectionModel().getSelectedItem();
    }
         
    @FXML
    void updateTable(ActionEvent event) {
       event e = tableview.getSelectionModel().getSelectedItem();
       Popup0.display(e);
       eventService ev=new eventService();
        ArrayList <event> list = (ArrayList <event>) ev.getAll() ;
        ObservableList <event> obslist= FXCollections.observableArrayList(list);
        tableview.setItems(obslist);
    } 
         
         @FXML
    void supprimer(ActionEvent event) {
        
             int reply=JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete project", JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_OPTION){
            
            
         event p=new event();
            p= tableview.getSelectionModel().getSelectedItem();
            System.out.println(p);
            int x=p.getId();
            eventService pservice=new eventService();
            pservice.delete(p);
            System.out.println("c bonnnnnnnn");  
            verif=true;
            if(verif==true){
                tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
           }
            }
    } 
    @FXML
    void update(ActionEvent event) throws IOException {
       event p = tableview.getSelectionModel().getSelectedItem();
       System.out.print(p);

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
