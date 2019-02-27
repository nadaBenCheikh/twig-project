package controllers;


import entities.jointureTable;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import service.questionServ;
import service.testServ;

public class affichTestController implements Initializable{
        boolean verif=false;


    @FXML
    private TableColumn<jointureTable, String> reponse;

    @FXML
    private TableColumn<jointureTable, Integer> score;

    @FXML
    private TableColumn<jointureTable, String> question;

    @FXML
    private MenuItem txtDetails;
        @FXML
    private Button chercher;
    @FXML
    private TextField cherchByname;
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
    private Button ajouterQ;

    @FXML
    private MenuItem txtUpdate;

    @FXML
    void supprimer(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete test", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            jointureTable p=new jointureTable();
            p= tableview.getSelectionModel().getSelectedItem();
            System.out.println(p);
            int idTest=p.getTestID();
            int idQuestion=p.getId();
            System.out.println(idQuestion);
            if(idQuestion==0){
                testServ pservice=new testServ();
                pservice.deletee(idTest);
                System.out.println("c bonn test"); 
                verif=true;
            }
            else{
                 questionServ tservice=new questionServ();
                 tservice.deletee(idQuestion);
                 System.out.println("c bonn question"); 
                 verif=true;
            }
            if(verif==true){
                tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
                //tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
          
            }
            
        }
        

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
      @FXML
    void ajouterQues(ActionEvent event) throws IOException {
        
     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/mainPane2.fxml"));
            Parent HomeParent = fxmlLoader.load();
            Scene HomeScene = new Scene(HomeParent);
            Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Home.setScene(HomeScene);
            Home.show();

    }
       @FXML
    void chercher(ActionEvent event) {
           String title=cherchByname.getText();
        //System.out.println(title);
        questionServ tservice1=new questionServ();
        //ArrayList<ProjectJoinTasks> filter=(ArrayList<ProjectJoinTasks>) tservice1.displayAllProjectsAndTasksPerTitle(2, title);
        List<jointureTable> filter=tservice1.displayNom(title);
        //if(title.equals("")){ 
        if(filter.isEmpty()){
            System.out.print("++++++"+filter.toString());
            questionServ tservice=new questionServ();
            ArrayList<jointureTable> list=(ArrayList<jointureTable>) tservice.displayTest();
            ObservableList<jointureTable> ob= FXCollections.observableArrayList(list);
            tableview.setItems(ob);  
            System.out.println("+++++++++++");
        }
        else{
            System.out.print("****"+filter.toString());
            ArrayList<jointureTable> list=(ArrayList<jointureTable>) filter;
            ObservableList<jointureTable> obs= FXCollections.observableArrayList(filter);
            tableview.setItems(obs);
        }
        cherchByname.setText("");
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