package controllers;


import entities.jointureTable;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import service.questionServ;

public class affichTestController implements Initializable{

    @FXML
    private TableColumn<jointureTable, String> reponse;

    @FXML
    private TableColumn<jointureTable, Integer> score;

    @FXML
    private TableColumn<jointureTable, String> question;

    @FXML
    private MenuItem txtDetails;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<jointureTable, Time> duree;

    @FXML
    private TableColumn<jointureTable, Integer> testID;

    @FXML
    private TableView<jointureTable> tableview;

    @FXML
    private TableColumn<jointureTable, Integer> id;

    @FXML
    private TableColumn<jointureTable, String> type;
    @FXML
    private TableColumn<jointureTable, String> nom;
    @FXML
    private Button delete;

    @FXML
    private MenuItem txtUpdate;

    @FXML
    void supprimer(ActionEvent event) {
        

    }

    @FXML
    void updateTable(ActionEvent event) {
         jointureTable e = tableview.getSelectionModel().getSelectedItem();
        popup1.display(e);
            jointureTable j = new jointureTable();
        questionServ ev=new questionServ();
        ArrayList <jointureTable> list = (ArrayList <jointureTable>) ev.display();
        ObservableList <jointureTable> obslist= FXCollections.observableArrayList(list);
        tableview.setItems(obslist);
     //  questionServ ev=new questionServ();
      //  ArrayList <jointureTable> list = (ArrayList <jointureTable>) ev.display(e.getTestID());
      //  ObservableList <event> obslist= FXCollections.observableArrayList(list);
    //   tableview.setItems(obslist);

    }

    @FXML
    void afficherDetails(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        jointureTable j = new jointureTable();
        questionServ ev=new questionServ();
        ArrayList <jointureTable> list = (ArrayList <jointureTable>) ev.display();
        ObservableList <jointureTable> obslist= FXCollections.observableArrayList(list);
        
        
     id.setCellValueFactory(new PropertyValueFactory <>("id"));
      testID.setCellValueFactory(new PropertyValueFactory <>("testID"));
      question.setCellValueFactory(new PropertyValueFactory <>("question"));
        reponse.setCellValueFactory(new PropertyValueFactory <>("bonneRep"));
           
         score.setCellValueFactory(new PropertyValueFactory <>("score"));
          duree.setCellValueFactory(new PropertyValueFactory <>("duree"));
          type.setCellValueFactory(new PropertyValueFactory <>("type"));
         nom.setCellValueFactory(new PropertyValueFactory <>("nom"));
          
          
        
       tableview.setItems(obslist);
   
}

   

   

}