package home.chat.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class singleMsgController {

    @FXML
    private Label message;

    @FXML
    private int id;
    private HBox itemC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public singleMsgController() {
        Random rand = new Random();
        id = rand.nextInt(50);
    }

    public void setMessage(String msg){
        message.setText(msg);
    }

}
