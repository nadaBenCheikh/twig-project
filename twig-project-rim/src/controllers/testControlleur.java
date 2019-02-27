
  package controllers;
import entities.test;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    private Button voirList;
    @FXML
    private TextField txt_type;

     @FXML
    void ajouterTest(ActionEvent event) {
          testServ pser=new testServ();
         
         Time t=Time.valueOf("01:20:00");
   // check if a test with the same name exists in the database
         if(pser.getByName(txt_inom.getText())== null){
            pser.insertPST(new test(200,t,txt_type.getText(),txt_inom.getText(),txt_describ.getText()));
            JOptionPane.showMessageDialog(null, "test added");
         }else{
             JOptionPane.showMessageDialog(null, "A test with the same name already exists");
         }

    }
        @FXML
    void VoirListeTtest(ActionEvent event) throws IOException {
   Parent piParent = FXMLLoader.load(getClass().getResource("../Fxml/affichTest_1_1.fxml"));
        Scene piScene = new Scene(piParent);
        Stage piStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        piStage.setScene(piScene);
        piStage.show();
    }
   

}

    

