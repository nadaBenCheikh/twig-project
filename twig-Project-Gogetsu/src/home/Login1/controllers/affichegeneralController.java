package home.Login1.controllers;

import static home.Login1.controllers.loginController.userConnect;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import home.Login1.entite.users;
import home.Login1.service.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class affichegeneralController implements Initializable{

    @FXML
    private TextField picturePath;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField description;
    @FXML
    private Button uploadimg;
    @FXML
    private TextField region;
    @FXML
    private Button btnupdate;
    @FXML
    private TextField email;
    
    int idC;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {//pour affichage
        picturePath.setText(userConnect.getPicturePath());
        Image img = new Image("http://localhost/images/" + userConnect.getPicturePath());
        imageView.imageProperty().set(img);
        firstName.setText(userConnect.getFirstName());
        lastName.setText(userConnect.getLastName());
        phone.setText(String.valueOf(userConnect.getPhone()));
        region.setText(userConnect.getRegion());
        description.setText(userConnect.getDescription());
        email.setText(userConnect.getEmail());
    }
    
    
    @FXML
    void Update(ActionEvent event) throws IOException {
         UserServices uservice2=new UserServices();
         uservice2.update(new users(userConnect.getId(),firstName.getText(),lastName.getText(),email.getText()
                 ,userConnect.getPassword(),"donneur d'ordre",Integer.parseInt(phone.getText()),region.getText()
                 ,description.getText(),picturePath.getText()));
         System.out.println("user est modifier");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Fxml/afficherprofil.fxml"));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();
    }

    @FXML
    void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(null);
        System.out.println("file "+ file);
        picturePath.setText(file.getName());
        Image img = new Image("http://localhost/images/" + file.getName());
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
