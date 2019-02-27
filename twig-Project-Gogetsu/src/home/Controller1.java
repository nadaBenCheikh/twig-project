package home;

import home.chat.Controllers.Client;
import home.chat.Controllers.mainPaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static home.Login1.controllers.loginController.userConnect;

public class Controller1 implements Initializable {
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
    private AnchorPane main;

    @FXML
    private ImageView myImage;
    private int id ;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        main.getChildren().clear();
        main.getChildren().add(root1);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Client myClient = Client.getInstance() ;
            id =userConnect.getId();
            myClient.sendMsg("first communication", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("chat/fxml/mainPane.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            pnlOverview.getChildren().add(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainPaneController controller = fxmlLoader.<mainPaneController>getController();
        controller.setId(id);
        myName.setText(userConnect.getFirstName()+" "+userConnect.getLastName());
        myImage.imageProperty().set(new Image("http://localhost/images/" + userConnect.getPicturePath()));
        //myImage.setImage(new Image(getClass().getResourceAsStream("/image/04.jpg")));
        pnlOverview.toFront();

    }


    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #000000");
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("forum/fxml/mainPane.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            pnlCustomer.getChildren().add(root1);
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #000000");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #000000");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #000000");
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("scrumBoard/fxml/mainPane.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            pnlOrders.getChildren().add(root1);
            pnlOrders.toFront();
        }
    }

}
