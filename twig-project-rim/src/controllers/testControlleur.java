
  package controllers;
import entities.test;
import java.sql.Date;
import java.sql.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import service.eventService;
import service.testServ;


public class testControlleur {

    @FXML
    private TextField txt_inom;

    @FXML
    private TextField txt_describ;

    @FXML
    private TextField txt_score;

    @FXML
    private TextField txt_duree;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button ajout;

    @FXML
    private TextField txt_type;

     @FXML
    void ajouterTest(ActionEvent event) {
          testServ pser=new testServ();
         
         Time t=Time.valueOf("01:20:00");
   

        pser.insertPST(new test(200,t,txt_type.getText(),txt_inom.getText(),txt_describ.getText()));
        JOptionPane.showMessageDialog(null, "test added");

    }
   

}

    

