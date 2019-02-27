/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.event;
import entities.jointure2;
import entities.jointureTable;
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


public class popupTest {
    public static void displayTest(jointure2 t){
       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("Test");
        Label name=new Label();
         name.setText((t.getNom()));
        Label question=new Label();
        question.setText(t.getQuestion());
        TextField bonnRep = new TextField();
        bonnRep.setText(t.getBonneRep());
        
        
        
         VBox layout=new VBox(10);
       layout.getChildren().addAll(name,question,bonnRep);
       layout.setAlignment(Pos.CENTER);
       Scene scene1=new Scene(layout,500,600);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();
       
       
       
       
    
}
}
