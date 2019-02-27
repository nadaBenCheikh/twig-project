
package controllers;

import entities.event;
import entities.participant;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.eventService; 
import service.participantService;

public class AfficherFront implements Initializable{

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox vbprojet;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        eventService pservice = new eventService();  
        List<event> list= pservice.getAll();
        Iterator iterator = list.iterator();
        HBox hb;
         
        for(int i = 0; i < list.size(); i++) {
            hb= new HBox(10);
            hb.setSpacing(20); // espace horizontal entre deux images
            for (int j = 0; j < 3; j++) {
                if(iterator.hasNext())
                {
         hb.getChildren().add(createVBProject((event) iterator.next()));    
                }
            }
            vbprojet.getChildren().add(hb);         
        }
    }
    
    
    public VBox createVBProject(event j){
      
        VBox vbProject = new VBox();
        vbProject.setStyle("background-color : #ffffff; padding-right: 0px");
        vbProject.setSpacing(10);
        ImageView logoEntreprise = new ImageView(new Image(j.getImage())); 
       
   
  
        //img.setX(100);
        //img.setY(100);
        logoEntreprise.setFitHeight(130);// longeur
        logoEntreprise.setFitWidth(170);
        Label titleP=new Label(j.getTitre());
        titleP.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label category = new Label(j.getCategory());
       
       
        Button showDetail = new Button("Show details");
       
        showDetail.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");

        showDetail.setOnAction((e) -> {           
            System.out.println(j);
            
            try {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../Fxml/detailEvent_1.fxml"));
                Parent root=loader.load();
                detailEventController aftcontroller =(detailEventController) loader.getController();
                aftcontroller.detail(j);
                Stage stage=new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherFront.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
         Button participer = new Button("participer");
       
        participer.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");

        participer.setOnAction((ev) -> {           
            System.out.println(j);
              participant p = new participant();
         p.setEventID(j.getId());
         //  après l'integration du projet, freelancerId sera récupérer de l'object userConnect
         p.setFeelancerID(j.getId()) ;
        
         participantService ps = new participantService();
         ps.insertPST(p);
         JOptionPane.showMessageDialog(null, "votre participation est enregistrée");
         
            
        });
        
        vbProject.getChildren().add(titleP);
        vbProject.getChildren().add(logoEntreprise);
        vbProject.getChildren().add(category);
        vbProject.getChildren().add(showDetail);
         vbProject.getChildren().add(participer);
       
        return vbProject;   
    }
    
}
