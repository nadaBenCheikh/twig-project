package home.scrumBoard.Controllers;

import com.jfoenix.controls.JFXButton;
import home.scrumBoard.Entity.scrumNotes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class mainPaneController implements linkControllers {

    @FXML
    private JFXButton addNoteButton;

    @FXML
    private VBox pnItems1;

    @FXML
    private Pane pnlMenus;

    private double x, y;
    public void addModal(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource()== addNoteButton)
        {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/addTaskBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            scrumAddController controller = fxmlLoader.<scrumAddController>getController();
            controller.setPreviousController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {

                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

            });
            stage.showAndWait();

        }
    }

    @Override
    public void addscrumBox(scrumNotes scrumNote) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/note.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        scrumController controller = fxmlLoader.<scrumController>getController();
        controller.setScrumNote(scrumNote);
        pnItems1.getChildren().add(root1);
    }
}