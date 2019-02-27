/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import entities.Offers;
import entities.ProjectJoinTasks;
import entities.Projects;
import entities.Tasks;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.OffersService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherOffersController implements Initializable {

    @FXML
    private TableColumn<?, ?> taskTitleColumn;
    @FXML
    private TableColumn<?, ?> ProjectTitleColumn;
    @FXML
    private TableColumn<Offers, Float> BIDColumn;
    @FXML
    private TableColumn<Offers, Float> DurationColumn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button recommandBtn;
    
    @FXML
    private TableView<Offers> table;
    @FXML
    private TableColumn< Offers, Integer> IdOfferColumn;
     public static int id_Offer;
     
        ObservableList<Offers> obslist;
    @FXML
    private TableColumn<?, ?> TaskIDColumn;
    @FXML
    private TableColumn<?, ?> ProjectIDColumn;
        
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               OffersService ps=new OffersService();
        ArrayList<Offers> list=(ArrayList<Offers>) ps.displayAll();
        
       obslist=FXCollections.observableArrayList(list);
        
        ProjectTitleColumn.setCellValueFactory(new PropertyValueFactory<>("proTitle"));
        taskTitleColumn.setCellValueFactory(new PropertyValueFactory<>("taskTitle"));
        BIDColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
        DurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        IdOfferColumn.setCellValueFactory(new PropertyValueFactory<> ("id") ); // ID offer kima fel attribut 
         TaskIDColumn.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        ProjectIDColumn.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        table.setItems(obslist);
        
        
        
        
    }
        

        //*********************************** CANCEL + refresh  ********************


    
                
    @FXML
    private void  deleteClick(MouseEvent event) {
        
        id_Offer=Integer.valueOf(IdOfferColumn.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
    
        System.out.println(id_Offer);
        
 
 

    }
    
      @FXML
    private void deleteOffer(ActionEvent event) {
  
        int id = ((Offers) table.getSelectionModel().getSelectedItem()).getId();

        new OffersService().delete(id);
        
        System.out.println("suppression reussite");
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Delete");
        alert.setContentText("Application deleted successfully");
        
        alert.showAndWait();
       
        
               // refresh 
               // ATTENTION!!
               // null pointer exception ken tabda mafama 7ata valeur fel table offers 
        
        obslist.clear();
   
      
        OffersService ps=new OffersService();
        ArrayList<Offers> list=(ArrayList<Offers>) ps.displayAll();
        
       obslist=FXCollections.observableArrayList(list);
        
        ProjectTitleColumn.setCellValueFactory(new PropertyValueFactory<>("proTitle"));
        taskTitleColumn.setCellValueFactory(new PropertyValueFactory<>("taskTitle"));
        BIDColumn.setCellValueFactory(new PropertyValueFactory<>("bid"));
        DurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        IdOfferColumn.setCellValueFactory(new PropertyValueFactory<> ("id") ); // ID offer kima fel attribut 
       
        
        table.setItems(obslist);
        
//        
//        // redirection automatique à  interface recommander un ami pour faire cette tache
//          System.out.println("redirection");
//                Offers h =table.getSelectionModel().getSelectedItem();
//         //new TasksService().setSelectedTask(h.getId());
//        int x;
//        x=h.getTaskId();
//        System.out.println(x);
//        if(x == 0){
//            System.out.println("aucune tacheeeeee");
//        }
//        else{
//            System.out.println("tache existe");
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("../Fxml/RecommanderUnAmi.fxml"));
//            Stage primaryStage = new Stage();
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Recommand a task for a friend");
//            primaryStage.show();
//         } catch (IOException ex) {
//            
//        }
//    }
        
        
    }
    /*    @FXML
    private void recommandClick(MouseEvent event) {
        
        idTask=Integer.valueOf(idT.getCellData(tableview.getSelectionModel().getSelectedIndex()).toString());
         idPro=Integer.valueOf(id.getCellData(tableview.getSelectionModel().getSelectedIndex()).toString());
        System.out.println(idTask);

    }*/
    
        @FXML
    void redirectToRecommandFriend(ActionEvent event) {
        Offers h =table.getSelectionModel().getSelectedItem();
         //new TasksService().setSelectedTask(h.getId());
        int x;
        x=h.getTaskId();
        System.out.println(x);
        if(x == 0){
            System.out.println("aucune tacheeeeee");
        }
        else{
            System.out.println("tache existe");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Fxml/RecommanderUnAmi.fxml"));
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Recommand a task for a friend");
            primaryStage.show();
         } catch (IOException ex) {
            
        }
    }
}

    private void redirect(ActionEvent event) throws IOException {
        
      
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/HomeYosr.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}