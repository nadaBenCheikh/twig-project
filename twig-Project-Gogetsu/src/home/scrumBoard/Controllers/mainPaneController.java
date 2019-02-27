package home.scrumBoard.Controllers;

import com.jfoenix.controls.JFXButton;
import home.scrumBoard.Entity.scrumBoard;
import home.scrumBoard.Entity.scrumNotes;
import home.scrumBoard.Service.scrumBoardService;
import home.scrumBoard.Service.scrumNotesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class mainPaneController implements linkControllers, Initializable {

    @FXML
    private JFXButton organizeButton;

    @FXML
    private JFXButton addNoteButton;

    @FXML
    private VBox pnItems1;

    @FXML
    private Pane pnlMenus;

    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private VBox pnItems11;

    @FXML
    private VBox pnItems111;

    private scrumBoard scrumBoard;

    private double x, y;
    public void addModal(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource()== addNoteButton)
        {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/addTaskBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            scrumAddController controller = fxmlLoader.<scrumAddController>getController();
            controller.setPreviousController(this);
            controller.setScrumboardId(scrumBoard.getId());

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
    public void setOnInit()
    {
        scrumBoardService scrumBoardService =new scrumBoardService();
        scrumBoard=scrumBoardService.getsingle(1);
        title.setText(scrumBoard.getTitle());
        description.setText(scrumBoard.getDescription());
        scrumNotesService scrumNotesService = new scrumNotesService();
        List<scrumNotes> mynotes =scrumNotesService.getAll(scrumBoard.getId());
        for (scrumNotes s:mynotes) {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/note.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scrumController controller = fxmlLoader.<scrumController>getController();
            controller.setScrumNote(s);
            System.out.println(s.getState());
            if (s.getState().equals("toDo"))
            pnItems1.getChildren().add(root1);
            if (s.getState().equals("doing"))
                pnItems11.getChildren().add(root1);
            if (s.getState().equals("done"))
                pnItems111.getChildren().add(root1);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOnInit();

    }
    @FXML
    void onDragOver(DragEvent event) {
        if (event.getDragboard().hasContent(scrumNotes.DATA_FORMAT))
        {
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }
    @FXML
    void onDragDropped(DragEvent event) throws IOException {
        scrumNotesService scrumNotesService = new scrumNotesService();
        scrumNotes Note = (scrumNotes) event.getDragboard().getContent(scrumNotes.DATA_FORMAT);
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/note.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        scrumController controller = fxmlLoader.<scrumController>getController();
        controller.setScrumNote(Note);
        if (event.getSource()==pnItems11) {
            Note.setState("doing");
            scrumNotesService.updatestate(Note);
            pnItems11.getChildren().add(root1);
        }
        if (event.getSource()==pnItems1){
            Note.setState("toDo");
            scrumNotesService.updatestate(Note);
            pnItems1.getChildren().add(root1);
        }
        if (event.getSource()==pnItems111){
            Note.setState("done");
            scrumNotesService.updatestate(Note);
            pnItems111.getChildren().add(root1);
        }
    }
    @FXML
    void organize(ActionEvent event) {
        pnItems1.getChildren().clear();
        pnItems11.getChildren().clear();
        pnItems111.getChildren().clear();
        setOnInit();
    }
}