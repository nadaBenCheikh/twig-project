package controllers;

import entite.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import service.UserServices;

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
    private TextField password;

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
    void sign(ActionEvent event) {
     UserServices us=new UserServices();
     String s="donneur d'ordre";
     us.insert(new users(firstName.getText(),lastName.getText(),email.getText(),password.getText(),s,Integer.parseInt(phone.getText()),region.getText(),description.getText(),picturePath.getText()));
     System.out.println("reussi");
    }

}

