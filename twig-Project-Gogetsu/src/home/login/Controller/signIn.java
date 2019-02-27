package home.login.Controller;

import com.jfoenix.controls.JFXButton;
import home.utils.entity.user;
import home.utils.service.userService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class signIn {
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    private double x, y;
    @FXML
    private JFXButton loginButton;
    @FXML
    void login(ActionEvent event1) throws IOException {
        System.out.println(email.getText());
        userService userService =new userService();
        user u = userService.getsingle(email.getText(),password.getText());
        if (u!=null)
        {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            //UserInstance userInstance = UserInstance.getInstance(email.getText(), password.getText());
            Parent root = FXMLLoader.load(getClass().getResource("../../Home.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless
            primaryStage.initStyle(StageStyle.UNDECORATED);

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
        }
        else {
            System.out.println("invalid user/password");
        }
    }

}

