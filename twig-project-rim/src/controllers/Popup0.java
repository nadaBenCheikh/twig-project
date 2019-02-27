/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.eventService;


/**
 *
 * @author rim
 */
public class Popup0 {
   
   public static void display(event t){
       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("update a training");
     //  Label label1=new Label("popup window now displayed");
       //Label label2= new Label();
       //label2.setText(t.getTitre());
     
       
       
       Label label1=new Label("title");
       TextField titre = new TextField();
       titre.setText(t.getTitre());
       Label label2=new Label("Adresse");
       TextField f1=new TextField();
       f1.setText(t.getAdresse());
       Label label3= new Label("Category");
         TextField f2=new TextField();
       f1.setText(t.getCategory());
       Label label4= new Label("Maximum Number");
         TextField f3=new TextField();
        int x=t.getNmbreMax();
        String s=new String();
        s=s.valueOf(x);
        f3.setText(s);
        Label label5= new Label("description");
                
        TextArea desc= new TextArea();
        desc.setText(t.getDescription());
        Label label6 = new Label("image");
        TextField f5 = new TextField();
        f5.setText(t.getImage());
      
       
       
       TextArea txt1=new TextArea();
       txt1.setText(t.getDescription());
       
       
  
       
       
       Button button1=new Button("close");
        Button button2=new Button("update");
       button1.setOnAction(e->popupwindow.close());
       
       button2.setOnAction(e->
       {
           eventService ev = new eventService();
           
           int x1=Integer.parseInt(f3.getText());
           System.out.println(x1);
           ev.update(new event(t.getId(),titre.getText(),desc.getText(),f1.getText(),x1,f2.getText(),f5.getText()));
           System.out.println("c bonnnnnn"); 
       });
       
       VBox layout=new VBox(10);
       layout.getChildren().addAll(label1,titre,label2,f1,label3,f2,label4,f3,label5,desc,label6,f5,button1,button2);
       layout.setAlignment(Pos.CENTER);
       Scene scene1=new Scene(layout,500,600);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();
               
   }
  
}
    

