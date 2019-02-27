package home.forum.Controllers;

import com.jfoenix.controls.JFXButton;
import home.forum.Service.PostsService;
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
import java.sql.Date;
import java.util.ResourceBundle;

public class mainPaneController implements Initializable,linkForumController {

    @FXML
    private JFXButton addPostButton;

    @FXML
    private Pane pnlCustomer11;

    @FXML
    private Pane pnlCustomer1;

    @FXML private TableView<PostsForum> tableView;
    @FXML private TableColumn<PostsForum, String> category;
    @FXML private TableColumn<PostsForum, String> subject;
    @FXML private TableColumn<PostsForum, String> description;
    @FXML private TableColumn<PostsForum, Date> postedOn;
    @FXML private TableColumn<PostsForum, Integer> id;
    @FXML
    void clickItem(MouseEvent event) {
        PostsService postsService = new PostsService();
        PostsForum postsForum;
        String FullName =postsService.getsingle(tableView.getSelectionModel().getSelectedItem().getId());
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/post.fxml"));
            pnlCustomer11.getChildren().add(fxmlLoader.load());
            forumController controller = fxmlLoader.<forumController>getController();
            controller.setLinkForumController(this);
            controller.setSubject("Subject: "+tableView.getSelectionModel().getSelectedItem().getSubject());
            controller.setDescription(tableView.getSelectionModel().getSelectedItem().getDescription());
            controller.setPostedOn("Posted on: "+tableView.getSelectionModel().getSelectedItem().getPostedOn().toString());
            controller.setAuthor(FullName);
            controller.setId(tableView.getSelectionModel().getSelectedItem().getId());
            controller.getComments();
            //all info jibhom mil DB w zid author fil table mta3 il info
        } catch (IOException e) {
            e.printStackTrace();
        }
        pnlCustomer11.toFront();

    }
    @Override
    public void setPosts()
    {
        category.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("category"));
        subject.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("subject"));
        postedOn.setCellValueFactory(new PropertyValueFactory<PostsForum, Date>("postedOn"));
        description.setCellValueFactory(new PropertyValueFactory<PostsForum, String>("description"));
        id.setCellValueFactory(new PropertyValueFactory<PostsForum, Integer>("id"));
        //load dummy data
        tableView.setItems(getPeople());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPosts();
    }
    public ObservableList<PostsForum> getPeople()
    {
        PostsService postsService = new PostsService();
        ObservableList<PostsForum> people = FXCollections.observableArrayList(postsService.getAll());
        for ( PostsForum p: people) {
            System.out.println(p);
        }
        return people;
    }
    @FXML
    void addModal(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../fxml/addpost.fxml"));
            pnlCustomer11.getChildren().add(fxmlLoader.load());
            forumAddController controller = fxmlLoader.<forumAddController>getController();
            controller.setLinkForumController(this);
            //all info jibhom mil DB w zid author fil table mta3 il info
        } catch (IOException e) {
            e.printStackTrace();
        }
        pnlCustomer11.toFront();

    }
    @Override
    public void goBack() {
        pnlCustomer1.toFront();
    }
}