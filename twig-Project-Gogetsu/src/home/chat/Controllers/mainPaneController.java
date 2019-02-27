package home.chat.Controllers;

import home.utils.entity.user;
import home.utils.service.userService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPaneController implements MsgListener, Initializable {

    @FXML
    private TextField textTosend;

    @FXML
    private VBox sendBox;

    @FXML
    private Button rightPane;

    @FXML
    private Button leftPane;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;

    @FXML
    private HBox itemC;

    @FXML
    private Button send;
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @FXML
    void sendButton(ActionEvent event) throws IOException {
        client.sendMsg(textTosend.getText(),id);

    }

    @Override
    public void publish(String test) throws IOException {
        FXMLLoader loader;
        userService userService = new userService();
        JSONObject received = new JSONObject(test);
        user u = userService.get(received.getInt("user_id"));
        if (received.getInt("user_id")== id) {
            loader = new FXMLLoader(getClass().getResource("../fxml/MyMsg.fxml"));
        }
        else {
            loader = new FXMLLoader(getClass().getResource("../fxml/HisMsg.fxml"));
        }
        Platform.runLater(new Runnable() {
            @Override public void run() {
                try {
                    Parent root = loader.load();
                    singleMsgController controller = loader.<singleMsgController>getController();
                    controller.setMessage(received.getString("text"));
                    System.out.println(u.getPicturePath());
                   controller.setMyimage(new Image(getClass().getResourceAsStream("../../image/"+u.getPicturePath())));
                    pnItems.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            client=Client.getInstance();
            client.setMsgListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}