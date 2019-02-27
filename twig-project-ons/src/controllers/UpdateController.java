package controllers;


import entite.Freelancer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.FreelancerService;


public class UpdateController implements Initializable{

    @FXML
    private TextField languages;

    @FXML
    private TextField maxHourlyFee;

    @FXML
    private TextField gender;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button update;

    @FXML
    private TextField ranking;

    @FXML
    private TextField minHourlyFee;

    @FXML
    private TextField cvLink;
    
    //static users userConnect;

   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FreelancerService fs=new FreelancerService();
        Freelancer freelancer = new Freelancer();
        freelancer=fs.getByIdFreelancer(loginController.userConnect.getId());
        languages.setText(freelancer.getLanguages());
        minHourlyFee.setText(String.valueOf(freelancer.getMinHourlyFee()));
        gender.setText(String.valueOf(freelancer.getGender()));
//        if(freelancer.getCvLink()== null){
//            
//        }else{
//            cvLink.setText(freelancer.getCvLink());
//        }
        
        maxHourlyFee.setText(String.valueOf(freelancer.getMaxHourlyFee()));
        ranking.setText(freelancer.getRanking());
        //System.out.print("here ------> " + cvLink.getText());
 
        
    }
    
    @FXML
    void update(ActionEvent event) {
        FreelancerService fservice=new FreelancerService();
        fservice.update(new Freelancer(loginController.userConnect.getId(),languages.getText(), Integer.parseInt(minHourlyFee.getText())
                ,Integer.parseInt(gender.getText()) ,
                cvLink.getText(),
                Integer.parseInt(maxHourlyFee.getText()), ranking.getText()));
        System.out.println("modifier");

    }
    
    @FXML
    void Return(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil_1.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();
    }
}
