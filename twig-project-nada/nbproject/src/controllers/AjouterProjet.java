/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Projects;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import services.ProjectsService;

public class AjouterProjet implements Initializable{
    
    @FXML
    private DatePicker DatePickerTermination;

    @FXML
    private Button ajouter;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtLocation;
    
    @FXML
    void add(ActionEvent event){
        ProjectsService pservice=new ProjectsService();
        boolean verifTitle=pservice.getByName(txtTitle.getText());
        if(verifTitle){
            JOptionPane.showMessageDialog(null, "Title already exist", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("title non");
        }
        else if(txtTitle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Title is not set", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("title non");
        }
        else if(txtDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Description is not set", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("description non");
        }
        else if(txtLocation.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Location is not set", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("Location non");
        }
        else if(txtCategory.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Category is not set", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("Category non");
        }
        /*else if(DatePickerTermination.getValue().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Wrong date!", "Add Project", JOptionPane.ERROR_MESSAGE);
            System.out.println("dString non");
        }*/
        else{
            Date d=Date.valueOf(DatePickerTermination.getValue());
            pservice.isert(new Projects(txtTitle.getText(),txtDescription.getText(),txtLocation.getText(),txtCategory.getText(),d,2));
            System.out.println("c bonnn");
            JOptionPane.showMessageDialog(null, "Project is successfully add", "Add Project", JOptionPane.PLAIN_MESSAGE);
            ////userConnect.getOwnerId()  session->user id 
        }
        
     
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatePickerTermination.setValue(NOW_LOCAL_DATE());
        } 
        catch (NullPointerException e) {
            
        }
    }
    
    public static final LocalDate NOW_LOCAL_DATE(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    
}

