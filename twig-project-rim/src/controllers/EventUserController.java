package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EventUserController {

    @FXML
    private TableColumn<?, ?> image;

    @FXML
    private TableColumn<?, ?> dateCreation;

    @FXML
    private TableColumn<?, ?> nmbreMax;

    @FXML
    private TableColumn<?, ?> adresse;

    @FXML
    private Button participer;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableView<?> tableview;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private TableColumn<?, ?> category;

    @FXML
    void participer(ActionEvent event) {

    }

}
