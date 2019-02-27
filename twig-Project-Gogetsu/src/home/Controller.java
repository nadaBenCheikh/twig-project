package home;

import home.chat.Controllers.Client;
import home.chat.Controllers.mainPaneController;
import static home.Login1.controllers.loginController.userConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane main;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;
    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Label myName;

    @FXML
    private ImageView myImage;
    private int id ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        myName.setText(userConnect.getFirstName()+" "+userConnect.getLastName());
        myImage.imageProperty().set(new Image("http://localhost/images/" + userConnect.getPicturePath()));
        //myImage.setImage(new Image(getClass().getResourceAsStream("/image/04.jpg")));
        pnlCustomer.toFront();

    }


    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnCustomers) {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Home1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            main.getChildren().clear();
            main.getChildren().add(root1);
        }
        if (actionEvent.getSource() == btnMenus) {

        }
        if (actionEvent.getSource() == btnOverview) {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Login1/Fxml/afficherprofil_1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            main.getChildren().clear();
            main.getChildren().add(root1);
        }
        if(actionEvent.getSource()==btnOrders)
        {

        }
    }

}
