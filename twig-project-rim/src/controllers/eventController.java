package controllers;

import entities.event;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import service.eventService;
import service.testServ;

public class eventController {
    testServ pservice=new testServ();
        ArrayList <entities.test> list=(ArrayList <entities.test>) pservice.getNomId();
        
        Map<String, Integer> op=list.stream().collect(Collectors.toMap(entities.test::getNom, entities.test::getId, (a,b)->a+b));
        ObservableList<String> options=FXCollections.observableArrayList(op.keySet());

    @FXML
    private TextField txt_describ;
    @FXML
    private Button ajouter;


    @FXML
    private TextField txt_cat;

    @FXML
    private DatePicker txt_date;

  

    @FXML
    private TextField txt_adress;

    @FXML
    private TextField txt_image;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField txt_title;

    @FXML
    private TextField txt_nombre;

    @FXML
    void ajouterEvent(ActionEvent event) {
        System.out.println("cccccccccccc");
        eventService pser=new eventService();
       Date d=Date.valueOf(txt_date.getValue());

        pser.insertPST(new event(txt_title.getText(),txt_describ.getText(),d,txt_adress.getText(),30,txt_cat.getText(),txt_image.getText()));
JOptionPane.showMessageDialog(null, "training succefuly added");
    }
  
  

}
