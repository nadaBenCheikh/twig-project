package home.Login1.controllers;


import java.io.IOException;
//import entite.users;
import home.Login1.entite.Freelancer;
import home.Login1.service.FreelancerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class profilController {

     @FXML
    private TextField languages;

    @FXML
    private TextField maxHourlyFee;

    @FXML
    private TextField gender;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField ranking;

    @FXML
    private Button Ajouter;

    @FXML
    private TextField minHourlyFee;
     @FXML
    private ImageView sign;

    @FXML
    private TextField cvLink;
    @FXML
    private Button btnReturn;

    @FXML
    void Ajouter(ActionEvent event) {
     
  
         FreelancerService fservice=new FreelancerService();
         fservice.insert(new Freelancer(6,languages.getText(), Integer.parseInt(minHourlyFee.getText())
                 ,Integer.parseInt(gender.getText()) ,cvLink.getText(),
                 Integer.parseInt(maxHourlyFee.getText()) , 
                 ranking.getText()
         ));
         System.out.println("ajout");
         JOptionPane.showMessageDialog(null, "Freelancer is successfully add", "Add Project", JOptionPane.PLAIN_MESSAGE);
         

    }
       @FXML
    void Return(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/inscrit.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();

}
}
