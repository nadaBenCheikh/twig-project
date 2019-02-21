package controllers;

import entities.Projects;
import entities.Tasks;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import services.ProjectsService;
import services.TasksService;

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
    private void initialize(){
        comboboxProjet.setItems(options);   
    }
    
    @FXML
    void ajouterTache(ActionEvent event) {
        String c= (String) comboboxProjet.getValue();
        //System.out.println(c);
        Integer s=op.get(c);
        //System.out.println(s);
        TasksService tservice= new TasksService();
        tservice.isert(new Tasks(s, txtTitle.getText(), txtDescription.getText()));
        System.out.println("c bonnnnnnnn");
        JOptionPane.showMessageDialog(null, "Project is successfully add", "Add Project", JOptionPane.PLAIN_MESSAGE);
    }   
    

}
