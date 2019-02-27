/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Projects;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ProjectsService;
import services.ValidationService;

public class AjouterProjet implements Initializable{
    
    @FXML
    private Label errormsg5;

    @FXML
    private Label errormsg4;

    @FXML
    private Label errormsg3;

    @FXML
    private Label errormsg2;

    @FXML
    private Label errormsg1;
    
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
        
        // controle de saisie :
        boolean validform = true;
        boolean validTitle = true;
        
            ValidationService validservice = new ValidationService();
            if (!validservice.validateTextField(txtTitle)) {
                errormsg1.setText("The Title is required");
                validform = false;
            }
            if (!validservice.validateTextArea(txtDescription)) {
                errormsg2.setText("The Description is required");
                validform = false;
            }
            if (!validservice.validateTextField(txtLocation)) {
                errormsg3.setText("The Location duration is required");
                validform = false;
            }
            if (!validservice.validateTextField(txtCategory)) {
                errormsg4.setText("The Category letter is required");
                validform = false;
            }
            
            if(!validservice.validateDateField(DatePickerTermination)){
                errormsg5.setText("The Date is required");
                validform= false;
            }
            
            if(verifTitle){
                JOptionPane.showMessageDialog(null, "Title already exist", "Add Project", JOptionPane.ERROR_MESSAGE);
                validTitle=false;
                System.out.println("title non");
            }
            
        if(validform==true&&validTitle==true){   
            errormsg1.setText("");
            errormsg2.setText("");
            errormsg3.setText("");
            errormsg4.setText("");
            errormsg5.setText("");

            Date d=Date.valueOf(DatePickerTermination.getValue());
            pservice.isert(new Projects(txtTitle.getText(),txtDescription.getText(),txtLocation.getText(),txtCategory.getText(),d,2));
            System.out.println("c bonnn");
            JOptionPane.showMessageDialog(null, "Project is successfully add", "Add Project", JOptionPane.PLAIN_MESSAGE);
            ////userConnect.getOwnerId()  session->user id 
            
            txtTitle.setText("");
            txtDescription.setText("");
            txtLocation.setText("");
            txtCategory.setText("");
            DatePickerTermination.setValue(null);
        }        
     
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}

