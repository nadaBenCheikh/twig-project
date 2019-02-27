package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
//import java.util.Date;
//import java.util.Properties;
import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

/**
 *
 * @author esprit
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Fxml/mainPane_4.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* mail
        try {
                    String host = "smtp.gmail.com";
                    String userM = "ons.mtar@esprit.tn";
                    String pass = "183JFT1359";
                   // String to = users.getEmail();
                    String to = "malak.gouiaa@esprit.tn";
                    String from = userM;
                    String subject = " welcome ";//objet
                    String messageText = "cc malek";//contenu
                    boolean sessionDebug = false;

                    Properties props = System.getProperties();

                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(from));
                    InternetAddress[] address = {new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setSentDate(new Date());
                    msg.setText(messageText);

                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, userM, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("message send successfully");
                } catch (Exception ex) {
                    System.out.println(ex);
                }*/
        launch(args);
    }
    
}
