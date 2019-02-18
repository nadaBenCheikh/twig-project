/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import service.UserServices;

/**
 *
 * @author esprit
 */
public class loginController {
    
    @FXML
    private TextField password;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField email;
    @FXML
    private Label IsConnected;
      @FXML
    void login(ActionEvent event) {
  /*String pwd = password.getText();
  String mail = email.getText();
   UserServices US = new UserServices();//import users services
   US.login(u);*/
  
            
        
          System.out.println(email.getText());
          System.out.println(password.getText());

    }
}
