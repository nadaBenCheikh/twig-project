/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.ProjectJoinTasks;
import entities.Projects;
import entities.Tasks;
import java.sql.Date;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ProjectsService;
import services.TasksService;

/**
 *
 * @author esprit
 */
public class Popup1 {
    public static void display(ProjectJoinTasks p){
       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("Update project_task");
       Label label01=new Label("Project");
        Label label1= new Label("Project title");
        TextField t1=new TextField(p.getTitle());
        Label label2= new Label("Project description");
        TextArea t2=new TextArea(p.getDescription());
        Label label3= new Label("Project location");
        TextField t3=new TextField(p.getLocation());
        Label label4= new Label("Project category");
        TextField t4=new TextField(p.getCategory());
        Label label5= new Label("Project termination date");
        Date d=p.getTerminationDate();
        LocalDate d1=d.toLocalDate();
        DatePicker picker=new DatePicker(d1);
       Label label02 =new Label("Task");
        Label label6= new Label("Task title");
        TextField t6=new TextField(p.getTitleT());
        Label label7= new Label("Task description");
        TextArea t7=new TextArea(p.getDescriptionT());     
       Button updateProject=new Button("Update Project");
       Button updateTask=new Button("Update Task");
        
       updateProject.setOnAction(e->{
           Date d2=Date.valueOf(picker.getValue());
           //System.out.println(d2);
           ProjectsService pservice=new ProjectsService();          
           pservice.update(new Projects(p.getId(),t1.getText(),t2.getText(),t3.getText(),t4.getText(),d2));
           System.out.println("c bonnnn"); 
           JOptionPane.showMessageDialog(null, "Project is changed successfully", null, JOptionPane.DEFAULT_OPTION);
       });
       
        updateTask.setOnAction(e->{
          if(p.getIdT()!=0){
            TasksService tservice=new TasksService();
            tservice.update(new Tasks(t6.getText(),t7.getText(),p.getIdT()));
            System.out.println("c biennn");
            JOptionPane.showMessageDialog(null, "Task is changed successfully", null, JOptionPane.DEFAULT_OPTION);
            popupwindow.close();
          }
          else{
            updateTask.disableProperty();
            JOptionPane.showMessageDialog(null, "impossible to modify non-existent spot", null, JOptionPane.ERROR_MESSAGE);
            popupwindow.close();
          }
        });
     
       VBox layout=new VBox(10);
       
       updateProject.setStyle("-fx-background-color:#66ACAE; -fx-background-radius:10,10,10,10;-fx-pref-width: 360px;");
       updateTask.setStyle("-fx-background-color:#66ACAE; -fx-background-radius:10,10,10,10;-fx-pref-width: 360px;");
       BackgroundFill bf=new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY);
       Background background=new Background(bf);
       layout.setBackground(background);
       label01.setFont(Font.font("Britanic Bold", FontWeight.BOLD, 20));
       label01.setTextFill(Paint.valueOf("#004058"));
       label02.setFont(Font.font("Britanic Bold", FontWeight.BOLD, 20));
       label02.setTextFill(Paint.valueOf("#004058"));
       label1.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label1.setTextFill(Paint.valueOf("#66ACAE"));
       label2.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label2.setTextFill(Paint.valueOf("#66ACAE"));
       label3.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label3.setTextFill(Paint.valueOf("#66ACAE"));
       label4.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label4.setTextFill(Paint.valueOf("#66ACAE"));
       label5.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label5.setTextFill(Paint.valueOf("#66ACAE"));
       label6.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label6.setTextFill(Paint.valueOf("#66ACAE"));
       label7.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label7.setTextFill(Paint.valueOf("#66ACAE"));
       //t1.setStyle("-fx-background-color: #fff; -fx-border-color: #fff; -fx-border-width: 0; -fx-border-image-width: 0; -fx-background-image: null; -fx-region-background: null;-fx-border-insets: 0; -fx-background-size:0; -fx-border-image-insets:0;");
       //t1.setStyle("-fx-opacity: 0.2;");
       t2.setStyle("-fx-background-color: #fff; -fx-border-color: #fff;-fx-border-style: none;");
       // t3.setStyle("-fx-opacity: 0.2;");
       //t4.setStyle("-fx-opacity: 0.2;");
       //t6.setStyle("-fx-opacity: 0.2;");
       t7.setStyle("-fx-background-color: #fff; -fx-border-color: #fff;-fx-border-style: none;");
       t7.setPrefHeight(300);  
       t7.setPrefWidth(100);
       t2.setPrefHeight(300);  
       t2.setPrefWidth(100);
       
       layout.getChildren().addAll(label01,label1,t1,label2,t2,label3,t3,label4,t4,label5,picker,updateProject,label02,label6,t6,label7,t7,updateTask);
       layout.setAlignment(Pos.CENTER_LEFT);
       Scene scene1=new Scene(layout,360,630);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();
               
   }  
}
