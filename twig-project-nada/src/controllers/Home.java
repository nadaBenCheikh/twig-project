package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Home {
        
    @FXML
    private Button btnListProject;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Button btnColabs;

    @FXML
    private Button btnOffers;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnAddTask;

    @FXML
    private Button btnOverview;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Button btnAddProject;

    @FXML
    void afficherAllProjectsFront(ActionEvent event) throws IOException {
       /*Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
        
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherFrontOffice.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    void afficherListProject(ActionEvent event) throws IOException {
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/afficherAllProjects_back_1_1_1_1.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    void afficherOffer(ActionEvent event) throws IOException {
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/offers_1_1.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    void afficherColabs(ActionEvent event) throws IOException {
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/colabs_1_1.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    void addProject(ActionEvent event) throws IOException {
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/mainPane_2_1_1.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

    @FXML
    void addTask(ActionEvent event) throws IOException {
        pnlOrders.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../Fxml/ajouterTache_1_1_1.fxml"));
        pnlOrders.getChildren().add(parent);
        pnlOrders.toFront();
    }

}
