/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.users;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.JOptionPane;
import service.UserServices;

/**
 *
 * @author rim
 */
public class loginController {
   
    
    @FXML
    private PasswordField password;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField email;
    
    static users userConnect;
    
    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
    
        String pswd;
        String mail;
        mail = email.getText();
        pswd = password.getText();
        Connection connect= projet.Projet.getInstance().getCnx();
        Statement statement = connect.createStatement();
        ResultSet rsl =statement.executeQuery("select * from users where email = '" + mail + "' and password = '" + pswd + "'");
        UserServices us = new UserServices();
        userConnect = us.getByEmail(mail);
        System.out.println("User is ===> " + userConnect.getFirstName());
        if (rsl.next()){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil.fxml"));
            Parent HomeParent = fxmlLoader.load();
            Scene HomeScene = new Scene(HomeParent);
            Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Home.setScene(HomeScene);
            Home.show();
        }
        else{
            users u= us.getByEmail(mail);
            System.out.println(u);
            if(u.getId()==0){
                JOptionPane.showMessageDialog(null, "Wrong mail address,retry!", mail, JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong password,retry", mail, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

    

