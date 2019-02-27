package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OnsBonsTest {

    @FXML
    private Button authentifier;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink addaccount;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Pane pnlOverviewSignIn;

    @FXML
    private Color x4;

    @FXML
    private Button singinbtn;

    @FXML
    private Hyperlink ForgetPW;

    @FXML
    private TextField email;

    @FXML
    void redirectionPane(ActionEvent event) throws IOException {
      /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pnlOverviewSignIn.));
        Parent HomeParent = fxmlLoader.load();
        Scene HomeScene = new Scene(HomeParent);
        Stage Home = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Home.setScene(HomeScene);
        Home.show();  */
    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void db3907(ActionEvent event) {

    }

    @FXML
    void fogetPW(ActionEvent event) {

    }

    @FXML
    void AddAccount(ActionEvent event) {

    }

}
