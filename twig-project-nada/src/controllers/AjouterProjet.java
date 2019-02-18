/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Projects;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.ProjectsService;

public class AjouterProjet {

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
    void add(ActionEvent event) {
        ProjectsService pservice=new ProjectsService();
        Date d=Date.valueOf(DatePickerTermination.getValue());
        pservice.isert(new Projects(txtTitle.getText(),txtDescription.getText(),txtLocation.getText(),txtCategory.getText(),d,3));
        System.out.println("c bonnn");
        ////user.getInstance()   session->user id
    }


}

