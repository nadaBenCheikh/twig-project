package controllers;

import entities.event;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    private Button upload;
    @FXML
    private Button voirListe;
  

    
         
     
       
    
     
    

    @FXML
    void ajouterEvent(ActionEvent event) {
             if ("".equals(txt_title.getText())) {
             JOptionPane.showMessageDialog(null, "Enter a title please!","erreur",JOptionPane.ERROR_MESSAGE);
             } 
            else if ("".equals(txt_adress.getText())) {
             JOptionPane.showMessageDialog(null, "Enter an adress please!","erreur",JOptionPane.ERROR_MESSAGE);
            }
             else if (txt_nombre.getText().matches(".*[a-zA-Z].*")) {
       JOptionPane.showMessageDialog(null, "Enter a number please!","erreur",JOptionPane.ERROR_MESSAGE);

           
        }
       
           
          
            else if ("".equals(txt_describ.getText())) {
            JOptionPane.showMessageDialog(null, "Enter a description please!","erreur",JOptionPane.ERROR_MESSAGE);    
            }
             else if ("".equals(txt_adress.getText())) {
             JOptionPane.showMessageDialog(null, "Enter an adress please!","erreur",JOptionPane.ERROR_MESSAGE);
            }

           
             else if ("".equals(txt_image.getText())) {
             JOptionPane.showMessageDialog(null, "Enter a picture  please!","erreur",JOptionPane.ERROR_MESSAGE);
             }
          else{
        System.out.println("cccccccccccc");
        eventService pser=new eventService();
       Date d=Date.valueOf(txt_date.getValue());

        pser.insertPST(new event(txt_title.getText(),txt_describ.getText(),d,txt_adress.getText(),30,txt_cat.getText(),txt_image.getText()));
        

          
JOptionPane.showMessageDialog(null, "training succefuly added");
    }
    }
    
        @FXML
    void apload(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpeg)", ".jpeg");
//        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".png");
//        fileChooser.getExtensionFilters().addAll(extFilterJPG,extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
        System.out.println("file "+ file);
      txt_image.setText(file.getName());
        Image img = new Image("http://localhost/image/" + file.getName());
    }
    

      @FXML
            
    void voirListeEvent(ActionEvent event) throws IOException {
    
       Parent piParent = FXMLLoader.load(getClass().getResource("../Fxml/mainPane_1_1_1.fxml"));
        Scene piScene = new Scene(piParent);
        Stage piStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        piStage.setScene(piScene);
        piStage.show();
    }
  
  

}
