package controllers;

import entities.ProjectJoinTasks;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class AfficherFrontTasks implements Initializable{

    @FXML
    private VBox vbTasks;

    @FXML
    private Pane pnlOverview;
    
    @FXML
    private Button retour;
    
    @FXML
    void redirect(ActionEvent event) throws IOException {
        /* pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOfficeTasks.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront(); */
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOfficeTasks.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void afficherDetailProject(int idP){
        System.out.print(idP);
        TasksService pservice = new TasksService();  
        List<ProjectJoinTasks> list=pservice.displayAllProjectsAndTasksAllDonneur(idP);
        Label titleP= new Label("Project Title  "+list.get(0).getTitle());
         titleP.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label descriptionP= new Label("Project Description  "+list.get(0).getDescription());
         descriptionP.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
        Label categoryP= new Label("Category  "+list.get(0).getCategory());
         categoryP.setFont(Font.font("Amble CN", FontWeight.NORMAL, 12));
        Label locationP= new Label("Location  "+list.get(0).getLocation());
         locationP.setFont(Font.font("Amble CN", FontWeight.NORMAL, 12));
        Label terminationDate= new Label("Termination Date  "+list.get(0).getTerminationDate().toString());
         terminationDate.setFont(Font.font("Amble CN", FontWeight.NORMAL, 10));    
        vbTasks.getChildren().add(titleP);
        vbTasks.getChildren().add(descriptionP);
        vbTasks.getChildren().add(categoryP);
        vbTasks.getChildren().add(locationP);
        vbTasks.getChildren().add(terminationDate);
        vbTasks.setAlignment(Pos.CENTER);
        
        Iterator iterator = list.iterator();
        HBox hb;
        /*for(int i = 0; i < list.size(); i++) {
            hb= new HBox(5);
            hb.setSpacing(20); // espace horizontal entre deux images
            for (int j = 0; j < 3; j++) {
                if(iterator.hasNext())
                {
                    hb.getChildren().add(createVbTasks((ProjectJoinTasks) iterator.next()));    
                }
            }
            vbTasks.getChildren().add(hb);         
        }*/
        while(iterator.hasNext()){
           hb= new HBox(10); 
           hb.setAlignment(Pos.CENTER);
           hb.getChildren().add(createVbTasks((ProjectJoinTasks) iterator.next())); 
           vbTasks.getChildren().add(hb);  
        }

    }
    public VBox createVbTasks(ProjectJoinTasks j){
        VBox vbT = new VBox();
        if(j.getIdT()==0){
            System.out.println("tacheeeeeeeeee"); 
            Button postulerProject = new Button("Postuler Project");
            postulerProject.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");
            postulerProject.setOnAction(e->{
                //yosrrrr
            });
            vbT.getChildren().add(postulerProject);
            vbT.setAlignment(Pos.CENTER);
        }
        else{
            Label task=new Label("Task");
            task.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
            Label titleT=new Label(j.getTitleT());
            titleT.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
            Label description = new Label(j.getDescriptionT());
            description.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
      
            Button postulerTask = new Button("Postuler Task");
            postulerTask.setStyle("-fx-background-color: #FF4500; -fx-text-fill: #000000; -fx-font-size: 15;");
            postulerTask.setOnAction(e->{
              System.out.println(titleT);
              System.out.println(description);
              System.out.println(postulerTask);
            }); 
            vbT.getChildren().add(task);
            vbT.getChildren().add(titleT);
            vbT.getChildren().add(description);
            vbT.getChildren().add(postulerTask);
            vbT.setAlignment(Pos.CENTER);
        }
        return vbT;
    }
        

}