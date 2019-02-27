package controllers;

import entities.jointureTable;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.questionServ;

public class testFrontController implements Initializable{

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
    private TableView<jointureTable> tableview;

    @FXML
    private TableColumn<jointureTable, Integer> id;

    @FXML
    private TableColumn<jointureTable, String> type;
   @FXML
    private TableColumn<?, ?> name;
    @FXML
    private Button delete;

    @FXML
    private MenuItem txtUpdate;
    @FXML
    private TableColumn<jointureTable, Integer> test_id;
    @FXML
    void supprimer(ActionEvent event) {
        

    }

       @FXML
    void passeTest(ActionEvent event) throws IOException {
       
           jointureTable e = tableview.getSelectionModel().getSelectedItem();
           FXMLLoader loader =new FXMLLoader(getClass().getResource("../Fxml/detailTestUser.fxml"));
                Parent root = loader.load();
             passerTestController ptc= (passerTestController) loader.getController();
             ptc.detail(e);
             
              Stage stage = new Stage(StageStyle.DECORATED);
                        stage.setTitle("Detail de l'événement");
                        stage.setScene(new Scene(root));
                        stage.show();
             
            }  
            
     


    
    @FXML
    void afficherDetails(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        jointureTable j = new jointureTable();
        questionServ ev=new questionServ();
        ArrayList <jointureTable> list = (ArrayList <jointureTable>) ev.displayTest();
        ObservableList <jointureTable> obslist= FXCollections.observableArrayList(list);
        
        
     id.setCellValueFactory(new PropertyValueFactory <>("id"));
     
      question.setCellValueFactory(new PropertyValueFactory <>("question"));
        reponse.setCellValueFactory(new PropertyValueFactory <>("bonneRep"));
           
         score.setCellValueFactory(new PropertyValueFactory <>("score"));
          duree.setCellValueFactory(new PropertyValueFactory <>("duree"));
          type.setCellValueFactory(new PropertyValueFactory <>("type"));
         name.setCellValueFactory(new PropertyValueFactory <>("nom"));
         test_id.setCellValueFactory(new PropertyValueFactory <>("testID"));
          
          
        
       tableview.setItems(obslist);
   
}
}