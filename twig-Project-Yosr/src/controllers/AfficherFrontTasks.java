package controllers;

import entities.ProjectJoinTasks;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import services.TasksService;

public class AfficherFrontTasks implements Initializable {
    
    //*************************************************************************************
    //************************************************************************************
    // yosr
        public static int idPro;
        public static int idTask;


    @FXML
    private VBox vbTasks;

    @FXML
    private Pane pnlOverview;
    
    
    @FXML
    private Button btnRetour;

  


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void afficherDetailProject(int idP) {
   
        //***************************************************************************************
        //***************************************************************************************
        //yosr
        // recuperer id du projet selectioné
        
        System.out.println("id of  selected project: ");
        idPro=idP;
        System.out.println(idPro);
        //********************************** FIN ***************************************************
        
        
        TasksService pservice = new TasksService();
        List<ProjectJoinTasks> list = pservice.displayAllProjectsAndTasksAllDonneur(idP);
        Label titleP = new Label("Project Title  " + list.get(0).getTitle());
        titleP.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label descriptionP = new Label("Project Description  " + list.get(0).getDescription());
        descriptionP.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
        Label categoryP = new Label("Category  " + list.get(0).getCategory());
        categoryP.setFont(Font.font("Amble CN", FontWeight.NORMAL, 12));
        Label locationP = new Label("Location  " + list.get(0).getLocation());
        locationP.setFont(Font.font("Amble CN", FontWeight.NORMAL, 12));
        Label terminationDate = new Label("Termination Date  " + list.get(0).getTerminationDate().toString());
        terminationDate.setFont(Font.font("Amble CN", FontWeight.NORMAL, 10));
        vbTasks.getChildren().add(titleP);
        vbTasks.getChildren().add(descriptionP);
        vbTasks.getChildren().add(categoryP);
        vbTasks.getChildren().add(locationP);
        vbTasks.getChildren().add(terminationDate);
        vbTasks.setAlignment(Pos.CENTER);

        Iterator iterator = list.iterator();
        HBox hb;
        for (int i = 0; i < list.size(); i++) {
            hb = new HBox(5);
            hb.setSpacing(20); // espace horizontal entre deux images
            for (int j = 0; j < 3; j++) {
                if (iterator.hasNext()) {
                    hb.getChildren().add(createVbTasks((ProjectJoinTasks) iterator.next()));
                }
            }
            vbTasks.getChildren().add(hb);
        }
        /*while(iterator.hasNext()){
           hb= new HBox(10); 
           hb.setAlignment(Pos.CENTER);
           hb.getChildren().add(createVbTasks((ProjectJoinTasks) iterator.next())); 
           vbTasks.getChildren().add(hb);  
        }*/

    }

    public VBox createVbTasks(ProjectJoinTasks j) {
        VBox vbT = new VBox();
        if (j.getIdT() == 0) {
          
            Button postulerProject = new Button("Postuler Project");
            postulerProject.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");
            postulerProject.setOnAction(e -> {
                //yosrrrr
                //*******************************************************
                //*****************************************************
                //***************** YOSR *********************************
                // POSTULER SUR UN PROJET VIDE
                                
                // recuperer id du task selectioné
                System.out.println("this project contains no tasks ");
                idTask=0;
                //System.out.println(idTask);
                
                try {
                    System.out.println("tesssssssssssssst");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fxml/Apply.fxml"));
                    System.out.println("tesssssssssssssst");
                    Parent root = loader.load();
              
                  
                    System.out.println("tesssssssssssssst");
                   // AfficherFrontTasks aftcontroller = (AfficherFrontTasks) loader.getController();
                   // aftcontroller.afficherDetailProject(id);
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                          System.out.println("tesssssssssssssst");
                    stage.setScene(scene);
                    stage.show();
                          System.out.println("tesssssssssssssst");
                } catch (IOException ex) {
                    Logger.getLogger(AfficherFront.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
            });
            
                //***************** FIN *********************************
            
            
            vbT.getChildren().add(postulerProject);
            vbT.setAlignment(Pos.CENTER);
        } else {
            Label task = new Label("Task");
            task.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
            Label titleT = new Label(j.getTitleT());
            titleT.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
            Label description = new Label(j.getDescriptionT());
            description.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));

            Button postulerTask = new Button("Postuler Task");
            postulerTask.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");
            //**************************************************************************************
            //        POSTULER POUR UNE TACHE
            // yosr *****************************************************************************
            //**********************************************************************************
            //************************************************************************************
            postulerTask.setOnAction(e -> {
                

                
                // recuperer id du task selectioné
                System.out.println("id of selected task: ");
                idTask=j.getIdT();
                System.out.println(idTask);
                
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fxml/Apply.fxml"));
                    Parent root = loader.load();
                   // AfficherFrontTasks aftcontroller = (AfficherFrontTasks) loader.getController();
                   // aftcontroller.afficherDetailProject(id);
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(AfficherFront.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            //***************** nada **********************************************************
            vbT.getChildren().add(task);
            vbT.getChildren().add(titleT);
            vbT.getChildren().add(description);
            vbT.getChildren().add(postulerTask);
            vbT.setAlignment(Pos.CENTER);
        }
        return vbT;
    }
    
    
    
      @FXML
    void redirect(ActionEvent event) throws IOException {
     Parent root= FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
     Stage primaryStage=new Stage();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    

}
