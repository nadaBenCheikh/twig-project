package home.scrumBoard.Controllers;
import com.jfoenix.controls.JFXButton;
import home.scrumBoard.Entity.scrumNotes;
import home.scrumBoard.Service.scrumNotesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Date;


public class scrumController  {
    @FXML
    private Button noteButton;

    @FXML
    private TextField title;
    private scrumNotes scrumNote;

    public scrumNotes getScrumNote() {
        return scrumNote;
    }

    public void setScrumNote(scrumNotes scrumNote) {
        this.scrumNote = scrumNote;
    }

    private double x, y;
    @FXML
    void editAction(ActionEvent event) throws IOException {
        if (event.getSource()== noteButton) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/editTaskBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
        scrumEditController controller = fxmlLoader.<scrumEditController>getController();
            controller.setScrumNote(scrumNote);
            controller.setScene();
        controller.setCurrentPane(((AnchorPane)noteButton.getParent()));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        root1.setOnMousePressed(e -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });
        root1.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - x);
            stage.setY(e.getScreenY() - y);
        });
        stage.showAndWait();
        }
    }


    @FXML
    void dragDetected(MouseEvent event) {
        Dragboard db = noteButton.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent cb = new ClipboardContent();
        cb.put(scrumNotes.DATA_FORMAT,scrumNote);
        db.setContent(cb);

        event.consume();
        AnchorPane pane =((AnchorPane)noteButton.getParent());
        pane.getChildren().clear();

    }

}
