package home.scrumBoard.Controllers;

import com.jfoenix.controls.JFXButton;
import home.scrumBoard.Entity.scrumNotes;
import home.scrumBoard.Service.scrumNotesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.util.Date;

public class scrumAddController {

    @FXML
    private JFXButton cancelButton;

    @FXML
    private TextField description;

    @FXML
    private JFXButton addButton;

    @FXML
    private TextField title;

    @FXML
    private HBox itemC2;

    @FXML
    private HBox itemC;

    @FXML
    private HBox itemC1;

    private linkControllers previousController;

    public void setPreviousController(linkControllers linkControllers){
        this.previousController = linkControllers;
    }

    @FXML
    void addTak(ActionEvent event) {

        try {
            scrumNotes scrumNote = new scrumNotes(title.getText(),description.getText(),new Date().toString(),5);
            scrumNotesService scrumNotesService = new scrumNotesService();
            scrumNote=scrumNotesService.insert(scrumNote);
            previousController.addscrumBox(scrumNote);
            Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
            TrayNotification tray = new TrayNotification();
            tray.setImage(whatsAppImg);
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setTitle("yo");
            tray.setMessage("aha");
            tray.showAndDismiss(Duration.seconds(2));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }
}
