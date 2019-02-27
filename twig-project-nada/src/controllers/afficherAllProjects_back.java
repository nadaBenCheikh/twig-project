package controllers;

import entities.ProjectJoinTasks;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    private MenuBar fileMenu;
    
    @FXML
    private TextField filterInput;
    
    @FXML
    private Button search;
    
    ObservableList<ProjectJoinTasks> ob;
        
    @FXML
    void updateCell(ActionEvent event) {          
        ProjectJoinTasks p=tableview.getSelectionModel().getSelectedItem();
        Popup1.display(p);
        ob.clear();
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
                ob.clear();
                tableview.setItems(getObservableListeToReload()); 
            }
        }
    }
    
    @FXML
    void handleSave(ActionEvent event) {
        Stage secondaryStage= new Stage();
        FileChooser filechooser= new FileChooser();
        filechooser.setTitle("Save list of projects and tasks");
        File file=filechooser.showSaveDialog(secondaryStage);
        if(file !=null){
            saveFile(tableview.getItems(), file);
            JOptionPane.showMessageDialog(null, "File is successfully Saved", null, JOptionPane.DEFAULT_OPTION);
        }
    }
    
    public void saveFile(ObservableList<ProjectJoinTasks> observableListProjectJoinTasks, File file){
        try {
            BufferedWriter outWriter= new BufferedWriter(new FileWriter(file));
            outWriter.write("Projects and tasks \n");
            for(ProjectJoinTasks pjt: observableListProjectJoinTasks){
                outWriter.write("Project State: "+pjt.getStatus()+" Title Project: "+pjt.getTitle()+" Description Project: "+pjt.getDescription()+" Project Category: "+pjt.getCategory()+" Project Location: "+pjt.getLocation()+" Task Title: "+pjt.getTitleT()+" Task Description: "+pjt.getDescriptionT());
                outWriter.write("\n");
                outWriter.newLine();
            }
            System.out.println("listttttttt");
            outWriter.close();     
        } catch (IOException ex) {
            Logger.getLogger(afficherAllProjects_back.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void rechercher(ActionEvent event) {
        String title=filterInput.getText();
        //System.out.println(title);
        TasksService tservice1=new TasksService();
        //ArrayList<ProjectJoinTasks> filter=(ArrayList<ProjectJoinTasks>) tservice1.displayAllProjectsAndTasksPerTitle(2, title);
        List<ProjectJoinTasks> filter=tservice1.displayAllProjectsAndTasksPerTitle(2, title);
        //if(title.equals("")){ 
        if(filter.isEmpty()){
            System.out.print("++++++"+filter.toString());
            ob.clear();
            tableview.setItems(getObservableListeToReload()); 
            /*TasksService tservice=new TasksService();
            ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) tservice.displayAllProjectsAndTasks(2);
            ObservableList<ProjectJoinTasks> ob= FXCollections.observableArrayList(list);
            tableview.setItems(ob); */ 
            System.out.println("+++++++++++");
        }
        else{
            System.out.print("****"+filter.toString());
            ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) filter;
            ObservableList<ProjectJoinTasks> obs= FXCollections.observableArrayList(filter);
            tableview.setItems(obs);
        }
        filterInput.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {       
        TasksService tservice=new TasksService();
        //int x=userConnect.getOwnerId();   
        ArrayList<ProjectJoinTasks> list=(ArrayList<ProjectJoinTasks>) tservice.displayAllProjectsAndTasks(2);
        ob= FXCollections.observableArrayList(list);
            
            statusDate(list);
            
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
        ob= FXCollections.observableArrayList(list);
        statusDate(list);
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
        return ob;
    }
    
    public void statusDate(ArrayList<ProjectJoinTasks> list){
        ProjectsService pservice=new ProjectsService();
        for(ProjectJoinTasks l:list){
            Date d=l.getTerminationDate();
            LocalDate dateTermination=d.toLocalDate();
            LocalDate dateNow=LocalDate.now();
            Period period=Period.between(dateNow,dateTermination);
            int days=period.getDays();
            int months=period.getMonths();
            int years=period.getYears();
            if(years<=0){
                if(months<=0){
                    if(days<0){     //pour ne pas etre egaux
                        pservice.state(l.getId());
                    }
                }
            }
            System.out.println(days);
            System.out.println(months);
            System.out.println(years);
        }
    }
}
