package home.Login1.controllers;

import java.io.File;
import java.io.IOException;

import home.Login1.entite.users;
import home.Login1.service.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class donnerController {

    @FXML
    private TextField picturePath;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField description;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button Sign;

    @FXML
    private TextField region;

    @FXML
    private TextField email;
    
    @FXML
    private Button btnapload;
    
    @FXML
    private Button btnreturn;

    @FXML
    void sign(ActionEvent event) throws IOException {
          
        
            if ("".equals(firstName.getText())) {
             JOptionPane.showMessageDialog(null, "Enter your fisrtname please!","erreur",JOptionPane.ERROR_MESSAGE);
             } 
            else if ("".equals(lastName.getText())) {
             JOptionPane.showMessageDialog(null, "Enter your lastname please!","erreur",JOptionPane.ERROR_MESSAGE);
            }

            else if ("".equals(email.getText())) {
            JOptionPane.showMessageDialog(null, "Enter your Email please!","erreur",JOptionPane.ERROR_MESSAGE);  
           }
           /*String chaine = email.getText();
           if (chaine.length() != 0) {
            if (chaine.charAt(chaine.length() - 1) == '.') {
                 JOptionPane.showMessageDialog(null, "Enter your Email please!","erreur",JOptionPane.ERROR_MESSAGE);  
            } else {

                int firstIndexA = chaine.indexOf("@");
                int lastIndexA = chaine.lastIndexOf("@");
                int lastIndexPt = chaine.lastIndexOf(".");
                if (firstIndexA < 3 || firstIndexA != lastIndexA || firstIndexA > lastIndexPt || lastIndexPt - firstIndexA < 4 || chaine.substring(lastIndexPt + 1, chaine.length() - 1).length() > 3 || chaine.substring(lastIndexPt + 1, chaine.length()).length() < 2) {
                  JOptionPane.showMessageDialog(null, "Enter your Email please!","erreur",JOptionPane.ERROR_MESSAGE);  
                
            
        }
        }
           }*/
           
            else if ("".equals(description.getText())) {
            JOptionPane.showMessageDialog(null, "Enter your description please!","erreur",JOptionPane.ERROR_MESSAGE);    
            }

            else if ("".equals(password.getText())) {
            JOptionPane.showMessageDialog(null, "Enter your password  please!","erreur",JOptionPane.ERROR_MESSAGE);    
            }
        else if (phone.getText().matches(".*[a-zA-Z].*")) {
         JOptionPane.showMessageDialog(null, "Enter a number  please!","erreur",JOptionPane.ERROR_MESSAGE);
        
        }
        else if (phone.getText().length() != 8)
        {
           JOptionPane.showMessageDialog(null, "Enter a number  please!","erreur",JOptionPane.ERROR_MESSAGE);
        }

            else if ("".equals(region.getText())) {
              JOptionPane.showMessageDialog(null, "Enter your region  please!","erreur",JOptionPane.ERROR_MESSAGE);   
            }

             else if ("".equals(picturePath.getText())) {
             JOptionPane.showMessageDialog(null, "Enter a picture  please!","erreur",JOptionPane.ERROR_MESSAGE);
             }
          else{
         
       UserServices us=new UserServices();
       String s="donneur d'ordre";
       us.insert(new users(firstName.getText(),lastName.getText(),email.getText(),password.getText(),s,Integer.parseInt(phone.getText()),region.getText(),description.getText(),picturePath.getText()));
       System.out.println("reussi");
       JOptionPane.showMessageDialog(null, "successful sign up", s, JOptionPane.DEFAULT_OPTION);
          Stage primaryStage=new Stage();
          Parent root= FXMLLoader.load(getClass().getResource("../Fxml/mainPane_4.fxml"));
          Scene scene = new Scene(root);
          primaryStage.setTitle("Hello World!");
          primaryStage.setScene(scene);
          primaryStage.show();
    }
    }
    
        @FXML
    void apload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        System.out.println("file "+ file);
        picturePath.setText(file.getName());
        Image img = new Image("http://localhost/images/" + file.getName());}
    
    
        @FXML
        void Return(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/inscrit.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();

      }

    


}

