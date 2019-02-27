/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import home.Login1.entite.users;
import home.Login1.project.database;
import home.Login1.service.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author esprit
 */
public class loginController {
    private double x, y;
    @FXML
    private PasswordField password;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField email;
    
    public static users userConnect;
    
    @FXML
    void login(ActionEvent event1) throws SQLException, IOException {
        Stage stage = (Stage) email.getScene().getWindow();
        String pswd;
        String mail;
        mail = email.getText();
        pswd = password.getText();
        Connection connect= database.getInstance().getCnx();
        Statement statement = connect.createStatement();
        ResultSet rsl =statement.executeQuery("select * from users where email = '" + mail + "' and password = '" + pswd + "'");
        UserServices us = new UserServices();
        userConnect = us.getByEmail(mail);
        if(userConnect.getState()== 0){
            JOptionPane.showMessageDialog(null, "Your account is desactivated ", "account desactivated", JOptionPane.ERROR_MESSAGE);
        }else{
            if (rsl.next()){
                /*XMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil_1.fxml"));
                Parent HomeParent = fxmlLoader.load();
                Scene HomeScene = new Scene(HomeParent);
                Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Home.setScene(HomeScene);
                Home.show();*/
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../../Home.fxml"));
                primaryStage.setScene(new Scene(root));
                //set stage borderless
                primaryStage.initStyle(StageStyle.UNDECORATED);
                stage.close();
                //drag it here
                root.setOnMousePressed(event -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });
                root.setOnMouseDragged(event -> {

                    primaryStage.setX(event.getScreenX() - x);
                    primaryStage.setY(event.getScreenY() - y);

                });
                primaryStage.show();
            }else{
                users u= us.getByEmail(mail);
                if(u.getId()==0){
                    JOptionPane.showMessageDialog(null, "Wrong mail address,retry!", mail, JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong password,retry", mail, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    static String getAlphaNumericString(int n) 
    { 
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
    
    @FXML
    void fogetPW(ActionEvent event) {
        String newPassword = getAlphaNumericString(8);
        System.out.println("the new password is " + newPassword);
        UserServices us = new UserServices();
        us.updatepassword(newPassword, email.getText());
        try {
                    String host = "smtp.gmail.com";
                    String userM = "ons.mtar@esprit.tn";
                    String pass = "183JFT1359";
                    String to = email.getText();
                    String from = userM;
                    String subject = "New password";//objet
                    String messageText = "your new password is: "+ newPassword + ". \n Please make sure that you update your password. "  ;//contenu
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
                }
    }
    
    @FXML
    void AddAccount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/mainPane_1.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();
    }
}
