package home.forum.Controllers;

import home.forum.entity.PostsForum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class mainPaneController implements Initializable,linkForumController {


    @FXML
    private Pane pnlCustomer11;

    @FXML
    private Pane pnlCustomer1;

    @FXML private TableView<PostsForum> tableView;
    @FXML private TableColumn<PostsForum, String> category;
    @FXML private TableColumn<PostsForum, String> subject;
    @FXML private TableColumn<PostsForum, String> description;
    @FXML private TableColumn<PostsForum, LocalDate> postedOn;

    @FXML
    void clickItem(MouseEvent event) {
        System.out.println(tableView.getSelectionModel().getSelectedItem().getSubject());
        System.out.println(tableView.getSelectionModel().getSelectedItem().getDescription());
        System.out.println(tableView.getSelectionModel().getSelectedItem().getCategory());
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/post.fxml"));
            pnlCustomer11.getChildren().add(fxmlLoader.load());
            forumController controller = fxmlLoader.<forumController>getController();
            controller.setLinkForumController(this);
            controller.setSubject("Subject: "+tableView.getSelectionModel().getSelectedItem().getSubject());
            controller.setDescription(tableView.getSelectionModel().getSelectedItem().getDescription());
            controller.setPostedOn("Posted on: "+tableView.getSelectionModel().getSelectedItem().getPostedOn().toString());
            //all info jibhom mil DB w zid author fil table mta3 il info
        } catch (IOException e) {
            e.printStackTrace();
        }
        pnlCustomer11.toFront();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("yoooo");
        category.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("category"));
        subject.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("subject"));
        postedOn.setCellValueFactory(new PropertyValueFactory<PostsForum, LocalDate>("postedOn"));
        description.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("description"));
        //load dummy data
        tableView.setItems(getPeople());
    }
    public ObservableList<PostsForum> getPeople()
    {
        ObservableList<PostsForum> people = FXCollections.observableArrayList();
        people.add(new PostsForum("Frank","Sinatra","oy",LocalDate.of(1915, Month.DECEMBER, 12) ));
        people.add(new PostsForum("Rebecca","Fergusson","oy",LocalDate.of(1986, Month.JULY, 21)));
        people.add(new PostsForum("Mr.","T","oy",LocalDate.of(1952, Month.MAY, 21)));
        return people;
    }
    @Override
    public void goBack() {
        pnlCustomer1.toFront();
    }
}