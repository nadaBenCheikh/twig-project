/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entities.jointureTable;
import entities.test;
import entities.questions;
import java.sql.Time;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import service.questionServ;
import service.testServ;

/**
 *
 * @author rim
 */
public class popup1 {
     public static void display(jointureTable t){
       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("update a test");
     //  Label label1=new Label("popup window now displayed");
       //Label label2= new Label();
       //label2.setText(t.getTitre());
     
       
       Label labelTest=new Label("test");
       Label lb=new Label("nom test");
       TextField nom = new TextField();
       nom.setText(t.getNom());
       Label label4= new Label("type");
         TextField f2=new TextField();
       f2.setText(t.getType());
       Label label5= new Label("score");
       TextField score = new TextField();
          int scr=t.getScore();
        String s=new String();
        s=s.valueOf(scr);
        score.setText(s);
        Label label6= new Label("duree");
        TextField duree = new TextField();
          Time tim=t.getDuree();
        String str=new String();
        str=str.valueOf(tim);
        duree.setText(str);
        
        Label LabelQuestion= new Label("update Question");
        
        Label label1=new Label("test ID");
        int tesss=t.getTestID();
        String l=new String();
        l=l.valueOf(tesss);
        TextField f1 = new TextField();
        f1.setText(l);
        Label label2=new Label("question");
       TextField question = new TextField();
       question.setText(t.getQuestion());
        Label label3= new Label("right answer");
       TextField bonneRep=new TextField();
       bonneRep.setText(t.getBonneRep());
                
   
  
       
       
       Button button1=new Button("close");
        Button button2=new Button("update test");
         Button button3=new Button("update question");
        
       button1.setOnAction(e->popupwindow.close());
       
       button2.setOnAction(e->
       {
           
         
           
        
            Time ti=Time.valueOf("01:20:00");
             int xx=Integer.parseInt(score.getText());
          
           System.out.println(t.getTestID());
           testServ tsv = new testServ();
           tsv.update(new test(t.getTestID(),xx,ti,f2.getText()));
           System.out.println("c bonnnnnn"); 
            JOptionPane.showMessageDialog(null, "test is changed successfully", null, JOptionPane.DEFAULT_OPTION);
       });
         button3.setOnAction(e->
       {
           int id=Integer.parseInt(f1.getText());
           questionServ ev = new questionServ();
           
            ev.update(new questions(t.getId(),id,question.getText(),bonneRep.getText()));
             System.out.println("c bonnnnnn"); 
            JOptionPane.showMessageDialog(null, "question is changed successfully", null, JOptionPane.DEFAULT_OPTION);
           
       });
         
       
       VBox layout=new VBox(10);
       layout.getChildren().addAll(lb,nom,labelTest,label4,f2,label5,score,label6,duree,LabelQuestion,label1,f1,label2,question,label3,bonneRep,button1,button2,button3);
       layout.setAlignment(Pos.CENTER);
       Scene scene1=new Scene(layout,500,600);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();
               
   
  
    
}
}
