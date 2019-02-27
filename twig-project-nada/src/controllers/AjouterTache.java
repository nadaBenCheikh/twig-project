package controllers;

import entities.Projects;
import entities.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ProjectsService;
import services.TasksService;
import services.ValidationService;

public class AjouterTache{
    
    ProjectsService pservice=new ProjectsService();
        ArrayList <Projects> list=(ArrayList <Projects>) pservice.displayAllProject(2);
        
        Map<String, Integer> op=list.stream().collect(Collectors.toMap(Projects::getTitle, Projects::getId, (a,b)->a+b));
        ObservableList<String> options=FXCollections.observableArrayList(op.keySet());
       
         
    @FXML
    private ComboBox comboboxProjet;
    
    @FXML
    private Button ajouter;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField txtTitle;
    
    @FXML
    private Button retour;
    
    @FXML
    private Label errormsg3;

    @FXML
    private Label errormsg2;

    @FXML
    private Label errormsg1;
    
    @FXML
    private void initialize(){
        comboboxProjet.setItems(options);   
    }
    
    @FXML
    void ajouterTache(ActionEvent event) {
        
        
        /*if(comboboxProjet.getValue()==null){
            JOptionPane.showMessageDialog(null, "You must choose a project", "Add Task", JOptionPane.ERROR_MESSAGE);
            System.out.println("projet non");
        }
        else if(txtTitle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Title is not set", "Add Task", JOptionPane.ERROR_MESSAGE);
            System.out.println("titre non");
        }
        else if(txtDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Description is not set", "Add Task", JOptionPane.ERROR_MESSAGE);
            System.out.println("description non");
        }*/
        
        // controle de saisie :
        boolean validform = true;
        ValidationService validservice = new ValidationService();
            if (!validservice.validateComboField(comboboxProjet)) {
                errormsg1.setText("The Project Title is required");
                validform = false;
            }    
            if (!validservice.validateTextField(txtTitle)) {
                errormsg2.setText("The Title is required");
                validform = false;
            }
            if (!validservice.validateTextArea(txtDescription)) {
                errormsg3.setText("The Description is required");
                validform = false;
            }
        if(validform==true){
            errormsg1.setText("");
            errormsg2.setText("");
            errormsg3.setText("");
            String c= (String) comboboxProjet.getValue();
            //System.out.println(c);
            Integer s=op.get(c);
            //System.out.println(s);
            TasksService tservice= new TasksService();
            tservice.isert(new Tasks(s, txtTitle.getText(), txtDescription.getText()));
            //System.out.println("c bonnnnnnnn");
            JOptionPane.showMessageDialog(null, "Project is successfully add", "Add Project", JOptionPane.PLAIN_MESSAGE);
            txtTitle.setText("");
            txtDescription.setText("");
            comboboxProjet.setValue(null);
        }
        
    }   
    

}
