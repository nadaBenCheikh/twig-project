package home.scrumBoard.Controllers;

import com.jfoenix.controls.JFXButton;
import home.scrumBoard.Entity.scrumNotes;
import home.scrumBoard.Service.scrumNotesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.util.Date;

public class scrumEditController
{
    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton editButton;

    @FXML
    private TextField description;

    @FXML
    private TextField title;

    @FXML
    private HBox itemC2;

    @FXML
    private HBox itemC;

    @FXML
    private HBox itemC1;
    private AnchorPane currentPane=null;
    private scrumNotes scrumNote;
    private scrumNotesService scrumNotesService = new scrumNotesService();
    public scrumNotes getScrumNote() {
        return scrumNote;
    }

    public void setScrumNote(scrumNotes scrumNote) {
        this.scrumNote = scrumNote;
    }

    public AnchorPane getCurrentPane() {
        return currentPane;
    }
    public void setCurrentPane(AnchorPane anchorPane){
        currentPane = anchorPane;
    }

    @FXML
    void editTak(ActionEvent event) {
        scrumNote.setTitle(title.getText());
        scrumNote.setDescription(description.getText());
        scrumNote.setPostedOn(new Date().toString());
        if (scrumNotesService.update(scrumNote))
        {
            Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
            TrayNotification tray = new TrayNotification();
            tray.setImage(whatsAppImg);
            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
            tray.setTitle("sucess");
            tray.setMessage("modification avec succes");
            tray.showAndDismiss(Duration.seconds(2));
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteTak(ActionEvent event) {
        currentPane.getChildren().removeAll();
        currentPane.getChildren().clear();
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        scrumNotesService.delete(scrumNote);
        stage.close();
        Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
        TrayNotification tray = new TrayNotification();
        tray.setImage(whatsAppImg);
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        tray.setTitle("sucess");
        tray.setMessage("Effacement avec succes");
        tray.showAndDismiss(Duration.seconds(2));

    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setScene() {
        description.setText(scrumNote.getDescription());
        title.setText(scrumNote.getTitle());
    }
}
