package home;

import home.chat.Controllers.Client;
import home.chat.Controllers.mainPaneController;
import home.forum.Controllers.linkForumController;
import home.forum.entity.PostsForum;
import home.scrumBoard.Controllers.linkControllers;
import home.scrumBoard.Controllers.scrumAddController;
import home.scrumBoard.Controllers.scrumController;
import home.scrumBoard.Entity.scrumNotes;
import home.utils.UserInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
        try {
            Client myClient = Client.getInstance() ;
            id =UserInstance.getUser1().getId();
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
        myName.setText(UserInstance.getUser1().getFirstName()+" "+UserInstance.getUser1().getLastName());
        myImage.setImage(new Image(getClass().getResourceAsStream(UserInstance.getUser1().getPicturePath())));
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
