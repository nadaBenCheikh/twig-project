package controllers;

import entities.ProjectJoinTasks;
import java.net.URL;
import java.sql.Date;
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
import services.TasksService;

public class AfficherAllProjects implements Initializable{

    @FXML
    private TableView<ProjectJoinTasks> tableview;
    
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        TasksService tservice=new TasksService();
        ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) tservice.displayAllProjectsAndTasksAllDonneur();
        ObservableList<ProjectJoinTasks> ob= FXCollections.observableArrayList(list);
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
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
    

}
