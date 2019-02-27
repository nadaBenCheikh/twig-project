/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import home.Login1.service.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class ChangepasswordController implements Initializable {

     @FXML
    private PasswordField  CurrentPW;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button update;

    @FXML
    private Button btnreturn;

    @FXML
    private PasswordField  ReEnterPW;

    @FXML
    private PasswordField  NewPW;
    
    UserServices us = new UserServices();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void change(ActionEvent event) throws IOException {
        if(CurrentPW.getText().equals(loginController.userConnect.getPassword())){
            if(NewPW.getText().equals(ReEnterPW.getText())){
                us.updatepassword(NewPW.getText(), loginController.userConnect.getEmail());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil_1.fxml"));
                Parent HomeParent = fxmlLoader.load();
                Scene HomeScene = new Scene(HomeParent);
                Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Home.setScene(HomeScene);
                Home.show();
            }else{
                JOptionPane.showMessageDialog(null, "The passwords do not match.","erreur",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "your currect password was entered incorrectly ","erreur",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @FXML
    void Return(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil_1.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();
    } 
    
}
