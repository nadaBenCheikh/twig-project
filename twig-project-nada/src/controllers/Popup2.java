/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.OfferJoinCollab;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author esprit
 */
public class Popup2 {
    public static void displayOffer(OfferJoinCollab p){
       Integer bid=p.getBidO();
       String ch=bid.toString();
       Integer maxH=p.getMaxHourlyFeeF();
       String ch1=maxH.toString();
       Integer minH=p.getMinHourlyFeeF();
       String ch2=minH.toString();
       Integer duration=p.getDurationO();
       String ch3=duration.toString();

       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("Application");
        ImageView image=new ImageView(new Image(p.getPicturePath()));
        Label label1=new Label(p.getLastName()+" "+p.getFirstName());
        Label label2=new Label(p.getEmail());
        Label label3=new Label("Languages : "+p.getLanguagesF());
        Label label4= new Label("Curriculum Vitae : ");
        Label label5=new Label(p.getCvLinkF());
        Label label6= new Label("Letter of Motivation : ");
        Label label7=new Label(p.getMotivationalLetterO());
        Label label8=new Label("Bid : "+ch);
        Label label9=new Label("Max Hourly Fee : "+ch1);
        Label label10=new Label("Min Hourly Fee : "+ch2);
        Label label11=new Label("Duration : "+ch3);
        Label label12=new Label("Date Offer : "+p.getOfferDateO().toString());
        Label label13=new Label("Project : "+p.getTitleP());
        //if(p.getTaskId()!=0){
            //Label label27=new Label("Task");
            Label label14=new Label("Task : "+p.getTitleT());
        //}
       VBox layout=new VBox(10);
       
       BackgroundFill bf=new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY);
       Background background=new Background(bf);
       layout.setBackground(background);
       label1.setFont(Font.font("Britanic Bold", FontWeight.BOLD, 20));
       label1.setTextFill(Paint.valueOf("#004058"));
       label2.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label2.setTextFill(Paint.valueOf("#66ACAE"));
       label3.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label3.setTextFill(Paint.valueOf("#66ACAE"));
       label4.setFont(Font.font("System", FontWeight.BOLD, 15));
       label4.setTextFill(Paint.valueOf("#66ACAE"));
       label5.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label5.setTextFill(Paint.valueOf("#66ACAE"));
       label6.setFont(Font.font("System", FontWeight.BOLD, 15));
       label6.setTextFill(Paint.valueOf("#66ACAE"));
       label7.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label7.setTextFill(Paint.valueOf("#66ACAE"));
       label8.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label8.setTextFill(Paint.valueOf("#66ACAE"));
       label9.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label9.setTextFill(Paint.valueOf("#66ACAE"));
       label10.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label10.setTextFill(Paint.valueOf("#66ACAE"));
       label11.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label11.setTextFill(Paint.valueOf("#66ACAE"));
       label12.setFont(Font.font("System", FontWeight.NORMAL, 15));
       label12.setTextFill(Paint.valueOf("#66ACAE"));
       label13.setFont(Font.font("System", FontWeight.BOLD, 17));
       label13.setTextFill(Paint.valueOf("#66ACAE"));
       label14.setFont(Font.font("System", FontWeight.BOLD, 17));
       label14.setTextFill(Paint.valueOf("#66ACAE"));
       image.setFitHeight(130);
       image.setFitWidth(170);
       
       layout.getChildren().addAll(image,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14);
       layout.setAlignment(Pos.CENTER);
       Scene scene1=new Scene(layout,400,800);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();       
   }  
        
}
