package controllers;

import entities.ProjectJoinTasks;
import java.net.URL;
import java.sql.Date;
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
import javax.swing.JOptionPane;
import services.ProjectsService;
import services.TasksService;

public class afficherAllProjects_back implements Initializable{
    
    boolean verif=false;
     
    @FXML
    private MenuItem txtupdate;
    
    @FXML
    private Button delete;
    
    @FXML
    private TableView<ProjectJoinTasks> tableview;
       
    @FXML
    private TableColumn<ProjectJoinTasks, String> status;
    
    @FXML
    private TableColumn<ProjectJoinTasks, Date> terminationDate;

    @FXML
    private TableColumn<ProjectJoinTasks, String> descriptionT;

    @FXML
    private TableColumn<ProjectJoinTasks, Integer> idT;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<ProjectJoinTasks, String> description;
    
    @FXML
    private TableColumn<ProjectJoinTasks, String> location;

    @FXML
    private TableColumn<ProjectJoinTasks, Integer> id;

    @FXML
    private TableColumn<ProjectJoinTasks, String> title;

    @FXML
    private TableColumn<ProjectJoinTasks, Date> creationDate;

    @FXML
    private TableColumn<ProjectJoinTasks, String> category;

    @FXML
    private TableColumn<ProjectJoinTasks, String> titleT;
    
    @FXML
    void updateCell(ActionEvent event) {          ///a voir avec madame!!!!!!!
        ProjectJoinTasks p=tableview.getSelectionModel().getSelectedItem();
        Popup1.display(p);
        tableview.setItems(getObservableListeToReload()); 
    }
    
    @FXML
    void supprimer(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete project", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            ProjectJoinTasks p=new ProjectJoinTasks();
            p= tableview.getSelectionModel().getSelectedItem();
            System.out.println(p);
            int idProject=p.getId();
            int idTask=p.getIdT();
            System.out.println(idTask);
            if(idTask==0){
                ProjectsService pservice=new ProjectsService();
                pservice.delete(idProject);
                System.out.println("c bonn projet"); 
                verif=true;
            }
            else{
                 TasksService tservice=new TasksService();
                 tservice.delete(idTask);
                 System.out.println("c bonn tache"); 
                 verif=true;
            }
            if(verif==true){
                //tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
                tableview.setItems(getObservableListeToReload()); 
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {       
        TasksService tservice=new TasksService();
        ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) tservice.displayAllProjectsAndTasks(2);
        ObservableList<ProjectJoinTasks> ob= FXCollections.observableArrayList(list);
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));
            title.setCellValueFactory(new PropertyValueFactory<>("title"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
            terminationDate.setCellValueFactory(new PropertyValueFactory<>("terminationDate"));
            location.setCellValueFactory(new PropertyValueFactory<>("location"));
            category.setCellValueFactory(new PropertyValueFactory<>("category"));
            titleT.setCellValueFactory(new PropertyValueFactory<>("titleT"));
            idT.setCellValueFactory(new PropertyValueFactory<>("idT"));
            descriptionT.setCellValueFactory(new PropertyValueFactory<>("descriptionT"));
            tableview.setItems(ob);   

    }
    
    public ObservableList<ProjectJoinTasks> getObservableListeToReload(){
        TasksService tservice=new TasksService();
        ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) tservice.displayAllProjectsAndTasks(2);
        ObservableList<ProjectJoinTasks> ob= FXCollections.observableArrayList(list);
        return ob;
    }
    
}
