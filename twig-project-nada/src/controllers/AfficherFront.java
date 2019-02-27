package controllers;

import entities.DonneurJoinProject;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.awt.Color;
import java.awt.Paint;
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
import javafx.geometry.Pos;
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
import services.ProjectsService;

public class AfficherFront implements Initializable{

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox vbprojet;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        ProjectsService pservice = new ProjectsService();  
        List<DonneurJoinProject> list=pservice.display(); 
        Iterator iterator = list.iterator();
        HBox hb;
         
        for(int i = 0; i < list.size(); i++) {
            hb= new HBox(10);
            hb.setSpacing(20); // espace horizontal entre deux images
            for (int j = 0; j < 3; j++) {
                if(iterator.hasNext())
                {
                    hb.getChildren().add(createVBProject((DonneurJoinProject) iterator.next()));    
                }
            }
            vbprojet.getChildren().add(hb);         
        }
    }
    public VBox createVBProject(DonneurJoinProject j){
      
        VBox vbProject = new VBox();
        vbProject.setStyle("background-color : #ffffff; padding-right: 0px");
        vbProject.setSpacing(10);
        ImageView logoEntreprise = new ImageView(new Image(j.getPicturePath())); 
   
        logoEntreprise.setPreserveRatio(false);
        //img.setX(100);
        //img.setY(100);
        logoEntreprise.setFitHeight(130);// longeur
        logoEntreprise.setFitWidth(170);
        Label titleP=new Label(j.getTitle());
        titleP.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label nomPrenonDonneur = new Label(j.getLastName()+" "+j.getFirstName());
        nomPrenonDonneur.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
       
       
        Button showDetail = new Button("Show details");
       
        showDetail.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");

        showDetail.setOnAction((event) -> {           
            System.out.println(j.getIdP());
            int id=j.getIdP();
            try {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../Fxml/afficherFrontOfficeTasks.fxml"));
                Parent root=loader.load();
                AfficherFrontTasks aftcontroller =(AfficherFrontTasks) loader.getController();
                aftcontroller.afficherDetailProject(id);
                Stage stage=new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherFront.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        vbProject.getChildren().add(titleP);
        vbProject.getChildren().add(logoEntreprise);
        vbProject.getChildren().add(nomPrenonDonneur);
        vbProject.getChildren().add(showDetail);
       
        return vbProject;   
    }
    
}

